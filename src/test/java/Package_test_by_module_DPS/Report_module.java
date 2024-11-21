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

import static java.lang.Thread.sleep;

public class Report_module {


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
                    System.out.println("ChromeDriver is not updated");
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

    @Test(priority = 7, testName = "(Reports) - Verify functionality of Reports Tab")
    public void test_Tab_Reports() {
        Report_module_elements file = new Report_module_elements(driver);
        try {
            WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
            eWait.until(ExpectedConditions.elementToBeClickable(Report_module_elements.Tab_Reports));
            Report_module_elements.Tab_Reports.click();
        } catch (StaleElementReferenceException e) {
            System.out.println("error "+ e);
        }
    }

    @Test(priority = 8, testName = "(Reports) - Verify functionality of Category Dropdown")
    public void test_Category(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.Dropdown_Category));
        Select Sc = new Select(Report_module_elements.Dropdown_Category);
        Sc.selectByIndex(1);

    }

    @Test(priority = 9, testName = "(Reports) - Verify functionality of See Date button")
    public void test_See_date(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.btn_Date));
        Report_module_elements.btn_Date.click();


    }

    @Test(priority = 10, testName = "(Reports) - Verify functionality of Start Date selection")
    public void test_Start_date(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.d_start_date));
        Report_module_elements.d_start_date.click();


    }

    @Test(priority = 11,  testName = "(Reports) - Verify functionality of Start Date selection of specific date")
    public void test_Start_date_1(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.d_start_date_1));
        Report_module_elements.d_start_date_1.click();

    }

    @Test(priority = 12, testName = "(Reports) - Verify functionality of Date 15th selection")
    public void test_Select_date_15_days(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.d_15th_date));
        Report_module_elements.d_15th_date.click();

    }

    @Test(priority = 13,  testName = "(Reports) - Verify functionality of Date 15th selection of specific date")
    public void test_Select_date_14(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.d_15th_date_14));
        Report_module_elements.d_15th_date_14.click();

    }

    @Test(priority = 14, testName = "(Reports) - Verify functionality of Date 30th selection")
    public void test_Select_date_30_days(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.d_30th_date));
        Report_module_elements.d_30th_date.click();

    }

    @Test(priority = 15,  testName = "(Reports) - Verify functionality of Date 30th selection of specific date")
    public void test_Select_date_30(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.d_30th_date_30));
        Report_module_elements.d_30th_date_30.click();

    }

    @Test(priority = 16, testName = "(Reports) - Verify functionality of Date 60th selection")
    public void test_Select_date_60_days(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.d_60_date));
        Report_module_elements.d_60_date.click();

    }

    @Test(priority = 17,  testName = "(Reports) - Verify functionality of Date 60th selection of specific date")
    public void test_Select_date_29(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.d_60_date_30));
        Report_module_elements.d_60_date_30.click();

    }

    @Test(priority = 18, testName = "(Reports) - Verify functionality of Date 90th selection")
    public void test_Select_date_90_days(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.d_90_date));
        Report_module_elements.d_90_date.click();

    }

    @Test(priority = 19,  testName = "(Reports) - Verify functionality of Date 90th selection of specific date")
    public void test_Select_date_29_(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.d_90_date_29));
        Report_module_elements.d_90_date_29.click();

    }

    @Test(priority = 20, testName = "(Reports) - Verify functionality of Other specify text box")
    public void test_txt_Other_specify(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.txt_specify));
        Report_module_elements.txt_specify.clear();
        Report_module_elements.txt_specify.sendKeys("Sample BEYOND 90 DAYS");

    }

    @Test(priority = 21, testName = "(Reports) - Verify functionality of Other date")
    public void test_Select_date_Other_date(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.d_Other_date));
        Report_module_elements.d_Other_date.click();

    }

    @Test(priority = 22,  testName = "(Reports) - Verify functionality of Other date selection of specific date")
    public void test_Select_Other_date_28(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.d_Other_date_28));
        Report_module_elements.d_Other_date_28.click();

    }

    @Test(priority = 23, enabled = false, testName = "(Reports) - Verify functionality of Prev Year button")
    public void test_btn_Prev_year(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.btn_Prev_year));
        Report_module_elements.btn_Prev_year.click();

    }

    @Test(priority = 24, testName = "(Reports) - Verify functionality of Save date button")
    public void test_btn_Save_date(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.btn_Save_date));
        Report_module_elements.btn_Save_date.click();

    }

    @Test(priority = 25, testName = "(Reports) - Verify functionality of OK button")
    public void test_btn_OK(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.btn_OK));
        Report_module_elements.btn_OK.click();

    }


    @Test(priority = 26, testName = "(Reports) - Verify functionality of Q2 button")
    public void test_btn_Q2(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.btn_Q2));
        Report_module_elements.btn_Q2.click();

    }


    @Test(priority = 27, testName = "(Reports) - Verify functionality of Start Date selection")
    public void test_Start_date_Q2(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.d_start_date_Q2));
        Report_module_elements.d_start_date_Q2.click();


    }

    @Test(priority = 28,  testName = "(Reports) - Verify functionality of Start Date selection of specific date")
    public void test_Start_date_1_Q2(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.d_start_date_1_Q2));
        Report_module_elements.d_start_date_1_Q2.click();

    }

    @Test(priority = 29, testName = "(Reports) - Verify functionality of Date 15th selection")
    public void test_Select_date_15_days_Q2(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.d_15th_date_Q2));
        Report_module_elements.d_15th_date_Q2.click();

    }

    @Test(priority = 30,  testName = "(Reports) - Verify functionality of Date 15th selection of specific date")
    public void test_Select_date_14_Q2(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.d_15th_date_15_Q2));
        Report_module_elements.d_15th_date_15_Q2.click();

    }

    @Test(priority = 31, testName = "(Reports) - Verify functionality of Date 30th selection")
    public void test_Select_date_30_days_Q2(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.d_30th_date_Q2));
        Report_module_elements.d_30th_date_Q2.click();

    }

    @Test(priority = 32,  testName = "(Reports) - Verify functionality of Date 30th selection of specific date")
    public void test_Select_date_30_Q2(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.d_30th_date_30_Q2));
        Report_module_elements.d_30th_date_30_Q2.click();

    }

    @Test(priority = 33, testName = "(Reports) - Verify functionality of Date 60th selection")
    public void test_Select_date_60_days_Q2(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.d_60_date_Q2));
        Report_module_elements.d_60_date_Q2.click();

    }

    @Test(priority = 34,  testName = "(Reports) - Verify functionality of Date 60th selection of specific date")
    public void test_Select_date_29_Q2(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.d_60_date_30_Q2));
        Report_module_elements.d_60_date_30_Q2.click();

    }

    @Test(priority = 35, testName = "(Reports) - Verify functionality of Date 90th selection")
    public void test_Select_date_90_days_Q2(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.d_90_date_Q2));
        Report_module_elements.d_90_date_Q2.click();

    }

    @Test(priority = 36,  testName = "(Reports) - Verify functionality of Date 90th selection of specific date")
    public void test_Select_date_29__Q2(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.d_90_date_29_Q2));
        Report_module_elements.d_90_date_29_Q2.click();

    }

    @Test(priority = 37, testName = "(Reports) - Verify functionality of Other specify text box")
    public void test_txt_Other_specify_Q2(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.txt_specify_Q2));
        Report_module_elements.txt_specify_Q2.clear();
        Report_module_elements.txt_specify_Q2.sendKeys("Sample BEYOND 90 DAYS");

    }

    @Test(priority = 38, testName = "(Reports) - Verify functionality of Other date")
    public void test_Select_date_Other_date_Q2(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.d_Other_date_Q2));
        Report_module_elements.d_Other_date_Q2.click();

    }

    @Test(priority = 39,  testName = "(Reports) - Verify functionality of Other date selection of specific date")
    public void test_Select_Other_date_28_Q2(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.d_Other_date_3_Q2));
        Report_module_elements.d_Other_date_3_Q2.click();

    }

    @Test(priority = 40, enabled = false, testName = "(Reports) - Verify functionality of Prev Year button")
    public void test_btn_Prev_year_Q2(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.btn_Prev_year_Q2));
        Report_module_elements.btn_Prev_year_Q2.click();

    }

    @Test(priority = 41, testName = "(Reports) - Verify functionality of Save date button")
    public void test_btn_Save_date_Q2(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.btn_Save_date_Q2));
        Report_module_elements.btn_Save_date_Q2.click();

    }

    @Test(priority = 42, testName = "(Reports) - Verify functionality of OK button")
    public void test_btn_OK_Q2(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.btn_OK_Q2));
        Report_module_elements.btn_OK_Q2.click();

    }


    @Test(priority = 43, testName = "(Reports) - Verify functionality of Q4 button")
    public void test_btn_Q3(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.btn_Q3));
        Report_module_elements.btn_Q3.click();

    }


    @Test(priority = 44, testName = "(Reports) - Verify functionality of Start Date selection")
    public void test_Start_date_Q3(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.d_start_date_Q3));
        Report_module_elements.d_start_date_Q3.click();


    }

    @Test(priority = 45,  testName = "(Reports) - Verify functionality of Start Date selection of specific date")
    public void test_Start_date_1_Q3(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.d_start_date_1_Q3));
        Report_module_elements.d_start_date_1_Q3.click();

    }

    @Test(priority = 46, testName = "(Reports) - Verify functionality of Date 15th selection")
    public void test_Select_date_15_days_Q3(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.d_15th_date_Q3));
        Report_module_elements.d_15th_date_Q3.click();

    }

    @Test(priority = 47,  testName = "(Reports) - Verify functionality of Date 15th selection of specific date")
    public void test_Select_date_14_Q3(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.d_15th_date_15_Q3));
        Report_module_elements.d_15th_date_15_Q3.click();

    }

    @Test(priority = 48, testName = "(Reports) - Verify functionality of Date 30th selection")
    public void test_Select_date_30_days_Q3(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.d_30th_date_Q3));
        Report_module_elements.d_30th_date_Q3.click();

    }

    @Test(priority = 49,  testName = "(Reports) - Verify functionality of Date 30th selection of specific date")
    public void test_Select_date_30_Q3(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.d_30th_date_30_Q3));
        Report_module_elements.d_30th_date_30_Q3.click();

    }

    @Test(priority = 50, testName = "(Reports) - Verify functionality of Date 60th selection")
    public void test_Select_date_60_days_Q3(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.d_60_date_Q3));
        Report_module_elements.d_60_date_Q3.click();

    }

    @Test(priority = 51,  testName = "(Reports) - Verify functionality of Date 60th selection of specific date")
    public void test_Select_date_29_Q3(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.d_60_date_30_Q3));
        Report_module_elements.d_60_date_30_Q3.click();

    }

    @Test(priority = 52, testName = "(Reports) - Verify functionality of Date 90th selection")
    public void test_Select_date_90_days_Q3(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.d_90_date_Q3));
        Report_module_elements.d_90_date_Q3.click();

    }

    @Test(priority = 53,  testName = "(Reports) - Verify functionality of Date 90th selection of specific date")
    public void test_Select_date_29__Q3(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.d_90_date_29_Q3));
        Report_module_elements.d_90_date_29_Q3.click();

    }

    @Test(priority = 54, testName = "(Reports) - Verify functionality of Other specify text box")
    public void test_txt_Other_specify_Q3(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.txt_specify_Q3));
        Report_module_elements.txt_specify_Q3.clear();
        Report_module_elements.txt_specify_Q3.sendKeys("Sample BEYOND 90 DAYS");

    }

    @Test(priority = 55, testName = "(Reports) - Verify functionality of Other date")
    public void test_Select_date_Other_date_Q3(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.d_Other_date_Q3));
        Report_module_elements.d_Other_date_Q3.click();

    }

    @Test(priority = 56,  testName = "(Reports) - Verify functionality of Other date selection of specific date")
    public void test_Select_Other_date_28_Q3(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.d_Other_date_3_Q3));
        Report_module_elements.d_Other_date_3_Q3.click();

    }

    @Test(priority = 57, enabled = false, testName = "(Reports) - Verify functionality of Prev Year button")
    public void test_btn_Prev_year_Q3(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.btn_Prev_year_Q3));
        Report_module_elements.btn_Prev_year_Q3.click();

    }

    @Test(priority = 58, testName = "(Reports) - Verify functionality of Save date button")
    public void test_btn_Save_date_Q3(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.btn_Save_date_Q3));
        Report_module_elements.btn_Save_date_Q3.click();

    }

    @Test(priority = 59, testName = "(Reports) - Verify functionality of OK button")
    public void test_btn_OK_Q3(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.btn_OK_Q3));
        Report_module_elements.btn_OK_Q3.click();

    }



    @Test(priority = 60, testName = "(Reports) - Verify functionality of Q4 button")
    public void test_btn_Q4(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.btn_Q4));
        Report_module_elements.btn_Q4.click();

    }


    @Test(priority = 61, testName = "(Reports) - Verify functionality of Start Date selection")
    public void test_Start_date_Q4(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.d_start_date_Q4));
        Report_module_elements.d_start_date_Q4.click();


    }

    @Test(priority = 62,  testName = "(Reports) - Verify functionality of Start Date selection of specific date")
    public void test_Start_date_1_Q4(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.d_start_date_1_Q4));
        Report_module_elements.d_start_date_1_Q4.click();

    }

    @Test(priority = 63, testName = "(Reports) - Verify functionality of Date 15th selection")
    public void test_Select_date_15_days_Q4(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.d_15th_date_Q4));
        Report_module_elements.d_15th_date_Q4.click();

    }

    @Test(priority = 64,  testName = "(Reports) - Verify functionality of Date 15th selection of specific date")
    public void test_Select_date_14_Q4(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.d_15th_date_15_Q4));
        Report_module_elements.d_15th_date_15_Q4.click();

    }

    @Test(priority = 65, testName = "(Reports) - Verify functionality of Date 30th selection")
    public void test_Select_date_30_days_Q4(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.d_30th_date_Q4));
        Report_module_elements.d_30th_date_Q4.click();

    }

    @Test(priority = 66,  testName = "(Reports) - Verify functionality of Date 30th selection of specific date")
    public void test_Select_date_30_Q4(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.d_30th_date_30_Q4));
        Report_module_elements.d_30th_date_30_Q4.click();

    }

    @Test(priority = 67, testName = "(Reports) - Verify functionality of Date 60th selection")
    public void test_Select_date_60_days_Q4(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.d_60_date_Q4));
        Report_module_elements.d_60_date_Q4.click();

    }

    @Test(priority = 68,  testName = "(Reports) - Verify functionality of Date 60th selection of specific date")
    public void test_Select_date_29_Q4(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.d_60_date_30_Q4));
        Report_module_elements.d_60_date_30_Q4.click();

    }

    @Test(priority = 69, testName = "(Reports) - Verify functionality of Date 90th selection")
    public void test_Select_date_90_days_Q4(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.d_90_date_Q4));
        Report_module_elements.d_90_date_Q4.click();

    }

    @Test(priority = 70,  testName = "(Reports) - Verify functionality of Date 90th selection of specific date")
    public void test_Select_date_29__Q4(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.d_90_date_29_Q4));
        Report_module_elements.d_90_date_29_Q4.click();

    }

    @Test(priority = 71, testName = "(Reports) - Verify functionality of Other specify text box")
    public void test_txt_Other_specify_Q4(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.txt_specify_Q4));
        Report_module_elements.txt_specify_Q4.clear();
        Report_module_elements.txt_specify_Q4.sendKeys("Sample BEYOND 90 DAYS");

    }

    @Test(priority = 72, testName = "(Reports) - Verify functionality of Other date")
    public void test_Select_date_Other_date_Q4(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.d_Other_date_Q4));
        Report_module_elements.d_Other_date_Q4.click();

    }

    @Test(priority = 73,  testName = "(Reports) - Verify functionality of Other date selection of specific date")
    public void test_Select_Other_date_28_Q4(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.d_Other_date_3_Q4));
        Report_module_elements.d_Other_date_3_Q4.click();

    }

    @Test(priority = 74, enabled = false, testName = "(Reports) - Verify functionality of Prev Year button")
    public void test_btn_Prev_year_Q4(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.btn_Prev_year_Q4));
        Report_module_elements.btn_Prev_year_Q4.click();

    }

    @Test(priority = 75, testName = "(Reports) - Verify functionality of Save date button")
    public void test_btn_Save_date_Q4(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.btn_Save_date_Q4));
        Report_module_elements.btn_Save_date_Q4.click();

    }

    @Test(priority = 76, testName = "(Reports) - Verify functionality of OK button")
    public void test_btn_OK_Q4(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.btn_OK_Q4));
        Report_module_elements.btn_OK_Q4.click();

    }

    @Test(priority = 77, testName = "(Reports) - Verify functionality of Close button")
    public void test_btn_Close_Q4(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.btn_Close_Q4));
        Report_module_elements.btn_Close_Q4.click();

    }
    @Test(priority = 78, testName = "(Reports) - Verify functionality of Response Rate by Sector and by Submission (All Samples) Table")
    public void test_dropdown_Table_All_sample(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.dd_Table));
        Select Tb = new Select(Report_module_elements.dd_Table);
        Tb.selectByIndex(0);
        Report_module_elements.btn_generate.click();
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.txt_total));
        Report_module_elements.btn_show.click();
    }

    @Test(priority = 79, testName = "(Reports) - Verify functionality of Response Rate by Sector and by Submission (Priority Samples) Table")
    public void test_dropdown_Table_priority_sample(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.dd_Table));
        Select Tb = new Select(Report_module_elements.dd_Table);
        Tb.selectByIndex(1);
        Report_module_elements.btn_generate.click();
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.txt_total));
        Report_module_elements.btn_show.click();
    }


    @Test(priority = 80, testName = "(Reports) - Verify functionality of Response Rate by Province, by Submission, and by Workload (All Workload) Table")
    public void test_dropdown_Table_All_workload(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.dd_Table));
        Select Tb = new Select(Report_module_elements.dd_Table);
        Tb.selectByIndex(2);
        Report_module_elements.btn_generate.click();
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.txt_total));
        Report_module_elements.btn_show.click();
    }

    @Test(priority = 81, testName = "(Reports) - Verify functionality of Response Rate by Province, by Submission, and by Workload (Priority Workload) Table")
    public void test_dropdown_Table_Priority_workload(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.dd_Table));
        Select Tb = new Select(Report_module_elements.dd_Table);
        Tb.selectByIndex(3);
        Report_module_elements.btn_generate.click();
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.txt_total));
        Report_module_elements.btn_show.click();
    }


    @Test(priority = 82, testName = "(Reports) - Verify functionality of Response Rate by Province, by Submission, and by Sample (All Samples) Table")
    public void test_dropdown_Table_All_sample_Province(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.dd_Table));
        Select Tb = new Select(Report_module_elements.dd_Table);
        Tb.selectByIndex(4);
        Report_module_elements.btn_generate.click();
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.txt_total));
        Report_module_elements.btn_show.click();
    }

    @Test(priority = 83, testName = "(Reports) - Verify functionality of Response Rate by Province, by Submission, and by Sample (Priority Samples) Table")
    public void test_dropdown_Table_Priority_sample_Province(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.dd_Table));
        Select Tb = new Select(Report_module_elements.dd_Table);
        Tb.selectByIndex(5);
        Report_module_elements.btn_generate.click();
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.txt_total));
        Report_module_elements.btn_show.click();
    }

    @Test(priority = 84, testName = "(Reports) - Verify functionality of Online Response Rate by Sector and by Submission (All Samples) by Online Response Table")
    public void test_dropdown_Table_All_sample_Online(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.dd_Table));
        Select Ct = new Select(Report_module_elements.Dropdown_Category);
        Ct.selectByIndex(2);
        Select Tb = new Select(Report_module_elements.dd_Table);
        Tb.selectByIndex(0);
        Report_module_elements.btn_generate.click();
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.txt_total));
        Report_module_elements.btn_show.click();
    }

    @Test(priority = 85, testName = "(Reports) - Verify functionality of Online Response Rate by Sector and by Submission (Priority Samples) by Online Response Table")
    public void test_dropdown_Table_Priority_sample_Online(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.dd_Table));
        Select Ct = new Select(Report_module_elements.Dropdown_Category);
        Ct.selectByIndex(2);
        Select Tb = new Select(Report_module_elements.dd_Table);
        Tb.selectByIndex(1);
        Report_module_elements.btn_generate.click();
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.txt_total));
        Report_module_elements.btn_show.click();
    }

    @Test(priority = 86, testName = "(Reports) - Verify functionality of Online Response Rate by Province, by Submission, and by Workload (All Workload) by Online Response Table")
    public void test_dropdown_Table_All_workload_Online(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.dd_Table));
        Select Ct = new Select(Report_module_elements.Dropdown_Category);
        Ct.selectByIndex(2);
        Select Tb = new Select(Report_module_elements.dd_Table);
        Tb.selectByIndex(2);
        Report_module_elements.btn_generate.click();
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.txt_total));
        Report_module_elements.btn_show.click();
    }

    @Test(priority = 87, testName = "(Reports) - Verify functionality of Online Response Rate by Province, by Submission, and by Workload (Priority Workload) by Online Response Table")
    public void test_dropdown_Table_Priority_workload_Online(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.dd_Table));
        Select Ct = new Select(Report_module_elements.Dropdown_Category);
        Ct.selectByIndex(2);
        Select Tb = new Select(Report_module_elements.dd_Table);
        Tb.selectByIndex(3);
        Report_module_elements.btn_generate.click();
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.txt_total));
        Report_module_elements.btn_show.click();
    }

    @Test(priority = 88, testName = "(Reports) - Verify functionality of Online Response Rate by Province, by Submission, and by Sample (All Samples) by Online Response Table")
    public void test_dropdown_Table_All_sample_Online_Province(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.dd_Table));
        Select Ct = new Select(Report_module_elements.Dropdown_Category);
        Ct.selectByIndex(2);
        Select Tb = new Select(Report_module_elements.dd_Table);
        Tb.selectByIndex(4);
        Report_module_elements.btn_generate.click();
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.txt_total));
        Report_module_elements.btn_show.click();
    }


    @Test(priority = 89, testName = "(Reports) - Verify functionality of Online Response Rate by Province, by Submission, and by Sample (Priority Samples) by Online Response Table")
    public void test_dropdown_Table_Priority_sample_Online_Province(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.dd_Table));
        Select Ct = new Select(Report_module_elements.Dropdown_Category);
        Ct.selectByIndex(2);
        Select Tb = new Select(Report_module_elements.dd_Table);
        Tb.selectByIndex(5);
        Report_module_elements.btn_generate.click();
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.txt_total));
        Report_module_elements.btn_show.click();
    }

    @Test(priority = 90, testName = "(Reports) - Verify functionality of by Status and by Sector (All Samples) By Questionnaire Table")
    public void test_dropdown_Table_All_sample_By_questionnaire() throws InterruptedException {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.dd_Table));
        Select Ct = new Select(Report_module_elements.Dropdown_Category);
        Ct.selectByIndex(3);
        sleep(2000);
        //Report_module_elements.dd_ECN.sendKeys("0010100013096G2");
        Select Tb = new Select(Report_module_elements.dd_Table);
        Tb.selectByIndex(0);
        Report_module_elements.btn_generate.click();
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.txt_total1));
        Report_module_elements.btn_show.click();
    }

    @Test(priority = 91, testName = "(Reports) - Verify functionality of by Status and by Sector (Priority Samples) By Questionnaire Table")
    public void test_dropdown_Table_Priority_sample_By_questionnaire() throws InterruptedException {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.dd_Table));
        Select Ct = new Select(Report_module_elements.Dropdown_Category);
        Ct.selectByIndex(3);
        //eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.dd_ECN));
        // Report_module_elements.dd_ECN.sendKeys("0010100013096G2");
        Select Tb = new Select(Report_module_elements.dd_Table);
        Tb.selectByIndex(1);
        Report_module_elements.btn_generate.click();
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.txt_total1));
        Report_module_elements.btn_show.click();
    }

    @Test(priority = 92, testName = "(Reports) - Verify functionality of by Status, by Province and by Workload (All Workload) By Questionnaire Table")
    public void test_dropdown_Table_All_workload_By_questionnaire() throws InterruptedException {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.dd_Table));
        Select Ct = new Select(Report_module_elements.Dropdown_Category);
        Ct.selectByIndex(3);
       //eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.dd_ECN));
       // Report_module_elements.dd_ECN.sendKeys("0010100013096G2");
        Select Tb = new Select(Report_module_elements.dd_Table);
        Tb.selectByIndex(2);
        Report_module_elements.btn_generate.click();
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.txt_total1));
        Report_module_elements.btn_show.click();
    }

    @Test(priority = 93, testName = "(Reports) - Verify functionality of by Status, by Province, and by Sample (All Samples) By Questionnaire Table")
    public void test_dropdown_Table_Priority_workload_By_questionnaire() throws InterruptedException {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.dd_Table));
        Select Ct = new Select(Report_module_elements.Dropdown_Category);
        Ct.selectByIndex(3);
        //eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.dd_ECN));
       // Report_module_elements.dd_ECN.sendKeys("0010100013096G2");
        Select Tb = new Select(Report_module_elements.dd_Table);
        Tb.selectByIndex(3);
        Report_module_elements.btn_generate.click();
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.txt_total1));
        Report_module_elements.btn_show.click();
    }

    @Test(priority = 94, testName = "(Reports) - Verify functionality of by Status, by Province and by Workload (Priority Workload) By Questionnaire Table")
    public void test_dropdown_Table_All_sample_By_questionnaire_Province() throws InterruptedException {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.dd_Table));
        Select Ct = new Select(Report_module_elements.Dropdown_Category);
        Ct.selectByIndex(3);
        //eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.dd_ECN));
        //Report_module_elements.dd_ECN.sendKeys("0010100013096G2");
        Select Tb = new Select(Report_module_elements.dd_Table);
        Tb.selectByIndex(4);
        Report_module_elements.btn_generate.click();
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.txt_total1));
        Report_module_elements.btn_show.click();
    }


    @Test(priority = 95, testName = "(Reports) - Verify functionality of  by Status, by Province, and by Sample (Priority Samples) By Questionnaire Table")
    public void test_dropdown_Table_Priority_sample_By_questionnaire_Province() throws InterruptedException {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.dd_Table));
        Select Ct = new Select(Report_module_elements.Dropdown_Category);
        Ct.selectByIndex(3);
        //eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.dd_ECN));
        //Report_module_elements.dd_ECN.sendKeys("0010100013096G2");
        Select Tb = new Select(Report_module_elements.dd_Table);
        Tb.selectByIndex(4);
        Report_module_elements.btn_generate.click();
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.txt_total1));
        Report_module_elements.btn_show.click();
    }


    @Test(priority = 96, testName = "(Reports) - Verify functionality of by Status and by Sector (All Samples) By Response Rate and Distribution(Online Response Rate) Table")
    public void test_dropdown_Table_All_sample_By_distribution_online() throws InterruptedException {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.dd_Table));
        Select Ct = new Select(Report_module_elements.Dropdown_Category);
        Ct.selectByIndex(4);
        sleep(2000);
        //Report_module_elements.dd_ECN.sendKeys("0010100013096G2");
        Select Tb = new Select(Report_module_elements.dd_Table);
        Tb.selectByIndex(0);
        Report_module_elements.btn_generate.click();
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.txt_total2));
        Report_module_elements.btn_show.click();
    }

    @Test(priority = 97, testName = "(Reports) - Verify functionality of by Status and by Sector (Priority Samples) By Response Rate and Distribution(Online Response Rate) Table")
    public void test_dropdown_Table_Priority_sample_By_distribution_online() throws InterruptedException {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.dd_Table));
        Select Ct = new Select(Report_module_elements.Dropdown_Category);
        Ct.selectByIndex(5);
        //eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.dd_ECN));
        // Report_module_elements.dd_ECN.sendKeys("0010100013096G2");
        Select Tb = new Select(Report_module_elements.dd_Table);
        Tb.selectByIndex(1);
        Report_module_elements.btn_generate.click();
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.txt_total2));
        Report_module_elements.btn_show.click();
    }

    @Test(priority = 98, testName = "(Reports) - Verify functionality of by Status, by Province and by Workload (All Workload) By Response Rate and Distribution(Online Response Rate) Table")
    public void test_dropdown_Table_All_workload_By_distribution_Province_online() throws InterruptedException {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.dd_Table));
        Select Ct = new Select(Report_module_elements.Dropdown_Category);
        Ct.selectByIndex(4);
        //eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.dd_ECN));
        // Report_module_elements.dd_ECN.sendKeys("0010100013096G2");
        Select Tb = new Select(Report_module_elements.dd_Table);
        Tb.selectByIndex(2);
        Report_module_elements.btn_generate.click();
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.txt_total2));
        Report_module_elements.btn_show.click();
    }

    @Test(priority = 99, testName = "(Reports) - Verify functionality of by Status, by Province, and by Sample (All Samples) By Response Rate and Distribution(Online Response Rate) Table")
    public void test_dropdown_Table_Priority_workload_By_distribution_Province_online() throws InterruptedException {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.dd_Table));
        Select Ct = new Select(Report_module_elements.Dropdown_Category);
        Ct.selectByIndex(4);
        //eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.dd_ECN));
        // Report_module_elements.dd_ECN.sendKeys("0010100013096G2");
        Select Tb = new Select(Report_module_elements.dd_Table);
        Tb.selectByIndex(3);
        Report_module_elements.btn_generate.click();
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.txt_total2));
        Report_module_elements.btn_show.click();
    }

    @Test(priority = 100, testName = "(Reports) - Verify functionality of by Status, by Province and by Workload (Priority Workload) By Response Rate and Distribution(Online Response Rate) Table")
    public void test_dropdown_Table_All_sample_By_distribution_Province_online() throws InterruptedException {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.dd_Table));
        Select Ct = new Select(Report_module_elements.Dropdown_Category);
        Ct.selectByIndex(4);
        //eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.dd_ECN));
        //Report_module_elements.dd_ECN.sendKeys("0010100013096G2");
        Select Tb = new Select(Report_module_elements.dd_Table);
        Tb.selectByIndex(4);
        Report_module_elements.btn_generate.click();
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.txt_total2));
        Report_module_elements.btn_show.click();
    }


    @Test(priority = 101, testName = "(Reports) - Verify functionality of  by Status, by Province, and by Sample (Priority Samples) By Response Rate and Distribution(Online Response Rate) Table")
    public void test_dropdown_Table_Priority_sample_By_distribution_Province_online() throws InterruptedException {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.dd_Table));
        Select Ct = new Select(Report_module_elements.Dropdown_Category);
        Ct.selectByIndex(4);
        //eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.dd_ECN));
        //Report_module_elements.dd_ECN.sendKeys("0010100013096G2");
        Select Tb = new Select(Report_module_elements.dd_Table);
        Tb.selectByIndex(5);
        Report_module_elements.btn_generate.click();
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.txt_total2));
        Report_module_elements.btn_show.click();
    }

    @Test(priority = 102, testName = "(Reports) - Verify functionality of Number and Response Rate of Received Questionnaire/Data Files by Sector and by Submission (All Samples) By Response Rate and Distribution Table")
    public void test_dropdown_Table_All_sample_By_distribution() throws InterruptedException {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.dd_Table));
        Select Ct = new Select(Report_module_elements.Dropdown_Category);
        Ct.selectByIndex(5);
        sleep(2000);
        //Report_module_elements.dd_ECN.sendKeys("0010100013096G2");
        Select Tb = new Select(Report_module_elements.dd_Table);
        Tb.selectByIndex(0);
        Report_module_elements.btn_generate.click();
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.txt_total2));
        Report_module_elements.btn_show.click();
    }

    @Test(priority = 103, testName = "(Reports) - Verify functionality of Number and Response Rate of Received Questionnaire/Data Files by Sector and by Submission (Priority Samples) By Response Rate and Distribution Table")
    public void test_dropdown_Table_Priority_sample_By_distribution() throws InterruptedException {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.dd_Table));
        Select Ct = new Select(Report_module_elements.Dropdown_Category);
        Ct.selectByIndex(5);
        //eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.dd_ECN));
        // Report_module_elements.dd_ECN.sendKeys("0010100013096G2");
        Select Tb = new Select(Report_module_elements.dd_Table);
        Tb.selectByIndex(1);
        Report_module_elements.btn_generate.click();
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.txt_total2));
        Report_module_elements.btn_show.click();
    }

    @Test(priority = 104, testName = "(Reports) - Verify functionality of Number and Response Rate of Received Questionnaire/Data Files by Province, by Submission and by Workload (All Workload) and Distribution Table")
    public void test_dropdown_Table_All_workload_By_distribution_Province() throws InterruptedException {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.dd_Table));
        Select Ct = new Select(Report_module_elements.Dropdown_Category);
        Ct.selectByIndex(5);
        //eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.dd_ECN));
        // Report_module_elements.dd_ECN.sendKeys("0010100013096G2");
        Select Tb = new Select(Report_module_elements.dd_Table);
        Tb.selectByIndex(2);
        Report_module_elements.btn_generate.click();
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.txt_total2));
        Report_module_elements.btn_show.click();
    }

    @Test(priority = 105, testName = "(Reports) - Verify functionality of Number and Response Rate of Received Questionnaire/Data Files by Province, by Submission and by Workload (Priority Workload) By Response Rate and Distribution Table")
    public void test_dropdown_Table_Priority_workload_By_distribution_Province() throws InterruptedException {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.dd_Table));
        Select Ct = new Select(Report_module_elements.Dropdown_Category);
        Ct.selectByIndex(5);
        //eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.dd_ECN));
        // Report_module_elements.dd_ECN.sendKeys("0010100013096G2");
        Select Tb = new Select(Report_module_elements.dd_Table);
        Tb.selectByIndex(3);
        Report_module_elements.btn_generate.click();
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.txt_total2));
        Report_module_elements.btn_show.click();
    }

    @Test(priority = 106, testName = "(Reports) - Verify functionality of Number and Response Rate of Received Questionnaire/Data Files by Province, by Submission and by Sample (All Samples) By Response Rate and Distribution Table")
    public void test_dropdown_Table_All_sample_By_distribution_Province() throws InterruptedException {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.dd_Table));
        Select Ct = new Select(Report_module_elements.Dropdown_Category);
        Ct.selectByIndex(5);
        //eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.dd_ECN));
        //Report_module_elements.dd_ECN.sendKeys("0010100013096G2");
        Select Tb = new Select(Report_module_elements.dd_Table);
        Tb.selectByIndex(4);
        Report_module_elements.btn_generate.click();
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.txt_total2));
        Report_module_elements.btn_show.click();
    }


    @Test(priority = 107, testName = "(Reports) - Verify functionality of  Number and Response Rate of Received Questionnaire/Data Files by Province, by Submission and by Sample (Priority Samples) By Response Rate and Distribution Table")
    public void test_dropdown_Table_Priority_sample_By_distribution_Province() throws InterruptedException {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.dd_Table));
        Select Ct = new Select(Report_module_elements.Dropdown_Category);
        Ct.selectByIndex(5);
        //eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.dd_ECN));
        //Report_module_elements.dd_ECN.sendKeys("0010100013096G2");
        Select Tb = new Select(Report_module_elements.dd_Table);
        Tb.selectByIndex(5);
        Report_module_elements.btn_generate.click();
        eWait.until(ExpectedConditions.visibilityOf(Report_module_elements.txt_total2));
        Report_module_elements.btn_show.click();
    }
























}
