package ross.feehan.com.urbanairshippushlibrary.HandlePush; /*
 * Created by Ross Feehan on 12/05/2016.
 */

public interface PushNotificationEventHandlerInterface {

    public static final String FIRST_EVENT_ID = "1001";
    public static final String SECOND_EVENT_ID = "1002";

    void handlePushNotificationEventIds(String eventID);
}
