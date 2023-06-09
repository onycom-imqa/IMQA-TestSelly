package DashBoard.MPM;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;


@DisplayName("알림정책 등록수정 테스트")
public class AlarmPolicyTest {

    private WebDriver driver;
    public static String filePath = "/Users/id_sucheol/Downloads";
    public static String fileNm = "ExcelReadTest.xlsx";

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        }catch (NoSuchElementException e) {
            return false;
        }
    }

    public AlarmPolicyTest() {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
//        option.addArguments("headless");
        driver = new ChromeDriver(option);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://account.imqa.io/user/login");

    }


    @Test
    @DisplayName("알림정책 등록수정 테스트")
    public void run() throws InterruptedException {

        Row targetRow = null;
        try (FileInputStream file = new FileInputStream(new File(filePath, fileNm))) {

            // 엑셀 파일로 Workbook instance를 생성한다.
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            // workbook의 첫번째 sheet를 가저온다.
            XSSFSheet sheet = workbook.getSheetAt(0);


            // 모든 행(row)들을 조회한다.
            int rowIndex = -1;
            for (Row row : sheet) {
                boolean foundAlarmPolicy = false;
                boolean foundClick = false;
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    if (cell.getCellType() == CellType.STRING) {
                        String cellValue = cell.getStringCellValue();
                        if ("AlarmPolicyTest".equals(cellValue)) {
                            foundAlarmPolicy = true;
                        } else if ("Click".equals(cellValue)) {
                            foundClick = true;
                        }
                    }
                }
                if (foundAlarmPolicy && foundClick) {
                    rowIndex = row.getRowNum();
                    break;
                }
            }

            if (rowIndex != -1) {
                targetRow = sheet.getRow(rowIndex);
                for (Cell cell : targetRow) {
                    if (cell.getCellType() == CellType.STRING) {
                        String cellValue = cell.getStringCellValue();
                        System.out.print(cellValue + "\t");
                    }
                }
                System.out.println();
            } else {
                System.out.println("Target cell not found.");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String class_name = targetRow.getCell(0).getStringCellValue();
        //class_name은 생각해보니까 식별자라서 사용할 일이 없네요
        String register_name = targetRow.getCell(2).getStringCellValue();
        String modify_name = targetRow.getCell(4).getStringCellValue();



        WebElement idField = driver.findElement(By.cssSelector("html > body > div > div > div > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(2) > form > div:nth-of-type(1) > div:nth-of-type(1) > input"));
        idField.sendKeys("su10king@gmail.com");
        //devload@naver.com

        WebElement passwordField = driver.findElement(By.cssSelector("html > body > div > div > div > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(2) > form > div:nth-of-type(2) > div:nth-of-type(1) > input"));
        passwordField.sendKeys("sucheol9608!");


        WebElement loginButton = driver.findElement(By.cssSelector("button[class='submit']"));
        loginButton.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("MPM board");


        WebElement goMpm = driver.findElement(By.cssSelector("html > body > div:nth-of-type(1) > div > div:nth-of-type(2) > div:nth-of-type(2) > table > tbody > tr:nth-of-type(1) > td:nth-of-type(2) > div"));
        goMpm.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //        알람 등록
        WebElement AlarmButton = driver.findElement(By.cssSelector("html > body > div > div > header > div:nth-of-type(2) > div > ul > div:nth-of-type(6) > li"));
        AlarmButton.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement AlarmPolicy = driver.findElement(By.cssSelector("a[class='out']"));
        AlarmPolicy.click();


        WebElement AddAlarm = driver.findElement(By.cssSelector("button[class='add-btn']"));
        AddAlarm.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement AlarmPolicyName = driver.findElement(By.cssSelector("input[class^='name-input']"));
        AlarmPolicyName.sendKeys(register_name);
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
        if (isElementPresent(By.cssSelector("input[id='memberList0']"))) {
            WebElement FirstAlertEmail = driver.findElement(By.cssSelector("input[id='memberList0']"));
            if (FirstAlertEmail.isEnabled())
                AlarmMemberSelect.click();
            System.out.println("최소 한명 이상의 이메일이 존재합니다.");
        } else {
            fail("이메일이 없습니다.");
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        //알림 정책을 등록하기 전에 TitleField값을 확인합니다.
        WebElement AlarmSave = driver.findElement(By.cssSelector("button[class='submit']"));

        if (isElementPresent(By.cssSelector("input[class^='name-input']"))) {
            WebElement AlarmPolicyTitleCheck = driver.findElement(By.cssSelector("input[class^='name-input']"));
            if (AlarmPolicyTitleCheck.isEnabled())
                AlarmPolicyTitleCheck.click();
            AlarmSave.click();
            System.out.println("알람저장 버튼을 클릭했습니다.");
        } else {
            fail();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        WebElement AlarmSubmitCheck = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > table > tbody > tr > td:nth-of-type(1)"));
        if (isElementPresent(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > table > tbody > tr > td:nth-of-type(1)"))) {
            WebElement NewAlarmCheck = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > table > tbody > tr > td:nth-of-type(1)"));
            if (NewAlarmCheck.isEnabled()) ;
            System.out.println("알림 등록이 성공했습니다");
        } else {
            fail("등록 실패했습니다.");
        }
        AlarmSubmitCheck.getText();

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
        ModifyAlarmPolicyName2.sendKeys(Keys.BACK_SPACE);
        ModifyAlarmPolicyName2.sendKeys(Keys.BACK_SPACE);
        ModifyAlarmPolicyName2.sendKeys(Keys.BACK_SPACE);

        ModifyAlarmPolicyName2.sendKeys(modify_name);

        WebElement AlarmResponseTime = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > div > div:nth-of-type(4) > div:nth-of-type(3) > input"));
        AlarmResponseTime.clear();
        AlarmResponseTime.sendKeys("1");
        WebElement ModifyAlarmSave = driver.findElement(By.cssSelector("button[class='submit']"));
        ModifyAlarmSave.click();


        //todo 수정 확인
        WebElement AlarmModifyCheck = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > table > tbody > tr > td:nth-of-type(1)"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        if (isElementPresent(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > table > tbody > tr > td:nth-of-type(1)"))) {
            WebElement NewAlarmCheck = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > table > tbody > tr > td:nth-of-type(1)"));
            if (NewAlarmCheck.isDisplayed())
                assertEquals(modify_name, AlarmModifyCheck.getText());
            AlarmModifyCheck.getText();
            System.out.println("알림 수정이 성공했습니다");
        } else {
            fail("알림 수정을 실패했습니다.");
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


//        //알람 삭제
//        WebElement DeleteAlarm = driver.findElement(By.cssSelector("button[class='button']"));
//        DeleteAlarm.click();
//
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        Alert alert1 = driver.switchTo().alert();
//        alert1.accept();
//        System.out.println("삭제 확인버튼 누름");
//
//        WebElement AfterDeleteAlarm = driver.findElement(By.cssSelector("button[class='button']"));
//        if (isElementPresent(By.cssSelector("button[class='button']"))){
//            WebElement AfterDeleteCheck= driver.findElement(By.cssSelector("button[class='button']"));
//            if (!AfterDeleteCheck.isDisplayed())
//                AfterDeleteAlarm.getText();
//            System.out.println("알림 삭제가 성공했습니다");
//        }else {
//            fail("얼림 삭제를 실패했습니다.");
//        }


    }
}