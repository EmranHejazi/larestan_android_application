package app.uni.lar.adapters;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import app.uni.lar.R;
import app.uni.lar.view.ItemActivity;
import app.uni.lar.data.categoryItems.ItemsCategory1;
import app.uni.lar.data.categoryItems.ItemsCategory2;
import app.uni.lar.data.categoryItems.ItemsCategory3;
import app.uni.lar.data.categoryItems.ItemsCategory4;
import app.uni.lar.data.categoryItems.ItemsCategory5;
import app.uni.lar.data.categoryItems.ItemsCategory6;
import app.uni.lar.models.Item;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {
    private List<Item> itemList;
    private ArrayList<Item> itemsList;

    public SearchAdapter(List<Item> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_search, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Item item = itemList.get(position);
        holder.imageView.setImageResource(item.getImageID());
        holder.textView.setText(item.getTitle());
        int color = Color.parseColor("#FFD570");
        holder.imageView.setColorFilter(color, PorterDuff.Mode.MULTIPLY);
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

            String searchText = item.getTitle();

            for (Item aItem : itemsList) {
                if (aItem.getTitle().contains(searchText)) {
                    Intent intent = new Intent(view.getContext(), ItemActivity.class);
                    intent.putExtra("item_name", aItem.getTitle());
                    intent.putExtra("item_imageID", aItem.getImageID());
                    intent.putExtra("item_content", aItem.getContent());
                    intent.putExtra("category_title", "جستجو");
                    view.getContext().startActivity(intent);
                }
            }

        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public void setItems(List<Item> items) {
        itemList = items;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        RelativeLayout relativeLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_item);
            textView = itemView.findViewById(R.id.title_item);
            relativeLayout = itemView.findViewById(R.id.relative_layout_search);

        }
    }
}
