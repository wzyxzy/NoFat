package com.wzy.nofat.one_adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.wzy.nofat.R;
import com.wzy.nofat.adapters.TeachBaseAdapter;
import com.wzy.nofat.one_model.Model_List;

import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.util.List;

/**
 * Created by Administrator on 2016/4/12 0012.
 */
public class OneCanQianAdapter extends TeachBaseAdapter<Model_List> {


    public OneCanQianAdapter(List<Model_List> data, Context context, int layoutRes) {
        super(data, context, layoutRes);
    }
    ImageOptions imageOptions = new ImageOptions.Builder()
            //设置使用缓存

            .setUseMemCache(true)
            .build();

    @Override
    public void bindData(ViewHolder holder, Model_List model_list) {


        ImageView mImagview = ((ImageView) holder.getView(R.id.one_canqian_imageview));
        x.image().bind(mImagview, model_list.getPic(),imageOptions);

        TextView name = ((TextView) holder.getView(R.id.one_canqian_name));
        name.setText(model_list.getName());
        ImageView xingxing = ((ImageView) holder.getView(R.id.one_canqian_xingxing));
        switch (model_list.getLevel()){
            case 1:
                xingxing.setImageResource(R.mipmap.bcp_yixing);
                break;
            case 2:
                xingxing.setImageResource(R.mipmap.bcp_liangxing);

                break;
            case 3:
                xingxing.setImageResource(R.mipmap.bcp_sanxing);

                break;
            case 4:
                xingxing.setImageResource(R.mipmap.bcp_sixing);

                break;
            case 5:
                xingxing.setImageResource(R.mipmap.bcp_wuxing);

                break;
        }

    }
}
