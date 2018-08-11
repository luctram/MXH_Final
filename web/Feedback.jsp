<%-- 
    Document   : Feedback
    Created on : Jul 17, 2018, 4:01:55 PM
    Author     : TramLuc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang='vi' class=''>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MAKEFRIEND SOCIAL NETWORK</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="css.css">
        <jsp:include page = "menu.jsp"></jsp:include>
        <jsp:include page = "footer.jsp"></jsp:include>
        <c:set var="root" value="${pageContext.request.contextPath}"/>
    <body>
        <div id="feedback">
            <form action="./Servlet_Feedback" method="POST">
               <input type="hidden" name="userid" value="<%=getServletContext().getAttribute("userid")%>">
               <textarea rows="15" cols="100" name="contents" >
                </textarea>
                 <br>
                 <input type="submit" value="Gửi phản ảnh">
        </form>
            </div>
    </body>
</html>
