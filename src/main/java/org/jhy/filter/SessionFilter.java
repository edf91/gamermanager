package org.jhy.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jhy.utils.SessionUser;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * 登陆过滤器
 */
public class SessionFilter extends OncePerRequestFilter{
	private List<String> publicResources = new ArrayList<String>();
	public SessionFilter() {
		publicResources.add("/martixAdmin/login.html");
		publicResources.add("/index.html");
		publicResources.add("/user/login");
		publicResources.add("/user/logout");
	}
	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filter)
			throws ServletException, IOException {
		String requestPath = request.getRequestURI();
		System.out.println(requestPath);
		// 公共资源
		if(publicResources.contains(requestPath) || (requestPath.contains(".") && !requestPath.endsWith(".html"))){
			filter.doFilter(request, response);
			return ;
		}
		HttpSession session = request.getSession();
		SessionUser user = (SessionUser) session.getAttribute(SessionUser.SESSION_USER_NAME);
		if(user == null){
			String path = request.getServletContext().getContextPath();
			System.out.println(path);
			response.sendRedirect(path+"/index.html");
			return ;
		}
		filter.doFilter(request, response);
	}
}
