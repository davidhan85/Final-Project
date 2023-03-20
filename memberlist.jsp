<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>會員列表</title>
</head>
<body>
 <h1>會員列表</h1>
    <table border="1">
        <thead>
            <tr>
                <th>編號</th>
                <th>帳號</th>
                <th>姓名</th>
                <th>電話</th>
                <th>地址</th>
                <th>電子郵件</th>
                <th>生日</th>
                <th>積分</th>
                <th>ID</th>             
            </tr>
        </thead>
        <tbody>
            <c:forEach var="member" items="${Allmember}">
                <tr>
                    <td>${member.m_number}</td>
                    <td>${member.m_account}</td>
                    <td>${member.m_name}</td>
                    <td>${member.m_phone}</td>
                    <td>${member.m_address}</td>
                    <td>${member.m_email}</td>
                    <td>${member.m_birth}</td>
                    <td>${member.m_points}</td>
                    <td>${member.m_id}</td>
                    <td><a href="member?action=edit&m_number=${member.m_number}">編輯</a></td>
                    <td><a href="member?action=delete&m_number=${member.m_number}">刪除</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>