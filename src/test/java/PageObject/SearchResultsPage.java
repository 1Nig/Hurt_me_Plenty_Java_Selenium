package PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class SearchResultsPage {
    WebDriver driver;
    WebDriverWait wait;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='https://cloud.google.com/products/calculator']")
    public WebElement GoogleCloudCalculatorLink;

    public GoogleCloudCalculatorPage clickGoogleCloudCalculatorLink() {
        GoogleCloudCalculatorLink.click();
        return new GoogleCloudCalculatorPage(driver);
    }

}