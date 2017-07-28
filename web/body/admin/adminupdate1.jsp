<%@taglib prefix="s" uri="/struts-tags" %>

<div class="w3-card-4" style="width: 50%">
<table class="w3-table w3-white w3-striped">
        <tr>
                <th>Title</th>
                <th>Price</th>
                <th>Stock</th>
                <th>Option</th>
            </tr>
        <s:iterator value="listproduct">
            <tr>
                <td><s:property value="name"/></td>
                <td><s:property value="price"/></td>
                <td><s:property value="stock"/></td>
                <td><a href="updateProduct?productid=<s:property value="productid"/>" class="w3-btn w3-red">Update Info</a></td>
            </tr>
        </s:iterator>
            <tr>
            <a class="w3-center w3-btn" href="<s:url action="adminupdateLink"/>">Select Another Category</a></tr>
</table>
</div>
    
    
