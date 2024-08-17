package steps;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.options.BaseOptions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import pages.SignupPage;
import java.net.MalformedURLException;
import java.net.URL;

public class SignupStep {
    static AppiumDriver driver;
    SignupPage signupPage;

    private URL getUrl() {
        try {
            return new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Given("User opens the application")
    public void userOpensTheApplication() {
        var options = new BaseOptions()
                .amend("platformName", "Android")
                .amend("appium:deviceName", "Pixel 6")
                .amend("appium:automationName", "UiAutomator2")
                .amend("appium:app", "/path/to/your/app.apk");

        driver = new AndroidDriver(this.getUrl(), options);
        signupPage = new SignupPage();
    }

    @When("User enters a valid first name")
    public void userEntersValidFirstName() {
        signupPage.fillFirstName("Aleyna", driver);
    }

    @When("User enters a valid last name")
    public void userEntersValidLastName() {
        signupPage.fillLastName("Barut", driver);
    }

    @When("User enters a valid email address")
    public void userEntersValidEmailAddress() {
        signupPage.fillEmail("aleyna@example.com", driver);
    }

    @When("User enters a strong password")
    public void userEntersStrongPassword() {
        signupPage.fillPassword("StrongPassword123", driver);
    }

    @When("User leaves the first name field empty")
    public void userLeavesFirstNameFieldEmpty() {
        signupPage.clearFields(driver);
        signupPage.fillLastName("Barut", driver);
        signupPage.fillEmail("aleyna@example.com", driver);
        signupPage.fillPassword("StrongPassword123", driver);
    }

    @When("User leaves the last name field empty")
    public void userLeavesLastNameFieldEmpty() {
        signupPage.clearFields(driver);
        signupPage.fillFirstName("Aleyna", driver);
        signupPage.fillEmail("aleyna@example.com", driver);
        signupPage.fillPassword("StrongPassword123", driver);
    }

    @When("User enters an invalid email address")
    public void userEntersInvalidEmailAddress() {
        signupPage.clearFields(driver);
        signupPage.fillFirstName("Aleyna", driver);
        signupPage.fillLastName("Barut", driver);
        signupPage.fillEmail("aleyna@", driver);
        signupPage.fillPassword("StrongPassword123", driver);
    }

    @When("User enters a weak password")
    public void userEntersWeakPassword() {
        signupPage.clearFields(driver);
        signupPage.fillFirstName("Aleyna", driver);
        signupPage.fillLastName("Barut", driver);
        signupPage.fillEmail("aleyna@example.com", driver);
        signupPage.fillPassword("123", driver);
    }

    @When("User enters an already registered email address")
    public void userEntersAlreadyRegisteredEmailAddress() {
        signupPage.clearFields(driver);
        signupPage.fillFirstName("Aleyna", driver);
        signupPage.fillLastName("Barut", driver);
        signupPage.fillEmail("already.registered@example.com", driver);
        signupPage.fillPassword("StrongPassword123", driver);
    }

    @When("User leaves all fields empty")
    public void userLeavesAllFieldsEmpty() {
        signupPage.clearFields(driver);

    }

    @When("User clicks on the {string} button")
    public void userClicksOnRegisterButton(String buttonText) {
        signupPage.clickRegisterButton(driver);

    }

    @Then("User should see a {string} message")
    public void userShouldSeeAMessage(String expectedMessage) {
        String actualMessage = driver.findElement(By.id("io.selendroid.testapp:id/success_message")).getText();
        assert actualMessage.equals(expectedMessage) : "Expected message: " + expectedMessage + ", but got: " + actualMessage;
    }

    @Then("User should see a {string} error message")
    public void userShouldSeeAErrorMessage(String errorMessage) {
        String actualErrorMessage = driver.findElement(By.id("error_message_id")).getText();
        assert actualErrorMessage.equals(errorMessage) : "Expected error message: " + errorMessage + ", but got: " + actualErrorMessage;
    }


}
