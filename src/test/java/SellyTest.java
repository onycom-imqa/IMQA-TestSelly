import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.AssertJUnit;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertEquals;

public class SellyTest {

        private WebDriver driver;

        private boolean isElementPresent(By by) {
            try {
                driver.findElement(by);
                return true;
            }catch (NoSuchElementException e) {
                return false;
            }
        }

    public SellyTest() {

        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
//        option.addArguments("headless");
        driver = new ChromeDriver(option);
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://account.imqa.io/user/login");

    }

        @Test
        public void main() {
        }



        @Test
        public void run() throws Exception {


            WebElement idField = driver.findElement(By.cssSelector("html > body > div > div > div > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(2) > form > div:nth-of-type(1) > div:nth-of-type(1) > input"));
            idField.sendKeys("su10king@gmail.com");
            //devload@naver.com

            WebElement passwordField = driver.findElement(By.cssSelector("html > body > div > div > div > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(2) > form > div:nth-of-type(2) > div:nth-of-type(1) > input"));
            passwordField.sendKeys("sucheol9608!");


            WebElement loginButton = driver.findElement(By.cssSelector("button[class='submit']"));
            loginButton.click();

            Thread.sleep(4000);





        Thread.sleep(3000);

        WebElement AppVersion = driver.findElement(By.cssSelector("html > body > div > div > div:nth-of-type(1) > section > div > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(1) > div > div > ul > li:nth-of-type(3) > button > span"));
        AppVersion.click();

        Thread.sleep(3000);

            System.out.println("MPM board");


            WebElement SummaryButton = driver.findElement(By.cssSelector("span[class$='center']"));
            SummaryButton.click();
            Thread.sleep(3000);


            WebElement SummaryClose = driver.findElement(By.cssSelector("img[style='cursor: pointer; position: absolute; top: 0px; left: 600px;']"));
            SummaryClose.click();
            Thread.sleep(2000);

//        알람 등록
            WebElement AlarmButton = driver.findElement(By.cssSelector("html > body > div > div > header > div:nth-of-type(2) > div > ul > div:nth-of-type(6) > li"));
            AlarmButton.click();

            Thread.sleep(3000);
            WebElement AlarmPolicy = driver.findElement(By.cssSelector("a[class='out']"));
            AlarmPolicy.click();


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
            WebElement AlarmMemberSelect = driver.findElement(By.cssSelector("label[for='allSelect']"));
            AlarmMemberSelect.click();
            Thread.sleep(3000);

            WebElement AlarmSave = driver.findElement(By.cssSelector("button[class='submit']"));
            AlarmSave.click();
            Thread.sleep(3000);


            //알람 수정
            WebElement ModifyAlarm = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > table > tbody > tr > td:nth-of-type(2)"));
            ModifyAlarm.click();
            Thread.sleep(3000);
//            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


            WebElement ModifyAlarmPolicyName2 = driver.findElement(By.cssSelector("input[class='name-input']"));
            WebElement ModifyAlarmPolicyName3 = driver.findElement(By.cssSelector("input[class='name-input']"));
            ModifyAlarmPolicyName3.clear();
            String expectedName = "테스트 알람 정책 수정됨";
            ModifyAlarmPolicyName2.sendKeys(expectedName);

            WebElement AlarmResponseTime = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > div > div:nth-of-type(3) > div:nth-of-type(3) > input"));
            AlarmResponseTime.clear();
            AlarmResponseTime.sendKeys("1");
            WebElement ModifyAlarmSave = driver.findElement(By.cssSelector("button[class='submit']"));
            ModifyAlarmSave.click();

            WebElement ModifyAlarmPolicyName2Updated = driver.findElement(By.cssSelector("input[class='name-input']"));
            String actualName = ModifyAlarmPolicyName2Updated.getAttribute("value");
            assertEquals(expectedName, actualName);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


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



//        앱 버전별 보고서 확인

            driver.get("https://account.imqa.io/user/login");

            WebElement goMpm1 = driver.findElement(By.cssSelector("html > body > div:nth-of-type(1) > div > div:nth-of-type(2) > div:nth-of-type(2) > table > tbody > tr:nth-of-type(1) > td:nth-of-type(2) > div"));
            goMpm1.click();
            Thread.sleep(3000);


            WebElement goReport = driver.findElement(By.cssSelector("html > body > div > div > header > div:nth-of-type(2) > div > ul > div:nth-of-type(5) > li > a > span"));
            goReport.click();
            Thread.sleep(5000);


        //AppVer1 (HY 프레딧 AOS 프로젝트 기준)
        WebElement AppVerDropBox = driver.findElement(By.cssSelector("button[class='version-dropdown-btn']"));
        AppVerDropBox.click();

        WebElement AppVerDroBoxSelect1 = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(1) > div:nth-of-type(3) > div:nth-of-type(2) > ul > li:nth-of-type(1) > button"));
            if (isElementPresent(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(1) > div:nth-of-type(3) > div:nth-of-type(2) > ul > li:nth-of-type(1) > button"))){
                WebElement AppVersionSelect = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(1) > div:nth-of-type(3) > div:nth-of-type(2) > ul > li:nth-of-type(1) > button"));
                if (!AppVersionSelect.isSelected())
                    AppVersionSelect.click();
                System.out.println("앱 버전 하나를 확인했습니다..");
            }else {
                AssertJUnit.fail("앱 버전이 없습니다");
            }

        WebElement ReportAppVerApplyButton = driver.findElement(By.cssSelector("button[class='version-apply-btn']"));
        ReportAppVerApplyButton.click();


            WebElement ReportElementConfirm = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(1) > table > tbody > tr > td:nth-of-type(2)"));
            if (isElementPresent(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(1) > table > tbody > tr > td:nth-of-type(2)"))){
                WebElement ReportEle1 = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(1) > table > tbody > tr > td:nth-of-type(2)"));
                if (ReportEle1.isEnabled())
                    ReportEle1.getText();

                System.out.println("네이티브 화면 로딩시간 확인");
            }else {
                AssertJUnit.fail("네이티브 화면 로딩시간 문제 발생");
            }
            ReportElementConfirm.getText();

            WebElement ReportElementConfirm2 = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(2) > table > tbody > tr > td:nth-of-type(2)"));
            if (isElementPresent(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(2) > table > tbody > tr > td:nth-of-type(2)"))){
                WebElement ReportEle2 = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(2) > table > tbody > tr > td:nth-of-type(2)"));
                if (ReportEle2.isEnabled())
                    ReportEle2.getText();
                System.out.println("웹뷰 화면 로딩시간 확인");
            }else {
                AssertJUnit.fail("웹뷰 화면 로딩시간 문제 발생");
            }
            ReportElementConfirm2.getText();


            WebElement ReportElementConfirm3 = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(3) > table > tbody > tr > td:nth-of-type(2)"));
            if (isElementPresent(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(3) > table > tbody > tr > td:nth-of-type(2)"))){
                WebElement ReportEle3 = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(3) > table > tbody > tr > td:nth-of-type(2)"));
                if (ReportEle3.isEnabled())
                    ReportEle3.getText();
                System.out.println("응답시간 확인");
            }else {
                AssertJUnit.fail("응답시간 문제 발생");
            }
            ReportElementConfirm3.getText();


            WebElement ReportElementConfirm4 = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(4) > table > tbody > tr > td:nth-of-type(2)"));
            if (isElementPresent(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(4) > table > tbody > tr > td:nth-of-type(2)"))){
                WebElement ReportEle4 = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(4) > table > tbody > tr > td:nth-of-type(2)"));
                if (ReportEle4.isEnabled())
                    ReportEle4.getText();
                System.out.println("CPU 사용량 확인");
            }else {
                AssertJUnit.fail("CPU 사용량 문제 확인");
            }
            ReportElementConfirm4.getText();

            WebElement ReportElementConfirm5 = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(5) > table > tbody > tr > td:nth-of-type(6)"));
            if (isElementPresent(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(5) > table > tbody > tr > td:nth-of-type(6)"))){
                WebElement ReportEle5 = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(5) > table > tbody > tr > td:nth-of-type(6)"));
                if (ReportEle5.isEnabled())
                    ReportEle5.getText();
                System.out.println("메모리 사용량 확인");
            }else {
                AssertJUnit.fail("메모리 사용량 문제 확인");
            }
            ReportElementConfirm5.getText();



        WebElement ReportFirstPage = driver.findElement(By.cssSelector("div[id='page1'] div[class='report-container']"));
        Thread.sleep(3000);

        File file=ReportFirstPage.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("app1logo.png"));
        Thread.sleep(4000);



        WebElement AppVerDropBox2 = driver.findElement(By.cssSelector("button[class='version-dropdown-btn']"));
        AppVerDropBox2.click();

        WebElement AppVerDroBoxSelect2 = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(1) > div:nth-of-type(3) > div:nth-of-type(2) > ul > li:nth-of-type(2) > button"));
            if (isElementPresent(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(1) > div:nth-of-type(3) > div:nth-of-type(2) > ul > li:nth-of-type(2) > button"))){
                WebElement AppVersionSelect2 = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(1) > div:nth-of-type(3) > div:nth-of-type(2) > ul > li:nth-of-type(2) > button"));
                if (!AppVersionSelect2.isSelected())
                    AppVersionSelect2.click();
                System.out.println("또 다른 앱버전을 확인했습니다..");
            }else {
                AssertJUnit.fail("두번째 앱 버전이 없습니다");
            }
        AppVerDroBoxSelect2.click();

        WebElement ReportAppVerApplyButton2 = driver.findElement(By.cssSelector("button[class='version-apply-btn']"));
        ReportAppVerApplyButton2.click();
        Thread.sleep(3000);

        WebElement ReportFirstPage2 = driver.findElement(By.cssSelector("div[id='page1'] div[class='report-container']"));
        Thread.sleep(3000);

        File file2 = ReportFirstPage2.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file2, new File("app2logo.png"));






        }
    }