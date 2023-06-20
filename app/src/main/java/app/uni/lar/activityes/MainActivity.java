package app.uni.lar.activityes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;

import app.uni.lar.R;
import app.uni.lar.utils.ExitDialog;

public class MainActivity extends AppCompatActivity {

    private ImageView buttonMenu;
    private LinearLayout searchContainer;
    private PopupMenu popupMenu;
    private LinearLayout category1NaturalGeography;
    private LinearLayout category2LocalGames;
    private LinearLayout category3AncientPlaces;
    private LinearLayout category4EconomicView;
    private LinearLayout category5Proverbs;
    private LinearLayout category6Foods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        initialize();
    }

    private void findViews() {
        buttonMenu = findViewById(R.id.button_menu);
        searchContainer = findViewById(R.id.search_container);
        category1NaturalGeography = findViewById(R.id.category_1_natural_geography);
        category2LocalGames = findViewById(R.id.category_2_local_games);
        category3AncientPlaces = findViewById(R.id.category_3_ancient_places);
        category4EconomicView = findViewById(R.id.category_4_economic_view);
        category5Proverbs = findViewById(R.id.category_5_proverbs);
        category6Foods = findViewById(R.id.category_6_foods);
    }

    private void initialize() {
        buttonMenu.setOnClickListener(v -> eventMenuClick()); // popup the menu
        searchContainer.setOnClickListener(v -> eventSearchClick());
        category1NaturalGeography.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CategoryItemsActivity.class);
            intent.putExtra("title", getString(R.string.category_1_natural_geography));
            intent.putExtra("category", "1");
            startActivity(intent);
            finish();
        });
        category2LocalGames.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CategoryItemsActivity.class);
            intent.putExtra("title", getString(R.string.category_2_local_games));
            intent.putExtra("category", "2");
            startActivity(intent);
            finish();
        });
        category3AncientPlaces.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CategoryItemsActivity.class);
            intent.putExtra("title", getString(R.string.category_3_ancient_places));
            intent.putExtra("category", "3");
            startActivity(intent);
            finish();
        });
        category4EconomicView.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CategoryItemsActivity.class);
            intent.putExtra("title", getString(R.string.category_4_economic_view));
            intent.putExtra("category", "4");
            startActivity(intent);
            finish();
        });
        category5Proverbs.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CategoryItemsActivity.class);
            intent.putExtra("title", getString(R.string.category_5_proverbs));
            intent.putExtra("category", "5");
            startActivity(intent);
            finish();
        });
        category6Foods.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CategoryItemsActivity.class);
            intent.putExtra("title", getString(R.string.category_6_foods));
            intent.putExtra("category", "6");
            startActivity(intent);
            finish();
        });


    }

    private void eventSearchClick() {
        startActivity(new Intent(MainActivity.this, SearchActivity.class));
    }

    private void eventMenuClick() {
        popupMenu = new PopupMenu(this, buttonMenu);
        MenuInflater inflater = popupMenu.getMenuInflater();
        inflater.inflate(R.menu.menu_main, popupMenu.getMenu());
        popupMenu.show();
    }

    // menu items click events
    public void eventMenuItemClickMoreInformation(MenuItem item) {
        startActivity(new Intent(MainActivity.this, InfoActivity.class));
        finish();
    }

    public void eventMenuItemClickExit(MenuItem item) {
        // Create a button to show the dialog
        ExitDialog.show(MainActivity.this);
    }

    public void eventMenuItemClickShare(MenuItem item) {
        // open android share intent
        String link = "http://dushusir.com/fake/win10ue/win10ue.html";
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, link);
        startActivity(Intent.createChooser(shareIntent, "Share link"));
    }

    @Override
    public void onBackPressed() {
        ExitDialog.show(MainActivity.this);
    }
}