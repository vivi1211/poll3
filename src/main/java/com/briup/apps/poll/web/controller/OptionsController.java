package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Options;
import com.briup.apps.poll.service.IOptionsService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="选项相关接口")
@RestController
@RequestMapping("/options")
public class OptionsController {
	@Autowired
	private IOptionsService optionsService;
	
	//修改有点问题
	@ApiOperation(value="保存或修改",notes="如果参数中包含id表示修改操作，否则表示保存操作")
	@PostMapping("saveOrUpdateOptions")
	public MsgResponse saveOrUpdateOptions(Options options) {
		try {
			optionsService.saveOrUpdateOptions(options);
			return MsgResponse.success("保存或更新成功",null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="删除年级")
	@GetMapping("deleteOptionsById")
	public MsgResponse deleteOptionsById(long id) {
		try {
			optionsService.deleteById(id);
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
			List<Options> list=optionsService.findAll();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
}
