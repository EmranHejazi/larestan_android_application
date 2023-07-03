package app.uni.lar.activities;

import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

import app.uni.lar.R;

public class InfoActivity extends AppCompatActivity {
    // define global variables for views
    private ImageView buttonBack;
    private SeekBar seekBarZoom;
    private TextView textContent;
    private ImageView buttonPlay;
    private ImageView buttonPause;
    private MediaPlayer mMediaPlayer;
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        try {
            initialize();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private void initialize() throws IOException {
        findViews();
        eventZoomAction();
        // change the color of status bar
        getWindow().setStatusBarColor(getColor(R.color.primary));
        // event for back button
        buttonBack.setOnClickListener(view -> {
            startActivity(new Intent(InfoActivity.this, MainActivity.class));
            finish();
        });
        loadSound();
        loadVideo();
    }

    private void findViews() {
        buttonBack = findViewById(R.id.button_back);
        textContent = findViewById(R.id.text_content);
        seekBarZoom = findViewById(R.id.seekBarZoom);
        buttonPlay = findViewById(R.id.button_play);
        buttonPause = findViewById(R.id.button_pause);
        videoView = findViewById(R.id.video_view);
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

    private void loadSound() throws IOException {
        // Get the raw resource ID of the sound file
        Resources resources = getResources();
        int soundId = resources.getIdentifier("sorod", "raw", getPackageName());

        // Convert the raw resource ID to a Uri object
        Uri soundUri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://" + getPackageName() + "/" + soundId);

        // Create a MediaPlayer object
        mMediaPlayer = new MediaPlayer();

        // Set the data source to the sound file
        mMediaPlayer.setDataSource(this, soundUri);

        // Prepare the MediaPlayer
        mMediaPlayer.prepare();
        buttonPlay.setOnClickListener(v -> {
            mMediaPlayer.start();
        });

        buttonPause.setOnClickListener(v -> {
            mMediaPlayer.stop();
        });
    }

    private void loadVideo() {
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.video_info;
        Uri videoUri = Uri.parse(videoPath);
        videoView.setVideoURI(videoUri);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.start();

    }

}