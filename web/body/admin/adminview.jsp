<%@taglib prefix="s" uri="/struts-tags" %>

<div class="w3-card-4" style="width: 50%">
<table class="w3-table w3-white w3-striped">
        <tr>
                <th>Name</th>
                <th>Price</th>
                <th>Category</th>
            </tr>
        <s:iterator value="all">
            <tr>
                <td><s:property value="name"/></td>
                <td><s:property value="price"/></td>
                <td><img src="<s:url action="proPic?productid=%{productid}"/>" height="50" width="50"/></td>
            </tr>
        </s:iterator>
        <a class="w3-btn w3-red w3-margin w3-center" href="<s:url action="adminhomeLink"/>"/>Back to Admin Home</a>
</table>
</div>
    
    
