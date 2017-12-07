package jwd.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jwd.models.NewsEntry;


/**
 * Servlet implementation class EditContent
 */
@WebServlet("/EditContent")
public class EditContent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditContent() {
        super();
        // TODO Auto-generated constructor stub
    }
private NewsEntry getEntry(Integer id) throws ServletException, IOException {
    	
    	Connection c = null;
    	try
		{
    		NewsEntry entry = null;
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/ltweb";
			String username = "root";
			String password = "1234";
			c = DriverManager.getConnection(url,username,password);
			String sql = "select * from contents where id = ? and type = 0";
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setInt(1,id);
			ResultSet rs = stmt.executeQuery();
			if(rs.next())
			{
				entry = new NewsEntry(
						rs.getInt("id"),
						rs.getString("title"),
						rs.getString("content"),
						rs.getString("coimg"),
						rs.getInt("type"),
						rs.getDate("date"),
						rs.getInt("perid"));
						return entry;
			}
			
				
		}
		catch(ClassNotFoundException e)
		{
			throw new ServletException(e);
		}
		catch(SQLException e)
		{
			throw new ServletException(e);
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
		return null;
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer id = Integer.valueOf(request.getParameter("id"));
		NewsEntry entry = getEntry(id);
		request.setAttribute("entry", entry);
		request.getRequestDispatcher("/WEB-INF/EditContent.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		Integer id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String coimg = request.getParameter("coimg");
		Integer type = Integer.parseInt(request.getParameter("type"));
		Connection c = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/ltweb";
			String username = "root";
			String password = "1234";
			String sql = "update contents set title=?,content=?,coimg=?,type=?,date=? where id=?";
			c = DriverManager.getConnection(url,username,password);
			PreparedStatement pstmt = (PreparedStatement) c.prepareStatement(sql);
			pstmt.setString(1,title);
			pstmt.setString(2,content);
			pstmt.setString(3,coimg);
			pstmt.setInt(4,type);
			pstmt.setTimestamp(5, new java.sql.Timestamp(new java.util.Date().getTime()));
			pstmt.setInt(6,id);
			pstmt.executeUpdate();

			response.sendRedirect("admintt");
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
