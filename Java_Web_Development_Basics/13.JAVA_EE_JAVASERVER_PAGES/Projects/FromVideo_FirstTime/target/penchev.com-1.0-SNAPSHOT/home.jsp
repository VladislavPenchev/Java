<%@ page import="java.util.Date" %>
<%@ page import="viewmodels.HomeViewModel" %>
<%@ page import="constants.ViewConstants" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script
            src="https://code.jquery.com/jquery-3.4.1.min.js"
            integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
            crossorigin="anonymous"></script>

</head>
<body>
    <h1>It works on <p><%=request.getAttribute("currentDate")%></p></h1>

    <% viewmodels.HomeViewModel viewModel = (HomeViewModel) request.getAttribute(ViewConstants.VIEW_MODEL_ATTRIBUTE_NAME); %>
        <h2>Hello <%= viewModel.getName() %></h2>
        <h2>Age <%= viewModel.getAge() %></h2>

    <% for (int i = 0; i < 5; i++) { %>
        <li><%= i %></li>
    <% } %>

    <script>
        const generateList = (users) => {
            return "<ul>" +
                users.map(user => "<li>" + user.name + "</li>")
                    .join("\n") +
                "</ul>"
        };
        //GET /users
        //Async JavaScript & XML
        $.ajax({
            url: "/api/users",
            method: 'GET',
            success: (users) => {
                const list = generateList(users);
                $('body').append(list);
            }
        });
    </script>
</body>
</html>