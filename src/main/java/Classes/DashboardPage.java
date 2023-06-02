package Classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {

    private WebDriver driver;
    private By downloads = By.xpath("/html/body/div[1]/div[2]/main/article/div/div/nav/ul/li[3]/a");
    private By browseProducts = By.xpath("/html/body/div[1]/div[2]/main/article/div/div/div/div[2]/a");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickDownloads() {
        driver.findElement(downloads).click();
    }

    public void clickBrowseProducts() {
        driver.findElement(browseProducts).click();

    }
}
