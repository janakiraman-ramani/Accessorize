<%@taglib prefix="s" uri="/struts-tags" %>
 
<div class="w3-card-4" style="width: 50%">
    <div class="w3-container w3-red">
        <h3>Your Shopping Cart</h3>
    </div>
    <table class="w3-table w3-white w3-striped">
        <th>Picture</th>
        <th>Name</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Total</th>
        <th>Option</th>
    </tr>
   
    <s:iterator value="items" var="product">
    <tr>
        <td><a href="productdetail?productid=<s:property value="productid"/>"><center><img src="<s:url action="proPic?productid=%{key.productid}"/>" height="80" width="70"/></center></a></td>
        <td><s:property value="key.name"/></td>
        <td>Rs. <s:property value="key.price"/></td>
        <td><s:property value="value"/></td>
        <td>Rs. ${key.price * value}</td>
        <td><a href="deletecart?productid=<s:property value="key.productid"/>" class="w3-btn w3-green">Delete from Cart</a></td>
    <tr>
    </s:iterator>
    </table>


<div class="w3-container w3-light-grey w3-right">
    <h5><strong>Total:</strong> Rs. <s:property value="total"/></h5>
</div>

<div class="w3-container w3-light-grey w3-padding">
        <a class="w3-btn" href="<s:url action="userhome1Link"/>">Continue Shopping</a>
        <s:form action="stockcheck">
        <s:submit cssClass="w3-btn" value="Checkout" id="submit"></s:submit>
        
        </s:form>
    <div class="w3-container w3-light-grey">
        <p>${requestScope.na}</p>
    </div>
</div>    
