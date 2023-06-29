package app.uni.lar.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import app.uni.lar.R;

public class ItemActivity extends AppCompatActivity {

    ImageView buttonBack;
    TextView textTitle;
    ImageView imageItem;
    TextView titleItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        initialize();
    }

    private void initialize() {
        findViews();
        // event for back button
        buttonBack.setOnClickListener(v -> {
            finish();
        });
        // set the Status bar color
        getWindow().setStatusBarColor(getColor(R.color.primary));
        // get data
        String itemName = getIntent().getStringExtra("item_name");
        String itemImageID = getIntent().getStringExtra("item_imageID");
        String itemContent = getIntent().getStringExtra("item_content");
        String categoryTitle = getIntent().getStringExtra("category_title");
        // set title
        textTitle.setText(categoryTitle);
        titleItem.setText(itemName);
    }

    private void findViews() {
        textTitle = findViewById(R.id.text_title);
        buttonBack = findViewById(R.id.button_back);
        titleItem = findViewById(R.id.title_item);
        imageItem = findViewById(R.id.image_item);
    }
}