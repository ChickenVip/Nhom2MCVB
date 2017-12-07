package jwd.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.PreparedStatement;

import jwd.models.GetAccount;

@WebServlet("/adminadddoc")
public class adminadddoc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public adminadddoc() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sesLg = request.getSession(false);
    	
    	if (sesLg.getAttribute("account") == null) {
    		response.sendRedirect("Login");
    	}
    	else {
		request.getRequestDispatcher("/WEB-INF/adminadddoc.jsp").forward(request, response);
    	}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String cont = request.getParameter("content");
		String tit = request.getParameter("title");
		String img = request.getParameter("coimg");
		
		HttpSession sesLg = request.getSession(false);
		
		GetAccount acc = (GetAccount)sesLg.getAttribute("account");
		String pid = acc.getPerid();
		
		Connection c = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/ltweb";
			String username = "root";
			String password = "1234";
			String sql = "insert into contents (title,content,coimg,type,date,perid) value (?,?,?,1,?,?)";
			c = DriverManager.getConnection(url,username,password);
			PreparedStatement pstmt = (PreparedStatement) c.prepareStatement(sql);
			pstmt.setString(1,tit);
			pstmt.setString(2,cont);
			pstmt.setString(3,img);
			pstmt.setTimestamp(4, new java.sql.Timestamp(new java.util.Date().getTime()));
			pstmt.setString(5, pid);
			pstmt.executeUpdate();
			
			response.sendRedirect("adminmc");

		}
		catch(SQLException e)
		{
			throw new ServletException(e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(c!=null) c.close();
			}
			catch(SQLException e)
			{
				throw new ServletException(e);
			}
		}
	}

}
