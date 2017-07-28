<%@taglib prefix="s" uri="/struts-tags"%>
<div class="w3-card-8 w3-border-4" style="width: 40%">
   
    <div class="w3-container w3-blue-grey w3-padding-4">
    
        <h3>Verify Mail</h3>
    
    </div>
    
    <div class="w3-container w3-white">
        <p>&nbsp;</p>
        <a href="sendotp" class="w3-btn w3-blue-grey">Send OTP via Mail</a>
    </div>
    
    <div class="w3-container w3-white">
        
        <p>${requestScope.msg}</p>
    </div>
    
    <div class="w3-container-8 w3-white">
            <table class="w3-table">
            <s:form action="verify">
                <tr><td><s:textfield name="otpfinal" label="Enter One-Time Password"/></td></tr>
                <tr><td colspan="2"><s:submit cssClass="w3-btn w3-blue-grey" value="Verify"/></td></tr>
            </s:form>
            </table>
    </div>
</div> 