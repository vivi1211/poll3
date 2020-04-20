package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Grade;

public interface IGradeService {
List<Grade> findAll() throws Exception;
	
	
	void deleteById(long id) throws Exception;
	
	
	void saveOrUpdateGrade(Grade grade) throws Exception;
}
