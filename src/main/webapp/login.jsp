<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Login</title>
    <style>
        form {
            border: 3px solid #f1f1f1;
        }

        /* Full-width inputs */
        input[type=text], input[type=password] {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            box-sizing: border-box;
        }

        /* Set a style for all buttons */
        input[type=submit] {
            background-color: #4CAF50;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            cursor: pointer;
            width: 100%;
        }

        /* Add a hover effect for buttons */
        input[type=submit]:hover {
            opacity: 0.8;
        }


        /* Add padding to containers */
        .container {
            padding: 16px;
        }
        .choose {
            display: block;
            position: relative;
            padding-left: 35px;
            margin-bottom: 12px;
            cursor: pointer;
            font-size: 22px;
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
        }

        .checkmark {
            position: absolute;
            top: 0;
            left: 0;
            height: 25px;
            width: 25px;
            background-color: #eee;
            border-radius: 50%;
        }

        /* On mouse-over, add a grey background color */
        .choose:hover input ~ .checkmark {
            background-color: #ccc;
        }

        /* When the radio button is checked, add a blue background */
        .choose input:checked ~ .checkmark {
            background-color: #2196F3;
        }

        /* Create the indicator (the dot/circle - hidden when not checked) */
        .checkmark:after {
            content: "";
            position: absolute;
            display: none;
        }

        /* Show the indicator (dot/circle) when checked */
        .choose input:checked ~ .checkmark:after {
            display: block;
        }

        /* Style the indicator (dot/circle) */
        .choose .checkmark:after {
            top: 9px;
            left: 9px;
            width: 8px;
            height: 8px;
            border-radius: 50%;
            background: white;
        }
    </style>
</head>
<body>
<%
    for (Cookie c : request.getCookies()) {
        if (c.getName().equalsIgnoreCase("user")) response.sendRedirect("/book");
    }
%>
<form action="<%=request.getContextPath()%>/login" method="post">
    <div class="container">
        <label>Username:</label> <input type="text" name="username" required><br>
        <label>Password:</label> <input type="password" name="password" required><br><br>
        <label for="login" class="choose">Login
            <input class="checkmark" type="radio" name="submit" id="login" value="login" checked>
        </label><br>
        <label for="register" class="choose">Register
            <input class="checkmark" type="radio" name="submit" id="register" value="register">
        </label><br>
        <input type="submit" value="submit">
    </div>
</form>

<%
    String err = request.getParameter("err");
    if ("1".equals(err)) {
        response.getWriter().print("<h4 style=\"color: red;\">Login Error! Invalid user</h4>");
    } else if ("0".equals(err)) {
        response.getWriter().print("<h4 style=\"color: green;\">Register Success!</h4>");
    } else if ("2".equals(err)) {
        response.getWriter().print("<h4 style=\"color: red;\">Register Failed! User existed</h4>");
    }
%>
</body>
</html>
