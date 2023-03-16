package com.Controller;

import java.io.IOException;
import java.security.PublicKey;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.memberdao;
import com.Dao.memberdaopractice;


@WebServlet("/member")
public class member extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private memberdao memberdao;
	public void init() {
		 memberdao = new memberdaopractice();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

	}
}