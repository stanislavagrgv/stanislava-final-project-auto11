import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    public static final String HOME_PAGE_URL = "http://training.skillo-bg.com:4200/posts/all";
    private final WebDriver driver;


    @FindBy(id="nav-link-profile")
    WebElement profileLink;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isHomePageUrlLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        return wait.until(ExpectedConditions.urlToBe(HomePage.HOME_PAGE_URL));
    }

    public void clickOnProfileLink(){
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(profileLink));
        profileLink.click();
    }
}
