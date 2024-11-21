package Package_Element_QOFE;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Statistics_module_elements {

    WebDriver driver;

    @FindBy(linkText = "About QSPBI")
    public static WebElement btn_about;

    public Statistics_module_elements(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
