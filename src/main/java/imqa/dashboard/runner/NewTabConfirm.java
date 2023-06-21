package imqa.dashboard.runner;

import imqa.dashboard.dao.MetricDao;
import imqa.dashboard.vo.ScenarioVo;
import org.openqa.selenium.WebDriver;

public class NewTabConfirm implements SeleniumAction {

    MetricDao dao;

    NewTabConfirm(MetricDao dao) {
        this.dao = dao;
    }

    @Override
    public void run(WebDriver driver, ScenarioVo scenario) {
        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String firstTab = driver.getWindowHandles().toArray()[0].toString();
        String lastTab = driver.getWindowHandles().toArray()[driver.getWindowHandles().size() - 1].toString();
        driver.switchTo().window(firstTab);
        driver.close();

        driver.switchTo().window(lastTab);
    }
}
