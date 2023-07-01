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
import app.uni.lar.activities.CategoryItemsActivity;
import app.uni.lar.models.Category;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.ViewHolder> {
    private final Category[] categories;

    public CategoriesAdapter(Category[] categories) {
        this.categories = categories;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.row_category, parent, false);
        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Category category = categories[position];
        holder.textView.setText(categories[position].getTitle());
        holder.imageView.setImageResource(categories[position].getImageID());
        holder.relativeLayout.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), CategoryItemsActivity.class);
            intent.putExtra("category_name", categories[position].getTitle());
            view.getContext().startActivity(intent);
        });
    }


    @Override
    public int getItemCount() {
        return categories.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView;
        public RelativeLayout relativeLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            this.imageView = itemView.findViewById(R.id.image_category);
            this.textView = itemView.findViewById(R.id.title_category);
            relativeLayout = itemView.findViewById(R.id.relative_layout_category);
        }
    }
}