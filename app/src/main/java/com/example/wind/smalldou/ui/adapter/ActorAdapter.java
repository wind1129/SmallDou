package com.example.wind.smalldou.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.wind.smalldou.R;
import com.example.wind.smalldou.interfaces.OnItemClickLinkToListener;
import com.example.wind.smalldou.mvp.model.bean.CastsBean;
import com.example.wind.smalldou.mvp.model.bean.DirectorsBean;
import com.example.wind.smalldou.mvp.model.bean.MovieDetailsBean;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Wind1129 on 17/4/17.
 */

public class ActorAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public Context mContext;
    private MovieDetailsBean mdata;

    /**
     * 点击监听
     */
    public OnItemClickLinkToListener mListener;

    public void setmListener(OnItemClickLinkToListener listener) {
        this.mListener = listener;
    }

    public ActorAdapter(Context mContext) {
        this.mContext = mContext;
    }


    public void setDatas(MovieDetailsBean movieDetailsBean) {
        mdata = movieDetailsBean;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_actor,parent,false);
        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ItemHolder itemHolder = (ItemHolder) holder;
        if (mdata.getDirectors()!=null && position < mdata.getDirectors().size()) {
            if (mdata.getDirectors().get(position).getAvatars() != null) {
                DirectorsBean directorsBean = mdata.getDirectors().get(position);
                Glide.with(mContext)
                        .load(directorsBean.getAvatars().getLarge())
                        .into(itemHolder.item_iv);
                itemHolder.item_actor.setText(directorsBean.getName());
                itemHolder.item_director.setText("导演");
            }
        }else{
            position -= mdata.getDirectors().size();
            if (mdata.getCasts().get(position).getAvatars()  != null) {
                final CastsBean castsBean = mdata.getCasts().get(position);

                Glide.with(mContext)
                        .load(castsBean.getAvatars().getLarge())
                        .into(itemHolder.item_iv);
                itemHolder.item_actor.setText(castsBean.getName());
                itemHolder.item_director.setText("");

                if(mListener!=null) {
                    itemHolder.item_iv.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mListener.ItemClickListener(castsBean.getId(),castsBean.getAvatars().getLarge());

                        }
                    });
                }
            }

        }

    }

    @Override
    public int getItemCount() {
        int i = 0;
        if (mdata.getCasts() != null) {
            i += mdata.getCasts().size();
        }
        if (mdata.getDirectors() != null) {
            i += mdata.getDirectors().size();
        }
        return i;
    }


    class ItemHolder extends RecyclerView.ViewHolder {
        ImageView item_iv;
        TextView item_actor;
        TextView item_director;

        public ItemHolder(View itemView) {
            super(itemView);
            item_iv = (ImageView) itemView.findViewById(R.id.item_iv);
            item_actor = (TextView) itemView.findViewById(R.id.item_actor);
            item_director = (TextView) itemView.findViewById(R.id.item_director);
        }
    }
}
