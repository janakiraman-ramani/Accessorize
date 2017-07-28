<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <sj:head jqueryui="true" />

    
<div class="w3-card-4 w3-light-grey" style="width: 40%">
    <div class="w3-container w3-red">
        <h3>Product Information</h3>
    </div>
    <div class="w3-container w3-light-grey w3-margin">
        <s:form id="formSelectReload" action="insertProduct" enctype="multipart/form-data">
            <s:textfield name="name" label="Name"/>
            <s:textfield name="brand" label="Brand"/>
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
                
            <s:url id="remoteurl" action="jsonsample" namespace="/"/>
                <sj:select label="Colour" href="%{remoteurl}" id="colourid" formIds="formSelectReload"
                                name="colour" list="colourlist" emptyOption="false" listKey="colourid" listValue="name"
                                headerKey="-1" headerValue="Please Select a Colour"/>
            <s:textfield name="price" label="Price (in Rs.)"/>
            <s:textfield name="stock" label="Stock"/>
            <s:textarea rows="3" name="description" label="Description"/>
            <s:file name="photo" label="Upload Image"/>
            <s:submit cssClass="w3-btn w3-red w3-margin" value="Add Product" align="center"/>
            <a class="w3-btn w3-red w3-margin" href="<s:url action="adminhomeLink"/>">Back To Admin Home</a>
        </s:form>
            
            
            <s:form id="formSelectReload" action="jsonsample">
                    
                    
            </s:form>
    </div>
    <s:if test="(#request.productid!=null)">
    <div class="w3-container w3-white w3-center ">
        <p>_Product Added in the Database <strong>Product ID:</strong>${requestScope.productid}</p>
    </div>
    </s:if>
</div>
