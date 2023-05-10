package imqa.dashboard.runner;

import imqa.dashboard.dao.MetricDao;
import imqa.dashboard.vo.ScenarioVo;
import org.openqa.selenium.WebDriver;

public class SleepAction implements SeleniumAction{

    @Override
    public void run(WebDriver driver, ScenarioVo scenario) {

        try {
            Thread.sleep(Long.parseLong(scenario.getParams()));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
