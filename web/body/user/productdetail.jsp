<%@taglib prefix="s" uri="/struts-tags" %>

<div class="w3-card-4 w3-white w3-margin-0 w3-center" style="width: 50%">
    <div class="w3-container w3-blue">
     <h2 class="" w3-text-white w3-padding-large"><i class="fa fa-lightbulb-o fa-fw w3-margin-right w3-xxlarge w3-text-white"></i>Product Details</h2>
    </div>
    
    <table class="w3-table w3-white w3-striped">
        <tr><td colspan="2"><center><img src="<s:url action="proPic?productid=%{productid}"/>" height="250" width="210"/></center></a></td></tr>
        <tr><th>Name</th><td><s:property value="productdetail.name"/></td></tr>
        <tr><th>Brand</th><td><s:property value="productdetail.brand"/></td></tr>
        <tr><th>Description</th><td><s:property value="productdetail.description"/></td></tr>
        <tr><th>Category</th><td><s:property value="productdetail.subcategory1.subcategory.category.name"/> -> <s:property value="productdetail.subcategory1.subcategory.name"/> -> <s:property value="productdetail.subcategory1.name"/></td></tr>
        <tr><th>Price</th><td>Rs. <s:property value="productdetail.price"/>/-</td></tr>     
        <tr><th>Stock</th><td><s:property value="productdetail.stock"/></td></tr>
        <tr><th>Colour</th><td><s:property value="productdetail.colour.colourid"/></td></tr>
    </table>
    
    <div class="w3-container w3-center">
        <s:if test="%{(#session.verified=='yes')&&(#session.name!=null)}">
        <a href="paddcart?productid=<s:property value="productid"/>" class="w3-btn w3-green">Add to Cart <i class="fa fa-cart-plus"></i></a>
        <a href="paddwishlist?productid=<s:property value="productid"/>" class="w3-btn w3-green">Add to Wishlist <i class="fa fa-heart-o"></i></a>
        </s:if>
        <s:elseif test="%{ (#session.verified=='no') && (#session.name!=null) }">
        <a href="#" class="w3-btn w3-green w3-disabled">Add to Cart <i class="fa fa-cart-plus"></i></a>
        <a href="paddwishlist?productid=<s:property value="productid"/>" class="w3-btn w3-green">Add to Wishlist <i class="fa fa-heart-o"></i></a>
        </s:elseif>
        <s:else>
        <a href="#" class="w3-btn w3-green w3-disabled">Add to Cart <i class="fa fa-cart-plus"></i></a>
        <a href="#" class="w3-btn w3-green w3-disabled">Add to Wishlist <i class="fa fa-heart-o"></i></a>
        </s:else>
    </div>
</div>
    <div class="w3-card-4 w3-margin-top w3-center" style="width: 20%">
        <div class="w3-container w3-black">
            <h3>Avg. Rating - <s:property value="avg"/>/5 <i class="fa fa-star"></i></h3>
        </div>
    </div>
    
    <div class="w3-card-4 w3-white w3-margin-top w3-center" style="width: 50%">
        
        <div class="w3-container w3-blue w3-left-align">
            <h3>Reviews & Comments <i class="fa fa-twitter"></i></h3>
        </div>
        
        <s:iterator value="comments">
        <div class="w3-container w3-white w3-left-align">
            <p><strong><s:property value="customer.name"/></strong> - <strong><s:property value="time"/></strong> <strong><s:property value="rating"/></strong></p>
            <p class="w3-light-grey"><s:property value="title"/> : <s:property value="body"/></p>
        </div>
        </s:iterator>
        
    </div>
    <div class="w3-card-4 w3-light-grey w3-margin-top w3-center" style="width: 50%">
         <div class="w3-container w3-blue w3-left-align">
            <h3>Give us your thoughts <i class="fa fa-twitter"></i></h3>
        </div>
            <table class="w3-table w3-white w3-striped w3-margin-top">
            <s:form action="submitcomment?productid=%{productid}">
               
                <tr><td colspan="2"><s:textfield cssClass="w3-input" label="Subject" name="title"/></td></tr>
                <tr><td colspan="2"><s:textarea cssClass="w3-input w3-margin-top" rows="3" label="Share us your Experience" name="body"/></td></tr>
                <tr><td colspan="2"><s:select cssClass="w3-select w3-margin-top" label="Your Rating" name="rating" list="{'1.0','2.0','3.0','3.5','4.0','4.5','5.0'}"/></td></tr>
                
            
                <s:if test="%{#session.verified=='yes'}">
                    <tr><td></td><td><s:submit cssClass="w3-btn w3-red w3-margin" value="Submit" align="center"/></td></tr>
                </s:if>
                <s:else>
                    <tr><td></td><td style="text-align: left"><a href="#" class="w3-btn w3-margin-top w3-disabled w3-green">Submit</a></td></tr>
                </s:else>
            </s:form>
            </table>
       
    </div>
    
