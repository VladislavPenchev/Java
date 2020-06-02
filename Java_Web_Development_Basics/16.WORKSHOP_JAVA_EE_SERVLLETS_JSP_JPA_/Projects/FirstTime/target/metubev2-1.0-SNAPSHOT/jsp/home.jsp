<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <c:import url="templates/head.jsp" />
</head>
<body>
<div class="container">
    <header>
        <c:import url="templates/navbar.jsp" />
    </header>
    <main>
        <hr class="my-3"/>
        <div class="jumbotron">
            <p class="h1 display-3">Welcome, <%= request.getSession().getAttribute("username")%></p>

        </div>
        <hr class="my-3"/>
    </main>
    <footer>
        <c:import url="templates/footer.jsp" />
    </footer>
</div>
</body>
</html>
