package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.PageInitializer;

import java.util.concurrent.TimeUnit;

public class CommonMethods extends PageInitializer {
    public static WebDriver driver;

    public static void openBrowserAndLaunchApplication(){
        ConfigReader.readProperties(Constants.CONFIGURATION_FILEPATH);
        String browserName=ConfigReader.getPropertyValue("browser");
        //cross browser testing
        switch (browserName){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Invalid browser name");
        }
        String url=ConfigReader.getPropertyValue("url");
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS );
        //initialize the page initializers
        initializePageObjects();
    }
    public static WebDriverWait getWait(){
        WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICIT_WAIT);
        return wait;
    }
    public static void waitForClickability(WebElement element){
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }
    public static void click(WebElement element){
        waitForClickability(element);
        element.click();
    }
    public static void sendText(WebElement element, String textToSend){
        element.clear();
        element.sendKeys(textToSend);
    }
}
