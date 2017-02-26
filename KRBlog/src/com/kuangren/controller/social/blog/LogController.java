package com.kuangren.controller.social.blog;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kuangren.enumerate.SessionEnum;
import com.kuangren.enumerate.TypeEnum;
import com.kuangren.po.Result;
import com.kuangren.po.log.Log;
import com.kuangren.po.log.LogCustom;
import com.kuangren.po.type.Type;
import com.kuangren.service.social.blog.LogService;
import com.kuangren.service.system.TypeService;

/**
 * 
 * Title: com.kuangren.controller.LogController
 * Description:
 * @createTime: 2017年1月27日 - 上午11:55:21
 * @Company: KuangRen
 * @author: OsenYang
 * @version: 1.0
 *
 */
@Controller
@RequestMapping("/log")
public class LogController {

	@Autowired
	private LogService logService;
	@Autowired
	private TypeService typeService;
	
	String redirectToList = "redirect:/log/list.action";
	String forwardToList = "forward:/log/list.action";

	@RequestMapping("/list")
	public ModelAndView list(HttpSession session) throws Exception {
	    
	    
	    List<LogCustom> logList = logService.list(session);
	    
	    // 返回ModelAndView
	    ModelAndView modelAndView = new ModelAndView();
	    // 相当 于request的setAttribut，在jsp页面中通过logList取数据
	    modelAndView.addObject("logList", logList);
	    modelAndView.setViewName("log/list");
	    
	    return modelAndView;
	    
	}
	
	
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request,
			@RequestParam(required=true)Integer id) throws Exception {
		logService.delete(id);
		
		request.setAttribute("result", new Result(Result.TYPE_SUCCESS, "成功删除!"));
		
		return forwardToList;//forward 才能显示result里面的信息
//		return redirectToList;//要用redirect 除非在那个方法（list）里面加入result 参数
	}
	
	@RequestMapping("/detail")
	public ModelAndView detail(HttpSession session, @RequestParam(required=true)Integer id,
				HttpServletRequest request, HttpServletResponse response) throws Exception {
		LogCustom log = logService.getById(session, id);
		ModelAndView modelAndView = new ModelAndView();
		
		if (log == null) {
			session.setAttribute(SessionEnum.RESULT, new Result(Result.TYPE_ERROR, "操作失败！"));
			//modelAndView.addObject(SessionEnum.RESULT, new Result(Result.TYPE_ERROR, "操作失败！"));
			modelAndView.setViewName("index");
			return modelAndView;
		}
		
		modelAndView.addObject("log", log);
		modelAndView.setViewName("log/detail");
		
		// 被观看 +1
		logService.seePlus1(log.getId());
		
		return modelAndView;
	}
	
	
	@RequestMapping("saveUI")
	public ModelAndView saveUI(Log log, Integer publish) throws Exception {
		
		ModelAndView modelAndView = new ModelAndView();
		//准备数据
		//找出类别列表
		List<Type> types = typeService.getTypesByMark(TypeEnum.LOG);
		modelAndView.addObject("types", types);
		
		if (log.getId() != null) {
			//此为更新方法
			log = logService.getById(log.getId());
			modelAndView.addObject("log", log);
		} 
		
		if (publish != null && publish == 1) {
			
			modelAndView.setViewName("log/publish");
		}else {
			
			modelAndView.setViewName("log/save");
		}
		
		return modelAndView;
		
	}
	
	@RequestMapping("save")
	public String save(HttpServletRequest request, LogCustom log) throws Exception {
		
		Integer typeId = log.getTypeId();
		if (typeId != null) {
			String type = typeService.getById(typeId).getType();
			log.setType(type);
			
			typeService.usedPlus1(typeId);
		}
		
		/*if (log.getIsDraft() != null && log.getIsDraft() == 1) {
			log.setStatus(StatusEnum.DRAFT);
		}*/
		
		logService.save(log);
		
		request.setAttribute("result", new Result());
		
		return forwardToList;// forward 是从这里跳过去页面的
		
	}
	@RequestMapping("encryptUI")
	public ModelAndView encryptUI(Integer id) throws Exception {
		
		Log log = logService.getById(id);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("log", log);
		modelAndView.setViewName("log/encrypt");
//		return "log/encryptionUI";
		
		return modelAndView;
	}
	
	@RequestMapping("encrypt")
	public String encrypt(HttpServletRequest request, Integer id, Integer secretCode) throws Exception {
		
		logService.encryption(id, secretCode);
//		return "log/list";//这样跳转list没有数据。因为这个方法里面没有加载。如果需要数据，那么你需要重定向
		
		request.setAttribute("result", new Result(Result.TYPE_SUCCESS, "修改加密成功!"));
		
		return forwardToList;
	}
	
	/** 设置状态（精华或者非精华） */
	@RequestMapping("setStatus")
	public String setStatus(HttpServletRequest request, Integer id, Integer statusCode) throws Exception {
		
		logService.setStatus(id, statusCode);
		
		request.setAttribute("result", new Result());
		
		return forwardToList;
	}
	
	/** 设置置顶 */
	@RequestMapping("setTop")
	public String setTop(HttpServletRequest request, Integer id) throws Exception {
		
		logService.setTop(id);
		
		request.setAttribute("result", new Result(Result.TYPE_SUCCESS, "置顶成功!"));
		
		return forwardToList;
	}
	/** 取消置顶 */
	@RequestMapping("cancelTop")
	public String cancelTop(HttpServletRequest request, Integer id) throws Exception {
		
		logService.cancelTop(id);
		
		request.setAttribute("result", new Result(Result.TYPE_SUCCESS, "成功取消置顶!"));
		
		return forwardToList;
	}

}
