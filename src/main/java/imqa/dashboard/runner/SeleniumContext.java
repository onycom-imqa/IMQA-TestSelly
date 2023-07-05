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
        actionMap.put("새창확인", new NewTabConfirm(metricDao));
        actionMap.put("입력", new InputAction(metricDao));
        actionMap.put("대기", new SleepAction());
        actionMap.put("확인", new ElementConfirm(metricDao));
        actionMap.put("히트맵", new HitMapClassNameAction(metricDao));
        actionMap.put("드래그", new ElementDrag(metricDao));
        actionMap.put("히트맵확인", new ForHeatMapConfirm(metricDao));
        actionMap.put("긴대기", new LongSleepAction());
        actionMap.put("프로젝트 설정", new SetTestProject(metricDao));
        actionMap.put("알림확인", new AlertAction(metricDao));
        actionMap.put("비활성화 검증",new InActiveConfirm(metricDao));
        actionMap.put("캐시 새로고침", new RefreshAction());
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
