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

import tb.dbaseclasses.DbHumans;
import tb.properties.userProperties;

public class QueryHumansTable {
	
	private static Connection c;
	private static Statement stmt;
	public String[] namefields;
	public String[] timefields;
	public Object[][] listDBH;
	public Object[][] listDBT;
	
	//Метод вибірка даних із таблиці Humans повертає значення 
	public  Object[][] queryDbHumans() throws SQLException, ClassNotFoundException{		
		c = null;
	    stmt = null;
	    int rsSize=0;
	    
	    userProperties up = new userProperties();
	    try {
	        Class.forName("org.sqlite.JDBC");
	        c = DriverManager.getConnection(up.getConStr());
	        c.setAutoCommit(false);
	        
	        stmt = c.createStatement();
	        
	        ResultSet techrs =stmt.executeQuery("SELECT COUNT() FROM HUMANS");
	        rsSize = techrs.getInt(1);
	        
	        
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
	        
	        this.listDBH = new Object[rsSize][namefields.length];
	        int i=0;
	        while(rs.next()){
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
	        		i++;
	        }	        	        
	        techrs.close();
	        rs.close();
	        stmt.close();
	        c.close();
	        
	      } catch ( Exception e ) {
	        JOptionPane.showMessageDialog(null,e.getClass().getName() + ": " + e.getMessage() );
	      }
		return listDBH;
		
	}	
	
	public void queryDelete(String table,String id ) throws SQLException
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
			  c.rollback();
			  stmt.close();
			  c.close();
		    }
		  }

	public void queryInsert( DbHumans dbh ) 
	  {
	    Connection c = null;
	    Statement stmt = null;
	    try {
	    	userProperties up = new userProperties();
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection(up.getConStr());
	      c.setAutoCommit(false);
	      stmt = c.createStatement();	     
	      stmt.executeUpdate("INSERT INTO HUMANS (LASTNAME,NAME,FATHERSNAME,POSITION,"
		      		+ "TABLENUMBER,PERCENT,SEX,IDTIME) " +
	                   "VALUES ('"+dbh.getLastname()+"','"+dbh.getName()+
	                   "','"+dbh.getFathersname()+"','"+dbh.getPosition()+
	                   "','"+dbh.getTablenumber()+"','"+dbh.getPercent()+
	                   "','"+dbh.getSex()+"','"+dbh.getTimeId()+ "')");

	      stmt.close();
	      c.commit();
	      c.close();
	    } catch ( Exception e ) {	    		    	
	    	JOptionPane.showMessageDialog(null, e.getClass().getName() + ": " + e.getMessage() );
	    }
	 }
	
	public void queryUpdate( DbHumans dbh )
	  {
	    Connection c = null;
	    Statement stmt = null;
	    try {
	    	userProperties up = new userProperties();
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection(up.getConStr());
	      c.setAutoCommit(false);
	      stmt = c.createStatement();	     
	      stmt.executeUpdate("UPDATE HUMANS SET LASTNAME='"+dbh.getLastname()
	    		+ "',NAME='"+dbh.getName()
	      		+ "',FATHERSNAME='"+dbh.getFathersname()
	      		+ "',POSITION='"+dbh.getPosition()
	      		+ "',TABLENUMBER='"+dbh.getTablenumber()
		      	+ "',PERCENT='"+dbh.getPercent()
		      	+ "',SEX='"+dbh.getSex()
		      	+ "',IDTIME='"+dbh.getTimeId()+"' WHERE ID='"+dbh.getId()+"';");

	      stmt.close();
	      c.commit();
	      c.close();
	    } catch ( Exception e ) {
	    	JOptionPane.showMessageDialog(null, e.getClass().getName() + ": " + e.getMessage() );	      
	    }
	 }
}
