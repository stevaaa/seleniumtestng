package utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import static constants.Constants.TESTDATA_FILEPATH;



public class ReadExcelData {

//    public static void main(String[] args) throws IOException {
//        ReadExcelData readXL = new ReadExcelData();
//        readXL.getData("testLoginWithIncorrectCreds");
//    }

    @DataProvider(name="incorrectCreds")
//    public String[][] getData(Method m) throws IOException {
    public String[][] getData(String excelSheetName) throws IOException {
        File tdf = new File(System.getProperty("user.dir")+TESTDATA_FILEPATH);
        FileInputStream fileInputStream = new FileInputStream(tdf);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheetName = workbook.getSheet(excelSheetName);

        //get total rows count
        int totalRows = sheetName.getLastRowNum();
        //get total cols count
        Row rowCells = sheetName.getRow(0);
        int totalCols = rowCells.getLastCellNum();

        DataFormatter format = new DataFormatter();

        String testData[][] = new String[totalRows][totalCols];

        for(int i=1; i<=totalRows; i++) {
            for(int j=0; j<totalCols; j++) {
                testData[i-1][j] = format.formatCellValue(sheetName.getRow(i).getCell(j));
                System.out.println(testData[i-1][j]);
            }
        }

        return testData;
    }
}
