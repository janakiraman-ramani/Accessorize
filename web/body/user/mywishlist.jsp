<%@taglib prefix="s" uri="/struts-tags" %>
<div class="w3-card-4 w3-white w3-margin-0 w3-center" style="width: 50%">
    
    <div class="w3-container ">
          <h2 class="w3-red w3-text-white w3-padding-large"><i class="fa fa-heart fa-fw w3-margin-right w3-xxlarge w3-text-white"></i>My Wishlist</h2>
    </div>
    
    <div class="w3-container w3-margin-top">
            <s:iterator value="wishlist">
            <table class="w3-table-all w3-margin-0">
                <tr><td rowspan="4"><a href="productdetail?productid=<s:property value="product.productid"/>"><center><img src="<s:url action="proPic?productid=%{product.productid}"/>" height="150" width="130"/></center></a></td>
                <td><strong>Title: </strong><s:property value="product.name"/></td></tr>  
                <tr><td><strong>Price: </strong>Rs.<s:property value="product.price"/>/-</td></tr>
                <tr><td><strong>Stock: </strong><s:property value="product.stock"/></td></tr>    
                <tr><s:if test="%{#session.verified=='no'}">
                    <td><a href="#" class="w3-btn w3-disabled w3-green">Add To Cart</a></td>
                    </s:if>
                    <s:elseif test="%{#session.verified=='yes'}">
                    <td><a href="addcartwish?productid=<s:property value="product.productid"/>" class="w3-btn w3-green">Add To Cart</a> <a href="removewishlist?wishlistid=<s:property value="wishlistid"/>" class="w3-btn w3-green">Remove from Wishlist</a></td>
                    </s:elseif>
                </tr>
            </table>
            </s:iterator>
    </div>
    </div>