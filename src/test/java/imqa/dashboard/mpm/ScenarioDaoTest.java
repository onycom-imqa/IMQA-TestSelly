package imqa.dashboard.mpm;

import imqa.dashboard.dao.ScenarioDao;
import imqa.dashboard.vo.ScenarioVo;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ScenarioDaoTest {


    @Test
    public void scenarioDao() throws IOException {

        List<ScenarioVo> result = new ScenarioDao(new File("/Users/id_sucheol/Downloads/login.xlsx")).readExcel();

        System.out.println(result);

        Assert.assertNotEquals(result.size(),0);
    }

}