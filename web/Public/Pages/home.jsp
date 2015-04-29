<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- If admin, import the admin dashboard -->
<c:if test="${sessionScope.user.rank == 3}">
    <c:import url="Public/Pages/Admin/dashboard.jsp" />
</c:if>

<!-- If seller, import the seller dashboard -->
<c:if test="${sessionScope.user.rank == 2}">
    <c:import url="Public/Pages/Seller/dashboard.jsp" />
</c:if>

<!-- If partner, import the partner dashboard -->
<c:if test="${sessionScope.user.rank == 1}">
    <c:import url="Public/Pages/Partner/dashboard.jsp" />
</c:if>