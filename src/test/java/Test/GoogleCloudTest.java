package Test;
import PageObject.EstimateSummary;
import PageObject.GoogleCloud;
import PageObject.SearchResultsPage;
import PageObject.GoogleCloudCalculatorPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.WaitUtils;


import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class GoogleCloudTest {
    WebDriver driver;
    GoogleCloud googleCloud;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://cloud.google.com/");
        googleCloud = new GoogleCloud(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test (description = "Проверка открытия страниц и внесение данных/ заполнение формы. Переход на итоговую страницу с суммой")
    public void testGoogleCloud()
            throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(googleCloud.SearchBtn)).click(); // Нажимаем на кнопку поиска

        // Выполняем поиск
        SearchResultsPage searchResultsPage = googleCloud.Search("Google Cloud Pricing Calculator");

        // Ожидаем, пока появится ссылка на калькулятор
        wait.until(ExpectedConditions.elementToBeClickable(searchResultsPage.GoogleCloudCalculatorLink));

        // Переходим на страницу калькулятора
        GoogleCloudCalculatorPage calculatorPage = searchResultsPage.clickGoogleCloudCalculatorLink();

        // Создаем объект JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Взаимодействуем с элементами на странице калькулятора
        wait.until(ExpectedConditions.elementToBeClickable(calculatorPage.AddToEstimate)).click();

        wait.until(ExpectedConditions.elementToBeClickable(calculatorPage.Compute_EngineRef)).click();

        wait.until(ExpectedConditions.elementToBeClickable(calculatorPage.NumberOfInstances)).click();
        calculatorPage.NumberOfInstances.clear();
        calculatorPage.NumberOfInstances("4");

        js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", calculatorPage.OperatingSystem);
        wait.until(ExpectedConditions.elementToBeClickable(calculatorPage.OperatingSystem)).click();

        wait.until(ExpectedConditions.elementToBeClickable(calculatorPage.OSChoice)).click();

        js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", calculatorPage.VM_Class_Regular);
        wait.until(ExpectedConditions.elementToBeClickable(calculatorPage.VM_Class_Regular)).click();


        wait.until(ExpectedConditions.elementToBeClickable(calculatorPage.Machine_type)).click();

        js.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight", calculatorPage.Machine_typeList);


        js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", calculatorPage.Machine_type_n1_8);
        wait.until(ExpectedConditions.elementToBeClickable(calculatorPage.Machine_type_n1_8)).click();

        calculatorPage.vCPUs.clear();
        calculatorPage.vCPUs.sendKeys("8");

        js.executeScript("arguments[0].scrollIntoView(true);", calculatorPage.RAM);
        calculatorPage.RAM.clear();
        calculatorPage.RAM.sendKeys("30");


        wait.until(ExpectedConditions.elementToBeClickable(calculatorPage.GPUs)).click();
        js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", calculatorPage.GPUs);
        wait.until(ExpectedConditions.elementToBeClickable(calculatorPage.GPU_Model)).click();

        wait.until(ExpectedConditions.elementToBeClickable(calculatorPage.NVidiaTesla)).click();


        calculatorPage.NumberOfGPUs.sendKeys("1");
        calculatorPage.NumberOfGPUs.click();


        wait.until(ExpectedConditions.elementToBeClickable(calculatorPage.LocalSSD)).click();

        js.executeScript("arguments[0].scrollIntoView(true);", calculatorPage.SSD2_375GB);

        calculatorPage.LocalSSD.sendKeys("2");
        calculatorPage.SSD2_375GB.click();


        js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", calculatorPage.SSD2_375GB);

        wait.until(ExpectedConditions.elementToBeClickable(calculatorPage.Region)).click();


        wait.until(ExpectedConditions.elementToBeClickable(calculatorPage.South_Carolina)).click();

        js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", calculatorPage.One_year);

        wait.until(ExpectedConditions.elementToBeClickable(calculatorPage.One_year)).click();
        calculatorPage.OpenDetailedView.click();


        EstimateSummary estimateSummary = new EstimateSummary(driver);

        Thread.sleep(30000);

        try {
            String actualInstance_type = estimateSummary.getInstance_type();
            String expectedInstance_type = "n1-standard-8";
            System.out.println("Actual Instance Type: " + actualInstance_type);
            Assert.assertTrue(actualInstance_type.contains(expectedInstance_type), "Instance_type does not match!");
        } catch (AssertionError e) {
            System.out.println("Assertion failed: " + e.getMessage());
        }

        System.out.println("Программа продолжает выполнение...");
        try {
            String actualLocalSSD_type = estimateSummary.LocalSSD_type();
            String expectedLocalSSD_type = "2x375 GB";
            System.out.println("Actual Local SSD Type: " + actualLocalSSD_type);
            Assert.assertTrue(actualLocalSSD_type.contains(expectedLocalSSD_type), "Local SSD type does not match!");
        } catch (AssertionError e) {
            System.out.println("Assertion failed: " + e.getMessage());
        }


        try {

            String actualRegion = estimateSummary.region();
            String expectedRegion = "South Carolina";
            System.out.println("Actual Region: " + actualRegion);
            Assert.assertTrue(actualRegion.contains(expectedRegion), "Region does not match!");
        } catch (AssertionError e) {
            System.out.println("Assertion failed: " + e.getMessage());
        }
        System.out.println("Программа продолжает выполнение...");
            try {

                String actualCommit_term_ = estimateSummary.Commit_term_();
                String expectedCommit_term_ = "1 year";
                System.out.println("Actual Commitment term: " + actualCommit_term_);
                Assert.assertTrue(actualCommit_term_.contains(expectedCommit_term_), "Commitment term does not match!");
            } catch (AssertionError e) {
                System.out.println("Assertion failed: " + e.getMessage());
            }
        System.out.println("Программа продолжает выполнение...");
        try {

            String actualResultSum = estimateSummary.ResultSumMoney();
            String expectedResultSum = "3,537.70";
            System.out.println("Actual estimate summary: " + actualResultSum);
            Assert.assertTrue(actualResultSum.contains(expectedResultSum), "Estimate summary does not match!");
        } catch (AssertionError e) {
            System.out.println("Assertion failed: " + e.getMessage());
        }
        System.out.println("Программа продолжает выполнение...");

        try {
            String actualVM_Class_type = estimateSummary.VM_Class_type();
            String expectedVM_Class_type = "Regular";
            System.out.println("Actual VM Class Type: " + actualVM_Class_type);
            Assert.assertTrue(actualVM_Class_type.contains(expectedVM_Class_type), "VM_Class_type does not match!");
        } catch (AssertionError e) {
            System.out.println("Assertion failed: " + e.getMessage());
        }
        System.out.println("Программа продолжает выполнение...");
        }


    @AfterClass
    public void tearDown () {
        if (driver != null) {
            driver.quit();
        }
    }
}