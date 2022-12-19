package com.example.paypaldemo.bean;

import com.paypal.http.annotations.SerializedName;
import com.paypal.orders.ApplicationContext;
import com.paypal.orders.Card;
import com.paypal.orders.OrderRequest;

public class Paypal {
    @SerializedName("attributes")
    private Attributes attributes;

    @SerializedName("experience_context")
    private ExperienceContext experienceContext;

    public Paypal(){
        super();
    }

    public Attributes attributes() {
        return this.attributes;
    }

    public Paypal attributes(Attributes attributes) {
        this.attributes = attributes;
        return this;
    }


    public ExperienceContext experienceContext() {
        return this.experienceContext;
    }

    public Paypal experienceContext(ExperienceContext experienceContext) {
        this.experienceContext = experienceContext;
        return this;
    }
}
