package com.briup.apps.poll.web.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.School;
import com.briup.apps.poll.service.ISchoolService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("school")
public class SchoolController {
@Autowired
private ISchoolService schoolService;

@ApiOperation(value="保存或修改",notes="如果参数中包含id表示修改操作，否则表示保存操作")
@PostMapping("saveOrUpdateSchool")
public MsgResponse saveOrUpdateSchool(School school) {
	try {
		schoolService.saveOrUpdateSchool(school);
		return MsgResponse.success("保存或更新成功",null);
	} catch (Exception e) {
		e.printStackTrace();
		return MsgResponse.error(e.getMessage());
	}
}

@ApiOperation(value="删除年级")
@GetMapping("deleteSchoolById")
public MsgResponse deleteSchoolById(long id) {
	try {
		schoolService.deleteById(id);
		return MsgResponse.success("删除成功",null);
	} catch (Exception e) {
		e.printStackTrace();
		return MsgResponse.error(e.getMessage());
	}
}

@ApiOperation(value="查询所有年级",notes="单表")
@GetMapping("findAll")
public MsgResponse findAll() {
	try {
		List<School> list=schoolService.findAll();
		return MsgResponse.success("success", list);
	} catch (Exception e) {
		e.printStackTrace();
		return MsgResponse.error(e.getMessage());
	}
}
}
