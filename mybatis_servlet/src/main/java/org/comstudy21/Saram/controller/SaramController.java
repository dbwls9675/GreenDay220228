package org.comstudy21.Saram.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy21.Saram.model.SaramDao;
import org.comstudy21.Saram.model.SaramDto;

@WebServlet("/saram/*")
public class SaramController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SaramDao saramDao = new SaramDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<SaramDto> saramList = saramDao.selectAll();
		
		request.setAttribute("saramList", saramList);
		request.setAttribute("title", "saramList");
		
		String viewName="/WEB-INF/views/saram/list.jsp";
		RequestDispatcher view = request.getRequestDispatcher(viewName);
		view.forward(request, response);
		
	}

}
