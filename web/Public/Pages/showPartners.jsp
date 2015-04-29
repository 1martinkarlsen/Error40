<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Dashboard -->
<section class="dashboard">

    <!-- Show partners -->
    <div class="dash_content dashboard_table">
        <div class="dashboard_table_row dash_headerRow">
            <div class="dashboard_table_cell dashboard_headCells">&nbsp;</div>
            <div class="dashboard_table_cell dashboard_headCells">Amount campaigns</div>
            <div class="dashboard_table_cell dashboard_headCells">Budget used $</div>
            <div class="dashboard_table_cell dashboard_headCells">Pending campaigns</div>
            <div class="dashboard_table_cell dashboard_headCells">Pending campaigns in $</div>
            <div class="dashboard_table_cell dashboard_headCells">Completed campaigns</div>
            <div class="dashboard_table_cell dashboard_headCells">Completed campaigns in $</div>
        </div>

        <c:forEach var="line" items="${sessionScope.allSellerLines}">
            
                <div class="dashboard_table_row">
                    <div class="dashboard_table_cell"><a href='<c:out value="Servlet?origin=showCampaignsFromPartner&id=${line.value['partnerId']}"/>'><c:out value="${line.value['name']}" /></a></div>
                    <div class="dashboard_table_cell"><c:out value="${line.value['amountCampaigns']}" /></div>
                    <div class="dashboard_table_cell"><c:out value="${line.value['budget_used']}" /></div>
                    <div class="dashboard_table_cell"><c:out value="${line.value['pendingCampaigns']}" /></div>
                    <div class="dashboard_table_cell"><c:out value="${line.value['pendingCampaignsCost']}" /></div>
                    <div class="dashboard_table_cell"><c:out value="${line.value['completedCampaigns']}" /></div>
                    <div class="dashboard_table_cell"><c:out value="${line.value['completedCampaignsCost']}" /></div>

                </div>
            

        </c:forEach>
    </div>
</section>