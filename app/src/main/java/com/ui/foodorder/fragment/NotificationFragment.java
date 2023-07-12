package com.ui.foodorder.fragment;

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
import com.ui.foodorder.databinding.FragmentNotifycationBinding;
import com.ui.foodorder.model.Chat;

import java.util.ArrayList;
import java.util.List;

public class NotificationFragment extends Fragment {
    private FragmentNotifycationBinding mBinding;
    private View mView;

    private List<Chat> mChats;
    private ChatAdapter mChatAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        mBinding = FragmentNotifycationBinding.inflate(inflater, container, false);
        mView = mBinding.getRoot();

        initialView();
        initialData();
        return mView;
    }

    private void initialView() {
        mChats = new ArrayList<>();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        mBinding.recyclerNotification.setLayoutManager(layoutManager);
        mBinding.recyclerNotification.setHasFixedSize(true);
    }

    private void initialData() {
        updateUINotification();
    }

    private void updateUINotification() {
        mChats = new ArrayList<>();

        mChats.add(new Chat(R.drawable.image_logo, "nhan hang", "hang da duoc van chuyen thanh cong", true));
        mChats.add(new Chat(R.drawable.icon_scanner, "uu dai khuyen mai", "khuyen mai hap dan", true));
        mChats.add(new Chat(R.drawable.image_cat_1, "Qua tet", "tri an khach hang", false));
        mChats.add(new Chat(R.drawable.image_cat_2, "Thach thuc cuc han", "Vo vang qua tang voi cac chuong trinh hap dan, san sale tha ga nhan ngay qua khung", true));
        mChats.add(new Chat(R.drawable.image_cat_3, "San pham moi", "Cac san pham dang duoc san don", false));

        mChats.add(new Chat(R.drawable.image_logo, "nhan hang", "hang da duoc van chuyen thanh cong", true));
        mChats.add(new Chat(R.drawable.icon_scanner, "uu dai khuyen mai", "khuyen mai hap dan", true));
        mChats.add(new Chat(R.drawable.image_cat_1, "Qua tet", "tri an khach hang", false));
        mChats.add(new Chat(R.drawable.image_cat_2, "Thach thuc cuc han", "Vo vang qua tang voi cac chuong trinh hap dan, san sale tha ga nhan ngay qua khung", true));
        mChats.add(new Chat(R.drawable.image_cat_3, "San pham moi", "Cac san pham dang duoc san don", false));

        mChats.add(new Chat(R.drawable.image_logo, "nhan hang", "hang da duoc van chuyen thanh cong", true));
        mChats.add(new Chat(R.drawable.icon_scanner, "uu dai khuyen mai", "khuyen mai hap dan", true));
        mChats.add(new Chat(R.drawable.image_cat_1, "Qua tet", "tri an khach hang", false));
        mChats.add(new Chat(R.drawable.image_cat_2, "Thach thuc cuc han", "Vo vang qua tang voi cac chuong trinh hap dan, san sale tha ga nhan ngay qua khung", true));
        mChats.add(new Chat(R.drawable.image_cat_3, "San pham moi", "Cac san pham dang duoc san don", false));

        mChats.add(new Chat(R.drawable.image_logo, "nhan hang", "hang da duoc van chuyen thanh cong", true));
        mChats.add(new Chat(R.drawable.icon_scanner, "uu dai khuyen mai", "khuyen mai hap dan", true));
        mChats.add(new Chat(R.drawable.image_cat_1, "Qua tet", "tri an khach hang", false));
        mChats.add(new Chat(R.drawable.image_cat_2, "Thach thuc cuc han", "Vo vang qua tang voi cac chuong trinh hap dan, san sale tha ga nhan ngay qua khung", true));
        mChats.add(new Chat(R.drawable.image_cat_3, "San pham moi", "Cac san pham dang duoc san don", false));

        if (mChatAdapter == null) {
            mChatAdapter = new ChatAdapter(mChats, getContext());
            mBinding.recyclerNotification.setAdapter(mChatAdapter);
        }
        mChatAdapter.notifyDataSetChanged();
    }
}
