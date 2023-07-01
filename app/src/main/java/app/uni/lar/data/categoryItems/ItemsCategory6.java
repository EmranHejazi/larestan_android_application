package app.uni.lar.data.categoryItems;

import android.content.Context;

import app.uni.lar.R;
import app.uni.lar.models.Item;

public class ItemsCategory6 {
    public ItemsCategory6(Context context) {
        ItemsCategory6 = new Item[]{
                //TODO("this data is for Ghaza haye boomi's items")
                new Item(context.getResources().getString(R.string.category_6_title_taftan), R.drawable.category_6_image_taftan, context.getResources().getString(R.string.category_6_content_taftan)),
                new Item(context.getResources().getString(R.string.category_6_title_halva), R.drawable.category_6_image_halva, context.getResources().getString(R.string.category_6_content_halva)),
                new Item(context.getResources().getString(R.string.category_6_title_delbaro), R.drawable.category_6_image_delbaro, context.getResources().getString(R.string.category_6_content_delbaro)),
        };
    }

    private final Item[] ItemsCategory6;

    public Item[] getItemsCategory6() {
        return this.ItemsCategory6;
    }
}
