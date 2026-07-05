<form action="LoginController" method="post">
    Username: <input type="text" name="username" /><br/>
    Password: <input type="password" name="password" /><br/>
    <input type="submit" value="Login" />
</form>

<%-- Display error message if present --%>
<% if(request.getAttribute("message") != null) { %>
    <p style="color:red;"><%= request.getAttribute("message") %></p>
<% } %>
