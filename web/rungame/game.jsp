<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en-us">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>MAKEFRIEND SOCIAL NETWORK | FlappyBird</title>
    <link rel="shortcut icon" href="TemplateData/favicon.ico">
    <link rel="stylesheet" href="TemplateData/style.css">
    <link rel="stylesheet" href="TemplateData/css.css">
    <script src="TemplateData/UnityProgress.js"></script>  
    <script src="Build/UnityLoader.js"></script>
    
    <link rel="stylesheet" href="../css.css">
    <jsp:include page = "../footer.jsp"></jsp:include>
    <script>
      var gameInstance = UnityLoader.instantiate("gameContainer", "Build/Flappybird_final.json", {onProgress: UnityProgress});
    </script>
  </head>
  <body>
      <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="../Home.jsp"><img src="../img/logo.png" width="55px"/></a>
                    
                </div>
                
                <ul class="nav navbar-nav">
                    <li><a href="../UserPage.jsp">Trâm Lục</a></li>
                    <li><a href="#">Lời mời kết bạn</a></li>
                    <li><a href="../mess.jsp">Tin nhắn</a></li>
                    <li><a href="#">Thông báo</a></li>
                    <li><a href="../Setting.jsp">Cài đặt</a></li>
                </ul>
                
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="../FormLogin.jsp"><span class="glyphicon glyphicon-log-in"></span> Đăng xuất</a></li>
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
    <div class="webgl-content">
       <div id="gameContainer" style="width: 1200px; height: 600px"></div>
      <div class="footer">
        <div class="fullscreen" onclick="gameInstance.SetFullscreen(1)"></div>
         <div class="title">FlappyBird</div>
         
      </div>
    </div>
  </body>
</html>