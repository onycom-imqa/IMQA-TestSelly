package IMQA.dashboard.ExcelRead;

import IMQA.DashBoard.ExcelRead.PoiReadExcel;
import com.common.Const;

import java.util.List;
import java.util.Map;

public abstract class IPoiReadExcel extends Const {
    public abstract List<Map<String, String>> readExcel(String fileNm);

    public static String filePath;
    public static String fileName;

    public static final IPoiReadExcel excel = new PoiReadExcel();
    public static final List<Map<String,String>> classList = excel.readExcel(fileName);
}