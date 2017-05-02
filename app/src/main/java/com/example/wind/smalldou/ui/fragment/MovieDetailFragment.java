package com.example.wind.smalldou.ui.fragment;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.wind.smalldou.R;
import com.example.wind.smalldou.SmallDouApplication;
import com.example.wind.smalldou.inject.component.ApplicationComponent;
import com.example.wind.smalldou.inject.component.DaggerMovieDetailComponent;
import com.example.wind.smalldou.inject.component.MovieDetailComponent;
import com.example.wind.smalldou.inject.module.ActivityModule;
import com.example.wind.smalldou.inject.module.MovieDetailModule;
import com.example.wind.smalldou.interfaces.OnItemClickLinkToListener;
import com.example.wind.smalldou.mvp.contract.DetailContract;
import com.example.wind.smalldou.mvp.model.bean.MovieDetailsBean;
import com.example.wind.smalldou.ui.adapter.ActorAdapter;
import com.example.wind.smalldou.ui.adapter.PageMovieAdapter;
import com.example.wind.smalldou.utils.CommonUtil;
import com.example.wind.smalldou.utils.DensityUtil;
import com.example.wind.smalldou.utils.ImageUtil;
import com.example.wind.smalldou.utils.IntentExtras;
import com.example.wind.smalldou.utils.StatusBarUtil;
import com.example.wind.smalldou.utils.StringUtil;
import com.example.wind.smalldou.widget.CompatNestedScrollView;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import jp.wasabeef.glide.transformations.BlurTransformation;

/**
 * Created by Wind1129 on 17/4/14.
 */

public class MovieDetailFragment extends Fragment implements DetailContract.View<MovieDetailsBean> {
    public static final String TAG = MovieDetailFragment.class.getSimpleName().toString();

    @Inject
    DetailContract.Presenter presenter;
    //activity传进来的movieId
    private String mMovieId;
    //activity传进来的imageUrl
    private String mImageUrl;
    private View rootView;

    private ActorAdapter mActorAdapter;


    @Bind(R.id.f_moviedetail_nested)
    CompatNestedScrollView compatNestedScrollView;
    @Bind(R.id.ll_image)
    LinearLayout ll_image;
    @Bind(R.id.iv_image)
    ImageView iv_image;
    @Bind(R.id.iv_bg)
    ImageView iv_bg;
    @Bind(R.id.iv_title_head_bg)
    ImageView iv_title_head_bg;
    @Bind(R.id.ll_content)
    LinearLayout ll_content;
    @Bind(R.id.include_item_subject_title)
    TextView subject_title;
    @Bind(R.id.include_item_subject_genres)
    TextView subject_genres;
    @Bind(R.id.include_item_subject_aka)
    TextView subject_aka;
    @Bind(R.id.include_item_subject_countries)
    TextView subject_countries;
    @Bind(R.id.include_item_ratingnumber)
    TextView ratingnumber;
    @Bind(R.id.include_item_ratingbar)
    RatingBar ratingbar;
    @Bind(R.id.include_item_ratings_count)
    TextView ratings_count;
    @Bind(R.id.tv_wish_count)
    TextView wish_count;
    @Bind(R.id.tv_reviews_count)
    TextView reviews_count;
    @Bind(R.id.tv_summary_title)
    TextView summary_title;
    @Bind(R.id.tv_summary)
    TextView summary;
    @Bind(R.id.tv_summary_more)
    TextView summary_more;
    @Bind(R.id.tv_actor_name)
    TextView actor_name;
    @Bind(R.id.rv_actor)
    RecyclerView rv_actor;
    @Bind(R.id.tv_recommend_movie)
    TextView recommend_movie;
    @Bind(R.id.rv_recommend_movie)
    RecyclerView rv_recommend_movie;
    @Bind(R.id.progressBar)
    ProgressBar progressBar;
    @Bind(R.id.title_tool_bar)
    Toolbar toolbar;

    //高斯图背景的高度
    private int imageBgHeight;
    //在多大范围内变色
    private int slidingDistance;
    //toolbar+状态栏的高度
    private int headerHeight;

    private MovieDetailsBean mMovieDetailsBean;


    public static MovieDetailFragment newInstance(String movieId, String imageUrl) {
        Bundle bundle = new Bundle();
        bundle.putString(IntentExtras.KEY_MOVIE_ID, movieId);
        bundle.putString(IntentExtras.KEY_IMAGE_URL, imageUrl);
        MovieDetailFragment movieDetailFragment = new MovieDetailFragment();
        movieDetailFragment.setArguments(bundle);
        return movieDetailFragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMovieId = getArguments().getString(IntentExtras.KEY_MOVIE_ID);
        mImageUrl = getArguments().getString(IntentExtras.KEY_IMAGE_URL);
        injectDependences();
        presenter.attachView(this);
        mActorAdapter = new ActorAdapter(getActivity());

    }

    private void injectDependences() {
        ApplicationComponent applicationComponent = ((SmallDouApplication) (getActivity().getApplication()))
                .getApplicationComponent();
        MovieDetailComponent movieDetailComponent = DaggerMovieDetailComponent.builder()
                .applicationComponent(applicationComponent)
                .activityModule(new ActivityModule(getActivity()))
                .movieDetailModule(new MovieDetailModule())
                .build();
        movieDetailComponent.inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle
            savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_movie_detail, container, false);
        ButterKnife.bind(this, rootView);

        setRatingbar();

        setTitleBar();
        setPicture();
        initSlideShapeTheme();

        return rootView;
    }

    private void setRatingbar() {
        // 设置小星星的颜色(兼容低版本)
        LayerDrawable layerDrawable = (LayerDrawable) ratingbar.getProgressDrawable();
        layerDrawable.getDrawable(2).setColorFilter(Color.rgb(253,171,62), PorterDuff.Mode.SRC_ATOP);
    }

    private void initSlideShapeTheme() {
        setImgHeaderBg();

        // toolbar的高度
        int toolbarHeight = toolbar.getLayoutParams().height;
        // toolbar+状态栏的高度
        headerHeight = toolbarHeight + StatusBarUtil.getStatusBarHeight(getActivity());
        // 使背景图向上移动到图片的最底端，保留toolbar+状态栏的高度
        iv_title_head_bg.setVisibility(View.VISIBLE);
        ViewGroup.LayoutParams params = iv_title_head_bg.getLayoutParams();
        ViewGroup.MarginLayoutParams ivTitleHeadBgParams = (ViewGroup.MarginLayoutParams) iv_title_head_bg
                .getLayoutParams();
        int marginTop = params.height - headerHeight;
        ivTitleHeadBgParams.setMargins(0, -marginTop, 0, 0);
        iv_title_head_bg.setImageAlpha(0);

        // 为头部是View的界面设置状态栏透明
        StatusBarUtil.setTranslucentImageHeader(getActivity(), 0, toolbar);

        ViewGroup.LayoutParams imgItemBgparams = iv_bg.getLayoutParams();
        // 获得高斯图背景的高度
        imageBgHeight = imgItemBgparams.height;

        //设置progressBar的展示位置
        ViewGroup.MarginLayoutParams progressBarparams = (ViewGroup.MarginLayoutParams) progressBar.getLayoutParams();
        progressBarparams.setMargins(0,imageBgHeight+headerHeight,0,0);
        // 监听改变透明度
        initScrollViewListener();
    }

    private void initScrollViewListener() {
        // 为了兼容api23以下
        compatNestedScrollView.setScrollInterfaceListener(new CompatNestedScrollView.ScrollInterfaceListener() {
            @Override
            public void onScrollChange(int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                scrollChangeHeader(scrollY);
            }
        });

        //int titleBarAndStatusHeight = (int) (CommonUtil.getDimens(R.dimen.nav_bar_height) + getStatusBarHeight(this));
        slidingDistance = imageBgHeight - headerHeight;
    }

    /**
     * 根据页面滑动距离改变Header透明度方法
     */
    private void scrollChangeHeader(int scrolledY) {

        if (scrolledY < 0) {
            scrolledY = 0;
        }
        float alpha = Math.abs(scrolledY) * 1.0f / (slidingDistance);
        Drawable drawable = iv_title_head_bg.getDrawable();

        if (drawable != null) {
            if (scrolledY <= slidingDistance) {
                // title部分的渐变
                drawable.mutate().setAlpha((int) (alpha * 255));
                iv_title_head_bg.setImageDrawable(drawable);
                toolbar.setTitle("");
            } else {
                drawable.mutate().setAlpha(255);
                iv_title_head_bg.setImageDrawable(drawable);
                toolbar.setTitle(mMovieDetailsBean.getTitle());
            }
        }
    }

    private void setImgHeaderBg() {
        Glide.with(this).load(mImageUrl)
//              .placeholder(R.drawable.stackblur_default)
                .error(R.drawable.stackblur_default)
                .bitmapTransform(new BlurTransformation(getActivity(), 14, 3))// 设置高斯模糊
                .listener(new RequestListener<String, GlideDrawable>() {//监听加载状态
                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean
                            isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable>
                            target, boolean isFromMemoryCache, boolean isFirstResource) {
                        toolbar.setBackgroundColor(Color.TRANSPARENT);
                        iv_title_head_bg.setImageAlpha(0);
                        iv_title_head_bg.setVisibility(View.VISIBLE);
                        return false;
                    }
                }).into(iv_title_head_bg);
    }

    private void setPicture() {
        Glide.with(this)
                .load(mImageUrl)
                .centerCrop()
                .into(iv_image);

        // "14":模糊度；"3":图片缩放3倍后再进行模糊
        Glide.with(this)
                .load(mImageUrl)
                .error(R.drawable.stackblur_default)
                .placeholder(R.drawable.stackblur_default)
                .crossFade(500)
                .bitmapTransform(new BlurTransformation(getActivity(), 14, 3))
                .into(iv_bg);
    }

    private void setTitleBar() {
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (actionBar != null) {
            //去除默认Title显示
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.icon_back);


            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getActivity().onBackPressed();

                }
            });
        }
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        presenter.refresh(mMovieId);
    }

    @Override
    public void showError(String errorString) {

    }

    @Override
    public void showStory(MovieDetailsBean movieDetailsBean) {
        ll_content.setVisibility(View.VISIBLE);

        mMovieDetailsBean = movieDetailsBean;
        if (mMovieDetailsBean.getRating() != null) {
            float rate = (float) (mMovieDetailsBean.getRating().getAverage() / 2);
            ratingbar.setRating(rate);
            ratingnumber.setText(rate * 2 + "");
            ratings_count.setText(mMovieDetailsBean.getRatings_count() + "人");
        }
        //设置标题
        subject_title.setText(mMovieDetailsBean.getTitle());

        if (mMovieDetailsBean.getGenres() != null) {
            subject_genres.setText(mMovieDetailsBean.getYear()+"/");
            List<String> genres = mMovieDetailsBean.getGenres();
            StringUtil.addViewString(genres, subject_genres);
        }
        if (mMovieDetailsBean.getCountries() != null) {
            subject_countries.setText("上映国家:");
            List<String> countries = mMovieDetailsBean.getCountries();
            StringUtil.addViewString(countries, subject_countries);
        }
        if (mMovieDetailsBean.getAka() != null) {
            subject_aka.setText("原名:");
            List<String> aka = mMovieDetailsBean.getAka();
            StringUtil.addViewString(aka, subject_aka);
        }

        wish_count.setText(mMovieDetailsBean.getWish_count()+"人");
        reviews_count.setText(mMovieDetailsBean.getReviews_count()+"人");

        if (mMovieDetailsBean.getSummary() != null) {
            summary_title.setText("简介");
            summary.setText(mMovieDetailsBean.getSummary());
            summary_more.setText("更多");
            summary_more.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    summary.setSingleLine(false);
                    summary.setEllipsize(null);
                    summary_more.setText("");

                }
            });
        }

        actor_name.setText("影人");

        mActorAdapter.setDatas(mMovieDetailsBean);
        rv_actor.setVisibility(View.VISIBLE);
        rv_actor.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        rv_actor.setAdapter(mActorAdapter);

        mActorAdapter.setmListener(new OnItemClickLinkToListener() {
            @Override
            public void ItemClickListener(String id, String imgUrl) {

            }
        });


    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);

    }
}
