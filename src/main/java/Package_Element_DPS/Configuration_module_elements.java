package Package_Element_DPS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Configuration_module_elements {

    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"__BVID__57\"]")
    public static WebElement dropdown_Year;

    @FindBy(xpath = "//*[@id=\"__BVID__58\"]")
    public static WebElement dropdown_Quarter;

    @FindBy(xpath ="//button[contains(.,'OK')]")
    public static WebElement btn_OK;

    @FindBy(linkText = "Configuration")
    public static WebElement Tab_Configuration;

    public Configuration_module_elements (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
