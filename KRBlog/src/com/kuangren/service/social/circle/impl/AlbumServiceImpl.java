package com.kuangren.service.social.circle.impl;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kuangren.enumerate.SecretEnum;
import com.kuangren.enumerate.StatusEnum;
import com.kuangren.mapper.social.circle.AlbumMapper;
import com.kuangren.po.album.Album;
import com.kuangren.po.album.AlbumCustom;
import com.kuangren.po.album.AlbumExample;
import com.kuangren.po.user.User;
import com.kuangren.service.impl.BaseServiceImpl;
import com.kuangren.service.social.circle.AlbumService;
import com.kuangren.util.BeanMapper;
import com.kuangren.util.Counter;
import com.kuangren.util.FileUtil;
@Service
public class AlbumServiceImpl extends BaseServiceImpl implements AlbumService {

	@Autowired
	private AlbumMapper albumMapper;
	
	@Override
	public AlbumCustom getById(Integer id) throws Exception {
		Album album = albumMapper.selectByPrimaryKey(id);

		AlbumCustom albumCustom = BeanMapper.map(album, AlbumCustom.class);
		
		return albumCustom;
	}
	
	@Override
	public AlbumCustom getById(HttpSession session, Integer id) throws Exception {
		Album album = albumMapper.selectByPrimaryKey(id);
		
		AlbumCustom albumCustom = BeanMapper.map(album, AlbumCustom.class);
		
		//普通的数据，直接给你返回
		if (albumCustom.getStatus() != StatusEnum.DELETE && albumCustom.getIsSecret() == SecretEnum.NORMAL) {
			return albumCustom;
		}else {
			User manager = getSessionManager(session);
			if (manager == null) {//不是管理员
				return null;
			}else {//管理员
				return albumCustom;
			}
		}
	}

	@Override
	public List<AlbumCustom> list(HttpSession session) throws Exception {
		AlbumExample example = new AlbumExample();
		if (getSessionManager(session) == null) {//不是管理员
			//状态是非删除的，加密是不加密的（正常的）
			example.createCriteria().andStatusNotEqualTo(StatusEnum.DELETE).andIsSecretEqualTo(SecretEnum.NORMAL);
		}
		example.setOrderByClause("createTime desc");//, seeCount desc, replyCount desc");
		List<Album> albumList = albumMapper.selectByExample(example);

		List<AlbumCustom> albumCustoms = BeanMapper.mapList(albumList, AlbumCustom.class);
		
		return albumCustoms;
	}


	/** 设置或修改加密 */
	@Override
	public void encryption(Integer id, Integer secretCode) throws Exception {
//		Album album = albumMapper.selectByPrimaryKey(id);
		Album album = new Album();
		album.setId(id);
		album.setIsSecret(secretCode);
		albumMapper.updateByPrimaryKeySelective(album);
		
	}

	@Override
	public void delete(HttpServletRequest request, Integer id) throws Exception {
		FileUtil.deleteFile(request, albumMapper.selectByPrimaryKey(id).getCoverPath());
		albumMapper.deleteByPrimaryKey(id);
		
	}

	@Override
	public void save(HttpServletRequest request, Album album, MultipartFile img) throws Exception{
		Integer id = album.getId();
		
		if (img != null && !img.isEmpty()) {
			if (id != null) {
				//删除旧图片
				FileUtil.deleteFile(request, albumMapper.selectByPrimaryKey(id).getCoverPath());
			}
			//原始图片名称
			String originalFilename = img.getOriginalFilename();
			//上传图片
			Map<String, String> map = FileUtil.saveUploadFile(request, originalFilename);
			
			/*if (map == null) {
				throw new CustomException("图片格式不正确！");
			}*/
			
			img.transferTo(new File(map.get("path")));//保存图片在硬盘
			album.setCoverPath(map.get("picturePath"));
		}
		
		if (id == null) {
			// 新增
			album.setCreateTime(new Date());
			album.setIsSecret(SecretEnum.NORMAL);
			album.setStatus(StatusEnum.NORMAL);
			/*album.setReplyCount(0);
			album.setSeeCount(0);*/
			
			albumMapper.insert(album);
		} else {
			// 修改
			albumMapper.updateByPrimaryKeySelective(album);
		}
		
	}

	@Override
	public void save(Album album) throws Exception {
		this.save(null, album, null);
	}

	@Override
	public void seePlus1(Integer id) throws Exception {
		Album album = albumMapper.selectByPrimaryKey(id);
//		Album album = new Album();
//		album.setId(id);
		album.setSeeCount(Counter.plus1(album.getSeeCount()));
		
		albumMapper.updateByPrimaryKeySelective(album);
		
	}

	
}
