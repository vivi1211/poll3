package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.OptionsExample;
import com.briup.apps.poll.bean.Options;
import com.briup.apps.poll.dao.OptionsMapper;
import com.briup.apps.poll.service.IOptionsService;

@Service
public class OptionsServiceImpl implements IOptionsService{
@Autowired
private OptionsMapper optionsMapper;
	
	@Override
	public List<Options> findAll() throws Exception {
		// TODO Auto-generated method stub
		OptionsExample example=new OptionsExample();
		return optionsMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public void deleteById(long id) throws Exception {
		// TODO Auto-generated method stub
		optionsMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void saveOrUpdateOptions(Options options) throws Exception {
		// TODO Auto-generated method stub
		if(options.getId()!=null) {
			optionsMapper.updateByPrimaryKey(options);
		}
		else
		{
			optionsMapper.insert(options);
		}
	}

}
