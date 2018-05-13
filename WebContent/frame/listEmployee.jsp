<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
        .table1{
            border:1px solid #ddd;
            width:900px;
            
        }
        thead{
            background-color:lightblue;
        }
    </style>
</head>
<body>
<table border="0" width="900px">
<tr>
<td align="center" style="font-size:24px; color:#666"> 员工管理</td>
</tr>
<tr>
<td align="right" > <a href="${pageContext.request.contextPath}/Employee/save">添加</a></td>
</tr>
</table>
<br/>


<table cellspacing="0" border="1" class="table1">
<thead>
  <tr>
<td align="center">编号</td>
<td align="center">员工姓名</td>
<td align="center">性别</td>
<td align="center">出生日期</td>
<td align="center">入职时间</td>
<td align="center">所属部门</td>
<td align="center">编辑</td>
<td align="center">删除</td>
</tr>
</thead>
<tbody>
<%-- <s:iterator value="list" var="e">
<tr>
<td align="center"><s:property value="#e.eno"/></td>
<td align="center"><s:property value="#e.ename"/></td>
<td align="center"><s:property value="#e.sex"/></td>
<td align="center"><s:date name="#e.birthday" format="yyyy-MM-dd"/></td>
<td align="center"><s:date name="#e.joinDate" format="yyyy-MM-dd"/></td>
<td align="center"><s:property value="#e.department.dname"/></td>
<td align="center"><a href="${pageContext.request.contextPath }/employee_edit.action?eid=<s:property value="#e.eid"/>"><img src="${pageContext.request.contextPath }/images/编辑.png"></a></td>
<td align="center"><a href="${pageContext.request.contextPath }/employee_delete.action?eid=<s:property value="#e.eid"/>">删除</a></td>
</tr>


</s:iterator> --%>
<c:forEach items="${page.list}" var="employee">
	<tr>
		<td align="center"><c:out value="${employee.eno }"/></td>
		<td align="center"><c:out value="${employee.ename }"/></td>
		<td align="center"><c:out value="${employee.sex }"/></td>
		<td align="center"><c:out value="${employee.birthday }" /></td>
		<td align="center"><c:out value="${employee.joinDate }" /></td>
		<td align="center"><c:out value="${employee.department.dname }"/></td>
		<td align="center"><a href="${pageContext.request.contextPath }/Employee/edit?eid=<c:out value="${employee.eid }"/>"><img src="${pageContext.request.contextPath }/images/编辑.png"></a></td>
		<td align="center"><a href="${pageContext.request.contextPath }/Employee/delete?eid=<c:out value="${employee.eid }"/>">删除</a></td>
	</tr>
</c:forEach>
</tbody>
</table>
<br/>

<table  border="0" cellspacing="0" cellpadding="0"  width="900px">
<tr>
<td align="right">
   <%-- <span>第<s:property value="currPage"/>/<s:property value="totalPage"/>页</span>
   <span>总记录<s:property value="totalCount"/></span>
   <span>
   <s:if test="currPage!=1">
       <a href="${pageContext.request.contextPath }/employee_findAll.action?currPage=1">[首页]</a>&nbsp;&nbsp;
       <a href="${pageContext.request.contextPath }/employee_findAll.action?currPage=<s:property value="currPage-1"/>">[上一页]</a>&nbsp;&nbsp;
       </s:if>
       <s:if test="currPage!=totalPage">
       <a href="${pageContext.request.contextPath }/employee_findAll.action?currPage=<s:property value="currPage+1"/>">[下一页]</a>&nbsp;&nbsp;
       <a href="${pageContext.request.contextPath }/employee_findAll.action?currPage=<s:property value="totalPage"/>">[尾页]</a>&nbsp;&nbsp;
       </s:if>

   </span> --%>
  <span>第<c:out value="${page.currPage}"/>/<c:out value="${page.totalPage }"/>页</span>&nbsp;&nbsp;
  <span>总记录<c:out value="${page.totalCount }"/></span>
   <span>
   <!--注意，test里面的判断条件不能带空格  -->
   		<c:if test="${page.currPage!=1}">
       <a href="${pageContext.request.contextPath }/Employee/findAll?currPage=1">[首页]</a>&nbsp;&nbsp;
       <a href="${pageContext.request.contextPath }/Employee/findAll?currPage=<c:out value="${page.currPage-1}"/>">[上一页]</a>&nbsp;&nbsp;
       </c:if>
       <c:if test="${page.currPage!=page.totalPage}">
       <a href="${pageContext.request.contextPath }/Employee/findAll?currPage=<c:out value="${page.currPage+1}"/>">[下一页]</a>&nbsp;&nbsp;
       <a href="${pageContext.request.contextPath }/Employee/findAll?currPage=<c:out value="${page.totalPage}"/>">[尾页]</a>&nbsp;&nbsp;
       </c:if>
   </span>
</td>
</tr>
</table>
</body>
</html>