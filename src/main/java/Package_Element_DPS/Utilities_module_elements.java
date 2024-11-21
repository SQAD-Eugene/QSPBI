package Package_Element_DPS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Utilities_module_elements {


    WebDriver driver;

    @FindBy(linkText = "Utilities")
    public  WebElement Tab_Utilities;

    @FindBy(id = "__BVID__30__BV_toggle_")
    public  WebElement dd_Utilities;

    @FindBy(id = "__BVID__53__BV_toggle_")
    public  WebElement dd_Utilities1;

    @FindBy(id = "__BVID__54__BV_toggle_")
    public  WebElement dd_Utilities2;

    @FindBy(id = "__BVID__49__BV_toggle_")
    public  WebElement dd_Utilities3;

    @FindBy(id = "__BVID__37__BV_toggle_")
    public  WebElement dd_Utilities4;

    @FindBy(id = "__BVID__45__BV_toggle_")
    public  WebElement dd_Utilities5;

    @FindBy(id = "__BVID__32__BV_toggle_")
    public  WebElement dd_User_account;
    @FindBy(id = "__BVID__55__BV_toggle_")
    public  WebElement dd_User_account1;

    @FindBy(id = "__BVID__56__BV_toggle_")
    public  WebElement dd_User_account2;

    @FindBy(id = "__BVID__49__BV_toggle_")
    public  WebElement dd_Others;

    @FindBy(id = "__BVID__57__BV_toggle_")
    public  WebElement dd_Others3;
    @FindBy(linkText = "Manage Reference File")
    public  WebElement Tab_Manage_Reference_File;

    @FindBy(linkText = "Address Stub and Control List")
    public  WebElement Tab_Address_Stub_Control;

    @FindBy(linkText = "Create Account")
    public  WebElement Tab_create_Account;

    @FindBy(linkText = "Active Accounts")
    public  WebElement Tab_Active_Account;

    @FindBy(linkText = "Update Characteristics")
    public  WebElement Tab_Update_char;

    @FindBy(linkText = "Update Characteristics")
    public  WebElement Tab_Inactive_Account;

    @FindBy(xpath = "//input[@placeholder='Enter employee number']")
    public  WebElement txt_Employee_number;

    @FindBy(xpath = "//input[@placeholder='Enter last name']")
    public  WebElement txt_Last_name;

    @FindBy(xpath = "//input[@placeholder='Enter first name']")
    public  WebElement txt_First_name;

    @FindBy(xpath = "//input[@placeholder='Enter middle name']")
    public  WebElement txt_Middle_name;

    @FindBy(xpath = "//input[@placeholder='Enter email']")
    public  WebElement txt_Email;

    @FindBy(xpath = "//input[@placeholder='Enter password']")
    public  WebElement txt_Password;

    @FindBy(xpath ="//select[contains(.,'- Select office -')]")
    public  WebElement dd_office;

    @FindBy(xpath ="//select[contains(.,'- Select role -')]")
    public  WebElement dd_role;

    @FindBy(xpath ="//*[@id=\"__BVID__24\"]/tbody/tr[1]/td[6]/div/div/div/div/a[1]")
    public  WebElement icon_view;

    @FindBy(linkText ="Edit Account")
    public  WebElement btn_Edit_account;

    @FindBy(linkText ="Inactive Accounts")
    public  WebElement btn_inactive_account;

    @FindBy(xpath = "//input[@placeholder='Enter last name']")
    public  WebElement txt_edit_lastname;

    @FindBy(xpath = "//input[@placeholder='Enter first name']")
    public  WebElement txt_edit_firstname;

    @FindBy(xpath = "//input[@placeholder='Enter middle name']")
    public  WebElement txt_edit_middlename;

    @FindBy(xpath ="//button[contains(.,'Change Password')]")
    public  WebElement btn_edit_changepassword;

    @FindBy(xpath = "//input[@placeholder='Enter password']")
    public  WebElement txt_edit_changepassword;

    @FindBy(xpath ="//button[contains(.,'Update Account')]")
    public  WebElement btn_edit_Update_account;

    @FindBy(xpath = "//*[@id=\"__BVID__24\"]/tbody/tr[2]/td[6]/div/div/div/div/a[3]/svg")
    public  WebElement icon_deactivate;

    @FindBy(xpath ="//button[contains(.,'Cancel')]")
    public  WebElement btn_Cancel;

    @FindBy(xpath ="//button[contains(.,'Deactivate')]")
    public  WebElement btn_Deactivate;

    @FindBy(xpath ="//*[@id=\"radio-group-1\"]/div[1]/label")
    public  WebElement rad_Address_stub;

    @FindBy(xpath ="//*[@id=\"radio-group-1\"]/div[2]/label")
    public  WebElement rad_Control_list;

    @FindBy(xpath ="//*[@id=\"radio-group-2\"]/div[1]/label")
    public WebElement rad_One;

    @FindBy(xpath ="//*[@id=\"radio-group-2\"]/div[2]/label")
    public WebElement rad_Two;

    @FindBy(xpath ="//select[contains(.,'Select Region')]")
    public WebElement dd_Region;

    @FindBy(id ="additional_filter.province")
    public WebElement dd_Province;

    @FindBy(id ="per_page_select")
    public WebElement dd_Perpage;

    @FindBy(xpath = "//input[@placeholder='Type to Search']")
    public WebElement txt_search;

    @FindBy(xpath = "//*[@id=\"__BVID__26\"]/tbody/tr/td[8]/div/div/div/div/a[3]/svg")
    public WebElement btn_Rep_ECN;

    @FindBy(linkText = "Help")
    public WebElement Tab_Help;



    public Utilities_module_elements (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}

