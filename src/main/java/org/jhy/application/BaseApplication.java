package org.jhy.application;

import java.util.List;

public interface BaseApplication<T> {
	
	
	void create(T t);
	
	void delete(T t);
	
	List<T> findAll();
	
	T get(String id);
}
