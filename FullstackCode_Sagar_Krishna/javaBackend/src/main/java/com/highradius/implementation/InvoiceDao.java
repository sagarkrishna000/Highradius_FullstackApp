package com.highradius.implementation;
import com.highradius.model.*;
import java.sql.SQLException;
import java.util.*;
import com.highradius.model.Invoice;
public interface InvoiceDao {
	public ArrayList<Invoice> getInvoice(int limit) throws ClassNotFoundException,SQLException;
	public int insertInvoice(Integer sl,Integer cno,Integer so,String dc,String div,Double rsv,String pot,Integer cc,String ocd,String oct,String cca,Integer sop,Double oa,String rdd,String oc,String cs,Integer cn,Double aiu,Long uui)throws SQLException;
    //public int updateInvoice(Integer id);
	public int insertInvoice_1(Integer sl,Integer cno,Integer so,String dc,Integer cc,String ocd,Double oa,Double aiu, Integer cn, String oc) throws SQLException;
    public int deleteInvoice(Integer id) throws SQLException;
    public ArrayList<Invoice> getInvoice() throws ClassNotFoundException,SQLException;
    public int update(String oc,String dc, Integer cc, Integer Sl) throws ClassNotFoundException,SQLException;

}
