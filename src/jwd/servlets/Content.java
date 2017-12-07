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

import com.mysql.jdbc.PreparedStatement;

import jwd.models.GetContent;

@WebServlet("/Content")
public class Content extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Content() {
        super();
    }

    public GetContent getContentEntry(int id)

    {
    	try
    	{
    		String driver = "com.mysql.jdbc.Driver";
    		String url = "jdbc:mysql://localhost:3306/ltweb";
    		String username = "root";
    		String password = "1234";
    	
    		String sql = "select title,content,name,type from contents,admin where contents.perid=admin.perid and id=?";	
    		
    		Class.forName(driver);
    		
    		Connection c = DriverManager.getConnection(url,username,password);
    		
    		PreparedStatement st  = (PreparedStatement) c.prepareStatement(sql);
    		st.setInt(1,id);

    		ResultSet rs  = st.executeQuery();
    		System.out.println("ok");
    		
    		if(rs.next())
    		{
    			GetContent entry = new GetContent(rs.getString("title"), rs.getString("content"), 
    					rs.getString("name"),rs.getInt("type"));
        		System.out.println("ok");
        		return entry;
    		}
    		
    	}
    	catch (Exception e) {
    		System.out.println("failed");
		}
    	return null;
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer id = Integer.valueOf(request.getParameter("id"));
		GetContent entry = getContentEntry(id);
		request.setAttribute("entry", entry);
		request.getRequestDispatcher("/WEB-INF/Content.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
