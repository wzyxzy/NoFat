package com.wzy.nofat.adapters;

import android.content.Context;
import android.webkit.WebView;
import android.widget.TextView;

import com.wzy.nofat.R;
import com.wzy.nofat.model.TwoFragmentData;


import java.util.List;

/**
 * Created by Administrator on 16-4-12.
 */
public class FragmentTwoData extends TeachBaseAdapter<TwoFragmentData> {
    public FragmentTwoData(List<TwoFragmentData> data, Context context, int layoutRes) {
        super(data, context, layoutRes);
    }

    @Override
    public void bindData(ViewHolder holder, TwoFragmentData twoFragmentData) {
        TextView tvTitle= (TextView) holder.getView(R.id.activity_fragment_two_title);
        TextView tvDesc= (TextView) holder.getView(R.id.activity_fragment_two_desc);
        WebView webView= (WebView) holder.getView(R.id.activity_fragment_two_data_webView);


        tvDesc.setText(twoFragmentData.getDesc());
        tvTitle.setText(twoFragmentData.getTitle());
        webView.loadUrl(twoFragmentData.getContent());
    }
}
