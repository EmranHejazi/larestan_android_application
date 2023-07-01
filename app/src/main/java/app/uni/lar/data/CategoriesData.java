package app.uni.lar.data;

import android.content.Context;

import app.uni.lar.R;
import app.uni.lar.models.Category;

public class CategoriesData {

    public CategoriesData(Context context) {
        categoriesData = new Category[]{
                //TODO("Hey Ali this data for categories. it's showing on the Main Activity")
                new Category(context.getResources().getString(R.string.category_1_natural_geography), R.drawable.category_ic_earth),
                new Category(context.getResources().getString(R.string.category_2_local_games), R.drawable.category_ic_ball),
                new Category(context.getResources().getString(R.string.category_3_ancient_places), R.drawable.category_ic_ancient),
                new Category(context.getResources().getString(R.string.category_4_economic_view), R.drawable.category_ic_money),
                new Category(context.getResources().getString(R.string.category_5_proverbs), R.drawable.category_ic_proverb),
                new Category(context.getResources().getString(R.string.category_6_foods), R.drawable.category_ic_bread),
        };
    }

    private final Category[] categoriesData;

    public Category[] getCategoriesData() {
        return this.categoriesData;
    }
}
