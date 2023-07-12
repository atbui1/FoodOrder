package com.ui.foodorder.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ui.foodorder.R;
import com.ui.foodorder.model.Credit;
import com.ui.foodorder.model.Suggest;

import java.util.List;

public class SuggestAdapter extends RecyclerView.Adapter<SuggestAdapter.ViewHolder> {

    private List<Suggest> suggests;
    private Context context;

    public SuggestAdapter(List<Suggest> suggests, Context context) {
        this.suggests = suggests;
        this.context = context;
    }

    @NonNull
    @Override
    public SuggestAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_row_suggest, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SuggestAdapter.ViewHolder holder, int position) {
        Suggest suggest = suggests.get(position);
        if (suggest == null) {
            return;
        }

        holder.txtTitle.setText(suggest.getTitle());
        holder.imgSuggest.setImageResource(suggest.getImage());
    }

    @Override
    public int getItemCount() {
        if (suggests.size() > 0) {
            return suggests.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtTitle;
        ImageView imgSuggest;
        RelativeLayout rllContainer;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txt_title);
            imgSuggest = itemView.findViewById(R.id.img_suggest);
            rllContainer = itemView.findViewById(R.id.rll_container);
        }
    }
}
