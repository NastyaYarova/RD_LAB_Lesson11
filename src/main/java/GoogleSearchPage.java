import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleSearchPage {

    private WebDriver driver;

    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//a[@href='https://uk-ua.facebook.com/']//cite[@class='iUh30']")
    private WebElement findfacebook;


    public FacebookEnterPage clickLink(){
        findfacebook.click();
        return new FacebookEnterPage(driver);
    }

}
