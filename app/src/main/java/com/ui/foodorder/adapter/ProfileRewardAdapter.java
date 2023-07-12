package com.ui.foodorder.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ui.foodorder.R;
import com.ui.foodorder.model.Reward;

import java.util.List;

public class ProfileRewardAdapter extends RecyclerView.Adapter<ProfileRewardAdapter.ViewHolder> {
    private List<Reward> rewards;
    private Context context;

    public ProfileRewardAdapter(List<Reward> rewards, Context context) {
        this.rewards = rewards;
        this.context = context;
    }

    @NonNull
    @Override
    public ProfileRewardAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_row_profile, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileRewardAdapter.ViewHolder holder, int position) {
        Reward reward = rewards.get(position);
        if (reward == null) {
            return;
        }

        holder.txtTitle.setText(reward.getTitle());
        if (reward.getStatus() == 0) {
            holder.txtNew.setVisibility(View.GONE);
        } else {
            holder.txtNew.setVisibility(View.VISIBLE);
        }

        holder.txtNewCardView.setVisibility(View.VISIBLE);
        if (reward.getStatus() == 0) {
            holder.txtNewCardView.setText("heart");
            holder.txtNewCardView.setBackgroundResource(R.color.yellow);
        } else {
            holder.txtNewCardView.setText("gift");
            holder.txtNewCardView.setBackgroundResource(R.color.green);
        }
    }

    @Override
    public int getItemCount() {
        if (rewards.size() > 0) {
            return rewards.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtTitle, txtNew, txtPoints, txtNewCardView;
        LinearLayout lnlPoints;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txt_title);
            txtNew = itemView.findViewById(R.id.txt_new);
            txtPoints = itemView.findViewById(R.id.txt_points);
            lnlPoints = itemView.findViewById(R.id.lnl_points);

            txtNewCardView = itemView.findViewById(R.id.txt_new_card_view);
        }
    }
}
