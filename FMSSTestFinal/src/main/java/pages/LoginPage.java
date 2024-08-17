package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private AppiumDriver driver;

    public LoginPage(AppiumDriver driver) {
        this.driver = driver;
    }

    public WebElement userNameEl() {
        return driver.findElement(By.id("io.selendroid.testapp:id/my_text_field"));
    }

    public WebElement passwordEl() {
        return driver.findElement(By.id("io.selendroid.testapp:id/my_password_field"));
    }

    public WebElement loginButtonEl() {
        return driver.findElement(By.id("io.selendroid.testapp:id/my_login_button")); // Giriş butonunun ID'sini girin
    }

    public void fillUserName(String username) {
        userNameEl().sendKeys(username);
    }

    public void fillPassword(String password) {
        passwordEl().sendKeys(password);

    }
    public void clickLoginButton() {
        loginButtonEl().click(); // Giriş butonuna tıkla
    }

    public void clickForgotPassword() {
        driver.findElement(By.id("io.selendroid.testapp:id/forgot_password")).click();
    }
}
