package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Answers;
import com.briup.apps.poll.bean.Survey;
import com.briup.apps.poll.bean.extend.SurveyVM;
import com.briup.apps.poll.service.IAnswersService;
import com.briup.apps.poll.service.ISurveyService;
import com.briup.apps.poll.util.MsgResponse;
import com.briup.apps.poll.vm.SurveyAndAnswersVM;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="课调相关接口")
@RestController
@RequestMapping("/survey")
public class SurveyController {
	@Autowired
	private ISurveyService surveyService;
@Autowired
private IAnswersService answersService;


@ApiOperation(value="根据班级id查询出该班级下所有自己审核的课调",
notes="")
@GetMapping("findSurveyByClazzId")
public MsgResponse findSurveyByClazzId(long id) {
	try {
		List<SurveyVM> list=surveyService.findByClazzIdAndCheckPass(id);
		return MsgResponse.success("success", list);
		//Survey (Clazz_id,course_id,user_id)
		//SurveyVM(clazz,course,user,questionnaire)
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		return MsgResponse.error(e.getMessage());
	}
}
	
	
	@ApiOperation(value="去审核课调",
			notes="返回课调的信息以及课调下所有答卷信息")
	@GetMapping("ToCheckSurvey")
	public MsgResponse ToCheckSurvey(long id) {
		try {
			//通过id查询课调信息
			SurveyVM surveyVM=surveyService.findById(id);
			//如果课调状态为未审核才能审核
			if(surveyVM.getStatus().equals(Survey.STATUS_CHECK_ON)) {
				//查询出该课调的所有答卷
				List<Answers> list=answersService.findAnswersBySurveyId(id);
				//计算出课调的平均分
				//所有单个平均分的总和
				double total=0;
				for(Answers answer:list) {
					//["5","5"]
					String[] arr=answer.getSelections().split("[|]");
					double SingleTotal=0;
					for(String a:arr) {
						SingleTotal+=Integer.parseInt(a);
					}
					//每个学生对于老师的平均分
					double singleAverage=SingleTotal/arr.length;
					total+=singleAverage;
					}
				double average=total/list.size();
                surveyVM.setAverage(average);
               
                //将平均分保存到数据库
                Survey survey=surveyService.fingSurveyById(id);
                //如果数据库中的平均分没有设定。我们在进行设定，否则不做操作
                if(survey.getAverage()==null) {
                survey.setAverage(average);
                surveyService.saveOrUpdate(survey);
                }
                //如何将surveyVM和list返回,封装到一个对象中
                SurveyAndAnswersVM savm=new SurveyAndAnswersVM();
                savm.setSurveyVM(surveyVM);
                savm.setAnswers(list);
                
                return MsgResponse.success("success", savm);
				
			}else {
				return MsgResponse.error("课调状态不合法");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="预览课调",
			notes="只有当课调状态未审核通过的时候才能预览课调")
	@GetMapping("previewSurvey")
	public MsgResponse previewSurvey(long id) {
		try {
			//1.课调的信息（课程，班级，讲师，问卷，平均分）surveyVM
		SurveyVM surveyVM=surveyService.findById(id);
		if(surveyVM!=null&&surveyVM.getStatus().equals(Survey.STATUS_CHECK_PASS)) {
			//2.课调的结果主观题列表Answers
			List<Answers> answers=answersService.findAnswersBySurveyId(id);
		//3.将课调信息和课调答卷信息封装到一个对象中SurveyAndAnswersVM
			SurveyAndAnswersVM savm=new SurveyAndAnswersVM();
			savm.setSurveyVM(surveyVM);
			savm.setAnswers(answers);
			return MsgResponse.success("success", savm);
		}else {
			return MsgResponse.error("课调状态不合法");
		}
		
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	
	@ApiOperation(value="审核课调",
			notes="只有当前课调状态为未审核才能被审核，参数ID表示课调编号，参数status的取值只能为0/1，如果是0表示审核不通过，如果是1表示审核通过")
	@GetMapping("CheckSurvey")
	public MsgResponse CheckSurvey(long id,int status) {
		try {
			//通过id找课调
			Survey survey=surveyService.fingSurveyById(id);
			//判断当前课调状态是否为未审核状态
			if(survey!=null&&survey.getStatus().equals(Survey.STATUS_CHECK_ON)) {
				if(status==0) {
					//2.1审核不通过
					survey.setStatus(Survey.STATUS_CHECK_NOPASS);
					
				}else {
					//2.2审核通过
					survey.setStatus(Survey.STATUS_CHECK_PASS);
				}
				//结果保存或修改
				surveyService.saveOrUpdate(survey);
				return MsgResponse.success("审核完成", null);
			}else {
				return MsgResponse.error("课调状态不合法");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	/*
	@ApiOperation(value="课调审核通过",notes="将状态改为通过")
	@GetMapping("CheckSurveyPass")
	public MsgResponse CheckSurveyPass(long id) {
		try {
			//1.通过id查询出课调
				Survey survey=surveyService.fingSurveyById(id);
				if(survey!=null)
				{
					survey.setStatus(Survey.STATUS_CHECK_PASS);
					surveyService.saveOrUpdate(survey);
					return MsgResponse.success("课调审核成功通过", null);
				}else {
				return	MsgResponse.error("当前课调状态为空");
				}
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="课调审核未通过",notes="将状态改为未通过")
	@GetMapping("CheckSurveyNoPass")
	public MsgResponse CheckSurveyNoPass(long id) {
		try {
			//1.通过id查询出课调
				Survey survey=surveyService.fingSurveyById(id);
				if(survey!=null)
				{
					survey.setStatus(Survey.STATUS_CHECK_NOPASS);
					surveyService.saveOrUpdate(survey);
					return MsgResponse.success("课调审核成功未通过", null);
				}else {
				return	MsgResponse.error("当前课调状态为空");
				}
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	*/
	@ApiOperation(value="关闭课调",
			notes="只有在课调为开启状态的时候才能关闭课调")
	@GetMapping("stopSurvey")
	public MsgResponse stopSurvey(long id) {
	try {
		//1.通过id查询出课调
		Survey survey=surveyService.fingSurveyById(id);
		if(survey!=null&&survey.getStatus().equals(Survey.STATUS_BEGIN))
		{
			survey.setStatus(Survey.STATUS_CHECK_ON);
			surveyService.saveOrUpdate(survey);
			return MsgResponse.success("关闭课调成功", null);
		}else {
		return	MsgResponse.error("当前课调状态为wei开启状态");
		}
		
	} catch (Exception e) {
		e.printStackTrace();
		return MsgResponse.error(e.getMessage());
	}
	}
	
	@ApiOperation(value="开启课调",
			notes="只有在课调为未开启状态的时候才能开启课调")
	@GetMapping("beginSurvey")
	public MsgResponse beginSurvey(long id) {
		
		try {
			//1.通过id查询出课调
		Survey survey=surveyService.fingSurveyById(id);
		//2.修改课调的状态/课调编号
		if(survey.getStatus().equals(Survey.STATUS_INIT)){
			//2.1将课调状态设置为开启
			survey.setStatus(Survey.STATUS_BEGIN);
			//将课调的code设置为当前课调的id,后期要通过code找survey
			survey.setCode(survey.getId().toString());
			//2.3执行保存或更新操作
			surveyService.saveOrUpdate(survey);
			return MsgResponse.success("开启成功", null);
		}else {
			return MsgResponse.error("当前课调状态为已开启状态");
		}
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
@ApiOperation(value="批量删除课调",
			notes="级联删除课调中的答卷信息")
@PostMapping("batchDeleteSurveyById")
public MsgResponse batchDeleteSurveyById(long[] ids) {
	try {
		surveyService.batchDelete(ids);
		return MsgResponse.success("批量删除成功", null);
	} catch (Exception e) {
		e.printStackTrace();
		return MsgResponse.error(e.getMessage());
	}
}
	
	@ApiOperation(value="通过id删除课调",
			notes="级联删除课调中的答卷信息")
@GetMapping("deleteSurveyById")
public MsgResponse deleteSurveyById(long id) {
	try {
		surveyService.deleteById(id);
		return MsgResponse.success("删除成功", null);
	} catch (Exception e) {
		e.printStackTrace();
		return MsgResponse.error(e.getMessage());
	}
}
	
	@ApiOperation(value="通过id查询课调",
			notes="级联查询课调中的课程，班级，用户，问卷")
@PostMapping("findSurveyVMById")
public MsgResponse findSurveyVMById(long id) {
	try {
		SurveyVM surveyVM=surveyService.findById(id);
		return MsgResponse.success("success", surveyVM);
	} catch (Exception e) {
		e.printStackTrace();
		return MsgResponse.error(e.getMessage());
	}
}
	
	@ApiOperation(value="级联查询所有课调",
			notes="级联查询课调中的课程，班级，用户，问卷")
@PostMapping("findAllSurveyVM")
public MsgResponse findAllSurveyVM() {
	try {
		List<SurveyVM> list=surveyService.findAll();
		return MsgResponse.success("success", list);
	} catch (Exception e) {
		e.printStackTrace();
		return MsgResponse.error(e.getMessage());
	}
}
	
	@ApiOperation(value="保存或更新课调",
			notes="如果参数中包含id表示修改，否则表示添加，只需要接受clazzid,courseid,teacherid,questionnaireid")
@PostMapping("saveOrUpdateSurvey")
public MsgResponse saveOrUpdateSurvey(Survey survey) {
	try {
		surveyService.saveOrUpdate(survey);
		return MsgResponse.success("保存或修改成功", null);
	} catch (Exception e) {
		e.printStackTrace();
		return MsgResponse.error(e.getMessage());
	}
}
}
