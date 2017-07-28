
package com.instamojo.wrapper.api;

import com.action.CartMain;
import com.datamodel.Customer;
import com.instamojo.wrapper.api.Instamojo;
import com.instamojo.wrapper.api.InstamojoImpl;
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
import com.instamojo.wrapper.util.Constants;
import com.opensymphony.xwork2.ActionSupport;
import com.utilities.HibernateUtil;
import com.utilities.SendEmail;
import java.util.Map;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Session;

public class InstaPay extends ActionSupport implements SessionAware 
{

	private static final Logger LOGGER = Logger.getLogger(InstaPay.class.getName());
        private String targetUrl;
	private SessionMap session;
        
        public String execute() 
        {
            String txnid=SendEmail.generateTxnId();
            CartMain cart = (CartMain) session.get("mycart1");
            Float tot=new Float(cart.getTotalPrice());
            
            Double total=new Double(tot.toString());
            Integer uid=(Integer)session.get("id");
            Session s=HibernateUtil.getSessionFactory().openSession();
            Customer customer=(Customer)s.get(Customer.class,uid);
            
                 //Create a new payment order **************************************
            PaymentOrder order = new PaymentOrder();
            order.setName(customer.getName());
            order.setEmail(customer.getEmail());
            order.setPhone(customer.getPhone());
          
            order.setCurrency("INR");
            order.setAmount(total);
            order.setDescription("Payment to accessorize.com");
            order.setRedirectUrl("http://localhost:8084/Accessorize/checkout");
            order.setTransactionId(txnid);
            Instamojo api = null;

            try 
            {
		// gets the reference to the instamojo api
			
		api = InstamojoImpl.getApi("tekNmmUe4tjTTXkVx2khdYtT4HNjO79PoQjYHZm3","6uH2WExYLb43ggnGI9heLv4Rq9D12Iu5ninMy9qCQutnF9qRhwxye2l8Sjoji1UK9xbgpM0EJtydRhptRCJi97idOovloDbn2gDUYD89XP7SMPzhmpPjXzIh93VsGg7F",Constants.INSTAMOJO_API_ENDPOINT,Constants.INSTAMOJO_AUTH_ENDPOINT);
		
            } catch (ConnectionException e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}

            boolean isOrderValid = order.validate();

            if (isOrderValid) {
		try {
			
                    CreatePaymentOrderResponse createPaymentOrderResponse = api.createNewPaymentOrder(order);
                        System.out.println(createPaymentOrderResponse.getPaymentOrder().getId());
                        String pid= createPaymentOrderResponse.getPaymentOrder().getId();
                        
                        String targetUrl1= "https://test.instamojo.com/@rahulvirus100/";
                        targetUrl=targetUrl1.concat(pid);
		} 
                catch (InvalidPaymentOrderException e) 
                {
			LOGGER.log(Level.SEVERE, e.toString(), e);

                        if (order.isTransactionIdInvalid()) 
                        {
                            System.out.println("Transaction id is invalid. This is mostly due to duplicate transaction id.");
			}
			if (order.isCurrencyInvalid()) 
                        {
                            System.out.println("Currency is invalid.");
			}
		} 
                
                catch (ConnectionException e) 
                {
			LOGGER.log(Level.SEVERE, e.toString(), e);
			}
		} else {
			// inform validation errors to the user.
			if (order.isTransactionIdInvalid()) {
				System.out.println("Transaction id is invalid.");
			}
			if (order.isAmountInvalid()) {
				System.out.println("Amount can not be less than 9.00.");
			}
			if (order.isCurrencyInvalid()) {
				System.out.println("Please provide the currency.");
			}
			if (order.isDescriptionInvalid()) {
				System.out.println("Description can not be greater than 255 characters.");
			}
			if (order.isEmailInvalid()) {
				System.out.println("Please provide valid Email Address.");
			}
			if (order.isNameInvalid()) {
				System.out.println("Name can not be greater than 100 characters.");
			}
			if (order.isPhoneInvalid()) {
				System.out.println("Phone is invalid.");
			}
			if (order.isRedirectUrlInvalid()) {
				System.out.println("Please provide valid Redirect url.");
			}

			if (order.isWebhookInvalid()) {
                System.out.println("Provide a valid webhook url");
            }
		}



		
                return "foo";
                
                
	}

    public String getTargetUrl() {
        return targetUrl;
    }

    public void setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl;
    }
        public void setSession(Map<String, Object> map) 
    {
        session=(SessionMap)map;
    }
        
}

