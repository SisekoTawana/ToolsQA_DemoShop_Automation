package TestLogin;
import org.testng.annotations.Test;
import Classes.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import Utilities.ExcelHelper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestLogin extends ExcelHelper {
    ExcelHelper excelData;
    WebDriver driver;
    HomePage account;
    LoginPage loginP, logO;
    DashboardPage downloads, browse;
    ProductsPage products, viewCart, pageNo3;
    Cart cartcheckout;
    Checkout billInfo;
    private String username;
    private String password;
    ExtentReports extentReports = new ExtentReports();
    ExtentSparkReporter sparkReporter = new ExtentSparkReporter("ExtentReport.html");

    @Parameters({"browseName", "browserUrl"})
    @BeforeTest
    public void initialize(String browserName, String browseUrl) {
        if (browserName.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        } else if (browserName.equalsIgnoreCase("Edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            driver.manage().window().maximize();
        }
        excelData = new ExcelHelper();
        excelData.setupExcel();

        extentReports.attachReporter(sparkReporter);
    }

    @Test(priority = 1)
    public void testUnsuccessfulLogin() throws InterruptedException {
        loginP = new LoginPage(driver);

        ExtentTest extentTest = extentReports.createTest("Login Failed");
        extentReports.attachReporter(sparkReporter);
        username = excelData.getCellData(1, 1);
        password = excelData.getCellData(1, 2);
        loginP.goTo();
        loginP.setUsername(username);
        loginP.setPassword(password);
        loginP.clickLoginButton();
        Assert.assertTrue(false);
        Thread.sleep(3000);
    }

    @Test(priority = 2)
    public void testSuccessfulLogin() throws InterruptedException {
        loginP = new LoginPage(driver);
        /*logO = new LoginPage(driver);*/

        extentReports.attachReporter(sparkReporter);
        ExtentTest extentTest = extentReports.createTest("Login Passed");
        username = excelData.getCellData(2, 1);
        password = excelData.getCellData(2, 2);
        loginP.setUsername(username);
        loginP.setPassword(password);
        loginP.clickLoginButton();
        /*logO.clickLogout();*/
        Thread.sleep(3000);
    }

    @Test(priority = 3)
    public void addItem() throws InterruptedException {
        extentReports.attachReporter(sparkReporter);
        ExtentTest extentTest = extentReports.createTest("Products");
        String HeelItem = excelData.getCellData(2, 3);
        String HeelColor = excelData.getCellData(2, 4);
        String HeelSize = excelData.getCellData(2, 5);
        products = new ProductsPage(driver);
        logO = new LoginPage(driver);

        products.clickHeelsItem();
        products.clickHeelColorOption();
        products.clickHeelSizeOption();
        products.clickAddHeel();
        viewCart.clickViewCart();
        account.clickMyAccount();
        logO.clickLogout();
        Thread.sleep(3000);
    }

    @Test(priority = 4)
    public void addItemInPage3() throws InterruptedException {
        loginP = new LoginPage(driver);
        logO = new LoginPage(driver);
        downloads = new DashboardPage(driver);
        browse = new DashboardPage(driver);
        pageNo3 = new ProductsPage(driver);
        products = new ProductsPage(driver);
        logO = new LoginPage(driver);
        viewCart = new ProductsPage(driver);
        account = new HomePage(driver);

        extentReports.attachReporter(sparkReporter);
        ExtentTest extentTest = extentReports.createTest("Login Passed");
        username = excelData.getCellData(2, 1);
        password = excelData.getCellData(2, 2);
        loginP.setUsername(username);
        loginP.setPassword(password);
        loginP.clickLoginButton();
        downloads.clickDownloads();
        browse.clickBrowseProducts();
        pageNo3.clickPage3();
        products.clickDressItem();
        products.clickDressColorOption();
        products.clickDressSizeOption();
        products.clickAddDressCart();
        viewCart.clickViewCart();
    }

    /*@Test(priority = 5)
    public void page3Order() {
        ExtentTest extentTest = extentReports.createTest("Page 3 Clicks");
        extentReports.attachReporter(sparkReporter);
        String ProdName = excelData.getCellData(3, 3);
        String ProdColor = excelData.getCellData(3, 4);
        String ProdSize = excelData.getCellData(3, 5);
        products = new ProductsPage(driver);
        products.clickPage3(ProdName, ProdColor, ProdSize);
    }
*/
    @Test(priority = 5)
    public void cartSpace() throws InterruptedException {
        ExtentTest extentTest = extentReports.createTest("Checkout Procedure");
        extentReports.attachReporter(sparkReporter);
        cartcheckout = new Cart(driver);
        cartcheckout.clickProceedToCheckout();
        Thread.sleep(3000);
    }

    @Test(priority = 6)
    public void bills() throws InterruptedException {

        ExtentTest extentTest = extentReports.createTest("Billing form test");
        extentReports.attachReporter(sparkReporter);
        /*extentTest.fail("Form crashed");*/
        String BFirstName = excelData.getCellData(3, 6);
        String BLastName = excelData.getCellData(3, 7);
        String BCompany = excelData.getCellData(3, 9);
        String BCountry = excelData.getCellData(3, 10);
        String BAddress = excelData.getCellData(3, 11);
        String BCity = excelData.getCellData(3, 12);
        String BProvince = excelData.getCellData(3, 13);
        String BCode = String.valueOf(excelData.getCellInt(3, 14));
        String BPhone = excelData.getCellData(3, 15);
        String BEmail = excelData.getCellData(3, 8);
        billInfo = new Checkout(driver);
        billInfo.setFName(BFirstName);
        billInfo.setLName(BLastName);
        billInfo.setCompanyName(BCompany);
        billInfo.clickCountryRegion();
        billInfo.setNoAndStreetName(BAddress);
        billInfo.setTownOrCity(BCity);
        billInfo.clickProvince();
        billInfo.setPinCode(BCode);
        billInfo.setPhone(BPhone);
        billInfo.setEmail(BEmail);

        Thread.sleep(3000);

    }
    @AfterTest
    public void endTest() {
        extentReports.flush();}
}

/*public class TestLogin extends Application.BaseTest{
@Test(priority = 1)
    public void testUnsuccessfulLogin () throws InterruptedException{
        LoginPage loginPage = homePage.clickMyAccount();
        Thread.sleep(2000);
        loginPage.setUsername("hhgfytdyt");
        Thread.sleep(2000);
        loginPage.setPassword("ydfyt7gygfyg");
        Thread.sleep(2000);
        Verify verify =loginPage.clickLoginButton();
        assertNotEquals(verify.getAlertText(), "Hello SisekoTawana (not SisekoTawana? Log out)",
                "ERROR: The username or password you entered is incorrect. Lost your password?");
        Thread.sleep(2000);
    }
    @Test(priority = 2)
    public void testSuccessfulLogin() throws InterruptedException{
        LoginPage loginPage = homePage.clickMyAccount();
        Thread.sleep(2000);
        loginPage.setUsername("SekoT");
        Thread.sleep(2000);
        loginPage.setPassword("SetoT_2023");
        Thread.sleep(2000);
        Verify verify = loginPage.clickLoginButton();
        assertNotEquals(verify.getAlertText(), "Hello SekoT (not SekoT? Log out)\n" +
                        "\n" +
                        "From your account dashboard you can view your recent orders, manage your shipping and billing addresses, and edit your password and account details.",
                "Hello SekoT (not SekoT? Log out)\n" +
                        "\n" +
                        "From your account dashboard you can view your recent orders, manage your shipping and billing addresses, and edit your password and account details.");
        Thread.sleep(2000);
        LoginPage clickLogoutWord = new LoginPage(driver);
        clickLogoutWord.clickLogout();
        Thread.sleep(2000);
}
    @Test(priority = 3)
    public void addItemSaleToCart() throws InterruptedException {
        LoginPage loginPage = homePage.clickMyAccount();
        Thread.sleep(2000);
        loginPage.setUsername("SekoT");
        Thread.sleep(2000);
        loginPage.setPassword("SetoT_2023");
        Thread.sleep(2000);
        Verify verify = loginPage.clickLoginButton();
        assertNotEquals(verify.getAlertText(), "Hello SekoT (not SekoT? Log out)\n" +
                        "\n" +
                        "From your account dashboard you can view your recent orders, manage your shipping and billing addresses, and edit your password and account details.",
                "Hello SekoT (not SekoT? Log out)\n" +
                        "\n" +
                        "From your account dashboard you can view your recent orders, manage your shipping and billing addresses, and edit your password and account details.");

        Thread.sleep(2000);
        DashboardPage downloadsClick = new DashboardPage(driver);
        downloadsClick.clickDownloads();
        Thread.sleep(2000);

        DashboardPage browseClick = new DashboardPage(driver);
        browseClick.clickBrowseProducts();
        Thread.sleep(2000);
        ProductsPage clickHeelItem = new ProductsPage(driver);
        clickHeelItem.clickHeelsItem();
        Thread.sleep(2000);
        ProductsPage clickHeelColorItem = new ProductsPage(driver);
        clickHeelColorItem.clickHeelColorOption();
        Thread.sleep(2000);
        ProductsPage clickHeelSizeItem = new ProductsPage(driver);
        clickHeelSizeItem.clickHeelSizeOption();
        Thread.sleep(2000);
        ProductsPage clickAddHeelCartItem = new ProductsPage(driver);
        clickAddHeelCartItem.clickAddHeel();
        Thread.sleep(2000);
        HomePage clickMyAccount = new HomePage(driver);
        clickMyAccount.clickMyAccount();
        Thread.sleep(2000);
        *//*LoginPage clickLogoutWord = new LoginPage(driver);
        clickLogoutWord.clickLogout();
        Thread.sleep(2000);*//*
    }

  @Test(priority = 4)
  public void addItemFromPage3() throws InterruptedException {
     *//* LoginPage loginPage = homePage.clickMyAccount();
      Thread.sleep(4000);
      loginPage.setUsername("SekoT");
      Thread.sleep(4000);
      loginPage.setPassword("SetoT_2023");
      Thread.sleep(4000);
      Verify verify = loginPage.clickLoginButton();
      assertNotEquals(verify.getAlertText(), "Hello SekoT (not SekoT? Log out)\n" +
                      "\n" +
                      "From your account dashboard you can view your recent orders, manage your shipping and billing addresses, and edit your password and account details.",
              "Hello SekoT (not SekoT? Log out)\n" +
                      "\n" +
                      "From your account dashboard you can view your recent orders, manage your shipping and billing addresses, and edit your password and account details.");


      Thread.sleep(4000);*//*
      DashboardPage downloadsClick = new DashboardPage(driver);
      downloadsClick.clickDownloads();
      Thread.sleep(4000);
      DashboardPage browseClick = new DashboardPage(driver);
      browseClick.clickBrowseProducts();
      Thread.sleep(4000);
      ProductsPage page3 = new ProductsPage(driver);
      page3.clickPage3();
      Thread.sleep(4000);
      ProductsPage dressItem = new ProductsPage(driver);
      dressItem.clickDressItem();
      Thread.sleep(4000);
      ProductsPage clickDressColor = new ProductsPage(driver);
      clickDressColor.clickDressColorOption();
      Thread.sleep(4000);
      ProductsPage dressSize = new ProductsPage(driver);
      dressSize.clickDressSizeOption();
      Thread.sleep(4000);
      ProductsPage addDressCart = new ProductsPage(driver);
      addDressCart.clickAddDressCart();
      Thread.sleep(2000);
      ProductsPage viewCart = new ProductsPage(driver);
      viewCart.clickViewCart();
      Thread.sleep(4000);
      Cart proceedToCheckout = new Cart(driver);
      proceedToCheckout.clickProceedToCheckout();
      Thread.sleep(4000);
      Checkout checkout = new Checkout(driver);
      Thread.sleep(4000);
      checkout.setFName("Bibo");
      Thread.sleep(4000);
      checkout.setLName("Bibo");
      Thread.sleep(4000);
      checkout.setCompanyName("HR");
      Thread.sleep(4000);
      checkout.clickCountryRegion();
      Thread.sleep(4000);
      checkout.setNoAndStreetName("885 Bibo");
      Thread.sleep(4000);
      checkout.setOptionalInfo("Bibo");
      Thread.sleep(4000);
      checkout.setTownOrCity("Bibo");
      Thread.sleep(4000);
      checkout.clickProvince();
      Thread.sleep(4000);
      checkout.setPinCode("1234");
      Thread.sleep(4000);
      checkout.setPhone("9876543210");
      Thread.sleep(4000);
      checkout.setEmail("sekoT@gmail.com");
      Thread.sleep(4000);
      checkout.setComment("sgduigfshfaghgdahfgjsdjgjdgjh");
      Thread.sleep(4000);
      checkout.clickTerms();
      Thread.sleep(4000);
      checkout.clickPlaceOrders();
      Thread.sleep(4000);
      LoginPage clickLogoutWord = new LoginPage(driver);
      clickLogoutWord.clickLogout();
      Thread.sleep(4000);
  }
}*/

