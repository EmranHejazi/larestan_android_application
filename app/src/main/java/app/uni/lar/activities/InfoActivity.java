package app.uni.lar.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import app.uni.lar.R;

public class InfoActivity extends AppCompatActivity {
    // define global variables for views
    private ImageView buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        initialize();
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
    }
}