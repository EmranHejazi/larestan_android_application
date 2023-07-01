package app.uni.lar.data.categoryItems;

import android.content.Context;

import app.uni.lar.R;
import app.uni.lar.models.Item;

public class ItemsCategory1 {
    public ItemsCategory1(Context context) {
        ItemsCategory1 = new Item[]{
                // this data is for Jorrafia tabiei's items
                new Item(context.getResources().getString(R.string.category_1_title_abohava), R.drawable.category_1_image_abohava, context.getResources().getString(R.string.category_1_content_abohava)),
                new Item(context.getResources().getString(R.string.category_1_title_rodha), R.drawable.category_1_image_rodha, context.getResources().getString(R.string.category_1_content_rodha)),
                new Item(context.getResources().getString(R.string.category_1_title_maeaden), R.drawable.category_1_image_maeaden, context.getResources().getString(R.string.category_1_content_maeaden)),
                new Item(context.getResources().getString(R.string.category_1_title_zendegijanevari), R.drawable.category_1_image_zendegijanevari, context.getResources().getString(R.string.category_1_content_zendegijanevari)),
        };
    }

    private final Item[] ItemsCategory1;

    public Item[] getItemsCategory1() {
        return this.ItemsCategory1;
    }
}
