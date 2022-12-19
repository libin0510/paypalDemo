package com.example.paypaldemo.bean;

import com.paypal.http.annotations.Model;
import com.paypal.http.annotations.SerializedName;
import com.paypal.orders.*;

import java.util.List;

@Model
public class OrderRequestV3 extends OrderRequest{
    @SerializedName("payment_source")
    private PaymentSource paymentSource;
    @SerializedName("application_context")
    private ApplicationContext applicationContext;

    @SerializedName("intent")
    private String checkoutPaymentIntent;
    @SerializedName("payer")
    private Payer payer;
    @SerializedName("processing_instruction")
    private String processingInstruction;
    @SerializedName(
            value = "purchase_units",
            listClass = PurchaseUnitRequest.class
    )

    private List<PurchaseUnitRequest> purchaseUnits;
    public OrderRequestV3() {
        super();
    }

    public PaymentSource paymentSource() {
        return this.paymentSource;
    }

    public OrderRequest paymentSource(PaymentSource paymentSource) {
        this.paymentSource = paymentSource;
        return this;
    }
    @Override
    public ApplicationContext applicationContext() {
        return this.applicationContext;
    }
    @Override
    public OrderRequest applicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
        return this;
    }
    @Override
    public String checkoutPaymentIntent() {
        return this.checkoutPaymentIntent;
    }
    @Override
    public OrderRequest checkoutPaymentIntent(String checkoutPaymentIntent) {
        this.checkoutPaymentIntent = checkoutPaymentIntent;
        return this;
    }
    @Override
    public Payer payer() {
        return this.payer;
    }
    @Override
    public OrderRequest payer(Payer payer) {
        this.payer = payer;
        return this;
    }
    @Override
    public String processingInstruction() {
        return this.processingInstruction;
    }
    @Override
    public OrderRequest processingInstruction(String processingInstruction) {
        this.processingInstruction = processingInstruction;
        return this;
    }
    @Override
    public List<PurchaseUnitRequest> purchaseUnits() {
        return this.purchaseUnits;
    }
    @Override
    public OrderRequest purchaseUnits(List<PurchaseUnitRequest> purchaseUnits) {
        this.purchaseUnits = purchaseUnits;
        return this;
    }
}
