package DanceGroupPractice.com.step_definitions;

import DanceGroupPractice.com.pages.GoogleSearchPage;
import DanceGroupPractice.com.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;


public class GoogleSearchStep_Def {

    GoogleSearchPage googleSearchPage = new GoogleSearchPage();

    @When("user is on the Google search")
    public void user_is_on_the_google_search() {
        Driver.getDriver().get("https://www.google.com");
    }

    @Then("user should see title is Google")
    public void user_should_see_title_is_google() {
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Google";

        Assert.assertEquals(expectedTitle, actualTitle);

        Driver.closeDriver();
    }

    @Then("user enters {string} in the search box and clicks enter")
    public void user_enters_in_the_search_box_and_clicks_enter(String searchTerm) {
        googleSearchPage.searchBox.sendKeys(searchTerm + Keys.ENTER);

    }



    @Then("actual title should contain the searched term {string}")
    public void actual_title_should_contain_the_searched_term(String searchTerm) {
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(searchTerm));

        Driver.closeDriver();

    }


}
