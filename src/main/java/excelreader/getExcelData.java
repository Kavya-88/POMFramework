package excelreader;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

public class getExcelData extends ReadExcelSheet {
	public static WebDriver driver;
    public static Object[][] LoginData;
    public static XSSFRow Row;
    public static XSSFCell cell;
    public static String FilePath = System.getProperty("user.dir") + "\\config\\input.xlsx";
    public static String SheetName = "data";
    public static XSSFSheet Sheet;

    @DataProvider(name = "getLoginData")
    public static Object[][] getLoginData() throws Exception{

        Sheet = DataSheet(FilePath, SheetName);
        int rowCount = Sheet.getLastRowNum();
        int colCount = Sheet.getRow(0).getLastCellNum();
    
        LoginData = new Object[rowCount][colCount];
        for (int rCnt=1; rCnt<=rowCount;rCnt++){
            for (int cCnt=0; cCnt<colCount;cCnt++){
                LoginData[rCnt-1][cCnt] = getCellData(SheetName, rCnt, cCnt);
            }
        }
        return LoginData;
    }

    @SuppressWarnings("deprecation")
	public static String getCellData(String Sheet, int row, int col){
        try {
            int index = WBook.getSheetIndex(Sheet);
            WSheet = WBook.getSheetAt(index);
            Row = WSheet.getRow(row);
            if (Row == null)
            return "";

            cell = Row.getCell(col);
            if (cell == null)
            return "";

            switch (cell.getCellType())
            {
            case  STRING:
            return cell.getStringCellValue();               

            case BOOLEAN:
            return String.valueOf(cell.getBooleanCellValue());          

            case  BLANK:
            return "";      

            case  ERROR:
            return cell.getStringCellValue();           

            case  NUMERIC:
            return String.valueOf(cell.getNumericCellValue());          

            default:
            return "Cell not found";        
            }
        }catch (Exception e) 
        {
            e.printStackTrace();
            return "row " + row + " or column " + col+ " Does not exist in xlsx";
            }

    }
}
