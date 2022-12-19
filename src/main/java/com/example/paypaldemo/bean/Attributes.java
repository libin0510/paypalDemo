package com.example.paypaldemo.bean;

import com.paypal.http.annotations.Model;
import com.paypal.http.annotations.SerializedName;
import com.paypal.orders.LinkDescription;
import com.paypal.orders.Order;

import java.util.List;

@Model
public class Attributes {
    @SerializedName("vault")
    private Vault vault;
    @SerializedName(
            value = "links",
            listClass = LinkDescription.class
    )
    private List<LinkDescription> links;
    @SerializedName("status")
    private String status;
    @SerializedName("customer")
    private Customer customer;

    public Attributes() {
        super();
    }

    public String status() {
        return this.status;
    }

    public Attributes status(String status) {
        this.status = status;
        return this;
    }

    public Customer customer() {
        return this.customer;
    }

    public Attributes customer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public Vault vault() {
        return this.vault;
    }

    public Attributes vault(Vault vault) {
        this.vault = vault;
        return this;
    }

    public List<LinkDescription> links() {
        return this.links;
    }

    public Attributes links(List<LinkDescription> links) {
        this.links = links;
        return this;
    }
}
