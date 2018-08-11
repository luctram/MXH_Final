<%-- 
    Document   : RequestFriends
    Created on : Aug 4, 2018, 10:25:17 PM
    Author     : TramLuc
--%>

<%@page import="DAO.UserDAO"%>
<%@page import="Model.User"%>
<%@page import="DAO.FriendsDAO"%>
<%@page import="java.util.List"%>
<%@page import="Model.Friends"%>
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
    <style>
.FriendName h4{
    margin-left: 20px;
}

    </style>
    <body>
        <%
             int userid = (int)getServletContext().getAttribute("userid");
             System.out.println(" A " + userid);
            List<Friends> listFriend = new ArrayList<Friends>();
             List<Friends> listFriendRequest = new ArrayList<Friends>();
            listFriend = FriendsDAO.getRequestFriendByUserid(userid);
            listFriendRequest = FriendsDAO.getRequestFromFriendByUserid(userid);
        %>
        <div class="container">
            <div class="col-sm-6">
                 <h3>YÊU CẦU KẾT BẠN</h3>
                 <%
                     for(int i = 0 ; i < listFriend.size(); i ++){
                         System.out.println("size yêu cầu  " + listFriend.size());
                          User user= new User();
                                user = UserDAO.getInfoByUserId(listFriend.get(i).getFriendId());
                                
                        
                     
%><div>
                 <div class="col-sm-1 FriendAvatar">
                        <img src="<%=user.getAvatarLink()%>" class="img-circle" width="55px" height="53px"  id="img">
                    </div>
                    <div class="col-sm-5 FriendName">
                        <h4><%=user.getName()%></h4>
                    </div>
                    <div class="col-sm-6">
                        
                        <form action="./Servlet_CancelRequest" method="POST" id="addfriend">
                            <input type="hidden" name="userid" value="<%=userid%>">
                                <input type="hidden" name="friendid" value="<%=user.getUserId()%>" id="friendname">
                            <input type="submit" value="Hủy yêu cầu" id="request">
                        </form>
                    </div></div><br><br>
                    <%}%>
            </div>
            
            <div class="col-sm-6">
             
        <h3>LỜI MỜI KẾT BẠN</h3>
        <%
                     for(int i = 0 ; i < listFriendRequest.size(); i++){
                          User user= new User();
                          user=UserDAO.getInfoByUserId(listFriendRequest.get(i).getFriendId());
                        
                     
                 %>
                 <div class="friendrequest">
                    <div class="col-sm-1 FriendAvatar">
                        <img src="<%=user.getAvatarLink()%>" class="img-circle" width="55px" height="53px"  id="img">
                    </div>
                    
                    <div class="col-sm-5 FriendName">
                        <h4><%=user.getName()%></h4>
                    </div>
                    
                    <div class="col-sm-6">
                        
                        <form action="./Servlet_AcceptFriend" method="POST" id="addfriend">
                            <input type="hidden" name="userid" value="<%=userid%>">
                             <input type="hidden" name="friendid" value="<%=listFriendRequest.get(i).getFriendId()%>" id="friendname">
                            <input type="submit" value="Đồng ý" id="request">
                        </form>
                                
                        <form action="./Servlet_CancelRequest" method="POST" id="addfriend">
                            <input type="hidden" name="userid" value="<%=listFriendRequest.get(i).getFriendId()%>">
                            <input type="hidden" name="friendid" value="<%=userid%>" id="friendname">
                            <input type="submit" value="Xóa lời mời" id="request">
                        </form>
                     </div></div><br><br><%}%>
            </div>
        </div>
    </body>
</html>
