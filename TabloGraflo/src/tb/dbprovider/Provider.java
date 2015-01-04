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
	      JOptionPane.showMessageDialog(null, "������� ����������");
	      System.exit(0);
	    }
	    JOptionPane.showMessageDialog(null, "���� ���������");
	  }
	  
	  public static void closeDeBase() throws SQLException, ClassNotFoundException
	  {
		  c.close();
	  }

}
