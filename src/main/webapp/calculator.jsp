<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Calculator Web App</title>
  <link rel="stylesheet" href="calc_style.css">
</head>
<body>
<div class="container">
  <h1>Calculator</h1>
  <form action="calculator" method="post">
    <label for="num1">Number 1:</label>
    <input type="text" id="num1" name="num1" value="<%= (request.getAttribute("num1") != null) ? request.getAttribute("num1") : "" %>" required><br><br>

    <label for="num2">Number 2:</label>
    <input type="text" id="num2" name="num2" value="<%= (request.getAttribute("num2") != null) ? request.getAttribute("num2") : "" %>" required><br><br>

    <label for="operation">Operation:</label>
    <select id="operation" name="operation">
      <option value="add" <%= ("add".equals(request.getAttribute("operation"))) ? "selected" : "" %>>Add</option>
      <option value="subtract" <%= ("subtract".equals(request.getAttribute("operation"))) ? "selected" : "" %>>Subtract</option>
      <option value="multiply" <%= ("multiply".equals(request.getAttribute("operation"))) ? "selected" : "" %>>Multiply</option>
      <option value="divide" <%= ("divide".equals(request.getAttribute("operation"))) ? "selected" : "" %>>Divide</option>
    </select><br><br>

    <input type="submit" value="Calculate">
  </form>

  <div id="result">
    <%-- Display the result if it exists --%>
    <% if (request.getAttribute("result") != null) { %>
    Result: <%= request.getAttribute("result") %>
    <% } %>
  </div>

  <%-- Display the error message if it exists --%>
  <% if (request.getAttribute("error") != null) { %>
  <div class="error-message">
    Error: <%= request.getAttribute("error") %>
  </div>
  <% } %>
</div>
</body>
</html>
