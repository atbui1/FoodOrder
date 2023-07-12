package com.ui.foodorder.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.ui.foodorder.adapter.ProfileMemberAdapter;
import com.ui.foodorder.adapter.ProfileRewardAdapter;
import com.ui.foodorder.databinding.FragmentProfileBinding;
import com.ui.foodorder.model.Member;
import com.ui.foodorder.model.Reward;

import java.util.ArrayList;
import java.util.List;

public class ProfileFragment extends Fragment {
    private FragmentProfileBinding mBinding;
    private View mView;

    private List<Reward> mRewards;
    private List<Member> mMembers;
    private ProfileRewardAdapter mProfileRewardAdapter;
    private ProfileMemberAdapter mProfileMemberAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        mBinding = FragmentProfileBinding.inflate(inflater, container, false);
        mView = mBinding.getRoot();

        initialView();
        initialData();

        return mView;
    }

    private void initialView() {
        mRewards = new ArrayList<>();
        mMembers = new ArrayList<>();

        LinearLayoutManager layoutManagerReward = new LinearLayoutManager(getContext());
        LinearLayoutManager layoutManagerMember = new LinearLayoutManager(getContext());

        mBinding.rclReward.setLayoutManager(layoutManagerReward);
        mBinding.rclReward.setNestedScrollingEnabled(false);
        mBinding.rclReward.setHasFixedSize(true);

        mBinding.rclMember.setLayoutManager(layoutManagerMember);
//        mBinding.rclMember.setNestedScrollingEnabled(false);
        mBinding.rclMember.setHasFixedSize(true);

    }

    private void initialData() {
        getDataReward();
        getDataMember();
    }

    private void getDataReward() {
        System.out.println("111111111");
        mRewards.add(new Reward("Rewards", 0));
        mRewards.add(new Reward("Gói hội viên", 0));
        mRewards.add(new Reward("Thử thách", 1));
        mRewards.add(new Reward("Giới thiệu", 0));
        updateUIReward();
    }
    private void getDataMember() {
        System.out.println("2222222");
        mMembers.add(new Member("Thành viên ưu đãi", 0, 1));
        mMembers.add(new Member("Thành viên theo gói", 50, 1));
        mMembers.add(new Member("Đã đặt trước", 0, 0));
        mMembers.add(new Member("Địa điểm đã lưu", 0, 0));
        mMembers.add(new Member("số liên lạc khẩn cấp", 0, 0));
        mMembers.add(new Member("Tài khoản doanh nghiệp", 0, 0));
        updateUIMember();
    }

    private void updateUIReward() {
        if (mProfileRewardAdapter == null) {
            mProfileRewardAdapter = new ProfileRewardAdapter(mRewards, getContext());
            mBinding.rclReward.setAdapter(mProfileRewardAdapter);
        }
        mProfileRewardAdapter.notifyDataSetChanged();
    }
    private void updateUIMember() {
        if (mProfileMemberAdapter == null) {
            mProfileMemberAdapter = new ProfileMemberAdapter(mMembers, getContext());
            mBinding.rclMember.setAdapter(mProfileMemberAdapter);
        }
        mProfileMemberAdapter.notifyDataSetChanged();
    }
}
