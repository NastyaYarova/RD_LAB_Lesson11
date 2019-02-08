import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;

public class TestFacebookLoginPage {
    static WebDriver driver;
    static GoogleMainPage googleMainPage;
    static GoogleSearchPage googleSearchPage;
    static FacebookEnterPage facebookEnterPage;
    static FacebookLogInPage facebookLogInPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        GoogleMainPage googleMainPage = PageFactory.initElements(driver, GoogleMainPage.class);
        googleMainPage.inputText("facebook");
        googleMainPage.enterSearch();
        GoogleSearchPage googleSearchPage = PageFactory.initElements(driver, GoogleSearchPage.class);
        googleSearchPage.clickLink();
    }

    @Test
    public void checkWrongPassword() {
        FacebookEnterPage facebookEnterPage = PageFactory.initElements(driver, FacebookEnterPage.class);
        facebookEnterPage.signUp("+0980261901", "12345678");
        facebookEnterPage.clickButtonLog();
        FacebookLogInPage facebookLogInPage = PageFactory.initElements(driver, FacebookLogInPage.class);
        facebookLogInPage.compareErrorTxt();
        Assert.assertTrue( facebookLogInPage.compareErrorTxt());
        //Assert.assertEquals("Test passed =)", true, facebookLogInPage.compareErrorTxt());
    }

    @Test
    public void checkWrongMail() {
        FacebookEnterPage facebookEnterPage = PageFactory.initElements(driver, FacebookEnterPage.class);
        facebookEnterPage.signUp("+0980261901", "12345678");
        facebookEnterPage.clickButtonLog();
        FacebookLogInPage facebookLogInPage = PageFactory.initElements(driver, FacebookLogInPage.class);
        facebookLogInPage.compareErrorTxt();
        //Assert.assertFalse("Test failed =(", facebookLogInPage.compareErrorTxt());
        Assert.assertTrue( facebookLogInPage.compareErrorTxt());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
