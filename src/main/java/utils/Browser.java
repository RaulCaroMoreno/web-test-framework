package utils;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Browser {

    private PropertiesUtil properties;
    private RemoteWebDriver webDriver;
    private Capabilities capability;


    public Browser( ) {
        properties = new PropertiesUtil();
        chooseBrowser(properties.getProperty("browserName"));
        try{
            webDriver = new RemoteWebDriver(new URL(properties.getProperty("hubUrl")), capability);
        }catch (MalformedURLException url) {
            throw new IllegalArgumentException("Url not reachable");
        }
        webDriver.get(properties.getProperty("url"));
        maximizeWindow();
    }

    public void chooseBrowser(String browser) {
        switch (browser) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setCapability("version","105");
                capability = chromeOptions;
                break;
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                capability = firefoxOptions;
                break;
            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                capability = edgeOptions;
                break;
            default:
                capability = new ChromeOptions();
        }
    }
    public RemoteWebDriver getWebDriver() {
        return webDriver;
    }

    public void maximizeWindow() {
        webDriver.manage().window().maximize();
    }

}
