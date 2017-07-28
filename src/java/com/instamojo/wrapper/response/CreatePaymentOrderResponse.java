package com.instamojo.wrapper.response;

import com.google.gson.annotations.SerializedName;
import com.instamojo.wrapper.model.PaymentOptions;
import com.instamojo.wrapper.model.PaymentOrder;

public class CreatePaymentOrderResponse extends Response 
{

    private static final long serialVersionUID = -2402922891686730624L;
    
    @SerializedName("order")
    private PaymentOrder paymentOrder;
    
    @SerializedName("payment_options")
    private PaymentOptions paymentOptions;
    
    public PaymentOrder getPaymentOrder() {
        return paymentOrder;
    }
    public void setPaymentOrder(PaymentOrder paymentOrder) {
        this.paymentOrder = paymentOrder;
    }
    public PaymentOptions getPaymentOptions() {
		return paymentOptions;
	}
	public void setPaymentOptions(PaymentOptions paymentOptions) {
		this.paymentOptions = paymentOptions;
	}
	@Override
	public String toString() {
		return "CreatePaymentOrderResponse{" + "paymentOrder=" + paymentOrder +
				", paymentOptions=" + paymentOptions +
				", success=" + success +
				", message='" + message + '\'' +
				", jsonResponse='" + jsonResponse + '\'' +
				'}';
	}
}
