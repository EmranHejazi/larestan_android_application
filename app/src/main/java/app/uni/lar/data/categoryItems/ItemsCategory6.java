package app.uni.lar.data.categoryItems;

import android.content.Context;

import app.uni.lar.R;
import app.uni.lar.models.Item;

public class ItemsCategory6 {
    public ItemsCategory6(Context context) {
        ItemsCategory6 = new Item[]{
                //TODO("this data is for Ghaza haye boomi's items")
                new Item(context.getResources().getString(R.string.category_5_proverbs), R.drawable.image_lorem, "")
        };
    }

    private final Item[] ItemsCategory6;

    public Item[] getItemsCategory6() {
        return this.ItemsCategory6;
    }
}
