package Package_Element_DPS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class File_maintenance_module_elements {

    WebDriver driver;


    @FindBy(linkText = "Encode Data")
    public static WebElement btn_Encode_Data;

    @FindBy(xpath = "//input[@placeholder='Search for ECN']")
    public static WebElement txt_ECN;

    @FindBy(xpath ="//button[contains(.,'Go Back To Data Entries')]")
    public static WebElement btn_DataEntries;

    @FindBy(linkText = "File Maintenance")
    public static WebElement Tab_File_Maintenance;

    @FindBy(xpath = "//*[@id=\"__BVID__84\"]/div/div/div[2]/a")
    public static WebElement List_ECN;

    @FindBy(xpath = "//select[@placeholder='Select']")
    public static WebElement dropdown_Status;

    @FindBy(xpath = "//input[@placeholder='Enter business name of sample establishment']")
    public static WebElement txt_B_name;

    @FindBy(xpath = "//input[@placeholder='Enter business address of sample establishment']")
    public static WebElement txt_B_address;

    @FindBy(xpath = "//input[@placeholder='Enter tax identification number']")
    public static WebElement txt_TIN;

    @FindBy(xpath = "//*[@id=\"__BVID__136\"]")
    public static WebElement txt_Working_owners_prev_month;

    @FindBy(xpath = "//*[@id=\"__BVID__139\"]")
    public static WebElement txt_Working_owners_january;

    @FindBy(xpath = "//*[@id=\"__BVID__142\"]")
    public static WebElement txt_Working_owners_february;

    @FindBy(xpath = "//*[@id=\"__BVID__145\"]")
    public static WebElement txt_Working_owners_march;

    @FindBy(xpath = "//*[@id=\"__BVID__178\"]")
    public static WebElement txt_Managers_executive_prev_month;

    @FindBy(xpath = "//*[@id=\"__BVID__181\"]")
    public static WebElement txt_Managers_executive_january;

    @FindBy(xpath = "//*[@id=\"__BVID__184\"]")
    public static WebElement txt_Managers_executive_february;

    @FindBy(xpath = "//*[@id=\"__BVID__187\"]")
    public static WebElement txt_Managers_executive_march;

    @FindBy(xpath = "//*[@id=\"__BVID__223\"]")
    public static WebElement txt_Other_employees_prev_month;

    @FindBy(xpath = "//*[@id=\"__BVID__226\"]")
    public static WebElement txt_Other_employees_january;

    @FindBy(xpath = "//*[@id=\"__BVID__229\"]")
    public static WebElement txt_Other_employees_february;

    @FindBy(xpath = "//*[@id=\"__BVID__232\"]")
    public static WebElement txt_Other_employees_march;

    @FindBy(xpath = "//*[@id=\"__BVID__282\"]")
    public static WebElement txt_Salary_managers_prev_month;

    @FindBy(xpath = "//*[@id=\"__BVID__285\"]")
    public static WebElement txt_Salary_managers_january;

    @FindBy(xpath = "//*[@id=\"__BVID__288\"]")
    public static WebElement txt_Salary_managers_february;

    @FindBy(xpath = "//*[@id=\"__BVID__291\"]")
    public static WebElement txt_Salary_managers_march;


    @FindBy(xpath = "//*[@id=\"__BVID__324\"]")
    public static WebElement txt_Salaries_wages_prev_month;

    @FindBy(xpath = "//*[@id=\"__BVID__327\"]")
    public static WebElement txt_Salaries_wages_january;

    @FindBy(xpath = "//*[@id=\"__BVID__330\"]")
    public static WebElement txt_Salaries_wages_february;

    @FindBy(xpath = "//*[@id=\"__BVID__333\"]")
    public static WebElement txt_Salaries_wages_march;

    @FindBy(xpath = "//*[@id=\"__BVID__346\"]")
    public static WebElement txt_Employers_contribution_prev_month;

    @FindBy(xpath = "//*[@id=\"__BVID__349\"]")
    public static WebElement txt_Employers_contribution_january;

    @FindBy(xpath = "//*[@id=\"__BVID__352\"]")
    public static WebElement txt_Employers_contribution_february;

    @FindBy(xpath = "//*[@id=\"__BVID__355\"]")
    public static WebElement txt_Employers_contribution_march;

    @FindBy(xpath = "//*[@id=\"__BVID__407\"]")
    public static WebElement txt_Revenue_sale_other_specify_prev_month;

    @FindBy(xpath = "//*[@id=\"__BVID__410\"]")
    public static WebElement txt_Revenue_sale_prev_month;

    @FindBy(xpath = "//*[@id=\"__BVID__413\"]")
    public static WebElement txt_Revenue_sale_january;

    @FindBy(xpath = "//*[@id=\"__BVID__416\"]")
    public static WebElement txt_Revenue_sale_february;

    @FindBy(xpath = "//*[@id=\"__BVID__419\"]")
    public static WebElement txt_Revenue_sale_march;

    @FindBy(xpath = "//*[@id=\"__BVID__430\"]")
    public static WebElement txt_Other_income_other_specify_prev_month;

    @FindBy(xpath = "//*[@id=\"__BVID__433\"]")
    public static WebElement txt_Other_income_prev_month;

    @FindBy(xpath = "//*[@id=\"__BVID__436\"]")
    public static WebElement txt_Other_income_january;

    @FindBy(xpath = "//*[@id=\"__BVID__439\"]")
    public static WebElement txt_Other_income_february;

    @FindBy(xpath = "//*[@id=\"__BVID__442\"]")
    public static WebElement txt_Other_income_march;

    @FindBy(xpath = "//*[@id=\"__BVID__515\"]")
    public static WebElement txt_GOODS_FOR_RESALE_january;

    @FindBy(xpath = "//*[@id=\"__BVID__519\"]")
    public static WebElement txt_GOODS_FOR_RESALE_march;

    @FindBy(xpath = "//*[@id=\"__BVID__528\"]")
    public static WebElement txt_OTHER_INVENTORIES_january;

    @FindBy(xpath = "//*[@id=\"__BVID__532\"]")
    public static WebElement txt_OTHER_INVENTORIES_march;

    @FindBy(xpath = "//*[@id=\"form_data.cert_mea\"]")
    public static WebElement txt_Description_of_MEA;

    @FindBy(xpath = "//*[@id=\"form_data.cert_remarks\"]")
    public static WebElement txt_Remarks;

    @FindBy(xpath = "//*[@id=\"form_data.cert_name\"]")
    public static WebElement txt_Name;

    @FindBy(xpath = "//*[@id=\"form_data.cert_designation\"]")
    public static WebElement txt_Designation;

    @FindBy(xpath = "//*[@id=\"form_data.cert_contact_number\"]")
    public static WebElement txt_Contact_number;

    @FindBy(xpath = "//*[@id=\"form_data.cert_email\"]")
    public static WebElement txt_Email;

    @FindBy(xpath = "//*[@id=\"form_data.cert_website\"]")
    public static WebElement txt_Website;

    @FindBy(xpath ="//button[contains(.,'Clear Encoded Data')]")
    public static WebElement btn_Clear_data;

    @FindBy(xpath ="//button[contains(.,'Save Data')]")
    public static WebElement btn_Save_date;

    @FindBy(css ="svg[aria-label='eye']")
    public static WebElement btn_View;

    @FindBy(xpath ="//button[contains(.,'Edit Data')]")
    public static WebElement btn_Edit_data;

    @FindBy(xpath = "//*[@id=\"__BVID__123\"]")
    public static WebElement txt_Working_owners_prev_month_edit;

    @FindBy(xpath = "//*[@id=\"__BVID__126\"]")
    public static WebElement txt_Working_owners_january_edit;

    @FindBy(xpath = "//*[@id=\"__BVID__129\"]")
    public static WebElement txt_Working_owners_february_edit;

    @FindBy(xpath = "//*[@id=\"__BVID__132\"]")
    public static WebElement txt_Working_owners_march_edit;

    @FindBy(xpath = "//*[@id=\"__BVID__165\"]")
    public static WebElement txt_Managers_executive_prev_month_edit;

    @FindBy(xpath = "//*[@id=\"__BVID__168\"]")
    public static WebElement txt_Managers_executive_january_edit;

    @FindBy(xpath = "//*[@id=\"__BVID__171\"]")
    public static WebElement txt_Managers_executive_february_edit;

    @FindBy(xpath = "//*[@id=\"__BVID__174\"]")
    public static WebElement txt_Managers_executive_march_edit;

    @FindBy(xpath = "//*[@id=\"__BVID__210\"]")
    public static WebElement txt_Other_employees_prev_month_edit;

    @FindBy(xpath = "//*[@id=\"__BVID__213\"]")
    public static WebElement txt_Other_employees_january_edit;

    @FindBy(xpath = "//*[@id=\"__BVID__216\"]")
    public static WebElement txt_Other_employees_february_edit;

    @FindBy(xpath = "//*[@id=\"__BVID__219\"]")
    public static WebElement txt_Other_employees_march_edit;

    @FindBy(xpath = "//*[@id=\"__BVID__269\"]")
    public static WebElement txt_Salary_managers_prev_month_edit;

    @FindBy(xpath = "//*[@id=\"__BVID__272\"]")
    public static WebElement txt_Salary_managers_january_edit;

    @FindBy(xpath = "//*[@id=\"__BVID__275\"]")
    public static WebElement txt_Salary_managers_february_edit;

    @FindBy(xpath = "//*[@id=\"__BVID__278\"]")
    public static WebElement txt_Salary_managers_march_edit;


    @FindBy(xpath = "//*[@id=\"__BVID__311\"]")
    public static WebElement txt_Salaries_wages_prev_month_edit;

    @FindBy(xpath = "//*[@id=\"__BVID__314\"]")
    public static WebElement txt_Salaries_wages_january_edit;

    @FindBy(xpath = "//*[@id=\"__BVID__317\"]")
    public static WebElement txt_Salaries_wages_february_edit;

    @FindBy(xpath = "//*[@id=\"__BVID__320\"]")
    public static WebElement txt_Salaries_wages_march_edit;

    @FindBy(xpath = "//*[@id=\"__BVID__333\"]")
    public static WebElement txt_Employers_contribution_prev_month_edit;

    @FindBy(xpath = "//*[@id=\"__BVID__336\"]")
    public static WebElement txt_Employers_contribution_january_edit;

    @FindBy(xpath = "//*[@id=\"__BVID__339\"]")
    public static WebElement txt_Employers_contribution_february_edit;

    @FindBy(xpath = "//*[@id=\"__BVID__342\"]")
    public static WebElement txt_Employers_contribution_march_edit;

    @FindBy(xpath = "//*[@id=\"__BVID__394\"]")
    public static WebElement txt_Revenue_sale_other_specify_prev_month_edit;

    @FindBy(xpath = "//*[@id=\"__BVID__397\"]")
    public static WebElement txt_Revenue_sale_prev_month_edit;

    @FindBy(xpath = "//*[@id=\"__BVID__400\"]")
    public static WebElement txt_Revenue_sale_january_edit;

    @FindBy(xpath = "//*[@id=\"__BVID__403\"]")
    public static WebElement txt_Revenue_sale_february_edit;

    @FindBy(xpath = "//*[@id=\"__BVID__406\"]")
    public static WebElement txt_Revenue_sale_march_edit;

    @FindBy(xpath = "//*[@id=\"__BVID__417\"]")
    public static WebElement txt_Other_income_other_specify_prev_month_edit;

    @FindBy(xpath = "//*[@id=\"__BVID__420\"]")
    public static WebElement txt_Other_income_prev_month_edit;

    @FindBy(xpath = "//*[@id=\"__BVID__423\"]")
    public static WebElement txt_Other_income_january_edit;

    @FindBy(xpath = "//*[@id=\"__BVID__426\"]")
    public static WebElement txt_Other_income_february_edit;

    @FindBy(xpath = "//*[@id=\"__BVID__429\"]")
    public static WebElement txt_Other_income_march_edit;

    @FindBy(xpath = "//*[@id=\"__BVID__502\"]")
    public static WebElement txt_GOODS_FOR_RESALE_january_edit;

    @FindBy(xpath = "//*[@id=\"__BVID__506\"]")
    public static WebElement txt_GOODS_FOR_RESALE_march_edit;

    @FindBy(xpath = "//*[@id=\"__BVID__515\"]")
    public static WebElement txt_OTHER_INVENTORIES_january_edit;

    @FindBy(xpath = "//*[@id=\"__BVID__519\"]")
    public static WebElement txt_OTHER_INVENTORIES_march_edit;

    @FindBy(xpath = "//*[@id=\"form_data.cert_mea\"]")
    public static WebElement txt_Description_of_MEA_edit;

    @FindBy(xpath = "//*[@id=\"form_data.cert_remarks\"]")
    public static WebElement txt_Remarks_edit;

    @FindBy(xpath = "//*[@id=\"form_data.cert_name\"]")
    public static WebElement txt_Name_edit;

    @FindBy(xpath = "//*[@id=\"form_data.cert_designation\"]")
    public static WebElement txt_Designation_edit;

    @FindBy(xpath = "//*[@id=\"form_data.cert_contact_number\"]")
    public static WebElement txt_Contact_number_edit;

    @FindBy(xpath = "//*[@id=\"form_data.cert_email\"]")
    public static WebElement txt_Email_edit;
    @FindBy(xpath = "//*[@id=\"form_data.cert_website\"]")
    public static WebElement txt_Website_edit;

    @FindBy(xpath = "//input[@placeholder='Type to Search']")
    public static WebElement txt_search;






    public File_maintenance_module_elements (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
