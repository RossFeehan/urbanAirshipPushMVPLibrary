package ross.feehan.com.urbanairshippushlibrary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import ross.feehan.com.urbanairshippushlibrary.RegisterForPush.RegisterForPush;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.toolbar) Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setupUI();
        registerForPush();
    }

    private void setupUI() {
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupToolbar();
    }

    private void setupToolbar() {
        setSupportActionBar(toolbar);
    }

    private void registerForPush() {
        RegisterForPush registerForPush = new RegisterForPush(getApplication());
        registerForPush.registerForPushNotifications();
    }
}