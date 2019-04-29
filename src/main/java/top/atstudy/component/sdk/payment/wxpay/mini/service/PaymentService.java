package top.atstudy.component.sdk.payment.wxpay.mini.service;

import org.apache.commons.beanutils.BeanUtils;
import top.atstudy.component.sdk.payment.wxpay.mini.config.PayConfig;
import top.atstudy.component.sdk.payment.wxpay.mini.vo.*;
import top.atstudy.component.util.RandomUtil;
import top.atstudy.component.util.WxPaymentUtil;
import top.atstudy.component.util.XmlUtil;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class PaymentService extends BasicPaymentService {

    public static PaymentService getInstance(PayConfig payConfig) {
        if (instance == null) {
            synchronized(PaymentService.class) {
                if (instance == null) {
                    instance = new PaymentService();
                    instance.setPayConfig(payConfig);
                }
            }
        }

        return instance;
    }

    /**
     * 小程序：统一下单
     * @param req
     * @return
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    public UnifiedOrderResp unifiedorder(UnifiedOrderReq req) throws IllegalAccessException, InvocationTargetException {
        BeanUtils.copyProperties(req, this.getPayConfig());
        req.setNonce_str(RandomUtil.randomString(32));
        String sign = this.getUnifiedorderSign(req);
        req.setSign(sign);
        String params = XmlUtil.convertToXml(req);
        String result = WxPaymentUtil.post("https://api.mch.weixin.qq.com/pay/unifiedorder", params);
        this.logger.info(" ==>> unifiedorder result: {}", result);
        UnifiedOrderResp resp = (UnifiedOrderResp)XmlUtil.convertXmlStrToObject(UnifiedOrderResp.class, result);
        if ("SUCCESS".equals(resp.getResult_code()) && "SUCCESS".equals(resp.getReturn_code())) {
            PaySignVo paySignVo = new PaySignVo();
            paySignVo.setAppId(this.getPayConfig().getAppid());
            long timeStamp = (new Date()).getTime() / 1000L;
            paySignVo.setTimeStamp(Long.toString(timeStamp));
            paySignVo.setNonceStr(RandomUtil.randomString(32));
            paySignVo.setPackageStr("prepay_id=" + resp.getPrepay_id());
            paySignVo.setSignType("MD5");
            paySignVo.setKey(this.getPayConfig().getKey());
            Map<String, Object> paySignMap = new HashMap();
            paySignMap.put("appId", paySignVo.getAppId());
            paySignMap.put("timeStamp", paySignVo.getTimeStamp());
            paySignMap.put("nonceStr", paySignVo.getNonceStr());
            paySignMap.put("package", paySignVo.getPackageStr());
            paySignMap.put("signType", paySignVo.getSignType());
            String paySign = this.getPaySign(paySignMap);
            paySignVo.setPaySign(paySign);
            resp.setPaySignVo(paySignVo);
        }

        return resp;
    }

    /**
     * 小程序：查询订单
     * @param req
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public OrderQueryResp orderquery(OrderQueryReq req) throws InvocationTargetException, IllegalAccessException {
        BeanUtils.copyProperties(req, this.getPayConfig());
        req.setNonce_str(RandomUtil.randomString(32));
        String sign = this.getUnifiedorderSign(req);
        req.setSign(sign);
        String params = XmlUtil.convertToXml(req);
        String result = WxPaymentUtil.post("https://api.mch.weixin.qq.com/pay/orderquery", params);
        this.logger.info(" ==>> orderqueery result: {}", result);
        OrderQueryResp resp = (OrderQueryResp)XmlUtil.convertXmlStrToObject(OrderQueryResp.class, result);
        return resp;
    }

    /**
     * 小程序：申请退款
     * @param req
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public RefundResp refund(RefundReq req) throws InvocationTargetException, IllegalAccessException {
        BeanUtils.copyProperties(req, this.getPayConfig());
        req.setNonce_str(RandomUtil.randomString(32));
        String sign = this.getUnifiedorderSign(req);
        req.setSign(sign);
        String params = XmlUtil.convertToXml(req);
        String result = WxPaymentUtil.post("https://api.mch.weixin.qq.com/secapi/pay/refund", params);
        this.logger.info(" ==>> refund result: {}", result);
        RefundResp resp = (RefundResp)XmlUtil.convertXmlStrToObject(RefundResp.class, result);
        return resp;
    }
}
