<%@taglib prefix="s" uri="/struts-tags" %>
 
<div class="w3-card-4 w3-white" style="width: 50%">
    <div class="w3-container w3-red">
        <h3>Pay <i class="fa fa-money"></i></h3>
    </div>
    <div class="w3-container w3-white w3-margin-top">
        <s:form action="paymethod">
        <s:radio cssClass="w3-radio" label="Choose a payment method" name="paymethod" list="{'Cash on Delivery','Pay via Instamojo Online'}"/>
        <s:submit cssClass="w3-btn w3-green" value="submit" name="Submit"/>
        </s:form>
    </div>