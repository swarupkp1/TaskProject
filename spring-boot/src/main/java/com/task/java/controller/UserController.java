package com.task.java.controller;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.task.java.model.DAOUser;
import com.task.java.service.UserService;


@RestController
public class UserController {
	@Autowired
	private UserService userService;
	

	
	@RequestMapping({ "/hello" })
	public String firstPage() {
		System.out.println("hi");
		return "Hello World";
	}
	
	
	/*
	 * @GetMapping("/userById/{id}") public DAOUser findByid(@PathVariable int id) {
	 * DAOUser dAOUser=userService.getProductById(id);
	 * System.out.println("hinm"+dAOUser.getEmail()); return dAOUser;
	 * 
	 * }
	 */
	
	
	@GetMapping("/userById/{id}")
	public String findByid(@PathVariable int id) {
		DAOUser dAOUser=userService.getProductById(id);
		System.out.println("user id"+dAOUser.getId());
		System.out.println("user email"+dAOUser.getUsername());
		System.out.println("user password"+dAOUser.getEmail());
		System.out.println("user pancard"+dAOUser.getPancard());
		System.out.println("user mobilenumber"+dAOUser.getMobileNumber());
		ObjectMapper Obj = new ObjectMapper();
		String jsonStr=null;
		try {
			jsonStr = Obj.writeValueAsString(dAOUser);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("hinmsfafafaf"+jsonStr);
		String s1="id:"+dAOUser.getId()+"\n"+"Username:"+dAOUser.getUsername()+"\n"+"Pancard:"+dAOUser.getPancard()+"\n"+"Mobile number:"+dAOUser.getMobileNumber();
		return s1;
		
	}
	
	
	
	@GetMapping("/userByName/{username}")
	public String findUsername(@PathVariable String username) {
		DAOUser dAOUser=userService.getUserByUsername(username);
		String s1="id:"+dAOUser.getId()+"\n"+"Username:"+dAOUser.getUsername()+"\n"+"Pancard:"+dAOUser.getPancard()+"\n"+"Mobile number:"+dAOUser.getMobileNumber();
		return s1;
		
	}
	
	
	
	
	
	
	

}