package imqa.dashboard.runner;

import imqa.dashboard.dao.MetricDao;
import imqa.dashboard.vo.ScenarioVo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementConfirm implements SeleniumAction{

    MetricDao dao;

    ElementConfirm(MetricDao dao) {
        this.dao = dao;
    }

    @Override
    public void run(WebDriver driver, ScenarioVo scenario) {
        WebElement ReportNativeLoading = driver.findElement(By.cssSelector(dao.findByElement(scenario).getCssSelect()));
        ReportNativeLoading.isDisplayed();
    }
}
