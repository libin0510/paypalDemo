package com.example.paypaldemo.bean;

import com.paypal.http.annotations.SerializedName;
import com.paypal.orders.Card;
import com.paypal.orders.PaymentSource;
import com.paypal.orders.Token;

public class PaymentSourceV3 extends PaymentSource {
    @SerializedName("card")
    private Card card;
    @SerializedName("token")
    private Token token;
    @SerializedName("paypal")
    private Paypal paypal;

    public PaymentSourceV3() {
        super();
    }

    public Paypal paypal() {
        return this.paypal;
    }

    public PaymentSource paypal(Paypal paypal) {
        this.paypal = paypal;
        return this;
    }
@Override
    public Card card() {
        return this.card;
    }
@Override
    public PaymentSource card(Card card) {
        this.card = card;
        return this;
    }
@Override
    public Token token() {
        return this.token;
    }
@Override
    public PaymentSource token(Token token) {
        this.token = token;
        return this;
    }
}
