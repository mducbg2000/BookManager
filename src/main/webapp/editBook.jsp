<%@ page import="team5.book_manager.entities.BookEntity" %>
<%@ page import="team5.book_manager.services.BookService" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/4/2021
  Time: 9:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit book</title>
    <style>
        input[type=text], input[type=number] {
            width: 100%; /* Full width */
            padding: 12px; /* Some padding */
            border: 1px solid #ccc; /* Gray border */
            border-radius: 4px; /* Rounded borders */
            box-sizing: border-box; /* Make sure that padding and width stays in place */
            margin-top: 6px; /* Add a top margin */
            margin-bottom: 16px; /* Bottom margin */
            resize: vertical /* Allow the user to vertically resize the textarea (not horizontally) */
        }

        /* Style the submit button with a specific background color etc */
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

        /* Add a background color and some padding around the form */
        .container {
            border-radius: 5px;
            background-color: #f2f2f2;
            padding: 20px;
        }
    </style>
</head>
<body>
<% BookService bookService = new BookService();
    String id = request.getParameter("id");
    BookEntity b = new BookEntity();
    if (id != null) b = bookService.getBookById(Integer.parseInt(id));
%>
<div class="container">
    <form action="<%=request.getContextPath()%>/update" method="post">
        <label>Id: </label> <input type="text" name="id" value="<%=b.getId()%>" readonly><br>
        <label>Name: </label> <input type="text" name="name" value="<%=b.getName()%>"><br>
        <label>Publisher: </label> <input type="text" name="publisher" value="<%=b.getPublisher()%>"><br>
        <label>Price: </label> <input type="number" name="price" value="<%=b.getPrice()%>"><br>
        <input type="submit" value="Submit">
    </form>
</div>
</body>
</html>
