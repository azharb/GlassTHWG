package com.wtgw.GlassTHWG;

import android.app.Service;
import android.content.Intent;
import android.content.res.Resources;
import android.os.IBinder;
import android.speech.tts.TextToSpeech;

/**
 * Created with IntelliJ IDEA.
 * User: abandeali
 * Date: 11/30/13
 * Time: 4:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class okglasswtgw extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Intent dialogIntent = new Intent(getBaseContext(), Wtgw.class);
        dialogIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getApplication().startActivity(dialogIntent);

        return super.onStartCommand(intent, flags, startId);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public IBinder onBind(Intent intent) {
        return null;
    }
}
