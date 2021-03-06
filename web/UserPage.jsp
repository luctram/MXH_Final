<%-- 
    Document   : trangcanhan
    Created on : Jun 27, 2018, 11:33:54 PM
    Author     : TramLuc
--%>

<%@page import="DAO.CmtPostDAO"%>
<%@page import="Model.CommentPost"%>
<%@page import="DAO.FileDAO"%>
<%@page import="DAO.UserPostDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Model.UserPost"%>
<%@page import="DAO.UserDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.User"%>
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
        </head>
        <body>
        <%
            User user = new User();
             int userid = (int)getServletContext().getAttribute("userid");
             user.setUserId(userid);
            user = UserDAO.getInfoByUserId(user.getUserId());
            List<UserPost> Listpost = new ArrayList<UserPost>();
            Listpost = UserPostDAO.getAllPostByUserid(userid);
            
        %>
        
        <div class="container-fluid">
            <div class="row">
                <div class="fb-profile">
                    <img align="left" class="profile-img thumbnail" src="<%=user.getAvatarLink()%>" alt="Profile image example" height="250px" width="10px"/>
                    <div class="profile-name">
                        <h1><%=user.getName()%>
                            
                        </h1>
                    </div>
                </div>
            </div>
        </div> <!-- /container fluid-->  
        <div class="container">
            <div class="col-sm-8">
                <%for (int i = 0; i < Listpost.size(); i++) {
                    int countcmt = CmtPostDAO.countCmt(Listpost.get(i).getPostId());
                %>

                <div>
                    <div class="panel-heading">
                        <a href="#"><img src="<%=user.getAvatarLink()%>" class="img-circle" width="45px" height="43px">&nbsp;&nbsp;&nbsp;    
                            <%=user.getName()%></a>
                        <div id="datepost">
                              <div class="dropdown">
                                <span>...</span>
                                <div class="dropdown-content">
                                    <form action="EditPost.jsp">
                                            <input  type = "hidden" name="idpost1" value="<%=Listpost.get(i).getPostId()%>">
                                            <input type="submit" value="Sửa bài viết">
                                    </form>
                                    
                                    
                                        <form action="./Servlet_DeletePost" method="POST">
                                        <input  type = "hidden" name="idpost" value="<%=Listpost.get(i).getPostId()%>" >
                                  <input type="submit" value="Xóa bài viết">
                                        </form>
                                </div>
                                </div>
                            <br>
                            <%=Listpost.get(i).getDate()%>
                            <br>
                            <p><%=countcmt%>&nbsp;bình luận&nbsp;&nbsp;&nbsp;<%=Listpost.get(i).getCountLike()%>&nbsp;&nbsp;&nbsp;<i class="fa fa-heart"></i></p>
                         
                        </div>
                    </div>   

                    <div class="panel-body">
                        <div class="PostContents">
                            <p><%=Listpost.get(i).getContent()%></p>
                            <%
                                if (!Listpost.get(i).getImgVideoLink().equals(" ")) {
                                    int check = FileDAO.checkfile(Listpost.get(i).getImgVideoLink());
                                    if (check == 0) {
                            %>
                            <img src="<%=Listpost.get(i).getImgVideoLink()%>" width="300px" height="150px" >
                            <%} else if (check == 1) {%>
                            <video width="320" height="240" controls>
                                <source src="<%=Listpost.get(i).getImgVideoLink()%>" type="video/mp4">
                            </video>
                            <%}
                                    }%>

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
                                        <a href="#tab_default_1_<%=Listpost.get(i).getPostId()%>" data-toggle="tab">
                                            Viết bình luận</a>
                                    </li>
                                    <li>
                                        <a href="#tab_default_2_<%=Listpost.get(i).getPostId()%>" data-toggle="tab">
                                            Xem bình luận</a>
                                    </li>
                                </ul> <div class="tab-content">
                                    <div class="tab-pane active" id="tab_default_1_<%=Listpost.get(i).getPostId()%>">
                                        <div class="CmtAvatar">
                                            <img src="<%=user.getAvatarLink()%>" class="img-circle" width="30px" height="30px">

                                        </div>
                                        <div class="Comment">
                                            <div id="Usenamepost">
                                                <a href=""><%=user.getName()%></a>
                                            </div>
                                            <div id="WriteContents">
                                                <form action="./Servlet_AddNewComment" method="POST">
                                                    <input type="hidden" name="postid" value="<%=Listpost.get(i).getPostId()%>">
                                                    <input type="hidden" name="usercmt" value="<%=userid%>">
                                                    <input type="text" placeholder="Viết bình luận" name="comment">
                                                </form>

                                            </div>
                                        </div>
                                                    


                                    </div>
                                    <div class="tab-pane" id="tab_default_2_<%=Listpost.get(i).getPostId()%>">
                                        <%
                                            List<CommentPost> cmtlist = new ArrayList<CommentPost>();
                                            cmtlist = CmtPostDAO.getAllCmtByPost(Listpost.get(i).getPostId());
                                            for(int k = 0; k < cmtlist.size(); k++){
                                                User u = new User();
                                                u= UserDAO.getInfoByUserId(cmtlist.get(k).getUserId());
                                        %><br><br>
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
                                                 <div class="editcmt">
                                                    <div id="datecmt">
                                                        <%=cmtlist.get(k).getCmtDate()%>
                                                    </div>
                                                    <div class="dropdown">
                                                        <span>...</span>
                                                        <div class="dropdown-content">
                                                          
                                                            <form action="./Servlet_DeleteCmtHome" method="POST">
                                                                <input  type = "hidden" name="idcmt" value="<%=cmtlist.get(k).getCmtId()%>" >
                                                                <input type="submit" value="Xóa bình luận">
                                                            </form>
                                                        </div>
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
                <br> 
                <%}
                %>


            </div>

            <div class="col-sm-4">
                <div class="panel panel-default">
                    <div class="menu_title">
                        THÔNG TIN CÁ NHÂN
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="form-group">
                                    <i class="fa fa-birthday-cake"></i>&nbsp;<label for="email">Sinh nhật&nbsp;</label><%=user.getBDay()%>
                                </div>
                                <div class="form-group">
                                    <i class="fa fa-map-marker"></i>&nbsp; <label for="email">Đến từ&nbsp;</label><%=user.getHometown()%>
                                </div>
                                <div class="form-group">
                                    <i class="fa fa-home"></i>&nbsp;<label for="email">Sống tại&nbsp;</label><%=user.getAddress()%>

                                </div>
                                <div class="form-group">
                                    <i class="fa fa-phone"></i> &nbsp; <label for="email">Số điện thoại&nbsp;</label><%=user.getPhone()%>
                                </div>
                                <div class="form-group">
                                    <i class="fa fa-envelope"></i> &nbsp;   <label for="email">Email&nbsp;</label><%=user.getEmail()%>

                                </div>
                                <div class="form-group">
                                    <i class="glyphicon glyphicon-heart"></i> &nbsp;   <label for="email">Sở thích&nbsp;</label><%=user.getHobby()%>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div></div>
    </body>
</html>
