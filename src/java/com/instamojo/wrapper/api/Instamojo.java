package com.instamojo.wrapper.api;

import com.instamojo.wrapper.exception.ConnectionException;
import com.instamojo.wrapper.exception.InvalidPaymentOrderException;
import com.instamojo.wrapper.exception.InvalidRefundException;
import com.instamojo.wrapper.model.PaymentOrder;
import com.instamojo.wrapper.model.PaymentOrderFilter;
import com.instamojo.wrapper.model.Refund;
import com.instamojo.wrapper.response.CreatePaymentOrderResponse;
import com.instamojo.wrapper.response.CreateRefundResponse;
import com.instamojo.wrapper.response.PaymentOrderDetailsResponse;
import com.instamojo.wrapper.response.PaymentOrderListResponse;

public interface Instamojo {

    CreatePaymentOrderResponse createNewPaymentOrder(PaymentOrder paymentOrder) throws ConnectionException, InvalidPaymentOrderException;

    PaymentOrderDetailsResponse getPaymentOrderDetails(String id) throws ConnectionException;

    PaymentOrderDetailsResponse getPaymentOrderDetailsByTransactionId(String transactionId) throws ConnectionException;

    PaymentOrderListResponse getPaymentOrderList(PaymentOrderFilter paymentOrderFilter) throws ConnectionException;
    
    CreateRefundResponse createNewRefund(Refund refund) throws ConnectionException, InvalidRefundException;

}
