package utils;

import static utils.Constants.SOURCE_REPORT_FILE;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {

    ExtentTest test;
    private static ThreadLocal<ExtentTest> extenTest = new ThreadLocal<>();
    static ExtentReports extentReport;

    public void configReport() {
        ExtentSparkReporter reporter = new ExtentSparkReporter(SOURCE_REPORT_FILE);
        reporter.config().setReportName("Example report name");
        reporter.config().setDocumentTitle("Document title");
        extentReport = new ExtentReports();
        extentReport.attachReporter(reporter);
    }

    public void trackTest(String testName) {
        test = extentReport.createTest(testName);
        extenTest.set(test);
    }

    public void reportSuccess() {
        extenTest.get().log(Status.PASS, "test passed");
    }

    public void reportSkip() {
        extenTest.get().log(Status.SKIP, "test skipped");
    }

    public void reportFailure(String errorMessage) {
        extenTest.get().fail(errorMessage);
    }

    public void closeReport() {
        extentReport.flush();
    }


}
