package imqa.dashboard.runner;

import imqa.dashboard.dao.MetricDao;
import imqa.dashboard.vo.ScenarioVo;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForHeatMapConfirm implements SeleniumAction {

    MetricDao dao;

    ForHeatMapConfirm(MetricDao dao) {
        this.dao = dao;
    }

    @Override
    public void run(WebDriver driver, ScenarioVo scenario) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
//        long ListCellsCount = (Long) js.executeScript("HeatMapList = document.getElementsByClassName('b-table-row-selected table-success'); return ListCells.length");
        long ListCellsCount = (Long) js.executeScript("var ListCells = document.getElementsByClassName('b-table-row-selected table-success'); return ListCells.length");

        WebElement Non_UI_Thread_Parm = driver.findElement(By.className("nodata"));

        Thread.sleep(3000);

        while (Non_UI_Thread_Parm.isDisplayed()) {
           String tableSelector = "html > body > div > div > section > div > div:nth-of-type(1) > div:nth-of-type(2) > table > tbody > tr:nth-of-type(";
                for (long i = 1; i <= ListCellsCount; i++) {
                String elementId = tableSelector + i + ")";
                WebElement elementToClick = driver.findElement(By.cssSelector(elementId));
                if (!Non_UI_Thread_Parm.isDisplayed()) {
                    elementToClick.click();
                    Thread.sleep(300);
                }break;
                }
            }
        }
    }
