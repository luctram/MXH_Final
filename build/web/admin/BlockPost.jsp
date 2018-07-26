<%-- 
    Document   : BlockPost
    Created on : Jul 17, 2018, 6:50:09 PM
    Author     : TramLuc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MAKEFRIEND SOCIAL NETWORK ADMINISTRATOR</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="AdminPageCss.css">
        <jsp:include page="AdminMenu.jsp"></jsp:include>
        <style>
            .column1 {
                width: 200px;
                padding-left: 40px;
            }

            .column2 {
                width:350x;
            }

            .column3 {
                width: 300px;
            }

            .column4 {
                width: 110px;

            }

            .column5 {
                width:150px;
                padding-right: 62px;
            }

        </style>
    </head>
    <body>
        <div class="limiter">
            <div class="container-table100">
                <div class="wrap-table100">
                    <div class="table100">
                        <table>
                            <thead>
                                <tr class="table100-head">
                                    <th class="column1">Tên tài khoản</th>
                                    <th class="column2">Nội dung bài viết</th>
                                    <th class="column3">Lý do</th>
                                    <th class="column4">Ngày đăng</th>
                                    <th class="column5">Ngày xóa</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td class="column1">2017-09-29 01:22</td>
                                    <td class="column2">200398</td>
                                    <td class="column3">iPhone X 64Gb Grey</td>
                                    <td class="column4">2017-09-29.00</td>
                                    <td class="column5">2017-09-29</td>
                                </tr>
                                <tr>
                                    <td class="column1">2017-09-28 05:57</td>
                                    <td class="column2">200397</td>
                                    <td class="column3">Samsung S8 Black</td>
                                    <td class="column4">$756.00</td>
                                    <td class="column5">1</td>
                                </tr>

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>




        <!--===============================================================================================-->	
        <script src="vendor/jquery/jquery-3.2.1.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/bootstrap/js/popper.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/select2/select2.min.js"></script>
        <!--===============================================================================================-->
        <script src="js/main.js"></script>
    </body>
</html>
