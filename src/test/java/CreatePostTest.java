import org.junit.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.*;

import java.io.File;

public class CreatePostTest extends TestBase{

    @DataProvider(name="postData")
    public Object [][] postData() {

        File postPicture = new File("src\\main\\resources\\upload\\image_upload1.jpg");
        return new Object[][]{
                {"stanii",
                 "aaaaaa",
                 postPicture,
                 "My new post"},
        };
    }

    @Test(dataProvider = "postData")
    public void testCreatePublicPost(String username, String password, File file, String postCaption){

        LoginPage loginPage = new LoginPage(super.getDriver());
        loginPage.performLoginSteps(username, password);

        HomePage homePage = new HomePage(super.getDriver());
        Assert.assertTrue("Home page is not loaded", homePage.isHomePageUrlLoaded());
        homePage.clickOnProfileLink();

        ProfilePage profilePage = new ProfilePage(super.getDriver());
        Assert.assertTrue("Profile page is not loaded", profilePage.isProfilePageUrlLoaded());

        profilePage.clickPublicPostsFilter();
        int initialPublicPostsCount = profilePage.getPostsCount();

        profilePage.clickNewPostLink();

        NewPostPage newPostPage = new NewPostPage(super.getDriver());
        Assert.assertTrue("New post page is not loaded", newPostPage.isNewPostUrlLoaded());

        newPostPage.uploadFile(file);
        newPostPage.fillInCaption(postCaption);
        //newPostPage.setPublicPost();
        newPostPage.clickCreatePostButton();

        Assert.assertTrue("You are not returned to Profile page", profilePage.isProfilePageUrlLoaded());

        profilePage.clickPublicPostsFilter();
        int updatedPublicPostsCount = profilePage.getPostsCount();

        Assert.assertTrue("Public post was not created", (updatedPublicPostsCount == initialPublicPostsCount+1));
    }

    @Test(dataProvider = "postData")
    public void testCreatePrivatePost(String username, String password, File file, String postCaption){

        LoginPage loginPage = new LoginPage(super.getDriver());
        loginPage.performLoginSteps(username, password);

        HomePage homePage = new HomePage(super.getDriver());
        Assert.assertTrue("Home page is not loaded", homePage.isHomePageUrlLoaded());
        homePage.clickOnProfileLink();

        ProfilePage profilePage = new ProfilePage(super.getDriver());
        Assert.assertTrue("Profile page is not loaded", profilePage.isProfilePageUrlLoaded());

        profilePage.clickPrivatePostsFilter();
        int initialPrivatePostsCount = profilePage.getPostsCount();

        profilePage.clickNewPostLink();

        NewPostPage newPostPage = new NewPostPage(super.getDriver());
        Assert.assertTrue("New post page is not loaded", newPostPage.isNewPostUrlLoaded());

        newPostPage.uploadFile(file);
        newPostPage.fillInCaption(postCaption);
        newPostPage.selectPrivatePost();
        newPostPage.clickCreatePostButton();

        Assert.assertTrue("You are not returned to Profile page", profilePage.isProfilePageUrlLoaded());

        profilePage.clickPrivatePostsFilter();
        int updatedPrivatePostsCount= profilePage.getPostsCount();

        Assert.assertTrue("Private post was not created", (updatedPrivatePostsCount == initialPrivatePostsCount+1));
    }

}
