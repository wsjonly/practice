import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;


public class ExcelTest {
	public static void main(String[] args) {
		
		File file = new File("isohu_url.csv");
		
		try {
		    POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(file));
		    HSSFWorkbook wb = new HSSFWorkbook(fs);
		    HSSFSheet sheet = wb.getSheetAt(0);
		    HSSFRow row;
		    HSSFCell cell;

		    int rows; // No of rows
		    rows = sheet.getPhysicalNumberOfRows();

		    int cols = 0; // No of columns
		    int tmp = 0;

		    // This trick ensures that we get the data properly even if it doesn't start from first few rows
		    for(int i = 0; i < 10 || i < rows; i++) {
		        row = sheet.getRow(i);
		        if(row != null) {
		            tmp = sheet.getRow(i).getPhysicalNumberOfCells();
		            if(tmp > cols) cols = tmp;
		        }
		    }

		    for(int r = 0; r < rows; r++) {
		        row = sheet.getRow(r);
		        if(row != null) {
		            for(int c = 0; c < cols; c++) {
		                cell = row.getCell((short)c);
		                if(cell != null) {
		                    // Your code here
		                }
		            }
		        }
		    }
		} catch(Exception ioe) {
		    ioe.printStackTrace();
		}
	}
}
