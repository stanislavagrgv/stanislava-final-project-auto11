import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class NewPostPage {

    public static final String NEW_POST_URL = "http://training.skillo-bg.com:4200/posts/create";
    private final WebDriver driver;

    @FindBy(xpath = "//input[@class=\"ng-untouched ng-pristine ng-invalid\"]")
    WebElement uploadPictureInput;

    @FindBy(name = "caption")
    WebElement postCaptionInput;

    @FindBy (xpath = "//label[@for=\"customSwitch2\"]")
    WebElement accessStatus;

    @FindBy (className= "public-status-label")
    WebElement privateLabel;

    @FindBy (id="create-post")
    WebElement createPostButton;

    @FindBy (id="upload-img")
    WebElement profilePicture;


    public NewPostPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isNewPostUrlLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        return wait.until(ExpectedConditions.urlToBe(NewPostPage.NEW_POST_URL));
    }

    public void uploadFile(File file) {
        uploadPictureInput.sendKeys(file.getAbsolutePath());
    }

    public void fillInCaption(String postCaption) {
        postCaptionInput.sendKeys(postCaption);
    }

    public void selectPrivatePost(){
        if ((privateLabel.getAttribute("class")).equals("post-status-label public-status-label")) {
            accessStatus.click();
        }
    }

    public void setPublicPost(){
        if (!((privateLabel.getAttribute("class")).equals("post-status-label public-status-label"))) {
            accessStatus.click();
        }
    }

    public void clickCreatePostButton(){
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(createPostButton));
        createPostButton.submit();
    }

    public void uploadProfilePicture(File file){
    profilePicture.sendKeys(file.getAbsolutePath());
    }

}
