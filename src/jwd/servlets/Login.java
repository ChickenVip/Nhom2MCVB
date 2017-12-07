package jwd.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.PreparedStatement;

import jwd.models.GetAccount;
import jwd.models.GetTitle;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Login() {
        super();
    }


    public boolean CheckLogin(String user, String pass) {

    	try
    	{
    		String driver = "com.mysql.jdbc.Driver";
    		String url = "jdbc:mysql://localhost:3306/ltweb";
    		String username = "root";
    		String password = "1234";
    	
    		String sql = "select * from account where username=? and password=?";	
    		
    		Class.forName(driver);
    		
    		Connection c = DriverManager.getConnection(url,username,password);
    		
    		PreparedStatement st  = (PreparedStatement) c.prepareStatement(sql);
    		st.setString(1,user);
    		st.setString(2, pass);
    		
    		ResultSet rs  = st.executeQuery();
    		
    		
    		rs.last();
    		
    		if (rs.getRow() > 0)
    		{
    			c.close();
    			System.out.println("T");
    			return true;
    		}
    		else 
    		{
    			c.close();
    			System.out.println("F");
    			return false;
    		}
    	}
    	catch (Exception e) {
    		System.out.println("failed");
		}
    	return false;
	}
    
    public GetAccount getAcc(String user, String pass)
    {
    	try
    	{
    		String driver = "com.mysql.jdbc.Driver";
    		String url = "jdbc:mysql://localhost:3306/ltweb";
    		String username = "root";
    		String password = "1234";
    	
    		String sql = "select * from account where username=? and password=?";	
    		
    		Class.forName(driver);
    		
    		Connection c = DriverManager.getConnection(url,username,password);
    		
    		PreparedStatement st  = (PreparedStatement) c.prepareStatement(sql);
    		st.setString(1,user);
    		st.setString(2, pass);
    		
    		ResultSet rs  = st.executeQuery();
    		
    		if(rs.next())
    		{
    			GetAccount acc = new GetAccount(rs.getString("perid"),rs.getString("username"), 
    					rs.getString("password"),rs.getInt("role"));
    			return acc;
    		}
    		System.out.println("ok2");
    	}
    	catch (Exception e) {
    		System.out.println("failed");
		}
    	return null;
    }
   
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {	
		request.getRequestDispatcher("/WEB-INF/Login.jsp").forward(request,response);
	}

	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("username");
		String pass = request.getParameter("password");	
		if(CheckLogin(user, pass)) {
			GetAccount account = getAcc(user,pass);
			HttpSession sesLg = request.getSession(true);	
			sesLg.setAttribute("account", account);
			response.sendRedirect("admin");
		} else {
			response.sendRedirect("Login?err=1");
		}
	}

}
