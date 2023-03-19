<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新增會員</title>
</head>
<body>
 <h1>新增成員</h1>
    <form action="member?action=insert" method="post">
        <table>
            <tr>
                <td>帳號：</td>
                <td><input type="text" name="m_account" required></td>
            </tr>
            <tr>
                <td>密碼：</td>
                <td><input type="password" name="m_password" required></td>
            </tr>
            <tr>
                <td>姓名：</td>
                <td><input type="text" name="m_name" required></td>
            </tr>
            <tr>
                <td>電話：</td>
                <td><input type="tel" name="m_phone" required></td>
            </tr>
            <tr>
                <td>地址：</td>
                <td><input type="text" name="m_address" required></td>
            </tr>
            <tr>
                <td>電子郵件：</td>
                <td><input type="email" name="m_email" required></td>
            </tr>
            <tr>
                <td>生日：</td>
                <td><input type="date" name="m_birth" required></td>
            </tr>
            <tr>
                <td>積分：</td>
                <td><input type="number" name="m_points" required></td>
            </tr>
            <tr>
                <td>ID：</td>
                <td><input type="text" name="m_id" required></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="新增成員"></td>
            </tr>
        </table>
    </form>
</body>
</html>