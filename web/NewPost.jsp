<%-- 
    Document   : NewPost
    Created on : Jul 25, 2018, 8:53:31 PM
    Author     : TramLuc
--%>

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

    <div class="row " style="margin-top: 50px">
        <div class="col-md-6 col-md-offset-3 form-container">
            <form action="./Servlet_AddNewPost" method="POST" enctype="multipart/form-data" id="reused_form">
               
                <div class="row">
                    <div class="col-sm-12 form-group">
                            <label for="comments">
                               Tạo bài viết mới: </label>
                             <input type="hidden" name="username" value="<%=getServletContext().getAttribute("username")%>">
                           <textarea class="form-control" type="textarea" name="newpost" id="comments" placeholder="Bạn đang nghĩ gì vậy??" maxlength="6000" rows="7"></textarea>
                           <br>
                               <input type="file" name="uploadFile" id="file" class="inputfile" data-multiple-caption="{count} files selected" multiple >
                               <label for="file"><i class="fa fa-image"></i> Thêm ảnh/Video</label>
                               <label id="result"></label>
                              
                               <input type="submit" class="btn btn-lg btn-warning btn-block" value="ĐĂNG">
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
