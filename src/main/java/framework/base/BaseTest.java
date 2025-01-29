package framework.base;

import framework.util.ConfigReader;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver ;

    @BeforeMethod
    public void setUp(@NotNull ITestContext context){
        String browser = ConfigReader.getProperties("browser");
        String url = ConfigReader.getProperties("url");


        driver = WebDriverFactory.createDriver(browser);
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