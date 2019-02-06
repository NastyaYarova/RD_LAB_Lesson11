

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FacebookEnterPage {

    private WebDriver driver;


    public FacebookEnterPage(WebDriver driver) {
        this.driver = driver;
    }


    @FindBy(id = "email")
    private WebElement fieldMail;

    @FindBy(id = "pass")
    private WebElement fieldPassword;

    @FindBy(id = "u_0_2")
    private WebElement buttonLog;


    public FacebookEnterPage inputMail(String mail) {
        fieldMail.sendKeys(mail);
        return new FacebookEnterPage(driver);
    }

    public FacebookEnterPage inputPassword(String password) {
        fieldPassword.sendKeys(password);
        return new FacebookEnterPage(driver);
    }

    public FacebookLogInPage clickButtonLog() {
        buttonLog.click();
        return new FacebookLogInPage(driver);
    }

    public FacebookLogInPage signUp(String mail, String password) {
        this.inputMail(mail);
        this.inputPassword(password);
        this.clickButtonLog();
        return new FacebookLogInPage(driver);
    }

}
