package imqa.dashboard.runner;

import imqa.dashboard.dao.MetricDao;
import imqa.dashboard.vo.ScenarioVo;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForHeatMapConfirm implements SeleniumAction{

    MetricDao dao;

    ForHeatMapConfirm(MetricDao dao) {
        this.dao = dao;
    }

    @Override
    public void run(WebDriver driver, ScenarioVo scenario) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
//        long ListCellsCount = (Long) js.executeScript("HeatMapList = document.getElementsByClassName('b-table-row-selected table-success'); return ListCells.length");
        long ListCellsCount = (Long) js.executeScript("var ListCells = document.getElementsByClassName('b-table-row-selected table-success'); return ListCells.length");

        WebElement Non_UI_Thread_Parm = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(2) > ul > li:nth-of-type(1) > div > span:nth-of-type(2)"));

        while (Non_UI_Thread_Parm.isDisplayed()) {
            for (int i = 1; i <= ListCellsCount; i++) {
                String NativeRenderList = "tr[class$='table-success'] td[aria-colindex='" + i + "']";
                WebElement elementToClick = driver.findElement(By.cssSelector(NativeRenderList));
                elementToClick.click();
            }
        }
    }
}




