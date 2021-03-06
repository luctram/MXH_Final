<%-- 
    Document   : Friend
    Created on : Jul 17, 2018, 9:17:06 PM
    Author     : TramLuc
--%>

<%@page import="DAO.UserDAO"%>
<%@page import="Model.Friends"%>
<%@page import="DAO.FriendsDAO"%>
<%@page import="Model.User"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
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
            int userid = (int)getServletContext().getAttribute("userid");
            List<Friends> listFriend = new ArrayList<Friends>();
            listFriend = FriendsDAO.getAllFriendByUserId(userid);
                  
        %>
        <div class="container">
                <h2>Danh sách bạn bè</h2>
                <div class="AddFriend">
                    <a href="RequestFriends.jsp" title="Lời mời kết bạn"><i class="fa fa-user-plus fa-2x"></i></a>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="NewFriend.jsp" title="Thêm bạn"><i class="fa fa-plus fa-2x"></i></a>
                </div>
                <br>
               
            <div class="row">
 <%
                            for(int i = 0; i< listFriend.size(); i++){
                                System.out.println("AAAAAAAA: " + listFriend.size());
                                User user= new User();
                                user = UserDAO.getInfoByUserId(listFriend.get(i).getFriendId());
                                System.out.println("BB" + user.getUserName());
 %>
                <div class="listfriend">
                    <div class="col-sm-12">
                       
                        
                        <div class="col-sm-1 FriendAvatar">
                            <img src="<%=user.getAvatarLink()%>" class="img-circle" width="55px" height="53px">
                        </div>
                        <div class="col-sm-9 FriendName">
                            <h4><a href="#"><%=user.getName()%></a></h4>
                        </div>
                        <div class="col-sm-2">
                            <form action="./Servlet_DeleteFriend" method="POST">
                                <input type="hidden" name="userid" value="<%=userid%>">
                                <input type="hidden" name="friendid" value="<%=listFriend.get(i).getFriendId()%>">
                            <span class="glyphicon glyphicon-map-marker text-muted c-info" data-toggle="tooltip" title="<%=user.getAddress()%>"></span>
                            <span class="glyphicon glyphicon-earphone text-muted c-info" data-toggle="tooltip" title="<%=user.getPhone()%>"></span>
                            <span class="glyphicon glyphicon-envelope text-muted c-info" data-toggle="tooltip" title="<%=user.getEmail()%>"></span>
                           <span class="glyphicon glyphicon-user text-muted c-info" data-toggle="tooltip" title="Bạn bè"></span>
                           
                               <input type="submit" value="Hủy bạn bè">
                           </form>
                        </div> 
                    </div>
                    <div class="clearfix"></div>
                    <hr />
                </div><%   }
                        %>
            </div>
        </div>
    </body>
</html>
