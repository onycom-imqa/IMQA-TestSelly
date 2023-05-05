package IMQA.dashboard.ExcelRead;

import IMQA.dashboard.mpm.AlarmPolicy;
import IMQA.dashboard.mpm.ReportAppVer;
import com.common.Const;
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

    private static String fileName;
    private static String filePath;

    public PoiReadExcel(String filePath, String fileName) {
        this.filePath = filePath;
        this.fileName = fileName;
    }

    public PoiReadExcel() {
        this(Const.filePath, Const.fileName);
    }

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



            // 모든 행(row)들을 조회한다.
            int rowIndex = -1;
            for (Row row : sheet) {
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    if (cell.getCellType() == CellType.STRING) {
                        String cellValue = cell.getStringCellValue();
                        rowIndex = row.getRowNum();
                        Cell nameCell = row.getCell(0);
                        registerName = nameCell.getStringCellValue();


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
