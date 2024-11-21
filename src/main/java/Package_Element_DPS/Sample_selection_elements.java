package Package_Element_DPS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Sample_selection_elements {

    WebDriver driver;

    @FindBy(linkText = "Sample Selection")
    public static WebElement Tab_Sample_selection;

    public Sample_selection_elements (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
