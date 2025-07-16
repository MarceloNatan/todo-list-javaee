package com.example;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.model.Task;
import com.example.service.TaskService;
import com.example.repository.TaskRepository;

import java.util.ArrayList;
import java.util.List;

public class TaskServiceTest {

    @InjectMocks
    private TaskService taskService;

    @Mock
    private TaskRepository taskRepository; // Assume a TaskRepository interface for database operations

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddTask() {
        Task task = new Task();
        task.setTitle("Test Task");
        task.setDescription("Test Description");

        when(taskRepository.save(task)).thenReturn(task);

        taskService.addTask(task);
        verify(taskRepository, times(1)).save(task);
    }

    @Test
    public void testGetAllTasks() {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task());
        when(taskRepository.findAll()).thenReturn(tasks);

        List<Task> result = taskService.getAllTasks();
        assertEquals(1, result.size());
    }

    @Test
    public void testUpdateTask() {
        Task task = new Task();
        task.setId(1L);
        task.setTitle("Updated Task");

        when(taskRepository.findById(1L)).thenReturn(java.util.Optional.of(task));
        when(taskRepository.save(task)).thenReturn(task);

        taskService.updateTask(task);
        // Optionally, verify that the repository's save method was called
        verify(taskRepository, times(1)).save(task);
    }

    @Test
    public void testRemoveTask() {
        Long taskId = 1L;
        doNothing().when(taskRepository).deleteById(taskId);

        taskService.removeTask(taskId);
        verify(taskRepository, times(1)).deleteById(taskId);
    }
}