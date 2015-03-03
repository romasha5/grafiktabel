package tb.dbprovider;

import java.io.File;
import java.io.IOException;

import tb.dbaseclasses.DbHumans;
import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ImportXLS {
	  private String inputFile;
	  private DbHumans dbh;
	  public void setInputFile(String inputFile) {
	    this.inputFile = inputFile;
	  }

	  public void read() throws IOException  {
	    File inputWorkbook = new File(inputFile);
	    Workbook w;
	    try {
	      w = Workbook.getWorkbook(inputWorkbook);
	      Sheet sheet = w.getSheet(0);

	        for (int i = 0; i < sheet.getRows(); i++) {
		        	Cell cell = sheet.getCell(0, i);
		          		dbh.setLastname(cell.getContents());
		          		cell = sheet.getCell(1,i);
		          		dbh.setName(cell.getContents());
		          		cell = sheet.getCell(2,i);
		          		dbh.setFathersname(cell.getContents());
		          		cell = sheet.getCell(3,i);
		          		dbh.setPosition(cell.getContents());
		          		cell = sheet.getCell(4,i);
		          		dbh.setTablenumber(Integer.valueOf(cell.getContents()));
		          		cell = sheet.getCell(5,i);
		          		dbh.setPercent(Float.valueOf(cell.getContents()));	
		          		cell = sheet.getCell(6,i);
		          		dbh.setSex(cell.getContents());
		          		cell = sheet.getCell(7,i);
		          		dbh.setTimeId(Integer.valueOf(cell.getContents()));		          		
		  	      }
	        
	    } catch (BiffException e) {
	      e.printStackTrace();
	    }
	  }
}
