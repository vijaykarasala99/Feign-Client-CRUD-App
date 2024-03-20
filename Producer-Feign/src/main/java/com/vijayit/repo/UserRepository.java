package com.vijayit.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vijayit.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity,Integer>{
	
	public UserEntity getByName(String name);

	public List<UserEntity> findByIdAndNameAndPhno(Integer id, String name, Long phno);

	public List<UserEntity> findByNameAndPhno(String name, Long phno);

	public List<UserEntity> findByNameAndId(String name, Integer id);

	public List<UserEntity> findByIdAndPhno(Integer id, Long phno);

	public List<UserEntity> findByName(String name);

	public List<UserEntity> findByPhno(Long phno);

}
