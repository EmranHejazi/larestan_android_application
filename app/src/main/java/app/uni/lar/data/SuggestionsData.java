package app.uni.lar.data;

import app.uni.lar.R;
import app.uni.lar.models.Suggestion;

public class SuggestionsData {
    private final Suggestion[] suggestionsData = new Suggestion[]{
            new Suggestion("مایه", R.drawable.category_2_image_maye),
            new Suggestion("زندگی جانوری", R.drawable.category_1_image_zendegijanevari),
            new Suggestion("قلعه اژدها پیکر", R.drawable.category_3_image_qale),
            new Suggestion("بازار قیصریه", R.drawable.category_3_image_bazar),
    };

    public Suggestion[] getSuggestionsData() {
        return this.suggestionsData;
    }
}
