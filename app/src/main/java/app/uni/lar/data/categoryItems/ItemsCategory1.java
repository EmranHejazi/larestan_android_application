package app.uni.lar.data.categoryItems;

import android.content.Context;

import app.uni.lar.R;
import app.uni.lar.models.Item;

public class ItemsCategory1 {
    public ItemsCategory1(Context context) {
        ItemsCategory1 = new Item[]{
                //TODO("this data is for Jorrafia tabiei's items")
                new Item(context.getResources().getString(R.string.category_1_natural_geography), R.drawable.image_lorem, "ITEM1"),
        };
    }

    private final Item[] ItemsCategory1;

    public Item[] getItemsCategory1() {
        return this.ItemsCategory1;
    }
}
