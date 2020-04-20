<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<meta charset="UTF-8">

<body>
<head>
    <title>注册信息</title>

</head>
<body>
<%
    request.setCharacterEncoding("UTF-8");
//    设置支持中文字符的字符集
    String name = request.getParameter("name");
//    name=new String(name.getBytes("ISO-8859-1"),"GBK");
    String pwd = request.getParameter("pwd");
    
    String[] genders=request.getParameterValues("gender");
    String birth = request.getParameter("birth");
    String hiredate = request.getParameter("hiredate");
    String[] types = request.getParameterValues("type");


%>
你输入的注册信息：<br>
<table>
    <tr>
        <td>用户名：</td>
        <td><%=name%>
        </td>
    </tr>
    <tr>
        <td>密码：</td>
        <td><%=pwd%>
        </td>
    </tr>
    <tr>
        <td>性别：</td>
        <%
            if (genders != null) {
                for (int i = 0; i < genders.length; i++) {
        %>
        <td><%=genders[i]%>
        </td>
        <%
                    // out.println(channels[i]);
                }
            }
        %>
    </tr>
    <tr>
        <td>生日：</td>
        <td><%=birth%>
        </td>
    </tr>
    <tr>
        <td>hiredate：</td>
        <td><%=hiredate%>
        </td>
    </tr>
    <tr>
        <td>职务：</td>
        <%
            if (types != null) {
                for (int i = 0; i < types.length; i++) {
        %>
        <td><%=types[i]%>
        </td>
        <%
                    // out.println(channels[i]);
                }
            }
        %>
    </tr>
</table>
</body>
</html>