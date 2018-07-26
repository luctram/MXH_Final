<%-- 
    Document   : FormLogin1
    Created on : Jul 11, 2018, 11:55:29 PM
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
        <link rel="stylesheet" href="LoginCss.css">
        
        <c:set var="root" value="${pageContext.request.contextPath}"/>
    </head>
    <body>
        
        <div id="welcome">
        <p>CHÀO MỪNG BẠN ĐẾN VỚI MAKE FRIEND SOCIAL NETWORK!!!</p>
        </div>
        
        <div id="warp">
             
            <form action="./Servlet_Login" method="POST">
                <div class="Make">
                    <div class="rota">
                        <h1>&nbsp;&nbsp;Make</h1>
                        <input id="username" type="text" name="username" value="" placeholder="Tên đăng nhập" /><br />
                        <input id="password" type="password" name="pass" value="" placeholder="Mật khẩu" />
                    </div>
                </div>
                <div class="Friend">
                    <div class="roti">
                        <h1>Friend</h1>
                        <input type="submit" class="nutdangnhap" value="Đăng nhập"><br />
                        <a href="CheckAcc.jsp">Quên mật khẩu?</a>
                    </div>
                </div>
                
            </form>
            
                <div id="dangky">
                            <br><br>Bạn chưa có tài khoản?
                            <a href="FormRegistration.jsp">Đăng ký ngay!</a>
                        </div>
            <br>
            <img src="img/logo.png" width="150px" height="150px">
        </div>
         <footer id="footer">
                <div class="container">
                    MakeFriend Social Network  &copy; 2018
                </div>    
            </footer>
    </body>
</html>
