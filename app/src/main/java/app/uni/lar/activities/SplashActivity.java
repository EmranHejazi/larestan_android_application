package app.uni.lar.activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import app.uni.lar.R;
import app.uni.lar.utils.DarkModeChecker;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        setDelay();
        setFullscreen();
        setStatusBarIcons();
    }

    // make fake delay for show logo

    private void setDelay() {
        final int splashTimeOut = 1500;
        Thread splashThread = new Thread() {
            int wait = 0;

            @Override
            public void run() {
                try {
                    super.run();
                    while (wait < splashTimeOut) {
                        sleep(100);
                        wait += 100;
                    }
                } catch (Exception ignored) {
                } finally {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();
                }
            }
        };
        splashThread.start();
    }

    private void setStatusBarIcons() {
        // set icons color of Status Bar
        if (DarkModeChecker.isDarkModeOff(this)) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }    }

    private void setFullscreen() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow(); // in Activity's onCreate() for instance
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
    }

}