import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class Main {

    static WebDriver driver;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.google.com");


        GoogleMainPage googleMainPage = PageFactory.initElements(driver,GoogleMainPage.class);
        googleMainPage.inputText("facebook");
        googleMainPage.enterSearch();

        GoogleSearchPage googleSearchPage = PageFactory.initElements(driver,GoogleSearchPage.class);
        googleSearchPage.clickLink();

        FacebookEnterPage facebookEnterPage = PageFactory.initElements(driver,FacebookEnterPage.class);
        facebookEnterPage.signUp("+0980261901", "12345678");
        facebookEnterPage.clickButtonLog();

        FacebookLogInPage facebookLogInPage = PageFactory.initElements(driver, FacebookLogInPage.class);
        facebookLogInPage.compareErrorTxt();
        if (facebookLogInPage.compareErrorTxt()) {
            System.out.println("Test passed =)");
        } else {
            System.out.println("Test failed =(");
        }

        driver.quit();
    }
}
