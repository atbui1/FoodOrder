package com.ui.foodorder.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ui.foodorder.R;
import com.ui.foodorder.adapter.ViewPagerContactAdapter;
import com.ui.foodorder.databinding.FragmentContactBinding;

public class ContactFragment extends Fragment implements View.OnClickListener {
    private FragmentContactBinding mBinding;
    private View mView;

    private ViewPagerContactAdapter mViewPagerContactAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        mBinding = FragmentContactBinding.inflate(inflater, container, false);
        mView = mBinding.getRoot();

        initialView();
        initialData();
        return mView;
    }

    private void initialView() {

        mViewPagerContactAdapter = new ViewPagerContactAdapter(getActivity());
        mBinding.viewPaperContact.setAdapter(mViewPagerContactAdapter);
        mBinding.viewPaperContact.setUserInputEnabled(false);

        //listener
        mBinding.btnMessage.setOnClickListener(this);
        mBinding.btnNotification.setOnClickListener(this);
    }

    private void initialData() {
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_message:
                mBinding.viewPaperContact.setCurrentItem(0);
                break;
            case R.id.btn_notification:
                mBinding.viewPaperContact.setCurrentItem(1);
                break;
        }
    }
}
