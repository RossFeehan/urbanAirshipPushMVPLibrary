package ross.feehan.com.urbanairshippushlibrary.RegisterForPush; /*
 * Created by Ross Feehan on 12/05/2016.
 */

import android.content.Context;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.util.Log;

import com.urbanairship.UAirship;

public class RegisterForPush {

    private Context ctx;

    public RegisterForPush(Context context){
        this.ctx = context;
    }

    public void registerForPushNotifications(){
        //SET THE USER TO GET PUSH NOTIFICATIONS BECAUSE THEY ARE DEFINITELY LOGGED IN NOW
        UAirship.shared().getPushManager().setUserNotificationsEnabled(true);
        getDeviceUniqueID();
        String channelID = UAirship.shared().getPushManager().getChannelId();
        Log.i("UAirship Channel", UAirship.shared().getPushManager().getChannelId());
        Log.i("UAirship inProduction", String.valueOf(UAirship.shared().getAirshipConfigOptions().inProduction));
    }

    private void getDeviceUniqueID() {
        String deviceID= Settings.Secure.getString(ctx.getContentResolver(), Settings.Secure.ANDROID_ID);
    }

    public void unregisterForPushNotifications(){
        //STOP THE USER GETTING PUSH NOTIFICATIONS WHEN THEY LOG OUT
        UAirship.shared().getPushManager().setUserNotificationsEnabled(false);
    }
}