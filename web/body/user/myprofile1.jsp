<%@taglib prefix="s" uri="/struts-tags" %>

<div class="w3-card-4 w3-light-grey" style="width: 50%">
    <div class="w3-container w3-red">
        <h3>Update Profile</h3>
    </div>
    <div class="w3-container w3-light-grey w3-margin">
        <s:form action="updateprofile">
            
            <s:textfield cssClass="w3-input" name="name" label="Name" value= "%{name}"/>
            <s:textfield cssClass="w3-input" name="address" label="Address"  value= "%{address}"/>
            <s:textfield cssClass="w3-input" name="city" label="City"  value= "%{city}"/>
            <s:textarea cssClass="w3-input" rows="3" name="phone" label="Phone" value="%{phone}"/>
            <s:password showPassword="true" cssClass="w3-input" name="password" label="Password" value="%{password}"/>
            <s:textfield cssClass="w3-input" name="email" label="E-mail" value="%{email}"/>
            <s:submit cssClass="w3-btn w3-red w3-margin" value="Update" align="center"/>
        </s:form>
    </div>
</div>