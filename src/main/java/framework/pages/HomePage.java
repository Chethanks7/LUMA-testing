package framework.pages;

import framework.objectrespository.HomePageLocators;
import framework.objectrespository.SignInLocators;
import framework.util.WaitUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class HomePage {
    private WebDriver driver;

    public void subscribe(
            List<String> subscribeFieldData
    ) throws InterruptedException {
        WaitUtil.waitForElementToBeClickable(
                driver,driver.findElement(HomePageLocators.SUBSCRIBE_LINK),10
        ).click();
        new SubscribePage(driver).subscribe(subscribeFieldData);
    }

}
