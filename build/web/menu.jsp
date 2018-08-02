<%-- 
    Document   : trangchu
    Created on : Mar 19, 2018, 11:01:57 PM
    Author     : TramLuc
--%>

<%@page import="DAO.UserDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MAKEFRIEND SOCIAL NETWORK</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="css.css">
        <c:set var="root" value="${pageContext.request.contextPath}"/>
    </head>
    <body>
        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="Home.jsp"><img src="img/logo.png" width="55px"/></a>
                    
                </div>
                
                <ul class="nav navbar-nav">
                    <li><a href="UserPage.jsp"><i class="glyphicon glyphicon-heart"></i> <%=UserDAO.getNameToShowHomePage(getServletContext().getAttribute("username").toString())%></a></li>
                    <li><a href="Friends.jsp"><i class="glyphicon glyphicon-user"></i> Bạn bè</a></li>
                    <li><a href="NewPost.jsp"><i class="fa fa-edit"></i> Bài đăng mới</a></li>
                    <li><a href="mess.jsp"><i class="fa fa-comments"></i> Tin nhắn</a></li>
                    <li><a href="Feedback.jsp"><i class="glyphicon glyphicon-send"></i> Phản hồi</a></li>
                    <li><a href="UserInfo.jsp"><i class="fa fa-cogs"></i> Cài đặt</a></li>
                </ul>
                
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="FormLogin.jsp"><span class="glyphicon glyphicon-log-in"></span> Đăng xuất</a></li>
                </ul>
                
                <form class="navbar-form navbar-right" action="#">
                    <div class="input-group">
                        <input type="text" class="form-control" placeholder="Tìm kiếm" name="search">
                        <div class="input-group-btn">
                            <button class="btn btn-default" type="submit">
                                <i class="glyphicon glyphicon-search"></i>
                            </button>
                        </div>
                    </div>
                </form>
                
            </div><!--/container-fluid-->

        </nav>
</body>
</html>
