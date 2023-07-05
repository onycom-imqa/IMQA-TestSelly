package imqa.dashboard.runner;

import imqa.dashboard.vo.ScenarioVo;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class RefreshAction implements SeleniumAction{

    @Override
    public void run(WebDriver driver, ScenarioVo scenario) throws InterruptedException {

        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).sendKeys(Keys.F5).keyUp(Keys.CONTROL).keyUp(Keys.SHIFT).perform();
        System.out.println("캐시 강력 날리기!");
    }
}
