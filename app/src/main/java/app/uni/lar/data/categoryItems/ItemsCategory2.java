package app.uni.lar.data.categoryItems;

import android.content.Context;

import app.uni.lar.R;
import app.uni.lar.models.Item;

public class ItemsCategory2 {
    public ItemsCategory2(Context context) {
        ItemsCategory2 = new Item[]{
                // this data is for Bazi haye mahali's items
                new Item(context.getResources().getString(R.string.category_2_title_patako), R.drawable.category_2_image_patako, context.getResources().getString(R.string.category_2_content_patako)),
                new Item(context.getResources().getString(R.string.category_2_title_petotsk), R.drawable.category_2_image_petotsk, context.getResources().getString(R.string.category_2_content_petotsk)),
                new Item(context.getResources().getString(R.string.category_2_title_chkhrk), R.drawable.category_2_image_chkhrk, context.getResources().getString(R.string.category_2_content_chkhrk)),
                new Item(context.getResources().getString(R.string.category_2_title_dartopa), R.drawable.category_2_image_dartopa, context.getResources().getString(R.string.category_2_content_dartopa)),
                new Item(context.getResources().getString(R.string.category_2_title_rig), R.drawable.category_2_image_rig, context.getResources().getString(R.string.category_2_content_rig)),
                new Item(context.getResources().getString(R.string.category_2_title_lpergale), R.drawable.category_2_image_lpergale, context.getResources().getString(R.string.category_2_content_lpergale)),
                new Item(context.getResources().getString(R.string.category_2_title_maye), R.drawable.category_2_image_maye, context.getResources().getString(R.string.category_2_content_maye)),
                new Item(context.getResources().getString(R.string.category_2_title_haftdzhaftgale), R.drawable.category_2_image_haftdzhaftgale, context.getResources().getString(R.string.category_2_content_haftdzhaftgale)),
        };
    }

    private final Item[] ItemsCategory2;

    public Item[] getItemsCategory2() {
        return this.ItemsCategory2;
    }
}
