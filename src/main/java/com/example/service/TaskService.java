package com.example.service;

import com.example.model.Task;
import com.example.repository.TaskRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class TaskService {

    @Inject
    private TaskRepository taskRepository;

    public void addTask(Task task) {
        taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public void updateTask(Task task) {
        taskRepository.save(task);
    }

    public void removeTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }
}