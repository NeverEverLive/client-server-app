<%--
  Created by IntelliJ IDEA.
  User: nel
  Date: 10/30/21
  Time: 10:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Autorization</title>
</head>
<body>

    <h1>Post request</h1>
    <form action='autorization' method='post'>
        <label>
            <input type='text' name='username'/>
        </label>
        <br><br>
        <label>
            <input type='password' name='password'/>
        </label>
        <br><br>
        <input type='submit' name='sign in'/>
    </form>
    <br><br><br><br>
    <h1>Get request</h1>
    <form action='autorization' method='get'>
        <label>
            <input type='text' name='username'/>
        </label>
        <br><br>
        <label>
            <input type='password' name='password'/>
        </label>
        <br><br>
        <input type='submit' name='sign in'/>
    </form>
</body>
</html>
