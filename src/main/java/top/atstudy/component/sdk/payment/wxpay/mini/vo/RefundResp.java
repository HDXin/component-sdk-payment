package top.atstudy.component.sdk.payment.wxpay.mini.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(
        name = "xml"
)
public class RefundResp extends BasicPayResp {
    private String transaction_id;
    private String out_trade_no;
    private String out_refund_no;
    private String refund_id;
    private Long refund_fee;
    private Long settlement_refund_fee;
    private Long total_fee;
    private Long settlement_total_fee;
    private String feee_type;
    private Long cash_fee;
    private String cash_fee_type;
    private Long cash_refund_fee;
    private String coupon_type_$n;
    private Long coupon_refund_fee;
    private Long coupon_refund_fee_$n;
    private Integer coupon_refund_count;
    private String coupon_refund_id_$n;

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

    public String getOut_refund_no() {
        return this.out_refund_no;
    }

    public void setOut_refund_no(String out_refund_no) {
        this.out_refund_no = out_refund_no;
    }

    public String getRefund_id() {
        return this.refund_id;
    }

    public void setRefund_id(String refund_id) {
        this.refund_id = refund_id;
    }

    public Long getRefund_fee() {
        return this.refund_fee;
    }

    public void setRefund_fee(Long refund_fee) {
        this.refund_fee = refund_fee;
    }

    public Long getSettlement_refund_fee() {
        return this.settlement_refund_fee;
    }

    public void setSettlement_refund_fee(Long settlement_refund_fee) {
        this.settlement_refund_fee = settlement_refund_fee;
    }

    public Long getTotal_fee() {
        return this.total_fee;
    }

    public void setTotal_fee(Long total_fee) {
        this.total_fee = total_fee;
    }

    public Long getSettlement_total_fee() {
        return this.settlement_total_fee;
    }

    public void setSettlement_total_fee(Long settlement_total_fee) {
        this.settlement_total_fee = settlement_total_fee;
    }

    public String getFeee_type() {
        return this.feee_type;
    }

    public void setFeee_type(String feee_type) {
        this.feee_type = feee_type;
    }

    public Long getCash_fee() {
        return this.cash_fee;
    }

    public void setCash_fee(Long cash_fee) {
        this.cash_fee = cash_fee;
    }

    public String getCash_fee_type() {
        return this.cash_fee_type;
    }

    public void setCash_fee_type(String cash_fee_type) {
        this.cash_fee_type = cash_fee_type;
    }

    public Long getCash_refund_fee() {
        return this.cash_refund_fee;
    }

    public void setCash_refund_fee(Long cash_refund_fee) {
        this.cash_refund_fee = cash_refund_fee;
    }

    public String getCoupon_type_$n() {
        return this.coupon_type_$n;
    }

    public void setCoupon_type_$n(String coupon_type_$n) {
        this.coupon_type_$n = coupon_type_$n;
    }

    public Long getCoupon_refund_fee() {
        return this.coupon_refund_fee;
    }

    public void setCoupon_refund_fee(Long coupon_refund_fee) {
        this.coupon_refund_fee = coupon_refund_fee;
    }

    public Long getCoupon_refund_fee_$n() {
        return this.coupon_refund_fee_$n;
    }

    public void setCoupon_refund_fee_$n(Long coupon_refund_fee_$n) {
        this.coupon_refund_fee_$n = coupon_refund_fee_$n;
    }

    public Integer getCoupon_refund_count() {
        return this.coupon_refund_count;
    }

    public void setCoupon_refund_count(Integer coupon_refund_count) {
        this.coupon_refund_count = coupon_refund_count;
    }

    public String getCoupon_refund_id_$n() {
        return this.coupon_refund_id_$n;
    }

    public void setCoupon_refund_id_$n(String coupon_refund_id_$n) {
        this.coupon_refund_id_$n = coupon_refund_id_$n;
    }
}
