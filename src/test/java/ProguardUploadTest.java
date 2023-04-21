import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.fail;

public class ProguardUploadTest {


    private WebDriver driver;

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        }catch (NoSuchElementException e) {
            return false;
        }
    }

    public ProguardUploadTest() {
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

        //        //파일 업로드 테스트
        driver.get("https://account.imqa.io/user/login");

        WebElement idField = driver.findElement(By.cssSelector("html > body > div > div > div > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(2) > form > div:nth-of-type(1) > div:nth-of-type(1) > input"));
        idField.sendKeys("su10king@gmail.com");
        //devload@naver.com

        WebElement passwordField = driver.findElement(By.cssSelector("html > body > div > div > div > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(2) > form > div:nth-of-type(2) > div:nth-of-type(1) > input"));
        passwordField.sendKeys("sucheol9608!");


        WebElement loginButton = driver.findElement(By.cssSelector("button[class='submit']"));
        loginButton.click();

        WebElement MangeDropButton = driver.findElement(By.cssSelector("div[class='project-dropdown'] a[class='dropdown-toggle']"));
        MangeDropButton.click();

        WebElement ProguardSettingButton = driver.findElement(By.cssSelector("html > body > div:nth-of-type(1) > div > div:nth-of-type(2) > div:nth-of-type(2) > table > tbody > tr:nth-of-type(1) > td:nth-of-type(5) > div > div > ul > li:nth-of-type(2) > a"));
        ProguardSettingButton.click();


        WebElement ProguardSelectButton = driver.findElement(By.cssSelector("input[id='mapping-file-input']"));
        ProguardSelectButton.sendKeys("/Users/id_sucheol/Downloads/fragment-0410/2.0/testfile.txt");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        File file1 = new File("/Users/id_sucheol/Downloads/fragment-0410/2.0");
        String lastFolderName = file1.getName(); // "2.0"
        WebElement ProguardAppVersion = driver.findElement(By.cssSelector("input[class='version-input']"));
        ProguardAppVersion.sendKeys(lastFolderName);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);



        WebElement ProguardUploadButton = driver.findElement(By.cssSelector("button[class='submit']"));
        if (isElementPresent(By.cssSelector("button[class='submit']"))){
            WebElement FileSubmitButton = driver.findElement(By.cssSelector("button[class='submit']"));
            if (FileSubmitButton.isEnabled())
                System.out.println("프로가드 파일이 선택됐습니다. 등록버튼을 활성화합니다.");
        }else {
            fail("프로가드 매핑 파일 등록을 실패했습니다.");
        }

        ProguardUploadButton.click();
        try {
            Thread.sleep(3000);
            Alert alert1 = driver.switchTo().alert();
            alert1.accept();
            alert1.dismiss();
            Thread.sleep(3000);
        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }

        WebElement ProguardModalCancel = driver.findElement(By.cssSelector("div[class='modal-proguard-setting'] img"));
        ProguardModalCancel.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        System.out.println("1133");
        WebElement MangeDropButton2 = driver.findElement(By.cssSelector("div[class='project-dropdown'] a[class='dropdown-toggle']"));
        MangeDropButton2.click();

        System.out.println("1122");
        WebElement ProguardSettingButton2 = driver.findElement(By.cssSelector("html > body > div:nth-of-type(1) > div > div:nth-of-type(2) > div:nth-of-type(2) > table > tbody > tr:nth-of-type(1) > td:nth-of-type(5) > div > div > ul > li:nth-of-type(2) > a"));
        ProguardSettingButton2.click();


        Thread.sleep(3000);
        WebElement ProguardSubmitCheck = driver.findElement(By.cssSelector("html > body > div:nth-of-type(1) > div > div:nth-of-type(3) > div > div:nth-of-type(2) > div > table > tbody > tr > td:nth-of-type(1)"));
        if (isElementPresent(By.cssSelector("html > body > div:nth-of-type(1) > div > div:nth-of-type(3) > div > div:nth-of-type(2) > div > table > tbody > tr > td:nth-of-type(1)"))){
            WebElement FirstProguardFile = driver.findElement(By.cssSelector("html > body > div:nth-of-type(1) > div > div:nth-of-type(3) > div > div:nth-of-type(2) > div > table > tbody > tr > td:nth-of-type(1)"));
            if (FirstProguardFile.isDisplayed())
                System.out.println("매핑파일이 등록됐습니다.");
        }else {
            fail("프로가드 매핑 파일 등록을 실패했습니다.");
        }
        ProguardSubmitCheck.getText();


//



        // 파일 등록 됐는지 검증

    }
}