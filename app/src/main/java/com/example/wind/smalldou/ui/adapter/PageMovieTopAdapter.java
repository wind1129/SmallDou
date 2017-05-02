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

/**
 * Created by Wind1129 on 17/4/20.
 */

public class PageMovieTopAdapter extends BasePagerAdapter<MovieBean> {


    public PageMovieTopAdapter(Context context) {
        super(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(mFooterView!=null && viewType == TYPE_FOOTER) {
            return new PageMovieTopAdapter.FooterViewHolder(mFooterView);
        }else {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_top, parent, false);
            return new PageMovieTopAdapter.ItemViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        if(getItemViewType(position) == TYPE_FOOTER) return;
        PageMovieTopAdapter.ItemViewHolder itemHolder = (PageMovieTopAdapter.ItemViewHolder) holder;
        itemHolder.item_tv_brief.setText("");
        Glide.with(mContext)
                .load(mDate.get(position).getImages().getLarge())
                .into(itemHolder.item_iv_img);
        itemHolder.item_title.setText(mDate.get(position).getTitle());
        itemHolder.item_tv_num.setText(position+1+"");
        itemHolder.item_tv_ratingnum.setText(mDate.get(position).getRating().getAverage() + "");
        itemHolder.item_ratingbar.setRating((float) mDate.get(position).getRating().getAverage() / 2);
        // 设置小星星的颜色(兼容低版本)
        LayerDrawable layerDrawable = (LayerDrawable)itemHolder.item_ratingbar.getProgressDrawable();
        layerDrawable.getDrawable(2).setColorFilter(Color.rgb(253,171,62), PorterDuff.Mode.SRC_ATOP);

        /**
         * 上映时间
         */
        if (!mDate.get(position).getYear().trim().equals("")) {
            itemHolder.item_tv_brief.append("上映时间：");
            itemHolder.item_tv_brief.append(mDate.get(position).getYear() + "\n");
        }
        /**
         * 导演信息
         */
        if (mDate.get(position).getDirectors() != null) {
            itemHolder.item_tv_brief.append("导演：");
            for (int i = 0; i < mDate.get(position).getDirectors().size(); i++) {

                if (i == mDate.get(position).getDirectors().size() - 1) {
                    itemHolder.item_tv_brief.append(mDate.get(position).getDirectors().get(i).getName());
                } else {
                    itemHolder.item_tv_brief.append(mDate.get(position).getDirectors().get(i).getName() + "/");
                }
            }

            itemHolder.item_tv_brief.append("\n");

        }
        /**
         * 演员信息
         */
        if (mDate.get(position).getCasts() != null) {
            itemHolder.item_tv_brief.append("演员：");
            for (int i = 0; i < mDate.get(position).getCasts().size(); i++) {
                if (i == mDate.get(position).getCasts().size()-1) {
                    itemHolder.item_tv_brief.append(mDate.get(position).getCasts().get(i).getName());
                } else {
                    itemHolder.item_tv_brief.append(mDate.get(position).getCasts().get(i).getName() + "/");
                }
            }

            itemHolder.item_tv_brief.append("\n");
        }
        /**
         * 类型信息
         */
        if (mDate.get(position).getCasts() != null) {
            itemHolder.item_tv_brief.append("类型：");
            for (int i = 0; i < mDate.get(position).getGenres().size(); i++) {
                if (i == mDate.get(position).getGenres().size() - 1) {
                    itemHolder.item_tv_brief.append(mDate.get(position).getGenres().get(i));
                } else {
                    itemHolder.item_tv_brief.append(mDate.get(position).getGenres().get(i) + "/");
                }
            }
            itemHolder.item_tv_brief.append("\n");
        }


        if(mListener!=null){
            itemHolder.item_cardview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = holder.getLayoutPosition();
                    mListener.ItemClickListener(mDate.get(position).getId(),mDate.get(position).getImages().getLarge());
                }
            });
        }
        

    }


    class ItemViewHolder extends RecyclerView.ViewHolder{
        TextView item_tv_num;
        ImageView item_iv_img;
        TextView item_title;
        RatingBar item_ratingbar;
        TextView item_tv_ratingnum;
        TextView item_tv_brief;
        CardView item_cardview;

        public ItemViewHolder(View itemView) {
            super(itemView);
            item_tv_num = (TextView) itemView.findViewById(R.id.item_tv_num);
            item_iv_img= (ImageView) itemView.findViewById(R.id.item_iv_img);
            item_title= (TextView) itemView.findViewById(R.id.item_title);
            item_ratingbar= (RatingBar) itemView.findViewById(R.id.item_ratingbar);
            item_tv_ratingnum= (TextView) itemView.findViewById(R.id.item_tv_ratingnum);
            item_tv_brief= (TextView) itemView.findViewById(R.id.item_tv_brief);
            item_cardview= (CardView) itemView.findViewById(R.id.item_cardview);

        }


    }

    class FooterViewHolder extends RecyclerView.ViewHolder{

        public FooterViewHolder(View itemView) {
            super(itemView);
        }
    }
}
