package tb.dbprovider;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import tb.properties.userProperties;

import java.io.File;

/**З'єднання з БД за наявності файлу БД 
 * інакше створення бази
 * @author Roma
 *
 */

public class Provider {
	
	private static Connection c;
	
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
	
	//Закриття з'єднання
	public static void closeDeBase() throws SQLException, ClassNotFoundException
	  {
		  c.close();
	  }

}
