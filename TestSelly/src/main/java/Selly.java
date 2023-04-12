import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Locale;




public class Selly {
    private WebDriver driver;

    int projectScanIndex = 0;


    public static void main(String[] args) throws Exception {
        System.out.println("Say Run");
        while (true) {
            try {
                new Selly().run();
            } catch (Exception e) {

            }
        }

    }

    public Selly() {

        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
//        option.addArguments("headless");
        driver = new ChromeDriver(option);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://account.imqa.io/user/login");

    }

    public void run() throws Exception {

        WebElement idField = driver.findElement(By.cssSelector("html > body > div > div > div > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(2) > form > div:nth-of-type(1) > div:nth-of-type(1) > input"));
        idField.sendKeys("su10king@gmail.com");

        WebElement passwordField = driver.findElement(By.cssSelector("html > body > div > div > div > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(2) > form > div:nth-of-type(2) > div:nth-of-type(1) > input"));
        passwordField.sendKeys("sucheol9608");


        WebElement loginButton = driver.findElement(By.cssSelector("button[class='submit']"));
        loginButton.click();


        Thread.sleep(3000);

        WebElement cardViewButton = driver.findElement(By.cssSelector("html > body > div:nth-of-type(1) > div > div:nth-of-type(3) > div:nth-of-type(1) > span:nth-of-type(2) > a:nth-of-type(2)"));
        cardViewButton.click();
        Thread.sleep(3000);
        List<WebElement> projectList = driver.findElements(By.cssSelector("div > .project-view-card"));
        Integer projectSize = projectList.size();
        System.out.println("프로젝트 List " + projectSize);

        while (true) {
            try{

                for(int i = projectScanIndex; i < projectSize; i++) {
                    projectScanIndex = i;
//                    List<LayoutBlock> blocks = new ArrayList<>();

                    WebElement projectNameElement = driver.findElement(By.cssSelector(  "html > body > div:nth-of-type(1) > div > div:nth-of-type(3) > div:nth-of-type(" + (3 + i) + ") .project-card-title .text-title"));
                    WebElement mpmButton;

                    boolean isOnlyCrash = true;

                    try {
                        mpmButton = driver.findElement(By.cssSelector("html > body > div:nth-of-type(1) > div > div:nth-of-type(3) > div:nth-of-type(" + (3 + i) + ") > div > div:nth-of-type(1) > span:nth-of-type(3) > .btn.mpm.active"));

                        if (mpmButton == null) {
                            //is not mpm project

                            continue;
                        }

                        isOnlyCrash = false;
                    }catch (Exception e) {
                        //not found
                    }


                    String projectName = projectNameElement.getText();
                    System.out.println(getCurrentDateTime("yyyy-MM-dd HH:mm:ss"));
                    System.out.print("프로젝트명 : '" + projectName + "'  ");
                    String title = "프로젝트명 : `" + projectName + "`  ";

                    projectNameElement.click();
                    Thread.sleep(3000);

                    if(!isOnlyCrash) {
                        String userCount = driver.findElement(By.cssSelector("html > body > div:nth-of-type(1) > div > div:nth-of-type(1) > section > div > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(1) > div:nth-of-type(1) > div > div > div > div:nth-of-type(2) > div:nth-of-type(1) > p")).getText();
                        String runCount = driver.findElement(By.cssSelector("html > body > div:nth-of-type(1) > div > div:nth-of-type(1) > section > div > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(1) > div:nth-of-type(1) > div > div > div > div:nth-of-type(2) > div:nth-of-type(2) > p")).getText();
                        String plan = "유료 플랜";
                        try {
                            if ("무료 플랜".equals(driver.findElement(By.cssSelector("html > body > div > div > header > div:nth-of-type(3) > button")).getText())) {
                                plan = "무료 플랜";
                            }
                        }catch (Exception e) {}
                        System.out.println("`" + plan + "`");
//                        blocks.add(HeaderBlock.builder().text(PlainTextObject.builder().text(title + "`" + plan + "`").build()).build());
//                        blocks.add(DividerBlock.builder().build());
                        System.out.println("MPM");
//                        blocks.add(SectionBlock.builder().text(MarkdownTextObject.builder().text("*MPM*").build()).build());
                        switch (plan) {
                            case "유료 플랜":
                                String firstAppVersion =  driver.findElement(By.cssSelector("html > body > div > div > div:nth-of-type(1) > section > div > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(1) > div > button > span")).getText().toString();
                                System.out.println("    앱버전 : " + firstAppVersion);
                                System.out.println("        유저수 : " + userCount);
                                System.out.println("        실행수 : " + runCount);

//                                String fileName = 스크린샷(driver, projectName, "DashBoard");
//
//                                if(userCount.equals("0")) {
//                                    blocks.add(SectionBlock.builder().fields(Arrays.asList(
//                                            MarkdownTextObject.builder().text("*앱버전* : " + firstAppVersion).build(),
//                                            MarkdownTextObject.builder().text("*유저수* : " + userCount).build(),
//                                            MarkdownTextObject.builder().text("*실행수* : " + runCount).build()
//                                    )).accessory(ImageElement.builder().imageUrl(STORAGE_URL + fileName).altText(fileName).build()).build());
//                                } else {
//                                    blocks.add(SectionBlock.builder().fields(Arrays.asList(
//                                            MarkdownTextObject.builder().text("*앱버전* : " + firstAppVersion).build(),
//                                            MarkdownTextObject.builder().text("*유저수* : " + userCount).build(),
//                                            MarkdownTextObject.builder().text("*실행수* : " + runCount).build()
//                                    )).build());
//                                    blocks.add(ImageBlock.builder().imageUrl(STORAGE_URL + fileName).altText(fileName).title(PlainTextObject.builder().text(fileName).emoji(true).build()).build());
//                                }

                                Thread.sleep(1000);
                                List<WebElement> appVersionListElement = driver.findElements(By.cssSelector("html > body > div > div > div:nth-of-type(1) > section > div > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(1) > div > div > ul > li"));
                                for(int j = 1; j < appVersionListElement.size(); j++) {
                                    try {
                                        driver.findElement(By.cssSelector("html > body > div > div > div:nth-of-type(1) > section > div > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(1) > div > button")).click();
                                        Thread.sleep(1000);
                                        driver.findElement(By.cssSelector("html > body > div > div > div:nth-of-type(1) > section > div > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(1) > div > div > ul > li:nth-of-type(" + (j + 1) + ") > button")).click();
                                        Thread.sleep(2000);
                                        String appVersion = driver.findElement(By.cssSelector("html > body > div > div > div:nth-of-type(1) > section > div > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(1) > div > button > span")).getText().toString();
                                        System.out.println("    앱버전 : " + appVersion);
                                        Thread.sleep(2000);
                                        userCount = driver.findElement(By.cssSelector("html > body > div:nth-of-type(1) > div > div:nth-of-type(1) > section > div > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(1) > div:nth-of-type(1) > div > div > div > div:nth-of-type(2) > div:nth-of-type(1) > p")).getText();
                                        runCount = driver.findElement(By.cssSelector("html > body > div:nth-of-type(1) > div > div:nth-of-type(1) > section > div > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(1) > div:nth-of-type(1) > div > div > div > div:nth-of-type(2) > div:nth-of-type(2) > p")).getText();
                                        System.out.println("        유저수 : " + userCount);
                                        System.out.println("        실행수 : " + runCount);

//
//                                        fileName = 스크린샷(driver, projectName, "DashBoard");
//
//                                        if(userCount.equals("0")) {
//                                            blocks.add(SectionBlock.builder().fields(Arrays.asList(
//                                                    MarkdownTextObject.builder().text("*앱버전* : " + appVersion).build(),
//                                                    MarkdownTextObject.builder().text("*유저수* : " + userCount).build(),
//                                                    MarkdownTextObject.builder().text("*실행수* : " + runCount).build()
//                                            )).accessory(ImageElement.builder().imageUrl(STORAGE_URL + fileName).altText(fileName).build()).build());
//                                        } else {
//                                            blocks.add(SectionBlock.builder().fields(Arrays.asList(
//                                                    MarkdownTextObject.builder().text("*앱버전* : " + appVersion).build(),
//                                                    MarkdownTextObject.builder().text("*유저수* : " + userCount).build(),
//                                                    MarkdownTextObject.builder().text("*실행수* : " + runCount).build()
//                                            )).build());
//                                            blocks.add(ImageBlock.builder().imageUrl(STORAGE_URL + fileName).altText(fileName).title(PlainTextObject.builder().text(fileName).emoji(true).build()).build());
//                                        }

                                        Thread.sleep(1000);
                                    }catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }

                                break;
                            case "무료 플랜":
                                System.out.println("    유저수 : " + userCount);
                                System.out.println("    실행수 : " + runCount);
//
//                                fileName = 스크린샷(driver, projectName, "DashBoard");
//
//                                if(userCount.equals("0")) {
//                                    blocks.add(SectionBlock.builder().fields(Arrays.asList(
//                                            MarkdownTextObject.builder().text("*유저수* : " + userCount).build(),
//                                            MarkdownTextObject.builder().text("*실행수* : " + runCount).build()
//                                    )).accessory(ImageElement.builder().imageUrl(STORAGE_URL + fileName).altText(fileName).build()).build());
//                                } else {
//                                    blocks.add(SectionBlock.builder().fields(Arrays.asList(
//                                            MarkdownTextObject.builder().text("*유저수* : " + userCount).build(),
//                                            MarkdownTextObject.builder().text("*실행수* : " + runCount).build()
//                                    )).build());
//                                    blocks.add(ImageBlock.builder().imageUrl(STORAGE_URL + fileName).altText(fileName).title(PlainTextObject.builder().text(fileName).emoji(true).build()).build());
//                                }
//
//                                break;
                        }
                    } else {
//                        blocks.add(HeaderBlock.builder().text(PlainTextObject.builder().text(title).build()).build());
//                        blocks.add(DividerBlock.builder().build());
                    }


                    Thread.sleep(3000);
                    driver.get("https://account.imqa.io/user/login");
                    프로젝트전체보기(driver);
//                    blocks.add(DividerBlock.builder().build());
                    Thread.sleep(10000);
                    //crash
                    System.out.println("Crash");
//                    blocks.add((LayoutBlock) SectionBlock.builder().text(MarkdownTextObject.builder().text("*Crash*").build()).build());

                    WebElement crashButton = driver.findElement(By.cssSelector(     "html > body > div:nth-of-type(1) > div > div:nth-of-type(3) > div:nth-of-type(" + (3 + i) + ") > div > div:nth-of-type(1) > span:nth-of-type(3) > a:nth-of-type(2) > span"));
                    crashButton.click();
                    Thread.sleep(2000);
                    String firstAppVersion =  driver.findElement(By.cssSelector("html > body > section > section > section > div:nth-of-type(1) > section:nth-of-type(1) > button")).getText().toString();
                    System.out.println("    앱버전 : " + firstAppVersion);
                    System.out.println("        주간크래시 : " + driver.findElement(By.cssSelector("html > body > section > section > section > div:nth-of-type(1) > section:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(1) > div:nth-of-type(2) > span")).getText());
                    System.out.println("        주간이용자수 : " + driver.findElement(By.cssSelector("html > body > section > section > section > div:nth-of-type(1) > section:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > span")).getText());
                    System.out.println("        주간실행수 : " + driver.findElement(By.cssSelector("html > body > section > section > section > div:nth-of-type(1) > section:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(2) > span")).getText());
//                    String fileName = 스크린샷(driver, projectName, "Crash");
//                    if(driver.findElement(By.cssSelector("html > body > section > section > section > div:nth-of-type(1) > section:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(1) > div:nth-of-type(2) > span")).getText().equals("0") || driver.findElement(By.cssSelector("html > body > section > section > section > div:nth-of-type(1) > section:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(1) > div:nth-of-type(2) > span")).getText().equals("데이터가 없습니다.")) {
//                        blocks.add(SectionBlock.builder().fields(Arrays.asList(
//                                MarkdownTextObject.builder().text("*앱버전* : " + firstAppVersion).build(),
//                                MarkdownTextObject.builder().text("*주간크래시* : " + driver.findElement(By.cssSelector("html > body > section > section > section > div:nth-of-type(1) > section:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(1) > div:nth-of-type(2) > span")).getText()).build(),
//                                MarkdownTextObject.builder().text("*주간이용자수* : " + driver.findElement(By.cssSelector("html > body > section > section > section > div:nth-of-type(1) > section:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > span")).getText()).build(),
//                                MarkdownTextObject.builder().text("*주간실행수* : " + driver.findElement(By.cssSelector("html > body > section > section > section > div:nth-of-type(1) > section:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(2) > span")).getText()).build()
//                        )).accessory(ImageElement.builder().imageUrl(STORAGE_URL + fileName).altText(fileName).build()).build());
//                    } else {
//                        blocks.add(SectionBlock.builder().fields(Arrays.asList(
//                                MarkdownTextObject.builder().text("*앱버전* : " + firstAppVersion).build(),
//                                MarkdownTextObject.builder().text("*주간크래시* : " + driver.findElement(By.cssSelector("html > body > section > section > section > div:nth-of-type(1) > section:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(1) > div:nth-of-type(2) > span")).getText()).build(),
//                                MarkdownTextObject.builder().text("*주간이용자수* : " + driver.findElement(By.cssSelector("html > body > section > section > section > div:nth-of-type(1) > section:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > span")).getText()).build(),
//                                MarkdownTextObject.builder().text("*주간실행수* : " + driver.findElement(By.cssSelector("html > body > section > section > section > div:nth-of-type(1) > section:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(2) > span")).getText()).build()
//                        )).build());
//                        blocks.add(ImageBlock.builder().imageUrl(STORAGE_URL + fileName).altText(fileName).title(PlainTextObject.builder().text(fileName).emoji(true).build()).build());
//                    }



                    List<WebElement> appVersionListElement = driver.findElements(By.cssSelector("html > body > section > section > section > div:nth-of-type(1) > section:nth-of-type(1) > ul > li"));
                    for(int j = 1; j < appVersionListElement.size(); j++) {
                        try {
                            Thread.sleep(2000);
                            driver.findElement(By.cssSelector("html > body > section > section > section > div:nth-of-type(1) > section:nth-of-type(1) > button")).click();
                            Thread.sleep(1000);
                            String appVersion = driver.findElement(By.cssSelector("html > body > section > section > section > div:nth-of-type(1) > section:nth-of-type(1) > ul > li:nth-of-type(" + (j+1) +") > a")).getText();
                            driver.findElement(By.cssSelector("html > body > section > section > section > div:nth-of-type(1) > section:nth-of-type(1) > ul > li:nth-of-type(" + (j+1) +")")).click();
                            Thread.sleep(3000);
                            System.out.println("    앱버전 : " + appVersion);
                            System.out.println("        주간크래시 : " + driver.findElement(By.cssSelector("html > body > section > section > section > div:nth-of-type(1) > section:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(1) > div:nth-of-type(2) > span")).getText());
                            System.out.println("        주간이용자수 : " + driver.findElement(By.cssSelector("html > body > section > section > section > div:nth-of-type(1) > section:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > span")).getText());
                            System.out.println("        주간실행수 : " + driver.findElement(By.cssSelector("html > body > section > section > section > div:nth-of-type(1) > section:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(2) > span")).getText());

//                            fileName = 스크린샷(driver, projectName, "Crash");
//                            if(driver.findElement(By.cssSelector("html > body > section > section > section > div:nth-of-type(1) > section:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(1) > div:nth-of-type(2) > span")).getText().equals("0") || driver.findElement(By.cssSelector("html > body > section > section > section > div:nth-of-type(1) > section:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(1) > div:nth-of-type(2) > span")).getText().equals("데이터가 없습니다.")) {
//                                blocks.add(SectionBlock.builder().fields(Arrays.asList(
//                                        MarkdownTextObject.builder().text("*앱버전* : " + appVersion).build(),
//                                        MarkdownTextObject.builder().text("*주간크래시* : " + driver.findElement(By.cssSelector("html > body > section > section > section > div:nth-of-type(1) > section:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(1) > div:nth-of-type(2) > span")).getText()).build(),
//                                        MarkdownTextObject.builder().text("*주간이용자수* : " + driver.findElement(By.cssSelector("html > body > section > section > section > div:nth-of-type(1) > section:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > span")).getText()).build(),
//                                        MarkdownTextObject.builder().text("*주간실행수* : " + driver.findElement(By.cssSelector("html > body > section > section > section > div:nth-of-type(1) > section:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(2) > span")).getText()).build()
//                                )).accessory(ImageElement.builder().imageUrl(STORAGE_URL + fileName).altText(fileName).build()).build());
//                            } else {
//                                blocks.add(SectionBlock.builder().fields(Arrays.asList(
//                                        MarkdownTextObject.builder().text("*앱버전* : " + appVersion).build(),
//                                        MarkdownTextObject.builder().text("*주간크래시* : " + driver.findElement(By.cssSelector("html > body > section > section > section > div:nth-of-type(1) > section:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(1) > div:nth-of-type(2) > span")).getText()).build(),
//                                        MarkdownTextObject.builder().text("*주간이용자수* : " + driver.findElement(By.cssSelector("html > body > section > section > section > div:nth-of-type(1) > section:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > span")).getText()).build(),
//                                        MarkdownTextObject.builder().text("*주간실행수* : " + driver.findElement(By.cssSelector("html > body > section > section > section > div:nth-of-type(1) > section:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(2) > span")).getText()).build()
//                                )).build());
//                                blocks.add(ImageBlock.builder().imageUrl(STORAGE_URL + fileName).altText(fileName).title(PlainTextObject.builder().text(fileName).emoji(true).build()).build());
//                            }


                            Thread.sleep(2000);
                        }catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    Thread.sleep(3000);

                    System.out.println();
                    System.out.println();
                    driver.get("https://account.imqa.io/user/login");
                    Thread.sleep(5000);
                    프로젝트전체보기(driver);
//
//                    try {
//
//                        // Build a request object
//                        ChatPostMessageRequest request = ChatPostMessageRequest.builder()
//                                .channel("#saas_scanner")
//                                .blocks(blocks)
//                                .build();
//
//                        ChatPostMessageResponse response = methods.chatPostMessage(request);
//                        System.out.println(response.getMessage());
//                        System.err.println(response.getError());
//                        System.out.println(blocks.toString());
//                    }catch (Exception e) {
//
//                    }



                    Thread.sleep(20000);
                }
                projectScanIndex= 0;
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void 프로젝트전체보기(WebDriver driver) throws InterruptedException {
        WebElement cardViewButton = driver.findElement(By.cssSelector("html > body > div:nth-of-type(1) > div > div:nth-of-type(3) > div:nth-of-type(1) > span:nth-of-type(2) > a:nth-of-type(2)"));
        cardViewButton.click();
        Thread.sleep(3000);
        List<WebElement> projectList = driver.findElements(By.cssSelector("div > .project-view-card"));
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("ChannelIO('hideMessenger');");
    }


    private String 스크린샷(WebDriver driver , String projectName, String screenName) throws IOException {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String fileName = URLEncoder.encode(projectName.replaceAll(" ","") + "_" + screenName.replaceAll(" ",""),"UTF-8") + "_"  + getCurrentDateTime() + ".png";
        String filePath = "C:\\imqa\\" + fileName;
        File output =  new File(filePath);
        FileUtils.copyFile(file,output);
//        BlobContainerClient blobContainerClient

//        BlobClient blobClient = new BlobClientBuilder()
//                .connectionString("DefaultEndpointsProtocol=https;AccountName=imqawebviewagent;AccountKey=nAassg1FIE+X/THZG10Zcri1L3x27VINYqE1Hmeu7UMCFtTi2tit9IK4MTF7kzicYW9v/TE6Ce4pI+/CvCB7HA==;EndpointSuffix=core.windows.net")
//                .containerName("slack")
//                .blobName(fileName)
//                .buildClient();
//
////        BlobClient blobClient = blobContainerClient.getBlobClient( projectName + "_" + screenName + "_"  + getCurrentDateTime() + ".png");
//        blobClient.uploadFromFile(filePath);
        return  fileName;
    }

    private String getCurrentDateTime() {
        return getCurrentDateTime("yyyyMMddHHmmss");
    }

    private String getCurrentDateTime(String format) {
        Date today = new Date();
        Locale currentLocale = new Locale("KOREAN", "KOREA");
        String pattern = format; //hhmmss로 시간,분,초만 뽑기도 가능
        SimpleDateFormat formatter = new SimpleDateFormat(pattern,
                currentLocale);
        return formatter.format(today);
    }
}


