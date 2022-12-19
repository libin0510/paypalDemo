package com.example.paypaldemo.bean;

import com.paypal.http.annotations.Model;
import com.paypal.http.annotations.SerializedName;

@Model
public class Customer {
    @SerializedName("id")
    private String id;

    public Customer(){

    }

    public String id(){
        return this.id;
    }

    public Customer id(String id){
        this.id = id;
        return this;
    }
}
