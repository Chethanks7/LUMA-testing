package framework.util;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtil {

    public static List<String[]> readTestData(String filePath , String sheetName) throws IOException {
        List<String[]> data = new ArrayList<>() ;
        FileInputStream inputStream = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheet(sheetName) ;
        System.out.println(sheet.getSheetName());
        for(Row row : sheet){
            System.out.println(row.getCell(0).getCellComment());
            String[] rowData = new String[row.getFirstCellNum()];
            for (int i = 0; i < row.getFirstCellNum(); i++) {
                Cell cell = row.getCell(i);
                System.out.println(cell.toString());
                rowData[i] = cell!=null ? cell.toString() : "" ;
            }
            data.add(rowData);
        }
        return data ;
    }
}
