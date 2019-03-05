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
 * Servlet implementation class book
 */
@WebServlet("/book")
public class book extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public book() {
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
		/*try{
			//String input;
		//Scanner sc=new Scanner(System.in);
		//System.out.println("Enter the table name");
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
		Statement stmt =conn.createStatement();
	
        String a="SHOW TABLES";
		ResultSet rs=stmt.executeQuery(a);
		ResultSetMetaData d= rs.getMetaData();
		int g=d.getColumnCount();
		for(int i=1;i<=g;i++)
		{
			out.print(d.getColumnName(i)+"\t");
		}
		
		while(rs.next()) {
			for(int i=1;i<=g;i++)
		{
			out.print(rs.getString(i)+"\t" );
		}
			out.println();
		}
		
		rs.close();
		stmt.close();
		conn.close();
	}*/
		try{//String input;
			//Scanner sc=new Scanner(System.in);
			//System.out.println("Enter the table name");
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
			Statement stmt =conn.createStatement();
		
	        String a="SHOW TABLES";
			ResultSet rs=stmt.executeQuery(a);
			ResultSetMetaData d= rs.getMetaData();
			int g=d.getColumnCount();
			out.println("<table border=1px>");
			for(int i=1;i<=g;i++)
			{
				out.print("<th>"+d.getColumnName(i)+"</th>");
			}
			
			while(rs.next())
			{
	            out.println("<tr>");
				for(int i=1;i<=g;i++)
			{
				out.print("<td><a href=''>"+rs.getString(i)+"</a></td>" );
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
