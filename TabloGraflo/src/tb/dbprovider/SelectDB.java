package tb.dbprovider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import tb.dbaseclasses.DbHumans;
import tb.properties.userProperties;

public class SelectDB {
	
	private static Connection c;
	private static Statement stmt;
	public String[] namefields;
	
	
	public  ArrayList<DbHumans> queryDbHumans() throws SQLException, ClassNotFoundException{
		ArrayList<DbHumans> listDBH = new ArrayList<DbHumans>();
		c = null;
	    stmt = null;
	    userProperties up = new userProperties();
	    try {
	        Class.forName("org.sqlite.JDBC");
	        c = DriverManager.getConnection(up.getConStr());
	        c.setAutoCommit(false);
	        
	        stmt = c.createStatement();
	        
	        ResultSet rs = stmt.executeQuery("SELECT ID AS \"#\","
	        		+ "LASTNAME AS \"ПРІЗВИЩЕ\","
	        		+ "NAME AS \"ІМ'Я\","
	        		+ "FATHERSNAME AS \"ПО-БАТЬКОВІ\","
	        		+ "POSITION AS \"ПОСАДА\","
	        		+ "TABLENUMBER AS \"ТН\","
	        		+ "PERCENT AS \"%\","
	        		+ "SEX AS \"СТАТЬ\","
	        		+ "ID_TIME AS \"ЧГ\" "
	        		+ "FROM HUMANS ORDER BY LASTNAME");
	        ResultSetMetaData rsmd = rs.getMetaData();
	        namefields = new String[rsmd.getColumnCount()];
	        for (int i = 1; i < namefields.length; i++) {
				namefields[i]=rsmd.getColumnName(i);
			}
	        
	        while(rs.next()){
	        	DbHumans dbh = new DbHumans();
	        	dbh.setId(rs.getInt(rsmd.getColumnName(1)));
	        	dbh.setLastname(rs.getString(rsmd.getColumnName(2)));
	        	dbh.setName(rs.getString(rsmd.getColumnName(3)));
	        	dbh.setFathersname(rs.getString(rsmd.getColumnName(4)));
	        	dbh.setPosition(rs.getString(rsmd.getColumnName(5)));
	        	dbh.setTablenumber(rs.getInt(rsmd.getColumnName(6)));
	        	dbh.setPercent(rs.getFloat(rsmd.getColumnName(7)));
	        	dbh.setSex(rs.getString(rsmd.getColumnName(8)));
	        	dbh.setId_time(rs.getInt(rsmd.getColumnName(9)));
	        	listDBH.add(dbh);
	        }
	        
	        rs.close();
	        stmt.close();
	        c.close();
	      } catch ( Exception e ) {
	        JOptionPane.showMessageDialog(null,e.getClass().getName() + ": " + e.getMessage() );
	      }
		return listDBH;
		
	}

}