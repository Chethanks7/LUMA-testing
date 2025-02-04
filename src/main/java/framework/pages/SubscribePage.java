package framework.pages;

import framework.objectrespository.SubscribePageLocators;
import framework.util.ElementUtil;
import framework.util.WaitUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@AllArgsConstructor
@Getter
@Setter
public class SubscribePage {
    private WebDriver driver ;

    public void subscribe(@NotNull List<String> subscribeFieldsData) throws InterruptedException {

        List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(windowHandles.get(1));
        Thread.sleep(3000);
        List<By> subscribePageLocators = SubscribePageLocators.subscribePageLocators() ;
        AtomicInteger locatorsIndex = new AtomicInteger();
        subscribeFieldsData.forEach(
                fieldData -> ElementUtil.enterText(
                        WaitUtil.waitForElementToBeVisible(
                                driver,
                                driver.findElement(subscribePageLocators.get(locatorsIndex.getAndIncrement())),
                                10
                        ),
                        fieldData
                )
        );

        WaitUtil.waitForElementToBeClickable(
                driver,driver.findElement(SubscribePageLocators.SUBSCRIBE_BUTTON),10
        ).click();

        driver.switchTo().defaultContent();
    }

}
