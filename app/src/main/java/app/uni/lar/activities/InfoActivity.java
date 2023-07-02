package app.uni.lar.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import java.net.URI;
import java.net.URL;

import app.uni.lar.R;

public class InfoActivity extends AppCompatActivity {
    // define global variables for views
    private ImageView buttonBack;
    private SeekBar seekBarZoom;
    private TextView textContent;
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        initialize();
    }


    private void initialize() {
        findViews();
        loadVideo();
        eventZoomAction();
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
        textContent = findViewById(R.id.text_content);
        seekBarZoom = findViewById(R.id.seekBarZoom);
        videoView = findViewById(R.id.video_view);
    }

    private void loadVideo() {
        // Get the URL of the video to play
        String videoURL = "https://aspb24.asset.aparat.com/aparat-video/8217bae6ed8ec502f36f018e4ca1f62831072065-144p.mp4?wmsAuthSign=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0b2tlbiI6IjM0MWY3YWU5ZTRkNDBiYTE0NjJlNzg1OTVmMmY5NWM5IiwiZXhwIjoxNjg4MzIwNDA0LCJpc3MiOiJTYWJhIElkZWEgR1NJRyJ9.jMF_8xZMCD4on-0Ehfd8iJetYeYBFqXc31Obek_ChgI";

        // Create a Uri object from the URL
        Uri uri = Uri.parse(videoURL);

        // Set the video URI on the VideoView
        videoView.setVideoURI(uri);

        // Create a MediaController object
        MediaController mediaController = new MediaController(this);

        // Attach the MediaController to the VideoView
        videoView.setMediaController(mediaController);

        // Start playing the video
        videoView.start();
    }

    private void eventZoomAction() {
        seekBarZoom.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textContent.setTextSize(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Not needed for this example
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Not needed for this example
            }
        });


    }


}