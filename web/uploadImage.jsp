<%--
  Created by IntelliJ IDEA.
  User: lawrance
  Date: 02/06/21
  Time: 7:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "s" uri = "/struts-tags"%>

<html>
<head>
    <title>Upload your image</title>
</head>
<body>
    <s:form action="uploadImage" method="post" enctype="multipart/form-data">
        <s:label for="myFile">Upload your Image</s:label>
        <s:file name="imageFile"/>
        <s:submit/>
    </s:form>
</body>
</html>
