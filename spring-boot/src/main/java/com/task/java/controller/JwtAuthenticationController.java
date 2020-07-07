package com.task.java.controller;

import java.util.Objects;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.task.java.config.JwtTokenUtil;
import com.task.java.dao.UserDao;
import com.task.java.model.DAOUser;
import com.task.java.model.JwtRequest;
import com.task.java.model.JwtResponse;
import com.task.java.model.UserDTO;
import com.task.java.service.JwtUserDetailsService;
import com.task.java.service.UserService;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

	private static final Logger logger = LogManager.getLogger(JwtAuthenticationController.class);
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserDao userDao;

	//for authenticate
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		final String token = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponse(token));
	}
	
	//for register
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<String> saveUser(@Valid @RequestBody UserDTO user) throws Exception {
		logger.info("/save user details");
		long count = userDao.countByPancard(user.getPancard());
		if(count>0) {
			return new ResponseEntity<>("1003-Old User", HttpStatus.OK);
		}
		else {
		DAOUser daoUser = userService.saveUser(user);
		return new ResponseEntity<>("1002-New User", HttpStatus.OK);
		}
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}