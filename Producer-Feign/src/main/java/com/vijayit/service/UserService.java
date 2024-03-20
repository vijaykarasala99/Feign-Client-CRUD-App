package com.vijayit.service;

import java.util.List;

import com.vijayit.entity.UserEntity;

public interface UserService {
	
	public UserEntity save(UserEntity entity);
	
    public UserEntity update(Integer id, UserEntity entity);
    
    public String delete(Integer id);
    
    public UserEntity getById(Integer id);
    
    public List<UserEntity> getAll();
    
    public UserEntity getByName(String name);

    public List<UserEntity> searchUsersWithFilters(Integer id, String name, Long phno);

}
