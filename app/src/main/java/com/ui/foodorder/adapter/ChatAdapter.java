package com.ui.foodorder.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ui.foodorder.R;
import com.ui.foodorder.model.Chat;
import com.ui.foodorder.model.Credit;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {
    private List<Chat> chats;
    private Context context;

    public ChatAdapter(List<Chat> chats, Context context) {
        this.chats = chats;
        this.context = context;
    }

    @NonNull
    @Override
    public ChatAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_row_chat, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatAdapter.ViewHolder holder, int position) {
        Chat chat = chats.get(position);
        if (chat == null) {
            return;
        }

        holder.txtTitle.setText(chat.getTitle());
        holder.txtSubTitle.setText(chat.getSubTitle());
        holder.imgAvatar.setImageResource(chat.getImage());

        if (chat.isStatus() == true) {
            holder.imgStatus.setVisibility(View.VISIBLE);
        } else {
            holder.imgStatus.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        if (chats.size() > 0) {
            return chats.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtTitle, txtSubTitle;
        ImageView imgAvatar, imgStatus;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txt_title);
            txtSubTitle = itemView.findViewById(R.id.txt_sub_title);
            imgAvatar = itemView.findViewById(R.id.img_avatar);
            imgStatus = itemView.findViewById(R.id.img_status);

        }
    }
}
