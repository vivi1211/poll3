<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login page</title>
</head>
<body>
<form name="form1" method="post" action="${pageContext.request.contextPath}/user/login">
    <table>
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>密 码：</td>
            <td><input type="password" name="pwd"></td>
        </tr>
        <tr>
            <td>
                <input type="submit" name="Submit" value="登陆">
                <input type="reset" name="Reset" value="取消">
            </td>
        </tr>
    </table>
</form>

</body>
</html>