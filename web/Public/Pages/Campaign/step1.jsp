<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section class="step1">
    <c:forEach var="campaign" items="${sessionScope.allCampaigns}">
        <c:if test="${sessionScope.cID == campaign.value['id']}">
    <form action="Servlet?origin=updateCampaign" method="post">
        <p>Title</p>
        <input type="text" name="name" value="<c:out value="${campaign.value['name']}" />" />
        
        <p>Description</p>
        <textarea id="description_textarea" name="description"><c:out value="${campaign.value['description']}" /></textarea>
        
        <p>Target</p>
        <input type="text" name="target" value="<c:out value="${campaign.value['target']}" />" />
        
        <c:forEach var="budget" items="${sessionScope.allBudget}">
            <c:if test="${budget.value['id'] == campaign.value['budgetID']}">
                <p>Cost</p>
                <input type="text" name="budget" value="<c:out value="${budget.value['amount']}" />" />
            </c:if>
        </c:forEach>
        
        <p>Start date</p>
        <select name="start_date" id="start_day" value="<c:out value="${campaign.value['start_day']}" />">
            <option value="<c:out value="${campaign.value['start_day']}" />"><c:out value="${campaign.value['start_day']}" /></option>
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
            <option value="6">6</option>
            <option value="7">7</option>
            <option value="8">8</option>
            <option value="8">8</option>
            <option value="9">9</option>
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
        
        <select name="start_month" id="start_month">
            <option value="<c:out value="${campaign.value['start_month']}" />"><c:out value="${campaign.value['start_month']}" /></option>
            <option value="1">January</option>
            <option value="2">February</option>
            <option value="3">March</option>
            <option value="4">April</option>
            <option value="5">May</option>
            <option value="6">June</option>
            <option value="7">July</option>
            <option value="8">August</option>
            <option value="9">September</option>
            <option value="10">October</option>
            <option value="11">November</option>
            <option value="12">December</option>
        </select>
        
        <select name="start_year" id="start_year">
            <option value="<c:out value="${campaign.value['start_year']}" />"><c:out value="${campaign.value['start_year']}" /></option>
            <option value="2015">2015</option>
            <option value="2016">2016</option>
        </select>
        
        <p>End date</p>
        <c:set var="end_day" value="${campaign.value['end_day']}" />
        <select name="end_date" id="end_day">
            <option value="<c:out value="${campaign.value['end_day']}" />"><c:out value="${campaign.value['end_day']}" /></option>
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
            <option value="6">6</option>
            <option value="7">7</option>
            <option value="8">8</option>
            <option value="9">9</option>
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
        
        <select name="end_month" id="end_month">
            <option value="<c:out value="${campaign.value['end_month']}" />"><c:out value="${campaign.value['end_month']}" /></option>
            <option value="1">January</option>
            <option value="2">February</option>
            <option value="3">March</option>
            <option value="4">April</option>
            <option value="5">May</option>
            <option value="6">June</option>
            <option value="7">July</option>
            <option value="8">August</option>
            <option value="9">September</option>
            <option value="10">October</option>
            <option value="11">November</option>
            <option value="12">December</option>
        </select>
        
        <select name="end_year" id="end_year">
            <option value="<c:out value="${campaign.value['end_year']}" />"><c:out value="${campaign.value['end_year']}" /></option>
            <option value="2015">2015</option>
            <option value="2016">2016</option>
        </select>
        
        <p>Objectives/Results</p>
        <input type="text" name="objectives" value="<c:out value="${campaign.value['objective']}" />" />
        
        <input type="submit" value="Update" id="updateButton" />
        <input type="hidden" name="hiddenUpdate" />
    </form>
        </c:if>
    </c:forEach>
    
    <div class="checkedApprove">
        <div class="checkedSeller">
            <img src="Public/images/User.png" id="imgSeller">
            <p>Seller</p>
        </div>
        <div class="checkedPartner">
            <img src="Public/images/User.png" id="imgPartner">
            <p>Partner</p>
        </div>
    </div>
    
    <div id="approve_buttons">
        <c:if test="${sessionScope.user.rank >= 2}">
            <div class="but_approve"><a href="index.jsp?show=campaign.jsp?cID=${campaign.value['id']}&step=step2.jsp">Approve</a></div>
            <div class="but_decline"><a href="#">Decline</a></div>
        </c:if>

        <c:if test="${sessionScope.user.rank == 1}">
            <div class="but_approve"><a href="index.jsp?show=campaign.jsp?cID=${campaign.value['id']}&step=step2.jsp">Approve</a></div>
            <div class="but_decline"><a href="#">Decline</a></div>
        </c:if>
    </div>
    
</section>