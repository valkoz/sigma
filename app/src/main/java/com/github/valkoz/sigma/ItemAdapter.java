package com.github.valkoz.sigma;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.valkoz.sigma.model.TransformedItem;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private List<TransformedItem> dataset;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView pubDate;
        public TextView creator;
        public TextView description;
        public TextView categories;

        public ViewHolder(View v) {
            super(v);
            title = v.findViewById(R.id.title);
            pubDate = v.findViewById(R.id.pub_date);
            creator = v.findViewById(R.id.creator);
            description = v.findViewById(R.id.description);
            categories = v.findViewById(R.id.categories);

        }
    }

    public ItemAdapter(List<TransformedItem> inputDataset) {
        dataset = inputDataset;
    }

    public void addItems(List<TransformedItem> items) {
        dataset = items;
        notifyDataSetChanged();
    }

    public List<TransformedItem> getItems() {
        return dataset;
    }

    @NonNull
    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                                     int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_main, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(dataset.get(position).getTitle());
        holder.pubDate.setText(dataset.get(position).getPubDate());
        holder.creator.setText(dataset.get(position).getCreator());
        holder.categories.setText(dataset.get(position).getCategories());
        holder.description.setText(dataset.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

}
