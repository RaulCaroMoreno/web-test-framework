package core;

import java.util.Map;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.Browser;
import utils.DataExtractor;
import utils.Reports;

@ExtendWith({utils.Listener.class})
@Execution(ExecutionMode.CONCURRENT)
public class TestBase {

    protected BehaviorFactory behaviorFactory;
    private Browser browser;
    private RemoteWebDriver driver;
    private static Reports report = new Reports();
    private DataExtractor dataExtractor;
    protected Map<String, String> testData;

    public TestBase() {
        setUpWebDriver();
        setUpBehaviors();
        dataExtractor = new DataExtractor();
    }

    @AfterEach
    protected  void tearDown() {
        browser.getWebDriver().close();
    }

    @BeforeEach
    protected void setUpEnvironment(TestInfo testInfo) {
        report.trackTest(testInfo.getDisplayName());
        testData = dataExtractor.getJsonData(testInfo.getDisplayName().replace("()", ""));
    }

    private void setUpBehaviors() {
        behaviorFactory = new BehaviorFactory(driver);
    }

    private void setUpWebDriver() {
        browser = new Browser();
        driver = browser.getWebDriver();
    } 
}
