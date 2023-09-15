package Com.demo.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import com.github.javafaker.Faker;

public class CommonUtility {
	public static WebDriver driver;
	public static FileInputStream fi;
	public static XSSFWorkbook wb;
	public static XSSFSheet sh;
	public static XSSFRow ro;
	public static XSSFRow cell;
	public static String fn;
	public static String ln;
	public static String em;
	public static String ps;
	public static String ps1;
	public static String value;
	public static Properties pro=new Properties();
	public static Faker f1;
	public static String email;
 	static List<String> list=new ArrayList<String>();
 	
 	public static List<String> main() throws IOException
 	{
 		fi=new FileInputStream("src//test//resources//Excel//Book1.xlsx");
 		wb=new XSSFWorkbook(fi);
 	    sh=wb.getSheet("Sheet1"); 
 		
 	    int rows=sh.getLastRowNum()+1;
 		int cell=sh.getRow(0).getLastCellNum();
 		
 		for(int a=1;a<rows;a++)
 		{
 			for(int b=0;b<cell;b++)
 			{
 			    value=sh.getRow(a).getCell(b).getStringCellValue();
 			    list.add(value);
 			}
 			 
 		}
 		    fn=list.get(0);
			System.out.println(fn);
			ln=list.get(1);
			System.out.println(ln);
			em=list.get(2);
			System.out.println(em);
			ps=list.get(3);
			System.out.println(ps);
			ps1=list.get(4);
			System.out.println(ps1);
			
			return list;
 	}
 	

 	public static String getEmail()
 	{
 		f1=new Faker();
 	    email= f1.internet().safeEmailAddress();
 		return email;
 	}

 	public static String[][] getpaymentdata(String file, String sheet) {
 	    String data[][] = null;
 	    try {
 	        fi = new FileInputStream(file);
 	        XSSFWorkbook wb = new XSSFWorkbook(fi);
 	        XSSFSheet sheets = wb.getSheet(sheet);

 	        int totalrows = sheets.getLastRowNum() + 1;
 	        int totalColumns = sheets.getRow(0).getLastCellNum();
 	        data = new String[totalrows-1][totalColumns];

 	        for (int a = 1; a < totalrows; a++) {
 	            for (int b = 0; b < totalColumns; b++) {
 	                data[a-1][b] = sheets.getRow(a).getCell(b).getStringCellValue();
 	            }
 	        }
 	        wb.close();

 	    } catch (FileNotFoundException e) {
 	        e.printStackTrace();
 	    } catch (IOException e) {
 	        e.printStackTrace();
 	    }

 	    return data;
 	}

 	public static void main(String[] args) {
 		
 		    String[][] paymentData = CommonUtility.getpaymentdata("src//test//resources//Excel//Hybrid.xlsx", "Sheet1");

 		    // Check if the data array is not null
 		    if (paymentData != null) {
 		        // Iterate through rows
 		        for (int row = 0; row < paymentData.length; row++) {
 		            // Iterate through columns in each row
 		            for (int col = 0; col < paymentData[row].length; col++) {
 		                // Print the cell value
 		                System.out.print(paymentData[row][col] + "\t"); // Use "\t" for tab separation
 		            }
 		            // Move to the next line after printing all columns in a row
 		            System.out.println();
 		        }
 		    } else {
 		        System.out.println("No data found in the Excel sheet.");
 		    }
 		

 	    
 	}

}
