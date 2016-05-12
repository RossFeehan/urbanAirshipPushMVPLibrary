package ross.feehan.com.urbanairshippushlibrary; /*
 * Created by Ross Feehan on 12/05/2016.
 */

/**
 * Runs all unit tests in the project
 */

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import ross.feehan.com.urbanairshippushlibrary.HandlePush.PushNotificationEventHandlerImplTest;

@RunWith(Suite.class)
@Suite.SuiteClasses ({
        PushNotificationEventHandlerImplTest.class
})
public class AllUnitTests {
}
