import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegisterProfileTest extends TestBase{

    @DataProvider(name="registerProfileData")
    public Object [][] postData() {
        return new Object[][]{
                {"stanivg", "stanivg@example.com", "aaaaaa", "aaaaaa"},
        };
    }

    @Test(dataProvider = "registerProfileData")
    public void testSuccessfulRegister(String username, String email, String password, String confirmPassword){

        LoginPage loginPage = new LoginPage(super.getDriver());
        loginPage.navigateTo();
        loginPage.isLoginPageUrlLoaded();

        loginPage.clickRegisterLink();

        RegisterProfilePage registerProfilePage = new RegisterProfilePage(super.getDriver());
        registerProfilePage.isRegisterProfilePageUrlLoaded();

        registerProfilePage.fillInUsername(username);
        registerProfilePage.fillInEmail(email);
        registerProfilePage.fillInPassword(password);
        registerProfilePage.fillInConfirmPassword(confirmPassword);

        registerProfilePage.clickSignInButton();

        HomePage homePage = new HomePage(super.getDriver());
        homePage.isHomePageUrlLoaded();
        homePage.clickOnProfileLink();

        ProfilePage profilePage = new ProfilePage(super.getDriver());

        profilePage.isProfilePageUrlLoaded();

        Assert.assertEquals(
                profilePage.getUserProfileName(),
                username);
    }


}
