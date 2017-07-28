<%@taglib prefix="s" uri="/struts-tags" %>

<div class="w3-card-4" style="width: 50%">
<table class="w3-table w3-white w3-striped">
        <tr>
                <th>Name</th>
                <th>Price</th>
                <th> </th>
            </tr>
        <s:iterator value="#session.products">
            <tr>
                <td><s:property value="name"/></td>
                <td><s:property value="price"/></td>
                <td><a href="deleteProduct?productid=<s:property value="productid"/>" class="w3-btn w3-red">Delete</a></td>
            </tr>
        </s:iterator>
            <tr>
            <a class="w3-center w3-btn" href="<s:url action="admindeleteLink"/>">Select Another Category</a></tr>
</table>
</div>
    
    
