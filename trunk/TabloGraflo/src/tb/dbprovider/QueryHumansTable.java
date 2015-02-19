//Клас що відповідає за SELECT таблиць із БД
package tb.dbprovider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import tb.dbaseclasses.DbTime;
import tb.properties.userProperties;

public class QueryHumansTable {
	
	private static Connection c;
	private static Statement stmt;
	public String[] namefields;
	public String[] timefields;
	public Object[][] listDBH;
	public ArrayList<DbTime> listDBT;
	
	//Метод вибірка даних із таблиці Humans повертає значення у вигляді ArrayList
	public  Object[][] queryDbHumans() throws SQLException, ClassNotFoundException{		
		c = null;
	    stmt = null;
	    int rsSize=0;
	    userProperties up = new userProperties();
	    try {
	        Class.forName("org.sqlite.JDBC");
	        c = DriverManager.getConnection(up.getConStr());
	        c.setAutoCommit(false);
	        
	        stmt = c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
	        
	        ResultSet rs = stmt.executeQuery("SELECT HUMANS.[id] AS \"#\","
	        		+ "HUMANS.[lastname] AS \"ПРІЗВИЩЕ\","
	        		+ "HUMANS.[name] AS \"ІМ'Я\","
	        		+ "HUMANS.[fathersname] AS \"ПО-БАТЬКОВІ\","
	        		+ "HUMANS.[position] AS \"ПОСАДА\","
	        		+ "HUMANS.[tablenumber] AS \"ТН\","
	        		+ "HUMANS.[percent] AS \"%\","
	        		+ "HUMANS.[sex] AS \"СТАТЬ\","
	        		+ "HUMANS.[IDTIME] AS \"РГ\","
	        		+ "TIME.[NAME] AS \"ГРАФІК\""
	        		+ "FROM HUMANS LEFT JOIN TIME "
	        		+ "ON HUMANS.IDTIME=TIME.ID ORDER BY HUMANS.[id]");
	        
	        
	        ResultSetMetaData rsmd = rs.getMetaData();
	        
	        namefields = new String[rsmd.getColumnCount()];
	        for (int i = 0; i < namefields.length; i++) {
				namefields[i]=rsmd.getColumnName(i+1);
			}	
	        
	        if (rs != null) {
	            rs.last();
	            rsSize = rs.getRow();
	            rs.beforeFirst();
	        }
	        
	        listDBH = new Object[rsSize][namefields.length];
	        
	        while(rs.next()){
	        	for (int i = 0; i < rsSize; i++){
	        		for (int j = 0; j < namefields.length; j++) {
	        			switch (rsmd.getColumnType(j+1)) {
						case Types.INTEGER:
							listDBH[i][j]=rs.getInt(j+1);
							break;
						case Types.VARCHAR:
							listDBH[i][j]=rs.getString(j+1);
							break;
						case Types.REAL:
							listDBH[i][j]=rs.getFloat(j+1);
							break;
						case Types.NUMERIC:
							listDBH[i][j]=rs.getFloat(j+1);
							break;													
						default:
							break;
						}
	        		}
	        	}	        	
	        }	        	        
	        
	        rs.close();
	        stmt.close();
	        c.close();
	        
	      } catch ( Exception e ) {
	        JOptionPane.showMessageDialog(null,e.getClass().getName() + ": " + e.getMessage() );
	      }
		return listDBH;
		
	}
	
	//Метод вибірка даних із таблиці Time повертає значення у вигляді ArrayList
	public void queryDbTime() throws SQLException, ClassNotFoundException{
		listDBT = new ArrayList<DbTime>();
		c = null;
	    stmt = null;
	    userProperties up = new userProperties();
	    try {
	        Class.forName("org.sqlite.JDBC");
	        c = DriverManager.getConnection(up.getConStr());
	        c.setAutoCommit(false);
	        
	        stmt = c.createStatement();
	        
	        ResultSet rs = stmt.executeQuery("select * from time order by name");
	        
	        while(rs.next()){
	        	DbTime dbt = new DbTime();
	        	dbt.setId(rs.getInt(1));
	        	dbt.setName(rs.getString(2));
	        	listDBT.add(dbt);
	        }
	        timefields = new String[listDBT.size()];      
	        for (int i = 0; i < listDBT.size(); i++) {
				timefields[i]=listDBT.get(i).getName();
			}				
	        
	        
	        rs.close();
	        stmt.close();
	        c.close();
	      } catch ( Exception e ) {
	        JOptionPane.showMessageDialog(null,e.getClass().getName() + ": " + e.getMessage() );
	      }
	}
	
		  public static void queryDelete(String table,String id )
		  {	    
		    userProperties up = new userProperties();
			c = null;
		    stmt = null;
		    try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection(up.getConStr());
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      String sql = "DELETE from "+table+" where ID="+id+";";
		      stmt.executeUpdate(sql);	
		      c.commit();
			  stmt.close();
			  c.close();		      
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
