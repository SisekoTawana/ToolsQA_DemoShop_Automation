package Classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Cart {
    private WebDriver driver;
    private By proceedToCheckoutButton = By.xpath("//*[@id=\"post-6\"]/div/div/div[2]/div[2]/div/a");
    public Cart(WebDriver driver){
        this.driver = driver;
    }
    public void clickProceedToCheckout(){
        driver.findElement(proceedToCheckoutButton).click();
    }
}
