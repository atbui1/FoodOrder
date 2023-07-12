package com.ui.foodorder.fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.ui.foodorder.R;
import com.ui.foodorder.adapter.ChatAdapter;
import com.ui.foodorder.databinding.FragmentChatBinding;
import com.ui.foodorder.model.Chat;

import java.util.ArrayList;
import java.util.List;

public class ChatFragment extends Fragment {
    private FragmentChatBinding mBinding;
    private View mView;

    private List<Chat> mChats;
    private ChatAdapter mChatAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        mBinding = FragmentChatBinding.inflate(inflater, container, false);
        mView = mBinding.getRoot();

        initialView();
        initialData();
        return mView;
    }

    private void initialView() {
        mChats = new ArrayList<>();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mBinding.recyclerChat.setLayoutManager(linearLayoutManager);
        mBinding.recyclerChat.setHasFixedSize(true);

    }

    private void initialData() {
        updateUIChat();
    }

    private void updateUIChat() {
        mChats = new ArrayList<>();
        mChats.add(new Chat(R.drawable.image_suggest_1, "tran cao Lanh", "cam on bac tai", true));
        mChats.add(new Chat(R.drawable.image_suggest_2, "tran van Hao", "cam on bac tai", true));
        mChats.add(new Chat(R.drawable.image_suggest_3, "nguyen trinh Binh", "cam on bac tai", false));
        mChats.add(new Chat(R.drawable.image_suggest_1, "hoa Hau ", "cam on bac tai", true));
        mChats.add(new Chat(R.drawable.image_suggest_3, "Ly cao Cao", "cam on bac tai", false));

        mChats.add(new Chat(R.drawable.image_suggest_1, "tran cao Lanh", "cam on bac tai", true));
        mChats.add(new Chat(R.drawable.image_suggest_2, "tran van Hao", "cam on bac tai", true));
        mChats.add(new Chat(R.drawable.image_suggest_3, "nguyen trinh Binh", "cam on bac tai", false));
        mChats.add(new Chat(R.drawable.image_suggest_1, "hoa Hau ", "cam on bac tai", true));
        mChats.add(new Chat(R.drawable.image_suggest_3, "Ly cao Cao", "cam on bac tai", false));

        mChats.add(new Chat(R.drawable.image_suggest_1, "tran cao Lanh", "cam on bac tai", true));
        mChats.add(new Chat(R.drawable.image_suggest_2, "tran van Hao", "cam on bac tai", true));
        mChats.add(new Chat(R.drawable.image_suggest_3, "nguyen trinh Binh", "cam on bac tai", false));
        mChats.add(new Chat(R.drawable.image_suggest_1, "hoa Hau ", "cam on bac tai", true));
        mChats.add(new Chat(R.drawable.image_suggest_3, "Ly cao Cao", "cam on bac tai", false));

        mChats.add(new Chat(R.drawable.image_suggest_1, "tran cao Lanh", "cam on bac tai", true));
        mChats.add(new Chat(R.drawable.image_suggest_2, "tran van Hao", "cam on bac tai", true));
        mChats.add(new Chat(R.drawable.image_suggest_3, "nguyen trinh Binh", "cam on bac tai", false));
        mChats.add(new Chat(R.drawable.image_suggest_1, "hoa Hau ", "cam on bac tai", true));
        mChats.add(new Chat(R.drawable.image_suggest_3, "Ly cao Cao", "cam on bac tai", false));

        if (mChatAdapter == null) {
            mChatAdapter = new ChatAdapter(mChats, getContext());
            mBinding.recyclerChat.setAdapter(mChatAdapter);
        }
        mChatAdapter.notifyDataSetChanged();
    }
}
