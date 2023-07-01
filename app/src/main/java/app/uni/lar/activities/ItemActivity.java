package app.uni.lar.activities;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import app.uni.lar.R;

public class ItemActivity extends AppCompatActivity {

    private ImageView buttonBack;
    private TextView textTitle;
    private TextView titleItem;
    private TextView textContent;
    private ImageView imageItem;
    private ImageView buttonZoomIn;
    private ImageView buttonZoomOut;
    private SeekBar seekBarZoom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        initialize();
    }

    private void initialize() {
        findViews();
        eventZoomAction();
        loadData();
        // event for back button
        buttonBack.setOnClickListener(v -> {
            finish();
        });
        // set the Status bar color
        getWindow().setStatusBarColor(getColor(R.color.primary));


    }

    private void findViews() {
        textTitle = findViewById(R.id.text_title);
        buttonBack = findViewById(R.id.button_back);
        titleItem = findViewById(R.id.title_item);
        imageItem = findViewById(R.id.image_item);
        textContent = findViewById(R.id.text_content);
        seekBarZoom = findViewById(R.id.seekBarZoom);


    }

    private void loadData() {
        // get data
        String itemName = getIntent().getStringExtra("item_name");
        int itemImageID = getIntent().getIntExtra("item_imageID", 0);
        String itemContent = getIntent().getStringExtra("item_content");
        String categoryTitle = getIntent().getStringExtra("category_title");
        // set titles
        textTitle.setText(categoryTitle);
        titleItem.setText(itemName);
        // set content
        textContent.setText(itemContent);
        textContent.setTextSize(seekBarZoom.getProgress());
        // set images
        imageItem.setImageResource(itemImageID);
    }

    private void eventZoomAction() {
        seekBarZoom.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int fontSize = progress;
                textContent.setTextSize(fontSize);
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