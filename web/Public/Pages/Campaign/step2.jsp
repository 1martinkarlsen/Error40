<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section class="step2">
    <ul class="poeItemList">
    <c:forEach var="poe" items="${sessionScope.allPOEs}">
        <c:if test="${poe.value['campaignID'] == sessionScope.cID}">
            <li><c:out value="${poe.value['name']}" /></li>
        </c:if>
    </c:forEach>
    </ul>
    
    
    <c:if test="${sessionScope.user.rank >= 2}">
        <a href="index.jsp?show=campaign.jsp?cID=${param.cID}&rank=${param.rank}&step=step3.jsp">Approve</a>
        <a href="#">Decline</a>
    </c:if>
</section>