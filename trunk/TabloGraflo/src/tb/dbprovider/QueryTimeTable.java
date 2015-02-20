//Клас що відповідає за SELECT таблиць із БД
package tb.dbprovider;

	import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import javax.swing.JOptionPane;

import tb.properties.userProperties;

	public class QueryTimeTable {
		
		private static Connection c;
		private static Statement stmt;
		public String[] timefields;
		public Object[][] listDBT;
		
		//Метод вибірка даних із таблиці Time повертає значення у вигляді ArrayList
		public Object[][] queryDbTime() throws SQLException, ClassNotFoundException{		
			c = null;
		    stmt = null;
		    int rsSize=0;
		    userProperties up = new userProperties();
		    try {
		        Class.forName("org.sqlite.JDBC");
		        c = DriverManager.getConnection(up.getConStr());
		        c.setAutoCommit(false);
		        
		        stmt = c.createStatement();
		        
		        ResultSet techrs =stmt.executeQuery("SELECT COUNT() FROM TIME");
		        rsSize = techrs.getInt(1);
		        
		        ResultSet rs = stmt.executeQuery("SELECT ID AS \"#\", "
		        		+ "NAME AS \"ГРАФІК\" FROM TIME ORDER BY NAME");
		        
		        ResultSetMetaData rsmd = rs.getMetaData();
		        
		        
		        timefields = new String[rsmd.getColumnCount()];
		        for (int i = 0; i < timefields.length; i++) {
					timefields[i]=rsmd.getColumnName(i+1);
				}	

		        this.listDBT = new Object[rsSize][timefields.length];
		        int i=0;
		        while(rs.next()){
	        		for (int j = 0; j < timefields.length; j++) {
	        			switch (rsmd.getColumnType(j+1)) {
						case Types.INTEGER:
							listDBT[i][j]=rs.getInt(j+1);
							break;
						case Types.VARCHAR:
							listDBT[i][j]=rs.getString(j+1);
							break;
						case Types.REAL:
							listDBT[i][j]=rs.getFloat(j+1);
							break;
						case Types.NUMERIC:
							listDBT[i][j]=rs.getFloat(j+1);
							break;													
						default:
							break;
						}
	        		}
	        		i++;
		        }

		        
		        rs.close();
		        stmt.close();
		        c.close();
		        
		      } catch ( Exception e ) {
		        JOptionPane.showMessageDialog(null,e.getClass().getName() + ": " + e.getMessage() );
		      }
		    return listDBT;
		}	
}
