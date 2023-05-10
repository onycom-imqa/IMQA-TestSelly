package IMQA.dashboard.ExcelRead;

import IMQA.dashboard.vo.ClassMappingVo;
import IMQA.dashboard.vo.ClassMappingVo2;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class PoiReadExcelTest {

    @Test
    public void poiReadExcelTest() throws IOException {

        List<ClassMappingVo> result = new PoiReadExcel<ClassMappingVo>(new File("/path....")) {
            @Override
            public ClassMappingVo marshalling(List<String> cellList) {

                ClassMappingVo result = new ClassMappingVo();
                result.setRegisterName(cellList.get(0));

                return result;
            }

            @Override
            public int maxCellIndex() {
                return 5;
            }
        }.readExcel();



        List<ClassMappingVo2> result2 = new PoiReadExcel<ClassMappingVo2>(new File("/path....")) {
            @Override
            public ClassMappingVo2 marshalling(List<String> cellList) {

                ClassMappingVo2 result = new ClassMappingVo2();
                result.setRegisterName(cellList.get(1));

                return result;
            }
        }.readExcel();

    }

}