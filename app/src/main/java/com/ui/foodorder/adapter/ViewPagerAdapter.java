package com.ui.foodorder.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.ui.foodorder.fragment.ChatFragment;
import com.ui.foodorder.fragment.ContactFragment;
import com.ui.foodorder.fragment.HistoryFragment;
import com.ui.foodorder.fragment.HomeFragment;
import com.ui.foodorder.fragment.ProfileFragment;
import com.ui.foodorder.fragment.PaymentFragment;

public class ViewPagerAdapter extends FragmentStateAdapter {
    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new HomeFragment();
            case 1:
                return new ContactFragment();
            case 2:
                return new PaymentFragment();
            case 3:
                return new ProfileFragment();
            default:
                return new HomeFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
