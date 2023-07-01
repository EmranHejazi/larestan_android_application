package app.uni.lar.data.categoryItems;

import android.content.Context;

import app.uni.lar.R;
import app.uni.lar.models.Item;

public class ItemsCategory2 {
    public ItemsCategory2(Context context) {
        ItemsCategory2 = new Item[]{
                //TODO("this data is for Bazi haye mahali's items")
                new Item(context.getResources().getString(R.string.category_1_natural_geography), R.drawable.image_lorem, ""),
        };
    }

    private final Item[] ItemsCategory2;

    public Item[] getItemsCategory2() {
        return this.ItemsCategory2;
    }
}
