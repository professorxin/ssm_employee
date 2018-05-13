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
<td width="39%" align="left" style="font-size:34px; color:#999"> 部门管理</td>
<td width="57%" align="right">
<a href="${pageContext.request.contextPath }/Department/save"><img src="${pageContext.request.contextPath }/frame/img/tianjia.png"></a>
</td>
</tr>
</table>

<br/>

<table cellspacing="0" border="1" class="table1">
<thead>
   <tr><th width="450">部门名称</th><th  width="450">编辑</th></tr>
</thead>

<tbody>
<%-- <s:iterator value="list" var="d">
<tr>
<td align="center"><s:property value="#d.dname"/></td>
<td width="7%" align="center"><a href="${pageContext.request.contextPath }/department_edit.action?did=<s:property value="#d.did"/>">编辑</a></td>
<td width="7%" align="center"><a href="${pageContext.request.contextPath }/department_delete.action?did=<s:property value="#d.did"/>">删除</a></td>
</tr>
</s:iterator> --%>
<c:forEach items="${page.list}" var="department">
<tr>
<td align="center"><c:out value="${department.dname}"/></td>
<td width="7%" align="center"><a href="${pageContext.request.contextPath }/Department/edit?did=${department.did}">编辑</a></td>
<td width="7%" align="center"><a href="${pageContext.request.contextPath }/Department/delete?did=${department.did}">删除</a></td>
</tr>
</c:forEach>
</tbody>
</table>
<br/>


<table border="0" cellspacing="0" cellpadding="0"  width="900px">
<tr>
<%-- <td align="right">
   <span>第<s:property value="currPage"/>/<s:property value="totalPage"/>页</span>&nbsp;&nbsp;
  <span>总记录<s:property value="totalCount"/></span>
   <span>
   		<s:if test="currPage != 1">
       <a href="${pageContext.request.contextPath }/department_findAll.action?currPage=1">[首页]</a>&nbsp;&nbsp;
       <a href="${pageContext.request.contextPath }/department_findAll.action?currPage=<s:property value="currPage-1"/>">[上一页]</a>&nbsp;&nbsp;
       </s:if>
       <s:if test="currPage != totalPage">
       <a href="${pageContext.request.contextPath }/department_findAll.action?currPage=<s:property value="currPage+1"/>">[下一页]</a>&nbsp;&nbsp;
       <a href="${pageContext.request.contextPath }/department_findAll.action?currPage=<s:property value="totalPage"/>">[尾页]</a>&nbsp;&nbsp;
       </s:if>
   </span>
</td> --%>
<td align="right">
   <span>第<c:out value="${page.currPage}"/>/<c:out value="${page.totalPage }"/>页</span>&nbsp;&nbsp;
  <span>总记录<c:out value="${page.totalCount }"/></span>
   <span>
   <!--注意，test里面的判断条件不能带空格  -->
   		<c:if test="${page.currPage!=1}">
       <a href="${pageContext.request.contextPath }/Department/findAll?currPage=1">[首页]</a>&nbsp;&nbsp;
       <a href="${pageContext.request.contextPath }/Department/findAll?currPage=<c:out value="${page.currPage-1}"/>">[上一页]</a>&nbsp;&nbsp;
       </c:if>
       <c:if test="${page.currPage!=page.totalPage}">
       <a href="${pageContext.request.contextPath }/Department/findAll?currPage=<c:out value="${page.currPage+1}"/>">[下一页]</a>&nbsp;&nbsp;
       <a href="${pageContext.request.contextPath }/Department/findAll?currPage=<c:out value="${page.totalPage}"/>">[尾页]</a>&nbsp;&nbsp;
       </c:if>
   </span>
</td>
</tr>
</table>
</body>
</html>