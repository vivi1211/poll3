package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.GradeExample;
import com.briup.apps.poll.bean.User;
import com.briup.apps.poll.bean.UserExample;
import com.briup.apps.poll.dao.UserMapper;
import com.briup.apps.poll.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{
@Autowired
private UserMapper userMapper;

@Override
public List<User> findAll() throws Exception {
	// TODO Auto-generated method stub
	UserExample example=new UserExample();
	return userMapper.selectByExample(example);
}


@Override
public void deleteById(long id) throws Exception {
	// TODO Auto-generated method stub
	userMapper.deleteByPrimaryKey(id);
}

@Override
public void saveOrUpdateUser(User user) throws Exception {
	// TODO Auto-generated method stub
	if(user.getId()!=null) {
		userMapper.updateByPrimaryKey(user);
	}
	else
	{
		userMapper.insert(user);
	}
}


@Override
public User login(String name, String password) throws Exception {
	// TODO Auto-generated method stub
	return userMapper.findByUsernameAndPassword(name,password);
}


}
