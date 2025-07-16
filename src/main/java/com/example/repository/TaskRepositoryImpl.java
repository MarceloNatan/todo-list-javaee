package com.example.repository;

import com.example.model.Task;
import javax.persistence.*;
import java.util.List;

public class TaskRepositoryImpl implements TaskRepository {

    private EntityManager getEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("todoListPU");
        return emf.createEntityManager();
    }

    @Override
    public void salvar(Task tarefa) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(tarefa);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Task> listar() {
        EntityManager em = getEntityManager();
        List<Task> tarefas = em.createQuery("SELECT t FROM Task t", Task.class).getResultList();
        em.close();
        return tarefas;
    }

    public Task buscarPorId(Long id) {
        EntityManager em = getEntityManager();
        Task tarefa = em.find(Task.class, id);
        em.close();
        return tarefa;
    }

    public void atualizar(Task tarefa) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.merge(tarefa);
        em.getTransaction().commit();
        em.close();
    }

    public void excluir(Long id) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Task tarefa = em.find(Task.class, id);
        if (tarefa != null) {
            em.remove(tarefa);
        }
        em.getTransaction().commit();
        em.close();
    }
}