package jwd.servlets;


import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import jwd.models.GetTitle;
import jwd.models.GetTitleFull;


@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Home() {
        super();

    }
    
    @SuppressWarnings("unchecked")
    
    private List<GetTitle> getTitNews() throws ServletException
    {
    	try
    	{
    		String driver = "com.mysql.jdbc.Driver";
    		String url = "jdbc:mysql://localhost:3306/ltweb";
    		String username = "root";
    		String password = "1234";
    	
    		String sql = "select id,title,date from contents where type = 0 order by date DESC limit 0,5";
    		
    		
    		Class.forName(driver);
    		
    		Connection c = DriverManager.getConnection(url,username,password);
    		
    		Statement st  = c.createStatement();
    		
    		ResultSet rs  = st.executeQuery(sql);
    		
    		List<GetTitle> title = new ArrayList<GetTitle>();
    		
    		while (rs.next()){
    			title.add(new GetTitle(rs.getString("id"), rs.getString("title"), 
    					rs.getString("date")));   
    			System.out.println("ok");
    		}
    		c.close();
    		return title;
    	}
    	catch (Exception e) {
    		System.out.println("failed");
		}
    	return null;
    }
    
    @SuppressWarnings("unchecked")
    private List<GetTitle> getTitDocs() throws ServletException
    {
    	try
    	{
    		String driver = "com.mysql.jdbc.Driver";
    		String url = "jdbc:mysql://localhost:3306/ltweb";
    		String username = "root";
    		String password = "1234";
    	
    		String sql = "select id,title,date from contents where type = 1 order by date DESC limit 0,5";
    				
    		Class.forName(driver);
    		
    		Connection c = DriverManager.getConnection(url,username,password);
    		
    		Statement st  = c.createStatement();
    		
    		ResultSet rs  = st.executeQuery(sql);
    		
    		List<GetTitle> title = new ArrayList<GetTitle>();
    		
    		while (rs.next()){
    			title.add(new GetTitle(rs.getString("id"), rs.getString("title"), 
    					rs.getString("date")));   
    			System.out.println("ok");
    		}
    		c.close();
    		return title;
    	}
    	catch (Exception e) {
    		System.out.println("failed");
		}
    	return null;
    }
    
    private List<GetTitleFull> getTitFullNews() throws ServletException
    {
    	try
    	{
    		String driver = "com.mysql.jdbc.Driver";
    		String url = "jdbc:mysql://localhost:3306/ltweb";
    		String username = "root";
    		String password = "1234";
    	
    		String sql = "select id,title,coimg,name,date from contents,admin "
    				+ "where type = 0 and admin.perid = contents.perid order by date DESC limit 0,3 ";
    		
    		
    		Class.forName(driver);
    		
    		Connection c = DriverManager.getConnection(url,username,password);
    		
    		Statement st  = c.createStatement();
    		
    		ResultSet rs  = st.executeQuery(sql);
    		
    		List<GetTitleFull> title = new ArrayList<GetTitleFull>();
    		
    		while (rs.next()){
    			title.add(new GetTitleFull(rs.getString("id"), rs.getString("title"), 
    					rs.getString("coimg"),rs.getString("name"),rs.getString("date")));   
    			System.out.println("ok");
    		}
    		c.close();
    		return title;
    	}
    	catch (Exception e) {
    		System.out.println("failed");
		}
    	return null;
    }

    protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		List<GetTitle> titlesNew = getTitNews();		
		request.setAttribute("titNew", titlesNew);
		
		List<GetTitleFull> tittlesHome = getTitFullNews();
		request.setAttribute("titHome", tittlesHome);
		
		List<GetTitle> titlesDoc = getTitDocs();
		request.setAttribute("titDoc", titlesDoc);
		
		request.getRequestDispatcher("/WEB-INF/Home.jsp").forward(request, response);	
	}

	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
