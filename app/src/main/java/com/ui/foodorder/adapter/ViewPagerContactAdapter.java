package com.ui.foodorder.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.ui.foodorder.fragment.ChatFragment;
import com.ui.foodorder.fragment.NotificationFragment;

public class ViewPagerContactAdapter extends FragmentStateAdapter {
    public ViewPagerContactAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new ChatFragment();
            case 1:
                return new NotificationFragment();
            default:
                return new ChatFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
