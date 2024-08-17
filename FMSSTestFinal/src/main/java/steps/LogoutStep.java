package steps;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.LoginPage;
import pages.LogoutPage;
import java.net.MalformedURLException;
import java.net.URL;

public class LogoutStep {
    static AppiumDriver driver;
    LogoutPage logoutPage;
    LoginPage loginPage;

    @Given("User is logged in to the application")
    public void userIsLoggedInToTheApplication() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:deviceName", "Pixel_6");
        capabilities.setCapability("appium:automationName", "UiAutomator2");
        capabilities.setCapability("appium:app", "/path/to/your/app.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        logoutPage = new LogoutPage(driver);
        loginPage = new LoginPage(driver);


        loginPage.fillUserName("your_username");
        loginPage.fillPassword("your_password");
        loginPage.clickLoginButton();
    }

    @When("User clicks on the {string} button")
    public void userClicksOnButton(String buttonText) {
        if (buttonText.equals("Logout")) {
            logoutPage.clickLogoutButton();
        }
    }

    @Then("User should see a {string} message")
    public void userShouldSeeMessage(String expectedMessage) {
        String actualMessage = logoutPage.getSuccessMessage();
        assert actualMessage.equals(expectedMessage) : "Expected message: " + expectedMessage + ", but got: " + actualMessage;
    }

    @Then("User should be redirected to the {string} screen")
    public void userShouldBeRedirectedToScreen(String screenName) {
        String currentScreen = logoutPage.getCurrentScreen();
        assert currentScreen.equals(screenName) : "User is not redirected to the " + screenName + " screen";
    }

    @When("User selects {string} on the confirmation dialog")
    public void userSelectsOnConfirmationDialog(String option) {
        if (option.equals("Cancel")) {
            logoutPage.clickCancelLogoutButton();
        }
    }

    @Then("User should remain on the current page")
    public void userShouldRemainOnCurrentPage() {
        String currentPage = logoutPage.getCurrentScreen();
        assert currentPage.equals("Current Page") : "User was redirected when they should not have been";
    }

    @When("User waits for the session to timeout")
    public void userWaitsForSessionToTimeout() {

        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @When("User tries to access a {string} page")
    public void userTriesToAccessProtectedPage(String pageName) {

        switch (pageName) {
            case "protected":
                driver.get("http://yourapp.com/protected");
                break;
            default:
                throw new IllegalArgumentException("Invalid page name: " + pageName);
        }
    }

    @Then("User should see a {string} error message")
    public void userShouldSeeErrorMessage(String expectedErrorMessage) {
        String actualErrorMessage = logoutPage.getErrorMessage();
        assert actualErrorMessage.equals(expectedErrorMessage) : "Expected error message: " + expectedErrorMessage + ", but got: " + actualErrorMessage;
    }

}
