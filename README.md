# paypalDemo
paypal支付对接demo
采用 js sdk + restApi形式

1、普通checkout button支付
http://localhost:8080/1.html

2、vault-payment-methods
接口地址：https://developer.paypal.com/limited-release/vault-payment-methods/vault-api

1、将paypal账户保存为vault
http://localhost:8080/paypal_to_vault?customerId=xxxx
2、将信用卡保存为vault
http://localhost:8080/card_to_vault?customerId=xxxx

退款接口
https://localhost:8080/refundOrder?captureId=


注：
sandbox测试通过后
如果测试正式信用卡支付接口，已经要放服务部署到正式服务器，并添加企业级ssl证书，不然会触发银行防诈骗风控，导致支付被阻止
