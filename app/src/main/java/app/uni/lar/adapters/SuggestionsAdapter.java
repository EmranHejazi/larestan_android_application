package app.uni.lar.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import app.uni.lar.R;
import app.uni.lar.models.Suggestion;

public class SuggestionsAdapter extends RecyclerView.Adapter<SuggestionsAdapter.ViewHolder> {
    private final Suggestion[] suggestions;

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