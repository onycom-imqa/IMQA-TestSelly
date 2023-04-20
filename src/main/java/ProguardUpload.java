import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ProguardUpload {

    private final WebDriver driver;

    public static void main(String[] args) throws Exception {
        System.out.println("Say Run");
        while (true) {
            try {
                new ProguardUpload().run();
            } catch (Exception e) {

            }
        }
    }


    public ProguardUpload() {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
//        option.addArguments("headless");
        driver = new ChromeDriver(option);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://account.imqa.io/user/login");

    }

    public void run() throws Exception{
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
        Thread.sleep(3000);

        File file1 = new File("/Users/id_sucheol/Downloads/fragment-0410/2.0");
        String lastFolderName = file1.getName(); // "2.0"
        WebElement ProguardAppVersion = driver.findElement(By.cssSelector("input[class='version-input']"));
        ProguardAppVersion.sendKeys(lastFolderName);

        Thread.sleep(2000);



        WebElement ProguardUploadButton = driver.findElement(By.cssSelector("button[class='submit']"));
        ProguardUploadButton.click();
        ProguardUploadButton.wait(3);


        Thread.sleep(3000);
        Alert alert1 = driver.switchTo().alert();
        alert1.accept();
        System.out.println("확인버튼 누름");
        Thread.sleep(3000);

        driver.get("https://account.imqa.io/user/login");
       }
}
