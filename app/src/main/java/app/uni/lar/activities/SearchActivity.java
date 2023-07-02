package app.uni.lar.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.MaterialAutoCompleteTextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import app.uni.lar.R;
import app.uni.lar.adapters.SearchAdapter;
import app.uni.lar.data.categoryItems.ItemsCategory1;
import app.uni.lar.data.categoryItems.ItemsCategory2;
import app.uni.lar.data.categoryItems.ItemsCategory3;
import app.uni.lar.data.categoryItems.ItemsCategory4;
import app.uni.lar.data.categoryItems.ItemsCategory5;
import app.uni.lar.data.categoryItems.ItemsCategory6;
import app.uni.lar.models.Item;


public class SearchActivity extends AppCompatActivity {

    private ImageView buttonBack;
    private List<String> originalList;
    private List<String> filteredList;
    private RecyclerView recyclerView;
    private MaterialAutoCompleteTextView searchEditText;
    private SearchAdapter adapter;
    private ArrayList<Item> itemsList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initialize();
    }

    private void initialize() {
        findViews();
        // event for back button
        buttonBack.setOnClickListener(view -> {
            startActivity(new Intent(SearchActivity.this, MainActivity.class));
            finish();
        });
        // set status bar color
        getWindow().setStatusBarColor(getResources().getColor(R.color.primary));
        loadSearch();
    }

    private void findViews() {
        buttonBack = findViewById(R.id.button_back);
        searchEditText = findViewById(R.id.input_search);
    }


    private void loadSearch() {
        // get all data
        itemsList = new ArrayList<>();
        ItemsCategory1 category1 = new ItemsCategory1(this);
        ItemsCategory2 category2 = new ItemsCategory2(this);
        ItemsCategory3 category3 = new ItemsCategory3(this);
        ItemsCategory4 category4 = new ItemsCategory4(this);
        ItemsCategory5 category5 = new ItemsCategory5(this);
        ItemsCategory6 category6 = new ItemsCategory6(this);
        // push all data to once list
        itemsList.addAll(Arrays.asList(category1.getItemsCategory1()));
        itemsList.addAll(Arrays.asList(category2.getItemsCategory2()));
        itemsList.addAll(Arrays.asList(category3.getItemsCategory3()));
        itemsList.addAll(Arrays.asList(category4.getItemsCategory4()));
        itemsList.addAll(Arrays.asList(category5.getItemsCategory5()));
        itemsList.addAll(Arrays.asList(category6.getItemsCategory6()));

        // set list adapter
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list_search);
        SearchAdapter adapter = new SearchAdapter(itemsList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(adapter);
        // set data
        searchEditText.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String searchText = charSequence.toString();
                List<Item> filteredList = new ArrayList<>();

                for (Item item : itemsList) {
                    if (item.getTitle().contains(searchText)) {
                        filteredList.add(item);
                    }
                }

                adapter.setItems(filteredList);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


    }


}