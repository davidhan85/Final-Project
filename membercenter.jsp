<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <!DOCTYPE html>
    <html>

    <head>
      <meta charset="UTF-8">
      <title>會員中心</title>
      <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
      <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">
      <!-- Custom styles for this template -->
      <link href="../css/sb-admin-2.min.css" rel="stylesheet">
      <!-- Custom styles for this page -->
      <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
      <style>
        #sidebar {
          float: left;
          width: 25%;
          position: fixed;
          margin-top: 0;
        }
        #position {
/*           TEXT-ALIGN: CENTER; */
/*           MARGIN-BOTTOM: 90%; */
 position: fixed;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  text-align: center;
  width: 50%;
         } 
         body{
          background-color: beige;
         }
      </style>
    </head>

    <body>

      <div id="sidebar">
        <jsp:include page="sidebar.html" />
      </div>

      <div id="position">
        <h2>搜尋所有會員</h2>
        <form action="../member?action=list" method="get">
          <input type="hidden" name="action" value="list">
          <input type="submit" value="查詢">
        </form>
        <h2>搜尋單筆會員</h2>
        <form action="../member?action=show" method="get">
          <input type="hidden" name="action" value="show">
          <label for="m_number">會員編號:</label>
          <input type="text" name="m_number" required>
          <input type="submit" value="查詢">
        </form>
        <h2>新增會員</h2>
        <a href="../member?action=new">新增會員</a>
      </div>

    </body>

    </html>