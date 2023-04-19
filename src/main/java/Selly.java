import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;


public class Selly {
    private WebDriver driver;


    public static void main(String[] args) throws Exception {
        System.out.println("Say Run");
        while (true) {
            try {
                new Selly().run();
            } catch (Exception e) {

            }
        }

    }


    public Selly() {

        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
//        option.addArguments("headless");
        driver = new ChromeDriver(option);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://account.imqa.io/user/login");

    }

    public void run() throws Exception {

        WebElement idField = driver.findElement(By.cssSelector("html > body > div > div > div > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(2) > form > div:nth-of-type(1) > div:nth-of-type(1) > input"));
        idField.sendKeys("su10king@gmail.com");
        //devload@naver.com

        WebElement passwordField = driver.findElement(By.cssSelector("html > body > div > div > div > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(2) > form > div:nth-of-type(2) > div:nth-of-type(1) > input"));
        passwordField.sendKeys("sucheol9608!");


        WebElement loginButton = driver.findElement(By.cssSelector("button[class='submit']"));
        loginButton.click();

//        WebDriverWait waitTimer = new WebDriverWait(driver, 6);
//        waitTimer.until(ExpectedConditions.textToBePresentInElement(passwordField, "sucheol9608!"));

//        Thread.sleep(4000);
//
//        WebElement MoreProjectsButton = driver.findElement(By.cssSelector("button[class='more-btn']"));
//        MoreProjectsButton.click();
//
//        Thread.sleep(3000);
//
//        WebElement TestMpm = driver.findElement(By.cssSelector("html > body > div:nth-of-type(1) > div > div:nth-of-type(3) > div:nth-of-type(2) > table > tbody > tr:nth-of-type(39) > td:nth-of-type(2)"));
//        TestMpm.click();
//

        WebElement goMpm = driver.findElement(By.cssSelector("html > body > div:nth-of-type(1) > div > div:nth-of-type(2) > div:nth-of-type(2) > table > tbody > tr:nth-of-type(1) > td:nth-of-type(2) > div"));
        goMpm.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);




        WebElement SummaryButton = driver.findElement(By.cssSelector("span[class$='center']"));
        SummaryButton.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        WebElement SummaryClose = driver.findElement(By.cssSelector("img[style='cursor: pointer; position: absolute; top: 0px; left: 600px;']"));
        SummaryClose.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//        알람 등록
        WebElement AlarmButton = driver.findElement(By.cssSelector("html > body > div > div > header > div:nth-of-type(2) > div > ul > div:nth-of-type(6) > li"));
        AlarmButton.click();

//        Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement AlarmPolicy = driver.findElement(By.cssSelector("a[class='out']"));
        AlarmPolicy.click();


        WebElement AddAlarm = driver.findElement(By.cssSelector("button[class='add-btn']"));
        AddAlarm.click();
//        Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement AlarmPolicyName = driver.findElement(By.cssSelector("input[class^='name-input']"));
        AlarmPolicyName.sendKeys("테스트 알람 자동 생성");
//        Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement AlarmNativeRendering = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > div > div:nth-of-type(2) > div:nth-of-type(3) > input"));
        AlarmNativeRendering.clear();
        AlarmNativeRendering.sendKeys("1");
//        Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //경고알람을 메일로 받기 위해서 경고알림 수치를 낮춥니다.

        WebElement EmailSelect = driver.findElement(By.cssSelector("label[for='email-input']"));
        EmailSelect.click();
        WebElement AlarmMember = driver.findElement(By.cssSelector("button[class^='member']"));
        AlarmMember.click();
        WebElement AlarmMemberSelect = driver.findElement(By.cssSelector("label[for='allSelect']"));
        AlarmMemberSelect.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement AlarmSave = driver.findElement(By.cssSelector("button[class='submit']"));
        AlarmSave.click();
//        Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //알람 수정
        WebElement ModifyAlarm = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > table > tbody > tr > td:nth-of-type(2)"));
        ModifyAlarm.click();
//        Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        WebElement ModifyAlarmPolicyName2 = driver.findElement(By.cssSelector("input[class='name-input']"));
        ModifyAlarmPolicyName2.clear();
//        Thread.sleep(2000);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        ModifyAlarmPolicyName2.sendKeys("테스트 알람 자동 생성 후 수정됨");
        WebElement AlarmResponseTime = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > div > div:nth-of-type(3) > div:nth-of-type(3) > input"));
        AlarmResponseTime.clear();
        AlarmResponseTime.sendKeys("1");
        WebElement ModifyAlarmSave = driver.findElement(By.cssSelector("button[class='submit']"));
        ModifyAlarmSave.click();
//        Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);



//        앱 버전별 보고서 확인
        driver.get("https://account.imqa.io/user/login");

        WebElement goMpm1 = driver.findElement(By.cssSelector("html > body > div:nth-of-type(1) > div > div:nth-of-type(2) > div:nth-of-type(2) > table > tbody > tr:nth-of-type(1) > td:nth-of-type(2) > div"));
        goMpm1.click();
        Thread.sleep(3000);


        WebElement goReport = driver.findElement(By.cssSelector("html > body > div > div > header > div:nth-of-type(2) > div > ul > div:nth-of-type(5) > li > a > span"));
        goReport.click();
        Thread.sleep(5000);



//        //AppVer1 (HY 프레딧 AOS 프로젝트 기준)
//        WebElement AppVerDropBox = driver.findElement(By.cssSelector("button[class='version-dropdown-btn']"));
//        AppVerDropBox.click();
//
//        WebElement AppVerDroBoxSelect1 = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(1) > div:nth-of-type(3) > div:nth-of-type(2) > ul > li:nth-of-type(1) > button"));
//        AppVerDroBoxSelect1.click();
//
//        WebElement ReportAppVerApplyButton = driver.findElement(By.cssSelector("button[class='version-apply-btn']"));
//        ReportAppVerApplyButton.click();
//
//        WebElement ReportFirstPage = driver.findElement(By.cssSelector("div[id='page1'] div[class='report-container']"));
//        Thread.sleep(3000);
//        File file=ReportFirstPage.getScreenshotAs(OutputType.FILE);
//        FileUtils.copyFile(file, new File("app1logo.png"));
//        Thread.sleep(4000);
//        //파일 스크린샷 코드 추가
//
//        //AppVer2 (HY 프레딧 AOS 프로젝트 기준)
//        WebElement AppVerDropBox2 = driver.findElement(By.cssSelector("button[class='version-dropdown-btn']"));
//        AppVerDropBox2.click();
//
//        WebElement AppVerDroBoxSelect2 = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(1) > div:nth-of-type(3) > div:nth-of-type(2) > ul > li:nth-of-type(2) > button"));
//        AppVerDroBoxSelect2.click();
//
//        WebElement ReportAppVerApplyButton2 = driver.findElement(By.cssSelector("button[class='version-apply-btn']"));
//        ReportAppVerApplyButton2.click();
//        Thread.sleep(3000);
//
//        WebElement ReportFirstPage2 = driver.findElement(By.cssSelector("div[id='page1'] div[class='report-container']"));
//        Thread.sleep(3000);
//        File file2 = ReportFirstPage2.getScreenshotAs(OutputType.FILE);
//        FileUtils.copyFile(file2, new File("app2logo.png"));


//        //파일 업로드 테스트
        driver.get("https://account.imqa.io/user/login");

        WebElement MangeDropButton = driver.findElement(By.cssSelector("div[class='project-dropdown'] a[class='dropdown-toggle']"));
        MangeDropButton.click();

        WebElement ProguardSettingButton = driver.findElement(By.cssSelector("html > body > div:nth-of-type(1) > div > div:nth-of-type(2) > div:nth-of-type(2) > table > tbody > tr:nth-of-type(1) > td:nth-of-type(5) > div > div > ul > li:nth-of-type(2) > a"));
        ProguardSettingButton.click();


        WebElement ProguardSelectButton = driver.findElement(By.cssSelector("input[id='mapping-file-input']"));
        ProguardSelectButton.sendKeys("/Users/id_sucheol/Downloads/fragment-0410/2.0/testfile.txt");
        Thread.sleep(3000);

        File file1 = new File("/Users/id_sucheol/Downloads/fragment-0410/2.0");
        String lastFolderName = file1.getName(); // "2.0"
        WebElement ProguardAppVersion = driver.findElement(By.cssSelector("input[class='version-input']"));
        ProguardAppVersion.sendKeys(lastFolderName);
        Thread.sleep(2000);



        //todo 프론트에서 disabled인 버튼이 동작하지 않는 이슈가 있다.
        WebElement ProguardUploadButton = driver.findElement(By.cssSelector("button[class='submit']"));
        ProguardUploadButton.click();
        ProguardUploadButton.wait(3);


        Thread.sleep(3000);
        Alert alert1 = driver.switchTo().alert();
        alert1.accept();
        System.out.println("확인버튼 누름");
        Thread.sleep(3000);










        //리버스 스택 분석
        driver.get("https://account.imqa.io/user/login");

        WebElement goMpm2 = driver.findElement(By.cssSelector("html > body > div:nth-of-type(1) > div > div:nth-of-type(2) > div:nth-of-type(2) > table > tbody > tr:nth-of-type(1) > td:nth-of-type(2) > div"));
        goMpm2.click();
        Thread.sleep(3000);

        WebElement goStatistic = driver.findElement(By.cssSelector("span[class$='opacity'] span[class='ctxt']"));
        goStatistic.click();

        WebElement SectionStaticsButton = driver.findElement(By.cssSelector("html > body > div > div > header > div:nth-of-type(2) > div > ul > div:nth-of-type(4) > li > ul > li:nth-of-type(1) > a > span"));
        SectionStaticsButton.click();





    }


    public void 프로젝트전체보기(WebDriver driver) throws InterruptedException {
        WebElement cardViewButton = driver.findElement(By.cssSelector("html > body > div:nth-of-type(1) > div > div:nth-of-type(3) > div:nth-of-type(1) > span:nth-of-type(2) > a:nth-of-type(2)"));
        cardViewButton.click();
        Thread.sleep(3000);
        List<WebElement> projectList = driver.findElements(By.cssSelector("div > .project-view-card"));
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("ChannelIO('hideMessenger');");
    }


    private String 스크린샷(WebDriver driver , String projectName, String screenName) throws IOException {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String fileName = URLEncoder.encode(projectName.replaceAll(" ","") + "_" + screenName.replaceAll(" ",""),"UTF-8") + "_"  + getCurrentDateTime() + ".png";
        String filePath = "C:\\imqa\\" + fileName;
        File output =  new File(filePath);
        FileUtils.copyFile(file,output);
        return  fileName;
    }

    private String getCurrentDateTime() {
        return getCurrentDateTime("yyyyMMddHHmmss");
    }

    private String getCurrentDateTime(String format) {
        Date today = new Date();
        Locale currentLocale = new Locale("KOREAN", "KOREA");
        String pattern = format; //hhmmss로 시간,분,초만 뽑기도 가능
        SimpleDateFormat formatter = new SimpleDateFormat(pattern,
                currentLocale);
        return formatter.format(today);
    }

//    public void 알람등록(WebDriver driver) throws InterruptedException {
//        WebElement AlarmButton = driver.findElement(By.xpath("//input[@text}"));
//        AlarmButton.click();
//        WebElement addButton = driver.findElement(By.className("add-btn"));
//        addButton.click();
////        WebElement AlarmName = driver.findElement(By.className("name-input invalid-input"));
////        AlarmName.sendKeys("알람 자동화 테스트");
//        WebElement AlarmElement = driver.findElement(By.tagName("number"));
//        AlarmElement.clear();
//        AlarmElement.sendKeys("1");
//        WebElement selectChannel = driver.findElement(By.linkText("/img/icon-check.a3f7142a.svg"));
//        selectChannel.click();
//        WebElement AlarmMemberToggle = driver.findElement(By.className("member_dropdown-btn"));
//        AlarmMemberToggle.click();
//        WebElement selectMember = driver.findElement(By.id("allSelect"));
//        selectMember.click();
//        WebElement Submit = driver.findElement(By.className("submit"));
//        Submit.click();
//    }


}


