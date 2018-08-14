<%-- 
    Document   : EditPost
    Created on : Aug 6, 2018, 4:24:57 PM
    Author     : TramLuc
--%>

<%@page import="DAO.FileDAO"%>
<%@page import="DAO.UserPostDAO"%>
<%@page import="Model.UserPost"%>
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
    String id = request.getParameter("idpost1");
  
    int postid= Integer.parseInt(id);
    UserPost upost = new UserPost();
    upost = UserPostDAO.get1Post(postid);
    
    
%>
    <div class="row " style="margin-top: 50px">
        <div class="col-md-6 col-md-offset-3 form-container">
            <form action="./Servlet_EditPost" method="POST" enctype="multipart/form-data" id="reused_form">
                <input type="hidden" value="<%=postid%>" name="id">
                <input type="hidden" name="link" value="<%=upost.getImgVideoLink()%>">
                <div class="row">
                    <div class="col-sm-12 form-group">
                            <label for="comments">
                               Chỉnh sửa bài viết: </label>
                        <label>Ngày <%=upost.getDate()%></label>
                           <textarea class="form-control" type="textarea" name="content" id="comments" maxlength="6000" rows="7"><%=upost.getContent()%></textarea>
                           <br>
                               <input type="file" name="uploadFile" id="file" class="inputfile" data-multiple-caption="{count} files selected" multiple >
                               
                                 <%
                                if (!upost.getImgVideoLink().equals(" ")) {
                                    int check = FileDAO.checkfile(upost.getImgVideoLink());
                                    if (check == 0) {
                            %>
                            <img src="<%=upost.getImgVideoLink()%>" width="300px" height="150px" >
                            <%} else if (check == 1) {%>
                            <video width="320" height="240" controls>
                                <source src="<%=upost.getImgVideoLink()%>" type="video/mp4">
                            </video>
                            
                            <%}}%>
                            <br><br><br>
                               <label for="file"><i class="fa fa-image"></i> Thêm ảnh/Video</label>
                               
                               <label id="result"></label>
                              
                               <input type="submit" class="btn btn-lg btn-warning btn-block" value="LƯU THAY ĐỔI">
                       
                    </div>
                </div>
            </form>
        </div>
    </div>
   <script>
         function readURL(input) {

            if (input.files && input.files[0]) {
                var reader = new FileReader();

                reader.onload = function (e) {
                  // $('#imgavatar').attr('src', e.target.result);
                  document.getElementById("result").innerHTML = "Load hình thành công!!";
                }

                reader.readAsDataURL(input.files[0]);
            }
        }

        $("#file").change(function () {
            readURL(this);
        });
        
        
    </script>
</body>
</html>
