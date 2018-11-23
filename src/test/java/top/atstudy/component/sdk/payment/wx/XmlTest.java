package top.atstudy.component.sdk.payment.wx;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import top.atstudy.component.sdk.payment.wx.mini.vo.UnifiedOrderReq;
import top.atstudy.component.util.XmlUtil;

public class XmlTest {


    @Test
    public void objToXml() {
        UnifiedOrderReq req = new UnifiedOrderReq();
        req.setAppid("abdcefg");
        req.setAttach("哈哈哈啊");
        String str = XmlUtil.convertToXml(req);
        System.out.println(str);
    }

    @Test
    public void xmlToObj() {
        String str = "<unifiedOrderReq>\n" +
                     "    <appid>abdcefg</appid>\n" +
                     "    <attach>哈哈哈啊</attach>\n" +
                     "</unifiedOrderReq>";
        UnifiedOrderReq payReq = (UnifiedOrderReq)XmlUtil.convertXmlStrToObject(UnifiedOrderReq.class, str);
        System.out.println(" ==>> " + JSONObject.toJSONString(payReq));
    }
}
