package PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleCloud {
    WebDriver driver;
    WebDriverWait wait;
    public GoogleCloud (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"kO001e\"]/div[2]/div[1]/div/div[2]/div[2]/div[1]/div/div")
    public WebElement SearchBtn;

    public void SearchBtn() {
        SearchBtn.click();
    }
    @FindBy(xpath = "//*[@id=\"i4\"]")
    public WebElement SearchField;

    public SearchResultsPage Search(String NewSearchString){
        SearchField.sendKeys(NewSearchString);
        SearchField.submit();
        return new SearchResultsPage(driver);
    }

}


