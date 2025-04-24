package DanceGroupPractice.com.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {

    //create a private constructor to remove access to this object

    private  Driver(){}

    /*
    We make the WebDriver private, because we want to close access from outside the class.
    We are making it static, because we will use it in a static method.
     */
    // private static WebDriver driver;  //default value = null

    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();

    /*
    Create a re-usable utility method which will return the same driver instance once we call it.
    - if an instance doesn't exist, it will create first, and then it will always return same instance.
     */

    public static WebDriver getDriver(){

        if(driverPool.get() == null){
            /*
            we will read our browserType from configuration.properties file.
            this way, we can control which browser is opened from outside our code.
             */

            String browserType = ConfigurationReader.getProperty("browser");

            /*
            Depending on the browserType returned from the configuration.properties
            switch statement will determine the "case" and open the matching driver
             */
            switch (browserType){
                case "chrome":
                    // WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.5735.199 Safari/537.36");
                    driverPool.set(new ChromeDriver(options));
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;

                case "firefox":
                    // WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
               /* case "headless-chrome":
                    ChromeOptions options = new ChromeOptions();
                    options.setHeadless(true);
                    driverPool.set(new ChromeDriver(options));
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;*/

            }

        }
        return driverPool.get();

    }

    /*
    create w new Driver.closeDriver(), it will use quit() method to quit browsers, and then set the driver value back to null.
     */

    public static void closeDriver(){
        if (driverPool.get()!= null){

            /*
            this line will terminate the currently existing driver completly. it will be non-exist going forward.
             */

            driverPool.get().quit();

            /*
            We assign the value back to "null" so that me "singleton" can create a newer one if needed.
             */

            driverPool.remove();
            // or: driverPool.set(null);

        }
    }
}
