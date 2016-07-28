package com.wzy.nofat.one_adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.wzy.nofat.R;
import com.wzy.nofat.adapters.TeachBaseAdapter;
import com.wzy.nofat.one_model.Model;
import com.wzy.nofat.one_model.ModelTwo;

import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.util.List;

/**
 * Created by Administrator on 2016/4/12 0012.
 */

//zhe
// 此为文章布局的GridView的适配器
public class Adapter_GridView_WenZhang extends TeachBaseAdapter<Model> {
    private ImageOptions options = new ImageOptions.Builder()
            .setFadeIn(true)
            .setCrop(true)
            .setLoadingDrawableId(R.mipmap.ic_launcher)//加载中默认显示图片
            .setUseMemCache(true)

            .setFailureDrawableId(R.mipmap.ic_launcher)//加载失败后默认显示图片
            .build();

    public Adapter_GridView_WenZhang(List<Model> data, Context context, int layoutRes) {
        super(data, context, layoutRes);
    }


    @Override
    public void bindData(ViewHolder holder, Model model) {


        ImageView mImageView = ((ImageView) holder.getView(R.id.one_wenzhang_image));
        x.image().bind(mImageView,model.getImgS(),options);

        TextView textView = ((TextView) holder.getView(R.id.one_wenzhang_textview));
        textView.setText(model.getTitle());

    }
}
