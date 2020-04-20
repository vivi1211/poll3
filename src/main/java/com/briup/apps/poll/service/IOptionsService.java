package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Options;

public interface IOptionsService {
List<Options> findAll() throws Exception;
	
	
	void deleteById(long id) throws Exception;
	
	
	void saveOrUpdateOptions(Options options) throws Exception;
}
