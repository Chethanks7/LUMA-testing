package framework.util;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtil {

    public static List<String[]> readTestData(
            String filePath ,
            String sheetName) throws IOException {
        List<String[]> data = new ArrayList<>() ;
        FileInputStream inputStream = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheet(sheetName);
        int rowCount = sheet.getPhysicalNumberOfRows() ;
        int colCount =sheet.getRow(0).getPhysicalNumberOfCells();
        for (int i = 1; i < rowCount; i++) {
            Row row = sheet.getRow(i) ;
            String[] rowData = new String[colCount];
            for (int j = 0; j < colCount; j++) {
                Cell cell = row.getCell(j);
                rowData[j] = cell != null ? cell.toString() : "" ;
            }
            data.add(rowData);
        }
    return data ;
    }


}
