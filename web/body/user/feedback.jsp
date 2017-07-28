<%@taglib prefix="s" uri="/struts-tags" %>

<div class="w3-card-4 w3-light-grey w3-margin-0 w3-center" style="width: 50%">
    <div class="w3-container w3-red">
     <h2 class="w3-text-white w3-padding-large"><i class="fa fa-support fa-fw w3-margin-right w3-xxlarge w3-text-white"></i>Queries & Feedback</h2>
    </div>
    
    <table class="w3-table w3-white w3-striped w3-margin-top">
        <s:form action="feedback">
            <tr><td colspan="2"><s:textfield cssClass="w3-input" name="name" label="Your Name"/></td></tr>
            <tr><td colspan="2"><s:textfield cssClass="w3-input w3-margin-top" name="email" label="Your E-mail"/></td></tr>
            <tr><td colspan="2"><s:textarea cssClass="w3-input w3-margin-top" rows="3" name="comments" label="Your Comments"/></td></tr>
            <tr><td></td><td><s:submit cssClass="w3-btn w3-red w3-margin" value="Submit" align="center"/></td></tr>
        </s:form>
    </table>
    
</div>