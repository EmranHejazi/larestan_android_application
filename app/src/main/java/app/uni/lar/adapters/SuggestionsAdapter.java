package app.uni.lar.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import app.uni.lar.R;
import app.uni.lar.activities.ItemActivity;
import app.uni.lar.data.categoryItems.ItemsCategory1;
import app.uni.lar.data.categoryItems.ItemsCategory2;
import app.uni.lar.data.categoryItems.ItemsCategory3;
import app.uni.lar.data.categoryItems.ItemsCategory4;
import app.uni.lar.data.categoryItems.ItemsCategory5;
import app.uni.lar.data.categoryItems.ItemsCategory6;
import app.uni.lar.models.Item;
import app.uni.lar.models.Suggestion;

public class SuggestionsAdapter extends RecyclerView.Adapter<SuggestionsAdapter.ViewHolder> {
    private final Suggestion[] suggestions;
    private ArrayList<Item> itemsList;

    public SuggestionsAdapter(Suggestion[] suggestions) {
        this.suggestions = suggestions;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.row_suggestion, parent, false);
        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Suggestion suggestion = suggestions[position];
        holder.textView.setText(suggestions[position].getTitle());
        holder.imageView.setImageResource(suggestions[position].getImageID());
        holder.relativeLayout.setOnClickListener(view -> {
            // get all data
            itemsList = new ArrayList<>();
            ItemsCategory1 category1 = new ItemsCategory1(view.getContext());
            ItemsCategory2 category2 = new ItemsCategory2(view.getContext());
            ItemsCategory3 category3 = new ItemsCategory3(view.getContext());
            ItemsCategory4 category4 = new ItemsCategory4(view.getContext());
            ItemsCategory5 category5 = new ItemsCategory5(view.getContext());
            ItemsCategory6 category6 = new ItemsCategory6(view.getContext());
            // push all data to once list
            itemsList.addAll(Arrays.asList(category1.getItemsCategory1()));
            itemsList.addAll(Arrays.asList(category2.getItemsCategory2()));
            itemsList.addAll(Arrays.asList(category3.getItemsCategory3()));
            itemsList.addAll(Arrays.asList(category4.getItemsCategory4()));
            itemsList.addAll(Arrays.asList(category5.getItemsCategory5()));
            itemsList.addAll(Arrays.asList(category6.getItemsCategory6()));

            String searchText = suggestions[position].getTitle();

            for (Item item : itemsList) {
                if (item.getTitle().contains(searchText)) {
                    Intent intent = new Intent(view.getContext(), ItemActivity.class);
                    intent.putExtra("item_name", item.getTitle());
                    intent.putExtra("item_imageID", item.getImageID());
                    intent.putExtra("item_content", item.getContent());
                    intent.putExtra("category_title", "پیشنهاد");
                    view.getContext().startActivity(intent);
                }
            }

        });
    }


    @Override
    public int getItemCount() {
        return suggestions.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView;
        public RelativeLayout relativeLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            this.imageView = itemView.findViewById(R.id.image_suggestion);
            this.textView = itemView.findViewById(R.id.title_suggestion);
            relativeLayout = itemView.findViewById(R.id.relative_layout_suggestions);
        }
    }
}