package imqa.dashboard.runner;

import imqa.dashboard.dao.MetricDao;
import imqa.dashboard.vo.ScenarioVo;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class AlertAction implements SeleniumAction{


    MetricDao dao;

    AlertAction(MetricDao dao) {
        this.dao = dao;
    }

    @Override
    public void run(WebDriver driver, ScenarioVo scenario) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        Alert alert = driver.switchTo().alert();
//        alert.accept();
        try {
            Alert alert1 = driver.switchTo().alert();
            alert1.accept();
        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }
        Thread.sleep(3000);
    }
}
