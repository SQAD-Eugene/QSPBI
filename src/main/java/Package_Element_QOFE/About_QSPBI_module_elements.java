package Package_Element_QOFE;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class About_QSPBI_module_elements {

    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"__BVID__33__BV_toggle_\"]")
    public WebElement About_QSPBI_Tab;

    @FindBy(linkText = "Overview of QSPBI")
    public WebElement Overview_QSPBI_dd;

    @FindBy(linkText = "Concepts and Definitions")
    public WebElement Concept_definition_dd;

    @FindBy(linkText = "QNAP Releases")
    public WebElement QNAP_Release_dd;

    @FindBy(xpath = "//*[@id=\"#content\"]/div/div")
    public WebElement Overview_page;

    @FindBy(xpath = "//*[@id=\"#content\"]/div/div/div/div")
    public WebElement Concepts_Definitions_page;

    @FindBy(xpath = "//*[@id=\"#content\"]/div/div/div/div")
    public WebElement QNAP_page;



    public About_QSPBI_module_elements(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
