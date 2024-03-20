package com.vijayit.feign;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.vijayit.entity.UserEntity;

@FeignClient(value = "vijay", url="http://localhost:1111/vijay/")
public interface FeignInterface {

	@GetMapping("/search")
	public ResponseEntity<List<UserEntity>> searchUsers(
	        @RequestParam(required = false) Integer id,
	        @RequestParam(required = false) String name,
	        @RequestParam(required = false) Long phno);
	
	
	@GetMapping("/{name}")
	public UserEntity getByName(@PathVariable String name);
	
	@PostMapping("/save")
	public UserEntity save(@RequestBody UserEntity entity);
	
	@GetMapping("/getall")
	public List<UserEntity> getAll();
	
	@GetMapping("/get/{id}")
	public UserEntity getById(@PathVariable Integer id);
	
	@PutMapping("/update/{id}")
	public UserEntity update(@PathVariable Integer id, @RequestBody UserEntity entity);
		
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable Integer id);
}