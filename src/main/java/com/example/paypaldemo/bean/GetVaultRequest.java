package com.example.paypaldemo.bean;

import com.alibaba.fastjson.JSONObject;
import com.paypal.http.HttpRequest;
import com.paypal.payments.Capture;
import com.paypal.payments.CapturesGetRequest;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class GetVaultRequest extends HttpRequest<JSONObject> {
    public GetVaultRequest(String customerId) {
        super("/v2/vault/payment-tokens?customer_id={customerId}", "GET", JSONObject.class);
        try {
            path(path().replace("{customerId}", URLEncoder.encode(String.valueOf(customerId), "UTF-8")));
        } catch (UnsupportedEncodingException ignored) {}

        header("Content-Type", "application/json");
    }
    public GetVaultRequest authorization(String authorization) {
        header("Authorization", String.valueOf(authorization));
        return this;
    }

}
