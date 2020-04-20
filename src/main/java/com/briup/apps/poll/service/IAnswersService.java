package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Answers;

public interface IAnswersService {
void saveOrUpdate(Answers answers) throws Exception;

//通过surveyid查询answers
Answers findById(long id) throws Exception;
List<Answers> findAnswersBySurveyId(long id) throws Exception;
}
