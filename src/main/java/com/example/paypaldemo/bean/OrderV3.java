package com.example.paypaldemo.bean;

import com.paypal.http.annotations.Model;
import com.paypal.http.annotations.SerializedName;
import com.paypal.orders.*;

import java.util.List;

@Model
public class OrderV3 extends Order {
    @SerializedName("intent")
    private String checkoutPaymentIntent;
    @SerializedName("create_time")
    private String createTime;
    @SerializedName("expiration_time")
    private String expirationTime;
    @SerializedName("id")
    private String id;
    @SerializedName(
            value = "links",
            listClass = LinkDescription.class
    )
    private List<LinkDescription> links;
    @SerializedName("payer")
    private Payer payer;
    @SerializedName(
            value = "purchase_units",
            listClass = PurchaseUnit.class
    )
    private List<PurchaseUnit> purchaseUnits;
    @SerializedName("status")
    private String status;
    @SerializedName("update_time")
    private String updateTime;
    @SerializedName("payment_source")
    private PaymentSource paymentSource;

    public OrderV3() {
        super();
    }

    public PaymentSource paymentSource() {
        return this.paymentSource;
    }

    public Order paymentSource(PaymentSource paymentSource) {
        this.paymentSource = paymentSource;
        return this;
    }
    @Override
    public String checkoutPaymentIntent() {
        return this.checkoutPaymentIntent;
    }
    @Override
    public Order checkoutPaymentIntent(String checkoutPaymentIntent) {
        this.checkoutPaymentIntent = checkoutPaymentIntent;
        return this;
    }
    @Override
    public String createTime() {
        return this.createTime;
    }
    @Override
    public Order createTime(String createTime) {
        this.createTime = createTime;
        return this;
    }
    @Override
    public String expirationTime() {
        return this.expirationTime;
    }
    @Override
    public Order expirationTime(String expirationTime) {
        this.expirationTime = expirationTime;
        return this;
    }
    @Override
    public String id() {
        return this.id;
    }
    @Override
    public Order id(String id) {
        this.id = id;
        return this;
    }
    @Override
    public List<LinkDescription> links() {
        return this.links;
    }
    @Override
    public Order links(List<LinkDescription> links) {
        this.links = links;
        return this;
    }
    @Override
    public Payer payer() {
        return this.payer;
    }
    @Override
    public Order payer(Payer payer) {
        this.payer = payer;
        return this;
    }
    @Override
    public List<PurchaseUnit> purchaseUnits() {
        return this.purchaseUnits;
    }
    @Override
    public Order purchaseUnits(List<PurchaseUnit> purchaseUnits) {
        this.purchaseUnits = purchaseUnits;
        return this;
    }
    @Override
    public String status() {
        return this.status;
    }
    @Override
    public Order status(String status) {
        this.status = status;
        return this;
    }
    @Override
    public String updateTime() {
        return this.updateTime;
    }

    @Override
    public Order updateTime(String updateTime) {
        this.updateTime = updateTime;
        return this;
    }
}
