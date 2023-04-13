package HaveToInToTheSelly;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.text.Style;

public class MpmStackTrace {


    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("https://mpm.imqa.io/mpm/342/dashboard");


        WebElement StaticClick = driver.findElement(By.className("none-a"));
        StaticClick.click();

        WebElement SelectStaticClick = driver.findElement(By.className("ctxt dis-block center"));
        SelectStaticClick.click();
        //todo errorline이 뜨지만.. 클래스명 동일합니다.

        WebElement P95Click = driver.findElement(By.className("hover_guide p95_guide active"));
        P95Click.click();

        WebElement OneCell = driver.findElement(By.className("cell"));
        OneCell.click();
        //next cell이 false일 때 까지 조회하려면...

        WebElement ReverseStack = driver.findElement(By.className("node"));
        System.out.println(ReverseStack.getText());

    }
}

