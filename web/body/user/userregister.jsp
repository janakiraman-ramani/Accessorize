<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="botDetect" uri="https://captcha.com/java/jsp"%>
<link rel="stylesheet" href="css/w3.css"/>
<div class="w3-card-8 w3-border-4" style="width: 40%">
    <div class="w3-container w3-blue-grey w3-padding-4">
        <h3>Create New Account <i class="fa fa-user-plus"></i></h3>
    </div>
    <div class="w3-container w3-white">
            <p>&nbsp;</p>
            <table class="w3-table">
                <s:form action="userregister">
                    <tr><td colspan="2"><s:textfield name="username" label="User-Name"/></td></tr>
                    <tr><td colspan="2"><s:textfield name="email" label="E-Mail"/></td></tr>
                    <tr><td colspan="2"><s:password name="password" label="Password"/></td></tr>
                    <tr><td colspan="2"><s:password name="repassword" label="Confirm Password"/></td></tr>
                    <tr><td colspan="2"><s:textfield name="address" label="Address"/></td></tr>
                    <tr><td colspan="2"><s:textfield name="city" label="City"/></td></tr>
                    <tr><td colspan="2"><s:textfield name="phone" label="Phone No."/></td></tr>
                    <tr><td><s:textfield name="captchaCode" id="captchaCode" label="Enter the Captcha Text"/></td></tr>
                    <tr><td></td><td><s:submit cssClass="w3-btn w3-blue-grey w3-margin-bottom w3-margin-top" value="Create Account" id="submit"/></td></tr>
                
            </table>
                    <botDetect:captcha id="exampleCaptcha" userInputID="captchaCode"/>
                </s:form>
    </div>