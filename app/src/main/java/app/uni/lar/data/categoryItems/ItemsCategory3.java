package app.uni.lar.data.categoryItems;

import android.content.Context;

import app.uni.lar.R;
import app.uni.lar.models.Item;

public class ItemsCategory3 {
    public ItemsCategory3(Context context) {
        ItemsCategory3 = new Item[]{
                //TODO("this data is for Amaken bastani's items")
                new Item(context.getResources().getString(R.string.category_3_title_emamzade), R.drawable.category_3_image_emamzade, context.getResources().getString(R.string.category_3_content_emamzade)),
                new Item(context.getResources().getString(R.string.category_3_title_bazar), R.drawable.category_3_image_bazar, context.getResources().getString(R.string.category_3_content_bazar)),
                new Item(context.getResources().getString(R.string.category_3_title_borj), R.drawable.category_3_image_borj, context.getResources().getString(R.string.category_3_content_borj)),
                new Item(context.getResources().getString(R.string.category_3_title_qadamgah), R.drawable.category_3_image_qadamgah, context.getResources().getString(R.string.category_3_content_qadamgah)),
                new Item(context.getResources().getString(R.string.category_3_title_qale), R.drawable.category_3_image_qale, context.getResources().getString(R.string.category_3_content_qale)),
        };
    }

    private final Item[] ItemsCategory3;

    public Item[] getItemsCategory3() {
        return this.ItemsCategory3;
    }
}
