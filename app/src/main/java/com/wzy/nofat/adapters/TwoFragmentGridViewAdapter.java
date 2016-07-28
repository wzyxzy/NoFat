package com.wzy.nofat.adapters;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.wzy.nofat.R;
import com.wzy.nofat.model.TwoFragmentGridData;

import org.xutils.common.util.DensityUtil;
import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 16-4-12.
 */
public class TwoFragmentGridViewAdapter extends BaseAdapter implements View.OnClickListener {
    private List<TwoFragmentGridData> data;
    private int layout;
    private LayoutInflater inflater;
    //借口的引用
    private OnClickListenerImageView onClickListenerImageView;

    private ImageOptions options;
    public TwoFragmentGridViewAdapter(Context context,List<TwoFragmentGridData> data,
                                      int layout,OnClickListenerImageView onClickListenerImageView){
        this.inflater=LayoutInflater.from(context);
        this.layout=layout;
        this.onClickListenerImageView=onClickListenerImageView;
        if(data==null){
            this.data=new ArrayList<>();
        }else {
            this.data=data;
        }

        options=new ImageOptions.Builder()

                .setUseMemCache(true)
                //设置图片渐变
                .setFadeIn(true)
                //设置加载失败
                .setFailureDrawableId(R.mipmap.ic_launcher)
                // TODO :设置圆角,它不能单独使用，必须和下面的方形属性配合使用
                .setRadius(DensityUtil.px2dip(20))
                 //设置圆角的时候必须设置 方形属性 下面就是方形属性
                .setSquare(true)
                //设置动画
                .setAnimation(AnimationUtils.loadAnimation(context,R.anim.image))
                .build();
    }

    public void addRes(List<TwoFragmentGridData> data) {
        if (data != null && data.size() > 0) {
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }
    public int getCount() {
        return data!=null?data.size():0;
    }

    public TwoFragmentGridData getItem(int position) {
        return data.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh;
        if(convertView==null){
            convertView=inflater.inflate(layout,parent,false);
            vh=new ViewHolder();
            vh.iv= (ImageView) convertView.findViewById(R.id.fragment_two_view_layout_ivone);
            vh.tv= (TextView) convertView.findViewById(R.id.fragment_two_view_layout_tvone);
            convertView.setTag(vh);
        }else {
            vh= (ViewHolder) convertView.getTag();
        }
        vh.tv.setText(getItem(position).getTitle());
        x.image().bind(vh.iv, getItem(position).getImgm(),options);
        //给图片设置点击事件
        vh.iv.setOnClickListener(this);
        //把点击的位置给传过来
        vh.iv.setTag(position);
        return convertView;
    }
    private static class ViewHolder{
        ImageView iv;
        TextView tv;
    }

    public void onClick(View v) {
        int position= (int) v.getTag();
        switch (v.getId()){
            case R.id.fragment_two_view_layout_ivone:
                if(onClickListenerImageView!=null){
                    onClickListenerImageView.onClick(position);
                }
                break;
        }
    }

    //写一个借口，把位置给传回去
    public interface OnClickListenerImageView{
        void onClick(int position);
    }
}
