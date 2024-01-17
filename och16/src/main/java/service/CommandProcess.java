package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommandProcess {
	 public String requestPro(HttpServletRequest   request,
			                  HttpServletResponse  response
			                  )
	                          throws ServletException,IOException;
}

// 문자타입의 requestPro 메서드 
// Model을 위한 패키지인 service  안에 있는 인터페이스 ( 명령처리) 
// 웹브라우저로부터 요청을 받을 때  HttpServletRequest  _request정보를 서블릿에 전달하기 위한 메소드
// 웹브라우져에게 응답을 돌려줄 HttpServletResponse_servlet은HttpServletResponse객체에 Content Type, 응답코드, 응답 메시지등을 담아서 전송