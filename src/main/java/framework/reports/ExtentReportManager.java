package framework.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportManager {

    private static ExtentReports extentReports ;

    public   static ExtentReports geExtentReports() throws IOException {
            if(extentReports == null){
                String timestamp = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss").format(new Date());
                String path = "C:\\Users\\User\\Downloads\\SeleniumAppTest\\test_reports\\ExtentReport_"+timestamp+".html";
                ExtentSparkReporter sparkReporter = new ExtentSparkReporter(path) ;
                sparkReporter.loadXMLConfig(
                        "C:\\Users\\User\\Downloads\\SeleniumAppTest\\src\\test\\resources\\config\\extent-config.xml"
                );
                extentReports = new ExtentReports();
                extentReports.attachReporter(sparkReporter);
                extentReports.setSystemInfo("OS", System.getProperty("os.name"));
                extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
            }
        return extentReports ;
    }
}
