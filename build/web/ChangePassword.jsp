<%-- 
    Document   : trangchu
    Created on : Mar 19, 2018, 11:01:57 PM
    Author     : TramLuc
--%>

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
        <jsp:include page="menu.jsp"></jsp:include>
        <jsp:include page = "footer.jsp"></jsp:include>
    </head>
    <body>

        <main role="main" class="container">
            <div class="col-md-3 caidatleft">
                <div id="caidatleft">
                    <p> <a href="UserInfo.jsp">Thông tin cá nhân</a>
                        <img src="img/setting.png" width="25px"></p>

                    <p><a href="ChangePassword.jsp">Đổi mật khẩu</a>
                        <img src="img/security1.png" width="25px"></p>

                    <p><a href="">Bạn bè</a>
                        <img src="img/friend1.png" width="25px"></p>

                    <p><a href="">Game</a>
                        <img src="img/game.png" width="25px"></p>
                </div>
            </div>

            <div class="col-md-9 ttcnright">

                <div id="dmkright">
                    <form action="./Servlet_ForgetPass" method="POST">
                        Mật khẩu mới&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="password"><br><br>
                        Nhập lại mật khẩu mới&nbsp;<input type="password">
                        <br><br>
                        <input type="hidden" name="username" value="<%=getServletContext().getAttribute("username1")%>">
                        <input type="submit" value="Lưu mật khẩu mới">
                    </form>
                </div>
            </div>
        </main><!-- /.container -->

    </body>
</html>
