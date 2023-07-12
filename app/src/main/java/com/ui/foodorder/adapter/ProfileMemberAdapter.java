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
import com.ui.foodorder.model.Member;
import com.ui.foodorder.model.Reward;

import java.util.List;

public class ProfileMemberAdapter extends RecyclerView.Adapter<ProfileMemberAdapter.ViewHolder> {
    private List<Member> members;
    private Context context;

    public ProfileMemberAdapter(List<Member> members, Context context) {
        this.members = members;
        this.context = context;
    }

    @NonNull
    @Override
    public ProfileMemberAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_row_profile, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileMemberAdapter.ViewHolder holder, int position) {
        Member member = members.get(position);
        if (member == null) {
            return;
        }

        holder.txtTitle.setText(member.getTitle());
        if (member.getStatus() == 0) {
            holder.lnlPoints.setVisibility(View.GONE);
        } else {
            holder.lnlPoints.setVisibility(View.VISIBLE);
            holder.txtPoints.setText(member.getPoint() + " points");
        }
    }

    @Override
    public int getItemCount() {
        if (members.size() > 0) {
            return members.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtTitle, txtNew, txtPoints;
        LinearLayout lnlPoints;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txt_title);
            txtNew = itemView.findViewById(R.id.txt_new);
            txtPoints = itemView.findViewById(R.id.txt_points);
            lnlPoints = itemView.findViewById(R.id.lnl_points);
        }
    }
}
