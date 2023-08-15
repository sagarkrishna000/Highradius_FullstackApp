package com.highradius.servlets;
import javax.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.highradius.implementation.InvoiceDao;
import com.highradius.implementation.InvoiceDaoImpl;
import com.highradius.model.Invoice;

/**
 * Servlet implementation class AddServerlet
 */
@WebServlet("/AddServerlet")
public class AddServerlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private InvoiceDao invoicedao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServerlet() {
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
		String cno =  request.getParameter("Cno");
		String so =  request.getParameter("So");
		String dc =  request.getParameter("Dc");
//		String div =  request.getParameter("Div");
//		Double rsv =  Double.parseDouble(request.getParameter("Rsv"));
//		String pot =  request.getParameter("Pot");
		String cc = request.getParameter("Cc");
		String ocd = request.getParameter("Ocd");
//		String oct = request.getParameter("Oct");
//		String cca = request.getParameter("Cca");
//		Integer sop = Integer.parseInt(request.getParameter("Sop"));
		String oa = request.getParameter("Oa");
//		String rdd = request.getParameter("Rdd");
		String oc = request.getParameter("Oc");
//		String cs = request.getParameter("Cs");
		String cn = request.getParameter("Cn");
		String aiu = request.getParameter("Aiu");
//		Long uui = Long.getLong(request.getParameter("Uui"));
		//String sno =  request.getParameter("Sno");
		//Double.parseDouble(oa)double ds = Double.parseDouble(oa);
		try {
			v = invoicedao.insertInvoice_1(Integer.parseInt(sl),Integer.parseInt(cno),Integer.parseInt(so),dc,Integer.parseInt(cc),ocd,Double.parseDouble(oa),Double.parseDouble(aiu), Integer.parseInt(cn), oc); 
			//v = invoicedao.insertInvoice(Integer.parseInt(sl),Integer.parseInt(cno),Integer.parseInt(so),dc,div,rsv,pot,cc,ocd,oct,cca,sop,oa,rdd,oc,cs,cn,aiu,uui); 
    		if (v >= 0)
    		{
    			s = "SUCCESSFULLY ADDED!";
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
//	@Override
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.setContentType("application/json");
//    	PrintWriter out = response.getWriter();
//    	Gson gson = new Gson();
//    	String jsonresponse = new String();
//    	//String id =  request.getParameter("Limit");
//    	try {
//    		ArrayList<Invoice> userlist = invoicedao.getInvoice(); 
//    		jsonresponse = gson.toJson(userlist);
//    		out.println(jsonresponse);
//    	}catch (Exception e) {
//			// TODO: handle exception
//    		
//    		e.printStackTrace();
//		}
//	}

}
