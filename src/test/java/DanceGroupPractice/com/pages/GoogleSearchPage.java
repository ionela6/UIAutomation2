package DanceGroupPractice.com.pages;

import DanceGroupPractice.com.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage {

    public GoogleSearchPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//textarea[@id='APjFqb']")
    public WebElement searchBox;

    @FindBy(xpath = "(//input[@name='btnK'])[2]")
    public WebElement searchBtn;


}
