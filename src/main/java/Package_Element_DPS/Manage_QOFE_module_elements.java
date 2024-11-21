package Package_Element_DPS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Manage_QOFE_module_elements {

    WebDriver driver;

    @FindBy(linkText = "Manage QOFE")
    public static WebElement Tab_Manage_QOFE;

    @FindBy(xpath ="//button[contains(.,'Register Account')]")
    public static WebElement btn_Register_account;

    @FindBy(xpath = "//input[@placeholder='Enter ECN']")
    public static WebElement txt_ECN;

    @FindBy(xpath = "//input[@placeholder='Enter email address']")
    public static WebElement txt_Email;

    @FindBy(id ="__BVID__162")
    public static WebElement dd_Status;

    @FindBy(xpath ="//button[contains(.,'Register')]")
    public static WebElement btn_Register;

    @FindBy(xpath ="//button[contains(.,'Cancel')]")
    public static WebElement btn_Cancel;

    @FindBy(id ="per_page_select")
    public static WebElement dd_Perpage;

    @FindBy(xpath = "//input[@placeholder='Type to Search']")
    public static WebElement txt_Search;


    public Manage_QOFE_module_elements (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
