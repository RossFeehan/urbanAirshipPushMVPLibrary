package ross.feehan.com.urbanairshippushlibrary.HandlePush; /*
 * Created by Ross Feehan on 12/05/2016.
 */

import android.content.Context;
import android.support.annotation.NonNull;

import com.urbanairship.AirshipReceiver;

import javax.inject.Inject;

import ross.feehan.com.urbanairshippushlibrary.ApplicationClass;

public class PushNotificationReceiver extends AirshipReceiver{

    /**
     * DONT FORGET TO REGISTER THIS CLASS AS A RECEIVER IN MANIFEST
     */

    @Inject PushNotificationEventHandlerInterface pushNotificationRouter;

    @Override
    protected boolean onNotificationOpened(@NonNull Context context, @NonNull NotificationInfo notificationInfo) {

        ((ApplicationClass) context.getApplicationContext()).getObjectGraph().inject(this);

        String eventID = (String)notificationInfo.getMessage().getPushBundle().get("event_id");

        pushNotificationRouter.handlePushNotificationEventIds(eventID);

        // Return true here so Urban Airship does not auto launch the launcher activity, we handle what activity to launch based on eventID.
        return true;
    }
}
