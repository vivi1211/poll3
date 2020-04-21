<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>

<form name="form1" method="post" action="${pageContext.request.contextPath}/user/login">
这是一个管理者主界面
<table>
<tr>
基础数据管理：<a href="jsp/admin/tab_student.jsp"></a>
</tr>

</table>

<div class="left-list">
			<div class="left-list-item" url="admin/tab_student.jsp" title="学生管理">
				<a class="easyui-linkbutton"  plain="true">学生管理</a>
				<!-- <img alt="" src="dist/css/icons/student.png" width="14px" height="14px" ><span>教师管理</span> -->
			</div>
			

		</div>

</body>
</html>