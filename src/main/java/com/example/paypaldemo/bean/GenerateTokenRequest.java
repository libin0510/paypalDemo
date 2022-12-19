package com.example.paypaldemo.bean;

import com.alibaba.fastjson.JSONObject;
import com.paypal.http.HttpRequest;
import com.paypal.orders.OrderRequest;

public class GenerateTokenRequest extends HttpRequest<JSONObject> {
    public GenerateTokenRequest() {
        super("/v1/identity/generate-token", "POST", JSONObject.class);
        this.header("Content-Type", "application/json");
    }
    public GenerateTokenRequest paypalRequestId(String payPalRequestId) {
        header("PayPal-Request-Id", String.valueOf(payPalRequestId));
        System.out.println("PayPal-Request-Id:"+String.valueOf(payPalRequestId));
        return this;
    }

    public GenerateTokenRequest requestBody(JSONObject data) {
        super.requestBody(data);
        return this;
    }
}
