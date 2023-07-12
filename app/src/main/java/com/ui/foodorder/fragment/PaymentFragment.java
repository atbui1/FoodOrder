package com.ui.foodorder.fragment;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.ui.foodorder.R;
import com.ui.foodorder.adapter.CreditAdapter;
import com.ui.foodorder.adapter.SuggestAdapter;
import com.ui.foodorder.databinding.FragmentPaymentBinding;
import com.ui.foodorder.model.Credit;
import com.ui.foodorder.model.Suggest;

import java.util.ArrayList;
import java.util.List;

public class PaymentFragment extends Fragment {
    private FragmentPaymentBinding mBinding;
    private View mView;

    private CreditAdapter mCreditAdapter;
    private SuggestAdapter mSuggestAdapter;

    private List<Credit> mCredits;
    private List<Suggest> mSuggests;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        mBinding = FragmentPaymentBinding.inflate(inflater, container, false);
        mView = mBinding.getRoot();

        initialView();
        initialData();
        return mView;
    }

    private void initialView() {
        mCredits = new ArrayList<>();
        mSuggests = new ArrayList<>();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        mBinding.recycleCreditOption.setLayoutManager(linearLayoutManager);
        mBinding.recycleCreditOption.setHasFixedSize(true);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        mBinding.recycleSuggest.setLayoutManager(gridLayoutManager);
        mBinding.recycleSuggest.setHasFixedSize(true);

        updateUiCreditOption();
        updateUiSuggest();

    }

    private void initialData() {

    }

    private void getDataCreditOption() {
        mCredits.add(new Credit(R.drawable.icon_wallet_add, getString(R.string.str_credit_option_debit)));
        mCredits.add(new Credit(R.drawable.icon_scanner, getString(R.string.str_credit_option_payment)));
        mCredits.add(new Credit(R.drawable.icon_transfer, getString(R.string.str_credit_option_pay)));
        mCredits.add(new Credit(R.drawable.icon_bank, getString(R.string.str_credit_option_withdraw)));

    }

    private void getDataSuggest() {
        mSuggests.add(new Suggest(R.drawable.image_suggest_1, getString(R.string.str_credit_option_debit)));
        mSuggests.add(new Suggest(R.drawable.image_suggest_3, getString(R.string.str_credit_option_payment)));
        mSuggests.add(new Suggest(R.drawable.image_suggest_2, getString(R.string.str_credit_option_pay)));
        mSuggests.add(new Suggest(R.drawable.image_suggest_1, getString(R.string.str_credit_option_withdraw)));
        mSuggests.add(new Suggest(R.drawable.image_suggest_3, getString(R.string.str_credit_option_withdraw)));

    }


    private void updateUiCreditOption() {
        getDataCreditOption();
        if (mCreditAdapter == null) {
            mCreditAdapter = new CreditAdapter(mCredits, getContext());
            mBinding.recycleCreditOption.setAdapter(mCreditAdapter);
        }
        mCreditAdapter.notifyDataSetChanged();
    }
    private void updateUiSuggest() {
        getDataSuggest();
        if (mSuggestAdapter == null) {
            mSuggestAdapter = new SuggestAdapter(mSuggests, getContext());
            mBinding.recycleSuggest.setAdapter(mSuggestAdapter);
        }
        mSuggestAdapter.notifyDataSetChanged();
    }

}
