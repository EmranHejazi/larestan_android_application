package app.uni.lar.data.categoryItems;

import android.content.Context;

import app.uni.lar.R;
import app.uni.lar.models.Item;

public class ItemsCategory3 {
    public ItemsCategory3(Context context) {
        ItemsCategory2 = new Item[]{
                //TODO("this data is for Amaken bastani's items")
                new Item(context.getResources().getString(R.string.category_5_proverbs), R.drawable.image_lorem, "")
        };
    }

    private final Item[] ItemsCategory2;

    public Item[] getItemsCategory3() {
        return this.ItemsCategory2;
    }
}
