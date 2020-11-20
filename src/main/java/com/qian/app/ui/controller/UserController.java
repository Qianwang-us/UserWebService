package com.qian.app.ui.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qian.app.ui.model.request.UserDetailsRequestModel;
import com.qian.app.ui.model.response.UserRest;

@RestController
@RequestMapping("users")
public class UserController {
	
	@GetMapping()
	public String getUser(@RequestParam(value="page", defaultValue="1") int page, 
			@RequestParam(value="limit", defaultValue="50") int limit,
			@RequestParam(value="sort", defaultValue="desc", required=false) String sort) {
		return "get user was called with page = "+page+", limit="+limit + ", sort="+sort;
	}
	
//	@GetMapping(path = "/{userId}", 
//			produces = {
//					MediaType.APPLICATION_XML_VALUE, 
//					MediaType.APPLICATION_JSON_VALUE
//					})
//	public UserRest getUser(@PathVariable String userId) {
//		UserRest returnValue = new UserRest();
//		returnValue.setEmail("user@test.com");
//		returnValue.setFirstName("Sergy");
//		returnValue.setLastName("Kar");
//		return returnValue;
//	}
	
	@GetMapping(path = "/{userId}", 
			produces = {
					MediaType.APPLICATION_XML_VALUE, 
					MediaType.APPLICATION_JSON_VALUE
					})
	public ResponseEntity<UserRest> getUser(@PathVariable String userId) {
		UserRest returnValue = new UserRest();
		returnValue.setEmail("user@test.com");
		returnValue.setFirstName("Sergy");
		returnValue.setLastName("Kar");
		return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
		//return new ResponseEntity<UserRest>(HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping(
			consumes = {
					MediaType.APPLICATION_XML_VALUE, 
					MediaType.APPLICATION_JSON_VALUE
					},
			produces = {
					MediaType.APPLICATION_XML_VALUE, 
					MediaType.APPLICATION_JSON_VALUE
					})
	public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails) {
		UserRest returnValue = new UserRest();
		returnValue.setEmail(userDetails.getEmail());
		returnValue.setFirstName(userDetails.getFirstName());
		returnValue.setLastName(userDetails.getLastName());
		return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
	}
	
	@PutMapping()
	public String updateUser() {
		return "update user was called.";
	}
	
	@DeleteMapping()
	public String deleteUser() {
		return "delete user was called.";
	}
}