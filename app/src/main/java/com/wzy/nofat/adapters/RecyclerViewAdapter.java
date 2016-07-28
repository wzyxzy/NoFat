package com.wzy.nofat.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.wzy.nofat.R;
import com.wzy.nofat.model.RecyclerViewModel;

import org.xutils.x;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 16-4-13.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> implements View.OnClickListener {

    private List<RecyclerViewModel> data;
    private LayoutInflater inflater;
    //申明RecyclerView的引用 目的是找到点击的条目的下标
    private RecyclerView recycleView;
    //借口的引用
    private SetOnClickListener onClickListener1;

    public RecyclerViewAdapter(List<RecyclerViewModel> data,Context context){
        inflater=LayoutInflater.from(context);
        if(data==null){
            this.data=new ArrayList<>();
        }else {
            this.data=data;
        }
    }

    public void addList(List<RecyclerViewModel> data){
        if(data!=null&&data.size()>0){
            this.data.clear();
            this.data.addAll(data);
            this.notifyDataSetChanged();
        }
    }
    //初始化ViewHolder,第二个参数是加载多布局的时候用到的
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=null;
        switch (viewType){
            case 1://更具不同的类型加载不同布局
                view=inflater.inflate(R.layout.fragment_two_wenda_one,parent,false);
                break;
            case 0://更具不同的类型加载不同布局
                view=inflater.inflate(R.layout.fragment_two_wenda_two,parent,false);
                break;
        }
        //由于RecyclerView没有点击事件，所以要给条目设置点击事件
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    //绑定数据源
    public void onBindViewHolder(ViewHolder holder, int position) {
        int type=getItemViewType(position);
        switch (type){
            case 1:
                ImageView iv= (ImageView) holder.getView(R.id.fragment_two_wenda_one_image);
                x.image().bind(iv, data.get(position).getPic());
                TextView tv= (TextView) holder.getView(R.id.fragment_two_wenda_one_text);
                tv.setText(data.get(position).getTname());
                break;
            case 0:
                ImageView iv1= (ImageView) holder.getView(R.id.fragment_two_wenda_two_image);
                x.image().bind(iv1, data.get(position).getPic());
                TextView tv1= (TextView) holder.getView(R.id.fragment_two_wenda_two_text);
                tv1.setText(data.get(position).getTname());
                break;
        }
    }

    public int getItemCount() {
        return data!=null?data.size():0;
    }

    //条目的点击事件
    public void onClick(View v) {
        //获取点击条目的下标
        int position=recycleView.getChildAdapterPosition(v);
        int id=data.get(position).getId();
        String title=data.get(position).getTname();
        if(onClickListener1!=null){
            onClickListener1.onItmemClick(id,title);
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        View itemView;
        private Map<Integer,View> map;
        public ViewHolder(View itemView) {
            super(itemView);
            this.itemView=itemView;
            map=new HashMap<>();
        }
        public View getView(int resId){
            View view=null;
            if(map.containsKey(resId)){
                view=map.get(resId);
            }else {
                view=itemView.findViewById(resId);
                map.put(resId,view);
            }
            return view;
        }
    }

    //更具下标获取itemViewType的类型
    public int getItemViewType(int position) {

        return data.get(position).getPosition();
    }

    //初始化RecyclerView，目的是找到点击的条目,依附
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.recycleView=recyclerView;
    }
    //剪除依附
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.recycleView=null;
    }

    //自己定义的点击事件，目的是把点击条目的位置给传到activity
    public interface SetOnClickListener{
        void onItmemClick(int id,String title);
    }

    //初始化借口的方法
    public void initView(SetOnClickListener onClickListener1){
        this.onClickListener1=onClickListener1;
    }
}
