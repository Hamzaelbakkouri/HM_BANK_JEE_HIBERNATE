<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: yc
  Date: 19/10/2023
  Time: 19:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
<div class="bg-blue-500 py-4 px-8 text-white">
    <h1 class="text-2xl font-bold">Choose a Date and an Option</h1>

    <!-- Date Input -->
    <input type="date" class="block mt-4 p-2 border rounded-md" id="creationDate">

    <!-- Select Element -->
    <select class="block mt-4 p-2 border rounded-md" id="crReqState">
        <option value="Pending">En cours</option>
        <option value="Accepted">Acceptees</option>
        <option value="Refused">Refusees</option>
    </select>

    <button class="bg-white text-blue-500 mt-4 py-2 px-4 rounded-md hover:bg-blue-100" id="filterCrs">
        Envoyer
    </button>
</div>
<div class="container mx-auto bg-gray-50 p-8 antialiased">
    <div>
        <c:forEach items="${creditRequests}" var="item">
            <!-- start  -->
            <div class="bg-gray-100 mx-auto border-gray-500 border rounded-sm text-gray-700 mb-0.5 h-30">
                <div class="flex p-3 border-l-8 border-yellow-600">
                    <div class="space-y-1 border-r-2 pr-3">
                        <div class="text-sm leading-5 font-semibold"><span class="text-xs leading-4 font-normal text-gray-500"> Numéro #</span> ${item.getNbr()}</div>
                        <div class="text-sm leading-5 font-semibold"><span class="text-xs leading-4 font-normal text-gray-500 pr"> Agence #</span> ${item.getAgency().getCode()}</div>
                        <div class="text-sm leading-5 font-semibold">${item.getCreationDate()}</div>
                    </div>
                    <div class="flex-1">
                        <div class="ml-3 space-y-1 border-r-2 pr-3">
                            <div class="text-base leading-6 font-normal">${item.getClient().getCode()}</div>
                            <div class="text-sm leading-4 font-normal"><span class="text-xs leading-4 font-normal text-gray-500"> Description</span> ${item.getAmount()} Dhs -- ${item.getMonthDuration()} Mois -- ${item.getMonthlyPayment()} Dhs/Mois</div>
                            <div class="text-sm leading-4 font-normal"><span class="text-xs leading-4 font-normal text-gray-500"> Remarques</span> ${item.getNotes()}</div>
                        </div>
                    </div>

                    <c:if test="${item.getState().name().equals(\"Pending\")}">
                        <div class="border-r-2 pr-3">
                            <div >
                                <div class="refuseBtn ml-3 my-3 border-gray-200 border-2 bg-gray-300 p-1" id="r${item.getNbr()}">
                                    <div class="uppercase text-xs leading-4 font-medium">Refuser</div>
                                </div>
                            </div>
                        </div>
                        <div class="border-r-2 pr-3">
                            <div >
                                <div class="acceptBtn ml-3 my-3 border-gray-200 border-2 bg-gray-300 p-1" id="a${item.getNbr()}">
                                    <div class="uppercase text-xs leading-4 font-medium">Accepter</div>
                                </div>
                            </div>
                        </div>
                    </c:if>
                    <div>
                            <c:choose>
                                <c:when test="${item.getState().name().equals(\"pending\")}">
                                    <div class="ml-3 my-5 bg-yellow-600 p-1 w-20">
                                        <div class="uppercase text-xs leading-4 font-semibold text-center text-yellow-100">${item.getState().name()}</div>
                                    </div>
                                </c:when>
                                <c:when test="${item.getState().name().equals(\"accepted\")}">
                                    <div class="ml-3 my-5 bg-green-600 p-1 w-20">
                                        <div class="uppercase text-xs leading-4 font-semibold text-center text-yellow-100">${item.getState().name()}</div>
                                    </div>
                                </c:when>
                                <c:otherwise>
                                    <div class="ml-3 my-5 bg-red-600 p-1 w-20">
                                        <div class="uppercase text-xs leading-4 font-semibold text-center text-yellow-100">${item.getState().name()}</div>
                                    </div>
                                </c:otherwise>
                            </c:choose>
                    </div>
                    <div>
                        <button class="historyBtn text-gray-100 rounded-sm my-5 ml-2 focus:outline-none bg-gray-500" id="h${item.getNbr()}">
                            <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M19 9l-7 7-7-7" />
                            </svg>
                        </button>
                    </div>
                </div>
            </div>
            <!-- end -->
        </c:forEach>
    </div>
</div>

<script>

    let historyPage = "http://localhost:8080/HM_BANK_JEE-1.0-SNAPSHOT/creditrequests?nbr=";



    //-------------------------show history-----------------------------------------------

    let historybuttons = document.querySelectorAll(".historyBtn");

    historybuttons.forEach(function(historybutton) {
        historybutton.addEventListener("click", handleButtonClick);
    });

    function handleButtonClick(event) {
        window.location.href = historyPage+event.currentTarget.id.substring(1);
    }


    //--------------------Accept credit requests


    let acceptbuttons = document.querySelectorAll(".acceptBtn");

    acceptbuttons.forEach(function(acceptbutton) {
        acceptbutton.addEventListener("click", handleAcceptButtonClick);
    });

    function handleAcceptButtonClick(event) {
        window.location.href = historyPage+event.currentTarget.id.substring(1)+"&action=accept";
    }



    //------------------------Refuse credit requests---------------------------------------

    let refusebuttons = document.querySelectorAll(".refuseBtn");

    refusebuttons.forEach(function(refusebutton) {
        refusebutton.addEventListener("click", handleRefuseButtonClick);
    });

    function handleRefuseButtonClick(event) {
        window.location.href = historyPage+event.currentTarget.id.substring(1)+"&action=refuse";
    }

    //---------------------------filter credit requests-------------------------------------

    let filterBtn = document.getElementById("filterCrs");

    filterBtn.addEventListener("click",function () {

        let baseUrl = "http://localhost:8080/HM_BANK_JEE-1.0-SNAPSHOT/creditrequests?";

        let crReqState = document.getElementById("crReqState");

        if(crReqState.value!=null)
        {
            baseUrl+="crreqstate="+crReqState.value+"&";
        }

        let creationDate = document.getElementById("creationDate");

        if(creationDate.value!=null && creationDate.value!=='')
        {
            baseUrl+="creationdate="+creationDate.value;
        }

        window.location.href = baseUrl;

    });
</script>

</body>
</html>
