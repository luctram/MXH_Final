<%-- 
    Document   : trangchu
    Created on : Mar 19, 2018, 11:01:57 PM
    Author     : TramLuc
--%>

<%@page import="DAO.CmtPostDAO"%>
<%@page import="Model.CommentPost"%>
<%@page import="DAO.FileDAO"%>
<%@page import="DAO.UserPostDAO"%>
<%@page import="Model.UserPost"%>
<%@page import="DAO.FriendsDAO"%>
<%@page import="Model.Friends"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
        <link rel="stylesheet" href="postcss.css">
        <jsp:include page="menu.jsp"></jsp:include>
        <jsp:include page = "footer.jsp"></jsp:include>
    <c:set var="root" value="${pageContext.request.contextPath}"/>
</head>
<body>
    <%
        int userid = (int)getServletContext().getAttribute("userid");
    String avatarlink = UserDAO.getAvatarToShowHomePage(userid);
    String username = UserDAO.getNameToShowHomePage(userid);
    List<Friends> listFriend = new ArrayList<Friends>();
            listFriend = FriendsDAO.getAllFriendByUserId(userid);
    %>
    <div class="main">
        <div class="container">
            <div class="row">
                <div class="col-md-2 catogory">
                    <div class="row">
                        <a href="UserPage.jsp" class="btn btn-default btn-xs"><img src="<%=avatarlink%>" alt="Alternate Text" class="img-responsive" width="190px" height="180px" />
                            <br><%=username%></a>
                    </div>
                    <hr>
                    <p>
                        Game
                    </p>
                    <a href="rungame/game.jsp"><img src="img/Flappybird-icon.png" width="30px" height="30px"></a>
                </div>

                <div class="col-md-8 content">
                    <%
                        List<UserPost> upost = new ArrayList<UserPost>();
                        
                        for(int i=0; i < listFriend.size(); i++){
                            upost = UserPostDAO.getAllPostByUserid(listFriend.get(i).getFriendId());
                         
                            String name, avatar;
                            name= UserDAO.getNameToShowHomePage(listFriend.get(i).getFriendId());
                            avatar = UserDAO.getAvatarToShowHomePage(listFriend.get(i).getFriendId());
                            for(int j=0; j< upost.size(); j++){
                                
%><div>
                    <div class="panel-heading">
                        <a href="#"><img src="<%=avatar%>" class="img-circle" width="45px" height="43px">&nbsp;&nbsp;&nbsp;    
                            <%=name%></a>
                        <div id="datepost"><%=upost.get(j).getDate()%>
                            <br><br>
                            <p>16&nbsp;bình luận&nbsp;&nbsp;&nbsp;<%=upost.get(j).getCountLike()%>&nbsp;&nbsp;&nbsp;<i class="fa fa-heart"></i></p>
                        </div>
                    </div>   

                    <div class="panel-body">
                        <div class="PostContents">
                            <p><%=upost.get(j).getContent()%></p>
                           <%
                               if(!upost.get(j).getImgVideoLink().equals(" ")){                           
                                    int check = FileDAO.checkfile(upost.get(j).getImgVideoLink());
                                    if (check == 0) {
                              
                           %>
                            <img src="<%=upost.get(j).getImgVideoLink()%>" width="300px" height="150px" >
                            <%} else if (check == 1) {%>
                            <video width="320" height="240" controls>
                                <source src="<%=upost.get(j).getImgVideoLink()%>" type="video/mp4">
                            </video>
                            <%}}%>

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
                                        <a href="#tab_default_1_<%=upost.get(j).getPostId()%>" data-toggle="tab">
                                            Viết bình luận</a>
                                    </li>
                                    <li>
                                        <a href="#tab_default_2_<%=upost.get(j).getPostId()%>" data-toggle="tab">
                                            Xem bình luận</a>
                                    </li>
                                </ul> <div class="tab-content">
                                    <div class="tab-pane active" id="tab_default_1_<%=upost.get(j).getPostId()%>">
                                        <div class="CmtAvatar">
                                            <img src="https://www.infrascan.net/demo/assets/img/avatar5.png" class="img-circle" width="30px" height="30px">

                                        </div>
                                        <div class="Comment">
                                            <div id="Usenamepost">
                                                <a href="">Trâm Lục</a>
                                            </div>
                                            <div id="WriteContents">
                                                <form action="./Servlet_AddNewCommentHome" method="POST">
                                                    <input type="hidden" name="postid" value="<%=upost.get(j).getPostId()%>">
                                                    <input type="hidden" name="usercmt" value="<%=username%>">
                                                    <input type="text" placeholder="Viết bình luận" name="comment">
                                                </form>

                                            </div>
                                        </div>


                                    </div>
                                    <div class="tab-pane" id="tab_default_2_<%=upost.get(j).getPostId()%>">
                                        <%
                                            List<CommentPost> cmtlist = new ArrayList<CommentPost>();
                                            cmtlist = CmtPostDAO.getAllCmtByPost(upost.get(j).getPostId());
                                            for(int k = 0; k < cmtlist.size(); k++){
                                                User u = new User();
                                                u= UserDAO.getInfoByUserId(cmtlist.get(k).getCmtId());
                                        %>
                                        <br>
                                        <div> <div class="CmtAvatar">
                                                <img src="<%=u.getAvatarLink()%>" class="img-circle" width="30px">

                                            </div>
                                            <div class="Comment">
                                                <div id="Usenamepost">
                                                    <a href=""><%=u.getName()%></a>
                                                </div>
                                                <div id="CmtContents">
                                                    <%=cmtlist.get(k).getContentsCmt()%>
                                                </div>
                                            </div>
                                        </div>
                                        <br>
                                     <%}%>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                    <br><%
                            }
                            }
                    %>
                </div>

                <div class="col-md-2">

                    <div class="member_list">
                        <ul class="list-unstyled">
                         <%
                              for(int i = 0; i< listFriend.size(); i++){
                                User user= new User();
                                user =UserDAO.getInfoByUserId(listFriend.get(i).getFriendId());
                                String friend = user.getUserName();
                                HttpSession sess = request.getSession(); 
                            sess.setAttribute("username123", friend);
                            System.out.println("C" + friend);
                         %>
                            <li class="left clearfix">
                                <a href="UserPageFriend.jsp"><span class="chat-img pull-left">
                                    <img src="<%=user.getAvatarLink()%>" class="img-circle">
                                </span>
                                <div class="chat-body clearfix">
                                    <div class="header_sec">
                                        <strong class="primary-font listfriendhome"><%=user.getName()%></strong> 
                                    </div>
                                </div></a>
                            </li>

<%}%>
                        </ul>
                    </div>
                </div>

            </div>

        </div> <!--/main-->

    </main><!-- /.container -->

</body>
</html>
