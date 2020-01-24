package com.mycompany.clase11;

import java.util.List;

public interface DAO<T> {
    
    List<T> findAll();
    
    T save(T entity);
}
