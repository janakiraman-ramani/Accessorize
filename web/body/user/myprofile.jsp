<%@taglib prefix="s" uri="/struts-tags" %>

<div class="w3-card-4 w3-white w3-margin-0 w3-center" style="width: 50%">
    <div class="w3-container ">
     <h2 class="w3-red w3-text-white w3-padding-large"><i class="fa fa-user fa-fw w3-margin-right w3-xxlarge w3-text-white"></i>My Profile</h2>
    </div>
    
    <table class="w3-table w3-white w3-striped">
        <tr><th>Name</th><td><s:property value="name"/></td></tr>
        <tr><th>Address</th><td><s:property value="address"/></td></tr>
        <tr><th>City</th><td><s:property value="city"/></td></tr>
        <tr><th>Phone</th><td><s:property value="phone"/></td></tr>
        <tr><th>E-mail</th><td><s:property value="email"/></td></tr>     
    </table>
    
    <div class="w3-container w3-center">
        <a href="updateinfo" class="w3-btn w3-green">Update Info</a>
    </div>
</div>
    
    
