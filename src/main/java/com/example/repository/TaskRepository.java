package com.example.repository;

import com.example.model.Task;
import java.util.List;

public interface TaskRepository {
    void salvar(Task tarefa);
    List<Task> listar();
    Task buscarPorId(Long id);
    void atualizar(Task tarefa);
    void excluir(Long id);
}