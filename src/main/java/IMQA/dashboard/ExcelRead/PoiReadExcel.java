package IMQA.dashboard.ExcelRead;

import IMQA.dashboard.mpm.AlarmPolicy;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;


public class PoiReadExcel extends IPoiReadExcel {

    private static AlarmPolicy alarmPolicy = new AlarmPolicy();
    public static String registerName;

    public String filePath = "/Users/id_sucheol/Downloads";
    public String fileName = "teste.xlsx";

    public static void main(String[] args) {

        try {
            FileInputStream file = new FileInputStream("/Users/id_sucheol/Downloads/teste.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            int rowindex=0;
            int columnindex=0;

            XSSFSheet sheet=workbook.getSheetAt(0);
            int rows=sheet.getPhysicalNumberOfRows();
            for(rowindex=1;rowindex<rows;rowindex++) {
                XSSFRow row = sheet.getRow(rowindex);
                if (row != null) {
                    XSSFCell cell = row.getCell(0);
                    String value = "";
                    if (cell == null) {
                    } else {
                        switch (cell.getCellType()) {
                            case FORMULA:
                                value = cell.getCellFormula();
                                break;
                            case NUMERIC:
                                value = cell.getNumericCellValue() + "";
                                break;
                            case STRING:
                                value = cell.getStringCellValue() + "";
                                break;
                            case BLANK:
                                value = cell.getBooleanCellValue() + "";
                                break;
                            case ERROR:
                                value = cell.getErrorCellValue() + "";
                                break;
                        }
                        boolean result = true;
                            //타입별로 내용 읽기
                            switch (value) {
                                case "알림정책-01":
                                    AlarmPolicy.AlarmPolicy1();
                                    break;
                                case "알림정책-02":
                                    AlarmPolicy.AlarmPolicy2();
                                    break;
                                case "알림정책-03":
                                    AlarmPolicy.AlarmPolicy3();
                                    break;
                                case "알림정책-04":
                                    AlarmPolicy.AlarmPolicy4();
                                    break;
                                case "알림정책-05":
                                    AlarmPolicy.AlarmPolicy5();
                                    break;
                                case "알림정책-06":
                                    AlarmPolicy.AlarmPolicy6();
                                    break;
                                case "알림정책-07":
                                    AlarmPolicy.AlarmPolicy7();
                                    break;
                            }
                            if(result == true){
                                value += "::: suucess";
                                System.out.println(value);
                            } else{
                                value += "::: failed";
                                System.out.println(value);
                            }
                        }
                    }
                }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Map<String, String>> readExcel(String fileName) {
        return null;
    }

    public void readExcelFile()throws IOException {

    }

    public String getRegisterName () {
        return registerName;
    }
}
