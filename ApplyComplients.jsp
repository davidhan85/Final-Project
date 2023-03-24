<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <title>InsertComplient</title>
            <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
            <link
                href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
                rel="stylesheet">


            <link href="css/sb-admin-2.min.css" rel="stylesheet">
            <style>

                #position{
                  text-align: center;
                padding-top: 10%;
                }
                #sidebar {
                    float: left;
                    width: 25%;
                    position: fixed;
                    margin-top: 0;
                }

                form {
                    max-width: 600px;
                    margin: 0 auto;
                    font-size: 16px;
                    line-height: 1.5;
                    color: #333;
                }

                input[type="text"],
                textarea {
                    width: 100%;
                    padding: 10px;
                    margin-bottom: 20px;
                    border-radius: 5px;
                    border: 1px solid #ccc;
                    font-size: 16px;
                    line-height: 1.5;
                }

                textarea {
                    height: 150px;
                }

                header {

                    float: right;
                    width: 90%;
                    background-color: #0077c2;
                    padding: 20px;
                    color: #ffffff;
                    text-align: center;
                    border-bottom: 2px solid #004e8c;
                    font-size: 24px;
                    font-weight: bold;
                }

                button {
                    margin-top: 20px;
                    padding: 10px 20px;
                    border: none;
                    border-radius: 5px;
                    box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
                    background-color: #4e73df;
                    color: #fff;
                    font-size: 16px;
                    cursor: pointer;

                }

                button:hover {
                    background-color: #2e59d9;
                }

                span {
                    font-size: 16px;
                    font-weight: bold;
                    margin-bottom: 5px;
                }
            </style>
        </head>

        <body>
            <header>回答信件</header>
            <div id="sidebar">
                <jsp:include page="sidebar.html" />
            </div>
            <div id="position">
                <form method="get" action="ApplyComplients" accept-charset="UTF-8">
                    <span>標題</span> <br><input type="text" value="${param.title}" name="title" readonly><br>
                    <span>提問日期</span> <br><input type="text" value="${param.ApplyDate}" name="createDate" readonly><br>
                    <span>聯絡人</span> <br><input type="text" value="${param.name}" name="customerName" readonly><br>
                    <span>問題說明</span> <br><textarea id="content" name="content" readonly>${param.content}</textarea><br>
                    <span>客服回答</span> <br><textarea id="content" name="apply"></textarea><br>
                    <button>送出</button>
                </form>
            </div>
            <script>
                var textarea = document.getElementById("content");
                textarea.focus();
                textarea.setSelectionRange(0, 0);
            </script>

        </body>

        </html>