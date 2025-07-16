package com.example.controller;

import com.example.model.Task;
import com.example.service.TaskService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/tasks")
public class TaskController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TaskService service = new TaskService();
        List<Task> tarefas = service.listarTarefas();
        req.setAttribute("tarefas", tarefas);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("_method");
        TaskService service = new TaskService();

        if ("delete".equals(method)) {
            Long id = Long.parseLong(req.getParameter("id"));
            service.excluirTarefa(id);
        } else if (req.getParameter("id") != null) {
            Long id = Long.parseLong(req.getParameter("id"));
            String titulo = req.getParameter("titulo");
            String descricao = req.getParameter("descricao");
            Task tarefa = service.buscarPorId(id);
            tarefa.setTitulo(titulo);
            tarefa.setDescricao(descricao);
            service.atualizarTarefa(tarefa);
        } else {
            String titulo = req.getParameter("titulo");
            String descricao = req.getParameter("descricao");
            service.cadastrarTarefa(new Task(titulo, descricao));
        }
        resp.sendRedirect("tasks");
    }
}

