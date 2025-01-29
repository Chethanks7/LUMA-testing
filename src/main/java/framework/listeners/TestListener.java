package framework.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import framework.reports.ExtentReportManager;
import org.jetbrains.annotations.NotNull;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class TestListener implements ITestListener {
    private ExtentReports extentReports ;
    private ExtentTest test ;

    @Override
    public void onStart(ITestContext context){
        try {
            extentReports = ExtentReportManager.geExtentReports();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestStart(@NotNull ITestResult result) {
        // not implemented
        test = extentReports.createTest(result.getMethod().getMethodName());
    }
    @Override
    public void onTestSuccess(@NotNull ITestResult result) {
        test.log(Status.PASS, "Test passed: " + result.getMethod().getMethodName());
    }

    @Override
    public void onFinish(ITestContext context) {
        extentReports.flush();
    }
}
