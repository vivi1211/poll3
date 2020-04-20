package com.briup.apps.poll.web.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Qq;
import com.briup.apps.poll.service.IQqService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/qq")
public class QqController {
	@Autowired
	private IQqService qqService;
	
	@ApiOperation(value="保存或修改",notes="如果参数中包含id表示修改操作，否则表示保存操作")
	@PostMapping("saveOrUpdateQq")
	public MsgResponse saveOrUpdateQq(Qq Qq) {
		try {
			qqService.saveOrUpdateQq(Qq);
			return MsgResponse.success("保存或更新成功",null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="删除年级")
	@GetMapping("deleteQqById")
	public MsgResponse deleteQqById(long id) {
		try {
			qqService.deleteById(id);
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
			List<Qq> list=qqService.findAll();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

}
