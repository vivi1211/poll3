package com.briup.apps.poll.web.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.briup.apps.poll.bean.User;
import com.briup.apps.poll.service.IUserService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.ApiOperation;
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
private IUserService userService;
	
	/*
	 * 4.19新加注册页面
	 * 使用的是@RestController注解,其中含有@ResponseBody注解,
	 * 结果index没有经过视图解析器解析 直接变成json字符串返回给浏览器了..
	 * 
	 * 推荐直接返回视图数据
	 */
	
	
	@PostMapping("register")
	public ModelAndView register(User user) {
		try {
				userService.saveOrUpdateUser(user);
				 ModelAndView mv = new ModelAndView("show");
				return mv;
		//return "redirect:jsp/login.jsp";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	
	}
	
	//登陆功能
	@PostMapping("login")
	public ModelAndView login(String name,String password,HttpSession session) {
		try {
			//登陆成功后跳转到查询员工所有
			ModelAndView mv = new ModelAndView("login");
		
				User user=userService.login(name, password);
				//判断user为空  用户名密码错误   //不为空  登陆成功
				if(user!=null) {
					session.setAttribute("user", user);
					//应该是回到用户主界面，但是还没写
					return null;
				}else {
					return mv; 
				}
		//return "redirect:jsp/login.jsp";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	
	}
	
	
	
	@ApiOperation(value="保存或修改",notes="如果参数中包含id表示修改操作，否则表示保存操作")
	@PostMapping("saveOrUpdateUser")
	public MsgResponse saveOrUpdateUser(User user) {
		try {
			userService.saveOrUpdateUser(user);
			return MsgResponse.success("保存或更新成功",null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="删除年级")
	@GetMapping("deleteUserById")
	public MsgResponse deleteUserById(long id) {
		try {
			userService.deleteById(id);
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
			List<User> list=userService.findAll();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
}
