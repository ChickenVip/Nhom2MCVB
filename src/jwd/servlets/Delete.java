package jwd.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;

@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	boolean f = false;
	
    public Delete() {
        super();

    }
    
    public boolean getDelete(int id)
    {
    	try
    	{
    		String driver = "com.mysql.jdbc.Driver";
    		String url = "jdbc:mysql://localhost:3306/ltweb";
    		String username = "root";
    		String password = "1234";
    	
    		String sql = "delete from contents where id=?";	
    		
    		Class.forName(driver);
    		
    		Connection c = DriverManager.getConnection(url,username,password);
    		
    		PreparedStatement st  = (PreparedStatement) c.prepareStatement(sql);
    		st.setInt(1,id);
    		
    		st.executeUpdate();
    		
    		System.out.println("ok");
    		return true;
    	}
    	catch (Exception e) {
    		System.out.println("failed");
		}
    	return false;
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.valueOf(request.getParameter("id"));	
		String rb = request.getParameter("rb");	
		f = getDelete(id);	
		System.out.println(rb);
		response.sendRedirect(rb);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
