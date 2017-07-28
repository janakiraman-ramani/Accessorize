<%@taglib prefix="s" uri="/struts-tags"%>
<div class="w3-card-8 w3-border-4" style="width: 40%">
   
    <div class="w3-container w3-blue-grey w3-padding-4">
    
        <h3>Forgot Password?</h3>
    
    </div>
    
    
    
    <div class="w3-container-8 w3-white">
            <table class="w3-table">
            <s:form action="forgotpassmail">
                <tr><td><s:textfield name="email" label="Enter Your Email"/></td></tr>
                <tr><td colspan="2"><s:submit cssClass="w3-btn w3-blue-grey" value="Submit"/></td></tr>
            </s:form>
            </table>
    </div>
</div> 