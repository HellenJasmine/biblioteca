/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.progame.Generic;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 *
 * @author Cliente
 * @param <T>
 * 
 */
public class GenericService<T> {
    private Class<T> entity;
    
    @PersistenceContext
    private EntityManager entityManager;

    public GenericService(Class<T> entity) {
        this.entity = entity;
    }
    
    public void save(T entity){
        entityManager.persist(entity);
    }
    
    public void update(T entity){
        entityManager.merge(entity);
    }
    
    public T find(Long id){
    T object = getEntityManager().find(entity, id);
    getEntityManager().refresh(object);
    return object;
    }
    
    
    
    public void remove(T entity) {
        
    }
    
    
    public List<T> findAll(){
        return entityManager.createQuery("SELECT e FROM "+entity.getSimpleName()+" e WHERE e.active = true").getResultList();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    
}
