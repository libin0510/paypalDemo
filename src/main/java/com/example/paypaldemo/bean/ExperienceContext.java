package com.example.paypaldemo.bean;

import com.paypal.http.annotations.SerializedName;
import com.paypal.orders.ApplicationContext;
import com.paypal.orders.PaymentMethod;

public class ExperienceContext {
    @SerializedName("brand_name")
    private String brandName;
    @SerializedName("cancel_url")
    private String cancelUrl;
    @SerializedName("landing_page")
    private String landingPage;
    @SerializedName("locale")
    private String locale;
    @SerializedName("payment_method")
    private PaymentMethod paymentMethod;
    @SerializedName("payment_token")
    private String paymentToken;
    @SerializedName("return_url")
    private String returnUrl;
    @SerializedName("shipping_preference")
    private String shippingPreference;
    @SerializedName("user_action")
    private String userAction;

    public ExperienceContext() {
    }

    public String brandName() {
        return this.brandName;
    }

    public ExperienceContext brandName(String brandName) {
        this.brandName = brandName;
        return this;
    }

    public String cancelUrl() {
        return this.cancelUrl;
    }

    public ExperienceContext cancelUrl(String cancelUrl) {
        this.cancelUrl = cancelUrl;
        return this;
    }

    public String landingPage() {
        return this.landingPage;
    }

    public ExperienceContext landingPage(String landingPage) {
        this.landingPage = landingPage;
        return this;
    }

    public String locale() {
        return this.locale;
    }

    public ExperienceContext locale(String locale) {
        this.locale = locale;
        return this;
    }

    public PaymentMethod paymentMethod() {
        return this.paymentMethod;
    }

    public ExperienceContext paymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
        return this;
    }

    public String paymentToken() {
        return this.paymentToken;
    }

    public ExperienceContext paymentToken(String paymentToken) {
        this.paymentToken = paymentToken;
        return this;
    }

    public String returnUrl() {
        return this.returnUrl;
    }

    public ExperienceContext returnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
        return this;
    }

    public String shippingPreference() {
        return this.shippingPreference;
    }

    public ExperienceContext shippingPreference(String shippingPreference) {
        this.shippingPreference = shippingPreference;
        return this;
    }

    public String userAction() {
        return this.userAction;
    }

    public ExperienceContext userAction(String userAction) {
        this.userAction = userAction;
        return this;
    }
}
