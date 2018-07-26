<%-- 
    Document   : game
    Created on : Jun 24, 2018, 10:50:45 AM
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
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css" />
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="css.css">
        <jsp:include page="menu.jsp"></jsp:include>
        <jsp:include page = "footer.jsp"></jsp:include>
    </head>
    <body>
            <main role="main" class="container">
             <div class="col-md-3 caidatleft">
                <div id="caidatleft">
                    <p> <a href="thongtincanhan.jsp">Thông tin cá nhân</a>
                        <img src="img/setting.png" width="25px"></p>

                    <p><a href="thongtindangnhap.jsp">Đổi mật khẩu</a>
                        <img src="img/security1.png" width="25px"></p>

                    <p><a href="">Bạn bè</a>
                        <img src="img/friend1.png" width="25px"></p>

                    <p><a href="">Game</a>
                        <img src="img/game.png" width="25px"></p>
                </div>
            </div>
                <div class="col-md-9 ttcnright">
            <div id="game">
                <h3>TRÒ CHƠI</h3>
               
            </div>
            </div>
    </body>
</html>
