<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<html>

<link rel="stylesheet" type="text/css" href="styles/common.css">
<%--<script src="scripts/js_adapter.js"/>--%>
<body>
<h2><%= I18n.getResource("10") %></h2>
<a href="hello">click</a><br>
<a href="jdbcTCheck">jdbcTemplateCheck</a><br>
<a href="hiberCheck">hiberCheck</a><br>
<a href="jpaCheck">jpaCheck</a>
<form method="post" name="login" action="/habit/create">
    <input type="text" class="big_text" name="email" value="" placeholder=<%= I18n.getResource("8") %>>
    <input type="text" class="big_text" name="pass" value="" placeholder=<%= I18n.getResource("7") %> onkeyup="toggle('index_expire', !!this.value);toggle('index_forgot', !this.value)">
    <button class="index_login_button flat_button button_big_text"><%= I18n.getResource("9") %></button>
</form>
<h3>GET Habit by ID (native jdbc)</h3>
<form method="get" name="login" action="/nativeJdbc/get">
    <input type="text" class="big_text" name="habit_id" value="" placeholder="id">
    <button class="index_login_button flat_button button_big_text">GET</button>
</form>
</body>
<%@ page import="com.habit.custom.client.i18n.I18n" %>
</html>
