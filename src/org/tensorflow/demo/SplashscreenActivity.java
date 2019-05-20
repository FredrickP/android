package org.tensorflow.demo;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;


public class SplashscreenActivity extends AppCompatActivity {

    TextView teks,teks2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splashscreen);

        teks=(TextView)findViewById(R.id.font);
        Typeface customfont= Typeface.createFromAsset(getAssets(),"font/steelfish rounded bd.ttf");
        teks.setTypeface(customfont);

        teks2=(TextView)findViewById(R.id.font);
        Typeface customfont2= Typeface.createFromAsset(getAssets(),"font/PeachesForBreakfast-Regular.otf");
        teks2.setTypeface(customfont);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                final Intent mainIntent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(mainIntent);
                finish();
            }
        }, 3000);

    }
}
