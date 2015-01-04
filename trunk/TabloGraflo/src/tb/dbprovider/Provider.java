package tb.dbprovider;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Provider {
	
	private static Connection c;

	public static void connectToDeBase(String cs)
	  {
	    c = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection(cs);
	    } catch ( Exception e ) {
	      JOptionPane.showMessageDialog(null, "Помилка підключення");
	      System.exit(0);
	    }
	    JOptionPane.showMessageDialog(null, "Базу підключено");
	  }
	  
	  public static void closeDeBase() throws SQLException, ClassNotFoundException
	  {
		  c.close();
	  }

}
