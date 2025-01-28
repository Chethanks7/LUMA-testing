package framework.util;

import org.openqa.selenium.WebElement;

public class ElementUtil {

    public static void click(WebElement element) {
        element.click();
    }

    public static void enterText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    public static String getText(WebElement element) {
        return element.getText();
    }

    public static boolean isDisplayed(WebElement element) {
        return element.isDisplayed();
    }
}
