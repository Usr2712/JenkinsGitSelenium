
package pages;


import CommonMethods.Common;
import CommonMethods.Constants;
import ConfigReader.ConfigSetup;
import ConfigReader.ExcelReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;


public class Launchpage {


    private Logger log;
    String AllertText;
    String ExpectedAllertMsg;
    ExcelReader reader = new ExcelReader();

    JavascriptExecutor js;

    public static List<String> BrokenLinks = new ArrayList<>();
    WebDriver localdriver;
    Wait<WebDriver> wait1;
    WebDriverWait Wait;
    Common common = new Common();


    ConfigSetup configSetup = new ConfigSetup();
    Properties usr = configSetup.propload();

    @FindBy(xpath = "//a[text()='Phones']")
    private WebElement PhonesTab;

    @FindBy(xpath = "//a[text()='Laptops']")
    private WebElement LaptopsTab;

    @FindBy(xpath = "//a[text()='Monitors']")
    private WebElement MonitorTab;


    @FindBy(xpath = "//a[text()='Samsung galaxy s6']")
    private WebElement Samsunggalaxys6;

    @FindBy(xpath = "//a[text()='Nokia lumia 1520']")
    private WebElement NokiaLumia1520;

    @FindBy(xpath = "//a[text()='Nexus 6']")
    private WebElement Nexus6;

    @FindBy(xpath = "//a[text()='Samsung galaxy s7']")
    private WebElement Samsunggalaxys7;

    @FindBy(xpath = "//a[text()='Iphone 6 32gb']")
    private WebElement Iphone6_32gnb;

    @FindBy(xpath = "//a[text()='Add to cart']")
    private WebElement AddToCart;

    @FindBy(xpath = "//a[text()='Cart']")
    private WebElement Cart;

    @FindBy(xpath = "//button[text()='Place Order']")
    private WebElement PlaceOrderbtn;

    @FindBy(xpath = "//input[@id='name']")
    private WebElement Name;

    @FindBy(xpath = "//input[@id='country']")
    private WebElement Country;

    @FindBy(xpath = "//input[@id='city']")
    private WebElement City;

    @FindBy(xpath = "//input[@id='card']")
    private WebElement CreditCard;

    @FindBy(xpath = "//input[@id='month']")
    private WebElement Month;

    @FindBy(xpath = "//input[@id='year']")
    private WebElement Year;

    @FindBy(xpath = "//button[text()='Purchase']")
    private WebElement PurchaseBtn;

    @FindBy(xpath = "//button[text()='OK']")
    private WebElement OkBtn;



    @FindBy(xpath = "//h2[text()='Thank you for your purchase!']")
    private WebElement ThanksMsg;


    public Launchpage(WebDriver driver) throws IOException, InvalidFormatException {
        this.localdriver = driver;
        PageFactory.initElements(driver, this);
        log = LogManager.getLogger(this.getClass().getName());
    }

    public void OpenPage() {
        Wait = new WebDriverWait(localdriver, 30);

        log.info("Page is opened");
        localdriver.get(usr.getProperty("url"));
        localdriver.manage().window().maximize();
        log.info("Windows maximized");



    }



    public void SelectPhoneBrand(String Brand) {

        if (Brand.equalsIgnoreCase("Samsung galaxy s6")) {
            Wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Samsung galaxy s6']")));
            common.DeviceName = Brand;
            System.out.println("Added Product is " + common.DeviceName);
            js = (JavascriptExecutor) localdriver;
            js.executeScript("arguments[0].scrollIntoView();", Samsunggalaxys6);
            Samsunggalaxys6.click();
        } else if (Brand.equalsIgnoreCase("Nokia lumia 1520")) {

            Wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Nexus 6']")));
            common.DeviceName = Brand;
            js = (JavascriptExecutor) localdriver;
            js.executeScript("arguments[0].scrollIntoView();", NokiaLumia1520);
            NokiaLumia1520.click();

        } else if (Brand.equalsIgnoreCase("Nexus 6")) {

            Wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Nexus 6']")));
            common.DeviceName = Brand;
            js = (JavascriptExecutor) localdriver;
            js.executeScript("arguments[0].scrollIntoView();", Nexus6);
            Nexus6.click();

        } else if (Brand.equalsIgnoreCase("Samsung galaxy s7")) {

            Wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Nexus 6']")));
            common.DeviceName = Brand;
            js = (JavascriptExecutor) localdriver;
            js.executeScript("arguments[0].scrollIntoView();", Samsunggalaxys7);
            Samsunggalaxys7.click();

        } else {

            Wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Nexus 6']")));
            common.DeviceName = Brand;
            js = (JavascriptExecutor) localdriver;
            js.executeScript("arguments[0].scrollIntoView();", Iphone6_32gnb);
            Iphone6_32gnb.click();


        }
    }

    public void addOrderTocart() {


        Wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Add to cart']")));
        AddToCart.click();

        if (Wait.until(ExpectedConditions.alertIsPresent()) == null) {

            System.out.println("alert was not present");
        } else {
            System.out.println("alert was present");
            localdriver.switchTo().alert().accept();
        }
        Cart.click();
    }

    public void CheckOrderInCart() {

        Wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@class='table table-bordered table-hover table-striped']//tr[1]//td[2]")));

        String ProductInCart = localdriver.findElement(By.xpath("//table[@class='table table-bordered table-hover table-striped']//tr[1]//td[2]")).getText();


        System.out.println("Cart product is " + ProductInCart);
        Assert.assertEquals(ProductInCart, common.DeviceName);

        PlaceOrderbtn.click();
    }


    public void EnterUserDetails() throws InterruptedException {


        wait1 = new FluentWait<>(localdriver)
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(TimeoutException.class);

        wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='name']")));
        Name.sendKeys("Test");
        Country.sendKeys("Test");
        City.sendKeys("Test");
        CreditCard.sendKeys("12345678");
        js.executeScript("arguments[0].scrollIntoView();", Month);
        Month.sendKeys("May");
        js.executeScript("arguments[0].scrollIntoView();", Year);
        Year.sendKeys("2024");


    }

    public void CompletePlacinOrder() {

        PurchaseBtn.click();
        ThanksMsgValidation();

        if (OkBtn.isDisplayed()) {

            OkBtn.click();


        } else {
            System.out.println("alert was present");
            AllertText = localdriver.switchTo().alert().getText();
            System.out.println("Allerttextinpopup is" + AllertText);
            localdriver.switchTo().alert().accept();

        }

    }

    public void ThanksMsgValidation() {

        String ThanksMessage = ThanksMsg.getText();
       System.out.println("Msg is "+ThanksMessage);

        Assert.assertEquals(ThanksMessage, "Thank you for your purchase!");
    }

    public void getCustomerDetailsFromExcel(String SheetName, Integer RowNumber) throws IOException, InvalidFormatException {


        List<Map<String, String>> testdata = reader.getData("C:\\Users\\DELL\\Sai\\Ecommerce_Testing\\src\\test\\resources\\Excel\\CustomerDetails.xlsx", SheetName);

        Name.sendKeys(testdata.get(RowNumber).get("Name"));
        Country.sendKeys(testdata.get(RowNumber).get("Country"));
        City.sendKeys(testdata.get(RowNumber).get("City"));
        CreditCard.sendKeys(testdata.get(RowNumber).get("Credit Card"));
        Month.sendKeys(testdata.get(RowNumber).get("Month"));
        Year.sendKeys(testdata.get(RowNumber).get("Year"));
        ExpectedAllertMsg = testdata.get(RowNumber).get("Error Message");
        System.out.println("Excelerrormsg" + ExpectedAllertMsg);

    }

    public void errorMsgValidation() {

        Assert.assertEquals(ExpectedAllertMsg, AllertText);


    }


    public void Verifylinks() throws IOException {


        List<String> totalLinks = new ArrayList<>();

        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet("Links");
        int Row = 1;
        sheet.createRow(0).createCell(0).setCellValue("Links");
        List<WebElement> AllLinks = localdriver.findElements(By.tagName("a"));
        System.out.println(AllLinks.size());

        for (WebElement e : AllLinks) {

            String Link = e.getAttribute("href");
            String BrokenLinks = VerifyBrokenLinks(Link);
            //totalLinks.add(e.getAttribute("href"));
            sheet.createRow(Row)
                    .createCell(0).setCellValue(BrokenLinks);
            Row++;


        }
        FileOutputStream fo = new FileOutputStream("C:\\Users\\DELL\\Sai\\Ecommerce_Testing\\src\\test\\resources\\Excel\\CustomerDetails.xlsx");
        wb.write(fo);
    }


    public String VerifyBrokenLinks(String Links) throws IOException {


        URL url = new URL(Links);

        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(5000);
        httpURLConnection.connect();

        if (httpURLConnection.getResponseCode() > +400) {

            System.out.println("Broken Url" + Links + httpURLConnection.getResponseCode());
        }

        return Links;
    }
}
