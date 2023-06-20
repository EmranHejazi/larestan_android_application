package app.uni.lar.activityes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import app.uni.lar.R;

public class InfoActivity extends AppCompatActivity {

    private ImageView buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        findViews();
        initialize();
    }

    private void findViews() {
        buttonBack = findViewById(R.id.button_back);
    }

    private void initialize() {
        // change the color of status bar
        getWindow().setStatusBarColor(getColor(R.color.primary));
        // event for back button
        buttonBack.setOnClickListener(view -> {
            startActivity(new Intent(InfoActivity.this, MainActivity.class));
            finish();
        });
    }
}