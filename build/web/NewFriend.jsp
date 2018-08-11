<%-- 
    Document   : Friend
    Created on : Jul 17, 2018, 9:17:06 PM
    Author     : TramLuc
--%>

<%@page import="Model.User"%>
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
                  
        %>
    <div class="container">
        <h2>THÊM BẠN MỚI</h2>
        <br>
        <div class="AddFriendForm">

            <form action="./Servlet_SearchFriend" method="POST" id="formfriend">
                <input type="text" name="friendinfo" placeholder=" Nhập tên/số điện thoại/email bạn cần tìm">
                <input type="submit" value="Tìm" name="search">

            </form>
            
        </div>
        <br>

        <div class="row">
            <div class="listfriend">
                <div class="col-sm-12">
                    <div class="col-sm-1 FriendAvatar">
                        <img src="" class="img-circle" width="55px" height="53px"  id="img">
                    </div>
                    <div class="col-sm-9 FriendName">
                        <h4><a href="#" id="namefriend"></a></h4>
                    </div>
                    <div class="col-sm-2">
                        <span class="glyphicon glyphicon-map-marker text-muted c-info" data-toggle="tooltip" title="" id="addressfriend"></span>

                        <span class="glyphicon glyphicon-earphone text-muted c-info" data-toggle="tooltip" title="" id="phonefriend"></span>

                        <span class="glyphicon glyphicon-envelope text-muted c-info" data-toggle="tooltip" title="" id="emailfriend"></span>
                        
                        <form action="./Servlet_RequestNewFriend" method="POST" id="addfriend">
                             <input type="hidden" name="userid" value="<%=userid%>">
                                <input type="hidden" name="friendid" value="" id="friendname">
                            <input type="submit" value="Gửi lời mời kết bạn" id="request">
                        </form>
                    </div>
                </div>
                <div class="clearfix"></div>
                <hr />
            </div>
        </div>
    </div>
       <script type="text/javascript">
            var frm = $('#formfriend');
            frm.submit(function(){
                
                $.ajax({
                    type: frm.attr('method'), url: frm.attr('action'), data: frm.serialize(), success: function(data){
                        var result = data;
                        //$('#result').attr("value",result);
                        var b= result.split("-");
                         $('#friendname').attr("value",b[0]);
                         $('#img').attr("src",b[5]);
                         $('#addressfriend').attr("title",b[4]);
                          $('#phonefriend').attr("title",b[3]);
                           $('#emailfriend').attr("title",b[2]);
                           document.getElementById("namefriend").innerHTML = b[1];
                    }
                });
                return false;
            });
            
        </script>
</body>
</html>
