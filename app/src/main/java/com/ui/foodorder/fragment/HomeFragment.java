package com.ui.foodorder.fragment;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.ui.foodorder.R;
import com.ui.foodorder.adapter.OptionAdapter;
import com.ui.foodorder.databinding.FragmentHomeBinding;
import com.ui.foodorder.model.Credit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements View.OnClickListener {
    private FragmentHomeBinding mBinding;
    private View mView;

    private List<Credit> mCredits;
    private OptionAdapter mOptionAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        mBinding = FragmentHomeBinding.inflate(inflater, container, false);
        mView = mBinding.getRoot();

        initialView();
        initialData();
        return mView;
    }

    private void initialView() {

        mCredits = new ArrayList<>();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        mBinding.recyclerOption.setLayoutManager(linearLayoutManager);
        mBinding.recyclerOption.setHasFixedSize(true);

        mBinding.txtPre.setOnClickListener(this);
        mBinding.txtPlay.setOnClickListener(this);
        mBinding.txtNext.setOnClickListener(this);

//        displayVideoIntroURL();
//        displayVideoIntroNew();
    }

    private void initialData() {
        updateUIOption();
    }

    private void updateUIOption() {
        mCredits = new ArrayList<>();
        mCredits.add(new Credit(R.drawable.image_logo, getString(R.string.str_credit_option_debit)));
        mCredits.add(new Credit(R.drawable.image_logo, getString(R.string.str_credit_option_debit)));
        mCredits.add(new Credit(R.drawable.image_logo, getString(R.string.str_credit_option_payment)));
        mCredits.add(new Credit(R.drawable.image_logo, getString(R.string.str_credit_option_pay)));
        mCredits.add(new Credit(R.drawable.image_logo, getString(R.string.str_credit_option_withdraw)));

        if (mOptionAdapter == null) {
            mOptionAdapter = new OptionAdapter(mCredits, getContext());
            mBinding.recyclerOption.setAdapter(mOptionAdapter);
        }
        mOptionAdapter.notifyDataSetChanged();
    }

    private void displayVideoIntroURL() {
        String url1 = "https://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4";
        mBinding.videoIntro.setVideoPath(url1);
        MediaController mediaController = new MediaController(getContext());
        mediaController.setAnchorView(mBinding.videoIntro);
        mBinding.videoIntro.setMediaController(mediaController);
        mBinding.videoIntro.start();

        mBinding.videoIntro.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
            }
        });
    }
    private void displayVideoIntroNew() {
        String url1 = "https://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4";
        mBinding.videoIntroNew.setVideoPath(url1);
        MediaController mediaController = new MediaController(getContext());
        mediaController.setAnchorView(mBinding.videoIntroNew);
        mBinding.videoIntroNew.setMediaController(mediaController);
        mBinding.videoIntroNew.start();

        mBinding.videoIntroNew.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.txt_pre:
                Toast.makeText(getContext(), "touch pre", Toast.LENGTH_SHORT).show();
                break;
            case R.id.txt_play:
                playMusicUrl();
                break;
            case R.id.txt_next:
                Toast.makeText(getContext(), "touch next", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void playMusicUrl() {
        try {
            System.out.println("AAAAAAAAAAAAAAa +++++++++++++");
            Toast.makeText(getContext(), "touch play", Toast.LENGTH_SHORT).show();
//        String link_mp3 = "https://www.shazam.com/track/44926728/t%25C3%25B4i-l%25C3%25A0-t%25C3%25B4i";
            String link_mp3 = "https://www.shazam.com/partner/sc/track/40333609";
            MediaPlayer mediaPlayer = new MediaPlayer();
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
//        mediaPlayer.setDataSource(getApplicationContext(), url);
            mediaPlayer.setDataSource(getContext().getApplicationContext(), Uri.parse(link_mp3));
            mediaPlayer.prepare();
            mediaPlayer.start();

            Toast.makeText(getContext(), "touch play end", Toast.LENGTH_SHORT).show();
        } catch (Exception ex) {
            System.out.println("222222 EEEEEEEEEE ------------------");
            ex.printStackTrace();
        }
    }
}
