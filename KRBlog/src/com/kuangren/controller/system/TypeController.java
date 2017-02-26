package com.kuangren.controller.system;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kuangren.po.Result;
import com.kuangren.po.type.Type;
import com.kuangren.po.type.TypeCustom;
import com.kuangren.po.type.TypeExample;
import com.kuangren.service.system.TypeService;

/**
 * 
 * Title: com.kuangren.controller.TypeController
 * Description:
 * @createTime: 2017年2月15日 - 下午3:02:01
 * @Company: KuangRen
 * @author: OsenYang
 * @version: 1.0
 */
@Controller
@RequestMapping("/manage/type")
public class TypeController {

	@Autowired
	private TypeService typeService;
	
	String redirectToList = "redirect:/manage/type/list.action";
	String forwardToList = "forward:/manage/type/list.action";

//	private List<MultipartFile> imgs;

	@RequestMapping("/list")
	public ModelAndView list() throws Exception {
		

	    
        TypeExample example = new TypeExample();
		List<TypeCustom> typeList = typeService.list(example);
		
		// 返回ModelAndView
		ModelAndView modelAndView = new ModelAndView();
		// 相当 于request的setAttribut，在jsp页面中通过typeList取数据
		modelAndView.addObject("typeList", typeList);
		modelAndView.setViewName("type/list");
		
		return modelAndView;

	}
	
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam(required=true)Integer id) throws Exception {
		typeService.delete(id);
		
		request.setAttribute("result", new Result(Result.TYPE_SUCCESS, "成功删除!"));
		
		return forwardToList;
	}
	
		
	@RequestMapping(value = "/saveUI", method = { RequestMethod.POST, RequestMethod.GET })
	public String saveUI() throws Exception {
		
		//准备数据
		
		return "/type/save";
		
	}
	
	@RequestMapping("/save")
	public String save(Model model, HttpServletRequest request, 
			@Validated Type type, BindingResult bindingResult) throws Exception {
		
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
			
			
			//可以直接使用model将提交pojo回显到页面
			model.addAttribute("type", type);
			
			// 出错重新到商品修改页面
			model.addAttribute("result", new Result(Result.TYPE_ERROR, "操作失败！原因：" + allErrors.get(0).getDefaultMessage()));
//			return "forward:/type/saveUI.action";
			return forwardToList;
		}
		
		typeService.save(type);
		
		request.setAttribute("result", new Result());
		
		return forwardToList;
		
	}
	
	
	/** 加密页面 */
	@RequestMapping("/encryptUI")
	public ModelAndView encryptUI(Integer id) throws Exception {
		
		Type type = typeService.getById(id);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("type", type);
		modelAndView.setViewName("type/encrypt");
		
		return modelAndView;
	}
	/** 加密的执行 */
	@RequestMapping("/encrypt")
	public String encrypt(HttpServletRequest request, Integer id, Integer secretCode) throws Exception {
		
		typeService.encryption(id, secretCode);
		
		request.setAttribute("result", new Result(Result.TYPE_SUCCESS, "修改加密成功!"));
		
		return forwardToList;
	}
	
	
	//--------------------------------------
}
