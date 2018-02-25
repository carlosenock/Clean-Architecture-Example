package cleancore.dev.cenock.com.core;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

/**
 * Created by carlosenock on 2/25/18.
 */

public class App extends Application{

    @SuppressLint("StaticFieldLeak")
    private static Context instance;


    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
    }

    public static Context getInstance() {
        return instance;
    }
}
