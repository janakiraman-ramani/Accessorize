<%@taglib prefix="s" uri="/struts-tags"%>
<link rel="stylesheet" href="css/w3.css">
<link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">

<ul class="w3-navbar w3-padding-tiny w3-light-grey w3-border">
    <s:if test="(#session.adminid)!=null">
    <li>
        <a class="w3-left w3-hover-light-grey" href="<s:url action="adminhomeLink"/>"><img src="images/logo.png" width="160px" height="30px"></a>
    </li>
    </s:if>
    <s:else>
        <li>
        <a class="w3-left w3-hover-light-grey" href="userHome.jsp"><img src="images/logo.png" width="160px" height="30px"></a>
    </li>
    </s:else>
    <s:if test="(#session.adminid)!=null">
        <li class="w3-right">
            <a class="w3-blue w3-btn w3-round-large" href="logOut">Log Out</a>
        </li>
    </s:if>
</ul>