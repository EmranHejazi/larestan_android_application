package app.uni.lar.data.categoryItems;

import android.content.Context;

import app.uni.lar.R;
import app.uni.lar.models.Item;

public class ItemsCategory2 {
    public ItemsCategory2(Context context) {
        ItemsCategory2 = new Item[] {
                new Item(context.getResources().getString(R.string.category_1_natural_geography), R.drawable.ic_earth,""),
                new Item(context.getResources().getString(R.string.category_2_local_games), R.drawable.ic_ball,""),
        };
    }
    private final Item[] ItemsCategory2;
    public Item[] getItemsCategory2() {
        return this.ItemsCategory2;
    }
}
