package imqa.dashboard.runner;

import imqa.dashboard.dao.MetricDao;
import imqa.dashboard.vo.ScenarioVo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ElementDrag implements SeleniumAction {
    private MetricDao dao;

    public ElementDrag(MetricDao dao) {
        this.dao = dao;
    }

    @Override
    public void run(WebDriver driver, ScenarioVo scenario) {
        String[] selectors = scenario.getParams().split(",");
        if (selectors.length >= 2) {
            String startSelector = selectors[0].trim();
            String endSelector = selectors[1].trim();

                WebElement startElement = driver.findElement(By.cssSelector(startSelector));
                WebElement endElement = driver.findElement(By.cssSelector(endSelector));

                Actions builder = new Actions(driver);
                builder.dragAndDrop(startElement, endElement).perform();
            } else {
                System.out.println("드래그못함");
            }

    }


}
