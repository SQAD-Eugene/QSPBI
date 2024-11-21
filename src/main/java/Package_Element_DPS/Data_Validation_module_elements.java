package Package_Element_DPS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Data_Validation_module_elements {

    WebDriver driver;

    @FindBy(linkText = "Data Validation")
    public static WebElement Tab_File_Data_validation;

    @FindBy(xpath = "//*[@id=\"per_page_select\"]")
    public static WebElement dropdown_Page;

    @FindBy(xpath = "//*[@id=\"filter_input\"]")
    public static WebElement txt_Search;

    @FindBy(xpath ="//button[contains(.,'Select All')]")
    public static WebElement btn_Select_all;

    @FindBy(xpath ="//button[contains(.,'Clear Selected')]")
    public static WebElement btn_Clear_selected;

    @FindBy(xpath ="//button[contains(.,'Validate')]")
    public static WebElement btn_validate;

    @FindBy(xpath ="//button[contains(.,'For Tabulation')]")
    public static WebElement btn_tabulation;

    @FindBy(xpath ="//*[@id=\"__BVID__27\"]/tbody/tr[2]/td[2]/div")
    public static WebElement tr_ECN;

    @FindBy(xpath ="//*[@id=\"__BVID__27\"]/tbody/tr[5]/td[2]/div")
    public static WebElement tr_ECN1;

    @FindBy(xpath ="//*[@id=\"__BVID__27\"]/tbody/tr[8]/td[2]/div")
    public static WebElement tr_ECN2;


    public Data_Validation_module_elements (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
