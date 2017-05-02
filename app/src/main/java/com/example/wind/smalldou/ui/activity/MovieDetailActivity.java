package com.example.wind.smalldou.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.wind.smalldou.R;
import com.example.wind.smalldou.ui.fragment.MovieDetailFragment;
import com.example.wind.smalldou.utils.IntentExtras;

/**
 * Created by Wind1129 on 17/4/14.
 */

public class MovieDetailActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        String movieId = getIntent().getStringExtra(IntentExtras.KEY_MOVIE_ID);
        String imageUrl = getIntent().getStringExtra(IntentExtras.KEY_IMAGE_URL);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, MovieDetailFragment.newInstance(movieId,imageUrl), MovieDetailFragment.TAG)
                .commit();
    }
}
