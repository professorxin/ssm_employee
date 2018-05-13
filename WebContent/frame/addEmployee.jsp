<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >
<html>
<head></head>
<body>
<table border="0" width="600px">
<tr>
<td align="center" style="font-size:24px; color:#666"> 员工添加</td>
</tr>
<tr>
<td align="right" > 
<a href="javascript:document.getElementById('saveForm').submit()">保存</a> &nbsp;&nbsp;
<a href="javascript:history.go(-1)">退回</a>
</td>
</tr>
</table>
<br/>

<form id="saveForm" action="${pageContext.request.contextPath }/Employee/insert" method="post">
<table border='0' cellpadding="0"  cellspacing="10">

<tr>

<td>姓名：</td>
<td><input type="text" name="ename" ></td>
<td>性别：</td>
<td><input type="radio" name="sex" value="男">男&nbsp;&nbsp;<input type="radio" name="sex" value="女">女</td>
</tr>
<tr>

<td>用户名：</td>
<td><input type="text" name="username" ></td>
<td>密码：</td>
<td><input type="text" name="password"></td>
</tr>
<tr>
<td>出生日期：</td>
<td><input type="date" name="birthday"/></td>
<td>入职时间：</td>
<td><input type="date" name="joinDate"/></td>
</tr>

<tr>
<td>所属部门：</td>
<td>
	<select name="department">
	<c:forEach items="${list}" var="department">
		<option value="${department}">${department.dname}</option>
	</c:forEach>
	</select>
</td>
<td>编号：</td>
<td><input type="text" name="eno" ></td>
</tr>
</table>
</form>

</body>
</html>