<%-- 
    Document   : quenmatkhau
    Created on : Mar 19, 2018, 10:39:14 PM
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
        <link rel="stylesheet" href="AccountCss.css">
        <jsp:include page = "footer.jsp"></jsp:include>
    </head>
    <body>
       

        <main role="main" class="container">
            <div class="col-md-6">
                <div id="welcome">
                    <p>CHÀO MỪNG BẠN ĐẾN VỚI </p>
                    <p>MAKE FRIEND SOCIAL NETWORK</p>
                    <img src="img/fulllogo.png" align="center">
                    
                </div>
            </div>
            
            <div class="col-md-6">
            <div id="quenmatkhau">
                <h3>NHẬP THÔNG TIN TÀI KHOẢN CỦA BẠN</h3>
                <form action="./Servlet_ForgetPass" method="GET">
                    <br><br>Tên tài khoản&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input class="username" type="text" name="username"  maxlength="20" minlength="5">
                    <br><br>Số điện thoại&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input class="sdt" type="text" name="phone" maxlength="15" minlength="9">
                    
                    <br><br>Email&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input class="email" type="text" name="email" maxlength="45" minlength="10">
                    
                    <br><br><br>
                    <input class="kiemtrataikhoan" type="submit" value="KIỂM TRA">
                    
                </form></div>
            </div>
                
        </main><!-- /.container -->
      
        </body>
</html>
