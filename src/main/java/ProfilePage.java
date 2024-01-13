import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.io.File;
import java.time.Duration;

import java.awt.event.ActionEvent;
import java.util.List;

public class ProfilePage {
    public static final String PROFILE_URL_PART = "http://training.skillo-bg.com:4200/users/";
    private final WebDriver driver;

    @FindBy(tagName = "h2")
    private WebElement userProfileName;

    @FindBy(id = "nav-link-new-post")
    WebElement newPostLink;

    @FindBy(className = "fa-user-edit")
    WebElement editProfileIcon;

    @FindBy(xpath = "//input[@formcontrolname=\"email\"]")
    WebElement emailEditInput;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    WebElement saveProfileChanges;

    @FindBy(id = "upload-img")
    WebElement profilePictureInput;

    @FindBy(className = "post-filter-buttons")
    WebElement postsFilterButtons;

    @FindBy(xpath = "//label[contains(text(), \"Public\")]/input")
    WebElement publicPostsFilter;

    @FindBy(xpath = "//label[contains(text(), \"Private\")]/input")
    WebElement privatePostsFilter;

    @FindAll({
            @FindBy(tagName = "app-post")
    })
    private List<WebElement> posts;

    @FindBy (className = "modal-open")
    WebElement editProfileModal;

    @FindBy (xpath = "//input[@formcontrolname=\"email\"]")
    WebElement emailInEditForm;

    @FindBy (xpath = "//button[@type=\"submit\"]")
    WebElement saveButton;

    @FindBy(id = "nav-link-logout")
    WebElement logoutIcon;

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

    public void clickNewPostLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(newPostLink));
        newPostLink.click();
    }

    public String getUserProfileName() {
        return userProfileName.getText();
    }

    public void uploadProfilePicture(File file) {

        profilePictureInput.sendKeys(file.getAbsolutePath());
    }

    public void clickPublicPostsFilter() {
       Actions actions = new Actions(driver);
       actions.moveToElement(publicPostsFilter).click().build().perform();
    }

    public void clickPrivatePostsFilter() {
        Actions actions = new Actions(driver);
        actions.moveToElement(privatePostsFilter).click().build().perform();
    }

    public int getPostsCount() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        return posts.size();
    }

//    public WebElement isEditModalOpened(){
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//        return wait.until(ExpectedConditions.visibilityOf(editProfileModal));
//    }

    public void changeEmail(String newEmail){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(editProfileModal));
        emailInEditForm.clear();
        emailInEditForm.sendKeys(newEmail);
    }

    public void saveEditChanges(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(saveButton));
        saveButton.click();
        wait.until(ExpectedConditions.invisibilityOf(editProfileModal));
    }

    public String checkCurrentEmail(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(emailInEditForm));
        return emailInEditForm.getText();
    }

    public void logout (){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(logoutIcon));
        logoutIcon.click();
    }


}
