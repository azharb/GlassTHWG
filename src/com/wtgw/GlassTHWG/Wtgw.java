package com.wtgw.GlassTHWG;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import com.google.android.glass.app.Card;

import java.util.Locale;

public class Wtgw extends Activity implements TextToSpeech.OnInitListener {

    // TTS object
    public TextToSpeech tts;
    private int result = 0;

    @Override
    protected void onDestroy() {
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }

        super.onDestroy();
    }

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        tts = new TextToSpeech(this, this);

        // Create a card with some simple text and a footer.
        Card card1 = new Card(getApplicationContext());
        card1.setText("TO HELL WITH GEORGIA!");
        View card1View = card1.toView();


        setContentView(card1View);


    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            //set Language
            result = tts.setLanguage(Locale.US);
            // tts.setPitch(5); // set pitch level
            // tts.setSpeechRate(2); // set speech speed rate
            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
            } else {
                sayTHWG();
            }
        } else {
            Log.e("TTS", "Initilization Failed");
        }
    }

    private void sayTHWG()
    {
        String text = getResources().getString(R.string.thwg);
        if(result!=tts.setLanguage(Locale.US))
        {

        }else
        {
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
        }
    }
}
