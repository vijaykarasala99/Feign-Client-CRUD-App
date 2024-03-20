package com.vijayit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vijayit.entity.UserEntity;
import com.vijayit.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {
   @Autowired
   private UserRepository repository;

   @Override
	public List<UserEntity> searchUsersWithFilters(Integer id, String name, Long phno) {
	  
	   if (id != null && name != null && phno!= null) {
	        return repository.findByIdAndNameAndPhno(id, name, phno);
	        
	    } else if (name != null && phno != null) {
	        return repository.findByNameAndPhno(name, phno);
	        
	    } else if (name != null && id != null) {
	        return repository.findByNameAndId(name, id);
	        
	    } else if (id != null && phno != null) {
	        return repository.findByIdAndPhno(id, phno);
	        
	    } else if (name != null) {
	        return repository.findByName(name);
	        
	    } else if (phno != null) {
	        return repository.findByPhno(phno);
	        
	    } else {
	        return repository.findAll();
	    }
	}
   
   
   @Override
	public UserEntity getByName(String name) {
		return repository.getByName(name);
	}

   
	@Override
	public UserEntity save(UserEntity entity) {
		return repository.save(entity);
	}

	@Override
	public UserEntity update(Integer id, UserEntity entity) {
		entity.setId(id);
		return repository.save(entity);
		
	}

	@Override
	public String delete(Integer id) {
		if(repository.existsById(id)) {
			repository.deleteById(id);
			return "deleted successfully";
		}else {
			return "no user found";
		}
	}
	
	@Override
	public UserEntity getById(Integer id) {
		Optional<UserEntity> findById = repository.findById(id);

		if (findById.isPresent()) {
			return findById.get();
		}
		return null;
	}
	
	@Override
	public List<UserEntity> getAll() {
		return repository.findAll();
	}
}