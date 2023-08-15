package com.highradius.servlets;
import com.google.gson.Gson;
import com.highradius.implementation.*;
//import com.implementation.InvoiceDao;
import com.highradius.model.Invoice;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/DataLoadingServerlet")
public class DataLoadingServerlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private InvoiceDao invoicedao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DataLoadingServerlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public void init() throws ServletException{
		invoicedao = new InvoiceDaoImpl(); 
	}
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.setContentType("application/json");
//    	PrintWriter out = response.getWriter();
//    	Gson gson = new Gson();
//    	String jsonresponse = new String();
//    	String id =  request.getParameter("Limit");
//    	try {
//    		ArrayList<Invoice> userlist = invoicedao.getInvoice(Integer.parseInt(id)); 
//    		jsonresponse = gson.toJson(userlist);
//    		out.println(jsonresponse);
//    	}catch (Exception e) {
//			// TODO: handle exception
//    		
//    		e.printStackTrace();
//		}
//	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json");
    	PrintWriter out = response.getWriter();
    	Gson gson = new Gson();
    	String jsonresponse = new String();
    	//String id =  request.getParameter("Limit");
    	try {
    		ArrayList<Invoice> userlist = invoicedao.getInvoice(); 
    		jsonresponse = gson.toJson(userlist);
    		out.println(jsonresponse);
    	}catch (Exception e) {
			// TODO: handle exception
    		
    		e.printStackTrace();
		}
	}

	}
