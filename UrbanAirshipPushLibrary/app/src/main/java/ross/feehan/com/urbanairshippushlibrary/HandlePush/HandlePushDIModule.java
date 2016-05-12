package ross.feehan.com.urbanairshippushlibrary.HandlePush; /*
 * Created by Ross Feehan on 12/05/2016.
 */

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ross.feehan.com.urbanairshippushlibrary.ApplicationClass;

@Module (injects = {ApplicationClass.class,PushNotificationReceiver.class})
public class HandlePushDIModule {

    private Context ctx;

    public HandlePushDIModule(Context ctx){
        this.ctx = ctx;
    }

    @Provides @Singleton
    public PushNotificationActivityRouterInterface providePushNotificationActivityRouterInterface(){
        return new PushNotificationActivityRouterImpl(ctx);
    }

    @Provides @Singleton
    public PushNotificationEventHandlerInterface providePushNotificationEventHandlerInterface(PushNotificationActivityRouterInterface pushNotificationActivityRouter){
        return new PushNotificationEventHandlerImpl(pushNotificationActivityRouter);
    }
}