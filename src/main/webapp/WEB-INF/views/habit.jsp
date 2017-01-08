<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring_form"%>
<html>
<head>
  <title>Spring MVC Form Handling</title>
  <style>
    .error {
      color: #ff0000;
    }

    .errorblock {
      color: #000;
      background-color: #ffEEEE;
      border: 3px solid #ff0000;
      padding: 8px;
      margin: 16px;
    }
  </style>
</head>
<body>

<h2>Habit Information</h2>
<spring_form:form method="POST" action="mvcAddHabit" commandName="createHabit">
  <spring_form:errors path="*" cssClass="errorblock" element="div" />
  <table>
    <tr>
      <td><spring_form:label path="name">Name</spring_form:label></td>
      <td><spring_form:input path="name" /></td>
      <td><spring_form:errors path="name" cssClass="error" /></td>
    </tr>
    <tr>
      <td><spring_form:label path="score">score</spring_form:label></td>
      <td><spring_form:input path="score" /></td>
      <td><spring_form:errors path="score" cssClass="error" /></td>
    </tr>
    <tr>
      <td colspan="2">
        <input type="submit" value="Submit"/>
      </td>
    </tr>
  </table>
</spring_form:form>
</body>
</html>