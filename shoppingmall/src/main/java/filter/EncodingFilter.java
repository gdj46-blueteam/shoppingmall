package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class EncodingFilter implements Filter {
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 타켓 서블릿 호출 전 실행
		request.setCharacterEncoding("utf-8");
		System.out.println("utf-8 인코딩 필터 실행");
		chain.doFilter(request, response);	// 타켓 서블릿의 메서드를 호출(Servlet.doGet(), Servlet.doPost())
		// 타켓 서블릿 호출 후 실행
		System.out.println("after doFilter");
	}

}
