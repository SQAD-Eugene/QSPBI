package Package_test_by_module_DPS;

import Package_Element_DPS.Configuration_module_elements;
import Package_Element_DPS.DataSet;
import Package_Element_DPS.Home_module_elements;
import Package_Element_DPS.Login_module_elements;
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

public class Configuration_module {


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


    @Test(priority = 7, testName = "Click Configuration Tab")
    public void test_tab_configuration() {
        Configuration_module_elements config = new Configuration_module_elements(driver);
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.elementToBeClickable(Configuration_module_elements.Tab_Configuration));

        Configuration_module_elements.Tab_Configuration.click();
    }

    @Test(priority = 8, testName = "Select Year tru Configuration")
    public void test_dropdown_year1() {
        Configuration_module_elements config = new Configuration_module_elements(driver);
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.elementToBeClickable(Configuration_module_elements.dropdown_Year));

        Select Yr = new Select(Configuration_module_elements.dropdown_Year);
        Yr.selectByIndex(3);
    }

    @Test(priority = 9, testName = "Select Quarter tru Configuration")
    public void test_dropdown_quarter1() {
        Select Qr = new Select(Configuration_module_elements.dropdown_Quarter);
        Qr.selectByIndex(1);
    }

    @Test(priority = 10, testName = "Click OK tru Configuration")
    public void test_button_OK1() {
        Configuration_module_elements.btn_OK.click();
    }


    @Test(priority = 11, testName = "Click logout")
    public void test_button_logout() throws InterruptedException {
        Login_module_elements login = new Login_module_elements(driver);
        try {
            WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
            eWait.until(ExpectedConditions.elementToBeClickable(login.btn_logout));
            sleep(3000);
            login.btn_logout.click();
        } catch (StaleElementReferenceException | InterruptedException e) {
            System.out.println("Element is no longer present, re-locating and retrying...");
            WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
            eWait.until(ExpectedConditions.elementToBeClickable(login.btn_logout));
            sleep(3000);
            login.btn_logout.click();
        }
    }
}
