<!DOCTYPE html>

<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>

	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="keywords" content="footer, address, phone, icons" />

	<title>Footer With Address And Phones</title>

	<link rel="stylesheet" href="css/demo.css">
	<link rel="stylesheet" href="css/footer-distributed-with-address-and-phones.css">
	
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">

	<link href="http://fonts.googleapis.com/css?family=Cookie" rel="stylesheet" type="text/css">

</head>
<body>
    <footer class="footer-distributed">
        <div class="footer-left">
            <h3><span>the</span>Accessorize<span>.com</span></h3>
            <s:if test="(#session.name)==null">
            <p class="footer-links">
                <a href="<s:url action="adminloginLink"/>">Admin Section</a>
            </p>
            </s:if>
            <p class="footer-company-name">Company Name &copy; 2015</p>
            <p class=""footer-links">
               <image src="images\cc-dc.db82f51f2765.jpg" width="150px" height="70px"/>
            </p>
        </div>
        <div class="footer-center">
            <div>
            <i class="fa fa-support"></i>
            <p><a href="<s:url action="feedbackLink"/>">Queries? Give us your Feedback</a></p>
	</div>
        <div>
            <i class="fa fa-map-marker"></i>
            <p><a href="http://maps.google.com/?q=NBCC+VIBGYOR+TOWER"<span>Newtown, ZIP-700156</span> Kolkata, India</a></p>
	</div>
        <div>
            <i class="fa fa-phone"></i>
            <p>+91 7278268191</p>
	</div>

				<div>
					<i class="fa fa-envelope"></i>
					<p><a href="mailto:support@company.com">rahulvirus100@gmail.com</a></p>
				</div>

			</div>

			<div class="footer-right">

				<p class="footer-company-about">
					<span>About the company</span>
					Accessorize is a young and vibrant company that aims to provide good service. It caters to the fashion needs of men and women.
				</p>

				<div class="footer-icons">

					<a href="#"><i class="fa fa-facebook"></i></a>
					<a href="#"><i class="fa fa-twitter"></i></a>
					<a href="#"><i class="fa fa-linkedin"></i></a>
					<a href="#"><i class="fa fa-github"></i></a>

				</div>

			</div>

		</footer>

	</body>

</html>
