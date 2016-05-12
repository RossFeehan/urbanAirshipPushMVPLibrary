package ross.feehan.com.urbanairshippushlibrary.HandlePush; /*
 * Created by Ross Feehan on 12/05/2016.
 */

import android.content.Context;
import android.content.Intent;

import ross.feehan.com.urbanairshippushlibrary.FirstEventActivity;
import ross.feehan.com.urbanairshippushlibrary.MainActivity;
import ross.feehan.com.urbanairshippushlibrary.SecondEventActivity;

public class PushNotificationActivityRouterImpl implements PushNotificationActivityRouterInterface{

    private Context ctx;

    //CONSTRUCTOR
    public PushNotificationActivityRouterImpl(Context ctx){
        this.ctx = ctx;
    }

    @Override
    public void openDefaultActivity() {
        Intent defaultIntent = new Intent(ctx, MainActivity.class);
        defaultIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        ctx.startActivity(defaultIntent);
    }

    @Override
    public void openFirstEventActivity() {
        Intent firstEventIntent = new Intent(ctx, FirstEventActivity.class);
        firstEventIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        ctx.startActivity(firstEventIntent);
    }

    @Override
    public void openSecondEventActivity() {
        Intent secondEventIntent = new Intent(ctx, SecondEventActivity.class);
        secondEventIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        ctx.startActivity(secondEventIntent);
    }
}