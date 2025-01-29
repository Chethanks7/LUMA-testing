package framework.objectrespository;

import org.openqa.selenium.By;

public class SignInLocators {
    public static final By USERNAME_FIELD = By.xpath("//input[@id='email']");
    public static final By PASSWORD_FIELD = By.xpath("(//input[@type = 'password'])[1]");
    public static final By SIGNIN_BUTTON = By.xpath("(//button[@id='send2'])[1]");
}
