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


            <!--  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
                integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
                crossorigin="anonymous"> -->


            <style>
                #sidebar {
                    float: left;
                    width: 25%;
                    position: fixed;
                    margin-top: 0;
                }

                /* 將表單設置為右浮動，寬度為75% */
                .container-fluid {
                    float: right;
                    width: 40%;
                    margin-right: 25%;
                    margin-top: 7%;
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
            </style>

        </head>

        <body>
            <header>查看信件</header>
            <div id="sidebar">
                <jsp:include page="sidebar.html" />
            </div>
            <div class="container-fluid">

                <div class="card shadow mb-4">
                    <div class="card-body">
                        <div class="table-responsive">
                            <form method="get" action="InsertComplient" accept-charset="UTF-8">
                                <span>聯絡人</span> <br>
                                <input type="text" class="form-control" id="exampleFormControlInput1"
                                    value="${param.name}" name="customerName" disabled><br> <span>電子郵件</span> <br>
                                <input type="text" class="form-control" id="exampleFormControlInput1"
                                    value="${param.email}" name="email" disabled><br> <span>問題類型</span> <br>
                                <input type="text" class="form-control" id="exampleFormControlInput1"
                                    value="${param.complaintID}" name="complaintID" disabled><br> <span>標題</span> <br>
                                <input type="text" class="form-control" id="exampleFormControlInput1"
                                    value="${param.title}" name="title" disabled><br> <span>問題說明</span> <br>
                                <textarea id="content" class="form-control" id="exampleFormControlTextarea1"
                                    name="content" disabled>${param.content}</textarea>
                                <br>
                            </form>
                        </div>
                    </div>
                </div>
            </div>




            <script>
                var textarea = document.getElementById("content");
                textarea.focus();
                textarea.setSelectionRange(0, 0);
            </script>

        </body>

        </html>