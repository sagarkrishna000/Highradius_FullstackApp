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
 * Servlet implementation class UpadateServerlet
 */
@WebServlet("/UpadateServerlet")
public class UpadateServerlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private InvoiceDao invoicedao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpadateServerlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    public void init() throws ServletException{
		invoicedao = new InvoiceDaoImpl(); 
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Access-Control-Allow-Origin", "http://localhost:3000/http://localhost:3000/"); // Replace "*" with the actual client URL or restrict it to specific origins
        response.setHeader("Access-Control-Allow-Methods", "POST, OPTIONS"); // Include the allowed methods
        response.setHeader("Access-Control-Allow-Headers","application/json"); // Include the allowed headers
        int v = 0;
		response.setContentType("application/json");
		 //response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
    	PrintWriter out = response.getWriter();
    	Gson gson = new Gson();
    	String s = "";
    	String jsonresponse = new String();
		String sl =  request.getParameter("Sl");
		String dc =  request.getParameter("Dc");
		String cc = request.getParameter("Cc");
		String oc = request.getParameter("Oc");
		try {
			v = invoicedao.update(oc,dc,Integer.parseInt(cc),Integer.parseInt(sl)); 
			//v = invoicedao.insertInvoice(Integer.parseInt(sl),Integer.parseInt(cno),Integer.parseInt(so),dc,div,rsv,pot,cc,ocd,oct,cca,sop,oa,rdd,oc,cs,cn,aiu,uui); 
    		if (v >= 0)
    		{
    			s = "SUCCESSFULLY EDITED!";
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


