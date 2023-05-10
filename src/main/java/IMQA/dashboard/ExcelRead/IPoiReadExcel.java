package IMQA.dashboard.ExcelRead;

import java.io.IOException;
import java.util.List;

public interface IPoiReadExcel<V> {
    public List<V> readExcel() throws IOException;



}