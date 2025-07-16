<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>To-Do List</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <h1>To-Do List</h1>
    <form action="task" method="post">
        <input type="text" name="title" placeholder="Task Title" required>
        <textarea name="description" placeholder="Task Description"></textarea>
        <button type="submit">Add Task</button>
    </form>
    <h2>Tasks</h2>
    <ul>
        <c:forEach var="task" items="${tasks}">
            <li>
                <strong>${task.title}</strong> - ${task.description}
                <form action="task/${task.id}" method="post" style="display:inline;">
                    <button type="submit">Delete</button>
                </form>
                <a href="edit/${task.id}">Edit</a>
            </li>
        </c:forEach>
    </ul>
</body>
</html>