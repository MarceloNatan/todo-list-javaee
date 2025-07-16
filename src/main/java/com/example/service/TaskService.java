package com.example.service;

import com.example.model.Task;
import com.example.repository.TaskRepository;
import com.example.repository.TaskRepositoryImpl;
import java.util.List;

public class TaskService {

    private TaskRepository taskRepository = new TaskRepositoryImpl();

    public void cadastrarTarefa(Task tarefa) {
        taskRepository.salvar(tarefa);
    }

    public List<Task> listarTarefas() {
        return taskRepository.listar();
    }

    public Task buscarPorId(Long id) {
        return taskRepository.buscarPorId(id);
    }

    public void atualizarTarefa(Task tarefa) {
        taskRepository.atualizar(tarefa);
    }

    public void excluirTarefa(Long id) {
        taskRepository.excluir(id);
    }

    // Implemente métodos para editar/excluir conforme necessário
}