package app.uni.lar.data.categoryItems;

import android.content.Context;

import app.uni.lar.R;
import app.uni.lar.models.Item;

public class ItemsCategory5 {
    public ItemsCategory5(Context context) {
        ItemsCategory5 = new Item[] {
                //TODO("this data is for Zarb al masal ha's items")
                new Item(context.getResources().getString(R.string.category_5_proverbs), R.drawable.image_lorem, "")
        };
    }
    private final Item[] ItemsCategory5;
    public Item[] getItemsCategory5() {
        return this.ItemsCategory5;
    }
}
