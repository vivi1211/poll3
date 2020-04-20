package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.User;

public interface IUserService {
List<User> findAll() throws Exception;
	
	
	void deleteById(long id) throws Exception;
	
	
	void saveOrUpdateUser(User user) throws Exception;
	
	//登陆
	
	User login(String name,String password) throws Exception;
}
