package cn.bdqn.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EncodeFilter implements Filter {

	private String charset;
	//初始化
	public void init(FilterConfig config) throws ServletException {
		charset= config.getInitParameter("charset");
	}
	
	//过滤
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		request.setCharacterEncoding(charset);
		response.setContentType("text/html;charset="+charset);
		//过滤通过交给下一个,如果没有就直接访问资源
		chain.doFilter(request, response);
	}
	
	//销毁
	public void destroy() {
		charset=null;
	}

}
