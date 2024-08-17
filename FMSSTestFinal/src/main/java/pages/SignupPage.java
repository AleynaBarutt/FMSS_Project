package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignupPage {

    // Locators
    public final By firstNameloc = By.id("your_first_name_field_id"); // İlk ad alanının ID'sini girin
    public final By lastNAmeLoc = By.id("your_last_name_field_id"); // Son ad alanının ID'sini girin
    public final By emailLoc = By.id("your_email_field_id"); // Email alanının ID'sini girin
    public final By passwordLoc = By.id("your_password_field_id"); // Şifre alanının ID'sini girin
    public final By registerButtonLoc = By.id("your_register_button_id"); // Kayıt butonunun ID'sini girin
    public final By successMessageLoc = By.id("your_success_message_id"); // Başarı mesajı alanının ID'sini girin
    public final By errorMessageLoc = By.id("your_error_message_id"); // Hata mesajı alanının ID'sini girin

    private WebElement firstNameElement(WebDriver driver) {
        return driver.findElement(firstNameloc);
    }

    private WebElement lastNameElement(WebDriver driver) {
        return driver.findElement(lastNAmeLoc);
    }

    private WebElement emailElement(WebDriver driver) {
        return driver.findElement(emailLoc);
    }

    private WebElement passwordElement(WebDriver driver) {
        return driver.findElement(passwordLoc);
    }

    private WebElement registerButtonElement(WebDriver driver) {
        return driver.findElement(registerButtonLoc);
    }

    public void fillFirstName(String firstName, WebDriver driver) {
        firstNameElement(driver).sendKeys(firstName);
    }

    public void fillLastName(String lastName, WebDriver driver) {
        lastNameElement(driver).sendKeys(lastName);
    }

    public void fillEmail(String email, WebDriver driver) {
        emailElement(driver).sendKeys(email);
    }

    public void fillPassword(String password, WebDriver driver) {
        passwordElement(driver).sendKeys(password);
    }

    public void clickRegisterButton(WebDriver driver) {
        registerButtonElement(driver).click();
    }

    public String getSuccessMessage(WebDriver driver) {
        return driver.findElement(successMessageLoc).getText();
    }

    public String getErrorMessage(WebDriver driver) {
        return driver.findElement(errorMessageLoc).getText();
    }

    public void clearFields(WebDriver driver) {
        firstNameElement(driver).clear();
        lastNameElement(driver).clear();
        emailElement(driver).clear();
        passwordElement(driver).clear();
    }
}
