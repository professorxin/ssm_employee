<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head></head>
<body>
<table border="0" width="600px">
<tr>
<td align="center" style="font-size:24px; color:#666"> 部门编辑</td>
</tr>
<tr>
<td align="right" > 
<a href="javascript:document.getElementById('saveForm').submit()">保存</a> &nbsp;&nbsp;
<a href="javascript:history.go(-1)">退回 </a>
</td>
</tr>
</table>
<br/>
 <br>
 <form id="saveForm" action="${pageContext.request.contextPath }/Department/update" method="post">
<input type="hidden" name="did" value="${department.did}"/>
<table style="font-size::16px">
<tr>
  <td>部门名称：</td>
  <td><input type="text" name="dname" value="${department.dname}"></td>
</tr>
<tr>
  <td>部门介绍：</td>
  <td></td>
</tr>
<tr>
  <td width="10%"></td>
  <td>
     <textarea cols="50" rows="5" name="ddesc">${department.ddesc}</textarea>
  </td>
</tr>
</table>
</form>

</body>
</html> 