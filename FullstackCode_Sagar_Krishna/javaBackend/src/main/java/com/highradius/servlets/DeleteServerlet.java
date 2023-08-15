package com.highradius.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.highradius.implementation.InvoiceDao;
import com.highradius.implementation.InvoiceDaoImpl;

/**
 * Servlet implementation class DeleteServerlet
 */
@WebServlet("/DeleteServerlet")
public class DeleteServerlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private InvoiceDao invoicedao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServerlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() throws ServletException{
		invoicedao = new InvoiceDaoImpl(); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int v = 0;
		response.setContentType("application/json");
    	PrintWriter out = response.getWriter();
    	Gson gson = new Gson();
    	String s = "";
    	String jsonresponse = new String();
    	Integer id = Integer.parseInt(request.getParameter("Id"));
    	try {
    		v = invoicedao.deleteInvoice(id); 
    		if (v >= 0)
    		{
    			s = "SUCCESSFULLY DELETED!";
    		}
    		else
    			s = "ERROR";
    		jsonresponse = gson.toJson(s);
    		out.println(jsonresponse);
    	}catch (Exception e) {
			// TODO: handle exception
    		e.printStackTrace();
    		
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
