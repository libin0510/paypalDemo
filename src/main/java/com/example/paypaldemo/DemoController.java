package com.example.paypaldemo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.example.paypaldemo.bean.*;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.paypal.core.PayPalEnvironment;
import com.paypal.core.object.AccessToken;
import com.paypal.core.request.AccessTokenRequest;
import com.paypal.http.HttpResponse;
import com.paypal.http.exceptions.HttpException;
import com.paypal.http.exceptions.SerializeException;
import com.paypal.http.serializer.Json;
import com.paypal.orders.*;
import com.paypal.payments.CapturesRefundRequest;
import com.paypal.payments.Money;
import com.paypal.payments.Refund;
import com.paypal.payments.RefundRequest;
import com.paypal.payments.RefundsGetRequest;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.*;

@Controller
public class DemoController {

    @RequestMapping(path = "/create_order", method = RequestMethod.POST)
    @ResponseBody
    public String createOrder(HttpServletRequest request, String currencyCode, String amount) throws SerializeException {
        System.out.println(currencyCode);
        System.out.println(amount);
        Order order = null;
        OrderRequest orderRequest = new OrderRequest();
        orderRequest.checkoutPaymentIntent("CAPTURE");
        List<PurchaseUnitRequest> purchaseUnits = new ArrayList<>();
        purchaseUnits
                .add(new PurchaseUnitRequest().amountWithBreakdown(new AmountWithBreakdown().currencyCode(currencyCode).value(amount)));
        orderRequest.purchaseUnits(purchaseUnits);
        System.out.println("create-order-request:"+new Json().serialize(orderRequest).toString());
        OrdersCreateRequest r = new OrdersCreateRequest().requestBody(orderRequest);

        try {
            // Call API with your client and get a response for your call
            HttpResponse<Order> response = Credentials.client.execute(r);

            // If call returns body in response, you can get the de-serialized version by
            // calling result() on the response
            order = response.result();
            System.out.println("Order ID: " + order.id());
            return new JSONObject(new Json().serialize(response.result())).toString(4);
        } catch (IOException ioe) {
            if (ioe instanceof HttpException) {
                // Something went wrong server-side
                HttpException he = (HttpException) ioe;
                System.out.println(he.getMessage());
//                he.headers().forEach(x -> System.out.println(x + " :" + he.headers().header(x)));
                return he.getMessage();
            } else {
                return null;
                // Something went wrong client-side
            }
        }
    }

    @RequestMapping(path = "/captures_order", method = RequestMethod.POST)
    @ResponseBody
    public String capturesOrder(HttpServletRequest request, String orderId) {
        Order order = null;
        OrdersCaptureRequest r = new OrdersCaptureRequest(orderId);

        try {
            // Call API with your client and get a response for your call
            HttpResponse<Order> response = Credentials.client.execute(r);

            // If call returns body in response, you can get the de-serialized version by
            // calling result() on the response
            order = response.result();
            System.out.println("captures_order:"+new JSONObject(new Json().serialize(response.result())).toString(4));
            return new JSONObject(new Json().serialize(response.result())).toString(4);
        } catch (IOException ioe) {
            if (ioe instanceof HttpException) {
                // Something went wrong server-side
                HttpException he = (HttpException) ioe;
                System.out.println(he.getMessage());
//                he.headers().forEach(x -> System.out.println(x + " :" + he.headers().header(x)));
                return he.getMessage();
            } else {
                // Something went wrong client-side
                return null;
            }
        }
    }

    @RequestMapping(path = "/order", method = RequestMethod.GET)
    @ResponseBody
    public String getOrder(HttpServletRequest request, String orderId) {
        Order order = null;
        OrdersGetRequest r = new OrdersGetRequest(orderId);
        try {
            // Call API with your client and get a response for your call
            HttpResponse<Order> response = Credentials.client.execute(r);

            // If call returns body in response, you can get the de-serialized version by
            // calling result() on the response
            order = response.result();
            return new JSONObject(new Json().serialize(response.result())).toString(4);
        } catch (IOException ioe) {
            if (ioe instanceof HttpException) {
                // Something went wrong server-side
                HttpException he = (HttpException) ioe;
                System.out.println(he.getMessage());
//                he.headers().forEach(x -> System.out.println(x + " :" + he.headers().header(x)));
                return he.getMessage();
            } else {
                // Something went wrong client-side
                return null;
            }
        }
    }

    @RequestMapping(path = "/refundOrder", method = RequestMethod.GET)
    @ResponseBody
    public String refund(HttpServletRequest request, String captureId) {
        Refund order = null;
        CapturesRefundRequest r = new CapturesRefundRequest(captureId);
        try {
            // Call API with your client and get a response for your call
            HttpResponse<Refund> response = Credentials.client.execute(r);

            // If call returns body in response, you can get the de-serialized version by
            // calling result() on the response
            order = response.result();
            return new JSONObject(new Json().serialize(response.result())).toString(4);
        } catch (IOException ioe) {
            if (ioe instanceof HttpException) {
                // Something went wrong server-side
                HttpException he = (HttpException) ioe;
                System.out.println(he.getMessage());
//                he.headers().forEach(x -> System.out.println(x + " :" + he.headers().header(x)));
                return he.getMessage();
            } else {
                // Something went wrong client-side
                return null;
            }
        }
    }

    @RequestMapping(path = "/refundOrderInfo", method = RequestMethod.GET)
    @ResponseBody
    public String getRefund(HttpServletRequest request, String captureId) {
        Refund order = null;
        RefundsGetRequest r = new RefundsGetRequest(captureId);
        try {
            // Call API with your client and get a response for your call
            HttpResponse<Refund> response = Credentials.client.execute(r);

            // If call returns body in response, you can get the de-serialized version by
            // calling result() on the response
            order = response.result();
            return new JSONObject(new Json().serialize(response.result())).toString(4);
        } catch (IOException ioe) {
            if (ioe instanceof HttpException) {
                // Something went wrong server-side
                HttpException he = (HttpException) ioe;
                System.out.println(he.getMessage());
//                he.headers().forEach(x -> System.out.println(x + " :" + he.headers().header(x)));
                return he.getMessage();
            } else {
                // Something went wrong client-side
                return null;
            }
        }
    }

    @RequestMapping(path = "/refundOrderB", method = RequestMethod.GET)
    @ResponseBody
    public String refundb(HttpServletRequest request, String captureId, String currencyCode, String amount) {
        com.paypal.payments.Money m = new Money();
        m.currencyCode(currencyCode);
        m.value(amount);
        Refund order = null;
        CapturesRefundRequest r = new CapturesRefundRequest(captureId);
        RefundRequest rr = new RefundRequest();
        rr.amount(m);
        r.requestBody(rr);
        try {
            // Call API with your client and get a response for your call
            HttpResponse<Refund> response = Credentials.client.execute(r);

            // If call returns body in response, you can get the de-serialized version by
            // calling result() on the response
            order = response.result();
            return new JSONObject(new Json().serialize(response.result())).toString(4);
        } catch (IOException ioe) {
            if (ioe instanceof HttpException) {
                // Something went wrong server-side
                HttpException he = (HttpException) ioe;
                System.out.println(he.getMessage());
//                he.headers().forEach(x -> System.out.println(x + " :" + he.headers().header(x)));
                return he.getMessage();
            } else {
                // Something went wrong client-side
                return null;
            }
        }
    }
    //v3版 vault接口，通过支付直接获取vault信息，sandbox可以，live不知道为啥不行，暂时放弃，采用jssdk restapi形式
    @RequestMapping(path = "/create_order_with_card", method = RequestMethod.POST)
    @ResponseBody
    public String createOrderWithCard(HttpServletRequest request, @RequestBody String body) throws SerializeException {
        com.alibaba.fastjson.JSONObject data = JSON.parseObject(body);
        OrderV3 order = null;
        OrderRequestV3 orderRequest = new OrderRequestV3();
        orderRequest.checkoutPaymentIntent(data.getString("intent"));
        CardV3 card = new CardV3();
        card.number(data.getJSONObject("payment_source").getJSONObject("card").getString("number"));
        card.expiry(data.getJSONObject("payment_source").getJSONObject("card").getString("expiry"));
        card.name(data.getJSONObject("payment_source").getJSONObject("card").getString("name"));
        card.addressPortable(new AddressPortable().addressLine1(data.getJSONObject("payment_source").getJSONObject("card").getJSONObject("billing_address").getString("address_line_1"))
                .addressLine2(data.getJSONObject("payment_source").getJSONObject("card").getJSONObject("billing_address").getString("address_line_2"))
                .adminArea2(data.getJSONObject("payment_source").getJSONObject("card").getJSONObject("billing_address").getString("admin_area_1"))
                .adminArea1(data.getJSONObject("payment_source").getJSONObject("card").getJSONObject("billing_address").getString("admin_area_2"))
                .postalCode(data.getJSONObject("payment_source").getJSONObject("card").getJSONObject("billing_address").getString("postal_code"))
                .countryCode(data.getJSONObject("payment_source").getJSONObject("card").getJSONObject("billing_address").getString("country_code")));
        card.attributes(new Attributes().vault(
                new Vault().confirmPaymentToken("ON_ORDER_COMPLETION"))
                .customer(new Customer()
                        .id(data.getJSONObject("payment_source")
                        .getJSONObject("card")
                        .getJSONObject("attributes")
                        .getJSONObject("customer")
                        .getString("id"))));
        orderRequest.paymentSource(new PaymentSource().card(card));
        List<PurchaseUnitRequest> purchaseUnits = new ArrayList<>();
        purchaseUnits
                .add(new PurchaseUnitRequest()
                        .amountWithBreakdown(new AmountWithBreakdown()
                                .currencyCode(data.getJSONObject("purchase_units")
                                        .getJSONObject("amount").getString("currency_code"))
                                .value(data.getJSONObject("purchase_units")
                                        .getJSONObject("amount").getString("value"))));
        orderRequest.purchaseUnits(purchaseUnits);
        System.out.println(new Json().serialize(orderRequest).toString());
        OrdersCreateRequestV3 r = new OrdersCreateRequestV3()
                .paypalRequestId(makeId(12)).requestBody(orderRequest);

        try {
            // Call API with your client and get a response for your call
            HttpResponse<OrderV3> response = Credentials.client.execute(r);

            // If call returns body in response, you can get the de-serialized version by
            // calling result() on the response
            order = (OrderV3) response.result();
            System.out.println(new Json().serialize(response.result()).toString());
            System.out.println("Order ID: " + order.id());
//            res.put("id", order.id());
//            res.put("status", order.status());
//            JSONArray links = new JSONArray();
////
//            order.links().forEach(link -> {
//                JSONObject l = new JSONObject();
//                l.put("rel", link.rel());
//                l.put("method", link.method());
//                l.put("href", link.href());
//                links.add(l);
//            });
//            res.put("links", links);
            return new JSONObject(new Json().serialize(response.result())).toString(4);
        } catch (IOException ioe) {
            if (ioe instanceof HttpException) {
                // Something went wrong server-side
                HttpException he = (HttpException) ioe;
                System.out.println(he.getMessage());
//                he.headers().forEach(x -> System.out.println(x + " :" + he.headers().header(x)));
                return he.getMessage();
            } else {
                return null;
                // Something went wrong client-side
            }
        }
    }
    @RequestMapping(path = "/create_order_save", method = RequestMethod.POST)
    @ResponseBody
    public String createOrderSave(HttpServletRequest request, String currencyCode,String amount,String customer) throws SerializeException {
        OrderV3 order = null;
        OrderRequestV3 orderRequest = new OrderRequestV3();
        orderRequest.checkoutPaymentIntent("CAPTURE");
        Paypal paypal = new Paypal();
        paypal.attributes(new Attributes().vault(
                new Vault().confirmPaymentToken("ON_ORDER_COMPLETION").usageType("MERCHANT").customerType("CONSUMER"))
                .customer(new Customer()
                        .id(customer)));
        paypal.experienceContext((new ExperienceContext().cancelUrl("https://xxx.xxx.com/paypal/callback").returnUrl("https://xxx.xxx.com/paypal/callback")));
        orderRequest.paymentSource(new PaymentSourceV3().paypal(paypal));
//        orderRequest.applicationContext(new ApplicationContext().returnUrl("https://xxx.xxx.com/returnUrl").cancelUrl("https://xxx.xxx.com/returnUrl").locale("en-US"));
        List<PurchaseUnitRequest> purchaseUnits = new ArrayList<>();
        purchaseUnits
                .add(new PurchaseUnitRequest().amountWithBreakdown(new AmountWithBreakdown().currencyCode(currencyCode).value(amount)));
        orderRequest.purchaseUnits(purchaseUnits);
        System.out.println(new Json().serialize(orderRequest).toString());
        OrdersCreateRequestV3 r = new OrdersCreateRequestV3()
                .paypalRequestId(makeId(12)).requestBody(orderRequest);

        try {
            // Call API with your client and get a response for your call
            HttpResponse<OrderV3> response = Credentials.client.execute(r);

            // If call returns body in response, you can get the de-serialized version by
            // calling result() on the response
            order = (OrderV3) response.result();
            System.out.println(new Json().serialize(response.result()).toString());
            System.out.println("Order ID: " + order.id());
//            res.put("id", order.id());
//            res.put("status", order.status());
//            JSONArray links = new JSONArray();
////
//            order.links().forEach(link -> {
//                JSONObject l = new JSONObject();
//                l.put("rel", link.rel());
//                l.put("method", link.method());
//                l.put("href", link.href());
//                links.add(l);
//            });
//            res.put("links", links);
            return new JSONObject(new Json().serialize(response.result())).toString(4);
        } catch (IOException ioe) {
            if (ioe instanceof HttpException) {
                // Something went wrong server-side
                HttpException he = (HttpException) ioe;
                System.out.println(he.getMessage());
//                he.headers().forEach(x -> System.out.println(x + " :" + he.headers().header(x)));
                return he.getMessage();
            } else {
                return null;
                // Something went wrong client-side
            }
        }
    }
    @RequestMapping(path = "/generate_token", method = RequestMethod.GET)
    @ResponseBody
    public String generateToken(HttpServletRequest request,String customerId){
        com.alibaba.fastjson.JSONObject data = new com.alibaba.fastjson.JSONObject();
        data.put("customer_id",customerId);
        GenerateTokenRequest gtq = new GenerateTokenRequest().paypalRequestId(makeId(12)).requestBody(data);
        try {
            // Call API with your client and get a response for your call
            HttpResponse<com.alibaba.fastjson.JSONObject> response = Credentials.client.execute(gtq);

            // If call returns body in response, you can get the de-serialized version by
            // calling result() on the response
            com.alibaba.fastjson.JSONObject token = response.result();
            return new JSONObject(new Json().serialize(token)).toString(4);
        } catch (IOException ioe) {
            if (ioe instanceof HttpException) {
                // Something went wrong server-side
                HttpException he = (HttpException) ioe;
                System.out.println(he.getMessage());
//                he.headers().forEach(x -> System.out.println(x + " :" + he.headers().header(x)));
                return he.getMessage();
            } else {
                return null;
                // Something went wrong client-side
            }
        }
    }
    @RequestMapping(path = "/clientId", method = RequestMethod.GET)
    @ResponseBody
    public String getClientId(HttpServletRequest request) {
            return Credentials.clientId;
    }

    @RequestMapping("/paypal_to_vault")
    public String paypal2Vault(ModelMap map,HttpServletRequest request,String customerId) {
        String token = generateToken(request,customerId);
        com.alibaba.fastjson.JSONObject tokenObj = JSON.parseObject(token);
        String clientId = getClientId(request);
        // 添加一个属性,用来在模板中根据这个key来读取对应的值
        map.addAttribute("customerId",customerId);
        map.addAttribute("generateToken",tokenObj.getString("client_token"));
        map.addAttribute("clientId","https://www.paypal.com/sdk/js?client-id="+clientId);
        // return 模板文件的名称-->对应src/main/resources/templates/index.html
        return "paypaltovault";
    }
    @RequestMapping("/card_to_vault")
    public String card2Vault(ModelMap map,HttpServletRequest request,String customerId) {
        String token = generateToken(request,customerId);
        com.alibaba.fastjson.JSONObject tokenObj = JSON.parseObject(token);
        String clientId = getClientId(request);
        // 添加一个属性,用来在模板中根据这个key来读取对应的值
        map.addAttribute("generateToken",tokenObj.getString("client_token"));
        map.addAttribute("clientId","https://www.paypal.com/sdk/js?components=buttons,hosted-fields&client-id="+clientId);
        // return 模板文件的名称-->对应src/main/resources/templates/index.html
        return "cardToVault";
    }
    @RequestMapping(path = "/vault", method = RequestMethod.GET)
    @ResponseBody
    public String getVault(HttpServletRequest request,String customerId) {
        return getVault(customerId);
    }
    private String getVault(String customerId){
        GetVaultRequest gtq = new GetVaultRequest(customerId);
        try {
            // Call API with your client and get a response for your call
            HttpResponse<com.alibaba.fastjson.JSONObject> response = Credentials.client.execute(gtq);

            // If call returns body in response, you can get the de-serialized version by
            // calling result() on the response
            com.alibaba.fastjson.JSONObject token = response.result();
            return new JSONObject(new Json().serialize(token)).toString(4);
        } catch (IOException ioe) {
            if (ioe instanceof HttpException) {
                // Something went wrong server-side
                HttpException he = (HttpException) ioe;
                System.out.println(he.getMessage());
//                he.headers().forEach(x -> System.out.println(x + " :" + he.headers().header(x)));
                return he.getMessage();
            } else {
                return null;
                // Something went wrong client-side
            }
        }
    }

    @RequestMapping(path = "/paypal/callback", method = RequestMethod.POST)
    @ResponseBody
    public String callback(HttpServletRequest request, @RequestBody String body) {
        System.out.println("paypal callback:"+body);
        return "success";
    }

    @RequestMapping(path = "/create_order_token", method = RequestMethod.GET)
    @ResponseBody
    public String createOrderByToken(HttpServletRequest request, String currencyCode, String amount,String customerId) throws InterruptedException {
        Map<String,String> c = new HashMap<>();
        Thread thread = new Thread(() -> {
            String order = createOrderByToken(currencyCode,amount,customerId);
            c.put("create:order:byToken:"+customerId,order);
            System.out.println(customerId+" create order:" + order);
        });
        thread.start();
        Thread.sleep(30*1000);
        return c.get("create:order:byToken:"+customerId);
    }

    private String createOrderByToken(String currencyCode, String amount,String customerId){
        System.out.println(currencyCode);
        System.out.println(amount);
        System.out.println(customerId);
        String tokenString = getVault(customerId);
        com.alibaba.fastjson.JSONObject tokenObj = JSON.parseObject(tokenString);
        JSONArray tokensList = tokenObj.getJSONArray("payment_tokens");
        if(tokensList == null || tokensList.isEmpty()){
            return "token is null";
        }
        String token = tokensList.getJSONObject(0).getString("id");
        System.out.println("customerId:"+customerId+" vaultId:"+tokenString);
        OrderV3 order = null;
        OrderRequestV3 orderRequest = new OrderRequestV3();
        orderRequest.checkoutPaymentIntent("AUTHORIZE");

        orderRequest.paymentSource(new PaymentSourceV3().token(new Token().id(token).type("PAYMENT_METHOD_TOKEN")));
        List<PurchaseUnitRequest> purchaseUnits = new ArrayList<>();
        purchaseUnits
                .add(new PurchaseUnitRequest().invoiceId(makeId(18)).referenceId(makeId(24)).amountWithBreakdown(new AmountWithBreakdown().currencyCode(currencyCode).value(amount)));
        orderRequest.purchaseUnits(purchaseUnits).applicationContext(new ApplicationContext().returnUrl("https://xxx.xxx.com/paypal/callback").cancelUrl("https://xxx.xxx.com/paypal/callback"));

        OrdersCreateRequestV3 r = new OrdersCreateRequestV3()
                .paypalRequestId(makeId(12))
                .requestBody(orderRequest);

        try {
            // Call API with your client and get a response for your call
            HttpResponse<OrderV3> response = Credentials.client.execute(r);

            // If call returns body in response, you can get the de-serialized version by
            // calling result() on the response
            order = response.result();
            System.out.println("Order ID: " + order.id());
            return new JSONObject(new Json().serialize(response.result())).toString(4);
        } catch (IOException ioe) {
            if (ioe instanceof HttpException) {
                // Something went wrong server-side
                HttpException he = (HttpException) ioe;
                System.out.println(he.getMessage());
//                he.headers().forEach(x -> System.out.println(x + " :" + he.headers().header(x)));
                return he.getMessage();
            } else {
                return null;
                // Something went wrong client-side
            }
        }
    }
    private String makeId(int length) {
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(3);
            long result = 0;
            switch (number) {
                case 0:
                    result = Math.round(Math.random() * 25 + 65);
                    sb.append(String.valueOf((char) result));
                    break;
                case 1:
                    result = Math.round(Math.random() * 25 + 97);
                    sb.append(String.valueOf((char) result));
                    break;
                case 2:
                    sb.append(String.valueOf(new Random().nextInt(10)));
                    break;
            }
        }
        return sb.toString();
    }
}
