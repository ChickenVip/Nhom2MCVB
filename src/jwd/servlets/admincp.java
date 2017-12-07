package jwd.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.PreparedStatement;

import jwd.models.GetAccount;


@WebServlet("/admincp")
public class admincp extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public admincp() {
        super();
    }

    private void getNewPass(String user,String newPass) {	
		try
    	{
    		String driver = "com.mysql.jdbc.Driver";
    		String url = "jdbc:mysql://localhost:3306/ltweb";
    		String username = "root";
    		String password = "1234";
    	
    		String sql = "UPDATE account SET password=? WHERE username=?";	
    		
    		Class.forName(driver);
    		
    		Connection c = DriverManager.getConnection(url,username,password);
    		
    		PreparedStatement st  = (PreparedStatement) c.prepareStatement(sql);
    		st.setString(1,newPass);
    		st.setString(2, user);
    		
    		st.executeUpdate();
    		
    		System.out.println("ok2");
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
    		request.getRequestDispatcher("/WEB-INF/admincp.jsp").forward(request, response);
    	}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesLg = request.getSession(false);
		GetAccount acc = (GetAccount)sesLg.getAttribute("account");
		
		String oldPass = request.getParameter("oldPass");
		String newPass = request.getParameter("newPass");
		String renewPass = request.getParameter("renewPass");
		String curPass = acc.getPass();
		

		System.out.println(oldPass+" "+newPass+" "+renewPass+" "+ curPass +" a");
		
		if (oldPass == "" || newPass == "" || renewPass == "")
			response.sendRedirect("admincp?err=0");
		else if(oldPass.equals(curPass) == false) {
			response.sendRedirect("admincp?err=1");
		} 
		else if(oldPass.equals(newPass)) {
			response.sendRedirect("admincp?err=2");
		}
		else if(newPass.equals(renewPass) == false){
			response.sendRedirect("admincp?err=3");
		}
		else {
			getNewPass(acc.getUser(), newPass);
			response.sendRedirect("admincp?err=5");
		}
	}

	
}
