package app.uni.lar;

import androidx.annotation.NonNull;
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
        buttonMenu.setOnClickListener(v -> eventMenuClick());
    }

    private void eventMenuClick() {
        popupMenu = new PopupMenu(this, buttonMenu);
        MenuInflater inflater = popupMenu.getMenuInflater();
        inflater.inflate(R.menu.menu_main, popupMenu.getMenu());
        popupMenu.show();
    }

    // menu items click events
    public void eventMenuItemClickMoreInformation(MenuItem item) {
        //TODO("open information activity")
    }

    public void eventMenuItemClickExit(MenuItem item) {
        finish();
    }

    public void eventMenuItemClickShare(MenuItem item) {
        // Get the link to share
        String link = "https://www.google.com";

        // Create an intent to share the link
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, link);
        startActivity(Intent.createChooser(shareIntent, "Share link"));
    }

}