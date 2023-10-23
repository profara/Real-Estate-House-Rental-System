/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import java.util.List;

/**
 *
 * @author Alek
 */
public interface Repository<T, K> {
    
    List<T> getAll() throws Exception;
    void add(T t) throws Exception;
    void delete(T t) throws Exception;
    T getById(K k) throws Exception;
    void update(T t) throws Exception;
    List<T> pretrazi(K k) throws Exception;
    
    
}
