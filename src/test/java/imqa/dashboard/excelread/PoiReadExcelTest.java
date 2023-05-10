package imqa.dashboard.excelread;

import imqa.dashboard.vo.MetricVo;
import imqa.dashboard.vo.ScenarioVo;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class PoiReadExcelTest {

    @Test
    public void poiReadExcelTest() throws IOException {

        List<ScenarioVo> result = new PoiReadExcel<ScenarioVo>(new File("/path....")) {
            @Override
            public ScenarioVo marshalling(List<String> cellList) {

                ScenarioVo result = new ScenarioVo();
//                result.setScenarioId(cellList.get(0));

                return result;
            }

            @Override
            public int maxCellIndex() {
                return 5;
            }
        }.readExcel();


        List<MetricVo> result2 = new PoiReadExcel<MetricVo>(new File("/path....")) {
            @Override
            public MetricVo marshalling(List<String> cellList) {

                MetricVo result = new MetricVo();
                result.setMetricId(cellList.get(0));

                return result;
            }
        }.readExcel();



    }

}