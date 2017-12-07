package jwd.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

import com.sun.glass.ui.Window;

import jwd.models.GetAccount;


@WebServlet("/adminac")
public class adminac extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public adminac() {
        super();
    }
    
    @SuppressWarnings("unchecked")
    private List<GetAccount> getListAcc() throws ServletException
    {
    	try
    	{
    		String driver = "com.mysql.jdbc.Driver";
    		String url = "jdbc:mysql://localhost:3306/ltweb";
    		String username = "root";
    		String password = "1234";
    	
    		String sql = "select perid,username,password,role from account";
    		    		
    		Class.forName(driver);
    		
    		Connection c = DriverManager.getConnection(url,username,password);
    		
    		Statement st  = c.createStatement();
    		
    		ResultSet rs  = st.executeQuery(sql);
    		
    		List<GetAccount> acc = new ArrayList<GetAccount>();
    		
    		while (rs.next()){
    			acc.add(new GetAccount(rs.getString("perid"),rs.getString("username"), 
    					rs.getString("password"),rs.getInt("role")));   
    			System.out.println("ok");
    		}
    		c.close();
    		return acc;
    	}
    	catch (Exception e) {
    		System.out.println("failed2");
		}
    	return null;
    }

    private boolean ResetPass(String user)
    {
		try
    	{
    		String driver = "com.mysql.jdbc.Driver";
    		String url = "jdbc:mysql://localhost:3306/ltweb";
    		String username = "root";
    		String password = "1234";
    	
    		String sql = "update account set password=? where username=? ";
    		    		
    		Class.forName(driver);
    		
    		Connection c = DriverManager.getConnection(url,username,password);
    		
    		PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setString(1,"123");
			stmt.setString(2, user);
			
			stmt.executeUpdate();
			
    		c.close();
    		
    		return true;
    	}
    	catch (Exception e) {
    		System.out.println("failed3");
		}
		return false;
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
    			List<GetAccount> acco = getListAcc();		
    			request.setAttribute("acco", acco);
    			request.getRequestDispatcher("/WEB-INF/adminac.jsp").forward(request, response);
        	}
    	}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user = request.getParameter("userid");
		
		if(ResetPass(user)){
			response.sendRedirect("adminac?err=0");
		}
		else
		{
			response.sendRedirect("adminac?err=1");
		}
	}

}
