<%-- 
    Document   : AdminLogin
    Created on : Jun 28, 2018, 11:19:12 PM
    Author     : TramLuc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MAKEFRIEND SOCIAL NETWORK ADMINISTRATOR</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
        <link rel="stylesheet" href="AdminCss.css">
        <style>
           #login {
  margin-left: -230px;
  background: black;
  color: white;
  text-align: right;
  cursor: pointer;
  transition: all 1s ease-out;
}
#login:hover {
  background: #81827c;
  transition: all 0.3s ease-in;
}
        </style>
    </head>
    <body>
        <div id="warp">
            MakeFriend Social Network Administrator
            <form action="./Servlet_AdminLogin" method="POST" id="formu">
                <div class="admin">
                    <div class="rota">
                        <h1>ADMIN</h1>
                        <input id="username" type="text" name="name" value="" placeholder="Tên đăng nhập" /><br />
                        <input id="password" type="password" name="pass" value="" placeholder="             Mật khẩu" />
                    </div>
                </div>
                <div class="title">
                    <div class="roti">
                        <h1>M.F</h1>
                        <input id="login" type="submit" name="valid" value="Đăng nhập"><br />
                    </div>
                </div>
            </form>
        </div>
       
    </body>
    
</html>
