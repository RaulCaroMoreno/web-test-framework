package suites;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        cases.LoginCase.class,
        cases.CheckInventoryItems.class
})
public class TestSuite {




}
