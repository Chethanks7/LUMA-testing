package com.tests;

import framework.base.BaseTest;
import framework.pages.LoginPage;
import framework.util.ExcelUtil;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class SignInTest extends BaseTest {

    @DataProvider(name = "signInData")
    public Object[][] getSignInData() throws IOException {
        List<String[]> data = ExcelUtil.readTestData(
                "C:\\Users\\User\\Downloads\\LoginTestData.xlsx",
                "LoginData");

        data.forEach(
                fileData -> {
                    System.out.println(fileData.length);
                }

        );
       return data.stream()
                .map(row ->{
                        if(row.length!=0)return new Object[]{row[0],row[1]};
                        throw new IllegalStateException("Array length is 0");
                })
                .toArray(Object[][]::new);
    }

    @Test(dataProvider = "signInData")
    public void singInTest(String username , String password) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username,password);
    }

}
