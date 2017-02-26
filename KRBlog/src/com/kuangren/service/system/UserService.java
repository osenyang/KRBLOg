package com.kuangren.service.system;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.kuangren.po.user.User;
import com.kuangren.po.user.UserCustom;
import com.kuangren.service.BaseService;

public interface UserService extends BaseService<UserCustom> {

	public void save(HttpServletRequest request, UserCustom user, MultipartFile img) throws Exception;

	public User validateUser(UserCustom userCustom) throws Exception;

	public void recover(Integer id) throws Exception;


}
