package tb.dbprovider;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import tb.properties.userProperties;
import java.io.File;

/**
 * @author Roman
 *
 */

public class Provider {
	
	private static Connection c;
	private static Statement stmt;
	
	public static void connectToDeBase(String cs)
	  {
	    c = null;
	    userProperties ps = new userProperties();
	    File file = new File(ps.getProperties());
	    
	    
	    if (file.exists()){
	    	try {
	    			Class.forName("org.sqlite.JDBC");
	    			c = DriverManager.getConnection(cs);
	    		} 
	    	catch ( ClassNotFoundException |SQLException e ) {
	    			JOptionPane.showMessageDialog(null, "DataBase not found");
	    			System.exit(0);
	    		} 
	    }	
	    else{
	    	int in =JOptionPane.showConfirmDialog(null, "DataBase is not found. Creat it?",
	    				"To be or not to be?",JOptionPane.YES_NO_OPTION);
	    	if(in==1){
	    		System.exit(0);
	    	}
	    	else{
		    	try {
		    		Class.forName("org.sqlite.JDBC");
		    		c = DriverManager.getConnection(cs);
	    			CreateDataBase.creatDB(c);
	    			c = DriverManager.getConnection(cs);
	    		} 
	    	catch ( ClassNotFoundException |SQLException e ) {
	    			JOptionPane.showMessageDialog(null, "It's ClassNotFoundException or SQLException");
	    			System.exit(0);
	    		} 
	    	}
	    }
	  }
	
	
	public static void closeDeBase() throws SQLException, ClassNotFoundException
	  {
		  c.close();
	  }
	public static void selectDeBase(String tname) throws SQLException, ClassNotFoundException{
	    c = null;
	    stmt = null;
	    userProperties up = new userProperties();
	    try {
	        Class.forName("org.sqlite.JDBC");
	        c = DriverManager.getConnection(up.getConStr());
	        c.setAutoCommit(false);
	        
	        stmt = c.createStatement();
	        ResultSet rs = stmt.executeQuery( "SELECT * FROM"+ tname );
	        rs.close();
	        stmt.close();
	        c.close();
	      } catch ( Exception e ) {
	        JOptionPane.showMessageDialog(null,e.getClass().getName() + ": " + e.getMessage() );
	      }
	}
}
