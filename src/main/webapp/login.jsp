<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url value="/security_login" var="loginUrl" />

<html>
<head><title>Login</title></head>
<body>
<div>
    <h1 style="text-align:center;">Login</h1>

    <div style="margin-left:450;">
        <form action="${loginUrl}" method="post">

            <fieldset style="width:340px;">
                <table>
                    <tr>
                        <td>Username</td>
                        <td><input type="text" name="username"/></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="password"/></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Login"/></td>
                    </tr>
                </table>
            </fieldset>
        </form>
        Not yet Registered? <a href="register.jsp">Register Here</a>!
    </div>
</div>

</body>
</html>