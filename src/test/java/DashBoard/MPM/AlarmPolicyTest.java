package DashBoard.MPM;

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.fail;


public class AlarmPolicyTest {

    private WebDriver driver;

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        }catch (NoSuchElementException e) {
            return false;
        }
    }

    public AlarmPolicyTest() {
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
    public void run() throws InterruptedException {

        WebElement idField = driver.findElement(By.cssSelector("html > body > div > div > div > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(2) > form > div:nth-of-type(1) > div:nth-of-type(1) > input"));
        idField.sendKeys("su10king@gmail.com");
        //devload@naver.com

        WebElement passwordField = driver.findElement(By.cssSelector("html > body > div > div > div > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(2) > form > div:nth-of-type(2) > div:nth-of-type(1) > input"));
        passwordField.sendKeys("sucheol9608!");


        WebElement loginButton = driver.findElement(By.cssSelector("button[class='submit']"));
        loginButton.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("MPM board");


        WebElement goMpm = driver.findElement(By.cssSelector("html > body > div:nth-of-type(1) > div > div:nth-of-type(2) > div:nth-of-type(2) > table > tbody > tr:nth-of-type(1) > td:nth-of-type(2) > div"));
        goMpm.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //        알람 등록
        WebElement AlarmButton = driver.findElement(By.cssSelector("html > body > div > div > header > div:nth-of-type(2) > div > ul > div:nth-of-type(6) > li"));
        AlarmButton.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement AlarmPolicy = driver.findElement(By.cssSelector("a[class='out']"));
        AlarmPolicy.click();


        WebElement AddAlarm = driver.findElement(By.cssSelector("button[class='add-btn']"));
        AddAlarm.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement AlarmPolicyName = driver.findElement(By.cssSelector("input[class^='name-input']"));
        AlarmPolicyName.sendKeys("테스트 알람 자동 생성");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement AlarmNativeRendering = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > div > div:nth-of-type(2) > div:nth-of-type(3) > input"));
        AlarmNativeRendering.clear();
        AlarmNativeRendering.sendKeys("1");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //경고알람을 메일로 받기 위해서 경고알림 수치를 낮춥니다.

        WebElement EmailSelect = driver.findElement(By.cssSelector("label[for='email-input']"));
        EmailSelect.click();
        WebElement AlarmMember = driver.findElement(By.cssSelector("button[class^='member']"));
        AlarmMember.click();
        WebElement AlarmMemberSelect = driver.findElement(By.cssSelector("label[for='allSelect']"));
        if (isElementPresent(By.cssSelector("input[id='memberList0']"))){
            WebElement FirstAlertEmail = driver.findElement(By.cssSelector("input[id='memberList0']"));
            if (FirstAlertEmail.isEnabled())
                AlarmMemberSelect.click();
            System.out.println("최소 한명 이상의 이메일이 존재합니다.");
        }else {
            fail("이메일이 없습니다.");
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement AlarmSubmitCheck = driver.findElement(By.cssSelector("input[id='memberList0']"));
        if (isElementPresent(By.cssSelector("section div[class='content']"))){
            WebElement NewAlarmCheck= driver.findElement(By.cssSelector("section div[class='content']"));
            if (NewAlarmCheck.isDisplayed())
                AlarmSubmitCheck.click();

        }else {
            fail("등록 실패했습니다.");
        }



        //알림 정책을 등록하기 전에 TitleField값을 확인합니다.
        WebElement AlarmSave = driver.findElement(By.cssSelector("button[class='submit']"));

        if (isElementPresent(By.cssSelector("input[class^='name-input']"))){
            WebElement AlarmPolicyTitleCheck = driver.findElement(By.cssSelector("input[class^='name-input']"));
            if (AlarmPolicyTitleCheck.isEnabled())
                AlarmPolicyTitleCheck.click();
            System.out.println("알림정책에 제목이 존재합니다");
            System.out.println("알림 등록이 성공했습니다");
        }else {
            fail("알림정책 제목이 없습니다");
        }

        AlarmSave.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        //알람 수정
        WebElement ModifyAlarm = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > table > tbody > tr > td:nth-of-type(2)"));
        ModifyAlarm.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        WebElement ModifyAlarmPolicyName2 = driver.findElement(By.cssSelector("input[class='name-input']"));
        ModifyAlarmPolicyName2.clear();
        ModifyAlarmPolicyName2.sendKeys("테스트 알람 정책 수정됨");

        WebElement AlarmResponseTime = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > div > div:nth-of-type(4) > div:nth-of-type(3) > input"));
        AlarmResponseTime.clear();
        AlarmResponseTime.sendKeys("1");
        WebElement ModifyAlarmSave = driver.findElement(By.cssSelector("button[class='submit']"));
        ModifyAlarmSave.click();



        //todo 수정 확인
        WebElement AlarmModifyCheck = driver.findElement(By.cssSelector("input[id='memberList0']"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        if (isElementPresent(By.cssSelector("section div[class='content']"))){
            WebElement NewAlarmCheck= driver.findElement(By.cssSelector("section div[class='content']"));
            if (NewAlarmCheck.isDisplayed())
                AlarmModifyCheck.getText();
            System.out.println("알림 수정이 성공했습니다");
        }else {
            fail("알림 수정을 실패했습니다.");
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        //알람 삭제
        WebElement DeleteAlarm = driver.findElement(By.cssSelector("button[class='button']"));
        DeleteAlarm.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Alert alert1 = driver.switchTo().alert();
        alert1.accept();
        System.out.println("삭제 확인버튼 누름");

        WebElement AfterDeleteAlarm = driver.findElement(By.cssSelector("button[class='button']"));
        if (isElementPresent(By.cssSelector("button[class='button']"))){
            WebElement AfterDeleteCheck= driver.findElement(By.cssSelector("button[class='button']"));
            if (!AfterDeleteCheck.isDisplayed())
                AfterDeleteAlarm.getText();
            System.out.println("알림 삭제가 성공했습니다");
        }else {
            fail("얼림 삭제를 실패했습니다.");
        }


    }
}