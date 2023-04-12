package HaveToInToTheSelly;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EachDashBoard {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
//        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("https://mpm.imqa.io/mpm/592/dashboard");
        driver.get("https://mpm.imqa.io/mpm/593/dashboard");
        driver.get("https://mpm.imqa.io/mpm/591/dashboard");
        driver.get("https://mpm.imqa.io/mpm/590/dashboard");




        WebElement userCountElement = driver.findElement(By.xpath("//h3[text()='총 사용자']/following-sibling::h4"));
        int userCount = Integer.parseInt(userCountElement.getAttribute("data-count"));

        WebElement usageCountElement = driver.findElement(By.xpath("//h3[text()='총 이용수']/following-sibling::h4"));
        int usageCount = Integer.parseInt(usageCountElement.getAttribute("data-count"));

        System.out.println("사용자수: " + userCount);
        System.out.println("이용수: " + usageCount);

//        driver.quit();


        //SaaS에서 전체 페이지가 아니라, Bike, Hy야쿠르트, cardoc만 조회하기 위한 코드


    }
}

