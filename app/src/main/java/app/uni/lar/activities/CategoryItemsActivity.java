package app.uni.lar.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;

import app.uni.lar.R;
import app.uni.lar.adapters.CategoryItemsAdapter;
import app.uni.lar.data.categoryItems.ItemsCategory1;
import app.uni.lar.data.categoryItems.ItemsCategory2;
import app.uni.lar.data.categoryItems.ItemsCategory3;
import app.uni.lar.data.categoryItems.ItemsCategory4;
import app.uni.lar.data.categoryItems.ItemsCategory5;
import app.uni.lar.data.categoryItems.ItemsCategory6;
import app.uni.lar.models.Item;

public class CategoryItemsActivity extends AppCompatActivity {
    // define global variables for views
    private TextView textTitle;
    private ImageView buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_items);
        initialize();
    }

    private void initialize() {
        findViews();
        // change the color of status bar
        getWindow().setStatusBarColor(getColor(R.color.primary));
        // event for back button
        buttonBack.setOnClickListener(view -> {
            startActivity(new Intent(CategoryItemsActivity.this, MainActivity.class));
            finish();
        });
        String category = getIntent().getStringExtra("category_name");
        // set title
        textTitle.setText(category);
        // set adapter
        String category1 = getString(R.string.category_1_natural_geography);
        String category2 = getString(R.string.category_2_local_games);
        String category3 = getString(R.string.category_3_ancient_places);
        String category4 = getString(R.string.category_4_economic_view);
        String category5 = getString(R.string.category_5_proverbs);
        String category6 = getString(R.string.category_6_foods);

        // give adapter "new CategoryItemsData(CategoryItemsActivity.this).getCategoryItemsData()"
        assert category != null;
        if (category.equals(category1)) setCategoryItemsAdapter(new ItemsCategory1(CategoryItemsActivity.this).getItemsCategory1());
        if (category.equals(category2)) setCategoryItemsAdapter(new ItemsCategory2(CategoryItemsActivity.this).getItemsCategory2());
        if (category.equals(category3)) setCategoryItemsAdapter(new ItemsCategory3(CategoryItemsActivity.this).getItemsCategory3());
        if (category.equals(category4)) setCategoryItemsAdapter(new ItemsCategory4(CategoryItemsActivity.this).getItemsCategory4());
        if (category.equals(category5)) setCategoryItemsAdapter(new ItemsCategory5(CategoryItemsActivity.this).getItemsCategory5());
        if (category.equals(category6)) setCategoryItemsAdapter(new ItemsCategory6(CategoryItemsActivity.this).getItemsCategory6());
    }

    private String getCategory(String title) {
        return title;
    }

    private void findViews() {
        textTitle = findViewById(R.id.text_title);
        buttonBack = findViewById(R.id.button_back);
    }

    private void setCategoryItemsAdapter(Item[] data) {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list_category_items);
        CategoryItemsAdapter adapter = new CategoryItemsAdapter(data);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(adapter);
    }
}