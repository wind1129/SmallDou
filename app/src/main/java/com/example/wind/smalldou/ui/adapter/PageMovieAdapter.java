package com.example.wind.smalldou.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.wind.smalldou.R;
import com.example.wind.smalldou.mvp.model.bean.MovieBean;
import com.example.wind.smalldou.mvp.presenter.BasePresenter;

import java.util.List;

/**
 * Created by Wind1129 on 17/4/12.
 */

public class PageMovieAdapter extends BasePagerAdapter<MovieBean>{


    public PageMovieAdapter(Context context) {
        super(context);
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(mFooterView!=null && viewType == TYPE_FOOTER) {
            return new FooterViewHolder(mFooterView);
        }else{
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_base, parent, false);
            return new ItemViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        if(getItemViewType(position) == TYPE_FOOTER) return;
        ((ItemViewHolder)holder).item_name.setText(mDate.get(position).getTitle());
        ((ItemViewHolder)holder).item_num.setText(mDate.get(position).getRating().getAverage()+"");
        ((ItemViewHolder)holder).item_ratingbar.setRating((float)mDate.get(position).getRating().getAverage()/2);

        // 设置小星星的颜色(兼容低版本)
        LayerDrawable layerDrawable = (LayerDrawable) ((ItemViewHolder)holder).item_ratingbar.getProgressDrawable();
        layerDrawable.getDrawable(2).setColorFilter(Color.rgb(253,171,62), PorterDuff.Mode.SRC_ATOP);

        Glide.with(mContext)
                .load(mDate.get(position).getImages().getLarge())
                .into(((ItemViewHolder)holder).item_iv);

        if(mListener!=null){
            ((ItemViewHolder)holder).item_cardview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = holder.getLayoutPosition();
                    mListener.ItemClickListener(mDate.get(position).getId(),mDate.get(position).getImages().getLarge());
                }
            });
        }

    }

    class ItemViewHolder extends RecyclerView.ViewHolder{
        ImageView item_iv;
        TextView item_num;
        TextView item_name;
        RatingBar item_ratingbar;
        CardView item_cardview;

        public ItemViewHolder(View itemView) {
            super(itemView);
            item_iv = (ImageView) itemView.findViewById(R.id.item_iv);
            item_num = (TextView) itemView.findViewById(R.id.item_num);
            item_name = (TextView) itemView.findViewById(R.id.item_name);
            item_ratingbar = (RatingBar) itemView.findViewById(R.id.item_ratingbar);
            item_cardview = (CardView) itemView.findViewById(R.id.item_cardview);
        }
    }

    class FooterViewHolder extends RecyclerView.ViewHolder{

        public FooterViewHolder(View itemView) {
            super(itemView);
        }
    }
}
