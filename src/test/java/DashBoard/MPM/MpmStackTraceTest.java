package DashBoard.MPM;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.*;

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

//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        WebElement TimeLine15_16 = driver.findElement(By.cssSelector("rect[data-index='31']"));
//        TimeLine15_16.click();

        Thread.sleep(3000);
        WebElement P95Graph = driver.findElement(By.cssSelector("rect[class*='p95']"));
        P95Graph.click();




//            드래그할 Element가 없음
//            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//            WebElement source = driver.findElement(By.cssSelector("html > body > div > div > div:nth-of-type(1) > div:nth-of-type(2) > div > div:nth-of-type(2) > div > div:nth-of-type(1) > div > div:nth-of-type(2) > svg > g:nth-of-type(3) > line:nth-of-type(1)"));
//            WebElement target = driver.findElement(By.cssSelector("html > body > div > div > div:nth-of-type(1) > div:nth-of-type(2) > div > div:nth-of-type(2) > div > div:nth-of-type(1) > div > div:nth-of-type(2) > svg > g:nth-of-type(3) > line:nth-of-type(7)"));
//            Actions DragBuilder = new Actions(driver);
//            DragBuilder.dragAndDrop(source, target).perform();


//프레딧 AOS 2023.04.21 15:30~16:00 중 15:57 픽셀 svg[width='820']
//        WebElement Native_UI_Rendering_Time_pixel = driver.findElement(By.cssSelector("svg[width='820']"));
//        Native_UI_Rendering_Time_pixel.click();

        driver.get("https://mpm.imqa.io/mpm/559/statistics/3.1.76/activity/nativeRendering?startDatetime=1682060220000&endDatetime=1682060279000&histogram_type=nativeRendering&startUsage=23080&endUsage=25387");

        WebElement UI_Thread_Line = driver.findElement(By.cssSelector("li[data-id='6f1c54e1-ab0e-4fa8-9b48-415313e07659'] div[class='row_data']"));
        if (isElementPresent(By.cssSelector("li[data-id='6f1c54e1-ab0e-4fa8-9b48-415313e07659'] div[class='row_data']"))){
            WebElement UIThreadCheck = driver.findElement(By.cssSelector("li[data-id='6f1c54e1-ab0e-4fa8-9b48-415313e07659'] div[class='row_data']"));
            if (UIThreadCheck.isEnabled())
            System.out.println("리버스 스택 데이터가 있습니다.");
        }else {
            fail();
        }
        UI_Thread_Line.getText();

        WebElement Non_Ui_Thread = driver.findElement(By.cssSelector("li[data-id='a84ea6df-d1d7-47be-a196-6143bb8d3581'] div[class='row_data']"));
        if (isElementPresent(By.cssSelector("li[data-id='6f1c54e1-ab0e-4fa8-9b48-415313e07659'] div[class='row_data']"))){
            WebElement NonUiThreadCheck = driver.findElement(By.cssSelector("li[data-id='6f1c54e1-ab0e-4fa8-9b48-415313e07659'] div[class='row_data']"));
            if (NonUiThreadCheck.isEnabled())
                System.out.println("리버스 스택 데이터가 있습니다.");
        }else {
            fail();
        }
        Non_Ui_Thread.getText();
    }
}