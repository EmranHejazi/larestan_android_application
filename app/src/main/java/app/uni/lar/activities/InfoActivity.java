package app.uni.lar.activities;

import android.content.Intent;
import android.os.Bundle;
//import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
//import android.widget.TextView;
//import android.widget.VideoView;


import androidx.appcompat.app.AppCompatActivity;

import app.uni.lar.R;

public class InfoActivity extends AppCompatActivity {
    // define global variables for views
    private ImageView buttonBack;
//    private VideoView videoView;
    private SeekBar seekBarZoom;
//    private TextView textContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        initialize();

//        videoView = findViewById(R.id.videoView);
//        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.lar;
//        videoView.setVideoPath(videoPath);
//        videoView.start();
//    }
//
//    public void onButtonClick(View view) {
//        videoView.pause();
    }


    private void initialize() {
        findViews();
        // change the color of status bar
        getWindow().setStatusBarColor(getColor(R.color.primary));
        // event for back button
        buttonBack.setOnClickListener(view -> {
            startActivity(new Intent(InfoActivity.this, MainActivity.class));
            finish();
        });
    }

    private void findViews() {
        buttonBack = findViewById(R.id.button_back);
//        textContent = findViewById(R.id.text_content);
//        seekBarZoom = findViewById(R.id.seekBarZoom);
    }

//    private void eventZoomAction() {
//        seekBarZoom.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            @Override
//            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//                textContent.setTextSize(progress);
//            }
//
//            @Override
//            public void onStartTrackingTouch(SeekBar seekBar) {
//                // Not needed for this example
//            }
//
//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) {
//                // Not needed for this example
//            }
//        });
//
//
//    }


}