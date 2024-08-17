package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LogoutPage {

    // Locators
    public final By logoutButtonLoc = By.id("your_logout_button_id"); // Çıkış butonunun ID'sini girin
    public final By confirmLogoutButtonLoc = By.id("your_confirm_logout_button_id"); // Çıkışı onaylama butonunun ID'sini girin
    public final By cancelLogoutButtonLoc = By.id("your_cancel_logout_button_id"); // Çıkışı iptal etme butonunun ID'sini girin
    public final By successMessageLoc = By.id("your_success_message_id"); // Başarı mesajı alanının ID'sini girin
    public final By errorMessageLoc = By.id("your_error_message_id"); // Hata mesajı alanının ID'sini girin
    public final By currentScreenLoc = By.id("your_current_screen_id"); // Mevcut ekran ID'sini girin

    private final AppiumDriver driver;

    public LogoutPage(AppiumDriver driver) {
        this.driver = driver;
    }

    private WebElement logoutButtonElement() {
        return driver.findElement(logoutButtonLoc);
    }

    private WebElement confirmLogoutButtonElement() {
        return driver.findElement(confirmLogoutButtonLoc);
    }

    private WebElement cancelLogoutButtonElement() {
        return driver.findElement(cancelLogoutButtonLoc);
    }

    private WebElement successMessageElement() {
        return driver.findElement(successMessageLoc);
    }

    private WebElement errorMessageElement() {
        return driver.findElement(errorMessageLoc);
    }

    private WebElement currentScreenElement() {
        return driver.findElement(currentScreenLoc);
    }

    public void clickLogoutButton() {
        logoutButtonElement().click();
    }

    public void clickConfirmLogoutButton() {
        confirmLogoutButtonElement().click();
    }

    public void clickCancelLogoutButton() {
        cancelLogoutButtonElement().click();
    }

    public String getSuccessMessage() {
        return successMessageElement().getText();
    }

    public String getErrorMessage() {
        return errorMessageElement().getText();
    }

    public String getCurrentScreen() {
        return currentScreenElement().getText();
    }
}
