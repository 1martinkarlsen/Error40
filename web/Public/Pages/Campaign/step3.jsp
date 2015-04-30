<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section class="step3">
    <c:forEach var="campaign" items="${sessionScope.allCampaigns}">
        <c:if test="${campaign.value['id'] == sessionScope.cID}">
            <c:forEach var="user" items="${sessionScope.allUsers}">
                <c:if test="${user.value['id'] == campaign.value['sellerID']}">
                    <c:set var="seller" value="${user.value['firstName']}" />
                </c:if>
                <c:if test="${user.value['id'] == campaign.value['partnerID']}">
                    <c:set var="partner" value="${user.value['firstName']}" />
                </c:if>
            </c:forEach>
                <div class="step3_table">
                    <div class="step3_row">
                        <div class="step3_cell"><b>Name:</b></div>
                        <div class="step3_cell"><c:out value="${campaign.value['name']}" /></div>
                    </div>

                    <div class="step3_row">
                        <div class="step3_cell"><b>Partner name:</b></div>
                        <div class="step3_cell"><c:out value="${partner}" /></div>
                    </div>
                        
                    <div class="step3_row">
                        <div class="step3_cell"><b>Seller name:</b></div>
                        <div class="step3_cell"><c:out value="${seller}" /></div>
                    </div>

                    <div class="step3_row">
                        <div class="step3_cell"><b>Start date:</b></div>
                        <div class="step3_cell"><c:out value="${campaign.value['start_day']}/${campaign.value['start_month']}/${campaign.value['start_year']}" /></div>
                    </div>
                        
                    <div class="step3_row">
                        <div class="step3_cell"><b>End date:</b></div>
                        <div class="step3_cell"><c:out value="${campaign.value['end_day']}/${campaign.value['end_month']}/${campaign.value['end_year']}" /></div>
                    </div>
                        
                    <div class="step3_row">
                        <c:forEach var="budget" items="${sessionScope.allBudget}">
                            <c:if test="${budget.value['id'] == campaign.value['budgetID']}">
                        <div class="step3_cell"><b>Cost:</b></div>
                        <div class="step3_cell"><c:out value="${budget.value['amount']}" /> $</div>
                            </c:if>
                        </c:forEach>
                    </div>
                    
                    <div class="step3_row">
                        <div class="step3_cell"><b>Target:</b></div>
                        <div class="step3_cell"><c:out value="${campaign.value['target']}" /></div>
                    </div>
                    
                    <div class="step3_row">
                        <div class="step3_cell"><b>Objectives/Results:</b></div>
                        <div class="step3_cell"><c:out value="${campaign.value['objective']}" /></div>
                    </div>
                </div>
        </c:if>
    </c:forEach>
</section>

<!--
    Faktura oversigt. Kampagne-navn, start- og slut dato, links til forslag og POE, samt budget osv.
    Knap som sender til betaling (betaling skal ikke laves).
-->