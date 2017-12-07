package jwd.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import jwd.models.GetInfo;
import jwd.models.GetTitle;

@WebServlet("/admin")
public class admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public admin() {
        super();
    }

    public GetInfo getInfos(String perid)

    {	
    	try
    	{
    		String driver = "com.mysql.jdbc.Driver";
    		String url = "jdbc:mysql://localhost:3306/ltweb";
    		String username = "root";
    		String password = "1234";
    	
    		String sql = "select * from admin where perid = ?";
    		
    		
    		Class.forName(driver);
    		
    		Connection c = DriverManager.getConnection(url,username,password);
    		
    		PreparedStatement st  = (PreparedStatement) c.prepareStatement(sql);
    		st.setString(1,perid);
    		
    		ResultSet rs  = st.executeQuery();
    		GetInfo info = null;
    		while (rs.next()){
    			info = new GetInfo(rs.getString("perid"),rs.getString("name"),
    				rs.getInt("age"),rs.getString("phone"),rs.getString("idcard"),
    				rs.getString("address"),rs.getString("avartar"));
    		}
    		c.close();
    		System.out.println("ok");
    		return info;
    	}
    	catch (Exception e) {
    		System.out.println("failed");
		}
    	return null;
    }
	
    protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
    	HttpSession sesLg = request.getSession(false);
    	
    	if (sesLg.getAttribute("account") == null)
    	{
    		response.sendRedirect("Login");
    	}
    	else 
    	{
    		GetAccount acc = (GetAccount)sesLg.getAttribute("account");
	    	GetInfo info = getInfos(acc.getPerid());
	    	
	    	HttpSession sesAc = request.getSession(true);	
			sesAc.setAttribute("info", info);
			
			request.setAttribute("info", info);
			request.getRequestDispatcher("/WEB-INF/admin.jsp").forward(request, response);	
    	}

	}

	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		Integer age = Integer.parseInt(request.getParameter("age"));
		String phone = request.getParameter("phone");
		Integer idcard = Integer.parseInt(request.getParameter("idcard"));
		String address = request.getParameter("address");
		Connection c = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/ltweb";
			String username = "root";
			String password = "1234";
			String sql = "update admin set name=?,age=?,phone=?,idcard=?,address=? where perid=?";
			c = DriverManager.getConnection(url,username,password);
			PreparedStatement pstmt = (PreparedStatement) c.prepareStatement(sql);
			pstmt.setString(1,name);
			pstmt.setInt(2,age);
			pstmt.setString(3,phone);
			pstmt.setInt(4,idcard);
			pstmt.setString(5,address);
			pstmt.setString(6,id);
			pstmt.executeUpdate();

			response.sendRedirect("admin");
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
