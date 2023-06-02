package Classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Checkout {
    private WebDriver driver;
    private By fName = By.id("billing_first_name");
    private By lName = By.id("billing_last_name");
    private By companyName = By.id("billing_company");
    private By countryRegionOption = By.xpath("//*[@id=\"billing_country_field\"]/span/span/span[1]/span/span[2]");
    private By selectCountryRegion = By.xpath("//*[@id=\"select2-billing_country-container\"]");
    private By noAndStreetName = By.id("billing_address_1");
    private By optionalInfo = By.id("billing_address_2");
    private By townOrCity = By.id("billing_city");
    private By provinceOption = By.xpath("//*[@id=\"billing_state_field\"]/span/span/span[1]/span/span[2]");
    private By province = By.xpath("//*[@id=\"select2-billing_state-container\"]");
    //private By stateOption = By.xpath("//*[@id=\"billing_state_field\"]/span/span/span[1]/span/span[2]");
    //private By state = By.xpath("//*[@id=\"select2-billing_state-result-dpkg-DL\"]");
    private By pinCode = By.id("billing_postcode");
    private By phone = By.id("billing_phone");
    private By email = By.id("billing_email");
    private By comment = By.id("order_comments");
    private By termsAndConditions = By.id("terms");
    private By placeOrder = By.xpath("//*[@id=\"place_order\"]");
    private By checkoutButton = By.xpath("//*[@id=\"noo-site\"]/header/div[1]/div/ul[2]/li[3]/a");
    public Checkout(WebDriver driver){
        this.driver =driver;
    }
    public void setFName(String billing_first_name){
        driver.findElement(fName).sendKeys(billing_first_name);}
    public void setLName(String billing_last_name){
        driver.findElement(lName).sendKeys(billing_last_name);}
    public void setCompanyName(String billing_company){
        driver.findElement(companyName).sendKeys(billing_company);}
    public void   clickCountryRegion(){
        driver.findElement(countryRegionOption).click();
        driver.findElement(selectCountryRegion).click();}
    public void setNoAndStreetName(String billing_address_1){
        driver.findElement(noAndStreetName).sendKeys(billing_address_1);}
    public void setOptionalInfo(String billing_address_2){
        driver.findElement(optionalInfo).sendKeys(billing_address_2);}
    public void setTownOrCity(String billing_city){
        driver.findElement(townOrCity).sendKeys(billing_city);}
    public void clickProvince(){
        driver.findElement(provinceOption).click();
        driver.findElement(province).click();
    }
    /*public void clickState() {
        driver.findElement(stateOption).click();
        driver.findElement(state).click();
    }*/
    public void setPinCode(String billing_postcode){
        driver.findElement(pinCode).sendKeys(billing_postcode);}
    public void setPhone(String billing_phone){
        driver.findElement(phone).sendKeys(billing_phone);}
    public void setEmail(String billing_email){
        driver.findElement(email).sendKeys(billing_email);}
    public void setComment(String order_comments){
        driver.findElement(comment).sendKeys(order_comments);}
    public void clickTerms(){
        driver.findElement(termsAndConditions).click();}
    public void clickPlaceOrders(){
        driver.findElement(placeOrder).click();
    }
    public void clickCheckoutButton(){
        driver.findElement(checkoutButton).click();
    }
}
