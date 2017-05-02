package com.example.wind.smalldou.ui.activity;


import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.signature.StringSignature;
import com.example.wind.smalldou.R;

import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * Created by Wind1129 on 17/4/6.
 */

public class GuideActivity extends AppCompatActivity {
    @Bind(R.id.iv_splash)
    ImageView iv_splash;

    private static final float SCALE_END = 1.15F;
    private static final int ANIM_TIME = 2000;

    private static final int[] IMAGES = {
            R.drawable.splash1,
            R.drawable.splash2,
            R.drawable.splash3,
            R.drawable.splash4,
            R.drawable.splash5,
            R.drawable.splash6,
            R.drawable.splash7,

    };


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        ButterKnife.bind(this);
        Random random = new Random(SystemClock.elapsedRealtime());
        Glide.with(GuideActivity.this).load(IMAGES[random.nextInt(IMAGES.length)])
                .centerCrop()
                .listener(new RequestListener<Integer, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, Integer model, Target<GlideDrawable> target, boolean
                            isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, Integer model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        startAnim();
                        return false;
                    }
                })
                .error(R.drawable.error_splash_bg)
                .into(iv_splash);
    }


    private void startAnim() {
        ObjectAnimator animatorX = ObjectAnimator.ofFloat(iv_splash, "scaleX", 1f, SCALE_END);
        ObjectAnimator animatorY = ObjectAnimator.ofFloat(iv_splash, "scaleY", 1f, SCALE_END);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(ANIM_TIME).play(animatorX).with(animatorY);
        animatorSet.start();
        animatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                Intent intent = new Intent(GuideActivity.this, NavigationActivity.class);
                startActivity(intent);
                GuideActivity.this.overridePendingTransition(android.support.v7.appcompat.R.anim.abc_fade_in,
                        android.support.v7.appcompat.R.anim.abc_fade_out);
                finish();
            }
        });
    }
}
