<%@taglib prefix="s" uri="/struts-tags"%>
<div class="w3-card-8 w3-dark-grey" style="width:50%">

<div class="w3-container w3-center">
    <h3>Your Order is Confirmed</h3>
</div>
    <div class="w3-container w3-white w3-center">
        <p>${sessionScope.name}! thank you for using TheBookworm.com</p><br>
        Payment ID : <b><%= request.getParameter("payment_id") %></b><br>
        Payment Request ID :<b><%= request.getParameter("id") %></b><br>
        Transaction ID : <b><%= request.getParameter("transaction_id") %></b><br>
        
        <p>Look Out for your product</p>
    </div>
  <div class="w3-container w3-light-grey w3-padding">
        <a class="w3-btn" href="<s:url action="userhomeLink"/>">Continue Shopping</a>
</div>
</div>
