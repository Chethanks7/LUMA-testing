package framework.base;

import framework.util.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver ;

    @BeforeMethod
    public void setUp(ITestContext context){
        String browser = ConfigReader.getProperties("browser");
        String url = ConfigReader.getProperties("url");


        driver = WebDriverFactory.createDriver(browser);
        assert driver != null;
        driver.get(url);

        driver.manage().window().maximize();
        context.setAttribute("driver",driver);
    }

    @AfterMethod
    public void shutDown(){
        if(driver!=null)
            driver.quit();
    }
}