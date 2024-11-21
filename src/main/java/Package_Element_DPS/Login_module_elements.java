package Package_Element_DPS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_module_elements {
    WebDriver driver;

    @FindBy(xpath = "//input[@placeholder='Enter email address']")
    public WebElement txt_E_add;

    @FindBy(xpath = "//input[@placeholder='Enter password']")
    public WebElement txt_Password;

    @FindBy(xpath ="//button[contains(.,'Log In')]")
    public WebElement btn_login;

    @FindBy(xpath ="//button[contains(.,'Ok')]")
    public WebElement btn_OK;
    @FindBy(xpath = "//*[@id=\"log-out-icon\"]")
    public WebElement btn_logout;

    @FindBy(xpath = "//legend[contains(text(),\"Email Address\")]")
    public WebElement lbl_email;

    @FindBy(xpath = "//legend[contains(text(),\"Password:\")]")
    public WebElement lbl_password;


    public Login_module_elements (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
}
