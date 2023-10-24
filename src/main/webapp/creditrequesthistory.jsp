<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: yc
  Date: 21/10/2023
  Time: 00:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
    <script src="https://cdn.tailwindcss.com"></script>
<body>
<!--Follow link for animation in action https://play.tailwindcss.com/IpRdROqEoQ -->
<div class="bg-gray-200 min-h-screen flex items-center justify-center px-16">
    <div class="relative w-full max-w-lg">
        <div class="m-8 relative space-y-4">
            <c:forEach items="${items}" var="item">
                <div class="p-5 bg-white rounded-lg flex items-center justify-between space-x-8">
                    <div class="flex-1 flex justify-between items-center">
                        <div class="h-4 w-48 bg-gray-300 rounded text-center text-sm">${item.getCreationDate()}</div>
                        <div class="w-24 h-6 rounded-lg bg-gray-300 text-center text-sm">${item.getState().name()}</div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
</body>
</html>
