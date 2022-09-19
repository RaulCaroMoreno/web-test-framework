package cases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import core.TestBase;
import org.junit.jupiter.api.Test;


public class CheckInventoryItems extends TestBase {

    @Test
    public void testCheckInventoryItems() {
        behaviorFactory.getLoginBehavior().loginWithGivenUserPass(testData.get("user"), testData.get("pass"));
        assertTrue(behaviorFactory.getInventoryBehavior().isInventoryPageVisible());
        assertEquals(behaviorFactory.getInventoryBehavior().getNumberOfItems(),
                Integer.valueOf(testData.get("itemSize")));
    }

}