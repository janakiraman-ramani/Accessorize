<%@taglib prefix="s" uri="/struts-tags" %>

<div class="w3-card-4 w3-white w3-margin-0 w3-center" style="width: 100%">
          <div class="w3-container ">
          <h2 class="w3-red w3-text-white w3-padding-large"><i class="fa fa-suitcase fa-fw w3-margin-right w3-xxlarge w3-text-white"></i>My Orders</h2>
      </div>
          
    <div class="w3-card-4 w3-border-top w3-center">
                <s:iterator value="myorder">
                    <table class="w3-table w3-border-4 w3-padding-4 w3-black w3-text-white">
                    <tr><td><strong>Order #: </strong><s:property value="orderformid"/></td>
                    <td><strong>Order Date: </strong><s:property value="orderdate"/></td>
                    <td><strong>Status: </strong><s:property value="status"/></td>
                    <td><strong>Payment ID: </strong><s:property value="payment_id"/></td></tr>
                    <tr><td><strong>Payment Method: </strong><s:property value="paymethod"/></td></tr>
                    </table>
                    <s:iterator value="orderitems">
                    <table class="w3-table-all w3-border-4">
                    <tr>
                        <td rowspan="5"><a href="productdetail?productid=<s:property value="product.productid"/>"><center><img src="<s:url action="proPic?productid=%{product.productid}"/>" height="130" width="100"/></center></a>
                        </td>
                    </tr>
                    <tr><td><strong>Product ID: </strong><s:property value="orderitemid"/><s:property value="product.productid"/></tr></td>
                    <tr><td><strong>Name: </strong><s:property value="product.name"/></tr></td>
                    <tr><td><strong>Quantity: </strong><s:property value="quantity"/></tr></td>
                    <tr><td><strong>Per Unit Price: </strong>Rs.${product.price}/- </tr></td>
                    </table>
                    </s:iterator>
                    <table class="w3-table w3-right-align">
                        <tr><strong><strong>Total Price: </strong><s:property value="total"/></td>
                    </strong></tr>
                    </table>
                    
                </s:iterator>
              </table>
      </div>
    </div>

  

