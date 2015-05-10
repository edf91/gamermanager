package org.jhy.application.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.jhy.application.BaseApplication;
import org.jhy.domain.BaseEntity;

public abstract class BaseApplicationImpl<T extends BaseEntity> implements BaseApplication<T>{
	
	private Class<T> clazz;
	@SuppressWarnings("unchecked")
	public BaseApplicationImpl(){
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz = (Class<T>) type.getActualTypeArguments()[0];
	}
	public void create(T t) {
		t.save();
	}
	public void update(T t){
		t.update();
	}
	public void delete(T t) {
		t.delete();
	}
	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		return BaseEntity.getSession().createQuery("FROM " + clazz.getSimpleName()).list();
	}
	public void deleteById(String id){
		this.get(id).delete();
	}
	public T get(String id){
		return BaseEntity.get(clazz, id);
	}
	
}
