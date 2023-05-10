package IMQA.dashboard.ExcelRead;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public abstract class PoiReadExcel<V>  implements IPoiReadExcel<V>  {

    File excelFile = null;
    int rowindex=0;
    int cellMaxIndex = 0;


    public PoiReadExcel(File excelFile) {
        this.excelFile = excelFile;
    }

    public PoiReadExcel(File excelFile, int rowindex) {
        this.excelFile = excelFile;
        this.rowindex = rowindex;
    }

    @Override
    public List<V> readExcel() throws IOException {

        List<V> result = new ArrayList<>();

        FileInputStream file = new FileInputStream(excelFile);
        XSSFWorkbook workbook = new XSSFWorkbook(file);

        int columnindex=0;
        //시트 수 (첫번째에만 존재하므로 0을 준다)
        //만약 각 시트를 읽기위해서는 FOR문을 한번더 돌려준다
        XSSFSheet sheet=workbook.getSheetAt(0);
        //행의 수
        int rows=sheet.getPhysicalNumberOfRows();
        for(rowindex=1;rowindex<rows;rowindex++) {
            //행을읽는다
            XSSFRow row = sheet.getRow(rowindex);
            if (row != null) {

                List<String> cellList = new ArrayList<>();
                for(int j = 0;  j <
                        (); j++) {
                    //셀값을 읽어서 cellList에 넣는다
                    cellList.add(getCellValue(row.getCell(j)));
                }
                result.add(marshalling(cellList));
            }

        }

        return result;
    }

    public int maxCellIndex() {
        return 0;
    }

    public abstract V marshalling(List<String> cellList);

    private String getCellValue(XSSFCell cell) {
        String value;
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
        return value;
    }

//    try {
//
}
