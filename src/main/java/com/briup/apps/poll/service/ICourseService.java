package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Course;

public interface ICourseService {
	/*
	 * 查询所有
	 */
List<Course> findAll() throws Exception;
/*
 * 通过ID搜索
 */
Course findById(long id) throws Exception;
/*
 * 关键字查询
 */
List<Course> query(String keywords) throws Exception;

/*
 * 保存与修改参数一样
 */
void saveOrUpdate(Course course) throws Exception;
/*
 * 删除
 */
void deleteById(long id) throws Exception;
/*
 * 批量删除
 */
void batchDelete(List<Long> ids) throws Exception;
}
