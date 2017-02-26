package com.kuangren.service.system.impl;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kuangren.enumerate.StatusEnum;
import com.kuangren.mapper.system.UserMapper;
import com.kuangren.po.user.User;
import com.kuangren.po.user.UserCustom;
import com.kuangren.po.user.UserExample;
import com.kuangren.service.system.UserService;
import com.kuangren.util.BeanMapper;
import com.kuangren.util.FileUtil;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public UserCustom getById(Integer id) throws Exception {
		User user = userMapper.selectByPrimaryKey(id);

		UserCustom userCustom = BeanMapper.map(user, UserCustom.class);
		
		return userCustom;
	}

	@Override
	public List<UserCustom> list() throws Exception {
		UserExample example = new UserExample();
		example.setOrderByClause("createTime desc");//, seeCount desc, replyCount desc");
		List<User> userList = userMapper.selectByExample(example);

		List<UserCustom> userCustoms = BeanMapper.mapList(userList, UserCustom.class);
		
		return userCustoms;
	}


	@Override
	public void delete(Integer id) throws Exception {
		
		//userMapper.deleteByPrimaryKey(id);
		
		/*非真正删除，改一下状态为删除状态*/
		setStatus(id, StatusEnum.DELETE);
		
	}

	@Override
	public void save(UserCustom user) throws Exception {
		
		
		user.setPassword(DigestUtils.md5Hex(user.getPassword()));
		
		if (user.getId() == null) {
			
			//TODO 查询并检查用户名称是否已经存在
			user.setCreateTime(new Date());
			user.setStatus(StatusEnum.NORMAL);
			
			userMapper.insert(user);
		}
		
		userMapper.updateByPrimaryKey(user);
	}

	@Override
	public void save(HttpServletRequest request, UserCustom user, MultipartFile img) throws Exception {
		Integer id = user.getId();
		
		if (img != null && !img.isEmpty()) {
			if (id != null) {
				//删除旧图片
				FileUtil.deleteFile(request, userMapper.selectByPrimaryKey(id).getImgPath());
			}
			//原始图片名称
			String originalFilename = img.getOriginalFilename();
			//上传图片
			Map<String, String> map = FileUtil.saveUploadFile(request, originalFilename);
			
			
			img.transferTo(new File(map.get("path")));//保存图片在硬盘
			user.setImgPath(map.get("picturePath"));
		}
		
		this.save(user);
	}

	@Override
	public User validateUser(UserCustom userCustom) throws Exception {
		UserExample example = new UserExample();
		example.createCriteria().andLoginNameEqualTo(userCustom.getLoginName())
			.andPasswordEqualTo(DigestUtils.md5Hex(userCustom.getPassword()));
		
		List<User> list = userMapper.selectByExample(example);
		if (list.isEmpty()) {
			return null;
		}
		
		return list.get(0);
	}

	@Override
	public void recover(Integer id) throws Exception {
		/*User user = new User();
		user.setId(id);
		user.setStatus(StatusEnum.NORMAL);
		userMapper.updateByPrimaryKeySelective(user);*/
		
		setStatus(id, StatusEnum.NORMAL);
		
	}
	
	private void setStatus(Integer id, Integer status)  throws Exception {
		User user = new User();
		user.setId(id);
		user.setStatus(status);
		userMapper.updateByPrimaryKeySelective(user);
	}


	
}
