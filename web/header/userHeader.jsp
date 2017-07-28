.<%@taglib prefix="s" uri="/struts-tags"%>
<link rel="stylesheet" href="css/w3.css">
<link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">

<ul class="w3-navbar w3-padding-tiny w3-light-grey w3-border">
    
    <li>
        <a class="w3-left w3-hover-light-grey" href="userHome.jsp"><img src="images/logo.png" width="160px" height="30px"></a>
    </li>
    
    <li class="w3-left">
            <s:form action="search">
            <s:textfield name="searchtext"/>
            <s:submit name="submit" value="Search" align="left"/>
            </s:form>
    </li>
     
    <s:if test="(#session.name)!=null">
        <li class="w3-right w3-margin-left">
            <a class="w3-hover-light-grey" href="#"></a>
        </li>
        <li class="w3-right w3-dropdown-hover w3-hover-red w3-margin-right">
            <a href="#" class="w3-hover-red">Hi! ${sessionScope.name} <i class="fa fa-caret-down"></i></a>
            <div class="w3-padding-0 w3-dropdown-content w3-border">
                <a href="myprofile">My Profile <i class="fa fa-user"></i></a>
                <a href="myorder">My Orders <i class="fa fa-suitcase"></i></a>
                <a href="wishlist">Wishlist <i class="fa fa-heart"></i></a>
                <a href="viewcart">Show Cart <i class="fa fa-cart-plus"></i></a>
                <s:if test="%{#session.verified=='no'}">
                <a href="verifyuserLink" class="w3-hover-red">Verify Email<i class="fa fa-caret-down"></i></a>
                </s:if>
                <a href="logout">Log Out  <i class="fa fa-sign-in"></i></a>
            </div>
        </li>
    </s:if>
    <s:else>
        
        <li class="w3-right w3-margin-left">
            <a class="w3-blue w3-btn w3-round-large" href="<s:url action="userregisterLink"/>">Sign Up</a>
        </li>
        <li class="w3-right">
            <a class="w3-blue w3-btn w3-round-large" href="<s:url action="userloginLink"/>">Sign In</a>
        </li>
    </s:else>
</ul>

