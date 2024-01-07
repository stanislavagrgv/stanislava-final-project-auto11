import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {
    public static final String PROFILE_URL_PART = "http://training.skillo-bg.com:4200/users/";
    private final WebDriver driver;

    @FindBy(tagName = "h2")
    private WebElement userProfileName;

    @FindBy(id="nav-link-new-post")
    WebElement newPostLink;

    @FindBy(className = "fa-user-edit")
    WebElement editProfileIcon;

    @FindBy(xpath = "//input[@formcontrolname=\"email\"]")
    WebElement emailEditInput;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    WebElement saveProfileChanges;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isProfilePageUrlLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.urlContains(ProfilePage.PROFILE_URL_PART));
    }

    public void clickEditProfileIcon() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(editProfileIcon));
        editProfileIcon.click();
    }

    public void fillNewEmail(String email) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(emailEditInput));
        emailEditInput.sendKeys(email);
    }

    public void saveProfileChange() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(saveProfileChanges));
        saveProfileChanges.click();
    }

    public void clickNewPostLink (){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(newPostLink));
        newPostLink.click();
    }

    public String getUserProfileName(String username) {
        return userProfileName.getText();
    }
}
