<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <!-- Meta -->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <!-- Style include -->
        <link href="Public/Style/main.css" type="text/css" rel="stylesheet">
        <link href="Public/Style/dashboard.css" type="text/css" rel="stylesheet">
        <link href="Public/Style/campaignSteps.css" type="text/css" rel="stylesheet">

        <!-- Title -->
        <title>Dell - MDF</title>

        <!-- JQuery include -->
        <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
        <script src="Library/JS/quarterTracker.js" type="text/javascript"></script>
        <script src="Library/JS/setDate.js" type="text/javascript"></script>
    </head>
    <body>
        
        <!-- Container start -->
        
        <div class="container">
            <!-- Header start -->
            <header>
                <!-- Logo start -->
                <div class="logo header_floats"><a href="<c:out value='index.jsp' />"><img id="logoImg" src="Public/images/logo.png" alt="" /></a></div> <!-- Logo end -->
                
                <!-- Navigation start -->
                <nav class="nav header_floats">
                    <ul>
                        <li><a href="<c:out value='Servlet?origin=showDefaultSite' />">Dashboard</a></li>
                        <c:if test="${sessionScope.user.rank >= 2}">
                        <li><a href="<c:out value='Servlet?origin=showPartnersFromAdmin' />">Show partners</a></li>
                        </c:if>
                    </ul>
                </nav> <!-- Navigation end -->
                
                <!-- Logout box start -->
                <div class="login_logout header_floats">
                    <a id="logout" href="Servlet?origin=logout">Logout</a>
                    <img id="userImg" src="Public/images/User.png" alt="" />
                    <c:if test="${sessionScope.user.rank > 0 && sessionScope.user != null}">
                        <p id="username">Welcome <c:out value="${sessionScope.user.firstName}"/></p>
                    </c:if>
                </div> <!-- Logout box end -->
            </header> <!-- Header end -->

            <!-- Content start - Her vises den enkelte sides indhold -->
            <section class="content">
                <c:if test="${param.show == null}">
                    <c:if test="${sessionScope.user == null}">
                        <c:redirect url="Public/Pages/login.jsp" />
                    </c:if>
                    <c:if test="${sessionScope.user.rank == 0}">
                        <c:redirect url="Public/Pages/login.jsp" />
                    </c:if>
                    <c:if test="${sessionScope.user.rank == 3}">
                        <c:import url="Public/Pages/home.jsp"></c:import>
                    </c:if>
                    <c:if test="${sessionScope.user.rank == 2}">
                        <c:import url="Public/Pages/home.jsp"></c:import>
                    </c:if>
                    <c:if test="${sessionScope.user.rank == 1}">
                        <c:import url="Public/Pages/home.jsp"></c:import>
                    </c:if>
                </c:if>
                
                <c:if test="${param.show != null}">
                    
                    <c:import url="Public/Pages/${param.show}"></c:import>
                </c:if>
            </section> <!-- Content end -->
        </div> <!-- Container end -->
    </body>
</html>