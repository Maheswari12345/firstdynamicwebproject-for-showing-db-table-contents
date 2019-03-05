package com.cognizant;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class All
 */
@WebServlet("/All")
public class All extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public All() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//s = new Scanner(System.in);
		PrintWriter out=response.getWriter();
        response.setContentType("text/html");
        out.println("<head><title> Mine.....</title></head>");
        try { 

        out.println("Enter Table name");
        //String a=s.next();
        
        Class.forName("com.mysql.jdbc.Driver");
        out.println(" <link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css' integrity='sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T' crossorigin='anonymous'>");
        out.println("<script src='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js' integrity='sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM' crossorigin='anonymous'></script>");
        Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
        Statement st = (Statement) c.createStatement();
        String d="SELECT * FROM " + request.getParameter("name");
        ResultSet rs = st.executeQuery(d);
        ResultSetMetaData de=(ResultSetMetaData) rs.getMetaData();
        int p=de.getColumnCount();
        out.println("<table border=1px class='table table-bordered table-dark'>");
        for(int i=1;i<=p;i++)
        {
              out.print("<th>"+ de.getColumnName(i) +"</th>");
        }
        out.println("<br>");
        while (rs.next()) {
              out.println("<tr>");
              for(int i=1;i<=p;i++)
              {
                     out.print("<td>"+ rs.getString(i) +"</td>");
              }
              out.println("</tr>");
        }
        rs.close();
        st.close();
        c.close();
 }

        catch(Exception e) {
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
