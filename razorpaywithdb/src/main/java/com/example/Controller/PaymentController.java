package com.example.Controller;


import java.util.Base64;
import java.util.Map;
import java.util.UUID;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.razorpay.*;
import com.example.entity.PaymentOrder;
import com.example.repository.PaymentRepo;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

	@Value("${razorpay.key.id}")
	private String keyId;
	@Value("${razorpay.key.secret}")
	private String keySecret;
	
		private final PaymentRepo paymentrepo;
		
		public PaymentController(PaymentRepo paymentrepo) {
			this.paymentrepo = paymentrepo;
		}
		
		
		@PostMapping("/create-order")
		public String createOrder(@RequestParam int amount) throws RazorpayException{
			
			RazorpayClient client=new RazorpayClient(keyId,keySecret);
			
			JSONObject obj=new JSONObject();
			obj.put("amount",amount*100);
			obj.put("currency","INR");
			String receiptId="txn_"+UUID.randomUUID();
			obj.put("receipt",receiptId);
			Order order = client.orders.create(obj);
			
			PaymentOrder payord=new PaymentOrder();
			payord.setOrderId(order.get("id"));
			payord.setAmount(amount*100);
			payord.setStatus("created");
			payord.setReceiptId(receiptId);
			payord.setCurrency("INR");
			
			paymentrepo.save(payord);
			return order.toString();
		} 
		
		@PostMapping("/verify-payment")
		public String verifyPayment(@RequestBody Map<String,String> data)throws Exception{
			String orderId = data.get("razorpay_order_id");
	        String paymentId = data.get("razorpay_payment_id");
	        String signature = data.get("razorpay_signature");

	        Mac mac = Mac.getInstance("HmacSHA256");
	        mac.init(new SecretKeySpec(keySecret.getBytes(), "HmacSHA256"));
	        byte[] hashBytes = mac.doFinal((orderId + "|" + paymentId).getBytes());
	        String generatedSignature = new String(Base64.getEncoder().encode(hashBytes));

	        if (generatedSignature.equals(signature)) {
	            PaymentOrder paymentOrder = paymentrepo.findByOrderId(orderId);
	            if (paymentOrder != null) {
	                paymentOrder.setStatus("paid");
	                paymentOrder.setPaymentId(paymentId);
	                paymentrepo.save(paymentOrder);
	            }
	            return "Payment Verified Successfully!";
	        } else {
	            return "Payment Verification Failed!";
	        }
			
			
			
		}
	
		
}
		
		

