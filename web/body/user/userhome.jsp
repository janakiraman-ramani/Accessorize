<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <sj:head jqueryui="true" />

<div class="w3-card-4 w3-light-grey">
    <div class="w3-container w3-black">
        <h3>Welcome To The Accessorize <i class="fa fa-shopping-bag"></i></h3>
    </div>
    <div class="w3-container w3-padding-32 " >
        <p>Bookworm is a young and vibrant company that aims to provide good and highly popular,trending and handpicked variety of items. It caters to the fashion needs of men, women and kids.</p>
    </div>
    <div class="w3-container w3-padding-32 " style="width: 40%">
        <s:form id="formSelectReload" action="listproduct">
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
                                headerKey="-1" headerValue="Please Select a Super Category" />
            
            <s:submit cssClass="w3-btn w3-red w3-margin" value="List Product" align="center"/>
            
        </s:form>
   </div>
</div>