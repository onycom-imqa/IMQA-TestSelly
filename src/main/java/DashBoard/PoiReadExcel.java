package DashBoard;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class PoiReadExcel {

    public static String filePath = "/Users/id_sucheol/Downloads";
    public static String fileNm = "ExcelReadTest.xlsx";


    public void readExcelFile() {


        try (FileInputStream file = new FileInputStream(new File(filePath, fileNm))) {

            // 엑셀 파일로 Workbook instance를 생성한다.
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            // workbook의 첫번째 sheet를 가저온다.
            XSSFSheet sheet = workbook.getSheetAt(0);


            // 모든 행(row)들을 조회한다.
            int rowIndex = -1;
            for (Row row : sheet) {
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    if (cell.getCellType() == CellType.STRING) {
                        String cellValue = cell.getStringCellValue();
                        if ("class_name".equals(cellValue)) {
                            rowIndex = row.getRowNum();
                            break;
                        }
                    }
                }
                if (rowIndex != -1) {
                    break;
                }
            }

            if (rowIndex != -1) {
                Row targetRow = sheet.getRow(rowIndex);
                for (Cell cell : targetRow) {
                    if (cell.getCellType() == CellType.STRING) {
                        String cellValue = cell.getStringCellValue();
                        System.out.print(cellValue + "\t");
                    }
                }
            } else {
                System.out.println("Target cell not found.");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

