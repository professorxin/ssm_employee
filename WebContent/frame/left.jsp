<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<link href="${pageContext.request.contextPath}/frame/dtree.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath }/frame/dtree.js"></script>
</head>

<body bgColor=#DDF0FB leftMargin=0 topMargin=0 marginwidth="0" marginheight="0">
<table width="90%" border="0" cellspacing="1" cellpadding="2" align="center">
<div class="${pageContext.request.contextPath}/frame/dtree.css">
  <script type="text/javascript">
    d=new dTree('d');
    d.add('01','-1','员工管理系统');
    d.add('0101','01','人力资源部');
    d.add('010101','0101','部门管理','${pageContext.request.contextPath }/Department/findAll?currPage=1','','right');
    d.add('010102','0101','员工管理','${pageContext.request.contextPath }/Employee/findAll?currPage=1','','right');
    document.write(d);
  </script>
</div>
</table>

</body>
</html>