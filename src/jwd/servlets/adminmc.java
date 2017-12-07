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

import jwd.models.GetTitle;
import jwd.models.GetTitleFull;


@WebServlet("/adminmc")
public class adminmc extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public adminmc() {
        super();
    }

@SuppressWarnings("unchecked")
    
    private List<GetTitleFull> getTitFullDocs() throws ServletException
    {
    	try
    	{
    		String driver = "com.mysql.jdbc.Driver";
    		String url = "jdbc:mysql://localhost:3306/ltweb";
    		String username = "root";
    		String password = "1234";
    	
    		String sql = "select id,title,coimg,name,date from contents,admin where type = 1 and admin.perid = contents.perid";
    		
    		
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sesLg = request.getSession(false);
		
		if (sesLg.getAttribute("account") == null)
    	{
    		response.sendRedirect("Login");
    	}
		else
		{
			List<GetTitleFull> titfNew = getTitFullDocs();
			request.setAttribute("titfNew", titfNew);
			request.getRequestDispatcher("/WEB-INF/adminmc.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getParameter("btnDelete");
		
		doGet(request, response);
	}

}
