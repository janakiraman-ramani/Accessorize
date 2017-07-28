<%@taglib prefix="s" uri="/struts-tags" %>

<div class="w3-card-4 w3-light-grey" style="width: 40%">
    <div class="w3-container w3-red">
        <h3>Product Information</h3>
    </div>
    <div class="w3-container w3-light-grey w3-margin">
        <s:form action="updateProductfinal">
            <s:textfield cssClass="w3-input" name="productid" label="Product ID" value= "%{productid}" readonly="true"/>
            <s:textfield cssClass="w3-input" name="name" label="Name" value= "%{name}"/>
            <s:textarea cssClass="w3-input" rows="3" name="description" label="Description" value="%{description}"/>
            <s:textfield cssClass="w3-input" name="price" label="Price (in Rs.)" value="%{price}"/>
            <s:textfield cssClass="w3-input" name="stock" label="Stock" value="%{stock}"/>
            <s:submit cssClass="w3-btn w3-red w3-margin" value="Update" align="center"/>
        </s:form>
    </div>
</div>
