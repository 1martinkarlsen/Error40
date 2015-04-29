<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Campaign section -->
<section class="campaign">
    <c:forEach var="campaign" items="${sessionScope.allCampaigns}"> 
        <c:if test="${campaign.value['id'] == sessionScope.cID}">
    <!-- Show partner name -->
    <div class="campaign_partnerTitle">${campaign.value['name']}</div>
    
    <!-- Steps of the campaign -->
    <div class="campaign_stepsList"> 
        <ul>
            <li>
                <c:url value="<a href='index.jsp?show=campaign.jsp?cID=${campaign.value['name']}&step=step1.jsp'>" />
                <div class="campaign_step">Project Approval</div>
                <c:url value="</a>" />
            </li>
            <li><div class="campaign_check">&nbsp;</div></li>
            <li>
                <c:if test="${campaign.value['stepNumber'] >= 2}"><c:url value="<a href='index.jsp?show=campaign.jsp?cID=${campaign.value['name']}&step=step2.jsp'>" /></c:if>
                <div class="campaign_step">Proof of execution</div>
                <c:if test="${campaign.value['stepNumber'] >= 2}"><c:url value="</a>" /></c:if>
            </li>
            <li><div class="campaign_check">&nbsp;</div></li>
            <li>
                <c:if test="${campaign.value['stepNumber'] == 3}"><c:url value="<a href='index.jsp?show=campaign.jsp?cID=${campaign.value['name']}&step=step3.jsp'>" /></c:if>
                <div class="campaign_step">Payment</div>
                <c:if test="${campaign.value['stepNumber'] == 3}"><c:url value="</a>" /></c:if>
            </li>
        </ul>
    </div>
        </c:if>
    </c:forEach>

    <div class="campaign_content">
        <c:if test="${param.step == null}">
            <c:forEach var="campaign" items="${sessionScope.allCampaigns}">
                <c:if test="${campaign.value['id'] == sessionScope.cID}">
                    <!-- Import step 1 if campaigns step is at first step -->
                    <c:if test="${campaign.value['stepNumber'] == 1}">
                        <c:import url="Public/Pages/Campaign/step1.jsp" />
                    </c:if>

                    <!-- Import step 2 if campaigns step is at second step -->
                    <c:if test="${campaign.value['stepNumber'] == 2}">
                        <c:import url="Public/Pages/Campaign/step2.jsp" />
                    </c:if>

                    <!-- Import step 3 if campaigns step is at third step -->
                    <c:if test="${campaign.value['stepNumber'] == 3}">
                        <c:import url="Public/Pages/Campaign/step3.jsp" />
                    </c:if>
                </c:if>
            </c:forEach>
        </c:if>
        <c:if test="${param.step != null}">
            <c:import url="Public/Pages/Campaign/${param.step}"></c:import>
        </c:if>
    </div>
</section>