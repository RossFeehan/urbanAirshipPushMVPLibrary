package ross.feehan.com.urbanairshippushlibrary.HandlePush;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

/*
* Created by Ross Feehan on 12/05/2016.
*/

/**
 * Single Responsibility:
 *
 * Tests for Single Contractor {@link PushNotificationEventHandlerImpl}
 */

@RunWith(MockitoJUnitRunner.class)
public class PushNotificationEventHandlerImplTest {

    PushNotificationEventHandlerImpl eventHandler;
    @Mock PushNotificationActivityRouterInterface pushNotificationActivityRouter;

    private static final String UNKNOWN_PUSH_EVENT = "2001";

    @Before
    public void setup(){
        eventHandler = new PushNotificationEventHandlerImpl(pushNotificationActivityRouter);
        MockResponses();
    }

    private void MockResponses() {

    }

    //SCENARIO -- PUSH NOTIFICATION WITH EVENT ID 1001 IS RECEIVED
    @Test
    public void when_pushNotificationWithEvent_FirstEvent_then_openUpcomingJobActivity(){
        //WHEN
        eventHandler.handlePushNotificationEventIds(PushNotificationEventHandlerInterface.FIRST_EVENT_ID);
        //THEN
        verify(pushNotificationActivityRouter).openFirstEventActivity();
    }

    //SCENARIO -- PUSH NOTIFICATION WITH EVENT ID 1002 IS RECEIVED
    @Test
    public void when_pushNotificationWithEvent_secondEvent_then_openCreateNewJobActivity(){
        //WHEN
        eventHandler.handlePushNotificationEventIds(PushNotificationEventHandlerInterface.SECOND_EVENT_ID);
        //THEN
        verify(pushNotificationActivityRouter).openSecondEventActivity();
    }

    //SCENARIO -- PUSH NOTIFICATION WITH UNKNOWN EVENT ID IS RECEIVED
    @Test
    public void when_pushNotificationWithUnknownEvent_then_openJobListsActivity(){
        //WHEN
        eventHandler.handlePushNotificationEventIds(UNKNOWN_PUSH_EVENT);
        //THEN
        verify(pushNotificationActivityRouter).openDefaultActivity();
    }

    //SCENARIO -- PUSH NOTIFICATION EVENT ID IS NULL
    @Test
    public void when_pushNotificationWithNullEventID_then_openJobListsActivity(){
        //WHEN
        eventHandler.handlePushNotificationEventIds(null);
        //THEN
        verify(pushNotificationActivityRouter).openDefaultActivity();
    }

}