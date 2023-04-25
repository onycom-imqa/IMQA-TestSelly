package DashBoard.MPM;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class AlarmPolicy {

    private final WebDriver driver;

    public static String filePath = "/Users/id_sucheol/Downloads";
    public static String fileNm = "ExcelReadTest.xlsx";

    public static void main(String[] args) throws Exception {
        System.out.println("Say Run");
        while (true) {
            try {
                new AlarmPolicy().run();
            } catch (Exception e) {

            }
        }
    }


    public AlarmPolicy() {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
//        option.addArguments("headless");
        driver = new ChromeDriver(option);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://account.imqa.io/user/login");

    }

    public void run() throws Exception {

        Row targetRow = null;
        try (FileInputStream file = new FileInputStream(new File(filePath, fileNm))) {

            // 엑셀 파일로 Workbook instance를 생성한다.
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            // workbook의 첫번째 sheet를 가저온다.
            XSSFSheet sheet = workbook.getSheetAt(0);


            // 모든 행(row)들을 조회한다.
            int rowIndex = -1;
            for (Row row : sheet) {
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    if (cell.getCellType() == CellType.STRING) {
                        String cellValue = cell.getStringCellValue();
                        if ("AlarmPolicyTest".equals(cellValue)) {
                            rowIndex = row.getRowNum();
                            break;
                        }
                    }
                }
                if (rowIndex != -1) {
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
            } else {
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


        WebElement goMpm = driver.findElement(By.cssSelector("html > body > div:nth-of-type(1) > div > div:nth-of-type(2) > div:nth-of-type(2) > table > tbody > tr:nth-of-type(1) > td:nth-of-type(2) > div"));
        goMpm.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


//            알람 등록
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
        AlarmMemberSelect.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement AlarmSave = driver.findElement(By.cssSelector("button[class='submit']"));
        AlarmSave.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

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



        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        ModifyAlarmPolicyName2.sendKeys(modify_name);

        WebElement AlarmResponseTime = driver.findElement(By.cssSelector("html > body > div > div > section > div > div:nth-of-type(2) > div > div:nth-of-type(3) > div:nth-of-type(3) > input"));
        AlarmResponseTime.clear();
        AlarmResponseTime.sendKeys("1");
        WebElement ModifyAlarmSave = driver.findElement(By.cssSelector("button[class='submit']"));
        ModifyAlarmSave.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

}
