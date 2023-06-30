package imqa.dashboard.runner;

import imqa.dashboard.dao.MetricDao;
import imqa.dashboard.dao.ScenarioDao;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class SeleniumContextTest {

    @Test
    public void seleniumTest() throws IOException {

        MetricDao metricDao = new MetricDao(new File("/Users/id_sucheol/Desktop/SellyExcel/MatricList.xlsx"));

        SeleniumContext context = new SeleniumContext(metricDao);

        ScenarioDao scenarioDao = new ScenarioDao(new File("/Users/id_sucheol/Desktop/SellyExcel/WPM 데모.xlsx"));

        context.run(scenarioDao.readExcel());

    }

}