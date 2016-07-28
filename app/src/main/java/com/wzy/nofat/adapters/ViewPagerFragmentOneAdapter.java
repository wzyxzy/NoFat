package com.wzy.nofat.adapters;

import android.content.Context;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.wzy.nofat.R;
import com.wzy.nofat.model.TwoFragmentModel;

import org.xutils.common.util.DensityUtil;
import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.util.List;

/**
 * Created by Administrator on 16-4-11.
 */
public class ViewPagerFragmentOneAdapter extends TeachBaseAdapter<TwoFragmentModel>{
    private ImageOptions options;
    public ViewPagerFragmentOneAdapter(List<TwoFragmentModel> data, Context context, int layoutRes) {
        super(data, context, layoutRes);
        options=new ImageOptions.Builder()
                .setUseMemCache(true)
                //设置图片渐变
                .setFadeIn(true)
                 //设置加载失败
                .setFailureDrawableId(R.mipmap.ic_launcher)
                 //设置动画
                .setAnimation(AnimationUtils.loadAnimation(context, R.anim.image))
                .build();
    }

    public void bindData(ViewHolder holder, TwoFragmentModel twoFragmentModel) {
        TextView tv= (TextView) holder.getView(R.id.fragemtn_two_view_layout_data_text);

        tv.setText(twoFragmentModel.getTitle());

        ImageView iv= (ImageView) holder.getView(R.id.fragemtn_two_view_layout_data_image);

        x.image().bind(iv,twoFragmentModel.getImg(),options);

    }
}
