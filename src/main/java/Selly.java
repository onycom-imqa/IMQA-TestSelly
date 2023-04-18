import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Locale;




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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://account.imqa.io/user/login");

    }

    public void run() throws Exception {


        WebElement idField = driver.findElement(By.cssSelector("html > body > div > div > div > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(2) > form > div:nth-of-type(1) > div:nth-of-type(1) > input"));
        idField.sendKeys("su10king@gmail.com");

        WebElement passwordField = driver.findElement(By.cssSelector("html > body > div > div > div > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(2) > form > div:nth-of-type(2) > div:nth-of-type(1) > input"));
        passwordField.sendKeys("sucheol9608!");


        WebElement loginButton = driver.findElement(By.cssSelector("button[class='submit']"));
        loginButton.click();


        Thread.sleep(4000);

//        WebElement MoreProjectsButton = driver.findElement(By.cssSelector("button[class='more-btn']"));
//        MoreProjectsButton.click();
//
//        Thread.sleep(3000);

//        WebElement TestMpm = driver.findElement(By.cssSelector("html > body > div:nth-of-type(1) > div > div:nth-of-type(3) > div:nth-of-type(2) > table > tbody > tr:nth-of-type(39) > td:nth-of-type(2)"));
        WebElement goMpm = driver.findElement(By.cssSelector("html > body > div:nth-of-type(1) > div > div:nth-of-type(2) > div:nth-of-type(2) > table > tbody > tr:nth-of-type(1) > td:nth-of-type(2) > div"));
        goMpm.click();
//        TestMpm.click();

        Thread.sleep(3000);

//        WebElement DropBox = driver.findElement(By.cssSelector("html > body > div > div > div:nth-of-type(1) > section > div > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(1) > div > button"));
//        DropBox.click();
//
//        Thread.sleep(3000);
//
//        WebElement AppVersion = driver.findElement(By.cssSelector("html > body > div > div > div:nth-of-type(1) > section > div > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(1) > div > div > ul > li:nth-of-type(3) > button > span"));
//        AppVersion.click();
//
//        Thread.sleep(3000);

        System.out.println("MPM board");


        WebElement SummaryButton = driver.findElement(By.cssSelector("span[class$='center']"));
        SummaryButton.click();
        Thread.sleep(3000);
//
//        System.out.println(driver.findElement(By.cssSelector("html > body > div > div > div:nth-of-type(3) > div > div:nth-of-type(3) > div:nth-of-type(1) > table > tbody > tr > td:nth-of-type(4)")).getText().toString()+ "여기에요");
//        Thread.sleep(2000);

        WebElement SummaryClose = driver.findElement(By.cssSelector("img[style='cursor: pointer; position: absolute; top: 0px; left: 600px;']"));
        SummaryClose.click();
        Thread.sleep(2000);

        WebElement AlarmButton = driver.findElement(By.cssSelector("html > body > div > div > header > div:nth-of-type(2) > div > ul > div:nth-of-type(2) > li"));
        AlarmButton.click();

        Thread.sleep(3000);
        WebElement AlarmPolicy = driver.findElement(By.cssSelector("a[class='out']"));
        AlarmPolicy.click();

        //알람 등록
        WebElement AddAlarm = driver.findElement(By.cssSelector("button[class='add-btn']"));
        AddAlarm.click();
        Thread.sleep(3000);

        WebElement AlarmPolicyName = driver.findElement(By.cssSelector("input[class^='name-input']"));
        AlarmPolicyName.sendKeys("테스트 알람 자동 생성");
        Thread.sleep(3000);

        WebElement AlarmNativeRendering = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > div > div:nth-of-type(2) > div:nth-of-type(3) > input"));
        AlarmNativeRendering.clear();
        AlarmNativeRendering.sendKeys("1");
        Thread.sleep(3000);
        //경고알람을 메일로 받기 위해서 경고알림 수치를 낮춥니다.

        WebElement EmailSelect = driver.findElement(By.cssSelector("label[for='email-input']"));
        EmailSelect.click();
        WebElement AlarmMember = driver.findElement(By.cssSelector("button[class^='member']"));
        AlarmMember.click();
        WebElement AlarmMemberSelect = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(3) > div:nth-of-type(2) > div > div > div > div > div > div:nth-of-type(1) > div > span:nth-of-type(1)"));
        AlarmMemberSelect.click();
        Thread.sleep(3000);

        WebElement AlarmSave = driver.findElement(By.cssSelector("button[class='submit']"));
        AlarmSave.click();
        Thread.sleep(3000);

        //알람 수정
        WebElement ModifyAlarm = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > table > tbody > tr > td:nth-of-type(2)"));
        ModifyAlarm.click();
        Thread.sleep(3000);

        WebElement ModifyAlarmPolicyName = driver.findElement(By.cssSelector("input[class='name-input']"));
        ModifyAlarmPolicyName.clear();
        Thread.sleep(2000);
        ModifyAlarmPolicyName.sendKeys("테스트 알람 자동 생성 후 수정됨");
        WebElement AlarmResponseTime = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > div > div:nth-of-type(3) > div:nth-of-type(3) > input"));
        AlarmResponseTime.clear();
        AlarmResponseTime.sendKeys("1");
        WebElement ModifyAlarmSave = driver.findElement(By.cssSelector("button[class='submit']"));
        ModifyAlarmSave.click();
        Thread.sleep(3000);

        // 크래시 버튼
        WebElement crashButton = driver.findElement(By.cssSelector("html > body > div:nth-of-type(1) > div > div:nth-of-type(3) > div:nth-of-type(" + (3) + ") > div > div:nth-of-type(1) > span:nth-of-type(3) > a:nth-of-type(2) > span"));
        crashButton.click();
        Thread.sleep(2000);
        String firstAppVersion = driver.findElement(By.cssSelector("html > body > section > section > section > div:nth-of-type(1) > section:nth-of-type(1) > button")).getText().toString();
        System.out.println("    앱버전 : " + firstAppVersion);
        System.out.println("        주간크래시 : " + driver.findElement(By.cssSelector("html > body > section > section > section > div:nth-of-type(1) > section:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(1) > div:nth-of-type(2) > span")).getText());
        System.out.println("        주간이용자수 : " + driver.findElement(By.cssSelector("html > body > section > section > section > div:nth-of-type(1) > section:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > span")).getText());
        System.out.println("        주간실행수 : " + driver.findElement(By.cssSelector("html > body > section > section > section > div:nth-of-type(1) > section:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(2) > span")).getText());


        List<WebElement> appVersionListElement = driver.findElements(By.cssSelector("html > body > section > section > section > div:nth-of-type(1) > section:nth-of-type(1) > ul > li"));
        for (int j = 1; j < appVersionListElement.size(); j++) {
            try {
                Thread.sleep(2000);
                driver.findElement(By.cssSelector("html > body > section > section > section > div:nth-of-type(1) > section:nth-of-type(1) > button")).click();
                Thread.sleep(1000);
                String appVersion = driver.findElement(By.cssSelector("html > body > section > section > section > div:nth-of-type(1) > section:nth-of-type(1) > ul > li:nth-of-type(" + (j + 1) + ") > a")).getText();
                driver.findElement(By.cssSelector("html > body > section > section > section > div:nth-of-type(1) > section:nth-of-type(1) > ul > li:nth-of-type(" + (j + 1) + ")")).click();
                Thread.sleep(3000);
                System.out.println("    앱버전 : " + appVersion);
                System.out.println("        주간크래시 : " + driver.findElement(By.cssSelector("html > body > section > section > section > div:nth-of-type(1) > section:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(1) > div:nth-of-type(2) > span")).getText());
                System.out.println("        주간이용자수 : " + driver.findElement(By.cssSelector("html > body > section > section > section > div:nth-of-type(1) > section:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > span")).getText());
                System.out.println("        주간실행수 : " + driver.findElement(By.cssSelector("html > body > section > section > section > div:nth-of-type(1) > section:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(2) > span")).getText());



                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        Thread.sleep(3000);

        System.out.println();
        System.out.println();
        driver.get("https://account.imqa.io/user/login");
        Thread.sleep(5000);
        프로젝트전체보기(driver);


        Thread.sleep(20000);
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


