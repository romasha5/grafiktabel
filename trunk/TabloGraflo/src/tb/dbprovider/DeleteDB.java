package tb.dbprovider;

import java.sql.*;

import javax.swing.JOptionPane;

import tb.properties.userProperties;

public class DeleteDB {
    static Connection c = null;	
    static Statement stmt = null;
	  public static void queryDelete(String table,String id )
	  {	    
	    userProperties up = new userProperties();
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection(up.getConStr());
	      c.setAutoCommit(false);
	      stmt = c.createStatement();
	      String sql = "DELETE from "+table+" where ID="+id+";";
	      stmt.executeUpdate(sql);	      
	    } catch ( Exception e ) {
	      JOptionPane.showMessageDialog(null,e.getClass().getName() + ": " + e.getMessage() );	      
	    }
	  }
	  
	  public static void commit(){
	    try {
			c.commit();
		    stmt.close();
		    c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	  }
	  
	  public static void rollbac(){
	    try {
			c.rollback();
		    stmt.close();
		    c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	  }

}
