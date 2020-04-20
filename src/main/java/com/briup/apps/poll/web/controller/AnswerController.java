package com.briup.apps.poll.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Answers;
import com.briup.apps.poll.service.IAnswersService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="答案相关接口")
@RestController
@RequestMapping("/answer")
public class AnswerController {
	@Autowired
	private IAnswersService answersService;
	
	
	@ApiOperation(value="删除答案主观题",
			notes="单选题答案和多选题答案不受影响")
	@GetMapping("deleteanswerContent")
	public MsgResponse deleteAnswerContent(long id) {
	try {
		//通过id找到答卷
		Answers answer=answersService.findById(id);
		//设置答卷内容为空
		answer.setContent("");
		answersService.saveOrUpdate(answer);
		return MsgResponse.success("删除成功", null);
		
	} catch (Exception e) {
		e.printStackTrace();
		return MsgResponse.error(e.getMessage());
	}
	}
	
	@ApiOperation(value="修改答案主观题",
			notes="单选题答案和多选题答案不受影响")
	@GetMapping("updateanswerContent")
	public MsgResponse updateAnswerContent(long id,String content) {
		try {
			//通过id找到答卷
			Answers answer=answersService.findById(id);
			//设置答卷内容为content
			answer.setContent(content);
			answersService.saveOrUpdate(answer);
			return MsgResponse.success("修改成功", null);
			
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

}
