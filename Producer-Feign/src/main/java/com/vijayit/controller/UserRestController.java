package com.vijayit.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.vijayit.entity.UserEntity;
import com.vijayit.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/vijay")
public class UserRestController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/search")
	public ResponseEntity<List<UserEntity>> searchUsers(
	        @RequestParam(required = false) Integer id,
	        @RequestParam(required = false) String name,
	        @RequestParam(required = false) Long phno) {

	    List<UserEntity> users = service.searchUsersWithFilters(id, name, phno);
	    return ResponseEntity.ok(users);
	}
	
	
	
	@GetMapping("/{name}")
	public UserEntity getByName(@PathVariable String name) {
		return service.getByName(name);
	}
	
	
	@PostMapping("/save")
	public UserEntity save(@RequestBody UserEntity entity) {
		return service.save(entity);
	}
	
	@GetMapping("/getall")
	public List<UserEntity> getAll() {
		return service.getAll();
		
	}
	@GetMapping("/get/{id}")
	public UserEntity getById(@PathVariable Integer id) {
		return service.getById(id);
		
	}
	
	@PutMapping("/update/{id}")
	public UserEntity update(@PathVariable Integer id, @RequestBody UserEntity entity) {
		return service.update(id, entity);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		String status= service.delete(id);
		return status;
	}
}






//@PostMapping("/save")
//public ResponseEntity<UserEntity> save(@RequestBody UserEntity entity) {
//    UserEntity savedEntity = service.save(entity);
//    return ResponseEntity.status(HttpStatus.CREATED).body(savedEntity);
//}
//
//@GetMapping("/getall")
//public ResponseEntity<List<UserEntity>> getAll() {
//    List<UserEntity> users = service.getAll();
//    return ResponseEntity.ok(users);
//}
//
//@GetMapping("/get/{id}")
//public ResponseEntity<UserEntity> getById(@PathVariable Integer id) {
//    UserEntity user = service.getById(id);
//    return ResponseEntity.ok(user);
//}
//
//@PutMapping("/update/{id}")
//public ResponseEntity<UserEntity> update(@PathVariable Integer id, @RequestBody UserEntity entity) {
//    UserEntity updatedEntity = service.update(id, entity);
//    return ResponseEntity.ok(updatedEntity);
//}
//
//@DeleteMapping("/delete/{id}")
//public ResponseEntity<String> delete(@PathVariable Integer id) {
//    String status = service.delete(id);
//    return ResponseEntity.ok(status);
//}

