<%@taglib prefix="s" uri="/struts-tags"%>
<link rel="stylesheet" href="css/w3.css"/>
<div class="w3-card-8 w3-border-4" style="width: 40%">
    <div class="w3-container w3-blue-grey w3-padding-4">
        <h3>Thank You for Registering ${requestScope.new_name}</h3>
    </div>
    <div class="w3-container w3-white">
        <p>Your Login ID is ${requestScope.new_id}</p>
        <p>Use this id to login into the site.Keep it Safe!</p>
        <p>Please use this to login and verify your email in order to enjot quality service</p>
        <p> <a class="w3-btn w3-black w3-margin" href="<s:url action="userloginLink"/>">Back To Login Home</a></p>
    </div>
</div>
