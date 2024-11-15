package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleCloudCalculatorPage {
    WebDriver driver;

    public GoogleCloudCalculatorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Add to estimate']")
    public WebElement AddToEstimate;

    public void AddToEstimate() {
        AddToEstimate.click();
    }

    @FindBy(xpath = "//*[@id=\"yDmH0d\"]/div[5]/div[2]/div/div/div/div[2]/div/div/div[1]/div/div/div")
    public WebElement Compute_EngineRef;

    public void Compute_EngineRef() {
        Compute_EngineRef.click();
    }

    @FindBy(xpath = "//input[@type='number' and @value='1']")
    public WebElement NumberOfInstances;

    public void NumberOfInstances(String NumberOfInstancesString) {
        NumberOfInstances.click();
        NumberOfInstances.clear();
        NumberOfInstances.sendKeys(NumberOfInstancesString);
        }

    @FindBy(xpath = "/html/body/c-wiz[1]/div/div/div/div[1]/div/div[2]/div/div/div/div/div/div[1]/div/div[2]/div[3]/div[7]/div/div[1]/div/div")
    public WebElement OperatingSystem;

    public void OperatingSystem() {
        OperatingSystem.click();
    }

    @FindBy(xpath = "//li[contains(@class, 'MCs1Pd') and contains(@class, 'HiC7Nc') and @data-value='free-debian-centos-coreos-ubuntu-or-byol-bring-your-own-license']")
    public WebElement OSChoice;

    public void OSChoice() {
        OSChoice.click();
    }

    @FindBy(xpath = "/html/body/c-wiz[1]/div/div/div/div[1]/div/div/div/div/div/div/div/div[1]/div/div[2]/div[3]/div[9]/div/div/div[2]/div/div/div")
    public WebElement VM_Class_Regular;

    public void VM_Class_Regular() {
        VM_Class_Regular.click();
    }
    @FindBy(xpath = "/html/body/c-wiz[1]/div/div/div/div[1]/div/div[2]/div/div/div/div/div/div[1]/div/div[2]/div[3]/div[11]/div/div/div[2]/div/div[1]/div[3]/div/div/div/div[1]/div")
    public WebElement Machine_type;

    public void Machine_type() {
        Machine_type.click();
    }
    @FindBy(xpath = "/html/body/c-wiz[1]/div/div/div/div[1]/div/div[2]/div/div/div/div/div/div[1]/div/div[2]/div[3]/div[11]/div/div/div[2]/div/div[1]/div[3]/div/div/div/div[2]/ul")
    public WebElement Machine_typeList;

    @FindBy(xpath = "//li[@data-value='n1-standard-8']")
    public WebElement Machine_type_n1_8;

    public void Machine_type_n1_8() {
        Machine_type_n1_8.click();
    }

    @FindBy(xpath = "/html/body/c-wiz[1]/div/div/div/div[1]/div/div[2]/div/div/div/div/div/div[1]/div/div[2]/div[3]/div[11]/div/div/div[2]/div/div[1]/div[4]/div[2]/div[2]/div/div/div/div/span[2]/input")
    public WebElement vCPUs;

    public void vCPUs(String vCPUsString) {
        vCPUs.click();
        vCPUs.clear();
        vCPUs.sendKeys(vCPUsString);
    }

    @FindBy(xpath = "/html/body/c-wiz[1]/div/div/div/div[1]/div/div[2]/div/div/div/div/div/div[1]/div/div[2]/div[3]/div[11]/div/div/div[2]/div/div[1]/div[5]/div[2]/div[2]/div/div/div/div/span[2]/input")
    public WebElement RAM;

    public void RAM(String RAMString) {
        vCPUs.clear();
        vCPUs.sendKeys(RAMString);
    }

    @FindBy(xpath = "//button[@jsname='DMn7nd' and @aria-label='Add GPUs']")
    public WebElement GPUs;

    public void GPUs() {
        GPUs.click();
    }

    @FindBy(xpath = "/html/body/c-wiz[1]/div/div/div/div[1]/div/div[2]/div/div/div/div/div/div[1]/div/div[2]/div[3]/div[23]/div/div[1]/div/div/div/div[1]")
    public WebElement GPU_Model;

    public void GPU_Model() {
        GPU_Model.click();
    }

    @FindBy(xpath = "//li[@data-value='nvidia-tesla-p100']")
    public WebElement NVidiaTesla;

    public void NVidiaTesla() {
        NVidiaTesla.click();
    }

    @FindBy(xpath = "/html/body/c-wiz[1]/div/div/div/div[1]/div/div[2]/div/div/div/div/div/div[1]/div/div[2]/div[3]/div[24]/div/div[1]/div/div/div/div[1]")
    public WebElement NumberOfGPUs;

    public void NumberOfGPUs(String Number) {
        NumberOfGPUs.sendKeys(Number);
        NumberOfGPUs.click();
    }

    @FindBy(xpath = "/html/body/c-wiz[1]/div/div/div/div[1]/div/div[2]/div/div/div/div/div/div[1]/div/div[2]/div[3]/div[27]/div/div[1]/div/div/div/div[1]")
    public WebElement LocalSSD;

    public void LocalSSD(String Num) {
        LocalSSD.click();
        LocalSSD.sendKeys(Num);
    }

    @FindBy(xpath = "/html/body/c-wiz[1]/div/div/div/div[1]/div/div/div/div/div/div/div/div[1]/div/div[2]/div[3]/div[27]/div/div[1]/div/div/div/div[2]/ul/li[3]")
    public WebElement SSD2_375GB;


    public void SSD2_375GB() {
        SSD2_375GB.click();
    }

    @FindBy(xpath = "/html/body/c-wiz[1]/div/div/div/div[1]/div/div[2]/div/div/div/div/div/div[1]/div/div[2]/div[3]/div[29]/div/div[1]/div/div/div/div[1]")
    public WebElement Region;

    public void Region() {
        Region.click();
    }

    @FindBy(xpath = "//li[.//span[contains(text(), 'South Carolina (us-east1)')]]")
    public WebElement South_Carolina;// т.к. во Франфрурте они недоступны

    public void South_Carolina() {
        South_Carolina.click();
    }


    @FindBy(xpath = "/html/body/c-wiz[1]/div/div/div/div[1]/div/div[2]/div/div/div/div/div/div[1]/div/div[2]/div[3]/div[31]/div/div/div[2]/div/div/div[2]")
    public WebElement One_year;
    public void One_year() {
        One_year.click();
    }

    @FindBy(xpath = "//a[@class='pYTkkf-Bz112c-mRLv6 pYTkkf-Bz112c-RLmnJb' and @aria-label='Open detailed view']")
    public WebElement OpenDetailedView;

    public GoogleCloudCalculatorPage Summary(){
        OpenDetailedView.click();
        return new EstimateSummary(driver).clickGoogleCloudCalculatorLink();
    }

    @FindBy(xpath = "//*[@id=\"yDmH0d\"]/c-wiz[1]/div/div/div/div/div/div[2]/div[2]/div[1]/div/div[1]/span[2]")
    WebElement Compute;
}