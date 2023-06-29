package app.uni.lar.data.categoryItems;

import android.content.Context;

import app.uni.lar.R;
import app.uni.lar.models.Item;

public class ItemsCategory1 {
    public ItemsCategory1(Context context) {
        ItemsCategory1 = new Item[]{
                //TODO("Edit this data!!")
                new Item(context.getResources().getString(R.string.category_1_natural_geography), R.drawable.ic_earth, ""),
                new Item(context.getResources().getString(R.string.category_2_local_games), R.drawable.ic_ball, ""),
                new Item(context.getResources().getString(R.string.category_3_ancient_places), R.drawable.ic_ancient, ""),
                new Item(context.getResources().getString(R.string.category_4_economic_view), R.drawable.ic_money, ""),
                new Item(context.getResources().getString(R.string.category_5_proverbs), R.drawable.ic_proverb, "")
        };
    }

    private final Item[] ItemsCategory1;

    public Item[] getItemsCategory1() {
        return this.ItemsCategory1;
    }
}
