package com.briup.apps.poll.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Question;
import com.briup.apps.poll.bean.Options;
import com.briup.apps.poll.bean.OptionsExample;
import com.briup.apps.poll.bean.QuestionExample;
import com.briup.apps.poll.bean.extend.QuestionVM;
import com.briup.apps.poll.dao.OptionsMapper;
import com.briup.apps.poll.dao.QuestionMapper;
import com.briup.apps.poll.dao.extend.QuestionVMMapper;
import com.briup.apps.poll.service.IQuestionService;

@Service
public class QuestionServiceImpl implements IQuestionService{
@Autowired
private QuestionMapper questionMapper;
@Autowired
private QuestionVMMapper questionVMMapper;
@Autowired
private OptionsMapper optionsMapper;


	@Override
	public List<Question> findAll() throws Exception {
		QuestionExample example=new QuestionExample();
		return questionMapper.selectByExample(example);
	}
	@Override
	public List<QuestionVM> findAllQuestionVM() throws Exception {
		
		return questionVMMapper.selectAll();
	}
	
	
	/**
	 * 保存或修改问题（包含选项）
	 */
	@Override
	public void saveOrUpdateQuestionVM(QuestionVM questionVM) throws Exception {
		//1.先分离quesitonvm,从中获取到question options
		List<Options> options=questionVM.getOptions();
		
		Question question=new Question();
		question.setId(questionVM.getId());
		question.setName(questionVM.getName());
		question.setQuestiontype(questionVM.getQuestionType());
		
		
		//question问题对象，options 所有问题的选项
		// 2.判断保存还是修改
		if(question.getId()==null) {
			//2.1保存
		if(question.getQuestiontype().equals("简答题")) {
			//2.1.1 保存简答题，只需保存题目相关信息
			questionMapper.insert(question);
			}else {
				//2.1.2保存单选和多选题的时候需要先保存题目信息，在保存选项信息
				questionMapper.insert(question);
				//如何获取刚刚插入到问题的id
				long questionId=question.getId();
				if(options!=null) {
				for(Options option:options) {
					//为每个option设置question_id
					option.setQuestionId(questionId);
					//保存选项
					optionsMapper.insert(option);
				}
			
			}
			}
		}else
		{
			//2.2修改
			//2.2.1修改题目信息
			questionMapper.updateByPrimaryKey(question);
			//2.2.2修改选项信息（添加新选项，删除旧选项，对原来选项修改）
			//1.删除该题目原有的选项
			OptionsExample example=new OptionsExample();
			example.createCriteria().andQuestionIdEqualTo(question.getId());
			optionsMapper.deleteByExample(example);
			//2.2.3重新添加选项
		
			long questionId=question.getId();
			for(Options option:options) {
				//为每个option设置question_id
				option.setQuestionId(questionId);
				//保存选项
				optionsMapper.insert(option);
			}
		
		}
		
		//判断是否是简答
		
		/*
		 * 保存
		 * 1.保存问题
		 * 2.保存选项
		 */
		
	
}
	@Override
	public void deleteById(long id) throws Exception {
		questionMapper.deleteByPrimaryKey(id);
		
	}
	
}
