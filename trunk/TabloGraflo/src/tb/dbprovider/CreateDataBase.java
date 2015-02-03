package tb.dbprovider;

import java.sql.*;

import javax.swing.JOptionPane;
 /**
  * 
  * @author Roman
  *
  */
final class CreateDataBase {
	
	static Statement stmt;	  
	static String sql;
	
	public static void creatDB( Connection c )
	  {
		stmt=null;
	    try {
	      stmt = c.createStatement();
	      sql = "CREATE TABLE [graph] ("
	      		  + "[ID] INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
	      		  + "[ID_HUMENS] INTEGER NOT NULL,"
	      		  + "[ID_REGULATIONS] INTEGER NOT NULL,"
	      		  + "[1start] TEXT, "
	      		  + "[1end] TEXT, "
	      		  + "[2start] TEXT,"
	      		  + "[2end] TEXT, "
	      		  + "[3start] TEXT, "
	      		  + "[3end] TEXT, "
	      		  + "[4start] TEXT,"
	      		  + "[4end] TEXT, "
	      		  + "[5start] TEXT,"
	      		  + "[5end] TEXT, "
	      		  + "[6start] TEXT,"
	      		  + "[6end] TEXT, "
	      		  + "[7start] TEXT,"
	      		  + "[7end] TEXT, "
	      		  + "[8start] TEXT,"
	      		  + "[8end] TEXT, "
	    		  + "[9start] TEXT,"
	    		  + "[9end] TEXT, "
	    		  + "[10start] TEXT,"
	    		  + "[10end] TEXT, "
	    		  + "[11start] TEXT,"
	    		  + "[11end] TEXT, "
	    		  + "[12start] TEXT,"
	    		  + "[12end] TEXT, "
	    		  + "[13start] TEXT,"
	    		  + "[13end] TEXT, "
	    		  + "[14start] TEXT,"
	    		  + "[14end] TEXT, "
	    		  + "[15start] TEXT,"
	    		  + "[15end] TEXT, "
	    		  + "[16start] TEXT,"
	    		  + "[16end] TEXT, "
	    		  + "[17start] TEXT,"
	    		  + "[17end] TEXT, "
	    		  + "[18start] TEXT,"
	    		  + "[18end] TEXT, "
	    		  + "[19start] TEXT,"
	    		  + "[19end] TEXT, "
	    		  + "[20start] TEXT,"
	    		  + "[20end] TEXT, "
	    		  + "[21start] TEXT,"
	    		  + "[21end] TEXT, "
	    		  + "[22start] TEXT,"
	    		  + "[22end] TEXT, "
	    		  + "[23start] TEXT,"
	    		  + "[23end] TEXT, "
	    		  + "[24start] TEXT,"
	    		  + "[24end] TEXT, "
	    		  + "[25start] TEXT,"
	    		  + "[25end] TEXT, "
	    		  + "[26start] TEXT,"
	    		  + "[26end] TEXT, "
	    		  + "[27start] TEXT,"
	    		  + "[27end] TEXT, "
	    		  + "[28start] TEXT,"
	    		  + "[28end] TEXT, "
	    		  + "[29start] TEXT,"
	    		  + "[29end] TEXT, "
	    		  + "[30start] TEXT,"
	    		  + "[30end] TEXT, "
	    		  + "[31start] TEXT,"
	    		  + "[31end] TEXT)"; 
	      stmt.executeUpdate(sql);
	      
	      sql = "CREATE TABLE [regulations] ("
	      		+ "[ID] INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
	      		+ "[YEAR] NUMERIC(4) NOT NULL,"
	      		+ "[MOON] NUMERIC(2) NOT NULL,"
	      		+ "[KKD] INTEGER,"
	      		+ "[KSD] INTEGER,"
	      		+ "[KVD] INTEGER,"
	      		+ "[KND] INTEGER,"
	      		+ "[KRD] INTEGER,"
	      		+ "[KPRD] INTEGER)";
	      stmt.executeUpdate(sql);
	      
	      sql = "CREATE TABLE [holidays] ("
	      		+ "[ID] INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
	      		+ "[ID_REGULATION] INTEGER NOT NULL CONSTRAINT [KEY_HOL_REG] REFERENCES [regulations]([ID]),"
	      		+ "[HOLIDAY] INTEGER)";
	      stmt.executeUpdate(sql);
	      
	      sql = "CREATE TABLE [time] ("
	      		+ "[ID] INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
	      		+ "[NAME] TEXT NOT NULL)";
	      stmt.executeUpdate(sql);
	      
	      sql = "CREATE TABLE [humans] ("
	      		+ "[id] integer NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,"
	      		+ "[lastname] text NOT NULL,"
	      		+ "[name] text NOT NULL,"
	      		+ "[fathersname] text NOT NULL,"
	      		+ "[position] text NOT NULL,"
	      		+ "[tablenumber] integer,"
	      		+ "[percent] REAL DEFAULT 1,"
	      		+ "[sex] TEXT,"
	      		+ "[ID_TIME] INTEGER CONSTRAINT [KEY_TIME] REFERENCES [time]([ID]))";
	      stmt.executeUpdate(sql);
	      
	      sql = "CREATE TABLE [preholidays] ("
	      		+ "[ID] INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
	      		+ "[ID_REGULATIONS] INTEGER NOT NULL CONSTRAINT [KEY_PREHOL_REG] REFERENCES [regulations]([ID]),"
	      		+ "[PREHOLIDAY] INTEGER)";
	      stmt.executeUpdate(sql);
	      
	      sql = "CREATE TABLE [regulationstime] ("
	      		+ "[ID] INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
	      		+ "[YEAR] NUMERIC(4) NOT NULL,"
	      		+ "[ID_TIME] INTEGER NOT NULL CONSTRAINT [KEY_TIME_REG] REFERENCES [time]([ID]),"
	      		+ "[JANUARY] REAL,"
	      		+ "[FEBRUARY] REAL,"
	      		+ "[MARCH] REAL,"
	      		+ "[APRIL] REAL,"
	      		+ "[MAY] REAL,"
	      		+ "[JUNE] REAL,"
	      		+ "[JULY] REAL,"
	      		+ "[AUGUST] REAL,"
	      		+ "[SEPTEMBER] REAL,"
	      		+ "[OCTOBER] REAL,"
	      		+ "[NOVEMBER] REAL,"
	      		+ "[DECEMBER] REAL)";
	      stmt.executeUpdate(sql);
	      
	      sql = "CREATE UNIQUE INDEX [TIMEPLUSYEAR] ON [regulationstime] ([ID] ASC, [YEAR] ASC)";
	      stmt.executeUpdate(sql);
	      
	      sql = "CREATE TABLE [tabel] ("
	      		  + "[ID] INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
	      		  + "[ID_HUMENS] INTEGER NOT NULL,"
	      		  + "[ID_REGULATIONS] INTEGER NOT NULL,"
	      		  + "[1] TEXT, "
	      		  + "[2] TEXT, "
	      		  + "[3] TEXT, "
	      		  + "[4] TEXT, "
	      		  + "[5] TEXT, "
	      		  + "[6] TEXT, "
	      		  + "[7] TEXT, "
	      		  + "[8] TEXT, "
	    		  + "[9] TEXT, "
	    		  + "[10] TEXT, "
	    		  + "[11] TEXT, "
	    		  + "[12] TEXT, "
	    		  + "[13] TEXT, "
	    		  + "[14] TEXT, "
	    		  + "[15] TEXT, "
	    		  + "[16] TEXT, "
	    		  + "[17] TEXT, "
	    		  + "[18] TEXT, "
	    		  + "[19] TEXT, "
	    		  + "[20] TEXT, "
	    		  + "[21] TEXT, "
	    		  + "[22] TEXT, "
	    		  + "[23] TEXT, "
	    		  + "[24] TEXT, "
	    		  + "[25] TEXT, "
	    		  + "[26] TEXT, "
	    		  + "[27] TEXT, "
	    		  + "[28] TEXT, "
	    		  + "[29] TEXT, "
	    		  + "[30] TEXT, "
	    		  + "[31] TEXT) "; 
	      stmt.executeUpdate(sql);    
	      
	      stmt.close();
	      c.close();
	    } catch ( Exception e ) {
	      JOptionPane.showMessageDialog(null, e.getClass().getName() + ": " + e.getMessage());
	      System.exit(0);
	    }
	    
	    JOptionPane.showMessageDialog(null, "DataBase created successfully");
	  }
}
