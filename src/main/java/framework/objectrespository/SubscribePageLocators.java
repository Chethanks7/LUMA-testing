package framework.objectrespository;

import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubscribePageLocators {

    public static final By EMAIL_FIELD = By.xpath("//input[@type='email']");
    public static final By FIRSTNAME_FIELD = By.id("mce-FNAME");
    public static final By LASTNAME_FIELD = By.id("mce-LNAME");
    public static final By COMPANY_NAME_FIELD = By.id("mce-COMPANY");
    public static final By POSITION_FIELD = By.id("mce-POSITION");
    public static final By SUBSCRIBE_BUTTON = By.xpath("//input[@type='submit']");

    public static List<By> subscribePageLocators(){
        return new ArrayList<>(Arrays.asList(
                EMAIL_FIELD,
                FIRSTNAME_FIELD,
                LASTNAME_FIELD,
                COMPANY_NAME_FIELD,
                POSITION_FIELD
        ));
    }
}
