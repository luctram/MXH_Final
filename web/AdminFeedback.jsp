<%-- 
    Document   : Feedback
    Created on : Jul 17, 2018, 6:49:46 PM
    Author     : TramLuc
--%>

<%@page import="DAO.UserDAO"%>
<%@page import="DAO.FeedbackDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Model.Feedback"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MAKEFRIEND SOCIAL NETWORK ADMINISTRATOR</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <link rel="stylesheet" href="AdminPageCss.css">
        <jsp:include page="AdminMenu.jsp"></jsp:include>

        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <style>
            .column1 {
                width: 200px;
                padding-left: 40px;
            }

            .column2 {
                width:100px;
            }

            .column3 {
                width: 400px;
                padding-right: 62px;
            }
        </style>
    </head>
    <body>
     <% List<Feedback> feedback = new ArrayList<Feedback>();
                            feedback = FeedbackDAO.GetFeedBack();%>
        <div class="limiter">
            <div class="container-table100">
                <div class="wrap-table100">
                    <div class="table100">
                        <table>
                            <thead>
                                <tr class="table100-head">
                                    <th class="column1">Tên tài khoản</th>
                                    <th class="column2">Ngày</th>
                                    <th class="column3">Nội dung phản ảnh</th>
                                </tr>
                            </thead>
                            <tbody>
                            <%
                            for(int i =0; i<feedback.size(); i++)
                            {
                                String username = UserDAO.getNameToShowHomePage(feedback.get(i).getUserId());
                            %>
                                <tr>
                                    <td class="column1"><%=username%></td>
                                    <td class="column2"><%=feedback.get(i).getDate()%></td>
                                    <td class="column3"><%=feedback.get(i).getContents()%></td>
                                </tr>
                                <%} %>
                                
                             
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>




        <!--===============================================================================================-->	
        <script src="vendor/jquery/jquery-3.2.1.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/bootstrap/js/popper.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/select2/select2.min.js"></script>
        <!--===============================================================================================-->
        <script src="js/main.js"></script>
    </body>
</html>
