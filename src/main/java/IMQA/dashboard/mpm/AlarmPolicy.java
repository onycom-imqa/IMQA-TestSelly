package IMQA.dashboard.mpm;

import com.common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class AlarmPolicy {

    private static WebDriver driver;
    private static Constant constant;

    public AlarmPolicy() {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
//        option.addArguments("headless");
        driver = new ChromeDriver(option);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://account.imqa.io/user/login");
    }

    private static void setLoginAccount() {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement idField = driver.findElement(By.cssSelector("html > body > div > div > div > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(2) > form > div:nth-of-type(1) > div:nth-of-type(1) > input"));
        idField.sendKeys("su10king@gmail.com");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement passwordField = driver.findElement(By.cssSelector("html > body > div > div > div > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(2) > form > div:nth-of-type(2) > div:nth-of-type(1) > input"));
        passwordField.sendKeys("sucheol9608!");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement loginButton = driver.findElement(By.cssSelector("button[class='submit']"));
        loginButton.click();

        WebElement goMpm = driver.findElement(By.cssSelector("html > body > div:nth-of-type(1) > div > div:nth-of-type(2) > div:nth-of-type(2) > table > tbody > tr:nth-of-type(1) > td:nth-of-type(2) > div"));
        goMpm.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    private static void setLogOut() {
        WebElement LogOutSideBar = driver.findElement(By.cssSelector("div[class='header-dropdown'] div[class='content']"));
        LogOutSideBar.click();

        WebElement LogOut = driver.findElement(By.cssSelector("html > body > div > div > header > div:nth-of-type(6) > div:nth-of-type(3) > ul > li:nth-of-type(4) > a > span"));
        LogOut.click();
    }

    public static boolean AlarmPolicy1 () {

        setLoginAccount();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement AlarmButton = driver.findElement(By.cssSelector("html > body > div > div > header > div:nth-of-type(2) > div > ul > div:nth-of-type(6) > li"));
        AlarmButton.click();


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement AlarmPolicy = driver.findElement(By.cssSelector("a[class='out']"));
        AlarmPolicy.click();


        WebElement AddAlarm = driver.findElement(By.cssSelector("button[class='add-btn']"));
        AddAlarm.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        WebElement AlarmPolicyName = driver.findElement(By.cssSelector("input[class^='name-input']"));
        AlarmPolicyName.sendKeys("알림정책01 크래시/ 실행수 변경");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement CrashRunCountButton = driver.findElement(By.cssSelector("label[class^='crash'] div[class='v-switch-core']"));
        CrashRunCountButton.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("로그아웃 타임아웃으로 실패했습니다.");
        }
        setLogOut();
        return true;
    }

    public static boolean AlarmPolicy2 () {

        setLoginAccount();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement AlarmButton = driver.findElement(By.cssSelector("html > body > div > div > header > div:nth-of-type(2) > div > ul > div:nth-of-type(6) > li"));
        AlarmButton.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement AlarmPolicy = driver.findElement(By.cssSelector("a[class='out']"));
        AlarmPolicy.click();

        WebElement AddAlarm = driver.findElement(By.cssSelector("button[class='add-btn']"));
        AddAlarm.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement AlarmPolicyName = driver.findElement(By.cssSelector("input[class^='name-input']"));
        AlarmPolicyName.sendKeys("알림정책02 네이티브 화면 로딩시간");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement AlarmNativeRendering = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > div > div:nth-of-type(2) > div:nth-of-type(3) > input"));
        AlarmNativeRendering.clear();
        AlarmNativeRendering.sendKeys("1");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("로그아웃 타임아웃으로 실패했습니다.");
        }
        setLogOut();
        return true;
    }

    public static boolean AlarmPolicy3 () {

        setLoginAccount();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement AlarmButton = driver.findElement(By.cssSelector("html > body > div > div > header > div:nth-of-type(2) > div > ul > div:nth-of-type(6) > li"));
        AlarmButton.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement AlarmPolicy = driver.findElement(By.cssSelector("a[class='out']"));
        AlarmPolicy.click();

        WebElement AddAlarm = driver.findElement(By.cssSelector("button[class='add-btn']"));
        AddAlarm.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement AlarmPolicyName = driver.findElement(By.cssSelector("input[class^='name-input']"));
        AlarmPolicyName.sendKeys("알림정책03 응답시간 변경");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement AlramResponse = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > div > div:nth-of-type(3) > div:nth-of-type(3) > input"));
        AlramResponse.clear();
        AlramResponse.sendKeys("1");

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
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("로그아웃 타임아웃으로 실패했습니다.");
        }
        setLogOut();
        return true;
    }

    public static boolean AlarmPolicy4 () {

        setLoginAccount();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement AlarmButton = driver.findElement(By.cssSelector("html > body > div > div > header > div:nth-of-type(2) > div > ul > div:nth-of-type(6) > li"));
        AlarmButton.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement AlarmPolicy = driver.findElement(By.cssSelector("a[class='out']"));
        AlarmPolicy.click();

        WebElement AddAlarm = driver.findElement(By.cssSelector("button[class='add-btn']"));
        AddAlarm.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement AlarmPolicyName = driver.findElement(By.cssSelector("input[class^='name-input']"));
        AlarmPolicyName.sendKeys("알림정책04 CPU 사용량 변경");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement AlarmCpuUsage = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > div > div:nth-of-type(4) > div:nth-of-type(3) > input"));
        AlarmCpuUsage.clear();
        AlarmCpuUsage.sendKeys("1");

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
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("로그아웃 타임아웃으로 실패했습니다.");
        }
        setLogOut();
        return true;
    }

    public static boolean AlarmPolicy5 () {

        setLoginAccount();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement AlarmButton = driver.findElement(By.cssSelector("html > body > div > div > header > div:nth-of-type(2) > div > ul > div:nth-of-type(6) > li"));
        AlarmButton.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement AlarmPolicy = driver.findElement(By.cssSelector("a[class='out']"));
        AlarmPolicy.click();

        WebElement AddAlarm = driver.findElement(By.cssSelector("button[class='add-btn']"));
        AddAlarm.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement AlarmPolicyName = driver.findElement(By.cssSelector("input[class^='name-input']"));
        AlarmPolicyName.sendKeys("알림정책05 메모리 사용량 변경");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement AlarmMemoryUsage = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > div > div:nth-of-type(5) > div:nth-of-type(3) > input"));
        AlarmMemoryUsage.clear();
        AlarmMemoryUsage.sendKeys("1");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

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
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("로그아웃 타임아웃으로 실패했습니다.");
        }
        setLogOut();
        return true;
    }


    public static boolean AlarmPolicy6 () {
            setLoginAccount();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            WebElement AlarmButton = driver.findElement(By.cssSelector("html > body > div > div > header > div:nth-of-type(2) > div > ul > div:nth-of-type(6) > li"));
            AlarmButton.click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            WebElement AlarmPolicy = driver.findElement(By.cssSelector("a[class='out']"));
            AlarmPolicy.click();

            WebElement AddAlarm = driver.findElement(By.cssSelector("button[class='add-btn']"));
            AddAlarm.click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            WebElement AlarmPolicyName = driver.findElement(By.cssSelector("input[class^='name-input']"));
            AlarmPolicyName.sendKeys("알림정책06 이메일, 브라우저 알림설정");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            WebElement AlarmMemoryUsage = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > div > div:nth-of-type(5) > div:nth-of-type(3) > input"));
            AlarmMemoryUsage.clear();
            AlarmMemoryUsage.sendKeys("1");

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            //경고알람을 메일로 받기 위해서 경고알림 수치를 낮춥니다.

            WebElement EmailSelect = driver.findElement(By.cssSelector("label[for='email-input']"));
            EmailSelect.click();

            WebElement BrowserAlarmSelect = driver.findElement(By.cssSelector("label[for='browser-input']"));
            BrowserAlarmSelect.click();

            WebElement AlarmMember = driver.findElement(By.cssSelector("button[class^='member']"));
            AlarmMember.click();

            WebElement AlarmMemberSelect = driver.findElement(By.cssSelector("label[for='allSelect']"));
            AlarmMemberSelect.click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            WebElement AlarmSave = driver.findElement(By.cssSelector("button[class='submit']"));
            AlarmSave.click();

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println("로그아웃 타임아웃으로 실패했습니다.");
            }
            setLogOut();
            return true;
        }

        public static boolean AlarmPolicy7 () {

            setLoginAccount();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            WebElement AlarmButton = driver.findElement(By.cssSelector("html > body > div > div > header > div:nth-of-type(2) > div > ul > div:nth-of-type(6) > li"));
            AlarmButton.click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            WebElement AlarmPolicy = driver.findElement(By.cssSelector("a[class='out']"));
            AlarmPolicy.click();

            WebElement AddAlarm = driver.findElement(By.cssSelector("button[class='add-btn']"));
            AddAlarm.click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            WebElement AlarmPolicyName = driver.findElement(By.cssSelector("input[class^='name-input']"));
            AlarmPolicyName.sendKeys("알림정책07 이메일 알림 수신자 설정");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            WebElement AlarmMemoryUsage = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > div > div:nth-of-type(5) > div:nth-of-type(3) > input"));
            AlarmMemoryUsage.clear();
            AlarmMemoryUsage.sendKeys("1");

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println("로그아웃 타임아웃으로 실패했습니다.");
            }
            setLogOut();
            return true;
        }
    }
