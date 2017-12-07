package jwd.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.PreparedStatement;

import jwd.models.GetAccount;
import jwd.models.GetInfo;

@WebServlet("/adminaddac")
public class adminaddac extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public adminaddac() {
        super();
       
    }

    public void AddAdm(String pid,String name,int age,String phone,int idc,String add, String avt) {
    	try
    	{
    		String driver = "com.mysql.jdbc.Driver";
    		String url = "jdbc:mysql://localhost:3306/ltweb";
    		String username = "root";
    		String password = "1234";
    	
    		String sql = "INSERT INTO admin (perid, name, age, phone, idcard, address, avartar) VALUES (?, ?, ?, ?, ?, ?, ?);";
    		
    		
    		Class.forName(driver);
    		
    		Connection c = DriverManager.getConnection(url,username,password);
    		
    		PreparedStatement st  = (PreparedStatement) c.prepareStatement(sql);
    		st.setString(1,pid);
    		st.setString(2,name);
    		st.setInt(3, age);
    		st.setString(4, phone);
    		st.setInt(5, idc);
    		st.setString(6, add);
    		st.setString(7, avt);

    		st.executeUpdate();
	
    		System.out.println("ok");
    	}
    	catch (Exception e) {
    		System.out.println("failed");
		}	
	}
    
    public void AddUser(String user,String pid, int role)
    {
		try
    	{
    		String driver = "com.mysql.jdbc.Driver";
    		String url = "jdbc:mysql://localhost:3306/ltweb";
    		String username = "root";
    		String password = "1234";
    	
    		String sql = "insert into account (username,password,perid,role) value (?,?,?,?)";
    		
    		
    		Class.forName(driver);
    		
    		Connection c = DriverManager.getConnection(url,username,password);
    		
    		PreparedStatement st  = (PreparedStatement) c.prepareStatement(sql);
    		st.setString(1,user);
    		st.setString(2, "123");
    		st.setString(3, pid);
    		st.setInt(4, role);
    		
    		st.executeUpdate();
	
    		System.out.println("ok");
    	}
    	catch (Exception e) {
    		System.out.println("failed");
		}	
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
		HttpSession sesLg = request.getSession(false);

		if (sesLg.getAttribute("account") == null) {
    		response.sendRedirect("Login");
    	}
    	else {
    		GetAccount account1 = (GetAccount)sesLg.getAttribute("account");
    		if (account1.getRole() < 5)	{	    
			    response.sendRedirect("admin");
    		}
        	else {			
    			request.getRequestDispatcher("/WEB-INF/adminaddac.jsp").forward(request, response);
        	}
    	}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String Auser = request.getParameter("Auser");
		String role =  request.getParameter("Arole");
		String Apid = request.getParameter("Apid");
		String Aname = request.getParameter("Aname");
		String age = request.getParameter("Aage");
		String Aphone = request.getParameter("Aphone");
		String Aadd = request.getParameter("Aadd");
		String idc = request.getParameter("Aidc");
		
		String Aavt = "./img/avt.jpg";
		
		if(Apid ==""|| Aname==""|| role==""|| age==""||idc==""|| Aphone==""||  Aadd==""|| Auser==""){
			response.sendRedirect("adminaddac?err=1");
		}
		else{
			try
			{
				int Aage = Integer.parseInt(age);
				int Aidc = Integer.parseInt(idc);
				int Arole = Integer.parseInt(role);
				
				AddAdm(Apid, Aname, Aage, Aphone, Aidc, Aadd, Aavt);
				AddUser(Auser, Apid, Arole);
				response.sendRedirect("adminaddac?err=3");
			}
			catch (Exception e) {
				response.sendRedirect("adminaddac?err=2");
			}
		}
	}

}
