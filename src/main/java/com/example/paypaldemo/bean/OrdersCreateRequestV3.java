package com.example.paypaldemo.bean;

import com.paypal.http.HttpRequest;
import com.paypal.http.annotations.Model;
import com.paypal.orders.Order;
import com.paypal.orders.OrderRequest;
import com.paypal.orders.OrdersCreateRequest;

@Model
public class OrdersCreateRequestV3 extends HttpRequest<OrderV3> {
    public OrdersCreateRequestV3() {
        super("/v2/checkout/orders", "POST", OrderV3.class);
        this.header("Content-Type", "application/json");
    }

    public OrdersCreateRequestV3 paypalRequestId(String payPalRequestId) {
        header("PayPal-Request-Id", String.valueOf(payPalRequestId));
        System.out.println("PayPal-Request-Id:"+String.valueOf(payPalRequestId));
        return this;
    }

    public OrdersCreateRequestV3 authorization(String authorization) {
        this.header("Authorization", String.valueOf(authorization));
        System.out.println("Authorization:"+String.valueOf(authorization));
        return this;
    }

    public OrdersCreateRequestV3 contentType(String contentType) {
        this.header("Content-Type", String.valueOf(contentType));
        System.out.println("Content-Type:"+String.valueOf(contentType));
        return this;
    }

    public OrdersCreateRequestV3 payPalPartnerAttributionId(String payPalPartnerAttributionId) {
        this.header("PayPal-Partner-Attribution-Id", String.valueOf(payPalPartnerAttributionId));
        System.out.println("PayPal-Partner-Attribution-Id:"+String.valueOf(payPalPartnerAttributionId));
        return this;
    }

    public OrdersCreateRequestV3 prefer(String prefer) {
        this.header("Prefer", String.valueOf(prefer));
        System.out.println("Prefer:"+String.valueOf(prefer));
        return this;
    }

    public OrdersCreateRequestV3 requestBody(OrderRequest order) {
        super.requestBody(order);
        return this;
    }
}
