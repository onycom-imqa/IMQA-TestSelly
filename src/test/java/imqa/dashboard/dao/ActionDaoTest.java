package imqa.dashboard.dao;

import imqa.dashboard.vo.ScenarioVo;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ActionDaoTest {
    @Test
    public void actionDao() throws IOException {

        List<ScenarioVo> result = new ScenarioDao(new File("/Users/id_sucheol/Downloads/ActionList.xlsx")).readExcel();

        System.out.println(result);

        Assert.assertNotEquals(result.size(),0);
    }
}