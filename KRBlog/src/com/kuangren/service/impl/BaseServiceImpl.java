package com.kuangren.service.impl;

import javax.servlet.http.HttpSession;

import com.kuangren.enumerate.SessionEnum;
import com.kuangren.po.user.User;

public class BaseServiceImpl {

	
	protected User getSessionManager(HttpSession session) throws Exception {
		
		return (User) session.getAttribute(SessionEnum.MANAGER);
	}
}
