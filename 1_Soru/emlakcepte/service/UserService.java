package com.emlakcepte.service;

import com.emlakcepte.repository.UserRepository;
import com.emlakcepte.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public void createUser(User user) {		
		//UserDao userDao = new UserDao(); tekrar tekrar oluşturmamıza gerek yok
		//--System.out.println("ben bir userDao objesiyim:" + userDao.toString());
		
		if (user.getPassword().length() < 5) {
			//--System.out.println("Şifre en az 5 karakterli olmalı");
		}			
		userRepository.createUser(user);
	}
	
	public List<User> getAllUser() {
		//UserDao userDao = new UserDao();		
		return userRepository.findAllUsers();
	}
	
	public void printAllUser() {
		
		getAllUser().forEach(user -> System.out.println(user.getName()));
		
	}
	
	public void updatePassword(User user, String newPassword) {
		// önce hangi user bul ve passwordü update et.
	}

	public void getUserSearchList(User user) {
		System.out.println(user.getName()+ " kullanıcısının kayıtlı aramaları ");
		user.getSaveSearchList().forEach(System.out::println);
	}

	public User getByEmail(String email) {
		return 	userRepository.findAllUsers().stream()
				.filter(user -> user.getMail().equals(email)).findFirst()
				.get();

	}
}
