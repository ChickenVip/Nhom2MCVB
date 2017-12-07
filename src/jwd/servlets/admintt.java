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

import jwd.models.GetTitleFull;

@WebServlet("/admintt")
public class admintt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public admintt() {
        super();
    }

    private List<GetTitleFull> getTitFullNews() throws ServletException
    {
    	try
    	{
    		String driver = "com.mysql.jdbc.Driver";
    		String url = "jdbc:mysql://localhost:3306/ltweb";
    		String username = "root";
    		String password = "1234";
    	
    		String sql = "select id,title,coimg,name,date from contents,admin where type = 0 and admin.perid = contents.perid";
    		
    		
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
			List<GetTitleFull> titfDoc = getTitFullNews();
			request.setAttribute("titfDoc", titfDoc);
			request.getRequestDispatcher("/WEB-INF/admintt.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
