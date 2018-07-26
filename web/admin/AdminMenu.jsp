<%-- 
    Document   : AdminPage
    Created on : Jun 28, 2018, 11:58:58 PM
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
        <style>
            li img{
                margin-top: 5px;
            }
            #AdminName{
                color: #9f9f9f;
                margin-top: 14px;
                margin-left: 5px;
            }
        </style>
    </head>
    <body>
         <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container-fluid">
               
                
                <ul class="nav navbar-nav menu">
                    <li><a href="Feedback.jsp">Phản hồi</a></li>
                    <li><a href="BlockAccount.jsp">Tài khoản bị khóa</a> </li>
                     <li><a href="BlockPost.jsp">Bài viết bị xóa</a> </li>
                    <li><a href="#">Liên hệ</a></li>
                </ul>
                
                <ul class="nav navbar-nav navbar-right">
                    <li><img src="../img/tram.jpg" alt="User Avatar" class="img-circle" width="40px" height="40px"></li>
                    <li id="AdminName">Tracy Luc</li>
                    <li><a href="AdminLogin.jsp"><span class="glyphicon glyphicon-log-in"></span> Đăng xuất</a></li>
                </ul>
             
                
            </div><!--/container-fluid-->

        </nav>
    </body>
</html>
