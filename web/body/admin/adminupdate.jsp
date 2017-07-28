<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <sj:head jqueryui="true" />
    
<div class="w3-card-4 w3-light-grey" style="width: 40%">
    <div class="w3-container w3-red">
        <h3>Update Product</h3>
    </div>
    <div class="w3-container w3-light-grey w3-margin">
        <s:form id="formSelectReload" action="gtpro_update">
            
            <s:url id="remoteurl" action="jsonsample" namespace="/"/>
                <sj:select label="Category" href="%{remoteurl}" id="category" onChangeTopics="reloadsecondlist" name="category1"
                                list="categorylist" listKey="categoryid" listValue="name" emptyOption="false"
                                headerKey="-1" headerValue="Please Select a Category"/>
                
                 
            <s:url id="remoteurl" action="jsonsample" namespace="/"/>
                <sj:select label="Sub Category" href="%{remoteurl}" id="subcategoryID" onChangeTopics="reloadThirdlist" formIds="formSelectReload"
                                reloadTopics="reloadsecondlist" name="subcategory" 
                                list="subcategorylist" listKey="subcategoryid" listValue="name" emptyOption="false"
                                headerKey="-1" headerValue="Please Select a Sub category"/>
                
                    
            <s:url id="remoteurl" action="jsonsample" namespace="/"/>
                <sj:select label="Super Category" href="%{remoteurl}" id="subcategory1" formIds="formSelectReload" reloadTopics="reloadThirdlist"
                                name="subcategory1" list="subcategory1list" emptyOption="false" listKey="subcategory1id" listValue="name"
                                headerKey="-1" headerValue="Please Select a Super Category"/>
                
            <s:submit cssClass="w3-btn w3-red w3-margin" value="List Products" align="center"/>
        </s:form>
        <a class="w3-btn w3-red w3-margin w3-center" href="<s:url action="adminhomeLink"/>"/>Back to Admin Home</a>
    </div>
    <div class="w3-container w3-red">
        <h3>${requestScope.msg}</h3>
    </div>
</div>