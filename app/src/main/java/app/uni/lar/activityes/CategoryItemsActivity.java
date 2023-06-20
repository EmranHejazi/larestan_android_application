package app.uni.lar.activityes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

import app.uni.lar.R;

public class CategoryItemsActivity extends AppCompatActivity {
    private TextView title;
    private ImageView buttonBack;

    private ListView categoryItemsList;

    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_items);
        findViews();
        setTitle();
        initialize();
        setContent();
    }

    private void findViews() {
        title = findViewById(R.id.text_title);
        buttonBack = findViewById(R.id.button_back);
        categoryItemsList = findViewById(R.id.category_items_list);
    }

    private void initialize() {
        getWindow().setStatusBarColor(getColor(R.color.primary));
        buttonBack.setOnClickListener(v -> {
            startActivity(new Intent(CategoryItemsActivity.this, MainActivity.class));
            finish();
        });
    }

    private void setTitle() {
        String titleText = getIntent().getStringExtra("title");
        title.setText(titleText);
    }

    private void setContent() {
        Intent intent = getIntent();
        String category = intent.getStringExtra("category");
        Toast.makeText(this, category, Toast.LENGTH_SHORT).show();

        switch (category) {
            case "1":
                setAdapter(new String[]{"I", "CV"});
                break;
            case "2":
                setAdapter(new String[]{"II", "CV"});
                break;
            case "3":
                setAdapter(new String[]{"III", "CV"});
                break;
            case "4":
                setAdapter(new String[]{"I", "CV"});
                break;
            case "5":
                setAdapter(new String[]{"I", "CV"});
                break;
            case "6":
                setAdapter(new String[]{"I", "CV"});
                break;
        }
    }
    private void setAdapter(String[] items) {
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        categoryItemsList.setAdapter(adapter);
    }

}