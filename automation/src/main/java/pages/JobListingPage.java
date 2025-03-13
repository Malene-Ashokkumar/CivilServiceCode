package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JobListingPage {
	
	private WebDriver driver;

    private By jobCount = By.xpath("//div[@class='csr-page-title']/h1[contains(text(), 'Search results')]");

    public JobListingPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getJobCount() {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    	
    	String resultText = driver.findElement(jobCount).getText();
    	String resultCount = resultText.replaceAll("[^0-9]", "");
    	System.out.println("Number of search results: " + resultCount);
		return resultCount;
    }

}
