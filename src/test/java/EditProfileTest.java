import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.*;

import java.io.File;
import java.time.Duration;

public class EditProfileTest extends TestBase{
    @DataProvider(name="profileData")
    public Object [][] profileData() {

        File profilePicture = new File("src\\main\\resources\\upload\\profile_image_upload.jpg");
        return new Object[][]{
                {
                    "stanig3",
                    "111111",
                    profilePicture
                },
        };
    }

    @DataProvider(name="emailData")
    public Object [][] emailData() {

        return new Object[][]{
                {
                        "stanitest",
                        "aaaaaa",
                        "initial@example.com",
                        "new3@example.com"
                },
        };
    }

    @Test(dataProvider = "profileData")
    public void editProfilePicture(String username, String password, File file){
        LoginPage loginPage = new LoginPage(super.getDriver());
        loginPage.performLoginSteps(username, password);

        HomePage homePage = new HomePage(super.getDriver());
        Assert.assertTrue("Home page is not loaded", homePage.isHomePageUrlLoaded());
        homePage.clickOnProfileLink();

        ProfilePage profilePage = new ProfilePage(super.getDriver());
        Assert.assertTrue("Profile page is not loaded", profilePage.isProfilePageUrlLoaded());

        profilePage.uploadProfilePicture(file);

        Assert.assertTrue("Profile page is not loaded", profilePage.isProfilePageUrlLoaded());

    }

    @Test (dataProvider = "emailData")
    public void testChangeProfileEmail(String username, String password, String initialEmail, String newEmail){

        LoginPage loginPage = new LoginPage(super.getDriver());
        loginPage.performLoginSteps(username, password);

        HomePage homePage = new HomePage(super.getDriver());
        Assert.assertTrue("Home page is not loaded", homePage.isHomePageUrlLoaded());
        homePage.clickOnProfileLink();

        ProfilePage profilePage = new ProfilePage(super.getDriver());
        Assert.assertTrue("Profile page is not loaded", profilePage.isProfilePageUrlLoaded());

        profilePage.clickEditProfileIcon();

        profilePage.changeEmail(newEmail);
        profilePage.saveEditChanges();

        profilePage.clickEditProfileIcon();


        //profilePage.logout();

        loginPage.performLoginSteps(newEmail, password);
        Assert.assertTrue("Email was not changed", homePage.isHomePageUrlLoaded());
        System.out.println("5");
    }


}
