package cases;


import static org.junit.jupiter.api.Assertions.assertTrue;

import core.TestBase;
import org.junit.jupiter.api.Test;


public class LoginCase extends TestBase {

    @Test()
    public void testLoginPage() {
        behaviorFactory.getLoginBehavior().loginWithGivenUserPass(testData.get("user"), testData.get("pass"));
        assertTrue(behaviorFactory.getInventoryBehavior().isInventoryPageVisible());
    }

}
