import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FacebookLogInPage {

    private WebDriver driver;

    public FacebookLogInPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@class='_4rbf _53ij']")
    private WebElement elementError;

//    public String elementErrorTxt() {
//        String elementErrorTxt = driver.findElement(elementError).getText();
//        return elementErrorTxt;
//    }

    public boolean compareErrorTxt() {

        String txtEn = "The email or phone number you’ve entered doesn’t match any account.";
        String txtRu = "Вы ввели неверный пароль. Забыли пароль? ";
        String txtUa = "Ви ввели неправильний пароль. Забули пароль?";

       String elementErrorTxt = elementError.getText();

        boolean testResult;

        if (elementErrorTxt.contains(txtEn)) {
            testResult = true;
        }
        if (elementErrorTxt.contains(txtRu)) {
            testResult = true;
        }
        if (elementErrorTxt.contains(txtUa)) {
            testResult = true;
        } else {
            testResult = false;
        }
        return testResult;
    }

}
