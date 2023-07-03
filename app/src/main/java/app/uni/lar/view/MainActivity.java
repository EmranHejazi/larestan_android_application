package app.uni.lar.view;

import android.content.Intent;
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
    private View menuContainer;

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
        menuContainer = findViewById(R.id.menu_container);
    }

    // set lists adapter
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void setSuggestionsAdapter() {
        RecyclerView recyclerView = findViewById(R.id.list_suggestions);
        SuggestionsAdapter adapter = new SuggestionsAdapter(new SuggestionsData().getSuggestionsData());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(adapter);
    }

    private void setCategoriesAdapter() {
        RecyclerView recyclerView = findViewById(R.id.list_categories);
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
        Window w = getWindow(); // in Activity's onCreate() for instance
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    }

    private void eventMenuClick() {
        PopupMenu popupMenu = new PopupMenu(this, menuContainer);
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
        Intent shareIntent = new Intent(android.content.Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Insert Subject here");
        String app_url = "https://fakeupdate.net/win10ue/";
        shareIntent.putExtra(android.content.Intent.EXTRA_TEXT, app_url);
        startActivity(Intent.createChooser(shareIntent, "Share via"));
    }

    /* public void eventMenuItemClickShare(MenuItem item) {
        // Get the file path of the app file.
        String filePath = "Lar.app.main.apk";

        // Create an Intent with the ACTION_SEND action.
        Intent share = new Intent(Intent.ACTION_SEND);
        share.setAction(Intent.ACTION_SEND);

        // Set the type of the file to be shared.
        share.setType("application/vnd.android.package-archive");

        // Create a content URI for the file.
        Uri contentUri = Uri.fromFile(new File(filePath));

        // Put the content URI in the Intent.
        share.putExtra(Intent.EXTRA_STREAM, contentUri);

        // Start the Intent.
        startActivity(Intent.createChooser(share, "به اشتراک گذاری اپلیکیشن"));
    } */

    /////////////////////////////////////////////////////////////////////////////////////////////////////////


}