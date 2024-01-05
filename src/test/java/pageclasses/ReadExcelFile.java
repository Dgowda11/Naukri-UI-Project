package pageclasses;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {
   
	public void inputdata() throws IOException{
		
	
	FileInputStream file = new FileInputStream("C:\\Users\\Darshan Gowda\\workspace\\SeleniumPOMFramework\\src\\main\\java\\properties\\naukri.xlsx");
	XSSFWorkbook workbook =new XSSFWorkbook(file);
	XSSFSheet sheet = workbook.getSheet("Sheet1");
	
	int rowcount = sheet.getLastRowNum(); //returns row count
	
    int colcount = sheet.getRow(0).getLastCellNum(); // returns column count 
    
    for(int i=0;i<rowcount;i++){
    	
    	XSSFRow currentrow = sheet.getRow(i);   //focus on current row 
    	
    	for(int j=0;j<colcount;j++){
    		String value = currentrow.getCell(j).toString();   //To read the all valves from the cell
    		System.out.println(value);
    	}
}
	}
}
	
