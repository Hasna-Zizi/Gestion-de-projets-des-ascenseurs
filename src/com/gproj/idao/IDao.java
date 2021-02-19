package com.gproj.idao;

import java.util.List;



public interface IDao<T> {
   
    List<T> getAll() throws Exception;

    T FindById(int id);
    
	T getOne(String nom);
	
	boolean save(T obj);
	
	boolean update(T obj);
	
	boolean delete(T obj);
}
