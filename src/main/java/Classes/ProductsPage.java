package Classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
    private WebDriver driver;
    private By heelItem = By.xpath("/html/body/div[2]/div[2]/div[2]/div/div/div[3]/div/h3/a");
    private By heelColorOption = By.xpath("/html/body/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/form/table/tbody/tr[1]/td/select");
    private By selectHeelColor = By.xpath("//*[@id=\"pa_color\"]/option[2]");
    private By heelSizeOption = By.xpath("//*[@id=\"pa_size\"]");
    private By selectHeelSize = By.xpath("//*[@id=\"pa_size\"]/option[2]");
    private By addHeelCart = By.xpath("//*[@id=\"product-1281\"]/div[1]/div[2]/form/div/div[2]/button");
    private By page3 = By.xpath("//*[@id=\"noo-site\"]/div[2]/div[2]/div/nav/ul/li[3]/a");
    private By dressItem = By.xpath("//*[@id=\"noo-site\"]/div[2]/div[2]/div/div/div/div/h3/a");
    private By dressColorOption = By.xpath("//*[@id=\"pa_color\"]");
    private By selectDressColor = By.xpath("//*[@id=\"pa_color\"]/option[2]");
    private By dressSizeOption = By.xpath("//*[@id=\"pa_size\"]");
    private By selectDressSize = By.xpath("//*[@id=\"pa_size\"]/option[4]");
    private By addDressCart = By.xpath("//*[@id=\"product-1248\"]/div[1]/div[2]/form/div/div[2]/button");
    private By viewCart = By.xpath("//*[@id=\"noo-site\"]/div[2]/div/div/div[1]/div/a");
    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickHeelsItem() {
        driver.findElement(heelItem).click();
    }
    public void clickHeelColorOption() {
        driver.findElement(heelColorOption).click();
        driver.findElement(selectHeelColor).click();
    }
    public void clickHeelSizeOption(){
        driver.findElement(heelSizeOption).click();
        driver.findElement(selectHeelSize).click();
    }
    public void clickAddHeel(){

        driver.findElement(addHeelCart).click();
    }
    public void clickPage3(){
        driver.findElement(page3).click();
    }
    public void clickDressItem(){

        driver.findElement(dressItem).click();
    }
    public void clickDressColorOption(){

        driver.findElement(dressColorOption).click();
        driver.findElement(selectDressColor).click();
    }
    public void clickDressSizeOption(){
        driver.findElement(dressSizeOption).click();
        driver.findElement(selectDressSize).click();
    }
    public void clickAddDressCart(){
        driver.findElement(addDressCart).click();
    }
    public void clickViewCart(){
        driver.findElement(viewCart).click();
    }
}
