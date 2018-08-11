<%-- 
    Document   : ChangeAvatar
    Created on : Jul 30, 2018, 8:42:32 PM
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
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="css.css">
        <jsp:include page="menu.jsp"></jsp:include>
        <jsp:include page = "footer.jsp"></jsp:include>
    <c:set var="root" value="${pageContext.request.contextPath}"/>
</head>
<body>
    <div class="mainbody container-fluid">
        <div class="col-md-3 caidatleft">
            <div id="caidatleft">
                <p> <a href="UserInfo.jsp">Thông tin cá nhân</a>
                    <img src="img/setting.png" width="25px"></p>

                <p><a href="ChangePassword.jsp">Đổi mật khẩu</a>
                    <img src="img/security1.png" width="25px"></p>

                <p><a href="ChangeAvatar.jsp">Đổi hình đại diện</a>
                    <i class="fa fa-user-circle"></i></p>
            </div>
        </div>
        <div class="col-md-9 ttcnright">


            <h3 >ẢNH ĐẠI DIỆN</h3>
            <br>
            <div >
                <form action="./Servlet_UploadFile" method="POST" enctype="multipart/form-data" id="formavatar">
                    <div class="col-lg-12 col-md-12">

                        <input type="hidden" name="userid" value="<%=getServletContext().getAttribute("userid")%>">

                        <input type="file" name="uploadFile" id="file" class="inputfile" data-multiple-caption="{count} files selected" multiple >
                        <label for="file"><i class="fa fa-image"></i> Thêm ảnh</label>

                        
                    </div>
                    <div class="col-lg-12 col-md-12">

                        <img class="img-thumbnail img-responsive" src="" width="340px" height="300px" id="imgavatar">
                        <br>
                        <input type="submit" value="Upload" />
                    </div>                                    
                </form>

            </div>

        </div>
    </div>

    <script type="text/javascript">
        function readURL(input) {

            if (input.files && input.files[0]) {
                var reader = new FileReader();

                reader.onload = function (e) {
                    $('#imgavatar').attr('src', e.target.result);
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
