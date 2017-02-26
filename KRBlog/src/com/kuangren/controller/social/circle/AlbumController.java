package com.kuangren.controller.social.circle;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kuangren.controller.validation.DeepValidation;
import com.kuangren.enumerate.SessionEnum;
import com.kuangren.enumerate.TypeEnum;
import com.kuangren.exception.CustomException;
import com.kuangren.po.Result;
import com.kuangren.po.album.Album;
import com.kuangren.po.album.AlbumCustom;
import com.kuangren.po.photo.Photo;
import com.kuangren.po.photo.PhotoCustom;
import com.kuangren.po.type.Type;
import com.kuangren.service.social.circle.AlbumService;
import com.kuangren.service.social.circle.PhotoService;
import com.kuangren.service.system.TypeService;
import com.kuangren.util.FileUtil;

/**
 * 
 * Title: com.kuangren.controller.AlbumController
 * Description:
 * @createTime: 2017年2月1日 - 下午11:26:58
 * @Company: KuangRen
 * @author: OsenYang
 * @version: 1.0
 *
 */
@Controller
@RequestMapping("/album")
public class AlbumController {

	@Autowired
	private AlbumService albumService;
	@Autowired
	private PhotoService photoService;
	@Autowired
	private TypeService typeService;
	
	String redirectToList = "redirect:/album/list.action";
	String forwardToList = "forward:/album/list.action";

//	private List<MultipartFile> imgs;

	@RequestMapping("/list")
	public ModelAndView list(HttpSession session) throws Exception {
		
		List<AlbumCustom> albumList = albumService.list(session);
		
		// 返回ModelAndView
		ModelAndView modelAndView = new ModelAndView();
		// 相当 于request的setAttribut，在jsp页面中通过albumList取数据
		modelAndView.addObject("albumList", albumList);
		modelAndView.setViewName("album/list");
		
		return modelAndView;

	}
	
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam(required=true)Integer id) throws Exception {
		albumService.delete(request, id);
		
		request.setAttribute("result", new Result(Result.TYPE_SUCCESS, "成功删除!"));
		
		return forwardToList;
	}
	
	@RequestMapping("/detail")
	public ModelAndView detail(@RequestParam(required=true)Integer id,
			HttpSession session) throws Exception {
		AlbumCustom album = albumService.getById(session, id);
		ModelAndView modelAndView = new ModelAndView();
		
		if (album == null) {
			session.setAttribute(SessionEnum.RESULT, new Result(Result.TYPE_ERROR, "操作失败！"));
			modelAndView.setViewName("index");
			//modelAndView.setViewName("mood/list");
			return modelAndView;
		}
		
		List<PhotoCustom> photos = photoService.getImgsById(id);
		
		album.setPhotos(photos);
				
		modelAndView.addObject("album", album);
		modelAndView.setViewName("album/detail");
		
		if (session.getAttribute("kr_album_id") != null) {
			session.removeAttribute("kr_album_id");//不知道同个名称的session 会不会重复放进去，所以再放进去之前还是删除一下吧
		}
		session.setAttribute("kr_album_id", id);//一进入相册，就把相册id放进去，上传图片的时候要用到
		// 被观看 +1
		/*album.setSeeCount(album.getSeeCount() + 1);
		albumService.save(album);//更新相册表，的seeCount 被观看数 */		
		albumService.seePlus1(album.getId());
		
		return modelAndView;
	}
	
		
	@RequestMapping(value = "/saveUI", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView saveUI(Album album) throws Exception {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("album/save");
		//准备数据
		//找出类别列表
		List<Type> types = typeService.getTypesByMark(TypeEnum.ALBUM);
		modelAndView.addObject("types", types);
		if (album.getId() != null) {
			//此为更新方法
			album = albumService.getById(album.getId());
			modelAndView.addObject("album", album);
		} 
		
		return modelAndView;
		
	}
	
	@RequestMapping("/save")
	public String save(Model model, HttpServletRequest request, 
			@Validated(value = {DeepValidation.class}) AlbumCustom album, BindingResult bindingResult, 
			MultipartFile img) throws Exception {
		
		// 获取校验错误信息
		if (bindingResult.hasErrors()) {
			// 输出错误信息
			List<ObjectError> allErrors = bindingResult.getAllErrors();

			for (ObjectError objectError : allErrors) {
				// 输出错误信息
				System.out.println(objectError.getDefaultMessage());

			}
			// 将错误信息传到页面
			model.addAttribute("allErrors", allErrors);
//			model.addAttribute("allErrors", bindingResult);
			
			
			//可以直接使用model将提交pojo回显到页面
			model.addAttribute("album", album);
			
			// 出错重新到商品修改页面
			model.addAttribute("result", new Result(Result.TYPE_ERROR, "操作失败！原因：" + allErrors.get(0).getDefaultMessage()));
//			return "forward:/album/saveUI.action";
			return forwardToList;
		}
		//如果附带了类别，那么把类别名称填写进去
		Integer typeId = album.getTypeId();
		if (typeId != null) {
			String type = typeService.getById(typeId).getType();
			album.setType(type);
			
			typeService.usedPlus1(typeId);
		}
		albumService.save(request, album, img);
		
		request.setAttribute("result", new Result());
		
		return forwardToList;
		
	}
	/** 用modal 的方式返回上传图片的视图 */
	@RequestMapping(value = "/uploadImgsUI", method = { RequestMethod.POST, RequestMethod.GET })
	public String uploadImgsUI(HttpServletRequest request, Integer id) throws Exception {
		
		AlbumCustom album = albumService.getById(id);
		request.setAttribute("album", album);
		
		return "album/uploadImgs";//string 返回方式它不帮忙拼接前面的album。它帮你拼接的是上面的mapping
	}
	
	/** dropzone 上传图片，真实的保存在硬盘里面 */
	@RequestMapping(value = "/dropzoneImg", method = {RequestMethod.POST})
	public String dropzoneImg(
			MultipartFile file,
			HttpServletRequest request,
			HttpSession session) throws Exception {
		
		Integer albumId = (Integer) session.getAttribute("kr_album_id");
		if (albumId == null) {
			throw new CustomException("上传图片失败。原因：获取相册ID为空。");
		}
		//原始图片名称
		String originalFilename = file.getOriginalFilename();
		//上传图片，取到返回的两个路径
		Map<String, String> map = FileUtil.saveUploadFile(request, originalFilename);
		
		file.transferTo(new File(map.get("path")));//保存图片在硬盘
		
		Photo photo = new Photo(file.getOriginalFilename(), map.get("picturePath"), albumId);//
		photoService.save(photo);
		
		request.setAttribute("id", albumId);//其实它不会跳转的
		return "forward:/album/detail.action";//因为它是ajax 请求过来的
	}
	
	/*@RequestMapping(value = "/setIdInsession", method = {RequestMethod.POST, RequestMethod.GET})
	public void setIdInsession(Integer id, 
			HttpServletRequest request,
			HttpServletResponse response,
			HttpSession session) throws Exception {
		
		if(session.getAttribute("kr_album_id") == null){
			
			session.setAttribute("kr_album_id", id);
		}
		
	}*/
	
	/*@RequestMapping(value = "/cancelUpload", method = {RequestMethod.POST, RequestMethod.GET})
	public void cancelUpload(HttpSession session) throws Exception {//void 不声明返回哪个链接，它自动返回方法名称+ jsp作为返回的视图
		
		session.removeAttribute("kr_album_id");
		
	}*/
	
	
	/** 加密页面 */
	@RequestMapping("/encryptUI")
	public ModelAndView encryptUI(Integer id) throws Exception {
		
		Album album = albumService.getById(id);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("album", album);
		modelAndView.setViewName("album/encrypt");
		
		return modelAndView;
	}
	/** 加密的执行 */
	@RequestMapping("/encrypt")
	public String encrypt(HttpServletRequest request, Integer id, Integer secretCode) throws Exception {
		
		albumService.encryption(id, secretCode);
		
		request.setAttribute("result", new Result(Result.TYPE_SUCCESS, "修改加密成功!"));
		
		return forwardToList;
	}
	
	
	/** 设置封面 */
	@RequestMapping("/setCover")
	public String setCover(Integer albumId, Integer photoId) throws Exception {
		
		
		return redirectToList;
	}
	
	//--------------------------------------
}
