package IMQA.dashboard.ExcelRead;

import com.common.Constant;

import java.util.List;
import java.util.Map;

public abstract class IPoiReadExcel extends Constant {
    public abstract List<Map<String, String>> readExcel(String fileNm);

    public static String filePath;
    public static String fileName;

    public static final IPoiReadExcel excel = new IPoiReadExcel() {
        @Override
        public List<Map<String, String>> readExcel(String fileNm) {
            return null;
        }
    };
    public static final List<Map<String,String>> classList = excel.readExcel(fileName);
}