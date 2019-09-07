package com.protectsoft.apiee.interfaces;

import com.protectsoft.apiee.entities.BaseEntity;
import java.util.List;

/**
 *
 * @param <T>
 */
public interface IRepository<T extends BaseEntity>  {
    
    List<T> findAll();
    
    T find(Long id);
    
    T update(T entity);
    
    T update(Long id,T entity);
    
    void create(T entity);
    
    void delete(T entity);
}
