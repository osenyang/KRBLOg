package com.kuangren.controller.social.circle;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kuangren.enumerate.SessionEnum;
import com.kuangren.po.PagingBean;
import com.kuangren.po.Result;
import com.kuangren.po.message.Message;
import com.kuangren.po.message.MessageCustom;
import com.kuangren.po.user.User;
import com.kuangren.service.social.circle.MessageService;

/**
 * 
 * Title: com.kuangren.controller.MessageController
 * Description:
 * @createTime: 2017年2月14日 - 上午3:16:29
 * @Company: KuangRen
 * @author: OsenYang
 * @version: 1.0
 */
@Controller
@RequestMapping("/message")
public class MessageController {

	@Autowired
	private MessageService messageService;
	
	String redirectToList = "redirect:/message/list.action";
//	String forwardToList = "forward:/message/list.action";
	String forwardToList = "forward:/message/list/paging.action";

//	private List<MultipartFile> imgs;

	@RequestMapping("/list")
	public ModelAndView list() throws Exception {
		// 返回ModelAndView
		ModelAndView modelAndView = new ModelAndView();
	    
//        MessageExample example = new MessageExample();
//        List<MessageCustom> messageList = messageService.list(example);
		List<MessageCustom> messageList = messageService.getList();
		
		// 相当 于request的setAttribut，在jsp页面中通过messageList取数据
		modelAndView.addObject("messageList", messageList);
		
		//把寄语拿出来也放到modelAndView里面
		MessageCustom sendWordMesg =  messageService.getSendWordMesg();
		if (sendWordMesg != null) {
			modelAndView.addObject("sendWordMesg", sendWordMesg);
		}
		
		modelAndView.setViewName("message/list");
		
		return modelAndView;

	}
	
	//以防页面修改过大，就在这个基础上修改吧，后面其他地方用到真分页，就把所有的信息都反正一个PagingVo里面去返回
	@RequestMapping("/list/paging")
	public ModelAndView pagingList(Integer currentPage) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		if (currentPage == null) {
			currentPage = 1;
		}
		PagingBean pagingBean = messageService.getPagingList(currentPage);
		
		/*List<MessageCustom> messageList = (List<MessageCustom>) pagingBean.getPageInfo().getList();
		modelAndView.addObject("messageList", messageList);*/
		modelAndView.addObject("pagingBean", pagingBean);//包含了所有的分页相关的信息
		
		MessageCustom sendWordMesg =  messageService.getSendWordMesg();
		if (sendWordMesg != null) {
			modelAndView.addObject("sendWordMesg", sendWordMesg);
		}
		
		modelAndView.setViewName("message/list");
		
		return modelAndView;
		
	}
	
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam(required=true)Integer id) throws Exception {
		messageService.delete(id);
		
		request.setAttribute("result", new Result(Result.TYPE_SUCCESS, "成功删除!"));
		
		return forwardToList;
	}
	
	@RequestMapping("/detail")
	public ModelAndView detail(@RequestParam(required=true)Integer id) throws Exception {
		MessageCustom message = messageService.getById(id);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message", message);
		modelAndView.setViewName("message/detail");
		
		return modelAndView;
	}
	
	/** 留言板只有新增，没有修改 */
	@RequestMapping(value = "/saveUI/free", method = { RequestMethod.POST, RequestMethod.GET })
	public String saveUI() throws Exception {
		
		return "message/save";
		
	}
	
	
	
	/*@RequestMapping("/reply")
	public String reply(HttpServletRequest request, 
			Message message) throws Exception {
		
		messageService.reply(message);
		
		request.setAttribute("result", new Result());
		
		message.setContent(null);//设置null 以免回显
		
		return forwardToList;
		
	}*/
	
	@RequestMapping("/save/free")
	public String save(HttpServletRequest request, HttpSession session,
			Message message) throws Exception {
		
		User user = (User) session.getAttribute(SessionEnum.USER);
		User manager = (User) session.getAttribute(SessionEnum.MANAGER);
		if(user != null){
			message.setNickname(user.getName());
			message.setUser_id(user.getId());
		}else if(manager != null){
			message.setNickname(manager.getName());
			message.setUser_id(manager.getId());
		}
		
		
		messageService.save(request, message);
		
		message.setContent(null);//设置null 以免回显
		
		return forwardToList;
//		return "forward:/message/list/paging.action";
		
	}
	@RequestMapping("/setSend")
	public String setSend(HttpServletRequest request, 
			Integer id) throws Exception {
		
		
		messageService.setSend(id);
		
		request.setAttribute("result", new Result(Result.TYPE_SUCCESS, "成功设为主人寄语！"));
		
		return forwardToList;
		
	}
	
	//--------------------------------------
}
