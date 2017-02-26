package com.kuangren.controller.social.circle;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kuangren.enumerate.SessionEnum;
import com.kuangren.enumerate.TypeEnum;
import com.kuangren.po.Result;
import com.kuangren.po.mood.Mood;
import com.kuangren.po.mood.MoodCustom;
import com.kuangren.po.type.Type;
import com.kuangren.service.social.circle.MoodService;
import com.kuangren.service.system.TypeService;

/**
 * 
 * Title: com.kuangren.controller.MoodController
 * Description:
 * @createTime: 2017年1月27日 - 上午11:55:21
 * @Company: KuangRen
 * @author: OsenYang
 * @version: 1.0
 *
 */
@Controller
@RequestMapping("/mood")
public class MoodController {

	@Autowired
	private MoodService moodService;
	@Autowired
	private TypeService typeService;
	
	String redirectToList = "redirect:/mood/list.action";
	String forwardToList = "forward:/mood/list.action";

	@RequestMapping("/list")
	public ModelAndView list(HttpSession session) throws Exception {
	    
	    
	    List<MoodCustom> moodList = moodService.list(session);
	    
	    // 返回ModelAndView
	    ModelAndView modelAndView = new ModelAndView();
	    // 相当 于request的setAttribut，在jsp页面中通过moodList取数据
	    modelAndView.addObject("moodList", moodList);
	    modelAndView.setViewName("mood/list");
	    
	    return modelAndView;
	    
	}
	
	
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request,
			@RequestParam(required=true)Integer id) throws Exception {
		moodService.delete(id);
		
		request.setAttribute("result", new Result(Result.TYPE_SUCCESS, "成功删除!"));
		
		return forwardToList;//forward 才能显示result里面的信息
//		return redirectToList;//要用redirect 除非在那个方法（list）里面加入result 参数
	}
	@RequestMapping("/detail")
	public ModelAndView detail(HttpSession session, @RequestParam(required=true)Integer id) throws Exception {
		MoodCustom mood = moodService.getById(session, id);
		
		ModelAndView modelAndView = new ModelAndView();
		if (mood == null) {
			session.setAttribute(SessionEnum.RESULT, new Result(Result.TYPE_ERROR, "操作失败！"));
			modelAndView.setViewName("index");
			//modelAndView.setViewName("mood/list");
			return modelAndView;
		}
		modelAndView.addObject("mood", mood);
		modelAndView.setViewName("mood/detail");
		
		// 被观看 +1
		/*mood.setSeeCount(mood.getSeeCount() == null ? 1 : mood.getSeeCount() + 1);
		moodService.save(mood);*/
		
		moodService.seePlus1(mood.getId());
		
		return modelAndView;
	}
	
	
	/*@RequestMapping("addUI")
	public String addUI() throws Exception {
		return "mood/save";
		
	}*/
	
	@RequestMapping("saveUI")
	public ModelAndView saveUI(Mood mood) throws Exception {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("mood/save");
		//准备数据
		//找出类别列表
		List<Type> types = typeService.getTypesByMark(TypeEnum.MOOD);
		modelAndView.addObject("types", types);
		
		if (mood.getId() != null) {
			//此为更新方法
			mood = moodService.getById(mood.getId());
			modelAndView.addObject("mood", mood);
		} 
		
		return modelAndView;
		
	}
	
	@RequestMapping("save")
	public String save(HttpServletRequest request, MoodCustom mood) throws Exception {
		Integer [] ids = mood.getTagIds();
		if (null != ids && ids.length > 0) {
			
			String tag = mood.getTag(mood.getTagIds(), typeService);
			
			mood.setTag(tag);
		}
		moodService.save(mood);
		
		request.setAttribute("result", new Result());
		mood.setContent(null);// 因为是从这里跳过去的，所以mood里面有值，为了避免被回显，所以清空
		
		return forwardToList;// forward 是从这里跳过去页面的
		
	}
	@RequestMapping("encryptUI")
	public ModelAndView encryptUI(Integer id) throws Exception {
		
		Mood mood = moodService.getById(id);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("mood", mood);
		modelAndView.setViewName("mood/encrypt");
//		return "mood/encryptionUI";
		
		return modelAndView;
	}
	
	@RequestMapping("encrypt")
	public String encrypt(HttpServletRequest request, Integer id, Integer secretCode) throws Exception {
		
		moodService.encryption(id, secretCode);
//		return "mood/list";//这样跳转list没有数据。因为这个方法里面没有加载。如果需要数据，那么你需要重定向
		
		request.setAttribute("result", new Result(Result.TYPE_SUCCESS, "修改加密成功!"));
		
		return forwardToList;
	}
	
	/** 设置状态（精华或者非精华） */
	@RequestMapping("setStatus")
	public String setStatus(HttpServletRequest request, Integer id, Integer statusCode) throws Exception {
		
		moodService.setStatus(id, statusCode);
		
		request.setAttribute("result", new Result());
		
		return forwardToList;
	}
	
	/** 设置置顶 */
	@RequestMapping("setTop")
	public String setTop(HttpServletRequest request, Integer id) throws Exception {
		
		moodService.setTop(id);
		
		request.setAttribute("result", new Result(Result.TYPE_SUCCESS, "置顶成功!"));
		
		return forwardToList;
	}
	/** 取消置顶 */
	@RequestMapping("cancelTop")
	public String cancelTop(HttpServletRequest request, Integer id) throws Exception {
		
		moodService.cancelTop(id);
		
		request.setAttribute("result", new Result(Result.TYPE_SUCCESS, "成功取消置顶!"));
		
		return forwardToList;
	}

}
