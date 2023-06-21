package imqa.dashboard.runner;

import imqa.dashboard.dao.MetricDao;
import imqa.dashboard.vo.ScenarioVo;
import org.openqa.selenium.WebDriver;

public class SetTestProject implements SeleniumAction {


    private MetricDao dao;

    public SetTestProject(MetricDao dao) {
        this.dao = dao;
    }


    @Override
    public void run(WebDriver driver, ScenarioVo scenario) throws InterruptedException {
        String[] excelPrm = scenario.getParams().split(",");
        if (excelPrm.length >= 1) {
            String projectURL = excelPrm[0].trim();
            driver.get(projectURL);
        }
    }
}
