<%-- 
    Document   : thontincanhan1
    Created on : Jul 1, 2018, 10:28:14 PM
    Author     : TramLuc
--%>

<%@page import="DAO.UserDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.User"%>
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
            <script>
                var inputs = document.querySelectorAll('.inputfile');
                Array.prototype.forEach.call(inputs, function (input)
                {
                var label = input.nextElementSibling,
                        labelVal = label.innerHTML;
                input.addEventListener('change', function (e)
                {
                var fileName = '';
                if (this.files && this.files.length > 1)
                        fileName = (this.getAttribute('data-multiple-caption') || '').replace('{count}', this.files.length);
                else
                        fileName = e.target.value.split('\\').pop();
                if (fileName)
                        label.querySelector('span').innerHTML = fileName;
                else
                        label.innerHTML = labelVal;
                });
                });
                function selectYear(obj){
                var options = obj.children;
                String year = "";
                for (int i = 0; i < options.length; i++){
                if (options[i].selected){
                year += options[i].values;
                }
                }
                }
                function selectMonth(obj){
                var options = obj.children;
                String month = "";
                for (int i = 0; i < options.length; i++){
                if (options[i].selected){
                month += options[i].values;
                }
                }
                }
                function selectDay(obj){
                var options = obj.children;
                String day = "";
                for (int i = 0; i < options.length; i++){
                if (options[i].selected){
                day += options[i].values;
                }
                }
                }

            </script>
        </head>
        <body>
        <%
            User user = new User();
            int userid = (int)getServletContext().getAttribute("userid");
            user.setUserId(userid);
            user = UserDAO.getInfoByUserId(userid);

            String nam, thang, ngay, bday;
            bday = user.getBDay();
            if (bday.equals("")) {
                nam = "Năm";
                thang = "Tháng";
                ngay = "Ngày";
            } else {
                String[] str = bday.split("[/]");
                nam = str[2];
                thang = str[1];
                ngay = str[0];
            }
        %>
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
                <form action="./Servlet_EditInfoUser" method="POST">
                    <h3>CÀI ĐẶT TÀI KHOẢN</h3>
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div class="form-horizontal">
                                <input type="hidden" name="userid" value="<%=userid%>">
                                <label for="name">Tên</label>
                                <input type="text" class="form-control" id="name" value="<%=user.getName()%>" name="name">
                                <br><label for="othername">Tên khác</label>
                                <input type="text" class="form-control" id="othername" value="<%=user.getUserName()%>" >               
                                <br><label for="phone">Số điện thoại</label>
                                <input type="text" class="form-control" id="othername" value="<%=user.getPhone()%>" name="phone">                        
                                <br><label for="email">Email</label>
                                <input type="text" class="form-control" id="othername" value="<%=user.getEmail()%>" name="email">
                                <br><label for="address">Đang sống tại</label>
                                <input type="text" class="form-control" id="address" value="<%=user.getAddress()%>" name="address">
                                <br><label for="hometown">Đến từ</label>
                                <input type="text" class="form-control" id="hometown" value="<%=user.getHometown()%>" name="hometown">
                                <br>
                                <label>Ngày sinh</label>
                                <div class="form-inline" id="birth-date">
                                    <select id="profile_date_year" name="profile[date][year]" class="form-control" onchange="selectYear(this)">
                                        <option value="" selected="selected"><%=nam%></option>
                                        <option value="2003">2003</option>
                                        <option value="2002">2002</option>
                                        <option value="2001">2001</option>
                                        <option value="2000">2000</option>
                                        <option value="1999">1999</option>
                                        <option value="1998">1998</option>
                                        <option value="1997">1997</option>
                                        <option value="1996">1996</option>
                                        <option value="1995">1995</option>
                                        <option value="1994">1994</option>
                                        <option value="1993">1993</option>
                                        <option value="1992">1992</option>
                                        <option value="1991">1991</option>
                                        <option value="1990">1990</option>
                                        <option value="1989">1989</option>
                                        <option value="1988">1988</option>
                                        <option value="1987">1987</option>
                                        <option value="1986">1986</option>
                                        <option value="1985">1985</option>
                                        <option value="1984">1984</option>
                                        <option value="1983">1983</option>
                                        <option value="1982">1982</option>
                                        <option value="1981">1981</option>
                                        <option value="1980">1980</option>
                                        <option value="1979">1979</option>
                                        <option value="1978">1978</option>
                                        <option value="1977">1977</option>
                                        <option value="1976">1976</option>
                                        <option value="1975">1975</option>
                                        <option value="1974">1974</option>
                                        <option value="1973">1973</option>
                                        <option value="1972">1972</option>
                                        <option value="1971">1971</option>
                                        <option value="1970">1970</option>
                                        <option value="1969">1969</option>
                                        <option value="1968">1968</option>
                                        <option value="1967">1967</option>
                                        <option value="1966">1966</option>
                                        <option value="1965">1965</option>
                                        <option value="1964">1964</option>
                                        <option value="1963">1963</option>
                                        <option value="1962">1962</option>
                                        <option value="1961">1961</option>
                                        <option value="1960">1960</option>
                                        <option value="1959">1959</option>
                                        <option value="1958">1958</option>
                                        <option value="1957">1957</option>
                                        <option value="1956">1956</option>
                                        <option value="1955">1955</option>
                                        <option value="1954">1954</option>
                                        <option value="1953">1953</option>
                                        <option value="1952">1952</option>
                                        <option value="1951">1951</option>
                                        <option value="1950">1950</option>
                                        <option value="1949">1949</option>
                                        <option value="1948">1948</option>
                                        <option value="1947">1947</option>
                                        <option value="1946">1946</option>
                                        <option value="1945">1945</option>
                                        <option value="1944">1944</option>
                                        <option value="1943">1943</option>
                                        <option value="1942">1942</option>
                                        <option value="1941">1941</option>
                                        <option value="1940">1940</option>
                                        <option value="1939">1939</option>
                                        <option value="1938">1938</option>
                                        <option value="1937">1937</option>
                                        <option value="1936">1936</option>
                                        <option value="1935">1935</option>
                                        <option value="1934">1934</option>
                                        <option value="1933">1933</option>
                                        <option value="1932">1932</option>
                                        <option value="1931">1931</option>
                                        <option value="1930">1930</option>
                                        <option value="1929">1929</option>
                                        <option value="1928">1928</option>
                                        <option value="1927">1927</option>
                                        <option value="1926">1926</option>
                                        <option value="1925">1925</option>
                                        <option value="1924">1924</option>
                                        <option value="1923">1923</option>
                                        <option value="1922">1922</option>
                                        <option value="1921">1921</option>
                                        <option value="1920">1920</option>
                                        <option value="1919">1919</option>
                                        <option value="1918">1918</option>
                                        <option value="1917">1917</option>
                                        <option value="1916">1916</option>
                                        <option value="1915">1915</option>
                                        <option value="1914">1914</option>
                                        <option value="1913">1913</option>
                                        <option value="1912">1912</option>
                                        <option value="1911">1911</option>
                                        <option value="1910">1910</option>
                                        <option value="1909">1909</option>
                                        <option value="1908">1908</option>
                                        <option value="1907">1907</option>
                                        <option value="1906">1906</option>
                                        <option value="1905">1905</option>
                                        <option value="1904">1904</option>
                                        <option value="1903">1903</option>
                                        <option value="1902">1902</option>
                                        <option value="1901">1901</option>
                                        <option value="1900">1900</option>
                                        <option value="1899">1899</option>
                                        <option value="1898">1898</option>
                                        <option value="1897">1897</option>
                                        <option value="1896">1896</option>
                                        <option value="1895">1895</option>
                                        <option value="1894">1894</option>
                                        <option value="1893">1893</option>
                                        <option value="1892">1892</option>
                                        <option value="1891">1891</option>
                                    </select>
                                    <select id="profile_date_month" name="profile[date][month]" class="form-control" onchange="selectMonth(this)"> 
                                        <option value="" selected="selected"><%=thang%></option>
                                        <option value="01">01</option>
                                        <option value="02">02</option>
                                        <option value="03">03</option>
                                        <option value="04">04</option>
                                        <option value="05">05</option>
                                        <option value="06">06</option>
                                        <option value="07">07</option>
                                        <option value="08">08</option>
                                        <option value="09">09</option>
                                        <option value="10">10</option>
                                        <option value="11">11</option>
                                        <option value="12">12</option>
                                    </select>
                                    <select id="profile_date_day" name="profile[date][day]" class="form-control" onchange="selectDay(this)">
                                        <option value="" selected="selected"><%=ngay%></option>
                                        <option value="01">01</option>
                                        <option value="02">02</option>
                                        <option value="03">03</option>
                                        <option value="04">04</option>
                                        <option value="05">05</option>
                                        <option value="06">06</option>
                                        <option value="07">07</option>
                                        <option value="08">08</option>
                                        <option value="09">09</option>
                                        <option value="10">10</option>
                                        <option value="11">11</option>
                                        <option value="12">12</option>
                                        <option value="13">13</option>
                                        <option value="14">14</option>
                                        <option value="15">15</option>
                                        <option value="16">16</option>
                                        <option value="17">17</option>
                                        <option value="18">18</option>
                                        <option value="19">19</option>
                                        <option value="20">20</option>
                                        <option value="21">21</option>
                                        <option value="22">22</option>
                                        <option value="23">23</option>
                                        <option value="24">24</option>
                                        <option value="25">25</option>
                                        <option value="26">26</option>
                                        <option value="27">27</option>
                                        <option value="28">28</option>
                                        <option value="29">29</option>
                                        <option value="30">30</option>
                                        <option value="31">31</option>
                                    </select>

                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="panel panel-default">
                        <div class="panel-body">
                            <h3 class="panel-title pull-left">Sở thích</h3>
                            <br><br>
                            <div class="form-horizontal">
                                <input type="text" class="form-control" name="hobby" placeholder="Like #movies #kittens #travel #teacher #newyork" value="<%=user.getHobby()%>" name="hobby">
                            </div>
                        </div>
                    </div>
                   
                    <input type="submit" value="Lưu thông tin">

                </form>
            </div>
        </div>
       
    </body>
</html>
