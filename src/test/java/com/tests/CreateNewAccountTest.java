package com.tests;

import framework.base.BaseTest;
import framework.pages.CreateAccountPage;
import framework.util.ExcelUtil;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreateNewAccountTest extends BaseTest {

    @DataProvider(name = "createAccountDataProvider")
    public Object[][] getCreateAccountData() throws IOException {
        List<String[]> createAccountData = ExcelUtil.readTestData(
                "C:\\Users\\User\\Downloads\\TEST_Data.xlsx",
                "Sheet2"
        ) ;

       return createAccountData.stream()
                .map(data -> {
                    if(data.length == 0)
                        throw new IllegalStateException("now data found");

                    return Arrays.stream(data).toArray();
                })
                .toArray(Object[][]::new);
    }

    @Test(dataProvider = "createAccountDataProvider")
    public void createAccountTest(
            String firstname,
            String lastname,
            String email,
            String password,
            String confirmPassword
    ){
        new CreateAccountPage(driver).createAccount(
                new ArrayList<>(Arrays.asList(
                        firstname,lastname,email,password,confirmPassword
                ))
        );
    }
}
