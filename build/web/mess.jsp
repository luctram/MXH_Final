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
    <body onload = "ok();">
          <%
        int userid = (int)getServletContext().getAttribute("userid");
    String avatarlink = UserDAO.getAvatarToShowHomePage(userid);
    
    List<Friends> listFriend = new ArrayList<Friends>();
            listFriend = FriendsDAO.getAllFriendByUserId(userid);
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
                                    name= UserDAO.getNameToShowHomePage(listFriend.get(i).getFriendId());
                                    avatar = UserDAO.getAvatarToShowHomePage(listFriend.get(i).getFriendId());
                                
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
                                    name= UserDAO.getNameToShowHomePage(12);
                                    avatar = UserDAO.getAvatarToShowHomePage(12);
                                
                            %>
                            <div class="new_message_head">
                                <div class="pull-left"><a href="#"><img src="<%=avatar%>" class="img-circle" width="45px">&nbsp;&nbsp;&nbsp;    
                                <%=name%></a></div>
                                <div class="pull-right">
                                   </div>
                            </div><!--new_message_head-->

                            <input type="text" value="<%=userid%>" id="me">
                            <input type="text" value="tramluc" id="myfriend">
                            <div class="chat_area">
                                <ul class="list-unstyled">
                                    <div id ="mess">
                                        asdfdsafdsfafds
                                    </div>
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




</div> <!--/main-->
<script type="text/javascript">
    function ok(){
//            $.ajax({
//                type: 'POST', url: './Servlet_Mess', data: { "user1" : me , "user2" : myfen }, dataType:text, success: function(data){
//                    alert("OK");
//                    var result = data;
//                       document.getElementById("mess").innerHTML = result;
//                }
//            , error: function(data) {
//            alert('woops!');
//            });
//         var refInterval = window.setInterval('update()', 1000); // 30 seconds
        setInterval(load(), 500);
    }
    function load(){
        var oldscrollHeight = $("#mess").attr("scrollHeight") - 20;
        $.post("Servlet_Mess",
        {
          user1: "tramluc",
          user2: "baocuong0501"
        },
        function(data){
            document.getElementById("mess").innerHTML = data;
            var newscrollHeight = $("#mess").attr("scrollHeight") - 20; //Scroll height after the request
				if(newscrollHeight > oldscrollHeight){
					$("#mess").animate({ scrollTop: newscrollHeight }, 'normal'); //Autoscroll to bottom of div
				}	
        });
    }
            
</script>
</body>
</html>
