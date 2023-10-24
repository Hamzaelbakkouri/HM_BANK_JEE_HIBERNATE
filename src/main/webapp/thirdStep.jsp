<%@ page import="hm.bank.Model.DTO.Client" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/input_Range.css">
</head>
<script src="https://cdn.tailwindcss.com"></script>
<body>
<nav class="bg-gray-800">
    <div class="mx-auto max-w-7xl px-2 sm:px-4 lg:px-8">
        <div class="relative flex h-16 items-center justify-between">
            <div class="flex items-center px-2 lg:px-0">
                <div class="flex-shrink-0">
                    <img class="block h-8 w-auto lg:hidden"
                         src="https://freeiconshop.com/wp-content/uploads/edd/bank-flat.png" alt="Your Company">
                    <img class="hidden h-8 w-auto lg:block"
                         src="https://freeiconshop.com/wp-content/uploads/edd/bank-flat.png" alt="Your Company">
                </div>
                <div class="hidden lg:ml-6 lg:block">
                    <div class="flex space-x-4">
                        <a href="#"
                           class="rounded-md bg-gray-900 px-3 py-2 text-sm font-medium text-white">Credit Request
                            List</a>
                        <a href="#"
                           class="rounded-md bg-gray-900 px-3 py-2 text-sm font-medium text-white">List</a>
                        <a href="firstStep.jsp"
                           class="rounded-md bg-gray-900 px-3 py-2 text-sm font-medium text-white">Simulation</a>
                    </div>
                </div>
            </div>
            <div class="flex flex-1 justify-center px-2 lg:ml-6 lg:justify-end">
                <div class="w-full max-w-lg lg:max-w-xs">
                    <label for="search" class="sr-only">Search</label>
                    <div class="relative">
                        <div class="pointer-events-none absolute inset-y-0 left-0 flex items-center pl-3">
                            <svg class="h-5 w-5 text-gray-400" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20"
                                 fill="currentColor" aria-hidden="true">
                                <path fill-rule="evenodd"
                                      d="M9 3.5a5.5 5.5 0 100 11 5.5 5.5 0 000-11zM2 9a7 7 0 1112.452 4.391l3.328 3.329a.75.75 0 11-1.06 1.06l-3.329-3.328A7 7 0 012 9z"
                                      clip-rule="evenodd"></path>
                            </svg>
                        </div>
                        <input id="search" name="search"
                               class="block w-full rounded-md border border-transparent bg-gray-700 py-2 pl-10 pr-3 leading-5 text-gray-300 placeholder-gray-400 focus:border-white focus:bg-white focus:text-gray-900 focus:outline-none focus:ring-white sm:text-sm"
                               placeholder="Search" type="search">
                    </div>
                </div>
            </div>
            <div class="flex lg:hidden">

                <button type="button"
                        class="inline-flex items-center justify-center rounded-md p-2 text-gray-400 hover:bg-gray-700 hover:text-white focus:outline-none focus:ring-2 focus:ring-inset focus:ring-white"
                        aria-controls="mobile-menu" aria-expanded="false">
                    <span class="sr-only">Open main menu</span>
                    <svg class="block h-6 w-6" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24"
                         stroke-width="1.5" stroke="currentColor" aria-hidden="true">
                        <path stroke-linecap="round" stroke-linejoin="round"
                              d="M3.75 6.75h16.5M3.75 12h16.5m-16.5 5.25h16.5"></path>
                    </svg>
                    <svg class="hidden h-6 w-6" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24"
                         stroke-width="1.5" stroke="currentColor" aria-hidden="true">
                        <path stroke-linecap="round" stroke-linejoin="round" d="M6 18L18 6M6 6l12 12"></path>
                    </svg>
                </button>
            </div>
            <div class="hidden lg:ml-4 lg:block">
                <div class="flex items-center">

                    <div class="relative ml-4 flex-shrink-0">
                        <div>
                            <button type="button"
                                    class="flex rounded-full bg-gray-800 text-sm text-white focus:outline-none focus:ring-2 focus:ring-white focus:ring-offset-2 focus:ring-offset-gray-800"
                                    id="user-menu-button" aria-expanded="false" aria-haspopup="true">
                                <span class="sr-only">Open user menu</span>
                                <img class="h-8 w-8 rounded-full"
                                     src="https://icons.veryicon.com/png/o/miscellaneous/two-color-icon-library/user-286.png"
                                     alt="">
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="lg:hidden" id="mobile-menu">
        <div class="space-y-1 px-2 pt-2 pb-3">
            <a href="#" class="block rounded-md bg-gray-900 px-3 py-2 text-base font-medium text-white">Credits Requests
                List</a>
            <a href="#" class="block rounded-md bg-gray-900 px-3 py-2 text-base font-medium text-white">Clients List</a>
        </div>
        <div class="border-t border-gray-700 pt-4 pb-3">
            <div class="flex items-center px-5">
                <div class="flex-shrink-0">
                    <img class="h-10 w-10 rounded-full"
                         src="https://images.unsplash.com/photo-1472099645785-5658abf4ff4e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=facearea&facepad=2&w=256&h=256&q=80"
                         alt="">
                </div>
                <div class="ml-3">
                    <div class="text-base font-medium text-white">Tom Cook</div>
                    <div class="text-sm font-medium text-gray-400">tom@example.com</div>
                </div>
                <button type="button"
                        class="ml-auto flex-shrink-0 rounded-full bg-gray-800 p-1 text-gray-400 hover:text-white focus:outline-none focus:ring-2 focus:ring-white focus:ring-offset-2 focus:ring-offset-gray-800">
                    <span class="sr-only">View notifications</span>

                    <svg class="h-6 w-6" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24"
                         stroke-width="1.5" stroke="currentColor" aria-hidden="true">
                        <path stroke-linecap="round" stroke-linejoin="round"
                              d="M14.857 17.082a23.848 23.848 0 005.454-1.31A8.967 8.967 0 0118 9.75v-.7V9A6 6 0 006 9v.75a8.967 8.967 0 01-2.312 6.022c1.733.64 3.56 1.085 5.455 1.31m5.714 0a24.255 24.255 0 01-5.714 0m5.714 0a3 3 0 11-5.714 0"></path>
                    </svg>
                </button>
            </div>
            <div class="mt-3 space-y-1 px-2">
                <a href="#"
                   class="block rounded-md px-3 py-2 text-base font-medium text-gray-400 hover:bg-gray-700 hover:text-white">Your
                    Profile</a>
                <a href="#"
                   class="block rounded-md px-3 py-2 text-base font-medium text-gray-400 hover:bg-gray-700 hover:text-white">Settings</a>
                <a href="#"
                   class="block rounded-md px-3 py-2 text-base font-medium text-gray-400 hover:bg-gray-700 hover:text-white">Sign
                    out</a>
            </div>
        </div>
    </div>
</nav>

<%--Navigtion--%>
<div class="lg:border-t lg:border-b lg:border-gray-200">
    <nav class="mx-auto max-w-7xl px-4 sm:px-6 lg:px-8" aria-label="Progress">
        <ol role="list"
            class="overflow-hidden rounded-md lg:flex lg:rounded-none lg:border-l lg:border-r lg:border-gray-200">
            <li class="relative overflow-hidden lg:flex-1">
                <div class="border border-gray-200 overflow-hidden border-b-0 rounded-t-md lg:border-0">
                    <a href="firstStep.jsp" class="group">
                            <span class="absolute top-0 left-0 h-full w-1 bg-transparent group-hover:bg-gray-200 lg:bottom-0 lg:top-auto lg:h-1 lg:w-full"
                                  aria-hidden="true"></span>
                        <span class="px-6 py-5 flex items-start text-sm font-medium">
              <span class="flex-shrink-0">
                <span class="flex h-10 w-10 items-center justify-center rounded-full bg-indigo-600">
                  <svg class="h-6 w-6 text-white" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"
                       fill="currentColor" aria-hidden="true">
                    <path fill-rule="evenodd"
                          d="M19.916 4.626a.75.75 0 01.208 1.04l-9 13.5a.75.75 0 01-1.154.114l-6-6a.75.75 0 011.06-1.06l5.353 5.353 8.493-12.739a.75.75 0 011.04-.208z"
                          clip-rule="evenodd"></path>
                  </svg>
                </span>
              </span>
              <span class="mt-0.5 ml-4 flex min-w-0 flex-col">
                <span class="text-sm font-medium">Job Details</span>
                <span class="text-sm font-medium text-gray-500">Vitae sed mi luctus laoreet.</span>
              </span>
            </span>
                    </a>
                </div>
            </li>
            <li class="relative overflow-hidden lg:flex-1">
                <div class="border border-gray-200 overflow-hidden border-b-0 rounded-t-md lg:border-0">
                    <a href="home.jsp" class="group">
                            <span class="absolute top-0 left-0 h-full w-1 bg-transparent group-hover:bg-gray-200 lg:bottom-0 lg:top-auto lg:h-1 lg:w-full"
                                  aria-hidden="true"></span>
                        <span class="px-6 py-5 flex items-start text-sm font-medium">
              <span class="flex-shrink-0">
                <span class="flex h-10 w-10 items-center justify-center rounded-full bg-indigo-600">
                  <svg class="h-6 w-6 text-white" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"
                       fill="currentColor" aria-hidden="true">
                    <path fill-rule="evenodd"
                          d="M19.916 4.626a.75.75 0 01.208 1.04l-9 13.5a.75.75 0 01-1.154.114l-6-6a.75.75 0 011.06-1.06l5.353 5.353 8.493-12.739a.75.75 0 011.04-.208z"
                          clip-rule="evenodd"></path>
                  </svg>
                </span>
              </span>
              <span class="mt-0.5 ml-4 flex min-w-0 flex-col">
                <span class="text-sm font-medium">Job Details</span>
                <span class="text-sm font-medium text-gray-500">Vitae sed mi luctus laoreet.</span>
              </span>
            </span>
                    </a>
                </div>
            </li>
            <li class="relative overflow-hidden lg:flex-1">
                <div class="border border-gray-200 overflow-hidden lg:border-0">
                    <!-- Current Step -->
                    <a href="thirdStep.jsp" aria-current="step">
                            <span class="absolute top-0 left-0 h-full w-1 bg-indigo-600 lg:bottom-0 lg:top-auto lg:h-1 lg:w-full"
                                  aria-hidden="true"></span>
                        <span class="px-6 py-5 flex items-start text-sm font-medium lg:pl-9">
              <span class="flex-shrink-0">
                <span class="flex h-10 w-10 items-center justify-center rounded-full border-2 border-indigo-600">
                  <span class="text-indigo-600">03</span>
                </span>
              </span>
              <span class="mt-0.5 ml-4 flex min-w-0 flex-col">
                <span class="text-sm font-medium text-indigo-600">Application form</span>
                <span class="text-sm font-medium text-gray-500">Cursus semper viverra.</span>
              </span>
            </span>
                    </a>
                    <div class="absolute inset-0 top-0 left-0 hidden w-3 lg:block" aria-hidden="true">
                        <svg class="h-full w-full text-gray-300" viewBox="0 0 12 82" fill="none"
                             preserveAspectRatio="none">
                            <path d="M0.5 0V31L10.5 41L0.5 51V82" stroke="currentcolor"
                                  vector-effect="non-scaling-stroke"></path>
                        </svg>
                    </div>
                </div>
            </li>
        </ol>
    </nav>
</div>
<%
    Client client = (Client) session.getAttribute("client");
    String time = session.getAttribute("time").toString();
    String balance = session.getAttribute("balance").toString();
    String mb = session.getAttribute("mb").toString();
%>
<section class="w-full flex justify-center items-center mb-20" id="credit_simulation">
    <div class="w-[800px] bg-white pt-5 border-b-2 border-x-2 border-gray-300 p-16 rounded-b-md">
        <form class="mt-3" action="createcredit" method="post">
            <div class="mx-auto max-w-lg">
                <div class="py-1">
                    <span class="px-1 text-sm text-gray-600">code</span>
                    <input placeholder="Enter code" value="<%= client.getCode() %>" type="text"
                           class="text-md block px-3 py-2 rounded-lg w-full
                bg-white border-2 border-gray-300 placeholder-gray-600 shadow-md focus:placeholder-gray-500 focus:bg-white focus:border-gray-600 focus:outline-none">
                </div>
                <div class="py-1">
                    <span class="px-1 text-sm text-gray-600">First Name</span>
                    <input placeholder="Enter first name" value="<%= client.getFirstName() %>" type="text"
                           class="text-md block px-3 py-2 rounded-lg w-full
                bg-white border-2 border-gray-300 placeholder-gray-600 shadow-md focus:placeholder-gray-500 focus:bg-white focus:border-gray-600 focus:outline-none">
                </div>
                <div class="py-1">
                    <span class="px-1 text-sm text-gray-600">Last Name</span>
                    <input placeholder="Enter last name" value=" <%= client.getLastName() %>" type="text"
                           class="text-md block px-3 py-2 rounded-lg w-full
                bg-white border-2 border-gray-300 placeholder-gray-600 shadow-md focus:placeholder-gray-500 focus:bg-white focus:border-gray-600 focus:outline-none">
                </div>
                <div class="py-1">
                    <span class="px-1 text-sm text-gray-600">Birth Date</span>
                    <input placeholder="Enter birth name" value="<%= client.getBirthDate() %>"
                           type="date"
                           x-model="date"
                           class="text-md block px-3 py-2 rounded-lg w-full
                bg-white border-2 border-gray-300 placeholder-gray-600 shadow-md focus:placeholder-gray-500 focus:bg-white focus:border-gray-600 focus:outline-none">
                </div>
                <div class="py-1">
                    <span class="px-1 text-sm text-gray-600">Phone number</span>
                    <input placeholder="Enter phone number" value="<%= client.getPhoneNumber() %>" type="text"
                           class="text-md block px-3 py-2 rounded-lg w-full
                bg-white border-2 border-gray-300 placeholder-gray-600 shadow-md focus:placeholder-gray-500 focus:bg-white focus:border-gray-600 focus:outline-none">
                </div>
                <div class="py-1">
                    <span class="px-1 text-sm text-gray-600">Address</span>
                    <input placeholder="Enter address" value="<%= client.getAddress() %>" type="text"
                           class="text-md block px-3 py-2 rounded-lg w-full
                bg-white border-2 border-gray-300 placeholder-gray-600 shadow-md focus:placeholder-gray-500 focus:bg-white focus:border-gray-600 focus:outline-none">
                </div>
            </div>
            <div class="mx-auto max-w-lg">
                <div class="py-1">
                    <span class="px-1 text-sm text-gray-600">Montant (EN DH)</span>
                    <input placeholder="Montant" value="<%= balance %>" type="number"
                           class="text-md block px-3 py-2 rounded-lg w-full
                bg-white border-2 border-gray-300 placeholder-gray-600 shadow-md focus:placeholder-gray-500 focus:bg-white focus:border-gray-600 focus:outline-none">
                </div>
                <div class="py-1">
                    <span class="px-1 text-sm text-gray-600">DURÉE (EN MOIS)</span>
                    <input placeholder="DURÉE" value="<%= time %>" type="number"
                           class="text-md block px-3 py-2 rounded-lg w-full
                bg-white border-2 border-gray-300 placeholder-gray-600 shadow-md focus:placeholder-gray-500 focus:bg-white focus:border-gray-600 focus:outline-none">
                </div>
                <div class="py-1">
                    <span class="px-1 text-sm text-gray-600">MENSUALITÉS (EN DH)</span>
                    <input placeholder="MENSUALITÉS" value="<%= mb %>" type="number"
                           class="text-md block px-3 py-2 rounded-lg w-full
                bg-white border-2 border-gray-300 placeholder-gray-600 shadow-md focus:placeholder-gray-500 focus:bg-white focus:border-gray-600 focus:outline-none">
                </div>
                <div class="py-1">
                    <span class="px-1 text-sm text-gray-600">Ecrit des Notes</span>
                    <textarea name="notes" placeholder="MENSUALITÉS" type="text"
                              class="text-md block px-3 py-2 rounded-lg w-full
                bg-white border-2 border-gray-300 placeholder-gray-600 shadow-md focus:placeholder-gray-500 focus:bg-white focus:border-gray-600 focus:outline-none"></textarea>
                </div>
            </div>
            <button type="submit"
                    class="mt-5 text-lg font-semibold bg-gray-800 w-full text-white rounded-lg px-6 py-3 block shadow-xl hover:text-white hover:bg-black">
                Create request
            </button>
        </form>

    </div>
</section>
</body>
<script src="js/simulationCalculate.js"></script>
</html>