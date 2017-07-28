<%@taglib prefix="s" uri="/struts-tags" %>
<link rel="stylesheet" href="css/w3.css"/>
<div class="w3-card-8 w3-border-4">
    <div class="w3-container w3-blue-grey">
        <h3>Welcome ${sessionScope.adminname}</h3>
    </div>
    <table class="w3-table w3-white">
        <tr>
            <td class="w3-center"><a href="<s:url action="admininsertLink"/>">INSERT</a></td>
            <td class="w3-center"><a href="<s:url action="adminupdateLink"/>">UPDATE</a></td>
            <td class="w3-center"><a href="<s:url action="admindeleteLink"/>">DELETE</a></td>
            <td class="w3-center"><a href="#">SEE ALL COMMENTS</a></td>
            <td class="w3-center"><a href="adminView">VIEW LIBRARY</a></td>
            <td class="w3-center"><a href="allorder">VIEW ALL ORDERS</a></td>
        </tr>
    </table>
</div>