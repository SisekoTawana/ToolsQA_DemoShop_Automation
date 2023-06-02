package Classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Verify {
    private WebDriver driver;
    private By statusAlert = By.xpath("/html/body/div[1]/div[2]/main/article/div/div/div");

    public Verify(WebDriver driver) {
        this.driver = driver;
    }
    public String getAlertText() {
        return driver.findElement(statusAlert).getText();
    }
}
