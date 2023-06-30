package imqa.dashboard.runner;

import imqa.dashboard.vo.ScenarioVo;
import org.openqa.selenium.WebDriver;

public class LongSleepAction implements SeleniumAction{

    @Override
    public void run(WebDriver driver, ScenarioVo scenario) throws InterruptedException {

        Thread.sleep(10000);
    }
}