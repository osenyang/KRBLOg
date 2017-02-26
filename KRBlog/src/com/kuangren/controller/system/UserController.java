package com.kuangren.controller.system;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kuangren.enumerate.SessionEnum;
import com.kuangren.enumerate.StatusEnum;
import com.kuangren.po.Result;
import com.kuangren.po.user.User;
import com.kuangren.po.user.UserCustom;
import com.kuangren.service.system.UserService;

/**
 * 
 * Title: com.kuangren.controller.system.UserController
 * Description:
 * @createTime: 2017年2月18日 - 下午3:05:50
 * @Company: KuangRen
 * @author: OsenYang
 * @version: 1.0
 */
@Controller
@RequestMapping("/free/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	String redirectToList = "redirect:/free/user/list/manage.action";
	String forwardToList = "forward:/free/user/list/manage.action";


	@RequestMapping("/list/manage")
	public ModelAndView list() throws Exception {
		
		List<UserCustom> userList = userService.list();
		
		// 返回ModelAndView
		ModelAndView modelAndView = new ModelAndView();
		// 相当 于request的setAttribut，在jsp页面中通过userList取数据
		modelAndView.addObject("userList", userList);
		modelAndView.setViewName("user/list");
		
		return modelAndView;

	}
	
	
	@RequestMapping("/delete/manage")
	public String delete(HttpServletRequest request, @RequestParam(required=true)Integer id) throws Exception {
		userService.delete(id);
		
		request.setAttribute("result", new Result(Result.TYPE_SUCCESS, "成功禁用了此用户!"));
		
		return forwardToList;
	}
	
	@RequestMapping("/recover/manage")
	public String recover(HttpServletRequest request, @RequestParam(required=true)Integer id) throws Exception {
		userService.recover(id);
		
		request.setAttribute("result", new Result(Result.TYPE_SUCCESS, "成功恢复了此用户!"));
		
		return forwardToList;
	}
	
		
	@RequestMapping(value = "/saveUI", method = { RequestMethod.POST, RequestMethod.GET })
	public String saveUI() throws Exception {
		
		//准备数据
		
		return "/user/save";
		
	}
	
	@RequestMapping("/save")
	public String save(Model model, HttpServletRequest request, 
			UserCustom user, MultipartFile img) throws Exception {
		
		if (img == null) {
			
			userService.save(user);

		}else {
			
			userService.save(request, user, img);
		}
		
		request.setAttribute("result", new Result(Result.TYPE_SUCCESS, "注册成功！谢谢你：" + user.getName()));
		
		return "forward:/index/index.action";
		
	}
	
	@RequestMapping("/login")
	public String login(HttpSession session, HttpServletRequest request, UserCustom userCustom) throws Exception {
		
		User user = userService.validateUser(userCustom);
		
		if (user != null) {
			if (user.getStatus() == StatusEnum.DELETE) {
				request.setAttribute("result", new Result(Result.TYPE_ERROR, "登录失败！该用户已被禁用"));
			}else {
				//把用户放进去session 里面
				if (user.getStatus() == StatusEnum.MANAGER) {
					//如果是管理员的话
					session.setAttribute(SessionEnum.MANAGER, user);

				}else {
					
					session.setAttribute(SessionEnum.USER, user);
				}
				request.setAttribute("result", new Result(Result.TYPE_SUCCESS, "登录成功！欢迎你：" + user.getName()));
			}
			
		}else {
			
			request.setAttribute("result", new Result(Result.TYPE_ERROR, "登录失败！用户名或密码不正确"));
		}
		
		return "forward:/index/index.action";
	}
	
	
	@RequestMapping("/logout")
	public String logout(HttpSession session, HttpServletRequest request) throws Exception {
		
		
			//session 删除已登录的用户
			session.removeAttribute(SessionEnum.MANAGER);
			session.removeAttribute(SessionEnum.USER);
			
			request.setAttribute("result", new Result(Result.TYPE_SUCCESS, "成功退出！"));
		
		return "forward:/index/index.action";
	}
	
	
	//--------------------------------------
}
