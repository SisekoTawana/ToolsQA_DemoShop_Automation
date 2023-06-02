package Application;

import Classes.HomePage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTest {

    protected static WebDriver driver;
    public static HomePage homePage;
    protected static ExtentReports extent;
    protected static ExtentTest test;
    @BeforeTest
    public void setUp() {
        System.setProperty("web-driver.chrome","resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://shop.demoqa.com/shop/");

        homePage = new HomePage(driver);
        homePage.clickDismissLink();
        homePage.clickMyAccount();

    }
}