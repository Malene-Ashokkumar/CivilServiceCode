package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePage {
	
    private WebDriver driver;
    private By jobTitleField = By.id("what");
    private By locationField = By.id("whereselector");
    private By searchButton  = By.xpath("//input[@id = 'submitSearch']");
    private By departmentFilter = By.xpath("//button[contains(text(), 'Department')]");
    private By departmentTextBox = By.xpath("//label[contains(text(), 'Filters Department')]/following::input[@name='oselect-filter-textbox'][1]");
    private By departmentOption = By.xpath("//label[text()='Medicines and Healthcare Products Regulatory Agency']");
    private By updateResult = By.xpath("//input[@id ='submitSearchUpdate' ]");
    private By firstJobListing = By.xpath("(//h3[@class='search-results-job-box-title']/a)[1]");
   // private By lifeInCivilServiceLink = By.xpath("//a[contains(@class, 'megamenu-item__link') and contains(., 'Life in the Civil Service')]");
   // private By workingForCivilServiceLink = By.xpath("(//li[@class='megamenu-links-group__submenu-item']//span[text()='Working for the Civil Service'])[1]");
    private By civilServiceCodeLink = By.xpath("//a[text() = 'Civil Service Code']");
    private By careerAvailableLink = By.xpath("//a[text() = 'careers available in the Civil Service (opens in a new window)']");
   
    
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchJob(String title, String location) {
    	
    	//Ignore Captcha Manually
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    	
    	driver.findElement(jobTitleField).click();
        driver.findElement(jobTitleField).sendKeys(title);
        driver.findElement(locationField).click();
        driver.findElement(locationField).sendKeys(location);    	
    	driver.findElement(searchButton).sendKeys(Keys.ENTER);
    	
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        
    }

    public void selectDepartment(String departmentName) {
    	
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    	
    	 WebElement elementToScrollTo = driver.findElement(departmentFilter);
    	
    	JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", elementToScrollTo);
        elementToScrollTo.click();
        
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    	driver.findElement(departmentTextBox).sendKeys(departmentName);
    	driver.findElement(departmentOption).click();
    	driver.findElement(updateResult).click();
    }

    public String selectFirstJobListing() {
    	
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        return driver.findElement(firstJobListing).getText();
    }
    
    public void clickCareerAvailable() {

        driver.findElement(careerAvailableLink).click();
  	    System.out.println("CareerAvailable");

    }

    public void clickOnWorkingForCivilService() throws InterruptedException {
        
        driver.get("https://www.civil-service-careers.gov.uk/workingforthecivilservice/");
        
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    public void clickOnCivilServiceCode() {
    	
        driver.findElement(civilServiceCodeLink).click();
        System.out.println("CivilServiceCode");
        
    }
}
