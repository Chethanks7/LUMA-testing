package com.tests;

import framework.base.BaseTest;
import framework.pages.HomePage;
import framework.util.ExcelUtil;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomePageTest extends BaseTest {

    @DataProvider(name = "SubscribeDataProvider")
    public Object[][] getCreateAccountData() throws IOException {
        List<String[]> createAccountData = ExcelUtil.readTestData(
                "C:\\Users\\User\\Downloads\\Subscribe_data.xlsx",
                "Sheet1"
        ) ;

        return createAccountData.stream()
                .map(data -> {
                    if(data.length == 0)
                        throw new IllegalStateException("now data found");

                    return Arrays.stream(data).toArray();
                })
                .toArray(Object[][]::new);
    }

    @Test(dataProvider = "SubscribeDataProvider")
    public void subscribeLinkTest(
            String email,
            String firstname,
            String lastname,
            String company,
            String position
    ) throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.subscribe(
                new ArrayList<>(Arrays.asList(
                        email,firstname,lastname,company,position
                ))
        );
    }
}
