package com.instamojo.wrapper.util;

/**
 * The Class Constants.
 */
public class Constants 
{
	private Constants() 
        {
	}
	public static final String INSTAMOJO_API_ENDPOINT = "https://test.instamojo.com/v2/";
	public static final String INSTAMOJO_AUTH_ENDPOINT = "https://test.instamojo.com/oauth2/token/";
	public static final String CLIENT_ID = "client_id";
	public static final String CLIENT_SECRET = "client_secret";
	public static final String GRANT_TYPE = "grant_type";
	public static final String CLIENT_CREDENTIALS = "client_credentials";
	public static final String AUTHORIZATION = "Authorization";
	public static final String TRANSACTION_ID = "transaction_id";
	public static final String WEBHOOK_URL = "webhook_url";
	public static final String CURRENCY = "currency";
	public static final String TYPE = "type";
	public static final String PAYMENT_ORDER_API_PATH = "gateway/orders/";
	public static final String REFUND_API_PATH = "payments/";
}
