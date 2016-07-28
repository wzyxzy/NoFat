package com.wzy.nofat.one_fragment;


        import android.content.Intent;
        import android.os.Bundle;
        import android.support.v4.app.Fragment;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.AdapterView;
        import android.widget.GridView;
        import android.widget.LinearLayout;
        import android.widget.ListView;
        import android.widget.TextView;

        import com.google.gson.Gson;
        import com.google.gson.reflect.TypeToken;
        import com.wzy.nofat.R;
        import com.wzy.nofat.one_activity.TiaoZhanActivity;
        import com.wzy.nofat.one_activity.TiaoZhuan_WenZhang_Activity;
        import com.wzy.nofat.one_adapter.Adapter_GridView_WenZhang;
        import com.wzy.nofat.one_adapter.OneCanQianAdapter;
        import com.wzy.nofat.one_adapter.OneFanHouAdapter;
        import com.wzy.nofat.one_model.Model;
        import com.wzy.nofat.one_model.Model_List;

        import org.json.JSONArray;
        import org.json.JSONException;
        import org.json.JSONObject;
        import org.xutils.common.Callback;
        import org.xutils.http.RequestParams;
        import org.xutils.image.ImageOptions;
        import org.xutils.x;

        import java.lang.reflect.Type;
        import java.util.ArrayList;
        import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_biechipang extends Fragment implements AdapterView.OnItemClickListener {
    private final static String URL = "http://bcp.525happy.com/index?version=510&appkey=10001&androidIos=1";
    public static final String TAG = Fragment_biechipang.class.getSimpleName();
    private View layout;
//    private int [] layouts = {R.layout.one_bcp_type00,R.layout.one_bcp_type0};
    private List<Model_List> data= new ArrayList<>();
    private GridView mGrideView;
    private Adapter_GridView_WenZhang gvadapter;
    private List<Model> twoData;
    private GridView canqianGridView;
    private OneCanQianAdapter canqiangadapter;
    private OneFanHouAdapter fanhouadapter;

    private List<Model_List> dataone;
    private List<Model_List> datatwo;

    public Fragment_biechipang() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        layout  = inflater.inflate(R.layout.fragment_fragment_biechipang, container, false);
        initView();
        initData();
        return layout;
    }



    private void initView() {

       //文章处的数据源
        twoData = new ArrayList<>();
        Log.e(TAG, "twoData" + twoData);
        //文章处gridview
        mGrideView = ((GridView) layout.findViewById(R.id.one_wenzhang_gridview));
        gvadapter = new Adapter_GridView_WenZhang(null,getActivity(),R.layout.one_grideview_wenzhang_items);
        mGrideView.setAdapter(gvadapter);
        mGrideView.setOnItemClickListener(this);



        //设置餐前预防的gridview
        GridView mGridView = ((GridView) layout.findViewById(R.id.one_canqian_gridview));
        canqiangadapter = new OneCanQianAdapter(null,getActivity(),R.layout.one_canqian_gridview_items);
//        canqiangadapter.updateRes(dataone);
        mGridView.setAdapter(canqiangadapter);
        mGridView.setOnItemClickListener(this);





    }

    /**
     * 此方法用于数据的下载
     */
    private void  initData() {



        Log.e(TAG,"测试44444444444444444444444444444444444444444444");

        RequestParams request = new RequestParams(URL);
        x.http().get(request, new Callback.CommonCallback<String>() {

            private TextView mTwoTextView;

            @Override
            public void onSuccess(String result) {
                Log.e(TAG,"result"+result);

                try {
                    JSONArray jsonArraytwo =  new JSONObject(result).getJSONArray("thinArtical");
                    Type typetwo = new  TypeToken<List<Model>>(){}.getType();
                    Gson gsontwo = new Gson();
                    twoData = gsontwo.fromJson(jsonArraytwo.toString(), typetwo);
                    gvadapter.updateRes(twoData);
                    Log.e(TAG, "twoData" + twoData);


                    JSONArray jsonArray = new JSONObject(result).getJSONObject("mealplan").getJSONArray("stufflist");
                    Type type = new TypeToken<List<Model_List>>(){}.getType();
                    Gson gson = new Gson();
                     data = gson.fromJson(jsonArray.toString(), type);

                     dataone = new ArrayList<>();

                     datatwo = new ArrayList<>();
                    for (int i = 0;i<data.size();i++){

                        if (data.get(i).getEatTime() %2 == 0){
                            dataone.add(data.get(i));
                        }else {
                            datatwo.add(data.get(i));
                        }
                    }
                    canqiangadapter.updateRes(datatwo);

                    //设置餐前预防的gridview
//                    GridView mGridView = ((GridView) layout.findViewById(R.id.one_canqian_gridview));
//                    canqiangadapter = new OneCanQianAdapter(null,getActivity(),R.layout.one_canqian_gridview_items);
//                    mGridView.setAdapter(canqiangadapter);

                    //设置餐后消脂的gridview
                    if (datatwo.size() != 0 ){
                    mTwoTextView = ((TextView) layout.findViewById(R.id.fanhou_text_one));
                    mTwoTextView.setText("餐后消脂");
                    GridView TwoGridView = ((GridView) layout.findViewById(R.id.one_fanhou_gridview));
                    fanhouadapter = new OneFanHouAdapter(null,getActivity(),R.layout.one_fanhou_gridview_items);
                    fanhouadapter.updateRes(dataone);
                    TwoGridView.setAdapter(fanhouadapter);
                     TwoGridView.setOnItemClickListener(Fragment_biechipang.this);


                    }

                    Log.e(TAG,"DATA-----------------------"+data);


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

//gridview的监听事件
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        switch (parent.getId()) {
            //第一个gridview
            case R.id.one_canqian_gridview:
                switch (position) {
                    case 0:
                        Intent intentone = new Intent(getActivity(), TiaoZhanActivity.class);
                        Bundle bundleone = new Bundle();
                        int one = datatwo.get(position).getSid();
                        Log.e(TAG, "a==========================" + one);
                        bundleone.putInt("key", one);
                        intentone.putExtras(bundleone);
                        startActivityForResult(intentone, 0);
                        break;
                    case 1:
                        Intent intenttwo = new Intent(getActivity(), TiaoZhanActivity.class);
                        Bundle bundletwo = new Bundle();
                        int two = datatwo.get(position).getSid();
                        Log.e(TAG, "a==========================" + two);
                        bundletwo.putInt("key", two);
                        intenttwo.putExtras(bundletwo);
                        startActivityForResult(intenttwo, 0);

                        break;

                    case 2:
                        Intent intentthree = new Intent(getActivity(), TiaoZhanActivity.class);
                        Bundle bundlethree = new Bundle();
                        int three = datatwo.get(position).getSid();
                        Log.e(TAG, "a==========================" + three);
                        bundlethree.putInt("key", three );
                        intentthree.putExtras(bundlethree);
                        startActivityForResult(intentthree, 0);

                        break;



                }
                break;
            //第二个gridview
            case R.id.one_fanhou_gridview:
                switch (position) {
                    case 0:
                        Intent canhouintent = new Intent(getActivity(), TiaoZhanActivity.class);
                        Bundle canhoubundle = new Bundle();
                        int danhouone = dataone.get(position).getSid();
                        Log.e(TAG, "a==========================" + danhouone);
                        canhoubundle.putInt("key", danhouone);
                        canhouintent.putExtras(canhoubundle);
                        startActivity(canhouintent);
                        break;
                    case 1:
                        Intent canhouintenttwo = new Intent(getActivity(), TiaoZhanActivity.class);
                        Bundle canhoubundletwo = new Bundle();
                        int danhoutwo = dataone.get(position).getSid();
                        Log.e(TAG, "a==========================" + danhoutwo);
                        canhoubundletwo.putInt("key", danhoutwo);
                        canhouintenttwo.putExtras(canhoubundletwo);
                        startActivity(canhouintenttwo);
                        break;

                    case 2:
                        Intent intentone = new Intent(getActivity(), TiaoZhanActivity.class);
                        Bundle bundleone = new Bundle();
                        int one = datatwo.get(position).getSid();
                        Log.e(TAG, "a==========================" + one);
                        bundleone.putInt("key", one);
                        intentone.putExtras(bundleone);
                        startActivityForResult(intentone, 0);

                        break;
                }
                break;
            case R.id.one_wenzhang_gridview:
                switch (position){
                    case 0:
                        Intent intentone = new Intent(getActivity(), TiaoZhuan_WenZhang_Activity.class);
                        Bundle bundleone = new Bundle();
                        int one = twoData.get(position).getId();
                        Log.e(TAG, "a==========================" + one);
                        bundleone.putInt("key", one);
                        intentone.putExtras(bundleone);
                        startActivityForResult(intentone, 0);
                        break;
                    case 1:
                        Intent intenttwo = new Intent(getActivity(), TiaoZhuan_WenZhang_Activity.class);
                        Bundle bundletwo = new Bundle();
                        int two = twoData.get(position).getId();
                        Log.e(TAG, "a==========================" + two);
                        bundletwo.putInt("key", two);
                        intenttwo.putExtras(bundletwo);
                        startActivityForResult(intenttwo, 0);

                        break;
                    case 2:
                        Intent intentthree = new Intent(getActivity(), TiaoZhuan_WenZhang_Activity.class);
                        Bundle bundlethree = new Bundle();
                        int three = twoData.get(position).getId();
                        Log.e(TAG, "a==========================" + three);
                        bundlethree.putInt("key", three);
                        intentthree.putExtras(bundlethree);
                        startActivityForResult(intentthree, 0);


                        break;
                    case 3:
                        Intent intentfour = new Intent(getActivity(), TiaoZhuan_WenZhang_Activity.class);
                        Bundle bundlefour = new Bundle();
                        int four = twoData.get(position).getId();
                        Log.e(TAG, "a==========================" + four);
                        bundlefour.putInt("key", four);
                        intentfour.putExtras(bundlefour);
                        startActivityForResult(intentfour, 0);


                        break;

                }
                break;


        }
    }
}
