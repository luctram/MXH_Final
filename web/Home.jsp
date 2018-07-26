<%-- 
    Document   : trangchu
    Created on : Mar 19, 2018, 11:01:57 PM
    Author     : TramLuc
--%>

<%@page import="Model.User"%>
<%@page import="DAO.UserDAO"%>
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
    <c:set var="root" value="${pageContext.request.contextPath}"/>
</head>
<body>
    <%
    String avatarlink = UserDAO.getAvatarToShowHomePage(getServletContext().getAttribute("username").toString());
    System.out.println("ACB: " + avatarlink);
    %>
    <div class="main">
        <div class="container">
            <div class="row">
                <div class="col-md-2 catogory">
                    <div class="row">
                        <a href="UserPage.jsp" class="btn btn-default btn-xs"><img src="<%=avatarlink%>" alt="Alternate Text" class="img-responsive" width="190px" height="180px" />
                            <br><%=UserDAO.getNameToShowHomePage(getServletContext().getAttribute("username").toString())%></a>
                    </div>
                    <hr>
                    <p>
                        Game
                    </p>
                    <a href="rungame/game.jsp"><img src="img/Flappybird-icon.png" width="30px" height="30px"></a>
                </div>

                <div class="col-md-8 content">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <a href="#"><img src="https://www.infrascan.net/demo/assets/img/avatar5.png" class="img-circle" width="45px">&nbsp;&nbsp;&nbsp;    
                                Trâm Lục</a>
                            <div id="datepost">2018-27-7
                                <br><br>
                                <p>16&nbsp;bình luận&nbsp;&nbsp;&nbsp;16&nbsp;&nbsp;&nbsp;<i class="fa fa-heart"></i></p>
                            </div>
                        </div>   
                        <div class="panel-body">
                            <div class="PostContents">
                                hôm nay dui qué đuy
                            </div>
                            <div class="LikeButton">
                                <input type="button" value="Thích">
                            </div>
                        </div>
                        <div class="panel-footer">
                            <div data-spy="scroll">
                                <div class="tabbable-line">
                                    <ul class="nav nav-tabs ">

                                        <li class="active">
                                            <a href="#tab_default_1" data-toggle="tab">
                                                Viết bình luận</a>
                                        </li>
                                        <li>
                                            <a href="#tab_default_2" data-toggle="tab">
                                                Xem bình luận</a>
                                        </li>
                                    </ul>
                                    
                                    <div class="tab-content">
                                        <div class="tab-pane active" id="tab_default_1">

                                            <div class="CmtAvatar">
                                                <img src="https://www.infrascan.net/demo/assets/img/avatar5.png" class="img-circle" width="30px">

                                            </div>
                                            <div class="Comment">
                                                <div id="Usenamepost">
                                                    <a href="">Trâm Lục</a>
                                                </div>
                                                <div id="WriteContents">
                                                    <form action="" method="POST">
                                                        <input type="text" placeholder="Viết bình luận">
                                                    </form>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="tab-pane watchCmt" id="tab_default_2">
                                            <ul>
                                                <li>
                                                     <div class="CmtAvatar">
                                                <img src="https://www.infrascan.net/demo/assets/img/avatar5.png" class="img-circle" width="30px">

                                            </div>
                                            <div class="Comment">
                                                <div id="Usenamepost">
                                                    <a href="">Trâm Lục</a>
                                                </div>
                                                <div id="PostContents">
                                                    Ahihi chắc dui
                                                </div>
                                            </div> <hr>
                                                </li>
                                            </ul>
                                            <ul>
                                               
                                            <div class="CmtAvatar">
                                                <img src="https://www.infrascan.net/demo/assets/img/avatar5.png" class="img-circle" width="30px">

                                            </div>
                                            <div class="Comment">
                                                <div id="Usenamepost">
                                                    <a href=""> Bảo Cường</a>
                                                </div>
                                                <div id="PostContents">
                                                    Sao dui dọ kể nghe dới =))
                                                </div>
                                            </div>
                                            </ul>
                                            
                                        </div></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <a href="#"><img src="https://www.infrascan.net/demo/assets/img/avatar5.png" class="img-circle" width="45px">&nbsp;&nbsp;&nbsp;    
                                Trâm Lục</a>
                            <div id="datepost">2018-27-7
                                <br><br>
                                <p>16&nbsp;bình luận&nbsp;&nbsp;&nbsp;16&nbsp;&nbsp;&nbsp;<i class="fa fa-heart"></i></p>
                            </div>
                        </div>   
                        <div class="panel-body">
                            <div class="PostContents">
                                hôm nay dui qué đuy
                            </div>
                            <div class="LikeButton">
                                <input type="button" value="Thích">
                            </div>
                        </div>
                        <div class="panel-footer">
                            <div data-spy="scroll">
                                <div class="tabbable-line">
                                    <ul class="nav nav-tabs ">

                                        <li class="active">
                                            <a href="#tab_default_1" data-toggle="tab">
                                                Viết bình luận</a>
                                        </li>
                                        <li>
                                            <a href="#tab_default_2" data-toggle="tab">
                                                Xem bình luận</a>
                                        </li>
                                    </ul> <div class="tab-content">
                                        <div class="tab-pane active" id="tab_default_1">

                                            <div class="CmtAvatar">
                                                <img src="https://www.infrascan.net/demo/assets/img/avatar5.png" class="img-circle" width="30px">

                                            </div>
                                            <div class="Comment">
                                                <div id="Usenamepost">
                                                    <a href="">Trâm Lục</a>
                                                </div>
                                                <div id="WriteContents">
                                                    <form>
                                                        <input type="text" placeholder="Viết bình luận">
                                                    </form>

                                                </div>
                                            </div>
                                        </div>
                                        <div class="tab-pane" id="tab_default_2">
                                            <div class="CmtAvatar">
                                                <img src="https://www.infrascan.net/demo/assets/img/avatar5.png" class="img-circle" width="30px">

                                            </div>
                                            <div class="Comment">
                                                <div id="Usenamepost">
                                                    <a href="">Trâm Lục</a>
                                                </div>
                                                <div id="PostContents">
                                                    Ahihi chắc dui
                                                </div>
                                            </div>
                                            <hr>
                                            <div class="CmtAvatar">
                                                <img src="https://www.infrascan.net/demo/assets/img/avatar5.png" class="img-circle" width="30px">

                                            </div>
                                            <div class="Comment">
                                                <div id="Usenamepost">
                                                    <a href=""> Bảo Cường</a>
                                                </div>
                                                <div id="PostContents">
                                                    Sao dui dọ kể nghe dới =))
                                                </div>
                                            </div>
                                            <br>
                                        </div></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-md-2">

                    <div class="member_list">
                        <ul class="list-unstyled">
                            <li class="left clearfix">
                                <span class="chat-img pull-left">
                                    <img src="img/tram.jpg" alt="User Avatar" class="img-circle">
                                </span>
                                <div class="chat-body clearfix">
                                    <div class="header_sec">
                                        <strong class="primary-font">Tram Luc</strong> 
                                    </div>
                                </div>
                            </li>
                            <li class="left clearfix">
                                <span class="chat-img pull-left">
                                    <img src="img/fulllogo.jpg" alt="User Avatar" class="img-circle">
                                </span>
                                <div class="chat-body clearfix">
                                    <div class="header_sec">
                                        <strong class="primary-font">Bao Cuong</strong> 
                                    </div>
                                </div>
                            </li>
                            <li class="left clearfix">
                                <span class="chat-img pull-left">
                                    <img src="img/logo.jpg" alt="User Avatar" class="img-circle">
                                </span>
                                <div class="chat-body clearfix">
                                    <div class="header_sec">
                                        <strong class="primary-font">Tram tram</strong> 
                                    </div>
                                </div>
                            </li>


                        </ul>
                    </div>
                </div>

            </div>

        </div> <!--/main-->

    </main><!-- /.container -->

</body>
</html>
