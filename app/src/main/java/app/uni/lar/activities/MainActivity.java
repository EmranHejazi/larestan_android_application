package app.uni.lar.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;

import app.uni.lar.R;
import app.uni.lar.adapters.CategoriesAdapter;
import app.uni.lar.adapters.SuggestionsAdapter;
import app.uni.lar.data.CategoriesData;
import app.uni.lar.data.SuggestionsData;
import app.uni.lar.utils.ExitDialog;

public class MainActivity extends AppCompatActivity {
    // define global variables for views
    private ImageView buttonMenu;
    private LinearLayout searchContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize() {
        setFullscreen();
        setSuggestionsAdapter();
        setCategoriesAdapter();
        findViews();
        buttonMenu.setOnClickListener(v -> eventMenuClick()); // popup the menu
        searchContainer.setOnClickListener(v -> eventSearchClick());
    }

    private void findViews() {
        buttonMenu = findViewById(R.id.button_menu);
        searchContainer = findViewById(R.id.search_container);
    }

    // set lists adapter
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void setSuggestionsAdapter() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list_suggestions);
        SuggestionsAdapter adapter = new SuggestionsAdapter(new SuggestionsData().getSuggestionsData());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(adapter);
    }

    private void setCategoriesAdapter() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list_categories);
        CategoriesAdapter adapter = new CategoriesAdapter(new CategoriesData(MainActivity.this).getCategoriesData());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView.setAdapter(adapter);
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////


    // until
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void eventSearchClick() {
        startActivity(new Intent(MainActivity.this, SearchActivity.class));
    }

    private void eventMenuClick() {
        PopupMenu popupMenu = new PopupMenu(this, buttonMenu);
        MenuInflater inflater = popupMenu.getMenuInflater();
        inflater.inflate(R.menu.menu_main, popupMenu.getMenu());
        popupMenu.show();
    }

    // open the Exit dialog when BackPressed
    @Override
    public void onBackPressed() {
        ExitDialog.show(MainActivity.this);
    }

    // hide the Status Bar
    private void setFullscreen() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////


    // menu items click events
    // when a item of menu is clicked, are functions is call automatically because it's define in menu.xml
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
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
    /////////////////////////////////////////////////////////////////////////////////////////////////////////

}