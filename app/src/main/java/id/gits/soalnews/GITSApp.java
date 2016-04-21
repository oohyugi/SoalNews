package id.gits.soalnews;

import android.app.Application;

import com.google.gson.Gson;

/**
 * Created by gitsindonesia on 4/18/16.
 */
public class GITSApp extends Application {

    public static Gson gson = new Gson();

    @Override
    public void onCreate() {
        super.onCreate();

    }
}

