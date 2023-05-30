package imqa.dashboard.runner;

import imqa.dashboard.vo.ScenarioVo;
import org.openqa.selenium.WebDriver;

public class SleepAction implements SeleniumAction{

    @Override
    public void run(WebDriver driver, ScenarioVo scenario) throws InterruptedException {

        Thread.sleep(5000);
    }
}
