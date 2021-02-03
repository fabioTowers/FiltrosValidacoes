package br.com.congresso.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.congresso.dbmock.DBMock;

@WebServlet("/efetuaLogin")
public class MeuServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		String user = (String)request.getParameter("login");
		String senha = (String)request.getParameter("senha");
		boolean isAuth = DBMock.auth(user,senha);
		
		if(isAuth){
			sessao.setAttribute("userLogado", user);
			response.sendRedirect("inicial");
		}else{
			response.sendRedirect("formLogin");
		}
	}

}
