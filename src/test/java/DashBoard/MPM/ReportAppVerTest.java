package DashBoard.MPM;

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.fail;
import static org.apache.commons.io.FileUtils.copyFile;

public class ReportAppVerTest {
    private WebDriver driver;

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        }catch (NoSuchElementException e) {
            return false;
        }
    }

    public ReportAppVerTest() {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
//        option.addArguments("headless");
        driver = new ChromeDriver(option);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://account.imqa.io/user/login");

    }

    @Test
    public void main() {
    }

    @Test
    public void run() throws IOException {

        //        앱 버전별 보고서 확인

        driver.get("https://account.imqa.io/user/login");

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


        WebElement goReport = driver.findElement(By.cssSelector("html > body > div > div > header > div:nth-of-type(2) > div > ul > div:nth-of-type(5) > li > a > span"));
        goReport.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //AppVer1 (HY 프레딧 AOS 프로젝트 기준)
        WebElement AppVerDropBox = driver.findElement(By.cssSelector("button[class='version-dropdown-btn']"));
        AppVerDropBox.click();


        WebElement AppVerDroBoxSelect1 = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(1) > div:nth-of-type(3) > div:nth-of-type(2) > ul > li:nth-of-type(1) > button"));
        if (isElementPresent(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(1) > div:nth-of-type(3) > div:nth-of-type(2) > ul > li:nth-of-type(1) > button"))){
            WebElement AppVersionSelect = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(1) > div:nth-of-type(3) > div:nth-of-type(2) > ul > li:nth-of-type(1) > button"));
            if (!AppVersionSelect.isSelected())
            System.out.println("앱 버전 하나를 확인했습니다..");
        }else {
            fail("앱 버전이 없습니다");
        }
        AppVerDroBoxSelect1.click();

        WebElement ReportAppVerApplyButton = driver.findElement(By.cssSelector("button[class='version-apply-btn']"));
        ReportAppVerApplyButton.click();


        WebElement ReportElementConfirm = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(1) > table > tbody > tr > td:nth-of-type(2)"));
        if (isElementPresent(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(1) > table > tbody > tr > td:nth-of-type(2)"))){
            WebElement ReportEle1 = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(1) > table > tbody > tr > td:nth-of-type(2)"));
            if (ReportEle1.isEnabled())
                ReportEle1.getText();

            System.out.println("네이티브 화면 로딩시간 확인");
        }else {
            fail("네이티브 화면 로딩시간 문제 발생");
        }
        ReportElementConfirm.getText();

        WebElement ReportElementConfirm2 = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(2) > table > tbody > tr > td:nth-of-type(2)"));
        if (isElementPresent(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(2) > table > tbody > tr > td:nth-of-type(2)"))){
            WebElement ReportEle2 = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(2) > table > tbody > tr > td:nth-of-type(2)"));
            if (ReportEle2.isEnabled())
                ReportEle2.getText();
            System.out.println("웹뷰 화면 로딩시간 확인");
        }else {
            fail("웹뷰 화면 로딩시간 문제 발생");
        }
        ReportElementConfirm2.getText();


        WebElement ReportElementConfirm3 = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(3) > table > tbody > tr > td:nth-of-type(2)"));
        if (isElementPresent(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(3) > table > tbody > tr > td:nth-of-type(2)"))){
            WebElement ReportEle3 = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(3) > table > tbody > tr > td:nth-of-type(2)"));
            if (ReportEle3.isEnabled())
                ReportEle3.getText();
            System.out.println("응답시간 확인");
        }else {
            fail("응답시간 문제 발생");
        }
        ReportElementConfirm3.getText();


        WebElement ReportElementConfirm4 = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(4) > table > tbody > tr > td:nth-of-type(2)"));
        if (isElementPresent(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(4) > table > tbody > tr > td:nth-of-type(2)"))){
            WebElement ReportEle4 = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(4) > table > tbody > tr > td:nth-of-type(2)"));
            if (ReportEle4.isEnabled())
                ReportEle4.getText();
            System.out.println("CPU 사용량 확인");
        }else {
            fail("CPU 사용량 문제 확인");
        }
        ReportElementConfirm4.getText();

        WebElement ReportElementConfirm5 = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(5) > table > tbody > tr > td:nth-of-type(6)"));
        if (isElementPresent(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(5) > table > tbody > tr > td:nth-of-type(6)"))){
            WebElement ReportEle5 = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(5) > table > tbody > tr > td:nth-of-type(6)"));
            if (ReportEle5.isEnabled())
                ReportEle5.getText();
            System.out.println("메모리 사용량 확인");
        }else {
            fail("메모리 사용량 문제 확인");
        }
        ReportElementConfirm5.getText();



        WebElement ReportFirstPage = driver.findElement(By.cssSelector("div[id='page1'] div[class='report-container']"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        File file=ReportFirstPage.getScreenshotAs(OutputType.FILE);
        copyFile(file, new File("app1logo.png"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);



        WebElement AppVer2DropBox = driver.findElement(By.cssSelector("button[class='version-dropdown-btn']"));
        AppVer2DropBox.click();

        WebElement AppVerDroBoxSelect2 = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(1) > div:nth-of-type(3) > div:nth-of-type(2) > ul > li:nth-of-type(2) > button"));
        if (isElementPresent(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(1) > div:nth-of-type(3) > div:nth-of-type(2) > ul > li:nth-of-type(2) > button"))){
            WebElement AppVersionSelect2 = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(1) > div:nth-of-type(3) > div:nth-of-type(2) > ul > li:nth-of-type(2) > button"));
            if (!AppVersionSelect2.isSelected())
                AppVersionSelect2.click();
            System.out.println("또 다른 앱버전을 확인했습니다..");
        }else {
            fail("두번째 앱 버전이 없습니다");
        }
        AppVerDroBoxSelect2.click();

        WebElement ReportAppVerApplyButton2 = driver.findElement(By.cssSelector("button[class='version-apply-btn']"));
        ReportAppVerApplyButton2.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement ReportFirstPage2 = driver.findElement(By.cssSelector("div[id='page1'] div[class='report-container']"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        File file2 = ReportFirstPage2.getScreenshotAs(OutputType.FILE);
        copyFile(file2, new File("app2logo.png"));

    }
}