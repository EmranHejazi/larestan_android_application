package app.uni.lar.data;

import app.uni.lar.R;
import app.uni.lar.models.Suggestion;

public class SuggestionsData {
    private final Suggestion[] suggestionsData = new Suggestion[]{
            new Suggestion("Email", R.drawable.image_lorem),
    };

    public Suggestion[] getSuggestionsData() {
        return this.suggestionsData;
    }
}
