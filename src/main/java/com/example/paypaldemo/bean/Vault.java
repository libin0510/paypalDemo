package com.example.paypaldemo.bean;

import com.alibaba.fastjson2.JSONObject;
import com.paypal.http.annotations.Model;
import com.paypal.http.annotations.SerializedName;
import com.paypal.orders.Card;
import com.paypal.orders.LinkDescription;
import com.paypal.orders.Order;

import java.util.List;

@Model
public class Vault {
    @SerializedName("store_in_vault")
    private String storeInVault;
    @SerializedName("usage_type")
    private String usageType;
    @SerializedName("customer")
    private Customer customer;
    @SerializedName("id")
    private String id;
    @SerializedName("setup_token")
    private String setupToken;
    @SerializedName("status")
    private String status;
    @SerializedName(
            value = "links",
            listClass = LinkDescription.class
    )
    private List<LinkDescription> links;
    @SerializedName("confirm_payment_token")
    private String confirmPaymentToken;
    @SerializedName("customer_type")
    private String customerType;

    public List<LinkDescription> links() {
        return this.links;
    }

    public Vault links(List<LinkDescription> links) {
        this.links = links;
        return this;
    }
    public String confirmPaymentToken(){
        return this.confirmPaymentToken;
    }
    public Vault confirmPaymentToken(String confirmPaymentToken) {
        this.confirmPaymentToken = confirmPaymentToken;
        return this;
    }
    public String customerType(){
        return this.customerType;
    }

    public Vault customerType(String customerType) {
        this.customerType = customerType;
        return this;
    }
    public String status(){
        return this.status;
    }
    public Vault status(String status) {
        this.status = status;
        return this;
    }

    public String setupToken(){
        return this.setupToken;
    }
    public Vault setupToken(String setupToken) {
        this.setupToken = setupToken;
        return this;
    }

    public String UsageType(){
        return this.usageType;
    }
    public Vault usageType(String usageType) {
        this.usageType = usageType;
        return this;
    }

    public String id(){
        return this.id;
    }
    public Vault id(String id) {
        this.id = id;
        return this;
    }

    public Customer customer(){
        return this.customer;
    }
    public Vault customer(Customer customer) {
        this.customer = customer;
        return this;
    }
    public String storeInVault() {
        return this.storeInVault;
    }

    public Vault storeInVault(String storeInVault) {
        this.storeInVault = storeInVault;
        return this;
    }
}
