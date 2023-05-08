package IMQA.dashboard.mpm;


import IMQA.dashboard.ExcelRead.PoiReadExcel;
import com.common.Const;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ReportAppVer {

    private final WebDriver driver;

    private Const aConst;

    public static void main(String[] args) throws Exception {
        System.out.println("Say Run");
        while (true) {
            try {
                new ReportAppVer().run();
            } catch (Exception e) {

            }
        }
    }


    public ReportAppVer() {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
//        option.addArguments("headless");
        driver = new ChromeDriver(option);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://account.imqa.io/user/login");

    }

    public void run() throws Exception {

        PoiReadExcel poiReadExcel = new PoiReadExcel();
        poiReadExcel.readExcelFile();
        String register_name = poiReadExcel.getRegisterName();


        WebElement idField = driver.findElement(By.cssSelector("html > body > div > div > div > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(2) > form > div:nth-of-type(1) > div:nth-of-type(1) > input"));
        idField.sendKeys(aConst.devEmail);


        WebElement passwordField = driver.findElement(By.cssSelector("html > body > div > div > div > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(2) > form > div:nth-of-type(2) > div:nth-of-type(1) > input"));
        passwordField.sendKeys(aConst.devPassword);


        WebElement loginButton = driver.findElement(By.cssSelector("button[class='submit']"));
        loginButton.click();


        //todo 앱버전이 하나인 계정으로 로그인시
//        WebElement goMpm = driver.findElement(By.cssSelector("html > body > div:nth-of-type(1) > div > div:nth-of-type(2) > div:nth-of-type(2) > table > tbody > tr:nth-of-type(1) > td:nth-of-type(2) > div"));
//        goMpm.click();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement MoreProjectsButton = driver.findElement(By.cssSelector("button[class='more-btn']"));
        MoreProjectsButton.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement TestMpm = driver.findElement(By.cssSelector("html > body > div:nth-of-type(1) > div > div:nth-of-type(3) > div:nth-of-type(2) > table > tbody > tr:nth-of-type(39) > td:nth-of-type(2)"));
        TestMpm.click();

        WebElement goReport = driver.findElement(By.cssSelector("html > body > div > div > header > div:nth-of-type(2) > div > ul > div:nth-of-type(5) > li > a > span"));
        goReport.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        Thread.sleep(5000);

        //AppVer1 (HY 프레딧 AOS 프로젝트 기준)
        WebElement AppVerDropBox = driver.findElement(By.cssSelector("button[class='version-dropdown-btn']"));
        AppVerDropBox.click();

        WebElement AppVerDroBoxSelect1 = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(1) > div:nth-of-type(3) > div:nth-of-type(2) > ul > li:nth-of-type(1) > button"));
        AppVerDroBoxSelect1.click();

        WebElement ReportAppVerApplyButton = driver.findElement(By.cssSelector("button[class='version-apply-btn']"));
        ReportAppVerApplyButton.click();

        WebElement ReportFirstPage = driver.findElement(By.cssSelector("div[id='page1'] div[class='report-container']"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        File file=ReportFirstPage.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("app1logo.png"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //파일 스크린샷 코드 추가

        //AppVer2 (HY 프레딧 AOS 프로젝트 기준)
        WebElement AppVerDropBox2 = driver.findElement(By.cssSelector("button[class='version-dropdown-btn']"));
        AppVerDropBox2.click();

        WebElement AppVerDroBoxSelect2 = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(1) > div:nth-of-type(3) > div:nth-of-type(2) > ul > li:nth-of-type(2) > button"));
        AppVerDroBoxSelect2.click();

        WebElement ReportAppVerApplyButton2 = driver.findElement(By.cssSelector("button[class='version-apply-btn']"));
        ReportAppVerApplyButton2.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement Report2ElementConfirm = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(1) > table > tbody > tr > td:nth-of-type(2)"));
        Report2ElementConfirm.getText();

        WebElement Report2ElementConfirm2 = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(3) > table > tbody > tr > td:nth-of-type(2)"));
        Report2ElementConfirm2.getText();

        WebElement Report2ElementConfirm3 = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(5) > table > tbody > tr > td:nth-of-type(6)"));
        Report2ElementConfirm3.getText();



        WebElement ReportFirstPage2 = driver.findElement(By.cssSelector("div[id='page1'] div[class='report-container']"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        File file2 = ReportFirstPage2.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file2, new File("app2logo.png"));
    }
}
