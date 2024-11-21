package Package_test_by_module_DPS;

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
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;

import static java.lang.Thread.sleep;
import static org.testng.AssertJUnit.assertEquals;

public  class Login_module {


    public static WebDriver driver;
    public static DataSet dataset;
    SoftAssert softAssert = new SoftAssert();


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

    @Test(priority = 1, testName = "Enter invalid Email")
    public void test_textbox_email_invalid_1() throws InterruptedException{
        Login_module_elements login = new Login_module_elements(driver);
        login.txt_E_add.sendKeys(dataset.EMAIL_INV1);
    }

    @Test(priority = 2, testName = "Enter  valid Password")
    public void test_textbox_password_invalid_1() {
        Login_module_elements login = new Login_module_elements(driver);
        login.txt_Password.sendKeys(dataset.PW_INV1);
    }


    @Test(priority = 3, testName = "Click login")
    public void test_button_login_invalid_1() {
        Login_module_elements login = new Login_module_elements(driver);
        login.btn_login.click();
    }

    @Test(priority = 4, testName = "Click OK")
    public void test_button_invalid_OK() {
        Login_module_elements login = new Login_module_elements(driver);
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOfAllElements(login.btn_OK));
        login.btn_OK.click();
    }

    @Test(priority = 5, testName = "Enter valid Email")
    public void test_textbox_email_invalid_2() throws InterruptedException{
        Login_module_elements login = new Login_module_elements(driver);
        login.txt_E_add.sendKeys(dataset.EMAIL_INV2);
    }

    @Test(priority = 6, testName = "Enter invalid Password")
    public void test_textbox_password_invalid_2() {
        Login_module_elements login = new Login_module_elements(driver);
        login.txt_Password.sendKeys(dataset.PW_INV2);
    }


    @Test(priority = 7, testName = "Click login")
    public void test_button_login_invalid_2() {
        Login_module_elements login = new Login_module_elements(driver);
        login.btn_login.click();
    }

    @Test(priority = 8, testName = "Click Ok")
    public void test_button_invalid_OK2() {
        Login_module_elements login = new Login_module_elements(driver);
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOfAllElements(login.btn_OK));
        login.btn_OK.click();
    }

    @Test(priority = 9, testName = "lbl Email")
    public void test_label_email() throws InterruptedException {
        Login_module_elements login = new Login_module_elements(driver);
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOfAllElements(login.lbl_email));
        String em = dataset.EMAIL_lbl;
        assertEquals(login.lbl_email.getText(), em);
        }

        @Test(priority = 10, testName = "Enter Email")
        public void test_textbox_email () throws InterruptedException {
            Login_module_elements login = new Login_module_elements(driver);
            login.txt_E_add.sendKeys(dataset.EMAIL);
        }

    @Test(priority = 11, testName = "lbl Password")
    public void test_label_password() throws InterruptedException {
        Login_module_elements login = new Login_module_elements(driver);
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOfAllElements(login.lbl_password));
        String pass = dataset.PASSWORD_lbl;
        assertEquals(login.lbl_password.getText(), pass);
    }

        @Test(priority = 12, testName = "Enter Password")
        public void test_textbox_password () {
            Login_module_elements login = new Login_module_elements(driver);
            login.txt_Password.sendKeys(dataset.PW);
        }


        @Test(priority = 13, testName = "Click login")
        public void test_button_login () {
            Login_module_elements login = new Login_module_elements(driver);
            login.btn_login.click();
        }


        @Test(priority = 14, testName = "Select Year")
        public void test_dropdown_year () {
            Home_module_elements home = new Home_module_elements(driver);
            WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
            eWait.until(ExpectedConditions.visibilityOfAllElements(home.dropdown_Year));

            Select Yr = new Select(home.dropdown_Year);
            Yr.selectByIndex(2);
        }

        @Test(priority = 15, testName = "Select Quarter")
        public void test_dropdown_quarter () {
            Home_module_elements home = new Home_module_elements(driver);
            Select Qr = new Select(home.dropdown_Quarter);
            Qr.selectByIndex(1);
        }

        @Test(priority = 16, testName = "Click OK")
        public void test_button_OK () {
            Home_module_elements home = new Home_module_elements(driver);
            home.btn_OK.click();
          System.out.println("hello");
        }


        @Test(priority = 17, testName = "Click logout")
        public void test_button_logout () throws InterruptedException {
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

        @AfterClass
        public void tearDown () {
            // Quit WebDriver
            if (driver != null) {
                driver.quit();
            }
        }
    }