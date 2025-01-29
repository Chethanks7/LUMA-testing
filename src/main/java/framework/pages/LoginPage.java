package framework.pages;

import framework.objectrespository.SignInLocators;
import framework.util.ElementUtil;
import framework.util.WaitUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


@AllArgsConstructor
@Setter
@Getter
public class LoginPage {
    WebDriver driver ;

	public void login(String username, String password) throws InterruptedException {
        // Enter username
        ElementUtil.enterText(
                WaitUtil.waitForElementToBeVisible(
                        driver,
                        driver.findElement(SignInLocators.USERNAME_FIELD),
                        10
                ),
                username
        );
        Thread.sleep(1000);

        // Enter password
        ElementUtil.enterText(
                WaitUtil.waitForElementToBeVisible(
                        driver,
                        driver.findElement(SignInLocators.PASSWORD_FIELD),
                        10
                ),
                password
        );
        Thread.sleep(1000);

        // Click the Sign-In button
        WebElement btn = WaitUtil.waitForElementToBeClickable(
                driver,
                driver.findElement(SignInLocators.SIGNIN_BUTTON),
                15
        );
        btn.click(); ;
    }
}
