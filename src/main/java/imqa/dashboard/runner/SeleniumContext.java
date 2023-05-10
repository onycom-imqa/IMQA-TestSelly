package imqa.dashboard.runner;

import imqa.dashboard.dao.MetricDao;
import imqa.dashboard.vo.ScenarioVo;
import org.apache.commons.collections4.map.HashedMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class SeleniumContext {

    private static WebDriver driver;

    private MetricDao metricDao;

    private Map<String, SeleniumAction> actionMap;

    public SeleniumContext(MetricDao dao) {
        this.metricDao = dao;

        setActionMap();

    }

    public void setActionMap() {
        actionMap = new HashedMap<>();
        actionMap.put("클릭", new ClickAction(metricDao));
        actionMap.put("입력", new InputAction(metricDao));
        actionMap.put("대기", new SleepAction());
    }

    public void before() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://account.imqa.io/user/login");
    }

    public void end() {
    }

    public void newDriver() {
        driver = new ChromeDriver(getOption());
    }

    public ChromeOptions getOption() {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        return option;
    }

    public void run(List<ScenarioVo> scenarioList) {
        newDriver();
        before();

        scenarioList.stream().forEach(scenario -> {
            try {
                actionMap.get(scenario.getActionName()).run(driver, scenario);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        end();
    }






}
