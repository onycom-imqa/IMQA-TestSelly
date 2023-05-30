package imqa.dashboard.runner;

import imqa.dashboard.dao.MetricDao;
import imqa.dashboard.vo.ScenarioVo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class HitMapClassNameAction implements SeleniumAction {


    MetricDao dao;

    HitMapClassNameAction(MetricDao dao) {
        this.dao = dao;
    }

    @Override
    public void run(WebDriver driver, ScenarioVo scenario) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement HitMapConfirm = driver.findElement(By.xpath(dao.findByElement(scenario).getCssSelect()));
        HitMapConfirm.getText();
 //xpathExpression 위치에  (By.cssSelector(dao.findByElement(scenario).getCssSelect()));
    }
}
