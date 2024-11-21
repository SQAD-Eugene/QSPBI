package Package_test_by_module_DPS;

import Package_Element_DPS.*;
import com.google.gson.Gson;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;

public class Tabulation_module {


    public static WebDriver driver;
    public static DataSet dataset;
    public static SoftAssert softAssert = new SoftAssert();


    @BeforeClass
    public void beforeClass() throws IOException {

        try{
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\USER\\Desktop\\Lagayan ng chrome driver\\chromedriver-win64\\chromedriver" + ".exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();

        }finally {
            if (driver == null) {
                try {
                    driver.quit();
                } catch (NullPointerException e) {
                    System.out.println("Driver is null. Unable to quit.");
                }
            }
        }
        //Chrome Browser
        //web link
        driver.get("https://qspbidev-dps-clone.psa.gov.ph/login");


        Gson gson = new Gson();
        Reader reader = Files.newBufferedReader(Paths.get("dataset.json"));
        dataset = gson.fromJson(reader, DataSet.class);

    }

    @Test(priority = 1, testName = "(Login) - Verify functionality of Email text box")
    public void test_textbox_email() throws InterruptedException {
        Login_module_elements login = new Login_module_elements(driver);
        login.txt_E_add.sendKeys(dataset.EMAIL);
    }

    @Test(priority = 2, testName = "(Login) - Verify functionality of Password text box")
    public void test_textbox_password() {
        Login_module_elements login = new Login_module_elements(driver);
        login.txt_Password.sendKeys(dataset.PW);
    }

    @Test(priority = 3, testName = "(Login) - Verify functionality of login button")
    public void test_button_login() {
        Login_module_elements login = new Login_module_elements(driver);
        login.btn_login.click();
    }
    @Test(priority = 4, testName = "(Configuration) - Verify functionality of Year dropdown box")
    public void test_dropdown_year() {
        Home_module_elements home = new Home_module_elements(driver);
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.elementToBeClickable(home.dropdown_Year));

        Select Yr = new Select(home.dropdown_Year);
        Yr.selectByIndex(1);
    }

    @Test(priority = 5, testName = "(Configuration) - Verify functionality of Quarter dropdown box")
    public void test_dropdown_quarter() {
        Home_module_elements home = new Home_module_elements(driver);
        Select Qr = new Select(home.dropdown_Quarter);
        Qr.selectByIndex(0);
    }

    @Test(priority = 6, testName = "(Configuration) - Verify functionality of OK button")
    public void test_button_OK() {
        Home_module_elements home = new Home_module_elements(driver);
        home.btn_OK.click();
    }

    @Test(priority = 7, testName = "(Tabulation) - Verify functionality of Tabulation Tab")
    public void test_Tab_Tabulation() {
        Tabulation_module_elements file = new Tabulation_module_elements(driver);
        try {
            WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
            eWait.until(ExpectedConditions.elementToBeClickable(Tabulation_module_elements.Tab_Tabulation));
            Tabulation_module_elements.Tab_Tabulation.click();
        } catch (StaleElementReferenceException e) {
            System.out.println("error "+ e);
        }
    }

    @Test(priority = 9, testName = "(Tabulation) - Verify functionality of Posting Sheets Radio button")
    public void test_Posting_Sheets(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Tabulation_module_elements.rad_posting_sheet));
        Tabulation_module_elements.rad_posting_sheet.click();

    }

    @Test(priority = 10, testName = "(Tabulation) - Verify functionality of Sector dropdown box")
    public void test_dropdown_sector() {
        Select St = new Select(Tabulation_module_elements.dd_sector);
        St.selectByIndex(0);
        St.selectByIndex(6);
        St.selectByIndex(10);
    }

    @Test(priority = 11, testName = "(Tabulation) - Verify functionality of Select table dropdown box")
    public void test_dropdown_select_table() {
        Select St = new Select(Tabulation_module_elements.dd_select_table);
        St.selectByIndex(0);
        St.selectByIndex(6);
        St.selectByIndex(10);
    }



    @Test(priority = 12, testName = "(Tabulation) - Verify functionality of Generate button")
    public void test_Generate(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Tabulation_module_elements.btn_Generate));
        Tabulation_module_elements.btn_Generate.click();

    }

    @Test(priority = 13, testName = "(Tabulation) - Verify functionality of Search text box")
    public void test_Search(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Tabulation_module_elements.txt_Search));
        Tabulation_module_elements.txt_Search.sendKeys("E36000");

    }


    @Test(priority = 14, testName = "(Tabulation) - Verify functionality of Retail Trade Data Radio button")
    public void test_Retail_Trade(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Tabulation_module_elements.rad_Retail_trade_data));
        Tabulation_module_elements.rad_Retail_trade_data.click();

    }

    @Test(priority = 15, testName = "(Tabulation) - Verify functionality of Generate button")
    public void test_Generate1(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Tabulation_module_elements.btn_Generate));
        Tabulation_module_elements.btn_Generate.click();

    }

    @Test(priority = 16, testName = "(Tabulation) - Verify functionality of BPM Table Radio button")
    public void test_BPM_Table(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Tabulation_module_elements.rad_BPM_table));
        Tabulation_module_elements.rad_BPM_table.click();

    }

    @Test(priority = 17, testName = "(Tabulation) - Verify functionality of Generate button")
    public void test_Generate2(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Tabulation_module_elements.btn_Generate));
        Tabulation_module_elements.btn_Generate.click();

    }

    @Test(priority = 18, testName = "(Tabulation) - Verify functionality of Search text box")
    public void test_Search2(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Tabulation_module_elements.txt_Search2));
        Tabulation_module_elements.txt_Search2.sendKeys("J62090");

    }

    @Test(priority = 19, testName = "(Tabulation) - Verify functionality of Compare posting sheets Radio button")
    public void test_Compare_Posting_sheet(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Tabulation_module_elements.rad_Compare_posting_sheets));
        Tabulation_module_elements.rad_Compare_posting_sheets.click();

    }
}
