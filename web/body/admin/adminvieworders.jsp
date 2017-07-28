<%@taglib prefix="s" uri="/struts-tags" %>

<div class="w3-card-4 w3-white w3-margin-0 ">
          <div class="w3-container ">
          <h2 class="w3-red w3-text-white w3-padding-large"><i class="fa fa-suitcase fa-fw w3-margin-right w3-xxlarge w3-text-white"></i>Order's DATABASE</h2>
      </div>
        <div class="w3-card-4 w3-border-top w3-center">
                <s:iterator value="orders">
                    <table class="w3-table w3-border-4 w3-border-black w3-light-blue">
                    <tr><td><strong>Order #: </strong><s:property value="orderformid"/></td>
                    <td><strong>Order Date: </strong><s:property value="orderdate"/></td>
                    <td><strong>Current Status: </strong><s:property value="status"/></td>
                    <td><strong>Change Status: </strong><a href="updatestatus?orderformid=<s:property value="orderformid"/>&status=Processing" class="w3-btn w3-blue-grey">Processing</a></td>
                    <td><a href="updatestatus?orderformid=<s:property value="orderformid"/>&status=Shipped" class="w3-btn w3-blue-grey">Shipped</a></td> 
                    <td><a href="updatestatus?orderformid=<s:property value="orderformid"/>&status=Dispatched" class="w3-btn w3-blue-grey">Dispatched</a></td></tr>
                    
                    <tr><td><strong>Ordered by: </strong><s:property value="customer.name"/></td>
                        <td colspan="5"><strong>Shipping Address: </strong><s:property value="customer.address"/></td>
                    </tr>
                    </table>
                    <s:iterator value="orderitems">
                    <table class="w3-table-all w3-border-4">
                    <tr>
                        <td rowspan="6"><center><img src="<s:url action="proPic?productid=%{product.productid}"/>" height="130" width="100"/></center></td>
                    </tr>
                    <tr><td><strong>Item ID: </strong><s:property value="product.productid"/></td></tr>
                    <tr><td><strong>Title: </strong><s:property value="product.name"/></td></tr>
                    <tr><td><strong>Per Unit Price: </strong>Rs.${product.price}/- </td></tr>
                    <tr><td><strong>Quantity: </strong><s:property value="quantity"/></td></tr>
                    </table>
                    </s:iterator>
                    <table class="w3-table w3-right-align">
                        <tr><strong>Total Price Paid : Rs.</strong><s:property value="total"/></tr>
                    </table>
                    
                </s:iterator>
              </table>
      </div>
</div>
    
    
