package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.briup.apps.poll.bean.Grade;
import com.briup.apps.poll.bean.GradeExample;
import com.briup.apps.poll.dao.GradeMapper;
import com.briup.apps.poll.service.IGradeService;

@Service
public class GradeServiceImpl implements IGradeService{
@Autowired
private GradeMapper gradeMapper;
	@Override
	public List<Grade> findAll() throws Exception {
		// TODO Auto-generated method stub
		GradeExample example=new GradeExample();
		return gradeMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public void deleteById(long id) throws Exception {
		// TODO Auto-generated method stub
		gradeMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void saveOrUpdateGrade(Grade grade) throws Exception {
		// TODO Auto-generated method stub
		if(grade.getId()!=null) {
			gradeMapper.updateByPrimaryKey(grade);
		}
		else
		{
			gradeMapper.insert(grade);
		}
	}
	

}
