<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring_form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<spring_form:form method="POST" action="addAttach" modelAttribute="attach" enctype="multipart/form-data">
<table>
    <tr>
        <th><label for="image">Profile image:</label></th>
        <td><input name="image" type="file"/>
        <td colspan="2">
            <input type="submit" value="Submit"/>
        </td>
    </tr>
</table>
</spring_form:form>
</body>
</html>
