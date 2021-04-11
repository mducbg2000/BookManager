<%@ page import="java.util.ArrayList" %>
<%@ page import="team5.book_manager.entities.BookEntity" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/4/2021
  Time: 10:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book List</title>
    <style>
        table {
            border-collapse: collapse;
            border-spacing: 0;
            width: 100%;
            border: 1px solid #ddd;
        }

        th, td {
            text-align: left;
            padding: 16px;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        input[type=submit] {
            background-color: #4CAF50;
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        /* When moving the mouse over the submit button, add a darker green color */
        input[type=submit]:hover {
            background-color: #45a049;
        }

        .topnav {
            overflow: hidden;
            background-color: #e9e9e9;
        }

        .topnav a {
            float: left;
            display: block;
            color: black;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
            font-size: 17px;
        }

        .topnav a:hover {
            background-color: #ddd;
            color: black;
        }

        .topnav a.active {
            background-color: #2196F3;
            color: white;
        }

        .topnav .search-container {
            float: right;
        }

        .topnav input[type=text] {
            padding: 6px;
            margin-top: 8px;
            font-size: 17px;
            border: none;
        }

        .topnav .search-container button {
            float: right;
            padding: 6px;
            margin-top: 8px;
            margin-right: 16px;
            background: #ddd;
            font-size: 17px;
            border: none;
            cursor: pointer;
        }

        .topnav .search-container button:hover {
            background: #ccc;
        }

    </style>
</head>
<body>
<% String user = "";
    Cookie[] cs = request.getCookies();
    for (Cookie c : cs) {
        if (c.getName().equalsIgnoreCase("user")) {
            user = user.concat(c.getValue());
        }
    }
    if (user.isEmpty()) response.sendRedirect("/login");
%>
<div class="topnav" style="background-color: white !important;">
    <h1 style="float: left">Hello <%=user%></h1>
    <a class="logout" href="/logout" style="background-color: red; border-radius: 5px; float: right ">Log out</a>
</div>
<label>
    <% String bookName = (String) request.getAttribute("bookName");
        if (bookName != null && bookName.length() > 0) response.getWriter().println("<h2>Key word: " + bookName + "</h2>");
    %>
</label>
<div class="topnav">
    <a class="left" href="/editBook.jsp">Add book</a>
    <a href="/book">All book</a>
    <div class="search-container">
        <form action="/book" method="get">
            <input type="text" name="name" required>
            <input type="submit" name="search" value="Search">
        </form>
    </div>
</div>
<table style="text-align: center">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Publisher</th>
        <th>Price</th>
        <th>Update</th>
        <th>Delete</th>
    </tr>
    <% ArrayList<BookEntity> books = (ArrayList<BookEntity>) request.getAttribute("data");
        if (books.size() == 0) response.getWriter().println("Don't have any book that name contains " + bookName);
        for (BookEntity b : books) { %>
    <tr>
        <td><%=b.getId()%>
        </td>
        <td><%=b.getName()%>
        </td>
        <td><%=b.getPublisher()%>
        </td>
        <td><%=b.getPrice()%> &#8363;
        </td>
        <td>
            <a href="editBook.jsp?id=<%=b.getId()%>">Edit</a>
        </td>
        <td>
            <a href="/update?id=<%=b.getId()%>&name=<%=bookName%>">Delete</a>
        </td>
    </tr>
    <%}%>
</table>

</body>
</html>
