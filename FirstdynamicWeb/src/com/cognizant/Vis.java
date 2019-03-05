package com.cognizant;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Vis
 */
@WebServlet("/Vis")
public class Vis extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Vis() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out=response.getWriter();
		try{//String input;
		//Scanner sc=new Scanner(System.in);
		//System.out.println("Enter the table name");
			//response .setContentType("html/css");
			out.println(" <link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css' integrity='sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T' crossorigin='anonymous'>");
			out.println("<script src='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js' integrity='sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM' crossorigin='anonymous'></script>");
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
		Statement stmt =conn.createStatement();
	
        String a="SHOW TABLES";
		ResultSet rs=stmt.executeQuery(a);
		ResultSetMetaData d= rs.getMetaData();
		int g=d.getColumnCount();
		out.println("<table border=1px class='table table-bordered table-dark'>");
		for(int i=1;i<=g;i++)
		{
			out.print("<th>"+d.getColumnName(i)+"</th>");
		}
		
		while(rs.next())
		{
            out.println("<tr>");
			for(int i=1;i<=g;i++)
		{
			out.print("<td><a href='All?name="+rs.getString(i)+"'>"+rs.getString(i)+"</a></td>" );
		}
			out.println("</tr>");
		}
		
		rs.close();
		stmt.close();
		conn.close();
	}
		catch(Exception e)
		{
			out.println(e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
