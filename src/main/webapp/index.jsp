<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<html>

<link rel="stylesheet" type="text/css" href="styles/common.css">
<%--<script src="scripts/js_adapter.js"/>--%>
<body>
<h2><%= I18n.getResource("10") %></h2>
<a href="hello">1 [Servlet] click</a><br>
<a href="jdbcTCheck">2 [Servlet] jdbcTemplate Check</a><br>
<a href="hiberCheck">3 [Servlet] Hibernate Check</a><br>
<a href="jpaCheck">4 [Servlet] JPA Check</a><br>
<a href="loginmvc">5 [Spring] [MVC] check</a><br>
<a href="mvcHabit">6 [Spring] [MVC] create habit</a><br>
<a href="attachmvc">7 [Spring] [MVC] add attach</a><br>
<a href="showHabits">8 [Spring] [MVC] excel example</a><br>
<a href="loginFlow">9 [Spring] [WEB FLOW] example login</a><br>
<a href="admin">10 [Spring][Security] Admin page </a>
<h3>11 [Servlet] Create Habit </h3>
<form method="post" name="login" action="/habit/create">
    <input type="text" class="big_text" name="email" value="" placeholder=<%= I18n.getResource("8") %>>
    <input type="text" class="big_text" name="pass" value="" placeholder=<%= I18n.getResource("7") %> onkeyup="toggle('index_expire', !!this.value);toggle('index_forgot', !this.value)">
    <button class="index_login_button flat_button button_big_text"><%= I18n.getResource("9") %></button>
</form>
<h3>12 [Servlet][EhCache] GET Habit by ID (native jdbc)</h3>
<form method="get" name="login" action="/nativeJdbc/get">
    <input type="text" class="big_text" name="habit_id" value="" placeholder="id">
    <button class="index_login_button flat_button button_big_text">GET</button>
</form>
</body>
<%@ page import="com.habit.custom.client.i18n.I18n" %>
</html>
