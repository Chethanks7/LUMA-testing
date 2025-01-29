package framework.objectrespository;

import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreateAccountLocators {

    public static final By FIRSTNAME_FIELD = By.xpath("//input[@id='firstname']");
    public static final By LASTNAME_FIELD = By.xpath("//input[@id='lastname']");
    public static final By EMAIL_FIELD = By.xpath("//input[@id='email_address']");
    public static final By PASSWORD_FIELD = By.xpath("//input[@id='password']");
    public static final By PASSWORD_CONFIRMATION_FIELD  = By.xpath("//input[@id='password-confirmation']");

    public static List<By> createAccountPageLocators(){
        return new ArrayList<>(Arrays.asList(
                FIRSTNAME_FIELD,
                LASTNAME_FIELD,
                EMAIL_FIELD,
                PASSWORD_FIELD,
                PASSWORD_CONFIRMATION_FIELD
        ));
    }
}
