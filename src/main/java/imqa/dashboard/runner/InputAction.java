package imqa.dashboard.runner;

import imqa.dashboard.dao.MetricDao;
import imqa.dashboard.vo.ScenarioVo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class InputAction implements SeleniumAction{

    MetricDao dao;

    InputAction(MetricDao dao) {
        this.dao = dao;
    }


    @Override
    public void run(WebDriver driver, ScenarioVo scenario) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement inputParams = driver.findElement(By.cssSelector(dao.findByElement(scenario).getCssSelect()));
        inputParams.sendKeys(scenario.getParams());

    }

}
