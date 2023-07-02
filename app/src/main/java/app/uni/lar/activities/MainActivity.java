package app.uni.lar.activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import app.uni.lar.R;
import app.uni.lar.adapters.CategoriesAdapter;
import app.uni.lar.adapters.SuggestionsAdapter;
import app.uni.lar.data.CategoriesData;
import app.uni.lar.data.SuggestionsData;
import app.uni.lar.utils.DarkModeChecker;
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
        // set icons color of Status Bar
        if (DarkModeChecker.isDarkModeOff(this)) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
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
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////


    // until
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void eventSearchClick() {
        startActivity(new Intent(MainActivity.this, SearchActivity.class));
    }

    private void setFullscreen() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow(); // in Activity's onCreate() for instance
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
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