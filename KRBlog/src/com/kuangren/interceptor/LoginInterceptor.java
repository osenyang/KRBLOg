package com.kuangren.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.kuangren.enumerate.SessionEnum;
import com.kuangren.po.Result;
import com.kuangren.po.user.User;

/**
 * 
 * Title: com.kuangren.interceptor.LoginInterceptor
 * Description:	登陆认证拦截器
 * @createTime: 2017年2月3日 - 下午5:36:14
 * @Company: KuangRen
 * @author: OsenYang
 * @version: 1.0
 *
 */
public class LoginInterceptor implements HandlerInterceptor {

	
	//进入 Handler方法之前执行
	//用于身份认证、身份授权
	//比如身份认证，如果认证通过表示当前用户没有登陆，需要此方法拦截不再向下执行
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		//判断先后的逻辑：先覆盖大的，多的，经常的
		
		//获取 session
		HttpSession session  = request.getSession();
		//从session中取出用户身份信息
		User manager = (User) session.getAttribute(SessionEnum.MANAGER);
		if(manager != null){
			//身份存在，放行
			return true;
		}//我最大，所以放最前面，后面哪怕一千条判断都与我无关。哈哈有点意思，最大摆最前。最凶残摆最后/里（manage）
		
		/*Boolean isJustWarning = false;
		if (session.getAttribute(SessionEnum.RESULT) != null) {
			isJustWarning = true;
			session.removeAttribute(SessionEnum.RESULT);
		}*/
		
		//获取请求的url
		String url = request.getRequestURI();
		
		if(url.indexOf("index.action")>=0){
			/*if (isJustWarning) {
				putSessionWarning(session);
			}*/
			//如果访问首页，放行
			return true;
		}
		
		
		//判断url是否是公开 地址（实际使用时将公开地址配置配置文件中）
		//这里公开地址是登陆提交的地址
		
		/*if(url.indexOf("user/save")>=0){
			//如果是注册，放行
			return true;
		}*/
		
		session.removeAttribute(SessionEnum.RESULT);//这个必须在index 之后。再其他自由访问的链接之前
		
		/*if(url.indexOf("login.action")>=0 || url.indexOf("logout.action")>=0){
			//如果进行登陆或者登出，放行
			return true;
		}*/
//		if(url.indexOf("free")>=0 || url.indexOf("open")>=0){
		if(url.indexOf("free") >= 0 ){
			if (url.indexOf("manage")>=0) {
				putSessionWarning(session);
				request.getRequestDispatcher("/index.jsp").forward(request, response);
				return false;
			}
			//如果是自由的或者是公开的，放行
			return true;
		}
		
		/*if (url.indexOf("manage_") >= 0) {
			putSessionWarning(session);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return false;
		}*/
		
		if((url.indexOf("list")>=0 || url.indexOf("detail")>=0 ) && url.indexOf("manage") < 0){
			//如果是查看，并且不能是包含 manage，放行
			return true;
		}
		
		
		//session.setAttribute(SessionEnum.RESULT, new Result(Result.TYPE_WARNING, "没有权限！请登录"));
		putSessionWarning(session);
		
		//执行这里表示用户身份需要认证，跳转首页
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		
		//return false表示拦截，不向下执行
		//return true表示放行
		return false;
	}
	
	private void putSessionWarning(HttpSession session){
		if (session.getAttribute(SessionEnum.USER) != null) {
			
			session.setAttribute(SessionEnum.RESULT, new Result(Result.TYPE_WARNING, "没有权限！您不是管理员"));

		}else {
			
			session.setAttribute(SessionEnum.RESULT, new Result(Result.TYPE_WARNING, "没有权限！请先登录"));
		}
	}

	//进入Handler方法之后，返回modelAndView之前执行
	//应用场景从modelAndView出发：将公用的模型数据(比如菜单导航)在这里传到视图，也可以在这里统一指定视图
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		System.out.println("HandlerInterceptor1...postHandle");
		
	}

	//执行Handler完成执行此方法
	//应用场景：统一异常处理，统一日志处理
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		System.out.println("HandlerInterceptor1...afterCompletion");
	}

}
