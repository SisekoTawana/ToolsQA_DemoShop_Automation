package Classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private By dismissLink = By.linkText("Dismiss");
    private By clickMyAccount = By.linkText("My Account");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage clickDismissLink() {
        driver.findElement(dismissLink).click();
        return new LoginPage(driver);
    }

    public LoginPage clickMyAccount() {
        driver.findElement(clickMyAccount).click();
        return new LoginPage(driver);
    }

}