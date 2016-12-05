<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 05.12.2016
  Time: 3:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title><%= I18n.getResource("11") %></title>
</head>

<h2><%= I18n.getResource("12") %></h2>
<br><br>
<form action="j_security_check" method=post>
  <p><strong><%= I18n.getResource("13") %></strong>
    <input type="text" name="j_username" size="25">
  <p><p><strong><%= I18n.getResource("14") %></strong>
  <input type="password" size="15" name="j_password">
  <p><p>
  <input type="submit" value="Submit">
  <input type="reset" value="Reset">
</form>
<%@ page import="com.habit.custom.client.i18n.I18n" %>
</html>
