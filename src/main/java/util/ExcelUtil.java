package util;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtil {
    public List<String[]> readExcelData(String filePath) {
        List<String[]> data = new ArrayList<>();
        try (FileInputStream file = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(file)) {

            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                // Ensure the row is not empty
                if (row != null) {
                    String action = getCellValueAsString(row.getCell(0));
                    String email = getCellValueAsString(row.getCell(1));
                    String password = getCellValueAsString(row.getCell(2));

                    // Add the row data only if all cells are not null
                    if (action != null && email != null && password != null) {
                        data.add(new String[]{action, email, password});
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    // Helper method to safely get cell value as String
    private String getCellValueAsString(Cell cell) {
        if (cell == null) {
            return null;
        }
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return String.valueOf(cell.getNumericCellValue());
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            default:
                return null;
        }
    }
}
