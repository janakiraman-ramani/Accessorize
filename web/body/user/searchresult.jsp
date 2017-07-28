<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <sj:head jqueryui="true" />

<div class="w3-card-4 w3-red w3-margin-bottom" style="width: 50%">
    
    <div class="w3-container w3-red">
        <s:form id="formSelectReload" action="listproduct">
            <s:url id="remoteurl" action="jsonsample" namespace="/"/>
                <sj:select label="Category" href="%{remoteurl}" id="category" onChangeTopics="reloadsecondlist" name="category1"
                                list="categorylist" listKey="categoryid" listValue="name" emptyOption="false"
                                headerKey="-1" headerValue="Please Select a Category"/>
    </div>            
    <div class="w3-container w3-red w3-margin-top">            
            <s:url id="remoteurl" action="jsonsample" namespace="/"/>
                <sj:select label="Sub Category" href="%{remoteurl}" id="subcategoryID" onChangeTopics="reloadThirdlist" formIds="formSelectReload"
                                reloadTopics="reloadsecondlist" name="subcategory" 
                                list="subcategorylist" listKey="subcategoryid" listValue="name" emptyOption="false"
                                headerKey="-1" headerValue="Please Select a Sub category"/>
    </div>            
    <div class="w3-container w3-red w3-margin-top">                
            <s:url id="remoteurl" action="jsonsample" namespace="/"/>
                <sj:select label="Super Category" href="%{remoteurl}" id="subcategory1" formIds="formSelectReload" reloadTopics="reloadThirdlist"
                                name="subcategory1" list="subcategory1list" emptyOption="false" listKey="subcategory1id" listValue="name"
                                headerKey="-1" headerValue="Please Select a Super Category" />
            
    </div>
    <div class="w3-container w3-black w3-margin-0">
        <s:submit cssClass="w3-btn w3-margin" value="Search" align="center"/>
    </s:form>
    </div>
</div>
    
<div class="w3-container w3-margin-top" style="width: 15%">
        <a class="w3-btn w3-center" href="<s:url action="viewcart"/>">Show Cart <i class="fa fa-cart-arrow-down"></i></a>
    </div>
<div class="w3-container w3-white" style="width: 45%">
        <p>Search Results <i class="fa fa-search"></i></p>
    </div>
    
<div class="w3-container w3-margin-top" style="width: 50%">
    
            <s:iterator value="#session.searchresult">
            <table class="w3-table-all w3-margin-0" style="width: 100%">
                <tr><td rowspan="4"><a href="productdetail?productid=<s:property value="productid"/>"><center><img src="<s:url action="proPic?productid=%{productid}"/>" height="150" width="130"/></center></a></td>
                <td><strong>Title: </strong><s:property value="name"/></td></tr>  
                <tr><td><strong>Price: </strong>Rs.<s:property value="price"/>/-</td></tr>
                <tr><td><strong>Stock: </strong><s:property value="stock"/></td></tr>    
                <tr><s:if test="%{#session.verified=='no'}">
                    <td><a href="#" class="w3-btn w3-disabled w3-green">Add To Cart</a><a href="saddwishlist?productid=<s:property value="productid"/>" class="w3-btn w3-green">Add to Wishlist</a></td>
                    </s:if>
                    <s:elseif test="%{#session.verified=='yes'}">
                    <td><a href="saddcart?productid=<s:property value="productid"/>" class="w3-btn w3-green">Add To Cart</a> <a href="saddwishlist?productid=<s:property value="productid"/>" class="w3-btn w3-green">Add to Wishlist</a></td>
                    </s:elseif>
                </tr>
            </table>
            </s:iterator>
    </div>