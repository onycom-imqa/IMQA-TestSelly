package HaveToInToTheSelly;


import com.beust.jcommander.Parameterized;
import com.beust.jcommander.Parameters;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class ExcelTransfer {

    private static WebDriver webDriver;
    private String shell1;
    private String shell2;
    private String shell3;

    //Object의 field 명시하는 란


    @Parameters
    public static collection testData () throws Exception {
        InputStream spreadsheet = new
                FileInputStream("/Users/id_sucheol/Downloads");
        return new SpreadsheetData(spreadsheet).getData();
    }

    public void ExcelTransferData(String shell1, String shell2, String shell3){
        this.shell1 = shell1;
        this.shell2 = shell2;
        this.shell3 = shell3;
    }



    @BeforeClass
    public static void setUp() throws Exception {

        webDriver = new ChromeDriver();
        webDriver.get("htttp1234.html");  // mpm 링크 넣어주기
    }

    @Test
    public CharSequence testObj () throws Exception {
        try {
            WebElement sheet1 =
                    webDriver.findElement(By.name("sheet1"));
            sheet1.clear();

            if (!sheet1.equals("<Blank>")) {
                sheet1.sendKeys(this.testObj());
            } else {
                WebElement errorLabel =
                        webDriver.findElement(By.id("error"));
                assertEquals(this.shell2, errorLabel.getText());
            }
        } catch (Error error) {
            verificationErrors.append(error.toString());
        }
    }
        @AfterClass
        public static void  tearDown() throws Exception {
        webDriver.quit();

        String verificationErrorString = verificationError.toString();

        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}

