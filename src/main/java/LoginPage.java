import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    public static final String LOGIN_URL = "http://training.skillo-bg.com:4200/users/login";
    private final WebDriver driver;
    @FindBy(id="defaultLoginFormUsername")
    private WebElement usernameInput;

    @FindBy (id="defaultLoginFormPassword")
    private WebElement passwordInput;

    @FindBy (id="sign-in-button")
    private WebElement signInButton;

    @FindBy(xpath = "//a[@href=\"/users/register\"]")
    private WebElement registerLink;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateTo() {
        this.driver.get(LOGIN_URL);
    }

    public boolean isLoginPageUrlLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        return wait.until(ExpectedConditions.urlToBe(LoginPage.LOGIN_URL));
    }

    public void fillInUsername(String loginUsername) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(usernameInput));
        usernameInput.sendKeys(loginUsername);
    }

    public void fillInPassword(String loginPassword) {
        passwordInput.sendKeys(loginPassword);
    }

    public void clickSignInButton() {
        signInButton.click();
    }

    public void clickRegisterLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(registerLink));
        registerLink.click();
    }

}
