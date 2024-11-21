package Package_Element_DPS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_module_elements {
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"__BVID__56\"]")
    public WebElement dropdown_Year;

    @FindBy(xpath = "//*[@id=\"__BVID__57\"]")
    public WebElement dropdown_Quarter;

    @FindBy(xpath ="//button[contains(.,'OK')]")
    public WebElement btn_OK;

    public Home_module_elements (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
