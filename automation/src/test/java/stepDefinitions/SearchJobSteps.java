package stepDefinitions;


import io.cucumber.java.en.*;

import java.time.Duration;

import org.testng.Assert;

import pages.HomePage;
import pages.JobListingPage;
import pages.SearchResultsPage;
import base.BaseTest;

public class SearchJobSteps extends BaseTest {
    private HomePage homePage;
    private SearchResultsPage searchResultsPage;
    private JobListingPage jobListingPage;
    
    @Given("I navigate to the Civil Service Jobs website")
    public void iNavigateToTheWebsite() {
        initializeDriver("chrome");
        driver.get("https://www.civilservicejobs.service.gov.uk/csr/index.cgi");        
        homePage = new HomePage(driver);
    }

    @When("I search for {string} jobs in {string}")
    public void iSearchForJobs(String title, String location) {
        homePage.searchJob(title, location);
    }

   @Then("I should see relevant job listings")
    public void iShouldSeeRelevantJobs() {	   
        searchResultsPage = new SearchResultsPage(driver);
        Assert.assertTrue(searchResultsPage.validateSearchResults(), "No job listings found!");
       quitDriver();
    }
   
   @When("I select the department {string} from the filter options")
   public void i_select_the_department_from_the_filter_options(String departmentName) {
   	    homePage.selectDepartment(departmentName);
   }

   @When("I select the first available job listing")
   public void i_select_the_first_available_job_listing() {
     	String FirstJob = homePage.selectFirstJobListing();
   	    System.out.println("First Job in the List "+ "=" + FirstJob);
   	
   }

   @Then("I should see the number of jobs available on the job listing details page")
   public void i_should_see_the_number_of_jobs_available_on_the_job_listing_details_page() {
        jobListingPage = new JobListingPage(driver);
        String jobCount = jobListingPage.getJobCount();
        Assert.assertTrue(Integer.parseInt(jobCount) > 0, "The job count should be a valid number");
       quitDriver();
   }
   
   @When("I select on {string}")
	   public void i_select_on(String name) {		    	
		   		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		   		  homePage.clickCareerAvailable();		   			  
   }
   
   @When("I locate on {string}")
   public void i_locate_on(String workingName) throws InterruptedException {		    	
	   		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	   		  homePage.clickOnWorkingForCivilService();		   			  
  }
   
   @And("I click on {string}")
   public void i_click_on(String linkName) {
	   
    	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
           homePage.clickOnCivilServiceCode();
   }
   

   @Then("I should be redirected to the {string} section of the Civil Service Commission website")
   public void i_should_be_redirected_to_the_section_of_the_civil_service_commission_website(String sectionName) {

       String currentUrl = driver.getCurrentUrl();
       Assert.assertTrue(currentUrl.contains("civilservicecommission"), "URL doesn't contain Civil Service Commission domain");

       Assert.assertTrue(driver.getPageSource().contains(sectionName), "The " + sectionName + " section is not present.");
       quitDriver();
   }

}
