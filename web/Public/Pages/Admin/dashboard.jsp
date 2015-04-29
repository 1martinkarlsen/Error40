<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="quarterList">
    <ul>
        <li id="quarter1">1. Quarter</li>
        <li id="quarter2">2. Quarter</li>
        <li id="quarter3">3. Quarter</li>
        <li id="quarter4">4. Quarter</li>
    </ul>
</div>

<!-- Dashboard -->
<section class="dashboard">
    <!-- Dashboard header -->
    <div class="dash_header">
        <div class="dash_table">
            <div class="dash_table-row">
                <div class="dash_table-cell dash_cell_h1">Last updated</div>
                <div class="dash_table-cell">xxx</div>
            </div>

            <div class="dash_table-row">
                <div class="dash_table-cell dash_cell_h1">Last finance report</div>
                <div class="dash_table-cell">xxx</div>
            </div>

            <div class="dash_table-row">
                <div class="dash_table-cell dash_cell_h1">Status</div>
                <div class="dash_table-cell">In progress</div>
            </div>
        </div>
    </div>

    <!-- Dashboard content -->
    <div class="dash_content dashboard_table">
        <div class="dashboard_table_row dash_headerRow">
            <div class="dashboard_table_cell dashboard_headCells">&nbsp;</div>
            <div class="dashboard_table_cell dashboard_headCells">Amount campaigns</div>
            <div class="dashboard_table_cell dashboard_headCells">Budget $</div>
            <div class="dashboard_table_cell dashboard_headCells">Budget $ used</div>
            <div class="dashboard_table_cell dashboard_headCells">Pending campaigns</div>
            <div class="dashboard_table_cell dashboard_headCells">Pending campaigns in $</div>
            <div class="dashboard_table_cell dashboard_headCells">Completed campaigns</div>
            <div class="dashboard_table_cell dashboard_headCells">Completed campaigns in $</div>
        </div>

        <c:forEach var="line" items="${sessionScope.allAdminLines}">
        <div class="dashboard_table_row">
            <div class="dashboard_table_cell"><a href='<c:out value="Servlet?origin=showPartnersFromSeller&id=${line.value['sellerId']}"/>'><c:out value="${line.value['name']}" /></a></div>
            <div class="dashboard_table_cell"><c:out value="${line.value['amountCampaigns']}"/></div>
            <div class="dashboard_table_cell"><c:out value="${line.value['sellerBudget']}"/></div>
            <div class="dashboard_table_cell"><c:out value="${line.value['budget_used']}"/></div>
            <div class="dashboard_table_cell"><c:out value="${line.value['pendingCampaigns']}"/></div>
            <div class="dashboard_table_cell"><c:out value="${line.value['pendingCampaignsCost']}"/></div>
            <div class="dashboard_table_cell"><c:out value="${line.value['completedCampaigns']}"/></div>
            <div class="dashboard_table_cell"><c:out value="${line.value['completedCampaignsCost']}"/></div>
        </div>
        </c:forEach>
        
    </div>
</section>