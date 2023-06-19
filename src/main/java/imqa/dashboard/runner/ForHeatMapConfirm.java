package imqa.dashboard.runner;

import imqa.dashboard.dao.MetricDao;
import imqa.dashboard.vo.MetricVo;
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
        MetricVo metric = dao.findByElement(scenario);
        if (metric == null) {
            // Null 값을 처리하는 예외 처리 로직을 추가합니다.
            // 예: 로그를 출력하고 메소드 실행을 중단하거나, 다른 대체 작업을 수행합니다.
            System.out.println("Metric is null for the given scenario.");
            return;
        }
        WebElement elementConfirm = driver.findElement(By.cssSelector(metric.getCssSelect()));
        WebElement clickAction = driver.findElement(By.cssSelector(metric.getCssSelect()));

        String A = elementConfirm.getText();

        JavascriptExecutor js = (JavascriptExecutor) driver;
//        String Title = (String) js.executeScript("return document.title");

        long ListCellsCount = (Long) js.executeScript("HeatMapList = document.getElementsByName('content-detail-table'); return ListCells.length");
        for (int i = 0; i < ListCellsCount;) {
            clickAction.click();
            elementConfirm.getText();
            js.executeScript("document.getElementsByClassName('expanded_icon').value = argument[0]", "expanded_icon");
            }
        }
    }


