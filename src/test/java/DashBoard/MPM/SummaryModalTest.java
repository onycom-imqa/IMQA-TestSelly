package DashBoard.MPM;


import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.fail;

@DisplayName("MPM 화면별 성능현황 화면카드 테스트")
public class SummaryModalTest {

    private WebDriver driver;

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        }catch (NoSuchElementException e) {
            return false;
        }
    }

    public SummaryModalTest() {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
//        option.addArguments("headless");
        driver = new ChromeDriver(option);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://account.imqa.io/user/login");

    }


    @Test
    @DisplayName("화면카드 데이터 수집여부 테스트")
    public void run() throws IOException {

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


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //      앱버전이 여러개일시
        WebElement DropBox = driver.findElement(By.cssSelector("html > body > div > div > div:nth-of-type(1) > section > div > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(1) > div > button"));
        if (isElementPresent(By.cssSelector("html > body > div > div > div:nth-of-type(1) > section > div > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(1) > div > button"))){
            WebElement AppVerDropBox = driver.findElement(By.cssSelector("html > body > div > div > div:nth-of-type(1) > section > div > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(1) > div > button"));
            if (AppVerDropBox.isSelected())
                DropBox.click();
            System.out.println("MPM 앱 버전 드롭박스 확인");
        }else {
            fail(
                    "웹버전이 하나인 프로젝트입니다. 앱버전 드롭박스가 없습니다.");
        }



        WebElement SummaryButton = driver.findElement(By.cssSelector("span[class$='center']"));
        SummaryButton.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        WebElement Card1 = driver.findElement(By.cssSelector("div[class='screen-table-content']"));
        if (isElementPresent(By.cssSelector("html > body > div > div > div:nth-of-type(3) > div > div:nth-of-type(3) > div:nth-of-type(2) > table > tbody > tr:nth-of-type(1) > td:nth-of-type(1) > span > span"))){
            WebElement ModalSM = driver.findElement(By.cssSelector("html > body > div > div > div:nth-of-type(3) > div > div:nth-of-type(3) > div:nth-of-type(2) > table > tbody > tr:nth-of-type(1) > td:nth-of-type(1) > span > span"));
            if (ModalSM.isDisplayed())
            System.out.println("화면카드가 하나 이상 있습니다.");
        }else {
            File file2 = Card1.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(file2, new File("DashBoardCard.png"));
        }



        WebElement SummaryClose = driver.findElement(By.cssSelector("img[style='cursor: pointer; position: absolute; top: 0px; left: 600px;']"));
        SummaryClose.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}