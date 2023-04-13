package HaveToInToTheSelly;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class CrashDownloadTest {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("https://mpm.imqa.io/crash/592/dashboard");
        //원하는 crash 모듈로 진입

    WebElement DetailCrashButton = driver.findElement(By.className("text-center"));
    DetailCrashButton.click();
        //에러 상세 왼쪽 상단 중복 파라미터 중 최초 감지되는 것으로 진입

        WebElement CrashFileDownload = driver.findElement(By.id("stackDownloadButton"));
        CrashFileDownload.click(); //원본 파일 다운로드

        //파일 저장위치
        //   /Users/id_sucheol/Downloads

        //txt 파일과 기대결과 값 비교

        WebElement CrashEncodeTest = driver.findElement(By.className("table-text-ellipsis-1"));
        CrashEncodeTest.getText();
        System.out.println(CrashEncodeTest.getText());




   }
}



