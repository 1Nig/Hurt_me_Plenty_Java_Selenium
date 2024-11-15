package PageObject;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class EstimateSummary {

    WebDriver driver;
    WebDriverWait wait;

    public EstimateSummary(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//a[@class='pYTkkf-Bz112c-mRLv6 pYTkkf-Bz112c-RLmnJb' and @aria-label='Open detailed view']")
    public WebElement EstimateSummary;


    public GoogleCloudCalculatorPage clickGoogleCloudCalculatorLink() {
        EstimateSummary.click();
        return new GoogleCloudCalculatorPage(driver);
    }

    @FindBy(xpath = "//span[contains(text(), \"standard\")]")
    public WebElement Instance_type;
    public String getInstance_type() {
        return Instance_type.getText();
    }
    @FindBy(xpath = "//*[contains(text(), \"South Carolina\")]")
    public WebElement getRegion;
    public String region() {
        return getRegion.getText();
            }
    @FindBy(xpath = "//*[contains(text(), \"2x375 GB\")]")
    public WebElement LocalSSD;
    public String LocalSSD_type() {
        return LocalSSD.getText();
    }
    @FindBy(xpath = "//*[text()='Regular']")
    public WebElement VM_Class;
    public String VM_Class_type() {
        return VM_Class.getText();
    }
    @FindBy(xpath = "//*[contains(text(), 'Compute')]/following-sibling::div)")
    public WebElement ResultSum;
    public String ResultSumMoney() {
        return ResultSum.getText();
    }
    @FindBy(xpath = "//*[contains(text(), \"1 year\")]")
    public WebElement Commit_term;
    public String Commit_term_() {
        return Commit_term.getText();

    }
}