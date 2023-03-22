<%@page import="com.bean.Memberbean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%Memberbean amember=(Memberbean)request.getAttribute("AMember"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>編輯會員</title>
</head>
<body>
<h1>會員清單</h1>
 <form action="member?action=update" method="post">
 <%if(amember!=null){ %>
 <input type="text" name="m_number" value="<%=amember.getM_number() %>" readonly="readonly">
 <%} %>
    <%System.out.println(amember.getM_number()); %>
 <table border="1">
 <tr>
 <td>帳號:</td>
  <td> <input type="text"  name="m_account" value="<%=amember.getM_account() %>" required="required"></td>
 </tr>
 <tr>
 <td>密碼:</td>
  <td> <input type="text"  name="m_password" value="<%=amember.getM_password() %>" required="required"></td>
   <%System.out.println(amember.getM_password()); %>
 </tr>
 <tr>
  <td>姓名:</td>
  <td> <input type="text"  name="m_name" value="<%=amember.getM_name() %>" required="required"></td>
 </tr>
  <tr>
  <td>電話:</td>
  <td> <input type="text"  name="m_phone" value="<%=amember.getM_phone() %>" required="required"></td>
 </tr>
  <tr>
  <td>地址:</td>
  <td> <input type="text"  name="m_address" value="<%=amember.getM_address() %>" required="required"></td>
 </tr>
  <tr>
  <td>電子郵件:</td>
  <td> <input type="text"  name="m_email" value="<%=amember.getM_email() %>" required="required"></td>
 </tr>
  <tr>
  <td>生日:</td>
  <td> <input type="date"  name="m_birth" value="${amember.getM_birth()}" required="required"></td>
    <%System.out.println(amember.getM_birth()); %>
 </tr>
   <tr>
  <td>積分:</td>
  <td> <input type="text"  name="m_points" value="<%=amember.getM_points() %>" required="required"></td>
 </tr>
  <tr>
  <td>ID:</td>
  <td> <input type="text"  name="m_id" value="<%=amember.getM_id() %>" required="required"></td>
 </tr>
 <tr>
<td><input type="submit" value="更新" ></td>
</tr>
 </table>
 </form>
 <form action="member?action=list" method="get">
 <input type="hidden" name="action" value="list">
 <input type="submit" value="返回">
 </form>
</body>
</html>