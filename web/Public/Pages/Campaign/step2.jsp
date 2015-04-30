<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section class="step2">
    <c:forEach var="poe" items="${sessionScope.allPOEs}">
        <c:if test="${poe.value['campaignID'] == sessionScope.cID}">
            <ul class="poeItemList">
                <li><c:out value="${poe.value['name']}" /></li>


            </ul>

            <c:forEach var="campaign" items="${sessionScope.allCampaigns}">
                <c:if test="${campaign.value['id'] == poe.value['campaignID']}">
                    <c:if test="${campaign.value['stepNumber'] == 2}">
                        <div class="approve_buttons">
                            <c:if test="${sessionScope.user.id == campaign.value['sellerID']}">
                                <div class="but_approve"><a href="Servlet?origin=approveCampaignPOE&choice=1">Approve</a></div>
                                <div class="but_decline"><a href="Servlet?origin=approveCampaignPOE&choice=2">Decline</a></div>
                            </c:if>
                        </div>
                    </c:if>
                </c:if>
            </c:forEach>
        </c:if>
    </c:forEach>
</section>