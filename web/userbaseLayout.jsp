<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
   
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" /></title>
<style>
    body {
    background-image: url("images/homebg.jpg");
    }
    .errorMessage{color:red;}  
    
</style>
</head>
<body>
    <table border="1" align="center" width="100%">
        <tr style="height: 20%"><td><tiles:insertAttribute name="header" /></td></tr>
        <tr align="center" style="height: 80%"><td><tiles:insertAttribute name="body"/></td></tr>
        <footer>    
            <tr><td><tiles:insertAttribute name="footer" /></td></tr>
        </footer>
</table>
</body>
</html>