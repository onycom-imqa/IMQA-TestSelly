package imqa.dashboard.dao;

import imqa.dashboard.excelread.PoiReadExcel;
import imqa.dashboard.vo.MetricVo;
import imqa.dashboard.vo.ScenarioVo;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class MetricDao extends PoiReadExcel<MetricVo> {

    private List<MetricVo> metricList;

    public MetricDao(File excelFile) throws IOException {
        super(excelFile);

        this.metricList = readExcel();
    }

    @Override
    public MetricVo marshalling(List<String> cellList) {

        MetricVo result = new MetricVo();
        result.setMetricId(cellList.get(0));
        result.setBigScreen(cellList.get(1));
        result.setSmallScreen(cellList.get(2));
        result.setTestTarget(cellList.get(3));
        result.setTestSummary(cellList.get(4));
        result.setCssSelect(cellList.get(5));

        return result;
    }

    @Override
    public int maxCellIndex() {
        return 5;
    }

    public MetricVo findByElement(ScenarioVo scenario) {

        for(MetricVo metric: metricList) {
            if(metric.getSmallScreen().equals(scenario.getScreen()) && metric.getTestTarget().equals(scenario.getElement())) {
                return metric;
            }
        }
        return null;
    }

}
