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
        <body onload = "load();">
        <%
            int userid = (int) getServletContext().getAttribute("userid");
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
                                    for (int i = 0; i < listFriend.size(); i++) {
                                        String namefriend, avatarfriend;
                                        namefriend = UserDAO.getNameToShowHomePage(listFriend.get(i).getFriendId());
                                        avatarfriend = UserDAO.getAvatarToShowHomePage(listFriend.get(i).getFriendId());

                                %>
                                <ul class="list-unstyled">
                                    <li class="left clearfix" onclick="setUser2(<%=listFriend.get(i).getFriendId()%>, '<%=namefriend%>', '<%=avatarfriend%>');">
                                        <span class="chat-img pull-left">
                                            <img src="<%=avatarfriend%>" alt="User Avatar" class="img-circle" >
                                        </span>
                                        <div class="chat-body clearfix">
                                            <div class="header_sec">
                                                <strong class="primary-font"><%=namefriend%></strong> <strong class="pull-right">
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

                            <div class="new_message_head">
                                <div class="pull-left"><img src="" class="img-circle" width="45px" height=43px" id = "imgfr">&nbsp;&nbsp;&nbsp;    
                                    <span id = "namefr"></span></div>
                                <div class="pull-right">
                                </div>
                            </div><!--new_message_head-->
                            <input type="hidden" value="00000000" id="indexx">
                            <input type="hidden" value="<%=userid%>" id="me">
                            <input type="hidden" value="" id="myfriendid">
                            <div class="chat_area" id = "mess">
                                
                            </div><!--chat_area-->
                            <div class="message_write">
                                <form action="./Servlet_SendMess" method="POST" id="sendmess">
                                    <input type="hidden" value="<%=userid%>" name="me">
                                    <input type="hidden" value="" name="myfriend" id="myfriendid1">
                                    <textarea class="form-control" placeholder="Nhập tin nhắn..." name="content" id="content"></textarea>
                                    <div class="clearfix"></div>
                                    <div class="chat_bottom">
                                        <i class="fa fa-camera"></i>
                                        <i class="fa fa-image"></i>
                                        <i class="fa fa-smile-beam"></i>

                                        <input type="submit" id="sendmes" value="Gửi"> 

                                    </div>                                
                                </form>

                            </div>
                        </div> <!--message_section-->
                    </div>
                </div>
            </div>




        </div> <!--/main-->
        <script type="text/javascript">
            var refreshInterval;
            var frm = $('#sendmess');
            frm.submit(function () {

                $.ajax({
                    type: frm.attr('method'), url: frm.attr('action'), data: frm.serialize(), success: function (data) {
                        var result = data;
                        
                    }
                });
                return false;
            });
//$('#content').attr("value", "");
//                        $('#content').attr("placeholder", "Nhập tin nhắn...");
//               var val= document.getElementById("content");
//                        var ph = document.getElementById("content");
//                        
//                        val.value = "";
//                        ph.placeholder ="Nhập tin nhắn..."";         
            function setUser2(x, y, z) {
                clearInterval(refreshInterval);
                var e = document.getElementById("namefr");
                var i = document.getElementById("imgfr");
                var fr = document.getElementById("myfriendid");
                var fr1 = document.getElementById("myfriendid1");
                e.innerHTML = y;
                i.src = z;
                fr.value = x;
                fr1.value =x;
                document.getElementById("indexx").value = "00000000";
                document.getElementById("mess").innerHTML = "";
                load();
            }
            function load() {
                var element = document.getElementById("mess");

                var index = document.getElementById("indexx");
                var me = document.getElementById("me");
                var myfriend = document.getElementById("myfriendid");
                $.post("Servlet_Mess",
                        {
                            user1: me.value,
                            user2: myfriend.value,
                            idMessageLastest: "00000000"
                        },
                        function (data) { // du lieu nay phai la du lieu moi, du lieu moi se co id message > hon id cua message hien tai
                            var str = "";
                            str = data;
                            index.value = str.slice(0, 8);
                            str = str.slice(8, str.length);
                            element.innerHTML = str;
                            element.scrollTop = element.scrollHeight;
                            refreshInterval = setInterval(addMessage, 500);
                        });
            }

            function addMessage() {
                var element = document.getElementById("mess");
                var index = document.getElementById("indexx");
                var me = document.getElementById("me");
                var myfriend = document.getElementById("myfriendid");
                
                $.post("Servlet_Mess",
                        {
                            user1: me.value,
                            user2: myfriend.value,
                            idMessageLastest: index.value
                        },
                        function (data) {
                            var str = "";
                            str = data;
                            index.value = str.slice(0, 8);
                            str = str.slice(8, str.length);
                            if (str.length == 0)
                                return;
                            element.innerHTML += str;
                            element.scrollTop = element.scrollHeight;
                            
                        });
                        
            }

        </script>
    </body>
</html>
