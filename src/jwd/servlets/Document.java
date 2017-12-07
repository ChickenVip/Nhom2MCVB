package jwd.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jwd.models.NewsEntry;

@WebServlet("/Document")
public class Document extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Document() {
        super();
    }

    @SuppressWarnings("unchecked")
    
    private int findStart(int limit, int selectPage)
	{
		int start = 0;
		if(selectPage > 1)
		{
			start = (selectPage - 1)*limit;
		}
		return start;
	}
	private int findPage(int count, int limit)
	{
		int page = ((count % limit)==0)?(count/limit):(Math.floorDiv(count, limit)+1);
		return page;
	}
	
	private List<NewsEntry> news(String sql) throws ServletException
	{
		List<NewsEntry> entries = new ArrayList<NewsEntry>();
		Connection c = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/ltweb";
			String username = "root";
			String password = "1234";
			c = DriverManager.getConnection(url,username,password);
			java.sql.Statement stmt = c.createStatement();			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				NewsEntry entry = new NewsEntry(
						rs.getInt("id"),						
						rs.getString("title"),
						rs.getString("content"),
						rs.getString("coimg"),
						rs.getInt("type"),
						rs.getDate("date"),
						rs.getInt("perid"));
				entries.add(entry);
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
		return entries;
	}
    
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		int selectPage = 1;
		if(request.getParameter("page")!=null)
		{
			selectPage = Integer.valueOf(request.getParameter("page"));
		}
		int limit = 7;
		int start = findStart(limit, selectPage);
		String sql = "select * from contents where type = 1";
		int count = news(sql).size();
		sql = "select * from contents where type = 1 limit "+start+", "+limit+" ";
		int page = findPage(count, limit);
		List<NewsEntry> entries = news(sql);
		request.setAttribute("page", page);
		request.setAttribute("selectPage", selectPage);
		request.setAttribute("entries", entries);
		request.getRequestDispatcher("WEB-INF/Document.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
