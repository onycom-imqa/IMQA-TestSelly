package imqa.dashboard.dao;

import imqa.dashboard.excelread.PoiReadExcel;
import imqa.dashboard.vo.ScenarioVo;

import java.io.File;
import java.util.List;

public class ScenarioDao  extends PoiReadExcel<ScenarioVo> {

    public ScenarioDao(File excelFile) {
        super(excelFile);
    }

    @Override
    public ScenarioVo marshalling(List<String> cellList) {


        ScenarioVo result = new ScenarioVo();
        result.setScreen(cellList.get(0));
        result.setElement(cellList.get(1));
        result.setActionName(cellList.get(2));
        result.setParams(cellList.get(3));

        return result;
    }

    @Override
    public int maxCellIndex() {
        return 3;
    }
}
