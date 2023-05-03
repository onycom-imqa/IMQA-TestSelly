package IMQA.dashboard.mpm;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class AlarmPolicy {

    private final WebDriver driver;



    public static void main(String[] args) throws Exception {
        System.out.println("Say Run");
        while (true) {
            try {
                new AlarmPolicy().run();
            } catch (Exception e) {

            }
        }
    }


    public AlarmPolicy() {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
//        option.addArguments("headless");
        driver = new ChromeDriver(option);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://account.imqa.io/user/login");

    }

    public void run() throws Exception {

        IMQA.DashBoard.ExcelRead.PoiReadExcel poiReadExcel = new IMQA.DashBoard.ExcelRead.PoiReadExcel();
        poiReadExcel.readExcelFile();
        String register_name = poiReadExcel.getRegisterName();

        WebElement idField = driver.findElement(By.cssSelector("html > body > div > div > div > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(2) > form > div:nth-of-type(1) > div:nth-of-type(1) > input"));
        idField.sendKeys("su10king@gmail.com");

        WebElement passwordField = driver.findElement(By.cssSelector("html > body > div > div > div > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(2) > form > div:nth-of-type(2) > div:nth-of-type(1) > input"));
        passwordField.sendKeys("sucheol9608!");

        WebElement loginButton = driver.findElement(By.cssSelector("button[class='submit']"));
        loginButton.click();


        WebElement goMpm = driver.findElement(By.cssSelector("html > body > div:nth-of-type(1) > div > div:nth-of-type(2) > div:nth-of-type(2) > table > tbody > tr:nth-of-type(1) > td:nth-of-type(2) > div"));
        goMpm.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


//            알람 등록
        WebElement AlarmButton = driver.findElement(By.cssSelector("html > body > div > div > header > div:nth-of-type(2) > div > ul > div:nth-of-type(6) > li"));
        AlarmButton.click();


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement AlarmPolicy = driver.findElement(By.cssSelector("a[class='out']"));
        AlarmPolicy.click();


        WebElement AddAlarm = driver.findElement(By.cssSelector("button[class='add-btn']"));
        AddAlarm.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        WebElement AlarmPolicyName = driver.findElement(By.cssSelector("input[class^='name-input']"));
        AlarmPolicyName.sendKeys("알림정책 등록");

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
        AlarmMemberSelect.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement AlarmSave = driver.findElement(By.cssSelector("button[class='submit']"));
        AlarmSave.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //알람 수정
        WebElement ModifyAlarm = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > table > tbody > tr > td:nth-of-type(2)"));
        ModifyAlarm.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        WebElement ModifyAlarmPolicyName2 = driver.findElement(By.cssSelector("input[class='name-input']"));
        ModifyAlarmPolicyName2.sendKeys(Keys.BACK_SPACE);
        ModifyAlarmPolicyName2.sendKeys(Keys.BACK_SPACE);
        ModifyAlarmPolicyName2.sendKeys(Keys.BACK_SPACE);
        ModifyAlarmPolicyName2.sendKeys(Keys.BACK_SPACE);
        ModifyAlarmPolicyName2.sendKeys(Keys.BACK_SPACE);
        ModifyAlarmPolicyName2.sendKeys(Keys.BACK_SPACE);
        ModifyAlarmPolicyName2.sendKeys(Keys.BACK_SPACE);
        ModifyAlarmPolicyName2.sendKeys(Keys.BACK_SPACE);
        ModifyAlarmPolicyName2.sendKeys(Keys.BACK_SPACE);
        ModifyAlarmPolicyName2.sendKeys(Keys.BACK_SPACE);
        ModifyAlarmPolicyName2.sendKeys(Keys.BACK_SPACE);
        ModifyAlarmPolicyName2.sendKeys(Keys.BACK_SPACE);
        ModifyAlarmPolicyName2.sendKeys(Keys.BACK_SPACE);
        ModifyAlarmPolicyName2.sendKeys(Keys.BACK_SPACE);
        ModifyAlarmPolicyName2.sendKeys(Keys.BACK_SPACE);
        ModifyAlarmPolicyName2.sendKeys(Keys.BACK_SPACE);
        ModifyAlarmPolicyName2.sendKeys(Keys.BACK_SPACE);
        ModifyAlarmPolicyName2.sendKeys(Keys.BACK_SPACE);
        ModifyAlarmPolicyName2.sendKeys(Keys.BACK_SPACE);
        ModifyAlarmPolicyName2.sendKeys(Keys.BACK_SPACE);
        ModifyAlarmPolicyName2.sendKeys(Keys.BACK_SPACE);
        ModifyAlarmPolicyName2.sendKeys(Keys.BACK_SPACE);



        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        ModifyAlarmPolicyName2.sendKeys("수정할 알림 제목");

        WebElement AlarmResponseTime = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > div > div:nth-of-type(3) > div:nth-of-type(3) > input"));
        AlarmResponseTime.clear();
        AlarmResponseTime.sendKeys("1");
        WebElement ModifyAlarmSave = driver.findElement(By.cssSelector("button[class='submit']"));
        ModifyAlarmSave.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

}
