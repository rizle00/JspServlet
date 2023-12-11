package common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter{
	//서블릿 컨테이너에서 http요청과 응답을 중간에 가로채어 필터 체인을 통해 처리하는 기능을 의미함.(=정수기)
//	인터셉터
//	1.인코딩 설정 : 클라이언트에서 서버로 오는 요청의 문자 인코딩 설정, 응답의 문자 인코등 설정 들을 처리함
//	2.인증과 권한 부여, 3.로깅, 4.캐싱, 5.예외처리.
	
	private String encoding;
//	
//	인코딩 초기화 : web.xml에서 넘어온 param 사용
	@Override
		public void init(FilterConfig filterConfig) throws ServletException {
//			Filter.super.init(filterConfig);
			encoding = filterConfig.getInitParameter("encoding"); //UTF-8
		}
	
//	필터 작동부
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding(encoding);//UTF-8
		chain.doFilter(request, response);
	}
	
}
