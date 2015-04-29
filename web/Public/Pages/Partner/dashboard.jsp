<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
            <div class="dashboard_table_cell dashboard_headCells">Seller name</div>
            <div class="dashboard_table_cell dashboard_headCells">Budget</div>
            <div class="dashboard_table_cell dashboard_headCells">Current state</div>
        </div>

        <c:forEach var="line" items="${sessionScope.allPartnerLines}">
            <c:if test="${sessionScope.id == null}">

                <c:if test="${line.value['id'] == sessionScope.user.id}">
                    <div class="dashboard_table_row">
                        <div class="dashboard_table_cell"><a href='<c:out value="Servlet?origin=showSingleCampaign&cID=${line.value['campaignId']}"/>'><c:out value="${line.value['name']}"/></a></div>
                        <div class="dashboard_table_cell"><c:out value="${line.value['sellerName']}"/></div>
                        <div class="dashboard_table_cell"><c:out value="${line.value['budget']}"/></div>
                        <div class="dashboard_table_cell"><c:out value="${line.value['currentState']}"/></div>
                    </div>
                </c:if>

            </c:if>

            <c:if test="${sessionScope.id != null}">

                <c:if test="${line.value['id'] == sessionScope.id}">
                    <div class="dashboard_table_row">
                        <div class="dashboard_table_cell"><a href='<c:out value="Servlet?origin=showSingleCampaign&cID=${line.value['campaignId']}"/>'><c:out value="${line.value['name']}"/></a></div>
                        <div class="dashboard_table_cell"><c:out value="${line.value['sellerName']}"/></div>
                        <div class="dashboard_table_cell"><c:out value="${line.value['budget']}"/></div>
                        <div class="dashboard_table_cell"><c:out value="${line.value['currentState']}"/></div>
                    </div>
                </c:if>

            </c:if>


        </c:forEach>
    </div>
</section>