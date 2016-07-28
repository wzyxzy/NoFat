package com.wzy.nofat.one_adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Rock on 2016/3/16.
 */
public abstract class OneTextBaseAdapter<T> extends BaseAdapter {

    private List<T> data;
    // 布局导入器
    private LayoutInflater inflater;
    // 子布局的layout id，放到一个数组里面
    private int[] layouts;
    // R.layout.item1   R.layout.items2
    public OneTextBaseAdapter(Context context, List<T> data, int... layouts){
        this.layouts = layouts;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (data ==  null){
            this.data = new ArrayList<>();
        }else{
            this.data = data;
        }
    }

    public void addRes(List<T> data){
        if (data != null && data.size() > 0){
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }

    public void updateRes(List<T> data){
        if (data != null && data.size() > 0){
            this.data.clear();
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }

    @Override
    public int getCount() {
        return data != null ? data.size() : 0;
    }

    @Override
    public T getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     *  根据position获取对应数据的布局类型,int型，要求0.1.2.3...
     *
     *  class.getDeclaredField（"type"） 根据type，获取class中的字段, getDeclaredField可获取私有字段
     *  field.setAccessible（true）将字段设置权限，可获取私有属性
     *  field.getInt(object) 获取object中对应字段的int值
     *
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        // 顶一个默认类型
        int type = 0;
        // 获取指定位置对应的数据
        T t = getItem(position);
        // 获取类对应的class
        Class<?> cls = t.getClass();
        try {
            // 根据字段名获取指定字段
            Field field = cls.getDeclaredField("type");
            // 设置权限，可获取私有字段
            field.setAccessible(true);
            // 获取字段中的值
            type = field.getInt(t);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return type;
    }

    /**
     * 获取多布局的布局种类数
     * @return
     */
    @Override
    public int getViewTypeCount() {
        // 我们传递进来几种布局，就有多少种布局
        return layouts.length;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null){
            // 需要实例化,layout id 需要根据不同的type来进行加载
            // 根据位置获取对应的ViewType
            int viewType = getItemViewType(position);
            // 根据ViewType去获取对应的布局
            int layoutRes = layouts[viewType];
            // 导入布局
            convertView = inflater.inflate(layoutRes,parent,false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        // 数据加载

        bindData(holder,getItem(position));

        return convertView;
    }

    public abstract void bindData(ViewHolder holder,T t);

    public static class ViewHolder{

        private View layout;

        private Map<Integer,View> cacheView;

        public ViewHolder(View convertView){
            layout = convertView;
            cacheView = new HashMap<>();
        }

        public View getView(int resId){
            View view = null;
            if (cacheView.containsKey(resId)){
                view = cacheView.get(resId);
            }else{
                view = layout.findViewById(resId);
                cacheView.put(resId,view);
            }
            return view;
        }
    }
}
