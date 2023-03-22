package com.Controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.memberdao;
import com.Dao.memberdaopractice;
import com.bean.Memberbean;


@WebServlet("/member")
public class member extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private memberdao memberdao;
	public void init() {
		 memberdao = new memberdaopractice();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		switch (action) {
		case "list":{
			showAll(request,response);
			break;
		}
		case "new": {
			shownewform(request,response);
			break;
		}
		case "insert":{
			insertmember(request,response);
			break;
		}
		case "delete":{
			deletemember(request,response);
			break;
		}
		case "update":{
			updatemember(request,response);
			break;
		}
		case "edit":{
			showeditform(request,response);
			break;
		}
		case "show":{
			showAmember(request,response);
			break;
		}
		
		default:
			showAll(request,response);
			break;
		}	
	}
	//會員編輯
	private void showeditform(HttpServletRequest request, HttpServletResponse response) {
		int m_number=Integer.parseInt(request.getParameter("m_number"));
		Memberbean AMember = memberdao.showAmember(m_number);
		System.out.println(m_number);
		System.out.println(AMember);
		request.setAttribute("AMember", AMember);
			try {
				request.getRequestDispatcher("/View/memberform.jsp").forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	//查詢單一會員
	private void showAmember(HttpServletRequest request, HttpServletResponse response) {
		int m_number=Integer.parseInt(request.getParameter("m_number"));
		Memberbean AMember = memberdao.showAmember(m_number);
		request.setAttribute("AMember", AMember);
		try {
			request.getRequestDispatcher("/View/showmember.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//更新會員
	private void updatemember(HttpServletRequest request, HttpServletResponse response) {
		int m_number=Integer.parseInt(request.getParameter("m_number"));
		String account=request.getParameter("m_account");
		String password=request.getParameter("m_password");
		String name=request.getParameter("m_name");
		String phone=request.getParameter("m_phone");
		String address=request.getParameter("m_address");
		String email=request.getParameter("m_email");
		Date birth=null;
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		    java.util.Date utilDate;
			try {
				utilDate = sdf.parse(request.getParameter("m_birth"));
				birth = new Date(utilDate.getTime());
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		int point=Integer.valueOf(request.getParameter("m_points"));
		String id=request.getParameter("m_id");
		Memberbean memberbean = new Memberbean(m_number,account, password, name, phone, address, email, birth, point, id);
		memberdao.updateMember(memberbean);
		try {
			response.sendRedirect("member?action=list");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//刪除會員
	private void deletemember(HttpServletRequest request, HttpServletResponse response) {
		int number = Integer.parseInt(request.getParameter("m_number"));
			 memberdao.deltetMember(number);
			try {
				response.sendRedirect("member?action=list");
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	//新增會員
	private void insertmember(HttpServletRequest request, HttpServletResponse response) {
		
		String account=request.getParameter("m_account");
		String password=request.getParameter("m_password");
		String name=request.getParameter("m_name");
		String phone=request.getParameter("m_phone");
		String address=request.getParameter("m_address");
		String email=request.getParameter("m_email");
		Date birth=null;
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		    java.util.Date utilDate;
			try {
				utilDate = sdf.parse(request.getParameter("m_birth"));
				birth = new Date(utilDate.getTime());
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		LocalDate create = LocalDate.now();
		Date creatdate=Date.valueOf(create);
		int point=Integer.valueOf(request.getParameter("m_points"));
		String id=request.getParameter("m_id");
		Memberbean memberbean = new Memberbean(point, account, password, name, phone, address,email,birth,creatdate,point,id);
		memberdao.insertMember(memberbean);
		try {
			response.sendRedirect("member?action=list");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	//查詢所有會員
	private void showAll(HttpServletRequest request, HttpServletResponse response) {
		List<Memberbean> Allmember = memberdao.showAllMember();
		request.setAttribute("Allmember", Allmember);
		try {
			request.getRequestDispatcher("/View/memberlist.jsp").forward(request, response);
		} catch (ServletException e) {		
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//新增會員然後導向空白的表單
	private void shownewform(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.getRequestDispatcher("/View/membernewform.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}
}