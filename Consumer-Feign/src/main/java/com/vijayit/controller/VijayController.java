package com.vijayit.controller;

import org.springframework.web.bind.annotation.RestController;

import com.vijayit.entity.UserEntity;
import com.vijayit.feign.FeignInterface;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class VijayController {

@Autowired
private FeignInterface feignService;

@GetMapping("/filter")
public ResponseEntity<List<UserEntity>> searchUsers(
        @RequestParam(required = false) Integer id,
        @RequestParam(required = false) String name,
        @RequestParam(required = false) Long phno){
	return feignService.searchUsers(id, name, phno);
}


@PostMapping("/add")
public UserEntity save(@RequestBody UserEntity entity) {
	return feignService.save(entity);
}

@GetMapping("/all")
public List<UserEntity> getAll(){
	return feignService.getAll();
}
@GetMapping("/give/{id}")
public UserEntity getById(@PathVariable Integer id) {
return feignService.getById(id);
}
@GetMapping("/get/{name}")
public UserEntity getByName(@PathVariable String name) {
	return feignService.getByName(name);
}
@PutMapping("/put/{id}")
public UserEntity update(@PathVariable Integer id, @RequestBody UserEntity entity) {
	return feignService.update(id, entity);
}
	
@DeleteMapping("/remove/{id}")
public String delete(@PathVariable Integer id) {
return feignService.delete(id);	
}
}