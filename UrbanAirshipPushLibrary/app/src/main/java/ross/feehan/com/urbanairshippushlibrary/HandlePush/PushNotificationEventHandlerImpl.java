package ross.feehan.com.urbanairshippushlibrary.HandlePush; /*
 * Created by Ross Feehan on 12/05/2016.
 */

public class PushNotificationEventHandlerImpl implements PushNotificationEventHandlerInterface{

    private PushNotificationActivityRouterInterface pushNotificationActivityRouter;

    public PushNotificationEventHandlerImpl(PushNotificationActivityRouterInterface pushNotificationActivityRouter){
        this.pushNotificationActivityRouter = pushNotificationActivityRouter;
    }

    @Override
    public void handlePushNotificationEventIds(String eventID) {
        if(eventID != null){
            switch(eventID){
                case FIRST_EVENT_ID:
                    pushNotificationActivityRouter.openFirstEventActivity();
                    break;
                case SECOND_EVENT_ID:
                    pushNotificationActivityRouter.openSecondEventActivity();
                    break;
                default:
                    pushNotificationActivityRouter.openDefaultActivity();
                    break;
            }
        }
        else{
            pushNotificationActivityRouter.openDefaultActivity();
        }
    }
}