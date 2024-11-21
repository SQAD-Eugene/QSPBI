package Package_Element_DPS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Tabulation_module_elements {

    WebDriver driver;

    @FindBy(linkText = "Tabulation")
    public static WebElement Tab_Tabulation;


    @FindBy(xpath = "//*[@id=\"radio-group-1\"]/div[1]/label")
    public static WebElement rad_posting_sheet;

    @FindBy(xpath = "//*[@id=\"radio-group-1\"]/div[2]/label")
    public static WebElement rad_Retail_trade_data;

    @FindBy(xpath = "//*[@id=\"radio-group-1\"]/div[3]/label")
    public static WebElement rad_BPM_table;

    @FindBy(xpath = "//*[@id=\"radio-group-1\"]/div[4]/label")
    public static WebElement rad_Compare_posting_sheets;

    @FindBy(xpath ="//button[contains(.,'Generate')]")
    public static WebElement btn_Generate;

    @FindBy(xpath = "//*[@id=\"table-tab2_filter\"]/label/input")
    public static WebElement txt_Search;

    @FindBy(xpath = "//*[@id=\"tabSector\"]")
    public static WebElement dd_sector;

    @FindBy(xpath = "//*[@id=\"pstitle\"]")
    public static WebElement dd_select_table;

    @FindBy(xpath = "//*[@id=\"table-bpm_filter\"]/label/input")
    public static WebElement txt_Search2;


    public Tabulation_module_elements (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
