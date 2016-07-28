package com.wzy.nofat.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.wzy.nofat.R;
import com.wzy.nofat.one_fragment.Fragment_biechipang;
import com.wzy.nofat.one_fragment.Fragment_jianzhiqu;

import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentOne extends Fragment implements RadioGroup.OnCheckedChangeListener, View.OnClickListener, PopupWindow.OnDismissListener {
    private static final String TAG = FragmentOne.class.getSimpleName();
    private View layout;
    private Fragment [] fragments;
    private RadioGroup mRadioGroup;
    private TextView dayofsolar;
    private String URL = "http://bcp.525happy.com/index?version=510&appkey=10001&androidIos=1";
    private TextView denglu;
    private PopupWindow popupWindow;

    public FragmentOne() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      layout = inflater.inflate(R.layout.fragment_fragment_one, container, false);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        fragments = new Fragment[]{
               new  Fragment_biechipang(),
                new Fragment_jianzhiqu()
        };

        if (savedInstanceState != null){
            for (int i = 0;i < fragments.length;i++){
                fragments[i] = fragmentManager.findFragmentByTag("fragment"+i);
            }
        }else {
            for (int i = 0; i<fragments.length;i++){
                transaction.add(R.id.one_frame_layout,fragments[i],"fragment"+i);
                transaction.hide(fragments[i]);

            }
            transaction.show(fragments[0]);
            transaction.commit();

        }
        //设置为选中状态
       RadioButton biechipang = ((RadioButton) layout.findViewById(R.id.one_rb_biechipang));
        biechipang.setChecked(true);
        initView();
        return layout;
    }

    private void initView() {
        denglu = ((TextView) layout.findViewById(R.id.one_denglu));




        denglu.setOnClickListener(this);
        mRadioGroup = ((RadioGroup) layout.findViewById(R.id.one_radiogroup));
        mRadioGroup.setOnCheckedChangeListener(this);
        dayofsolar = ((TextView) layout.findViewById(R.id.one_day));

        RequestParams requestParams = new RequestParams(URL);
        x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                try {
                    String day = new JSONObject(result).getString("dayofsolar");
                    dayofsolar.setText(day);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });


    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        int indext = 0;
        switch (checkedId){
            case R.id.one_rb_biechipang:
                indext = 0;
                break;
            case R.id.one_rb_jianzhiqu:
                indext = 1;
                break;
        }
        for (int i = 0; i<fragments.length;i++){
            transaction.hide(fragments[i]);
            if (i == indext){
                transaction.show(fragments[i]);
            }
        }
        transaction.commit();
    }

    @Override
    public void onClick(View v) {
        Log.e(TAG,"bvbbbbbbbbbbbbbbbbbbbbbbbbbbb");
        switch (v.getId()){
            case R.id.one_denglu:
        if (popupWindow == null){
            Log.e(TAG,"aaaaaaaaaaaaaaaaaaaaaaaaaaaa");
            popupWindow= new PopupWindow(getActivity());
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.loading_items,null);
            popupWindow.setContentView(view);
            popupWindow.setHeight(600);
            popupWindow.setWidth(LinearLayout.LayoutParams.MATCH_PARENT);
            //设置界面以外可点
            popupWindow.setAnimationStyle(0);
            popupWindow.setOutsideTouchable(true);
            popupWindow.setOnDismissListener(this);
            popupWindow.showAsDropDown(denglu);

            }else {
            if (popupWindow.isShowing()){
                popupWindow.dismiss();
            }else {
                popupWindow.showAsDropDown(denglu);

            }

        }
        break;
        }
    }

    @Override
    public void onDismiss() {

    }
}
