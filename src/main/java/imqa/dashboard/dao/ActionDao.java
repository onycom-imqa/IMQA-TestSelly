package imqa.dashboard.dao;

import imqa.dashboard.excelread.PoiReadExcel;
import imqa.dashboard.vo.ActionVo;

import java.io.File;
import java.util.List;

public class ActionDao extends PoiReadExcel<ActionVo> {

    public ActionDao(File excelFile) {
        super(excelFile);
    }

    @Override
    public ActionVo marshalling(List<String> cellList) {

        ActionVo result = new ActionVo();
        result.setActionName(cellList.get(0));
        result.setActionName(cellList.get(1));
        result.setDesc(cellList.get(2));

        return result;
    }

    @Override
    public int maxCellIndex() {
        return 2;
    }
}
