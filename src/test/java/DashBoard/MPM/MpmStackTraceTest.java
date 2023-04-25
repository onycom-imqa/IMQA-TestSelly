package DashBoard.MPM;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.fail;

@DisplayName("리버스 스택 조회")
public class MpmStackTraceTest {


    private WebDriver driver;

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        }catch (NoSuchElementException e) {
            return false;
        }
    }

    public MpmStackTraceTest() {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
//        option.addArguments("headless");
        driver = new ChromeDriver(option);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://account.imqa.io/user/login");

    }

    @Test
    @DisplayName("네이티브 화면 로딩시간")
    public void run() throws InterruptedException {

        WebElement idField = driver.findElement(By.cssSelector("html > body > div > div > div > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(2) > form > div:nth-of-type(1) > div:nth-of-type(1) > input"));
        idField.sendKeys("devload@naver.com");
        //devload@naver.com

        WebElement passwordField = driver.findElement(By.cssSelector("html > body > div > div > div > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(2) > form > div:nth-of-type(2) > div:nth-of-type(1) > input"));
        passwordField.sendKeys("sh583582!23$");


        WebElement loginButton = driver.findElement(By.cssSelector("button[class='submit']"));
        loginButton.click();


        WebElement MoreProjectsButton = driver.findElement(By.cssSelector("button[class='more-btn']"));
        MoreProjectsButton.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement TestMpm = driver.findElement(By.cssSelector("html > body > div:nth-of-type(1) > div > div:nth-of-type(3) > div:nth-of-type(2) > table > tbody > tr:nth-of-type(39) > td:nth-of-type(2)"));
        TestMpm.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement goStatic = driver.findElement(By.cssSelector("html > body > div > div > header > div:nth-of-type(2) > div > ul > div:nth-of-type(4) > li"));
        goStatic.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement goDistributionAnalysis = driver.findElement(By.cssSelector("html > body > div > div > header > div:nth-of-type(2) > div > ul > div:nth-of-type(4) > li > ul > li:nth-of-type(1) > a > span"));
        goDistributionAnalysis.click();

        WebElement AppVerDropBox = driver.findElement(By.cssSelector("button[class='dropdown-btn']"));
        AppVerDropBox.click();

        WebElement SelectAppVerSecond = driver.findElement(By.cssSelector("html > body > div > div > div:nth-of-type(1) > div:nth-of-type(1) > div > div > div:nth-of-type(1) > div > div:nth-of-type(2) > button:nth-of-type(2)"));
        SelectAppVerSecond.click();



        WebElement AnalysisDatePicker = driver.findElement(By.cssSelector("div[class='date-info'] span"));
        AnalysisDatePicker.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement SelectDate = driver.findElement(By.cssSelector("html > body > div > div > div:nth-of-type(1) > div:nth-of-type(1) > div > div > div:nth-of-type(2) > div > div:nth-of-type(1) > div:nth-of-type(2) > div > div:nth-of-type(2) > div > span:nth-of-type(34)"));
        SelectDate.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Select Date");
        Thread.sleep(4000);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement TimeLine15_16_pixel = driver.findElement(By.cssSelector("rect[data-index='31']"));
        TimeLine15_16_pixel.click();
        System.out.println("111");
        Thread.sleep(4000);



        WebElement P95Graph = driver.findElement(By.cssSelector("rect[class*='p95']"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        P95Graph.click();
        System.out.println("11122");



        WebElement Native_UI_Rendering_Time_pixel = driver.findElement(By.cssSelector("rect[data-value='23080']"));
        Native_UI_Rendering_Time_pixel.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        String currentWindowId = driver.getWindowHandle();
        Set<String> allWindow = driver.getWindowHandles();
        if(allWindow.isEmpty()) {
            for (String windowId : allWindow) {
                driver.switchTo().window(windowId);
                if (driver.getPageSource().contains("데이터가 아직 수집되지 않았거나 데이터가 없습니다.")) {
                    try {System.out.println("스택 데이터가 없습니다.");

                }catch (NoSuchElementException e) {
                        System.out.println("스택 데이터가 있습니다.");
                        e.printStackTrace();
                    }
                }
            }
        }
        driver.switchTo().window(currentWindowId);



        driver.get("https://mpm.imqa.io/mpm/559/statistics/3.1.76/activity/nativeRendering?startDatetime=1682060220000&endDatetime=1682060279000&histogram_type=nativeRendering&startUsage=23080&endUsage=25387");
        Thread.sleep(3000);
        WebElement UI_Thread_Line = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(1) > div:nth-of-type(2) > ul > li:nth-of-type(1) > div > span:nth-of-type(2)"));
        if (isElementPresent(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(1) > div:nth-of-type(2) > ul > li:nth-of-type(1) > div > span:nth-of-type(2)"))){
            WebElement UIThreadCheck = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(1) > div:nth-of-type(2) > ul > li:nth-of-type(1) > div > span:nth-of-type(2)"));
            if (UIThreadCheck.isDisplayed())
            System.out.println("리버스 스택 데이터가 있습니다.");
        }else {
            fail("리버스 스택 데이터가 없습니다.");
        }
        UI_Thread_Line.getText();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement Non_Ui_Thread = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(2) > ul > li:nth-of-type(1) > div > span:nth-of-type(2)"));
        if (isElementPresent(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(2) > ul > li:nth-of-type(1) > div > span:nth-of-type(2)"))){
            WebElement NonUiThreadCheck = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(2) > ul > li:nth-of-type(1) > div > span:nth-of-type(2)"));
            if (NonUiThreadCheck.isDisplayed())
                System.out.println("리버스 스택 데이터가 있습니다.");
        }else {
            fail("리버스 스택 데이터가 없습니다.");
        }
        Non_Ui_Thread.getText();
    }
}
