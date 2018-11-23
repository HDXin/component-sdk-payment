package top.atstudy.component.sdk.payment.wx;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import top.atstudy.component.sdk.payment.wx.mini.config.PayConfig;
import top.atstudy.component.sdk.payment.wx.mini.service.PaymentService;
import top.atstudy.component.sdk.payment.wx.mini.vo.*;

import java.lang.reflect.InvocationTargetException;

public class PaymentServiceTest {

    /**
     * 小程序：统一下单
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    @Test
    public void unifiedorderTest() throws InvocationTargetException, IllegalAccessException {
        PayConfig payConfig = new PayConfig();
        payConfig.setAppid("wx542117793d10f889");
        payConfig.setMch_id("1491071992");
        payConfig.setNotify_url("https://advistory.51alf.cn/api/mini/payment/notify");
        payConfig.setTrade_type("JSAPI");
        payConfig.setKey("c8f6l6m5v9qrswmesvdh85im4j11y1v5");
        UnifiedOrderReq req = new UnifiedOrderReq();
        req.setBody("微信统一下单测试");
        req.setOut_trade_no("1234567890");
        req.setTotal_fee(1L);
        req.setSpbill_create_ip("123.12.12.123");
        req.setOpenid("ozw4D0R2YD-fMGLwJXvqOpBlcUto");
        UnifiedOrderResp resp = PaymentService.getInstance(payConfig).unifiedorder(req);
        String result = JSONObject.toJSONString(resp);
        System.out.println(" ===>>" + result);
    }

    /**
     * 小程序：查询订单
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    @Test
    public void orderqueryTest() throws InvocationTargetException, IllegalAccessException {
        PayConfig payConfig = new PayConfig();
        payConfig.setAppid("wx542117793d10f889");
        payConfig.setMch_id("1491071992");
        payConfig.setTrade_type("JSAPI");
        payConfig.setKey("c8f6l6m5v9qrswmesvdh85im4j11y1v5");
        OrderQueryReq req = new OrderQueryReq();
        req.setOut_trade_no("12345678910");
        OrderQueryResp resp = PaymentService.getInstance(payConfig).orderquery(req);
        String result = JSONObject.toJSONString(resp);
        System.out.println(" ===>>" + result);
    }

    /**
     * 小程序：申请退款
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    @Test
    public void refund() throws InvocationTargetException, IllegalAccessException {
        PayConfig payConfig = new PayConfig();
        payConfig.setAppid("wx542117793d10f889");
        payConfig.setMch_id("1491071992");
        payConfig.setNotify_url("https://advistory.51alf.cn/api/mini/payment/notify");
        payConfig.setTrade_type("JSAPI");
        payConfig.setKey("c8f6l6m5v9qrswmesvdh85im4j11y1v5");
        RefundReq req = new RefundReq();
        //订单号
        req.setOut_trade_no("");
        //订单金额 单位：分
        req.setTotal_fee(11L);
        //退款单号
        req.setOut_trade_no("12345678910");
        //退款金额 单位：分
        req.setRefund_fee(1L);
        //退款结果通知，异步回调地址
        req.setNotify_url("");

        RefundResp resp = PaymentService.getInstance(payConfig).refund(req);
        String result = JSONObject.toJSONString(resp);
        System.out.println(" ===>>" + result);
    }

}
