package top.atstudy.component.sdk.payment.wxpay.mini.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class OrderQueryReq extends BasicPayReq {
    private String transaction_id;
    private String out_trade_no;

    public String getTransaction_id() {
        return this.transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getOut_trade_no() {
        return this.out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }
}
