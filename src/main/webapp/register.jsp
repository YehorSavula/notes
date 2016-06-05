<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Register</title></head>
<body>
<div>
    <h1 style="text-align:center;">Register</h1>

    <form action="register" method="post">
        <fieldset style="width:340px;margin-left:450;">
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
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </fieldset>
    </form>
</div>

</body>
</html>