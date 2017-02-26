package com.kuangren.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kuangren.po.log.LogCustom;
import com.kuangren.po.message.MessageCustom;
import com.kuangren.po.mood.MoodCustom;
import com.kuangren.po.photo.PhotoCustom;
import com.kuangren.service.social.blog.LogService;
import com.kuangren.service.social.circle.MessageService;
import com.kuangren.service.social.circle.MoodService;
import com.kuangren.service.social.circle.PhotoService;

@Controller
@RequestMapping("/index")
public class IndexController {
	
	@Autowired
	private PhotoService photoService;
	@Autowired
	private LogService logService;
	@Autowired
	private MoodService moodService;
	@Autowired
	private MessageService messageService;

	// 首页
	@RequestMapping("/index")
	public String index(HttpSession session, HttpServletRequest request) throws Exception {
		//查找最新上传的图片6张
		List<PhotoCustom> photos = photoService.getListFront(session, 6);
		request.setAttribute("photos", photos);
		//查找 6 条最新日志
		List<LogCustom> logs = logService.getListFront(session, 6);
		request.setAttribute("logs", logs);
		//查找 6 条最新心情
		List<MoodCustom> moods = moodService.getListFront(session, 6);
		request.setAttribute("moods", moods);
		//查找 8 条最新留言
		List<MessageCustom> messages = messageService.getListFront(8);
		request.setAttribute("messages", messages);
		
		return "index/index";
	}
	
	// 头部
	@RequestMapping("/head")
	public String head() throws Exception {

		return "index/head";
	}
	// 左边 - 菜单
	@RequestMapping("/left")
	public String left() throws Exception {
		
		return "index/left";
	}
	// 后边 - 主体
	@RequestMapping("/right")
	public String right() throws Exception {
		
		return "index/right";
	}
	// 底部
	@RequestMapping("/bottom")
	public String bottom() throws Exception {
		
		return "index/bottom";
	}

}
