<%-- 
    Document   : mess
    Created on : Jun 24, 2018, 10:47:12 AM
    Author     : TramLuc
--%>

<%@page import="DAO.FriendsDAO"%>
<%@page import="Model.Friends"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css" />
        <link rel="stylesheet" href="css.css">
        <jsp:include page="menu.jsp"></jsp:include>
        <jsp:include page = "footer.jsp"></jsp:include>
    </head>
    <body>
          <%
        String username = getServletContext().getAttribute("username").toString();
    String avatarlink = UserDAO.getAvatarToShowHomePage(username);
    
    List<Friends> listFriend = new ArrayList<Friends>();
            listFriend = FriendsDAO.getAllFriendByUsername(username);
    %>
              <div class="main_section">
            <div class="container">
                <div class="chat_container">
                    <div class="col-sm-3 chat_sidebar">
                        <div class="row">
                            <div id="mess-search">
                                <div class="input-group col-md-12">
                                    <input type="text" class="  search-query form-control" placeholder="Cuộc trò chuyện" />
                                    <button class="btn btn-danger" type="button">
                                        <span class=" glyphicon glyphicon-search"></span>
                                    </button>
                                </div>
                            </div>
                            <div class="dropdown all_conversation">
                                <button class="dropdown-toggle" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <i class="fa fa-weixin" aria-hidden="true"></i>
                                    Tất cả cuộc trò chuyện
                                </button>
                                
                            </div>
                           
                            <div class="member_list">
                                 <%
                                for(int i = 0; i< listFriend.size(); i++){
                                     String name, avatar;
                                    name= UserDAO.getNameToShowHomePage(listFriend.get(i).getFriendName());
                                    avatar = UserDAO.getAvatarToShowHomePage(listFriend.get(i).getFriendName());
                                
                            %>
                                <ul class="list-unstyled">
                                    <li class="left clearfix">
                                        <span class="chat-img pull-left">
                                            <img src="<%=avatar%>" alt="User Avatar" class="img-circle">
                                        </span>
                                        <div class="chat-body clearfix">
                                            <div class="header_sec">
                                                <strong class="primary-font"><%=name%></strong> <strong class="pull-right">
                                                   </strong>
                                            </div>
                                        </div>
                                    </li>
                                </ul><%}%>
                            </div>
                        
                        </div>
                    </div>
                    <!--chat_sidebar-->


                    <div class="col-sm-9 message_section">
                        <div class="row">
                            <%
                                     String name, avatar;
                                    name= UserDAO.getNameToShowHomePage("baocuong0501");
                                    avatar = UserDAO.getAvatarToShowHomePage("baocuong0501");
                                
                            %>
                            <div class="new_message_head">
                                <div class="pull-left"><a href="#"><img src="<%=avatar%>" class="img-circle" width="45px">&nbsp;&nbsp;&nbsp;    
                                <%=name%></a></div>
                                <div class="pull-right">
                                   </div>
                            </div><!--new_message_head-->

                            <div class="chat_area">
                                <ul class="list-unstyled">
                                    <li class="left clearfix">
                                        <span class="chat-img1 pull-left">
                                            <img src="<%=avatar%>" alt="User Avatar" class="img-circle">
                                        </span>
                                        <div class="chat-body1 clearfix">
                                            <p>heyy Long time no see</p>
                                            <div class="chat_time pull-right">09:40PM</div>
                                        </div>
                                    </li>
                                    
                                   
                                    <li class="left clearfix admin_chat">
                                        <span class="chat-img1 pull-right">
                                            <img src="<%=avatarlink%>" alt="User Avatar" class="img-circle">
                                        </span>
                                        <div class="chat-body1 clearfix">
                                            <p>Hahaa yehh </p>
                                            <div class="chat_time pull-left">09:41PM</div>
                                        </div>
                                    </li>
                                    
                                     <li class="left clearfix admin_chat">
                                        <span class="chat-img1 pull-right">
                                            <img src="<%=avatarlink%>" alt="User Avatar" class="img-circle">
                                        </span>
                                        <div class="chat-body1 clearfix">
                                            <p>i have been worked so now i'm busy :))</p>
                                            <div class="chat_time pull-left">09:41PM</div>
                                        </div>
                                    </li>
                                    
                                     <li class="left clearfix admin_chat">
                                        <span class="chat-img1 pull-right">
                                            <img src="<%=avatarlink%>" alt="User Avatar" class="img-circle">
                                        </span>
                                        <div class="chat-body1 clearfix">
                                            <p>but tomorrow i'll off</p>
                                            <div class="chat_time pull-left">09:42PM</div>
                                        </div>
                                    </li>
                                        
                                        
                                    <li class="left clearfix">
                                        <span class="chat-img1 pull-left">
                                            <img src="<%=avatar%>" alt="User Avatar" class="img-circle">
                                        </span>
                                        <div class="chat-body1 clearfix">
                                            <p>Oh</p>
                                            <div class="chat_time pull-right">09:45PM</div>
                                        </div>
                                    </li>
                                    
                                    <li class="left clearfix">
                                        <span class="chat-img1 pull-left">
                                            <img src="<%=avatar%>" alt="User Avatar" class="img-circle">
                                        </span>
                                        <div class="chat-body1 clearfix">
                                            <p>Would u wanna go coffee</p>
                                            <div class="chat_time pull-right">09:45PM</div>
                                        </div>
                                    </li>
                                    <li class="left clearfix">
                                        <span class="chat-img1 pull-left">
                                            <img src="<%=avatar%>" alt="User Avatar" class="img-circle">
                                        </span>
                                        <div class="chat-body1 clearfix">
                                            <p>Would u wanna go coffee</p>
                                            <div class="chat_time pull-right">09:46PM</div>
                                        </div>
                                    </li>
                                    
                                   
                                    <li class="left clearfix admin_chat">
                                        <span class="chat-img1 pull-right">
                                            <img src="<%=avatarlink%>" alt="User Avatar" class="img-circle">
                                        </span>
                                        <div class="chat-body1 clearfix">
                                            <p>I know a dog coffee shop </p>
                                            <div class="chat_time pull-left">09:46PM</div>
                                        </div>
                                    </li>
                                        
                                       
                                    <li class="left clearfix">
                                        <span class="chat-img1 pull-left">
                                            <img src="<%=avatar%>" alt="User Avatar" class="img-circle">
                                        </span>
                                        <div class="chat-body1 clearfix">
                                            <p>Great!!!!</p>
                                            <div class="chat_time pull-right">09:40PM</div>
                                        </div>
                                    </li>
                                    
                                   
                                    <li class="left clearfix admin_chat">
                                        <span class="chat-img1 pull-right">
                                            <img src="<%=avatarlink%>" alt="User Avatar" class="img-circle">
                                        </span>
                                        <div class="chat-body1 clearfix">
                                            <p>Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia.</p>
                                            <div class="chat_time pull-left">09:40PM</div>
                                        </div>
                                    </li>
                               
                                    <li class="left clearfix">
                                        <span class="chat-img1 pull-left">
                                            <img src="<%=avatar%>" alt="User Avatar" class="img-circle">
                                        </span>
                                        <div class="chat-body1 clearfix">
                                            <p>Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia.</p>
                                            <div class="chat_time pull-right">09:40PM</div>
                                        </div>
                                    </li>
                                    
                                   
                                    <li class="left clearfix admin_chat">
                                        <span class="chat-img1 pull-right">
                                            <img src="<%=avatarlink%>" alt="User Avatar" class="img-circle">
                                        </span>
                                        <div class="chat-body1 clearfix">
                                            <p>Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia.</p>
                                            <div class="chat_time pull-left">09:40PM</div>
                                        </div>
                                    </li>
                                </ul>
                            </div><!--chat_area-->
                            <div class="message_write">
                                <textarea class="form-control" placeholder="Nhập tin nhắn..."></textarea>
                                <div class="clearfix"></div>
                                <div class="chat_bottom">
                                    <i class="fa fa-camera"></i>
                                    <i class="fa fa-image"></i>
                                    <i class="fa fa-smile-beam"></i>
                                    <a href="#" class="pull-right btn btn-success">Gửi</a></div>
                                    
                            </div>
                        </div>
                    </div> <!--message_section-->
                </div>
            </div>
        </div>
    </div>
</div>


</div> <!--/main-->

</body>
</html>
