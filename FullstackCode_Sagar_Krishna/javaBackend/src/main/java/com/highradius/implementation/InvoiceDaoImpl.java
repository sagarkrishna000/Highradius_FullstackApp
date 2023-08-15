package com.highradius.implementation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import com.highradius.model.*;
import com.highradius.connection.DatabaseConnection;
public class InvoiceDaoImpl implements InvoiceDao{
	@Override
    public ArrayList<Invoice> getInvoice(int limit) throws ClassNotFoundException,SQLException {
		String query = null;
		Connection con = DatabaseConnection.connect();
		PreparedStatement p = null;
		ResultSet rs = null;
		ArrayList<Invoice> userList = new ArrayList<>();
		try {
			query = "select Sl_no,CUSTOMER_ORDER_ID,SALES_ORG,DISTRIBUTION_CHANNEL,COMPANY_CODE,ORDER_CREATION_DATE,ORDER_CURRENCY,CUSTOMER_NUMBER,ORDER_AMOUNT,AMOUNT_IN_USD from h2h_oap LIMIT ?;";
			p = con.prepareStatement(query);
			p.setInt(1, limit);
			rs = p.executeQuery();
			
			
			while (rs.next()) {
	    		Invoice value = new Invoice();
	    		//System.out.println();
	    		value.setSlNo(rs.getInt("Sl_no"));
	    		value.setCustomerOrderId(rs.getInt("CUSTOMER_ORDER_ID"));
	    		//System.out.print(value.getCustomerOrderId()+"  ");
	    		value.setSalesOrg(rs.getInt("SALES_ORG"));
	    		//System.out.print(value.getSalesOrg()+"  ");
	    		value.setDistributionChannel(rs.getString("DISTRIBUTION_CHANNEL"));
	    		//System.out.print(value.getDistributionChannel());
	    		value.setCompanyCode(rs.getInt("COMPANY_CODE"));
	    		value.setOrderCreationDate(rs.getString("ORDER_CREATION_DATE"));
	    		value.setOrderAmount(rs.getDouble("ORDER_AMOUNT"));
	    		value.setAmountInUsd(rs.getDouble("AMOUNT_IN_USD"));
	    		value.setCustomerNo(rs.getInt("CUSTOMER_NUMBER"));
	    		value.setOrderCurrency(rs.getString("ORDER_CURRENCY"));
	    		userList.add(value);
	    		//System.out.println();
	    	}
		}catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally {
			try {
				// By closing connection object statement and ResultSet will be closed
				// automatically.
				if (rs != null)
					rs.close();
				if (p != null)
					p.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return userList;
    }
	public ArrayList<Invoice> getInvoice() throws ClassNotFoundException,SQLException {
		String query = null;
		Connection con = DatabaseConnection.connect();
		PreparedStatement p = null;
		ResultSet rs = null;
		ArrayList<Invoice> userList = new ArrayList<>();
		try {
			query = "select Sl_no,CUSTOMER_ORDER_ID,SALES_ORG,DISTRIBUTION_CHANNEL,COMPANY_CODE,ORDER_CREATION_DATE,ORDER_CURRENCY,CUSTOMER_NUMBER,ORDER_AMOUNT,AMOUNT_IN_USD from h2h_oap LIMIT 100000;";
			p = con.prepareStatement(query);
			//p.setInt(1, limit);
			rs = p.executeQuery();
			
			
			while (rs.next()) {
	    		Invoice value = new Invoice();
	    		//System.out.println();
	    		value.setSlNo(rs.getInt("Sl_no"));
	    		value.setCustomerOrderId(rs.getInt("CUSTOMER_ORDER_ID"));
	    		//System.out.print(value.getCustomerOrderId()+"  ");
	    		value.setSalesOrg(rs.getInt("SALES_ORG"));
	    		//System.out.print(value.getSalesOrg()+"  ");
	    		value.setDistributionChannel(rs.getString("DISTRIBUTION_CHANNEL"));
	    		//System.out.print(value.getDistributionChannel());
	    		value.setCompanyCode(rs.getInt("COMPANY_CODE"));
	    		value.setOrderCreationDate(rs.getString("ORDER_CREATION_DATE"));
	    		value.setOrderAmount(rs.getDouble("ORDER_AMOUNT"));
	    		value.setAmountInUsd(rs.getDouble("AMOUNT_IN_USD"));
	    		value.setCustomerNo(rs.getInt("CUSTOMER_NUMBER"));
	    		value.setOrderCurrency(rs.getString("ORDER_CURRENCY"));
	    		userList.add(value);
	    		//System.out.println();
	    	}
		}catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally {
			try {
				// By closing connection object statement and ResultSet will be closed
				// automatically.
				if (rs != null)
					rs.close();
				if (p != null)
					p.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return userList;
    }
    public int insertInvoice(Integer sl,Integer cno,Integer so,String dc,String div,Double rsv,String pot,Integer cc,String ocd,String oct,String cca,Integer sop,Double oa,String rdd,String oc,String cs,Integer cn,Double aiu,Long uui) throws SQLException {
        //dc.addInvoice(invoice);
    	String query = null;
		Connection con = DatabaseConnection.connect();
		PreparedStatement p = null;
		ResultSet rs = null;
		int v = 0;
    	try {
    		query = "INSERT INTO h2h_oap (Sl_no, CUSTOMER_ORDER_ID, SALES_ORG, DISTRIBUTION_CHANNEL) values (?, ?, ?, ?)";
			//query = "INSERT INTO h2h_oap (Sl_no,CUSTOMER_ORDER_ID, SALES_ORG, DISTRIBUTION_CHANNEL, DIVISION, RELEASED_CREDIT_VALUE, PURCHASE_ORDER_TYPE, COMPANY_CODE, ORDER_CREATION_DATE, ORDER_CREATION_TIME, CREDIT_CONTROL_AREA, SOLD_TO_PARTY, ORDER_AMOUNT, REQUESTED_DELIVERY_DATE, ORDER_CURRENCY, CREDIT_STATUS, CUSTOMER_NUMBER, AMOUNT_IN_USD, UNIQUE_CUST_ID) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			p = con.prepareStatement(query);
			p.setInt(1, sl);
			p.setInt(2, cno);
			p.setInt(3, so);
			p.setString(4, dc);
			p.setString(5, div);
			p.setDouble(6, rsv);
			p.setString(7, pot);
			p.setInt(8, cc);
			p.setString(9,ocd);
			p.setString(10, oct);
			p.setString(11,cca);
			p.setInt(12,sop);
			p.setDouble(13,oa);
			p.setString(14,rdd);
			p.setString(15,oc);
			p.setString(16,cs);
			p.setInt(17, cn);
			p.setDouble(18, aiu);
			p.setLong(19, uui);
			//System.out.println(dc);
			v = p.executeUpdate();
    	}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally {
			try {
				// By closing connection object statement and ResultSet will be closed
				// automatically.
				if (rs != null)
					rs.close();
				if (p != null)
					p.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
    	return v;
    }
    public int insertInvoice_1(Integer sl,Integer cno,Integer so,String dc,Integer cc,String ocd,Double oa,Double aiu,Integer cn, String oc) throws SQLException {
        //dc.addInvoice(invoice);
    	String query = null;
		Connection con = DatabaseConnection.connect();
		PreparedStatement p = null;
		ResultSet rs = null;
		int v = 0;
    	try {
    		query = "INSERT INTO h2h_oap (Sl_no, CUSTOMER_ORDER_ID, SALES_ORG, DISTRIBUTION_CHANNEL, COMPANY_CODE, ORDER_CREATION_DATE, ORDER_AMOUNT, AMOUNT_IN_USD, CUSTOMER_NUMBER, ORDER_CURRENCY) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			//query = "INSERT INTO h2h_oap (Sl_no,CUSTOMER_ORDER_ID, SALES_ORG, DISTRIBUTION_CHANNEL, DIVISION, RELEASED_CREDIT_VALUE, PURCHASE_ORDER_TYPE, COMPANY_CODE, ORDER_CREATION_DATE, ORDER_CREATION_TIME, CREDIT_CONTROL_AREA, SOLD_TO_PARTY, ORDER_AMOUNT, REQUESTED_DELIVERY_DATE, ORDER_CURRENCY, CREDIT_STATUS, CUSTOMER_NUMBER, AMOUNT_IN_USD, UNIQUE_CUST_ID) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			p = con.prepareStatement(query);
			p.setInt(1, sl);
			p.setInt(2, cno);
			p.setInt(3, so);
			p.setString(4, dc);
//			p.setString(5, div);
//			p.setDouble(6, rsv);
//			p.setString(7, pot);
			p.setInt(5, cc);
			p.setString(6,ocd);
//			p.setString(10, oct);
//			p.setString(11,cca);
//			p.setInt(12,sop);
			p.setDouble(7,oa);
//			p.setString(14,rdd);
			p.setString(10,oc);
//			p.setString(16,cs);
			p.setInt(9, cn);
     		p.setDouble(8, aiu);
//			p.setLong(19, uui);
			//System.out.println(dc);
			v = p.executeUpdate();
    	}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally {
			try {
				// By closing connection object statement and ResultSet will be closed
				// automatically.
				if (rs != null)
					rs.close();
				if (p != null)
					p.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
    	return v;
    }
	    public int deleteInvoice(Integer id) throws SQLException {
	    	int v= 0;
	    	String query = null;
			Connection con = DatabaseConnection.connect();
			PreparedStatement p = null;
			ResultSet rs = null;
			try {
				query = "delete from h2h_oap where Sl_no = ?;";
				p = con.prepareStatement(query);
				p.setInt(1, id);
				v = p.executeUpdate();
			}catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}finally {
				try {
					// By closing connection object statement and ResultSet will be closed
					// automatically.
					if (rs != null)
						rs.close();
					if (p != null)
						p.close();
					if (con != null)
						con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
	    	return v;
	    }
	    public int update(String oc,String dc, Integer cc, Integer Sl) throws ClassNotFoundException,SQLException
	    {
	    	int v= 0;
	    	String query = null;
			Connection con = DatabaseConnection.connect();
			PreparedStatement p = null;
			ResultSet rs = null;
			try {
				query = "UPDATE h2h_oap SET COMPANY_CODE = ?, DISTRIBUTION_CHANNEL = ?, ORDER_CURRENCY = ? WHERE Sl_no = ?";
				p = con.prepareStatement(query);
				p.setInt(1, cc);
				p.setString(2, dc);
				p.setString(3, oc);
				p.setInt(4, Sl);
				v = p.executeUpdate();
			}catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}finally {
				try {
					// By closing connection object statement and ResultSet will be closed
					// automatically.
					if (rs != null)
						rs.close();
					if (p != null)
						p.close();
					if (con != null)
						con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
	    	return v;
	    }
	    
//	 @Override
//	    public void updateInvoice(int id, Invoice invoice) {
//	    }
}
