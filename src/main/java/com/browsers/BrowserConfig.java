package com.browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserConfig {

    public static WebDriver startAPP(WebDriver driver, String browserName, String url) {
        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hamim\\Desktop\\driver\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver");
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("opera")) {
            System.setProperty("webdriver.opera.driver", "Drivers/operadriver");
            driver = new OperaDriver();
        } else if (browserName.equalsIgnoreCase("safari")) {
            System.setProperty("webdriver.safari.driver", "Drivers/safaridriver");
            driver = new SafariDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", "Drivers/msedgedriver");
            driver = new EdgeDriver();
        } else {
            System.out.println(browserName+" is not supported by this framework!");
            //here you can use logger
        }

        //
        driver.manage().window().maximize();
        //
        driver.get(url);
        //
        return driver;
    }

    public static void closeAPP(WebDriver driver) {
        driver.quit();
    }
}
