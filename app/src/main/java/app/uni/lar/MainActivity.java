package app.uni.lar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;

public class MainActivity extends AppCompatActivity {

    private ImageView buttonMenu;
    private LinearLayout searchContainer;
    private PopupMenu popupMenu;

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
    }

    private void initialize() {
        buttonMenu.setOnClickListener(v -> eventMenuClick()); // popup the menu
        searchContainer.setOnClickListener(v -> eventSearchClick());
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
        finish(); // finish activity
    }

    public void eventMenuItemClickShare(MenuItem item) {
        // open android share intent
        String link = "http://dushusir.com/fake/win10ue/win10ue.html";
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, link);
        startActivity(Intent.createChooser(shareIntent, "Share link"));
    }

}