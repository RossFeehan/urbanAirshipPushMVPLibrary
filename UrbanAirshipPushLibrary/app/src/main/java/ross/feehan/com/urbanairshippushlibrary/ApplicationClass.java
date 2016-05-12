package ross.feehan.com.urbanairshippushlibrary; /*
 * Created by Ross Feehan on 12/05/2016.
 */

import android.app.Application;

import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.UAirship;

import java.util.Arrays;
import java.util.List;

import dagger.ObjectGraph;
import ross.feehan.com.urbanairshippushlibrary.HandlePush.HandlePushDIModule;

public class ApplicationClass extends Application{

    private ObjectGraph objectGraph;

    @Override
    public void onCreate() {
        super.onCreate();

        //URBAN AIRSHIP
        setupUrbanAirship();

        //DAGGER
        objectGraph = ObjectGraph.create(getModules().toArray());
        objectGraph.inject(this);

    }

    private List<Object> getModules(){
        return Arrays.<Object>asList(new HandlePushDIModule(this));
    }

    public ObjectGraph getObjectGraph(){
        return objectGraph;
    }

    private void setupUrbanAirship() {

        AirshipConfigOptions options = new AirshipConfigOptions.Builder()
                .setDevelopmentAppKey("8MgHsg5CQWyqJj2DvXnyAw")
                .setDevelopmentAppSecret("MVRCwBRUQ8Gm_4usF-sCZw")
                .setInProduction(BuildConfig.INPRODUCTION)
                .setGcmSender("240158939057")
                .build();
        UAirship.takeOff(this, options);


        /*AirshipConfigOptions uaOptions = new AirshipConfigOptions.Builder()
                .setDevelopmentAppKey("DEV KEY")
                .setDevelopmentAppSecret("DEV SECRET")
                .setProductionAppKey("PROD KEY")
                .setProductionAppSecret("PROD SECRET")
                .setInProduction(BuildConfig.INPRODUCTION)
                .setGcmSender("GCM PROJECT NUMBER")
                .setNotificationIcon(R.drawable.notifications_icon)
                .build();
        UAirship.takeOff(this, uaOptions);*/
    }
}
