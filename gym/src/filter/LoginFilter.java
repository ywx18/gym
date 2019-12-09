package filter;

import java.io.IOException;
import java.io.PrintWriter;
 
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginFilter implements Filter{

	public void destroy() {
	}
 
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession(true);
		resp.setContentType("text/html;");
		resp.setCharacterEncoding("utf-8");
		PrintWriter out = resp.getWriter();
		String request_uri = req.getRequestURI();
		String ctxPath = req.getContextPath();
		String uri = request_uri.substring(ctxPath.length());
		if (uri.contains("login.jsp") || uri.contains("Login")||uri.contains(".css")) {
			chain.doFilter(request, response);
		} else {
			if (session.getAttribute("username") != null) {
				chain.doFilter(request, response);
			} else {
				out.println("로그인 하지 않았으니 먼저 로그인해 주십시오!3초 후 로그인 페이지로 돌아갑니다.");
				resp.setHeader("refresh", "3;url=" + ctxPath + "/login.jsp");
				return;
			}
		}
	}
 
	public void init(FilterConfig fConfig) throws ServletException {
	}


}
