<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
    <script src="<c:url value="/js/script.js" />"></script>
    <title>Home page</title>
</head>
<body>

<a href="logout">Logout</a><br>

<b>Enter new note:</b><br>
<textarea rows="10" cols="45" name="newNote">
</textarea><br>
<button onclick="addNote(this);">Add</button>

<br><br><br>
<h1>My Notes:</h1>
<table id="list_car_table" width="600px">
    <c:forEach var="note" items="${notes}">
        <tr data-note-id="${note.noteId}">
            <td>${note.text}</td>
            <td><button onclick="removeNote(this);">Remove</button></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>