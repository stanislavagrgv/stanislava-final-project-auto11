import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterProfilePage {
    public static final String REGISTER_PROFILE_PAGE_URL = "http://training.skillo-bg.com:4200/users/register";
    private final WebDriver driver;

    @FindBy(xpath = "//input[@formcontrolname=\"username\"]")
    private WebElement usernameInput;

    @FindBy(xpath = "//input[@formcontrolname=\"email\"]")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@formcontrolname=\"password\"]")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@formcontrolname=\"confirmPassword\"]")
    private WebElement confirmPasswordInput;

    @FindBy(id = "sign-in-button")
    private WebElement signInButton;

    public RegisterProfilePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isRegisterProfilePageUrlLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        return wait.until(ExpectedConditions.urlToBe(RegisterProfilePage.REGISTER_PROFILE_PAGE_URL));
    }

    public void fillInUsername(String username) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(usernameInput));
        usernameInput.sendKeys(username);
    }
    public void fillInEmail(String email) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(emailInput));
        emailInput.sendKeys(email);
    }
    public void fillInPassword(String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(passwordInput));
        passwordInput.sendKeys(password);
    }

    public void fillInConfirmPassword(String confirmPassword) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(passwordInput));
        confirmPasswordInput.sendKeys(confirmPassword);
    }

    public void clickSignInButton() {
        signInButton.click();
    }
}
