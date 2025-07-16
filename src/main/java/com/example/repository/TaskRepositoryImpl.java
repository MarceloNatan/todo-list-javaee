package com.example.repository;

import com.example.model.Task;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Stateless
public class TaskRepositoryImpl implements TaskRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Task save(Task task) {
        if (task.getId() == null) {
            entityManager.persist(task);
            return task;
        } else {
            return entityManager.merge(task);
        }
    }

    @Override
    public List<Task> findAll() {
        return entityManager.createQuery("SELECT t FROM Task t", Task.class).getResultList();
    }

    @Override
    public Optional<Task> findById(Long id) {
        return Optional.ofNullable(entityManager.find(Task.class, id));
    }

    @Override
    public void deleteById(Long id) {
        Task task = entityManager.find(Task.class, id);
        if (task != null) {
            entityManager.remove(task);
        }
    }
}