<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<meta charset="UTF-8">

<body>
<head>
    <title>用户注册</title>
</head>
<body>

<form name="form1" method="post" action="${pageContext.request.contextPath}/user/register">
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
            <td>性别：</td>
            <td><input type="checkbox" name="gender" value="male">male
                <input type="checkbox" name="gender" value="female">female
                
            </td>
        </tr>
        <tr>
            <td>生日：</td>
            <td><input type="text" name="birth"></td>
        </tr>
        <tr>
            <td>hiredate：</td>
            <td><input type="text" name="hiredate"></td>
        </tr>
        <tr>
            <td>type：</td>
            <td><input type="checkbox" name="type" value="student">student
                <input type="checkbox" name="type" value="teacher">teacher
                <input type="checkbox" name="type" value="Admin">Admin
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" name="Submit" value="提交">
                <input type="reset" name="Reset" value="取消">
            </td>
        </tr>
    </table>
</form>



</body>
</html>