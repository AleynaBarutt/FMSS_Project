package steps;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.LoginPage;

import java.net.MalformedURLException;
import java.net.URL;

public class LoginStep {
    static AppiumDriver driver;
    LoginPage loginPage;

    @Given("the application is opened")
    public void theApplicationIsOpened() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:deviceName", "Pixel_6");
        capabilities.setCapability("appium:automationName", "UiAutomator2");
        capabilities.setCapability("appium:app", "/path/to/your/app.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        loginPage = new LoginPage(driver);
    }

    @And("User fills username as {string}")
    public void userFillsUsernameAs(String username) {
        loginPage.fillUserName(username);
    }

    @And("User fills password as {string}")
    public void userFillsPasswordAs(String password) {
        loginPage.fillPassword(password);
    }


    @And("User enters email as {string}")
    public void userEntersEmailAs(String email) {
        driver.findElement(By.id("io.selendroid.testapp:id/email_field")).sendKeys(email); // E-posta alanının ID'sini güncelleyin
    }

    @And("User clicks on the {string} button")
    public void userClicksOnButton(String buttonText) {
        if (buttonText.equals("Send Password Reset Request")) {
            driver.findElement(By.id("io.selendroid.testapp:id/send_reset_button")).click(); // Butonun ID'sini güncelleyin
        }
    }

    @When("User clicks on the {string} link")
    public void userClicksOnLink(String linkText) {
        if (linkText.equals("Forgot Password")) {
            loginPage.clickForgotPassword();
        }
    }

    @Then("User should see {string} error")
    public void userShouldSeeError(String errorMessage) {
        String actualErrorMessage = driver.findElement(By.id("error_message_id")).getText();
        assert actualErrorMessage.equals(errorMessage) : "Expected error message: " + errorMessage + ", but got: " + actualErrorMessage;
    }

    @Then("User should be redirected to the {string} page")
    public void userShouldBeRedirectedToPage(String pageName) {

        String currentUrl = driver.getCurrentUrl();
        String expectedUrl;

        switch (pageName.toLowerCase()) {
            case "home":
                expectedUrl = "https://carapp.com/home";
                break;
            case "login":
                expectedUrl = "https://carapp.com/login";
                break;
            case "dashboard":
                expectedUrl = "https://carapp.com/dashboard";
                break;
            case "profile":
                expectedUrl = "https://carapp.com/profile";
                break;

            default:
                throw new IllegalArgumentException("Unknown page: " + pageName);
        }

        assert currentUrl.equals(expectedUrl) : "Expected URL: " + expectedUrl + ", but got: " + currentUrl;

    }


    @Then("User should see {string} message")
    public void userShouldSeeMessage(String expectedMessage) {
        String actualMessage = driver.findElement(By.id("io.selendroid.testapp:id/success_message")).getText();
        assert actualMessage.equals(expectedMessage) : "Expected message: " + expectedMessage + ", but got: " + actualMessage;
    }
}
