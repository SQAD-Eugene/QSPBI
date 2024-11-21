package Package_test_by_module_DPS;

import Package_Element_DPS.*;
import com.google.gson.Gson;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
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

public class Utilities_module {
    WebDriver driver;
    DataSet dataset;
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


    @Test(priority = 7, testName = "(Utilities) - Verify functionality of Utilities Dropdown Create Account Tab")
    public void test_Tab_Utilities() {


        Utilities_module_elements file = new Utilities_module_elements(driver);
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        //Actions actions = new Actions(driver);
        eWait.until(ExpectedConditions.elementToBeClickable(file.dd_Utilities));
        file.dd_Utilities.click();
        eWait.until(ExpectedConditions.elementToBeClickable(file.dd_User_account));
       // actions.moveToElement(file.dd_User_account).perform();
        eWait.until(ExpectedConditions.elementToBeClickable(file.Tab_create_Account));
        file.Tab_create_Account.click();
    }

    @Test(priority = 8, testName = "(Utilities) - Verify functionality of Employee Number text box")
    public void test_textbox_Employee_number() {
        Utilities_module_elements file = new Utilities_module_elements(driver);

        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.elementToBeClickable(file.txt_Employee_number));
        file.txt_Employee_number.sendKeys(dataset.Employee_number);
    }

    @Test(priority = 9, testName = "(Utilities) - Verify functionality of Last Name text box")
    public void test_textbox_Last_name() {
        Utilities_module_elements file = new Utilities_module_elements(driver);

        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.elementToBeClickable(file.txt_Last_name));
        file.txt_Last_name.sendKeys(dataset.Last_name);
    }

    @Test(priority = 10, testName = "(Utilities) - Verify functionality of First Name text box")
    public void test_textbox_First_name() {
        Utilities_module_elements file = new Utilities_module_elements(driver);

        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.elementToBeClickable(file.txt_First_name));
        file.txt_First_name.sendKeys(dataset.First_name);
    }

    @Test(priority = 11, testName = "(Utilities) - Verify functionality of Middle Name text box")
    public void test_textbox_Middle_name() {
        Utilities_module_elements file = new Utilities_module_elements(driver);

        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.elementToBeClickable(file.txt_Middle_name));
        file.txt_Middle_name.sendKeys(dataset.Middle_name);
    }

    @Test(priority = 12, testName = "(Utilities) - Verify functionality of Email text box")
    public void test_textbox_Email() {
        Utilities_module_elements file = new Utilities_module_elements(driver);

        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.elementToBeClickable(file.txt_Email));
        file.txt_Email.sendKeys(dataset.Email);
    }

    @Test(priority = 13, testName = "(Utilities) - Verify functionality of Password text box")
    public void test_textbox_Password() {
        Utilities_module_elements file = new Utilities_module_elements(driver);

        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.elementToBeClickable(file.txt_Password));
        file.txt_Password.sendKeys(dataset.PW);
    }

    @Test(priority = 14, testName = "(Utilities) - Verify functionality of Office Dropdown")
    public void test_dropdown_Office() {
        Utilities_module_elements file = new Utilities_module_elements(driver);

        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.elementToBeClickable(file.dd_office));
        Select Off = new Select(file.dd_office);
        Off.selectByIndex(2);
    }

    @Test(priority = 15, testName = "(Utilities) - Verify functionality of Role Dropdown")
    public void test_dropdown_Role() {
        Utilities_module_elements file = new Utilities_module_elements(driver);

        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.elementToBeClickable(file.dd_role));
        Select rl = new Select(file.dd_role);
        rl.selectByIndex(2);
    }

    @Test(priority = 16, testName = "(Utilities) - Verify functionality of Utilities Dropdown and Active Accounts Tab")
    public void test_Tab_Utilities1() {
        Utilities_module_elements file = new Utilities_module_elements(driver);

        Actions actions = new Actions(driver);
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.elementToBeClickable(file.dd_Utilities1));
        file.dd_Utilities1.click();
        eWait.until(ExpectedConditions.elementToBeClickable(file.dd_User_account1));
        actions.moveToElement(file.dd_User_account1).perform();
        eWait.until(ExpectedConditions.elementToBeClickable(file.Tab_Active_Account));
        file.Tab_Active_Account.click();

    }

    @Test(priority = 17, testName = "(Utilities) - Verify functionality of View Icon")
    public void test_View_icon() {
        Utilities_module_elements file = new Utilities_module_elements(driver);

        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.elementToBeClickable(file.icon_view));
        file.icon_view.click();

    }

    @Test(priority = 18, testName = "(Utilities) - Verify functionality of Edit button")
    public void test_btn_Edit() {
        Utilities_module_elements file = new Utilities_module_elements(driver);

        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 1000);");
        eWait.until(ExpectedConditions.elementToBeClickable(file.btn_Edit_account));
        file.btn_Edit_account.click();

    }

    @Test(priority = 19, testName = "(Utilities) - Verify functionality of Edit Last name")
    public void test_btn_Edit_lastname() {
        Utilities_module_elements file = new Utilities_module_elements(driver);

        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.elementToBeClickable(file.txt_edit_lastname));
        file.txt_edit_lastname.clear();
        file.txt_edit_lastname.sendKeys(dataset.Last_name);

    }

    @Test(priority = 20, testName = "(Utilities) - Verify functionality of Edit First name")
    public void test_btn_Edit_firstname() {
        Utilities_module_elements file = new Utilities_module_elements(driver);

        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.elementToBeClickable(file.txt_edit_firstname));
        file.txt_edit_firstname.clear();
        file.txt_edit_firstname.sendKeys(dataset.First_name);

    }

    @Test(priority = 21, testName = "(Utilities) - Verify functionality of Edit Middle name")
    public void test_btn_Edit_middlename() {
        Utilities_module_elements file = new Utilities_module_elements(driver);

        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.elementToBeClickable(file.txt_edit_middlename));
        file.txt_edit_middlename.clear();
        file.txt_edit_middlename.sendKeys(dataset.Middle_name);

    }

    @Test(priority = 22, testName = "(Utilities) - Verify functionality of Edit Change password")
    public void test_btn_Edit_change_password() {
        Utilities_module_elements file = new Utilities_module_elements(driver);

        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.elementToBeClickable(file.btn_edit_changepassword));
        file.btn_edit_changepassword.click();

    }

    @Test(priority = 23, testName = "(Utilities) - Verify functionality of Edit Change password text box")
    public void test_txt_Edit_change_password() {
        Utilities_module_elements file = new Utilities_module_elements(driver);

        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.elementToBeClickable(file.txt_edit_changepassword));
        file.txt_edit_changepassword.sendKeys(dataset.PW);

    }

    @Test(priority = 24, testName = "(Utilities) - Verify functionality of Update button")
    public void test_btn_Edit_update() {
        Utilities_module_elements file = new Utilities_module_elements(driver);

        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.elementToBeClickable(file.btn_edit_Update_account));
        file.btn_edit_Update_account.click();

    }

    @Test(priority = 25, testName = "(Utilities) - Verify functionality of Utilities Dropdown and Inactive Accounts Tab")
    public void test_Tab_Utilities2() {
        Utilities_module_elements file = new Utilities_module_elements(driver);

        Actions actions = new Actions(driver);
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.elementToBeClickable(file.dd_Utilities2));
        file.dd_Utilities2.click();
        eWait.until(ExpectedConditions.elementToBeClickable(file.dd_User_account2));
        actions.moveToElement(file.dd_User_account2).perform();
        eWait.until(ExpectedConditions.elementToBeClickable(file.btn_inactive_account));
        file.btn_inactive_account.click();

    }

    @Test(priority = 26, testName = "(Utilities) - Verify functionality of Deactivate Account", enabled = false)
    public void test_icon_deactivate() {
        Utilities_module_elements file = new Utilities_module_elements(driver);

        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.elementToBeClickable(file.icon_deactivate));
        file.icon_deactivate.click();

    }

    @Test(priority = 27, testName = "(Utilities) - Verify functionality of Cancel button", enabled = false)
    public void test_btn_cancel() {
        Utilities_module_elements file = new Utilities_module_elements(driver);

        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.elementToBeClickable(file.btn_Cancel));
        file.btn_Cancel.click();

    }

    @Test(priority = 28, testName = "(Utilities) - Verify functionality of Deactivate Account", enabled = false)
    public void test_icon_deactivate1() {
        Utilities_module_elements file = new Utilities_module_elements(driver);

        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.elementToBeClickable(file.icon_deactivate));
        file.icon_deactivate.click();

    }

    @Test(priority = 29, testName = "(Utilities) - Verify functionality of Deactivate button", enabled = false)
    public void test_btn_deactivate() {
        Utilities_module_elements file = new Utilities_module_elements(driver);

        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.elementToBeClickable(file.btn_Deactivate));
        file.btn_Deactivate.click();

    }

    @Test(priority = 30, testName = "(Utilities) - Verify functionality of Manage Reference file")
    public void test_btn_Manage_ref() {
        Utilities_module_elements file = new Utilities_module_elements(driver);

        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.elementToBeClickable(file.dd_Utilities3));
        file.dd_Utilities3.click();
        eWait.until(ExpectedConditions.elementToBeClickable(file.Tab_Manage_Reference_File));
        file.Tab_Manage_Reference_File.click();

    }

    @Test(priority = 31, testName = "(Utilities) - Verify functionality of Utilities Dropdown and Address Stub and Control List Tab")
    public void test_Tab_Utilities_Address_Stub_Control_List() {
        Utilities_module_elements file = new Utilities_module_elements(driver);

        Actions actions = new Actions(driver);
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.elementToBeClickable(file.dd_Utilities4));
        file.dd_Utilities4.click();
        eWait.until(ExpectedConditions.elementToBeClickable(file.dd_Others));
        actions.moveToElement(file.dd_Others).perform();
        eWait.until(ExpectedConditions.elementToBeClickable(file.Tab_Address_Stub_Control));
        file.Tab_Address_Stub_Control.click();
    }

    @Test(priority = 32, testName = "(Utilities) - Verify functionality of Control List Radio button")
    public void test_Radio_Control_list() {
        Utilities_module_elements file = new Utilities_module_elements(driver);

        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOfAllElements(file.rad_Control_list));
        file.rad_Control_list.click();

    }
    @Test(priority = 33, testName = "(Utilities) - Verify functionality of Address Stub Radio button")
    public void test_Radio_Address_Stub() {
        Utilities_module_elements file = new Utilities_module_elements(driver);

        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOfAllElements(file.rad_Address_stub));
        file.rad_Address_stub.click();

    }

    @Test(priority = 34, testName = "(Utilities) - Verify functionality of One Radio button")
    public void test_Radio_One() {
        Utilities_module_elements file = new Utilities_module_elements(driver);

        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOfAllElements(file.rad_One));
        file.rad_One.click();

    }

    @Test(priority = 35, testName = "(Utilities) - Verify functionality of Two Radio button")
    public void test_Radio_Two() {
        Utilities_module_elements file = new Utilities_module_elements(driver);

        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOfAllElements(file.rad_Two));
        file.rad_Two.click();

    }

    @Test(priority = 36, testName = "(Utilities) - Verify functionality of Region Dropdown")
    public void test_Dropdown_Reg() {
        Utilities_module_elements file = new Utilities_module_elements(driver);

        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOfAllElements(file.dd_Region));
        Select Rg = new Select(file.dd_Region);
        Rg.selectByIndex(4);

    }

    @Test(priority = 37, testName = "(Utilities) - Verify functionality of Province Dropdown", enabled = false)
    public void test_Dropdown_Prov() {
        Utilities_module_elements file = new Utilities_module_elements(driver);

        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOfAllElements(file.dd_Province));
        Select Pr = new Select(file.dd_Province);
        WebElement selectedOption = (WebElement) Pr.getAllSelectedOptions();
        String selectedValue =selectedOption.getAttribute("value");
        System.out.println("Valueeee"+selectedValue+"...");

    }


    @Test(priority = 38, testName = "(Utilities) - Verify functionality of Update Characteristics dropdown")
    public void test_Tab_Update_char() {
        Utilities_module_elements file = new Utilities_module_elements(driver);

        Actions actions = new Actions(driver);
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.elementToBeClickable(file.dd_Utilities5));
        file.dd_Utilities5.click();
        eWait.until(ExpectedConditions.elementToBeClickable(file.dd_Others3));
        actions.moveToElement(file.dd_Others3).perform();
        eWait.until(ExpectedConditions.elementToBeClickable(file.Tab_Update_char));
        file.Tab_Update_char.click();

    }

    @Test(priority = 39, testName = "(Utilities) - Verify functionality of Per page dropdown")
    public void test_dd_Perpage() {
        Utilities_module_elements file = new Utilities_module_elements(driver);

        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.elementToBeClickable(file.dd_Perpage));
        Select Pp = new Select(file.dd_Perpage);
        Pp.selectByIndex(2);

    }

    @Test(priority = 40, testName = "(Utilities) - Verify functionality of Search text box")
    public void test_txt_Search() {
        Utilities_module_elements file = new Utilities_module_elements(driver);
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.elementToBeClickable(file.txt_search));
        file.txt_search.sendKeys(dataset.Search_value);

    }

    @Test(priority = 41, testName = "(Utilities) - Verify functionality of Replace ECN button")
    public void test_btn_Replace_ECN() {
        Utilities_module_elements file = new Utilities_module_elements(driver);
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.elementToBeClickable(file.btn_Rep_ECN));
        file.btn_Rep_ECN.click();

    }

    @Test(priority = 42, testName = "(Utilities) - Verify functionality of Help button")
    public void test_Tab_Help() {
        Utilities_module_elements file = new Utilities_module_elements(driver);
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.elementToBeClickable(file.Tab_Help));
       file.Tab_Help.click();

    }

}