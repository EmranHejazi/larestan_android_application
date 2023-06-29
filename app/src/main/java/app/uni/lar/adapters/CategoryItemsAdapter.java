package app.uni.lar.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import app.uni.lar.R;
import app.uni.lar.activities.ItemActivity;
import app.uni.lar.models.Item;

public class CategoryItemsAdapter extends RecyclerView.Adapter<CategoryItemsAdapter.ViewHolder> {
    private final Item[] items;

    public CategoryItemsAdapter(Item[] items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.row_category_items, parent, false);
        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Item item = items[position];
        holder.textView.setText(items[position].getTitle());
        holder.imageView.setImageResource(items[position].getImageID());
        holder.relativeLayout.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), ItemActivity.class);
            intent.putExtra("item_name", items[position].getTitle());
            intent.putExtra("item_imageID", items[position].getImageID());
            intent.putExtra("item_content", items[position].getContent());
            view.getContext().startActivity(intent);
        });
    }


    @Override
    public int getItemCount() {
        return items.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView;
        public RelativeLayout relativeLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            this.imageView = itemView.findViewById(R.id.image_item);
            this.textView = itemView.findViewById(R.id.title_item);
            relativeLayout = itemView.findViewById(R.id.relative_layout_item);
        }
    }
}