package tb.dbprovider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import tb.dbaseclasses.DbHumans;
import tb.properties.userProperties;

public class SelectDB {
	
	private static Connection c;
	private static Statement stmt;
	
	
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
	        
	        while(rs.next()){
	        	DbHumans dbh = new DbHumans();
	        	dbh.setId(rs.getInt("ID"));
	        	dbh.setLastname(rs.getString("LASTNAME"));
	        	dbh.setName(rs.getString("NAME"));
	        	dbh.setFathersname(rs.getString("FATHERSNAME"));
	        	dbh.setPosition(rs.getString("POSITION"));
	        	dbh.setTablenumber(rs.getInt("TABLENUMBER"));
	        	dbh.setPercent(rs.getFloat("PERCENT"));
	        	dbh.setSex(rs.getString("SEX"));
	        	dbh.setId_time(rs.getInt("ID_TIME"));
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
