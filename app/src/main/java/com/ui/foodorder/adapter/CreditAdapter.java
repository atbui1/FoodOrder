package com.ui.foodorder.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ui.foodorder.R;
import com.ui.foodorder.model.Credit;
import com.ui.foodorder.model.Member;

import java.util.List;

public class CreditAdapter extends RecyclerView.Adapter<CreditAdapter.ViewHolder> {
    private List<Credit> credits;
    private Context context;

    public CreditAdapter(List<Credit> credits, Context context) {
        this.credits = credits;
        this.context = context;
    }

    @NonNull
    @Override
    public CreditAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_row_credit, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CreditAdapter.ViewHolder holder, int position) {
        Credit credit = credits.get(position);
        if (credit == null) {
            return;
        }

        holder.txtTitle.setText(credit.getTitle());
        holder.imgOption.setImageResource(credit.getImage());
    }

    @Override
    public int getItemCount() {
        if (credits.size() > 0) {
            return credits.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtTitle;
        ImageView imgOption;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txt_title);
            imgOption = itemView.findViewById(R.id.img_credit_option);
        }
    }
}
