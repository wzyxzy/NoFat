package com.wzy.nofat.adapters;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.wzy.nofat.R;
import com.wzy.nofat.model.TwoFragmentTitleModel;

import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.util.List;

/**
 * Created by Administrator on 16-4-12.
 */
public class TwoFragmentTitleAdapter extends TeachBaseAdapter<TwoFragmentTitleModel>{
    private ImageOptions imageOptions;
    public TwoFragmentTitleAdapter(List<TwoFragmentTitleModel> data, Context context, int layoutRes) {
        super(data, context, layoutRes);
        imageOptions=new ImageOptions.Builder().setUseMemCache(true).build();
    }

    @Override
    public void bindData(ViewHolder holder, TwoFragmentTitleModel twoFragmentTitleModel) {
        TextView tv = ((TextView) holder.getView(R.id.fragemtn_two_view_layout_data_text));
        tv.setText(twoFragmentTitleModel.getTitle());

        ImageView imageView = ((ImageView) holder.getView(R.id.fragemtn_two_view_layout_data_image));
        x.image().bind(imageView,twoFragmentTitleModel.getImgS(),imageOptions);
    }
}
