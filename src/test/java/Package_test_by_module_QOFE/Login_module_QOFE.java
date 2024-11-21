package Package_test_by_module_QOFE;

import Package_Element_DPS.DataSet;
import Package_Element_DPS.Home_module_elements;
import Package_Element_DPS.Login_module_elements;
import Package_Element_QOFE.DataSet_QOFE;
import Package_Element_QOFE.Login_module_elements_QOFE;
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

public class Login_module_QOFE {


   WebDriver driver;
   DataSet_QOFE dataset;
   SoftAssert softAssert = new SoftAssert();


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
        driver.get("https://qspbidev-cawi-clone.psa.gov.ph/home");


        Gson gson = new Gson();
        Reader reader = Files.newBufferedReader(Paths.get("dataset.json"));
        dataset = gson.fromJson(reader, DataSet_QOFE.class);
    }

    @Test(priority = 1, testName = "Click Login Tab")
    public void tab_Login() throws InterruptedException{
        Login_module_elements_QOFE login = new  Login_module_elements_QOFE(driver);
        Login_module_elements_QOFE.Tab_Login.click();
    }

    @Test(priority = 1, testName = "Enter Email")
    public void test_textbox_email() throws InterruptedException{
        Login_module_elements_QOFE login = new Login_module_elements_QOFE(driver);
        Login_module_elements_QOFE.txt_ECN.sendKeys(dataset.ECN_QOFE);
    }

    @Test(priority = 2, testName = "Enter Password")
    public void test_textbox_password() {
        Login_module_elements_QOFE.txt_Password.sendKeys(dataset.PW_QOFE);
    }

    @Test(priority = 3, testName = "Click login")
    public void test_button_login() {
        Login_module_elements_QOFE.btn_login.click();
    }

    @Test(priority = 7, testName = "Click logout")
    public void test_button_logout() throws InterruptedException {

        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(120));
        try {
            eWait.until(ExpectedConditions.elementToBeClickable(Login_module_elements_QOFE.btn_logout));
//            sleep(3000);
            Login_module_elements_QOFE.btn_logout.click();
        } catch (StaleElementReferenceException e) {
            System.out.println("Element is no longer present, re-locating and retrying...");
            eWait.until(ExpectedConditions.elementToBeClickable(Login_module_elements_QOFE.btn_logout));
//            sleep(3000);
            Login_module_elements_QOFE.btn_logout.click();
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
