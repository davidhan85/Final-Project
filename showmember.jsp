<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>會員詳細資訊</title>
</head>
<body>
 <h1>會員詳細資料</h1>
 <table border="1">
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
		<tr>
					<td>${AMember.m_number}</td>
                    <td>${AMember.m_account}</td>
                    <td>${AMember.m_name}</td>
                    <td>${AMember.m_phone}</td>
                    <td>${AMember.m_address}</td>
                    <td>${AMember.m_email}</td>
                    <td>${AMember.m_birth}</td>
                    <td>${AMember.m_points}</td>
                    <td>${AMember.m_id}</td>
		</tr>
 </table>






</body>
</html>