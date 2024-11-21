package Package_test_by_module_DPS;

import Package_Element_DPS.*;
import com.google.gson.Gson;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class Data_Validation_module {

    public static WebDriver driver;
    public static DataSet dataset;
    public static SoftAssert softAssert = new SoftAssert();


    @BeforeClass
    public void beforeClass() throws IOException {

        try {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\USER\\Desktop\\Lagayan ng chrome driver\\chromedriver-win64\\chromedriver" + ".exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();

        } finally {
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
    @Test(priority = 4, testName = "Select Year")
    public void test_dropdown_year() {
        Home_module_elements home = new Home_module_elements(driver);
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOfAllElements(home.dropdown_Year));

        Select Yr = new Select(home.dropdown_Year);
        Yr.selectByIndex(2);
    }

    @Test(priority = 5, testName = "Select Quarter")
    public void test_dropdown_quarter() {
        Home_module_elements home = new Home_module_elements(driver);
        Select Qr = new Select(home.dropdown_Quarter);
        Qr.selectByIndex(1);
    }

    @Test(priority = 6, testName = "Click OK")
    public void test_button_OK() {
        Home_module_elements home = new Home_module_elements(driver);
        home.btn_OK.click();
    }

    @Test(priority = 7, testName = "(Data Validation) - Verify functionality of File Maintenance Tab")
    public void test_Tab_File_Maintenance() {
        Data_Validation_module_elements file = new Data_Validation_module_elements(driver);
        try {
            WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
            eWait.until(ExpectedConditions.elementToBeClickable(Data_Validation_module_elements.Tab_File_Data_validation));
            Data_Validation_module_elements.Tab_File_Data_validation.click();
        } catch (StaleElementReferenceException e) {
            System.out.println("error "+ e);
        }
    }

    @Test(priority = 8, testName = "(Data Validation) - Verify functionality of Page dropdown box")
    public void test_dropdown_page() {
        Select Pg = new Select(Data_Validation_module_elements.dropdown_Page);
        Pg.selectByIndex(0);
        Pg.selectByIndex(1);
        Pg.selectByIndex(2);
        Pg.selectByIndex(0);

    }

    @Test(priority = 9, testName = "(Data Validation) - Verify functionality of Search text box")
    public void test_search_text_box() {
        Data_Validation_module_elements file = new Data_Validation_module_elements(driver);
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.elementToBeClickable(Data_Validation_module_elements.txt_Search));
        Data_Validation_module_elements.txt_Search.sendKeys(dataset.Search_value);
        Data_Validation_module_elements.txt_Search.clear();
    }

    @Test(priority = 10, testName = "(Data Validation) - Verify functionality of Select all button")
    public void test_select_all_button() throws InterruptedException {
        Data_Validation_module_elements file = new Data_Validation_module_elements(driver);
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.elementToBeClickable(Data_Validation_module_elements.btn_Select_all));
         Data_Validation_module_elements.btn_Select_all.click();
         sleep(3000);
    }

    @Test(priority = 11, testName = "(Data Validation) - Verify functionality of Clear Selected button")
    public void test_clear_selected_button() {
        Data_Validation_module_elements file = new Data_Validation_module_elements(driver);
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.elementToBeClickable(Data_Validation_module_elements.btn_Clear_selected));
        Data_Validation_module_elements.btn_Clear_selected.click();
    }

    @Test(priority = 12, testName = "(Data Validation) - Verify functionality of Selecting ECN")
    public void test_ECN() {
        Data_Validation_module_elements file = new Data_Validation_module_elements(driver);
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));

        WebElement ecn = Data_Validation_module_elements.tr_ECN;
        WebElement ecn1 = Data_Validation_module_elements.tr_ECN1;
        WebElement ecn2 = Data_Validation_module_elements.tr_ECN2;

        List<WebElement> elements = new ArrayList<>();
        elements.add(ecn);
        elements.add(ecn1);
        elements.add(ecn2);

        for (WebElement element : elements) {
            // Wait for the element to be clickable
            eWait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();

        }

    }

    @Test(priority = 13, testName = "(Data Validation) - Verify functionality of Validate button")
    public void test_Validate_button() {
        Data_Validation_module_elements file = new Data_Validation_module_elements(driver);
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.elementToBeClickable(Data_Validation_module_elements.btn_validate));
        Data_Validation_module_elements.btn_validate.click();
    }



    @Test(priority = 14, testName = "Click logout")
    public void test_button_logout() throws InterruptedException {
        Login_module_elements login = new Login_module_elements(driver);
        try {
            WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
            eWait.until(ExpectedConditions.elementToBeClickable(login.btn_logout));
            sleep(3000);
            login.btn_logout.click();
        } catch (StaleElementReferenceException e) {
            System.out.println("Element is no longer present, re-locating and retrying...");
            WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
            eWait.until(ExpectedConditions.elementToBeClickable(login.btn_logout));
            sleep(3000);
            login.btn_logout.click();
        }
    }

//    @AfterClass
//    public void tearDown () {
//        // Quit WebDriver
//        if (driver != null) {
//            driver.quit();
//        }
//    }

}
