import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleMainPage {

    private WebDriver driver;

    public GoogleMainPage(WebDriver driver) {
        this.driver = driver;
        // this.driver.get("https://www.google.com");
    }

    @FindBy(xpath = "//input[@class='gLFyf gsfi']")
    private WebElement searchField;

    @FindBy(xpath = "//div[@class='FPdoLc VlcLAe']//input[1]")
    private WebElement searchButton;

    public GoogleMainPage inputText(String searchTex) {
        searchField.sendKeys(searchTex);
        return new GoogleMainPage(driver);
    }

    public GoogleSearchPage clickButtonSearch() {
        searchButton.click();
        return new GoogleSearchPage(driver);
    }

    public GoogleSearchPage enterSearch() {
        searchField.sendKeys(Keys.RETURN);
        return new GoogleSearchPage(driver);
    }

}
