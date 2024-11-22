package Package_Element_QOFE;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_module_elements_QOFE {

    WebDriver driver;

    @FindBy(linkText = "Login")
    public static WebElement Tab_Login;

    @FindBy(xpath = "//input[@placeholder='Enter ECN']")
    public static WebElement txt_ECN;

    @FindBy(xpath = "//input[@placeholder='Enter password']")
    public static WebElement txt_Password;

    @FindBy(xpath ="//button[contains(.,'Log In')]")
    public static WebElement btn_login;

    @FindBy(linkText = "Logout")
    public static WebElement btn_logout;

    @FindBy(linkText = "Logout1")
    public static WebElement btn_logout1;

    public Login_module_elements_QOFE (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
