package imqa.dashboard.runner;

import imqa.dashboard.vo.ScenarioVo;
import org.openqa.selenium.WebDriver;

public interface SeleniumAction {

    public void run(WebDriver driver, ScenarioVo scenario);

}
