package PageObjects;


import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Optional;

import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v114.network.Network;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.aventstack.extentreports.ExtentTest;

public class BaseClass {

    protected WebDriver driver;
    private WebDriverWait wait;
    public ExtentTest test;

   
  String baseUrl = "https://werpnmembers.108.tips/step-1/";  // QA
   
    // Method to initialize the browser based on the input parameter

    @BeforeMethod
    public void setupBrowser(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            default:
                throw new IllegalArgumentException("Browser " + browser + " is not supported.");
        }

        // Maximize the browser window
        driver.manage().window().maximize();
		
    }

    // Method to navigate to a specific URL
    public String openUrl() {
       
    	driver.get(baseUrl);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable((By.xpath("//*[text()=\"Dismiss\"]"))));
        return baseUrl;
    }
    
    // To initiate the driver instance
    
    public WebDriver getDriver() {
        return driver;
    }
    // Method to close the browser
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        
        
    }
    
    // To handle the Tawk-ChatBot
    
   
    public void handleChatBot() {
        // Reuse the existing driver instance
        ChromeOptions options = new ChromeOptions();
        DevTools devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();

        // Enable network and block specific URLs
        devTools.send(Network.enable(Optional.of(1000000), Optional.empty(), Optional.empty()));
        devTools.send(Network.setBlockedURLs(java.util.List.of(
            "https://embed.tawk.to/5dce6ff6d96992700fc7925c/default",
            "https://tools.luckyorange.com/core/lo.js?site-id=f07cc5b8"
        )));
    }
    
// Browser Close krne k lie
    @AfterMethod
    public void tearDown(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            captureScreenshot(result.getName());
        }
        if (driver != null) {
            driver.quit();
        }
    }

    
// Screenshot capture krne k lie on test case fail    
    public void captureScreenshot(String testName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String fileName = testName + "_" + timeStamp + ".jpg";

        File destination = new File("D:\\VCDoctorAutomationProject\\VCDoctorAutomation\\trunk\\target\\ErrorSnapShot\\" + fileName);
        try {
            FileHandler.copy(source, destination);
            System.out.println("Screenshot taken: " + destination.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Exception while taking screenshot: " + e.getMessage());
        }
    } 
    
}
