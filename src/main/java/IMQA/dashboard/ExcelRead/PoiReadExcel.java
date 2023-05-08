package IMQA.dashboard.ExcelRead;

import IMQA.dashboard.mpm.AlarmPolicy;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class PoiReadExcel extends IPoiReadExcel {

    private static AlarmPolicy alarmPolicy = new AlarmPolicy();
    public static String registerName;

    public String filePath = "/Users/id_sucheol/Downloads";

    public String fileName = "teste.xlsx";


    public static void main(String[] args) throws Exception {
        System.out.println("Say Run");
        while (true) {
            try {
                new PoiReadExcel().readExcelFile();

            } catch (Exception e) {

            }
        }
    }



    @Override
    public List<Map<String, String>> readExcel(String fileName) {
        return null;
    }


    public void readExcelFile()throws IOException {
        try (FileInputStream file = new FileInputStream(new File(filePath, fileName))) {

            // 엑셀 파일로 Workbook instance를 생성한다.
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            // workbook의 첫번째 sheet를 가저온다.
            XSSFSheet sheet = workbook.getSheetAt(0);


            System.out.println("1step");
            // 모든 행(row)들을 조회한다.
            int rowIndex = -1;
            for (Row row : sheet) {
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    System.out.println("2step");
                    if (cell.getCellType() == CellType.STRING) {
                        String cellValue = cell.getStringCellValue();
                        rowIndex = row.getRowNum();
                        Cell nameCell = row.getCell(0);
                        registerName = nameCell.getStringCellValue();
                        System.out.println("3step");

                        switch (registerName) {
                            case "알림정책-01":
                                alarmPolicy.AddAlarmPolicy();
                                System.out.println("01실행");
                                break;
                            case "알림정책-02":
                                alarmPolicy.ModifyAlarmPolicy();
                                System.out.println("02실행");
                                break;
                            default:
                                throw new IllegalStateException("Unexpected value: " + registerName);
                        }
                        System.out.println("사이클 끝");
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getRegisterName () {
        return registerName;
    }


}
