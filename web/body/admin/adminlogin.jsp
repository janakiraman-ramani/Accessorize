<%@taglib prefix="s" uri="/struts-tags"%>
<link rel="stylesheet" href="css/w3.css"/>
<div class="w3-card-8 w3-border-4" style="width: 40%">
    <div class="w3-container w3-blue-grey w3-padding-4">
    <h3>Administrator Login</h3>
    </div>
    <div class="w3-container w3-white">
            <p>&nbsp;</p>
                <table class="w3-table">
                <s:form action="adminLogin">
                <tr><td colspan="2"><s:textfield cssClass="w3-input" name="id" label="User-ID"/></td></tr>
                <tr><td colspan="2"><s:password cssClass="w3-input" name="password" label="Password "/></td></tr>
                <tr><td></td><td><s:submit cssClass="w3-btn w3-blue-grey w3-margin" value="Go"/></td></tr>
                </s:form>
            </table>
    </div>
    <div class="w3-container w3-white">
        <p>${requestScope.msg}</p>
    </div>
    
    
</div>