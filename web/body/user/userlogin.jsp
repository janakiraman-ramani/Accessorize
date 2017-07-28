<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="botDetect" uri="https://captcha.com/java/jsp"%>
<div class="w3-card-8 w3-border-4" style="width: 40%">
    <div class="w3-container w3-blue-grey w3-padding-4">
        <h3>Log-In Here <i class="fa fa-sign-in"></i></h3>
    </div>
    <div class="w3-container w3-white">
        <p>${requestScope.msg}</p>
    </div>
    <div class="w3-container w3-white">
            <p>&nbsp;</p>
            <table class="w3-table">
                <s:form action="logging">
                
                <tr><td colspan="2"><s:textfield name="id" label="User-ID"/></td></tr>
                <tr><td colspan="2"><s:password name="password" label="Password "/></td></tr>
                <tr><td><s:textfield name="captchaCode" id="captchaCode" label="Enter the Captcha Text"/></td></tr>
                <tr><td></td><td><s:submit cssClass="w3-btn w3-blue-grey" value="Go" id="submit"/></td></tr>
                <tr><td></td></tr>
                <tr><td style="text-align: left"><div class="w3-small w3-padding-4 w3-margin-bottom">Forgot Password or User ID? <a href="forgotLink">Click Here</a></div></td>
                    <td style="text-align: right"><div class="w3-small w3-padding-4 w3-margin-bottom">Not Registered Yet? <a href="userregisterLink">Register Yourself</a></div></td></tr>
                
            </table>
            <botDetect:captcha id="exampleCaptcha" userInputID="captchaCode"/>
            </s:form>
    </div>
</div>