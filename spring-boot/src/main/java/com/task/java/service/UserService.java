package com.task.java.service;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import com.task.java.dao.UserDao;
import com.task.java.model.DAOUser;
import com.task.java.model.UserDTO;
@Service
public class UserService {

	private static final Logger logger = LogManager.getLogger(UserService.class);
	
	@Autowired
	private UserDao userDao;
	
	
	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	
	public DAOUser saveUser(UserDTO user){
		DAOUser savetodb=null;
		try {
		logger.info("$$$$$ saveUser of UserService class $$$$$");
		DAOUser newUser = new DAOUser();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		newUser.setEmail(user.getEmail());
		newUser.setMobileNumber(user.getMobileNumber());
		newUser.setPancard(user.getPancard());
		savetodb=userDao.save(newUser);
		}
		catch(Exception e) {
			logger.error("$$$$$ (Exception) ERROR in ~saveUser~ UserService $$$$$" + e);
		}
		return savetodb;
	}
	
	//to find the detail bu using id
	public DAOUser getProductById(int id){
	return userDao.findById(id).orElse(null);
	}

	public DAOUser getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return userDao.findByUsername(username);
	}

	
//fgdfgd
	
	

}
