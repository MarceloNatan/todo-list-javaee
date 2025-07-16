<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>ToDo List</title>
</head>
<body>
    <h1>Lista de Tarefas</h1>
    <ul>
        <c:forEach var="tarefa" items="${tarefas}">
            <li>
                ${tarefa.titulo} - ${tarefa.descricao}
                <form action="tasks" method="post" style="display:inline;">
                    <input type="hidden" name="id" value="${tarefa.id}" />
                    <input type="text" name="titulo" value="${tarefa.titulo}" />
                    <input type="text" name="descricao" value="${tarefa.descricao}" />
                    <button type="submit">Editar</button>
                </form>
                <form action="tasks" method="post" style="display:inline;" onsubmit="return confirm('Excluir?');">
                    <input type="hidden" name="id" value="${tarefa.id}" />
                    <input type="hidden" name="_method" value="delete" />
                    <button type="submit">Excluir</button>
                </form>
            </li>
        </c:forEach>
    </ul>
    <h2>Cadastrar Tarefa</h2>
    <form action="tasks" method="post">
        <input type="text" name="titulo" placeholder="Título" required />
        <input type="text" name="descricao" placeholder="Descrição" required />
        <button type="submit">Cadastrar</button>
    </form>
</body>
</html>