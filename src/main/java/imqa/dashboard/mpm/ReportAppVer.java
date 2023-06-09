package imqa.dashboard.mpm;


import com.common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class ReportAppVer {

    private static WebDriver driver;

    private Constant constant;


    public ReportAppVer() {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
//        option.addArguments("headless");
        driver = new ChromeDriver(option);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://account.imqa.io/user/login");
    }

    private static void setReportLogin() {



        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement idField = driver.findElement(By.cssSelector("html > body > div > div > div > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(2) > form > div:nth-of-type(1) > div:nth-of-type(1) > input"));
        setReportLogOut();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        idField.sendKeys("devload@naver.com");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement passwordField = driver.findElement(By.cssSelector("html > body > div > div > div > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(2) > form > div:nth-of-type(2) > div:nth-of-type(1) > input"));
        passwordField.sendKeys("sh583582!23$");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement loginButton = driver.findElement(By.cssSelector("button[class='submit']"));
        loginButton.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement MoreProjectsButton = driver.findElement(By.cssSelector("button[class='more-btn']"));
        MoreProjectsButton.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement TestMpm = driver.findElement(By.cssSelector("html > body > div:nth-of-type(1) > div > div:nth-of-type(3) > div:nth-of-type(2) > table > tbody > tr:nth-of-type(39) > td:nth-of-type(2)"));
        TestMpm.click();

        WebElement goReport = driver.findElement(By.cssSelector("html > body > div > div > header > div:nth-of-type(2) > div > ul > div:nth-of-type(5) > li > a > span"));
        goReport.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    private static void setReportLogOut() {
        WebElement LogOutSideBar = driver.findElement(By.cssSelector("div[class='header-dropdown'] div[class='content']"));
        LogOutSideBar.click();

        WebElement LogOut = driver.findElement(By.cssSelector("html > body > div > div > header > div:nth-of-type(6) > div:nth-of-type(3) > ul > li:nth-of-type(4) > a > span"));
        LogOut.click();
    }



    public static boolean ReportTest1() {

        setReportLogin();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement AppVerDropBox = driver.findElement(By.cssSelector("button[class='version-dropdown-btn']"));
        AppVerDropBox.click();

        WebElement AppVerDroBoxSelect = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(1) > div:nth-of-type(3) > div:nth-of-type(2) > ul > li:nth-of-type(2) > button"));
        AppVerDroBoxSelect.click();

        WebElement ReportAppVerApplyButton = driver.findElement(By.cssSelector("button[class='version-apply-btn']"));
        ReportAppVerApplyButton.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement ReportNativeLoading = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(1) > table > tbody > tr > td:nth-of-type(2)"));
        ReportNativeLoading.getText();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("로그아웃 타임아웃으로 실패했습니다.");
        }
        setReportLogOut();
        return true;
    }

    public static boolean ReportTest2 () {

        setReportLogin();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement AppVerDropBox = driver.findElement(By.cssSelector("button[class='version-dropdown-btn']"));
        AppVerDropBox.click();

        WebElement AppVerDroBoxSelect = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(1) > div:nth-of-type(3) > div:nth-of-type(2) > ul > li:nth-of-type(2) > button"));
        AppVerDroBoxSelect.click();

        WebElement ReportAppVerApplyButton = driver.findElement(By.cssSelector("button[class='version-apply-btn']"));
        ReportAppVerApplyButton.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement ReportWebViewLoading = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(2) > table > tbody > tr > td:nth-of-type(2)"));
        ReportWebViewLoading.getText();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("로그아웃 타임아웃으로 실패했습니다.");
        }
        setReportLogOut();
        return true;
    }

    public static boolean ReportTest3 () {

        setReportLogin();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement AppVerDropBox = driver.findElement(By.cssSelector("button[class='version-dropdown-btn']"));
        AppVerDropBox.click();

        WebElement AppVerDroBoxSelect = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(1) > div:nth-of-type(3) > div:nth-of-type(2) > ul > li:nth-of-type(2) > button"));
        AppVerDroBoxSelect.click();

        WebElement ReportAppVerApplyButton = driver.findElement(By.cssSelector("button[class='version-apply-btn']"));
        ReportAppVerApplyButton.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement ReportResponse = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(3) > table > tbody > tr > td:nth-of-type(2)"));
        ReportResponse.getText();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("로그아웃 타임아웃으로 실패했습니다.");
        }
        setReportLogOut();
        return true;
    }

    public static boolean ReportTest4 () {

        setReportLogin();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement AppVerDropBox = driver.findElement(By.cssSelector("button[class='version-dropdown-btn']"));
        AppVerDropBox.click();

        WebElement AppVerDroBoxSelect = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(1) > div:nth-of-type(3) > div:nth-of-type(2) > ul > li:nth-of-type(2) > button"));
        AppVerDroBoxSelect.click();

        WebElement ReportAppVerApplyButton = driver.findElement(By.cssSelector("button[class='version-apply-btn']"));
        ReportAppVerApplyButton.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement ReportCpuUsage = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(4) > table > tbody > tr > td:nth-of-type(2)"));
        ReportCpuUsage.getText();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("로그아웃 타임아웃으로 실패했습니다.");
        }
        setReportLogOut();
        return true;
    }

    public static boolean ReportTest5 () {

        setReportLogin();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement AppVerDropBox = driver.findElement(By.cssSelector("button[class='version-dropdown-btn']"));
        AppVerDropBox.click();

        WebElement AppVerDroBoxSelect = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(1) > div:nth-of-type(3) > div:nth-of-type(2) > ul > li:nth-of-type(2) > button"));
        AppVerDroBoxSelect.click();

        WebElement ReportAppVerApplyButton = driver.findElement(By.cssSelector("button[class='version-apply-btn']"));
        ReportAppVerApplyButton.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement ReportMemoryUsage = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(5) > table > tbody > tr > td:nth-of-type(2)"));
        ReportMemoryUsage.getText();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("로그아웃 타임아웃으로 실패했습니다.");
        }
        setReportLogOut();
        return true;
    }

    public static boolean ReportTest6 () {
        setReportLogin();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement AppVerDropBox = driver.findElement(By.cssSelector("button[class='version-dropdown-btn']"));
        AppVerDropBox.click();

        WebElement AppVerDroBoxSelect = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(1) > div:nth-of-type(3) > div:nth-of-type(2) > ul > li:nth-of-type(2) > button"));
        AppVerDroBoxSelect.click();

        WebElement ReportAppVerApplyButton = driver.findElement(By.cssSelector("button[class='version-apply-btn']"));
        ReportAppVerApplyButton.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement NativeUiRenderingBar = driver.findElement(By.cssSelector("span[class='uiRenderingBottom']"));
        NativeUiRenderingBar.getText();


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("로그아웃 타임아웃으로 실패했습니다.");
        }
        setReportLogOut();
        return true;
    }

    public static boolean ReportTest7 () {
        setReportLogin();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement AppVerDropBox = driver.findElement(By.cssSelector("button[class='version-dropdown-btn']"));
        AppVerDropBox.click();

        WebElement AppVerDroBoxSelect = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(1) > div:nth-of-type(3) > div:nth-of-type(2) > ul > li:nth-of-type(2) > button"));
        AppVerDroBoxSelect.click();

        WebElement ReportAppVerApplyButton = driver.findElement(By.cssSelector("button[class='version-apply-btn']"));
        ReportAppVerApplyButton.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        //표본의 2번째 데이터 존재 유무로 테스트 성공실패를 판단, td.type을 1로 수정하고 isDisplayed를 getText로 하면 하나의 값을 알 수 있다.
        WebElement ReportScreenTable = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(1) > table > tbody > tr > td:nth-of-type(2)"));
        ReportScreenTable.isDisplayed();

        WebElement ReportOsVersionTable = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(2) > table > tbody > tr > td:nth-of-type(2)"));
        ReportOsVersionTable.isDisplayed();

        WebElement ReportDeviceTable = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(3) > table > tbody > tr > td:nth-of-type(2)"));
        ReportDeviceTable.isDisplayed();

        WebElement ReportLocationTable = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(4) > table > tbody > tr > td:nth-of-type(2)"));
        ReportLocationTable.isDisplayed();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("로그아웃 타임아웃으로 실패했습니다.");
        }
        setReportLogOut();
        return true;
    }

    public static boolean ReportTest8 () {
        setReportLogin();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement AppVerDropBox = driver.findElement(By.cssSelector("button[class='version-dropdown-btn']"));
        AppVerDropBox.click();

        WebElement AppVerDroBoxSelect = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(1) > div:nth-of-type(3) > div:nth-of-type(2) > ul > li:nth-of-type(2) > button"));
        AppVerDroBoxSelect.click();

        WebElement ReportAppVerApplyButton = driver.findElement(By.cssSelector("button[class='version-apply-btn']"));
        ReportAppVerApplyButton.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement CpuUsageBar = driver.findElement(By.cssSelector("span[class='cpuBottom']"));
        CpuUsageBar.getText();


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("로그아웃 타임아웃으로 실패했습니다.");
        }
        setReportLogOut();
        return true;
    }

    public static boolean ReportTest9 () {
        setReportLogin();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement AppVerDropBox = driver.findElement(By.cssSelector("button[class='version-dropdown-btn']"));
        AppVerDropBox.click();

        WebElement AppVerDroBoxSelect = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(1) > div:nth-of-type(3) > div:nth-of-type(2) > ul > li:nth-of-type(2) > button"));
        AppVerDroBoxSelect.click();

        WebElement ReportAppVerApplyButton = driver.findElement(By.cssSelector("button[class='version-apply-btn']"));
        ReportAppVerApplyButton.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //표본의 2번째 데이터 존재 유무로 테스트 성공실패를 판단, td.type을 1로 수정하고 isDisplayed를 getText로 하면 하나의 값을 알 수 있다.
        WebElement ReportScreenTable = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > div:nth-of-type(3) > div:nth-of-type(2) > div:nth-of-type(1) > table > tbody > tr > td:nth-of-type(2)"));
        ReportScreenTable.isDisplayed();

        WebElement ReportOsVersionTable = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > div:nth-of-type(3) > div:nth-of-type(2) > div:nth-of-type(2) > table > tbody > tr > td:nth-of-type(2)"));
        ReportOsVersionTable.isDisplayed();

        WebElement ReportDeviceTable = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > div:nth-of-type(3) > div:nth-of-type(2) > div:nth-of-type(3) > table > tbody > tr > td:nth-of-type(2)"));
        ReportDeviceTable.isDisplayed();

        WebElement ReportLocationTable = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > div:nth-of-type(3) > div:nth-of-type(2) > div:nth-of-type(4) > table > tbody > tr > td:nth-of-type(2)"));
        ReportLocationTable.isDisplayed();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("로그아웃 타임아웃으로 실패했습니다.");
        }
        setReportLogOut();
        return true;
    }

    public static boolean ReportTest10 () {
        setReportLogin();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement AppVerDropBox = driver.findElement(By.cssSelector("button[class='version-dropdown-btn']"));
        AppVerDropBox.click();

        WebElement AppVerDroBoxSelect = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(1) > div:nth-of-type(3) > div:nth-of-type(2) > ul > li:nth-of-type(2) > button"));
        AppVerDroBoxSelect.click();

        WebElement ReportAppVerApplyButton = driver.findElement(By.cssSelector("button[class='version-apply-btn']"));
        ReportAppVerApplyButton.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement MemoryBar = driver.findElement(By.cssSelector("span[class='memoryBottom']"));
        MemoryBar.getText();


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("로그아웃 타임아웃으로 실패했습니다.");
        }
        setReportLogOut();
        return true;
    }

    public static boolean ReportTest11 () {
        setReportLogin();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement AppVerDropBox = driver.findElement(By.cssSelector("button[class='version-dropdown-btn']"));
        AppVerDropBox.click();

        WebElement AppVerDroBoxSelect = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(1) > div:nth-of-type(3) > div:nth-of-type(2) > ul > li:nth-of-type(2) > button"));
        AppVerDroBoxSelect.click();

        WebElement ReportAppVerApplyButton = driver.findElement(By.cssSelector("button[class='version-apply-btn']"));
        ReportAppVerApplyButton.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //표본의 2번째 데이터 존재 유무로 테스트 성공실패를 판단, td.type을 1로 수정하고 isDisplayed를 getText로 하면 하나의 값을 알 수 있다.
        WebElement ReportScreenTable = driver.findElement(By.cssSelector("hhtml > body > div > div > section > div > div:nth-of-type(2) > div:nth-of-type(4) > div:nth-of-type(2) > div:nth-of-type(1) > table > tbody > tr > td:nth-of-type(2)"));
        ReportScreenTable.isDisplayed();

        WebElement ReportOsVersionTable = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > div:nth-of-type(4) > div:nth-of-type(2) > div:nth-of-type(2) > table > tbody > tr > td:nth-of-type(2)"));
        ReportOsVersionTable.isDisplayed();

        WebElement ReportDeviceTable = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > div:nth-of-type(4) > div:nth-of-type(2) > div:nth-of-type(3) > table > tbody > tr > td:nth-of-type(2)"));
        ReportDeviceTable.isDisplayed();

        WebElement ReportLocationTable = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > div:nth-of-type(4) > div:nth-of-type(2) > div:nth-of-type(4) > table > tbody > tr > td:nth-of-type(2)"));
        ReportLocationTable.isDisplayed();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("로그아웃 타임아웃으로 실패했습니다.");
        }
        setReportLogOut();
        return true;
    }


    public static boolean ReportTest12 () {
        setReportLogin();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement AppVerDropBox = driver.findElement(By.cssSelector("button[class='version-dropdown-btn']"));
        AppVerDropBox.click();

        WebElement AppVerDroBoxSelect = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(1) > div:nth-of-type(3) > div:nth-of-type(2) > ul > li:nth-of-type(2) > button"));
        AppVerDroBoxSelect.click();

        WebElement ReportAppVerApplyButton = driver.findElement(By.cssSelector("button[class='version-apply-btn']"));
        ReportAppVerApplyButton.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement UrlResponseAverage = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > div:nth-of-type(5) > div:nth-of-type(2) > div > table > tbody > tr:nth-of-type(1) > td:nth-of-type(6)"));
        UrlResponseAverage.getText();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("로그아웃 타임아웃으로 실패했습니다.");
        }
        setReportLogOut();
        return true;
    }

    public static boolean ReportTest13 () {
        setReportLogin();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement AppVerDropBox = driver.findElement(By.cssSelector("button[class='version-dropdown-btn']"));
        AppVerDropBox.click();

        WebElement AppVerDroBoxSelect = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(1) > div:nth-of-type(3) > div:nth-of-type(2) > ul > li:nth-of-type(2) > button"));
        AppVerDroBoxSelect.click();

        WebElement ReportAppVerApplyButton = driver.findElement(By.cssSelector("button[class='version-apply-btn']"));
        ReportAppVerApplyButton.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement UrlP95ResponseAverage = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > div:nth-of-type(5) > div:nth-of-type(2) > div > table > tbody > tr:nth-of-type(1) > td:nth-of-type(7)"));
        UrlP95ResponseAverage.getText();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("로그아웃 타임아웃으로 실패했습니다.");
        }
        setReportLogOut();
        return true;
    }

    public static boolean ReportTest14 () {
        setReportLogin();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement AppVerDropBox = driver.findElement(By.cssSelector("button[class='version-dropdown-btn']"));
        AppVerDropBox.click();

        WebElement AppVerDroBoxSelect = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(1) > div:nth-of-type(3) > div:nth-of-type(2) > ul > li:nth-of-type(2) > button"));
        AppVerDroBoxSelect.click();

        WebElement ReportAppVerApplyButton = driver.findElement(By.cssSelector("button[class='version-apply-btn']"));
        ReportAppVerApplyButton.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement WebViewLoadingAverage = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > div:nth-of-type(6) > div:nth-of-type(2) > div > table > tbody > tr:nth-of-type(1) > td:nth-of-type(4)"));
        WebViewLoadingAverage.getText();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("로그아웃 타임아웃으로 실패했습니다.");
        }
        setReportLogOut();
        return true;
    }

    public static boolean ReportTest15 () {
        setReportLogin();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement AppVerDropBox = driver.findElement(By.cssSelector("button[class='version-dropdown-btn']"));
        AppVerDropBox.click();

        WebElement AppVerDroBoxSelect = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(1) > div:nth-of-type(3) > div:nth-of-type(2) > ul > li:nth-of-type(2) > button"));
        AppVerDroBoxSelect.click();

        WebElement ReportAppVerApplyButton = driver.findElement(By.cssSelector("button[class='version-apply-btn']"));
        ReportAppVerApplyButton.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement WebViewP95LoadingAverage = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > div:nth-of-type(6) > div:nth-of-type(2) > div > table > tbody > tr:nth-of-type(1) > td:nth-of-type(5)"));
        WebViewP95LoadingAverage.getText();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("로그아웃 타임아웃으로 실패했습니다.");
        }
        setReportLogOut();
        return true;
    }
}
