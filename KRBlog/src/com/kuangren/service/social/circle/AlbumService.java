package com.kuangren.service.social.circle;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.kuangren.po.album.Album;
import com.kuangren.po.album.AlbumCustom;

public interface AlbumService {

	public AlbumCustom getById(Integer id) throws Exception;

//	public List<AlbumCustom> list(AlbumExample example) throws Exception;

	public void encryption(Integer id, Integer secretCode) throws Exception;

//	public void delete(Integer id) throws Exception;

	/** 新增或者修改 */
	public void save(HttpServletRequest request, Album album, MultipartFile images) throws Exception;

	public void save(Album album) throws Exception;

	void delete(HttpServletRequest request, Integer id) throws Exception;

	public void seePlus1(Integer id) throws Exception;

	List<AlbumCustom> list(HttpSession session) throws Exception;

	AlbumCustom getById(HttpSession session, Integer id) throws Exception;

}
