<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>

<html>
<header></header>
<body>
<div align="center">
    <form action="/security/login.action" method="post">
        <table>
            <tr>
                <td>user name:</td>
                <td><input name="username" type="text" width="20"/></td>
            </tr>
            <tr>
                <td>password:</td>
                <td><input name="password" type="password" width="20"/></td>
            </tr>
            <tr>
                <td colspan="2"><input name="submit" type="submit" value="login"/></td>
            </tr>
        </table>
    </form>
    <c:if test="${param.error != null }">
        <p style="color: red;">Invalid Username and Password.</p>
    </c:if>
</div>
</body>
</html>