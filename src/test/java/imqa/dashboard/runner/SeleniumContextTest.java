package imqa.dashboard.runner;

import imqa.dashboard.dao.MetricDao;
import imqa.dashboard.dao.ScenarioDao;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class SeleniumContextTest {

    @Test
    public void seleniumTest() throws IOException {

        MetricDao metricDao = new MetricDao(new File("/Users/id_sucheol/Desktop/SellyExcel/MatricListF.xlsx"));

        SeleniumContext context = new SeleniumContext(metricDao);

        ScenarioDao scenarioDao = new ScenarioDao(new File("/Users/id_sucheol/Desktop/SellyExcel/화면카드 상세 시나리오 리스트.xlsx"));

        context.run(scenarioDao.readExcel());

    }

}