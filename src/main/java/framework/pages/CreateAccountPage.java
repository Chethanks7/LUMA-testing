package framework.pages;

import framework.objectrespository.CreateAccountLocators;
import framework.objectrespository.SignInLocators;
import framework.util.ElementUtil;
import framework.util.WaitUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@AllArgsConstructor
@Setter
@Getter
public class CreateAccountPage {
    private  WebDriver driver ;

    public  void    createAccount(
            @NotNull List<String> createAccountData
    ){
        //switching to the create account link
        WaitUtil.waitForElementToBeClickable(
               driver,driver.findElement(SignInLocators.CREATE_ACCOUNT_LINK),10
       ).click();

        Assert.assertEquals(driver.getTitle(), "Create New Customer Account");

        List<By> locators = CreateAccountLocators.createAccountPageLocators() ;
        AtomicInteger locatorsIndex = new AtomicInteger();

        createAccountData.forEach(
                fieldData -> {
                    WebElement element  = driver.findElement(locators.get(locatorsIndex.getAndIncrement()));
                    ElementUtil.enterText(
                            WaitUtil.waitForElementToBeVisible(driver,element,15),
                            fieldData
                    );
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
        );
    }

}
