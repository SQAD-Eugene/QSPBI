package Package_test_by_module_DPS;

import Package_Element_DPS.DataSet;
import Package_Element_DPS.File_maintenance_module_elements;
import Package_Element_DPS.Home_module_elements;
import Package_Element_DPS.Login_module_elements;
import com.google.gson.Gson;
import org.openqa.selenium.JavascriptExecutor;
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

public class File_Maitenance_module {

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
        Yr.selectByIndex(1);
    }

    @Test(priority = 5, testName = "Select Quarter")
    public void test_dropdown_quarter() {
        Home_module_elements home = new Home_module_elements(driver);
        Select Qr = new Select(home.dropdown_Quarter);
        Qr.selectByIndex(0);
    }

    @Test(priority = 6, testName = "Click OK")
    public void test_button_OK() {
        Home_module_elements home = new Home_module_elements(driver);
        home.btn_OK.click();
    }

    @Test(priority = 7, testName = "(File Maintenance) - Verify functionality of File Maintenance Tab")
    public void test_Tab_File_Maintenance() {
        File_maintenance_module_elements file = new File_maintenance_module_elements(driver);
            try {
                WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
                eWait.until(ExpectedConditions.elementToBeClickable(File_maintenance_module_elements.Tab_File_Maintenance));
                File_maintenance_module_elements.Tab_File_Maintenance.click();
            } catch (StaleElementReferenceException e) {
                System.out.println("error "+ e);
            }
        }

    @Test(priority = 8, testName = "(File Maintenance) - Verify functionality of Encode data button")
    public void test_button_encode_data() {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.elementToBeClickable(File_maintenance_module_elements.btn_Encode_Data));
        File_maintenance_module_elements.btn_Encode_Data.click();
    }

    @Test(priority = 9, testName = "(File Maintenance) - Verify functionality of ECN text box")
    public void test_Textbox_ECN() {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.elementToBeClickable(File_maintenance_module_elements.txt_ECN));
        File_maintenance_module_elements.txt_ECN.sendKeys(dataset.ECN);
    }

    @Test(priority = 10, testName = "(File Maintenance) - Verify functionality of Listed ECN")
    public void test_List_ECN() {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.elementToBeClickable(File_maintenance_module_elements.List_ECN));
        File_maintenance_module_elements.List_ECN.click();
    }

    @Test(priority = 11, testName = "(File Maintenance) - Verify functionality of Questionnaire status dropdown")
    public void test_Qustionniare_Status() {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.elementToBeClickable(File_maintenance_module_elements.dropdown_Status));
        Select Qs = new Select(File_maintenance_module_elements.dropdown_Status);
        Qs.selectByIndex(1);
    }

    @Test(priority = 12, testName = "(File Maintenance) - Verify functionality of Business name text box")
    public void test_Business_name_() {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_B_name));
        String Businame_value = File_maintenance_module_elements.txt_B_name.getText();
        softAssert.assertEquals(Businame_value,dataset.BUSINESS_NAME_VALUE);
    }

    @Test(priority = 13, testName = "(File Maintenance) - Verify functionality of Business address text box")
    public void test_Business_address_() {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_B_address));
        String Busiaddress_value = File_maintenance_module_elements.txt_B_address.getText();
        softAssert.assertEquals(Busiaddress_value,dataset.BUSINESS_ADDRESS_VALUE);
    }

    @Test(priority = 14, testName = "(File Maintenance) - Verify functionality of TIN text box")
    public void test_TIN_() {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_TIN));
        String TIN_value = File_maintenance_module_elements.txt_TIN.getText();
        softAssert.assertEquals(TIN_value,dataset.TIN_VALUE);
    }

    @Test(priority = 15, testName = "(File Maintenance) - Verify functionality A. Working Owners for previous quarter text box")
    public void test_Prev_Working_Owners() {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Working_owners_prev_month));
        File_maintenance_module_elements.txt_Working_owners_prev_month.sendKeys(dataset.Test1);
    }

    @Test(priority = 16, testName = "(File Maintenance) - Verify functionality  A. Working Owners for january text box")
    public void test_January_Working_Owners() {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Working_owners_january));
        File_maintenance_module_elements.txt_Working_owners_january.sendKeys(dataset.Test1);
    }

    @Test(priority = 17, testName = "(File Maintenance) - Verify functionality  A. Working Owners for February text box")
    public void test_February_Working_Owners() {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Working_owners_february));
        File_maintenance_module_elements.txt_Working_owners_february.sendKeys(dataset.Test1);
    }

    @Test(priority = 18, testName = "(File Maintenance) - Verify functionality A. Working Owners for March text box")
    public void test_March_Working_Owners(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Working_owners_march));
        File_maintenance_module_elements.txt_Working_owners_march.sendKeys(dataset.Test1);
    }

    @Test(priority = 19, testName = "(File Maintenance) - Verify functionality 1. MANAGERS AND EXECUTIVES previous quarter text box")
    public void test_Prev_Managers_executive() throws InterruptedException {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Managers_executive_prev_month));
        File_maintenance_module_elements.txt_Managers_executive_prev_month.sendKeys(dataset.Test1);
    }

    @Test(priority = 20, testName = "(File Maintenance) - Verify functionality 1. MANAGERS AND EXECUTIVES january text box")
    public void test_January_Managers_executive() {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Managers_executive_january));
        File_maintenance_module_elements.txt_Managers_executive_january.sendKeys(dataset.Test1);
    }

    @Test(priority = 21, testName = "(File Maintenance) - Verify functionality 1. MANAGERS AND EXECUTIVES February text box")
    public void test_February_Managers_executive() {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Managers_executive_february));
        File_maintenance_module_elements.txt_Managers_executive_february.sendKeys(dataset.Test1);
    }

    @Test(priority = 22, testName = "(File Maintenance) - Verify functionality 1. MANAGERS AND EXECUTIVES March text box")
    public void test_March_Managers_executive() throws InterruptedException {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Managers_executive_march));
        File_maintenance_module_elements.txt_Managers_executive_march.sendKeys(dataset.Test1);
    }
    @Test(priority = 23, testName = "(File Maintenance) - Verify functionality 3. Other Employees for previous quarter text box")
    public void test_Prev_Other_employees() throws InterruptedException {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Other_employees_prev_month));
        File_maintenance_module_elements.txt_Other_employees_prev_month.sendKeys(dataset.Test1);

    }

    @Test(priority = 24, testName = "(File Maintenance) - Verify functionality 3. Other Employees for january text box")
    public void test_January_Other_employees() {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Other_employees_january));
        File_maintenance_module_elements.txt_Other_employees_january.sendKeys(dataset.Test1);
    }

    @Test(priority = 25, testName = "(File Maintenance) - Verify functionality 3. Other Employees for February text box")
    public void test_February_Other_employees() {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Other_employees_february));
        File_maintenance_module_elements.txt_Other_employees_february.sendKeys(dataset.Test1);
    }

    @Test(priority = 26, testName = "(File Maintenance) - Verify functionality 3. Other Employees for March text box")
    public void test_March_Other_employees() throws InterruptedException {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Other_employees_march));
        File_maintenance_module_elements.txt_Other_employees_march.sendKeys(dataset.Test1);
    }

    @Test(priority = 27, testName = "(File Maintenance) - Verify functionality 1. SALARIES OF MANAGERS AND EXECUTIVES for previous quarter text box")
    public void test_Prev_Manager_executive() throws InterruptedException {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Salary_managers_prev_month));
        File_maintenance_module_elements.txt_Salary_managers_prev_month.sendKeys(dataset.Test1);

    }

    @Test(priority = 28, testName = "(File Maintenance) - Verify functionality 1. SALARIES OF MANAGERS AND EXECUTIVES for january text box")
    public void test_January_Manager_executive() {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Salary_managers_january));
        File_maintenance_module_elements.txt_Salary_managers_january.sendKeys(dataset.Test1);
    }

    @Test(priority = 29, testName = "(File Maintenance) - Verify functionality 1. SALARIES OF MANAGERS AND EXECUTIVES for February text box")
    public void test_February_Manager_executive() {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Salary_managers_february));
        File_maintenance_module_elements.txt_Salary_managers_february.sendKeys(dataset.Test1);
    }

    @Test(priority = 30, testName = "(File Maintenance) - Verify functionality 1. SALARIES OF MANAGERS AND EXECUTIVES for March text box")
    public void test_March_Manager_executive() throws InterruptedException {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Salary_managers_march));
        File_maintenance_module_elements.txt_Salary_managers_march.sendKeys(dataset.Test1);
    }

    @Test(priority = 31, testName = "(File Maintenance) - Verify functionality 3. SALARIES AND WAGES OF OTHER EMPLOYEES for previous quarter text box")
    public void test_Prev_OTHER_EMPLOYEES() throws InterruptedException {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Salaries_wages_prev_month));
        File_maintenance_module_elements.txt_Salaries_wages_prev_month.sendKeys(dataset.Test1);

    }

    @Test(priority = 32, testName = "(File Maintenance) - Verify functionality 3. SALARIES AND WAGES OF OTHER EMPLOYEES for january text box")
    public void test_January_OTHER_EMPLOYEES() {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Salaries_wages_january));
        File_maintenance_module_elements.txt_Salaries_wages_january.sendKeys(dataset.Test1);
    }

    @Test(priority = 33, testName = "(File Maintenance) - Verify functionality 3. SALARIES AND WAGES OF OTHER EMPLOYEES for February text box")
    public void test_February_OTHER_EMPLOYEES() {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Salaries_wages_february));
        File_maintenance_module_elements.txt_Salaries_wages_february.sendKeys(dataset.Test1);
    }

    @Test(priority = 34, testName = "(File Maintenance) - Verify functionality 3. SALARIES AND WAGES OF OTHER EMPLOYEES for March text box")
    public void test_March_OTHER_EMPLOYEES() throws InterruptedException {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Salaries_wages_march));
        File_maintenance_module_elements.txt_Salaries_wages_march.sendKeys(dataset.Test1);
    }


    @Test(priority = 35, testName = "(File Maintenance) - Verify functionality B. EMPLOYER’S CONTRIBUTION TO SOCIAL SECURITY SYSTEM (SSS), GOVERNMENT SERVICE INSURANCE SYSTEM (GSIS), PHILHEALTH, AND OTHERSfor previous quarter text box")
    public void test_Prev_EMPLOYEES_CONTRIBUTION() throws InterruptedException {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Employers_contribution_prev_month));
        File_maintenance_module_elements.txt_Employers_contribution_prev_month.sendKeys(dataset.Test1);

    }

    @Test(priority = 36, testName = "(File Maintenance) - Verify functionality B. EMPLOYER’S CONTRIBUTION TO SOCIAL SECURITY SYSTEM (SSS), GOVERNMENT SERVICE INSURANCE SYSTEM (GSIS), PHILHEALTH, AND OTHERSfor january text box")
    public void test_January_EMPLOYEES_CONTRIBUTION() {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Employers_contribution_january));
        File_maintenance_module_elements.txt_Employers_contribution_january.sendKeys(dataset.Test1);
    }

    @Test(priority = 37, testName = "(File Maintenance) - Verify functionality B. EMPLOYER’S CONTRIBUTION TO SOCIAL SECURITY SYSTEM (SSS), GOVERNMENT SERVICE INSURANCE SYSTEM (GSIS), PHILHEALTH, AND OTHERSfor February text box")
    public void test_February_EMPLOYEES_CONTRIBUTION() {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Employers_contribution_february));
        File_maintenance_module_elements.txt_Employers_contribution_february.sendKeys(dataset.Test1);
    }

    @Test(priority = 38, testName = "(File Maintenance) - Verify functionality B. EMPLOYER’S CONTRIBUTION TO SOCIAL SECURITY SYSTEM (SSS), GOVERNMENT SERVICE INSURANCE SYSTEM (GSIS), PHILHEALTH, AND OTHERSfor March text box")
    public void test_March_EMPLOYEES_CONTRIBUTION() throws InterruptedException {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Employers_contribution_march));
        File_maintenance_module_elements.txt_Employers_contribution_march.sendKeys(dataset.Test1);
    }

    @Test(priority = 39, testName = "(File Maintenance) - Verify functionality A. REVENUE/SALES FROM MAIN ECONOMIC ACTIVITY for Specify Main activity text box")
    public void test_Prev_REVENUE_SALES_specify() throws InterruptedException {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Revenue_sale_other_specify_prev_month));
        File_maintenance_module_elements.txt_Revenue_sale_other_specify_prev_month.sendKeys(dataset.Specify_Main_eco);

    }

    @Test(priority = 40, testName = "(File Maintenance) - Verify functionality A. REVENUE/SALES FROM MAIN ECONOMIC ACTIVITY for previous quarter text box")
    public void test_Prev_REVENUE_SALES() throws InterruptedException {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Revenue_sale_prev_month));
        File_maintenance_module_elements.txt_Revenue_sale_prev_month.sendKeys(dataset.Test1);

    }

    @Test(priority = 41, testName = "(File Maintenance) - Verify functionality A. REVENUE/SALES FROM MAIN ECONOMIC ACTIVITY for january text box")
    public void test_January_REVENUE_SALES() {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Revenue_sale_january));
        File_maintenance_module_elements.txt_Revenue_sale_january.sendKeys(dataset.Test1);
    }

    @Test(priority = 42, testName = "(File Maintenance) - Verify functionality A.  REVENUE/SALES FROM MAIN ECONOMIC ACTIVITY for February text box")
    public void test_February_REVENUE_SALES() {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Revenue_sale_february));
        File_maintenance_module_elements.txt_Revenue_sale_february.sendKeys(dataset.Test1);
    }

    @Test(priority = 43, testName = "(File Maintenance) - Verify functionality A. REVENUE/SALES FROM MAIN ECONOMIC ACTIVITY for March text box")
    public void test_March_REVENUE_SALES() throws InterruptedException {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Revenue_sale_march));
        File_maintenance_module_elements.txt_Revenue_sale_march.sendKeys(dataset.Test1);

    }


    @Test(priority = 44, testName = "(File Maintenance) - Verify functionality B. OTHER INCOME for Specify Main activity text box")
    public void test_Prev_Other_income_specify() throws InterruptedException {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Other_income_other_specify_prev_month));
        File_maintenance_module_elements.txt_Other_income_other_specify_prev_month.sendKeys(dataset.Specify_Other_income);

    }

    @Test(priority = 45, testName = "(File Maintenance) - Verify functionality B. OTHER INCOME for previous quarter text box")
    public void test_Prev_Other_income() throws InterruptedException {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Other_income_prev_month));
        File_maintenance_module_elements.txt_Other_income_prev_month.sendKeys(dataset.Test1);

    }

    @Test(priority = 46, testName = "(File Maintenance) - Verify functionality B. OTHER INCOME for january text box")
    public void test_January_Other_income() {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Other_income_january));
        File_maintenance_module_elements.txt_Other_income_january.sendKeys(dataset.Test1);
    }

    @Test(priority = 47, testName = "(File Maintenance) - Verify functionality B. OTHER INCOME for February text box")
    public void test_February_Other_income() {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Other_income_february));
        File_maintenance_module_elements.txt_Other_income_february.sendKeys(dataset.Test1);
    }

    @Test(priority = 48, testName = "(File Maintenance) - Verify functionality B. OTHER INCOME for March text box")
    public void test_March_Other_income() throws InterruptedException {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Other_income_march));
        File_maintenance_module_elements.txt_Other_income_march.sendKeys(dataset.Test1);

    }

    @Test(priority = 49, testName = "(File Maintenance) - Verify functionality E. GOODS FOR RESALE for January text box")
    public void test_January_GOODS_RESALE() {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_GOODS_FOR_RESALE_january));
        File_maintenance_module_elements.txt_GOODS_FOR_RESALE_january.sendKeys(dataset.Test1);
    }

    @Test(priority = 50, testName = "(File Maintenance) - Verify functionality E. GOODS FOR RESALE for March text box")
    public void test_March_GOODS_RESALE() throws InterruptedException {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_GOODS_FOR_RESALE_march));
        File_maintenance_module_elements.txt_GOODS_FOR_RESALE_march.sendKeys(dataset.Test1);

    }

    @Test(priority = 51, testName = "(File Maintenance) - Verify functionality F. OTHER INVENTORIES for January text box")
    public void test_January_OTHER_INVENTORIES() {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_OTHER_INVENTORIES_january));
        File_maintenance_module_elements.txt_OTHER_INVENTORIES_january.sendKeys(dataset.Test1);
    }

    @Test(priority = 52, testName = "(File Maintenance) - Verify functionality F. OTHER INVENTORIES for March text box")
    public void test_March_OTHER_INVENTORIES() throws InterruptedException {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_OTHER_INVENTORIES_march));
        File_maintenance_module_elements.txt_OTHER_INVENTORIES_march.sendKeys(dataset.Test1);

    }

    @Test(priority = 53, testName = "(File Maintenance) - Verify functionality Description of this establishment's Main Economic (Principal) Activity: text box")
    public void test_Description() throws InterruptedException {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Description_of_MEA));
        File_maintenance_module_elements.txt_Description_of_MEA.sendKeys(dataset.Description);

    }

    @Test(priority = 54, testName = "(File Maintenance) - Verify functionality Remarks: text box")
    public void test_Remarks() throws InterruptedException {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Remarks));
        File_maintenance_module_elements.txt_Remarks.sendKeys(dataset.Remarks);
    }

    @Test(priority = 55, testName = "(File Maintenance) - Verify functionality Name of Official text box")
    public void test_Name() throws InterruptedException {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Name));
        File_maintenance_module_elements.txt_Name.sendKeys(dataset.Name);
    }

    @Test(priority = 56, testName = "(File Maintenance) - Verify functionality Designation text box")
    public void test_Designation() throws InterruptedException {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Designation));
        File_maintenance_module_elements.txt_Designation.sendKeys(dataset.Designation);
    }

    @Test(priority = 57, testName = "(File Maintenance) - Verify functionality Contact Number text box")
    public void test_Cont_No() throws InterruptedException {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Contact_number));
        File_maintenance_module_elements.txt_Contact_number.sendKeys(dataset.Contact);
    }

    @Test(priority = 58, testName = "(File Maintenance) - Verify functionality Email text box")
    public void test_Email() throws InterruptedException {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Email));
        File_maintenance_module_elements.txt_Email.sendKeys(dataset.Email);
    }

    @Test(priority = 59, testName = "(File Maintenance) - Verify functionality Website text box")
    public void test_Web() throws InterruptedException {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Website));
        File_maintenance_module_elements.txt_Website.sendKeys(dataset.Website);
        sleep(10000);
    }

    @Test(priority = 60, testName = "(File Maintenance) - Verify functionality of File Maintenance Tab")
    public void test_Tab_File_Maintenance2() {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        try {

            eWait.until(ExpectedConditions.elementToBeClickable(File_maintenance_module_elements.Tab_File_Maintenance));
            File_maintenance_module_elements.Tab_File_Maintenance.click();
        } catch (StaleElementReferenceException e) {
            System.out.println("error "+ e);
        }
    }

    @Test(priority = 61, testName = "(File Maintenance) - Verify functionality of View icon")
    public void test_View_icon(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOfAllElements(File_maintenance_module_elements.btn_View));
        File_maintenance_module_elements.btn_View.click();
    }

    @Test(priority = 62, testName = "(File Maintenance) - Verify functionality of Edit data")
    public void test_Edit_data_button(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.elementToBeClickable(File_maintenance_module_elements.btn_Edit_data));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", File_maintenance_module_elements.btn_Edit_data);
        File_maintenance_module_elements.btn_Edit_data.click();
    }

    @Test(priority = 63, testName = "(File Maintenance - edit) - Verify functionality A. Working Owners for previous quarter text box")
    public void test_Prev_Working_Owners_edit() {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Working_owners_prev_month_edit));
        File_maintenance_module_elements.txt_Working_owners_prev_month_edit.clear();
        File_maintenance_module_elements.txt_Working_owners_prev_month_edit.sendKeys(dataset.Test1);
    }

    @Test(priority = 64, testName = "(File Maintenance - edit) - Verify functionality  A. Working Owners for january text box")
    public void test_January_Working_Owners_edit() {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Working_owners_january_edit));
        File_maintenance_module_elements.txt_Working_owners_january_edit.clear();
        File_maintenance_module_elements.txt_Working_owners_january_edit.sendKeys(dataset.Test1);
    }

    @Test(priority = 65, testName = "(File Maintenance - edit) - Verify functionality  A. Working Owners for February text box")
    public void test_February_Working_Owners_edit() {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Working_owners_february_edit));
        File_maintenance_module_elements.txt_Working_owners_february_edit.clear();
        File_maintenance_module_elements.txt_Working_owners_february_edit.sendKeys(dataset.Test1);
    }

    @Test(priority = 66, testName = "(File Maintenance - edit) - Verify functionality A. Working Owners for March text box")
    public void test_March_Working_Owners_edit(){
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Working_owners_march_edit));
        File_maintenance_module_elements.txt_Working_owners_march_edit.clear();
        File_maintenance_module_elements.txt_Working_owners_march_edit.sendKeys(dataset.Test1);
    }

    @Test(priority = 67, testName = "(File Maintenance - edit) - Verify functionality 1. MANAGERS AND EXECUTIVES previous quarter text box")
    public void test_Prev_Managers_executive_edit() throws InterruptedException {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Managers_executive_prev_month_edit));
        File_maintenance_module_elements.txt_Managers_executive_prev_month_edit.clear();
        File_maintenance_module_elements.txt_Managers_executive_prev_month_edit.sendKeys(dataset.Test1);
    }

    @Test(priority = 68, testName = "(File Maintenance - edit) - Verify functionality 1. MANAGERS AND EXECUTIVES january text box")
    public void test_January_Managers_executive_edit() {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Managers_executive_january_edit));
        File_maintenance_module_elements.txt_Managers_executive_january_edit.clear();
        File_maintenance_module_elements.txt_Managers_executive_january_edit.sendKeys(dataset.Test1);
    }

    @Test(priority = 69, testName = "(File Maintenance - edit) - Verify functionality 1. MANAGERS AND EXECUTIVES February text box")
    public void test_February_Managers_executive_edit() {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Managers_executive_february_edit));
        File_maintenance_module_elements.txt_Managers_executive_february_edit.clear();
        File_maintenance_module_elements.txt_Managers_executive_february_edit.sendKeys(dataset.Test1);
    }

    @Test(priority = 70, testName = "(File Maintenance - edit) - Verify functionality 1. MANAGERS AND EXECUTIVES March text box")
    public void test_March_Managers_executive_edit() throws InterruptedException {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Managers_executive_march_edit));
        File_maintenance_module_elements.txt_Managers_executive_march_edit.clear();
        File_maintenance_module_elements.txt_Managers_executive_march_edit.sendKeys(dataset.Test1);
    }
    @Test(priority = 71, testName = "(File Maintenance - edit) - Verify functionality 3. Other Employees for previous quarter text box")
    public void test_Prev_Other_employees_edit() throws InterruptedException {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Other_employees_prev_month_edit));
        File_maintenance_module_elements.txt_Other_employees_prev_month_edit.clear();
        File_maintenance_module_elements.txt_Other_employees_prev_month_edit.sendKeys(dataset.Test1);

    }

    @Test(priority = 72, testName = "(File Maintenance - edit) - Verify functionality 3. Other Employees for january text box")
    public void test_January_Other_employees_edit() {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Other_employees_january_edit));
        File_maintenance_module_elements.txt_Other_employees_january_edit.clear();
        File_maintenance_module_elements.txt_Other_employees_january_edit.sendKeys(dataset.Test1);
    }

    @Test(priority = 73, testName = "(File Maintenance - edit) - Verify functionality 3. Other Employees for February text box")
    public void test_February_Other_employees_edit() {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Other_employees_february_edit));
        File_maintenance_module_elements.txt_Other_employees_february_edit.clear();
        File_maintenance_module_elements.txt_Other_employees_february_edit.sendKeys(dataset.Test1);
    }

    @Test(priority = 74, testName = "(File Maintenance - edit) - Verify functionality 3. Other Employees for March text box")
    public void test_March_Other_employees_edit() throws InterruptedException {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Other_employees_march_edit));
        File_maintenance_module_elements.txt_Other_employees_march_edit.clear();
        File_maintenance_module_elements.txt_Other_employees_march_edit.sendKeys(dataset.Test1);
    }

    @Test(priority = 75, testName = "(File Maintenance - edit) - Verify functionality 1. SALARIES OF MANAGERS AND EXECUTIVES for previous quarter text box")
    public void test_Prev_Manager_executive_edit() throws InterruptedException {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Salary_managers_prev_month_edit));
        File_maintenance_module_elements.txt_Salary_managers_prev_month_edit.clear();
        File_maintenance_module_elements.txt_Salary_managers_prev_month_edit.sendKeys(dataset.Test1);

    }

    @Test(priority = 76, testName = "(File Maintenance - edit) - Verify functionality 1. SALARIES OF MANAGERS AND EXECUTIVES for january text box")
    public void test_January_Manager_executive_edit() {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Salary_managers_january_edit));
        File_maintenance_module_elements.txt_Salary_managers_january_edit.clear();
        File_maintenance_module_elements.txt_Salary_managers_january_edit.sendKeys(dataset.Test1);
    }

    @Test(priority = 77, testName = "(File Maintenance - edit) - Verify functionality 1. SALARIES OF MANAGERS AND EXECUTIVES for February text box")
    public void test_February_Manager_executive_edit() {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Salary_managers_february_edit));
        File_maintenance_module_elements.txt_Salary_managers_february_edit.clear();
        File_maintenance_module_elements.txt_Salary_managers_february_edit.sendKeys(dataset.Test1);
    }

    @Test(priority = 78, testName = "(File Maintenance - edit) - Verify functionality 1. SALARIES OF MANAGERS AND EXECUTIVES for March text box")
    public void test_March_Manager_executive_edit() throws InterruptedException {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Salary_managers_march_edit));
        File_maintenance_module_elements.txt_Salary_managers_march_edit.clear();
        File_maintenance_module_elements.txt_Salary_managers_march_edit.sendKeys(dataset.Test1);
    }

    @Test(priority = 79, testName = "(File Maintenance - edit) - Verify functionality 3. SALARIES AND WAGES OF OTHER EMPLOYEES for previous quarter text box")
    public void test_Prev_OTHER_EMPLOYEES_edit() throws InterruptedException {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Salaries_wages_prev_month_edit));
        File_maintenance_module_elements.txt_Salaries_wages_prev_month_edit.clear();
        File_maintenance_module_elements.txt_Salaries_wages_prev_month_edit.sendKeys(dataset.Test1);

    }

    @Test(priority = 80, testName = "(File Maintenance - edit) - Verify functionality 3. SALARIES AND WAGES OF OTHER EMPLOYEES for january text box")
    public void test_January_OTHER_EMPLOYEES_edit() {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Salaries_wages_january_edit));
        File_maintenance_module_elements.txt_Salaries_wages_january_edit.clear();
        File_maintenance_module_elements.txt_Salaries_wages_january_edit.sendKeys(dataset.Test1);
    }

    @Test(priority = 81, testName = "(File Maintenance - edit) - Verify functionality 3. SALARIES AND WAGES OF OTHER EMPLOYEES for February text box")
    public void test_February_OTHER_EMPLOYEES_edit() {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Salaries_wages_february_edit));
        File_maintenance_module_elements.txt_Salaries_wages_february_edit.clear();
        File_maintenance_module_elements.txt_Salaries_wages_february_edit.sendKeys(dataset.Test1);
    }

    @Test(priority = 82, testName = "(File Maintenance - edit) - Verify functionality 3. SALARIES AND WAGES OF OTHER EMPLOYEES for March text box")
    public void test_March_OTHER_EMPLOYEES_edit() throws InterruptedException {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Salaries_wages_march_edit));
        File_maintenance_module_elements.txt_Salaries_wages_march_edit.clear();
        File_maintenance_module_elements.txt_Salaries_wages_march_edit.sendKeys(dataset.Test1);
    }


    @Test(priority = 83, testName = "(File Maintenance - edit) - Verify functionality B. EMPLOYER’S CONTRIBUTION TO SOCIAL SECURITY SYSTEM (SSS), GOVERNMENT SERVICE INSURANCE SYSTEM (GSIS), PHILHEALTH, AND OTHERSfor previous quarter text box")
    public void test_Prev_EMPLOYEES_CONTRIBUTION_edit() throws InterruptedException {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Employers_contribution_prev_month_edit));
        File_maintenance_module_elements.txt_Employers_contribution_prev_month_edit.clear();
        File_maintenance_module_elements.txt_Employers_contribution_prev_month_edit.sendKeys(dataset.Test1);

    }

    @Test(priority = 84, testName = "(File Maintenance - edit) - Verify functionality B. EMPLOYER’S CONTRIBUTION TO SOCIAL SECURITY SYSTEM (SSS), GOVERNMENT SERVICE INSURANCE SYSTEM (GSIS), PHILHEALTH, AND OTHERSfor january text box")
    public void test_January_EMPLOYEES_CONTRIBUTION_edit() {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Employers_contribution_january_edit));
        File_maintenance_module_elements.txt_Employers_contribution_january_edit.clear();
        File_maintenance_module_elements.txt_Employers_contribution_january_edit.sendKeys(dataset.Test1);
    }

    @Test(priority = 85, testName = "(File Maintenance - edit) - Verify functionality B. EMPLOYER’S CONTRIBUTION TO SOCIAL SECURITY SYSTEM (SSS), GOVERNMENT SERVICE INSURANCE SYSTEM (GSIS), PHILHEALTH, AND OTHERSfor February text box")
    public void test_February_EMPLOYEES_CONTRIBUTION_edit() {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Employers_contribution_february_edit));
        File_maintenance_module_elements.txt_Employers_contribution_february_edit.clear();
        File_maintenance_module_elements.txt_Employers_contribution_february_edit.sendKeys(dataset.Test1);
    }

    @Test(priority = 86, testName = "(File Maintenance - edit) - Verify functionality B. EMPLOYER’S CONTRIBUTION TO SOCIAL SECURITY SYSTEM (SSS), GOVERNMENT SERVICE INSURANCE SYSTEM (GSIS), PHILHEALTH, AND OTHERSfor March text box")
    public void test_March_EMPLOYEES_CONTRIBUTION_edit() throws InterruptedException {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Employers_contribution_march_edit));
        File_maintenance_module_elements.txt_Employers_contribution_march_edit.clear();
        File_maintenance_module_elements.txt_Employers_contribution_march_edit.sendKeys(dataset.Test1);
    }

    @Test(priority = 87, testName = "(File Maintenance - edit) - Verify functionality A. REVENUE/SALES FROM MAIN ECONOMIC ACTIVITY for Specify Main activity text box")
    public void test_Prev_REVENUE_SALES_specify_edit() throws InterruptedException {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Revenue_sale_other_specify_prev_month_edit));
        File_maintenance_module_elements.txt_Revenue_sale_other_specify_prev_month_edit.clear();
        File_maintenance_module_elements.txt_Revenue_sale_other_specify_prev_month_edit.sendKeys(dataset.Specify_Main_eco);

    }

    @Test(priority = 88, testName = "(File Maintenance - edit) - Verify functionality A. REVENUE/SALES FROM MAIN ECONOMIC ACTIVITY for previous quarter text box")
    public void test_Prev_REVENUE_SALES_edit() throws InterruptedException {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Revenue_sale_prev_month_edit));
        File_maintenance_module_elements.txt_Revenue_sale_prev_month_edit.clear();
        File_maintenance_module_elements.txt_Revenue_sale_prev_month_edit.sendKeys(dataset.Test1);

    }

    @Test(priority = 89, testName = "(File Maintenance - edit) - Verify functionality A. REVENUE/SALES FROM MAIN ECONOMIC ACTIVITY for january text box")
    public void test_January_REVENUE_SALES_edit() {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Revenue_sale_january_edit));
        File_maintenance_module_elements.txt_Revenue_sale_january_edit.clear();
        File_maintenance_module_elements.txt_Revenue_sale_january_edit.sendKeys(dataset.Test1);
    }

    @Test(priority = 90, testName = "(File Maintenance - edit) - Verify functionality A.  REVENUE/SALES FROM MAIN ECONOMIC ACTIVITY for February text box")
    public void test_February_REVENUE_SALES_edit() {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Revenue_sale_february_edit));
        File_maintenance_module_elements.txt_Revenue_sale_february_edit.clear();
        File_maintenance_module_elements.txt_Revenue_sale_february_edit.sendKeys(dataset.Test1);
    }

    @Test(priority = 91, testName = "(File Maintenance - edit) - Verify functionality A. REVENUE/SALES FROM MAIN ECONOMIC ACTIVITY for March text box")
    public void test_March_REVENUE_SALES_edit() throws InterruptedException {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Revenue_sale_march_edit));
        File_maintenance_module_elements.txt_Revenue_sale_march_edit.clear();
        File_maintenance_module_elements.txt_Revenue_sale_march_edit.sendKeys(dataset.Test1);

    }


    @Test(priority = 92, testName = "(File Maintenance - edit) - Verify functionality B. OTHER INCOME for Specify Main activity text box")
    public void test_Prev_Other_income_specify_edit() throws InterruptedException {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Other_income_other_specify_prev_month_edit));
        File_maintenance_module_elements.txt_Other_income_other_specify_prev_month_edit.clear();
        File_maintenance_module_elements.txt_Other_income_other_specify_prev_month_edit.sendKeys(dataset.Specify_Other_income);

    }

    @Test(priority = 93, testName = "(File Maintenance - edit) - Verify functionality B. OTHER INCOME for previous quarter text box")
    public void test_Prev_Other_income_edit() throws InterruptedException {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Other_income_prev_month_edit));
        File_maintenance_module_elements.txt_Other_income_prev_month_edit.clear();
        File_maintenance_module_elements.txt_Other_income_prev_month_edit.sendKeys(dataset.Test1);

    }

    @Test(priority = 94, testName = "(File Maintenance - edit) - Verify functionality B. OTHER INCOME for january text box")
    public void test_January_Other_income_edit() {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Other_income_january_edit));
        File_maintenance_module_elements.txt_Other_income_january_edit.clear();
        File_maintenance_module_elements.txt_Other_income_january_edit.sendKeys(dataset.Test1);
    }

    @Test(priority = 95, testName = "(File Maintenance - edit) - Verify functionality B. OTHER INCOME for February text box")
    public void test_February_Other_income_edit() {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Other_income_february_edit));
        File_maintenance_module_elements.txt_Other_income_february_edit.clear();
        File_maintenance_module_elements.txt_Other_income_february_edit.sendKeys(dataset.Test1);
    }

    @Test(priority = 96, testName = "(File Maintenance - edit) - Verify functionality B. OTHER INCOME for March text box")
    public void test_March_Other_income_edit() throws InterruptedException {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Other_income_march_edit));
        File_maintenance_module_elements.txt_Other_income_march_edit.clear();
        File_maintenance_module_elements.txt_Other_income_march_edit.sendKeys(dataset.Test1);

    }

    @Test(priority = 97, testName = "(File Maintenance - edit) - Verify functionality E. GOODS FOR RESALE for January text box")
    public void test_January_GOODS_RESALE_edit() {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_GOODS_FOR_RESALE_january_edit));
        File_maintenance_module_elements.txt_GOODS_FOR_RESALE_january_edit.clear();
        File_maintenance_module_elements.txt_GOODS_FOR_RESALE_january_edit.sendKeys(dataset.Test1);
    }

    @Test(priority = 98, testName = "(File Maintenance - edit) - Verify functionality E. GOODS FOR RESALE for March text box")
    public void test_March_GOODS_RESALE_edit() throws InterruptedException {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_GOODS_FOR_RESALE_march_edit));
        File_maintenance_module_elements.txt_GOODS_FOR_RESALE_march_edit.clear();
        File_maintenance_module_elements.txt_GOODS_FOR_RESALE_march_edit.sendKeys(dataset.Test1);

    }

    @Test(priority = 99, testName = "(File Maintenance - edit) - Verify functionality F. OTHER INVENTORIES for January text box")
    public void test_January_OTHER_INVENTORIES_edit() {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_OTHER_INVENTORIES_january_edit));
        File_maintenance_module_elements.txt_OTHER_INVENTORIES_january_edit.clear();
        File_maintenance_module_elements.txt_OTHER_INVENTORIES_january_edit.sendKeys(dataset.Test1);
    }

    @Test(priority = 100, testName = "(File Maintenance - edit) - Verify functionality F. OTHER INVENTORIES for March text box")
    public void test_March_OTHER_INVENTORIES_edit() throws InterruptedException {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_OTHER_INVENTORIES_march_edit));
        File_maintenance_module_elements.txt_OTHER_INVENTORIES_march_edit.clear();
        File_maintenance_module_elements.txt_OTHER_INVENTORIES_march_edit.sendKeys(dataset.Test1);

    }

    @Test(priority = 101, testName = "(File Maintenance - edit) - Verify functionality Description of this establishment's Main Economic (Principal) Activity: text box")
    public void test_Description_edit() throws InterruptedException {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Description_of_MEA_edit));
        File_maintenance_module_elements.txt_Description_of_MEA_edit.clear();
        File_maintenance_module_elements.txt_Description_of_MEA_edit.sendKeys(dataset.Description);

    }

    @Test(priority = 102, testName = "(File Maintenance - edit) - Verify functionality Remarks: text box")
    public void test_Remarks_edit() throws InterruptedException {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Remarks_edit));
        File_maintenance_module_elements.txt_Remarks_edit.clear();
        File_maintenance_module_elements.txt_Remarks_edit.sendKeys(dataset.Remarks);
    }

    @Test(priority = 103, testName = "(File Maintenance - edit) - Verify functionality Name of Official text box")
    public void test_Name_edit() throws InterruptedException {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Name_edit));
        File_maintenance_module_elements.txt_Name_edit.clear();
        File_maintenance_module_elements.txt_Name_edit.sendKeys(dataset.Name);
    }

    @Test(priority = 104, testName = "(File Maintenance - edit) - Verify functionality Designation text box")
    public void test_Designation_edit() throws InterruptedException {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Designation_edit));
        File_maintenance_module_elements.txt_Designation_edit.clear();
        File_maintenance_module_elements.txt_Designation_edit.sendKeys(dataset.Designation);
    }

    @Test(priority = 105, testName = "(File Maintenance - edit) - Verify functionality Contact Number text box")
    public void test_Cont_No_edit() throws InterruptedException {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Contact_number_edit));
        File_maintenance_module_elements.txt_Contact_number_edit.clear();
        File_maintenance_module_elements.txt_Contact_number_edit.sendKeys(dataset.Contact);
    }

    @Test(priority = 106, testName = "(File Maintenance - edit) - Verify functionality Email text box")
    public void test_Email_edit() throws InterruptedException {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Email_edit));
        File_maintenance_module_elements.txt_Email_edit.clear();
        File_maintenance_module_elements.txt_Email_edit.sendKeys(dataset.Email);
    }

    @Test(priority = 107, testName = "(File Maintenance - edit) - Verify functionality Website text box")
    public void test_Web_edit() throws InterruptedException {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_Website_edit));
        File_maintenance_module_elements.txt_Website_edit.clear();
        File_maintenance_module_elements.txt_Website_edit.sendKeys(dataset.Website);
    }

    @Test(priority = 108, testName = "(File Maintenance) - Verify functionality of File Maintenance Tab")
    public void test_Tab_File_Maintenance3() {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        try {
            eWait.until(ExpectedConditions.elementToBeClickable(File_maintenance_module_elements.Tab_File_Maintenance));
            File_maintenance_module_elements.Tab_File_Maintenance.click();
        } catch (StaleElementReferenceException e) {
            System.out.println("error "+ e);
        }
    }

    @Test(priority = 109, testName = "(File Maintenance - edit) - Verify functionality Search text box")
    public void test_Search() throws InterruptedException {
        WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        eWait.until(ExpectedConditions.visibilityOf(File_maintenance_module_elements.txt_search));
        File_maintenance_module_elements.txt_search.sendKeys(dataset.Search);
        sleep(10000);
    }

    @Test(priority = 110, testName = "Click logout")
    public void test_button_logout() {
        Login_module_elements login = new Login_module_elements(driver);
        try {
            WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
            eWait.until(ExpectedConditions.elementToBeClickable(login.btn_logout));

            login.btn_logout.click();
        } catch (StaleElementReferenceException e) {
            System.out.println("Element is no longer present, re-locating and retrying...");
            WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(60));
            eWait.until(ExpectedConditions.elementToBeClickable(login.btn_logout));

            login.btn_logout.click();
        }
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        // Quit WebDriver
        if (driver != null) {
            sleep(5000);
            driver.quit();
        }
    }
}