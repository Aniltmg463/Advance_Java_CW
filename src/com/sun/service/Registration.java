package com.sun.service;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try
		{
			String fname = request.getParameter("fname");
			String lname = request.getParameter("lname");
			String email = request.getParameter("emailid");
			String userid = request.getParameter("username");
			String password = request.getParameter("password");
			
			Class.forName ("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/db_crud", "root", "123");
			Statement stm = con.createStatement();
			stm.executeUpdate
			("insert into tb_register values" + "('"+fname+"', '"+lname+"', '"+email+"', '"+userid+"', '"+password+"')");
			
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
            rd.forward(request, response);

            stm.close();
            con.close();
		}
		catch (Exception e)
		{
			System.out.print("Error" +e);
			e.printStackTrace();
		}
	}

}