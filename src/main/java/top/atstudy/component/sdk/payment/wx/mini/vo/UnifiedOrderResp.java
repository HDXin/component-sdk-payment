package top.atstudy.component.sdk.payment.wx.mini.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(
        name = "xml"
)
public class UnifiedOrderResp extends BasicPayResp {
    private String trade_type;
    private String prepay_id;
    private String code_url;
    private PaySignVo paySignVo;

    public String getTrade_type() {
        return this.trade_type;
    }

    public void setTrade_type(String trade_type) {
        this.trade_type = trade_type;
    }

    public String getPrepay_id() {
        return this.prepay_id;
    }

    public void setPrepay_id(String prepay_id) {
        this.prepay_id = prepay_id;
    }

    public String getCode_url() {
        return this.code_url;
    }

    public void setCode_url(String code_url) {
        this.code_url = code_url;
    }

    public PaySignVo getPaySignVo() {
        return this.paySignVo;
    }

    public void setPaySignVo(PaySignVo paySignVo) {
        this.paySignVo = paySignVo;
    }
}
