package app.uni.lar.data.categoryItems;

import android.content.Context;

import app.uni.lar.R;
import app.uni.lar.models.Item;

public class ItemsCategory4 {
    public ItemsCategory4(Context context) {
        ItemsCategory4 = new Item[]{
                //TODO("this data is for Did eghtesadi's items")
                new Item(context.getResources().getString(R.string.category_4_title_sekelari), R.drawable.category_4_image_sekelari, context.getResources().getString(R.string.category_4_content_sekelari)),
        };
    }

    private final Item[] ItemsCategory4;

    public Item[] getItemsCategory4() {
        return this.ItemsCategory4;
    }
}
