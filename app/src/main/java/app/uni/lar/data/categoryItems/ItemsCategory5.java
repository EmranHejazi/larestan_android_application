package app.uni.lar.data.categoryItems;

import android.content.Context;

import app.uni.lar.R;
import app.uni.lar.models.Item;

public class ItemsCategory5 {
    public ItemsCategory5(Context context) {
        ItemsCategory5 = new Item[] {
                new Item(context.getResources().getString(R.string.category_1_natural_geography), R.drawable.ic_earth,""),
                new Item(context.getResources().getString(R.string.category_2_local_games), R.drawable.ic_ball,""),
                new Item(context.getResources().getString(R.string.category_3_ancient_places), R.drawable.ic_ancient,""),
                new Item(context.getResources().getString(R.string.category_4_economic_view), R.drawable.ic_money,""),
                new Item(context.getResources().getString(R.string.category_5_proverbs), R.drawable.ic_proverb,"")
        };
    }
    private final Item[] ItemsCategory5;
    public Item[] getItemsCategory5() {
        return this.ItemsCategory5;
    }
}
