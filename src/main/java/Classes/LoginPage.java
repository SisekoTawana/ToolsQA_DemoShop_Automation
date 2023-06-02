package Classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By userName = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.xpath("/html/body/div[1]/div[2]/main/article/div/div/div[2]/div[1]/form/p[3]/button");
    private By logout = By.xpath("/html/body/div[1]/div[2]/main/article/div/div/nav/ul/li[6]/a");
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
    public void setUsername(String username) {
        driver.findElement(userName).sendKeys(username);
    }
    public void setPassword(String password) {
            driver.findElement(passwordField).sendKeys(password);
    }
    public Verify clickLoginButton(){
        driver.findElement(loginButton).click();
        return new Verify(driver);
    }
    public void goTo(){
        driver.get("https://shop.demoqa.com/shop/");
    }
    public void clickLogout() {
        driver.findElement(logout).click();
    }
}
