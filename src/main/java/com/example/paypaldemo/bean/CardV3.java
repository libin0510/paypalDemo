package com.example.paypaldemo.bean;

import com.paypal.http.annotations.Model;
import com.paypal.http.annotations.SerializedName;
import com.paypal.orders.AddressPortable;
import com.paypal.orders.Card;
@Model
public class CardV3 extends Card {
    @SerializedName("attributes")
    private Attributes attributes;
    @SerializedName("billing_address")
    private AddressPortable addressPortable;
    @SerializedName("card_type")
    private String cardType;
    @SerializedName("expiry")
    private String expiry;
    @SerializedName("id")
    private String id;
    @SerializedName("last_digits")
    private String lastDigits;
    @SerializedName("name")
    private String name;
    @SerializedName("number")
    private String number;
    @SerializedName("security_code")
    private String securityCode;
    @SerializedName("brand")
    private String brand;

    public CardV3(){
        super();
    }


    public String brand() {
        return this.brand;
    }

    public Card brand(String brand) {
        this.brand = brand;
        return this;
    }

    public Attributes attributes() {
        return this.attributes;
    }

    public Card attributes(Attributes attributes) {
        this.attributes = attributes;
        return this;
    }
    @Override
    public AddressPortable addressPortable() {
        return this.addressPortable;
    }

    @Override
    public Card addressPortable(AddressPortable addressPortable) {
        this.addressPortable = addressPortable;
        return this;
    }

    @Override
    public String cardType() {
        return this.cardType;
    }

    @Override
    public Card cardType(String cardType) {
        this.cardType = cardType;
        return this;
    }

    @Override
    public String expiry() {
        return this.expiry;
    }

    @Override
    public Card expiry(String expiry) {
        this.expiry = expiry;
        return this;
    }

    @Override
    public String id() {
        return this.id;
    }

    @Override
    public Card id(String id) {
        this.id = id;
        return this;
    }

    @Override
    public String lastDigits() {
        return this.lastDigits;
    }
    @Override
    public Card lastDigits(String lastDigits) {
        this.lastDigits = lastDigits;
        return this;
    }
    @Override
    public String name() {
        return this.name;
    }
    @Override
    public Card name(String name) {
        this.name = name;
        return this;
    }
    @Override
    public String number() {
        return this.number;
    }
    @Override
    public Card number(String number) {
        this.number = number;
        return this;
    }
    @Override
    public String securityCode() {
        return this.securityCode;
    }
    @Override
    public Card securityCode(String securityCode) {
        this.securityCode = securityCode;
        return this;
    }
}
