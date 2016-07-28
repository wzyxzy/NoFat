package com.wzy.nofat.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.wzy.nofat.R;
import com.wzy.nofat.activitys.GotoWebView;
import com.wzy.nofat.model.Three_Info_Web;
import com.wzy.nofat.model.Tikongcan;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zy on 2016/4/12.
 */
public class ThreeAdapter extends RecyclerView.Adapter<ThreeAdapter.ViewHolder> {
    private List<Tikongcan.PromptListEntity> promptListEntities;
    private List<Tikongcan.StuffListEntity> stuffListEntities;
    private List<Tikongcan.RecipeListEntity> recipeListEntities;
    private LayoutInflater inflater;
    private String url;

    public ThreeAdapter(Context context, List<Tikongcan.PromptListEntity> promptListEntities, List<Tikongcan.StuffListEntity> stuffListEntities, List<Tikongcan.RecipeListEntity> recipeListEntities) {
        this.promptListEntities = promptListEntities;
        this.stuffListEntities = stuffListEntities;
        this.recipeListEntities = recipeListEntities;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void updateRes(List<Tikongcan.PromptListEntity> promptListEntities, List<Tikongcan.StuffListEntity> stuffListEntities, List<Tikongcan.RecipeListEntity> recipeListEntities) {
        if (promptListEntities != null && stuffListEntities != null && recipeListEntities != null) {
            this.promptListEntities.clear();
            this.stuffListEntities.clear();
            this.recipeListEntities.clear();
            this.promptListEntities.addAll(promptListEntities);
            this.stuffListEntities.addAll(stuffListEntities);
            this.recipeListEntities.addAll(recipeListEntities);
            notifyDataSetChanged();
        }
    }

    @Override
    public ThreeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = null;
        switch (viewType) {
            case 1:
                itemView = inflater.inflate(R.layout.three_prompt_item, parent, false);
                break;
            case 2:
                itemView = inflater.inflate(R.layout.three_stuff_item, parent, false);
                break;
            case 3:
                itemView = inflater.inflate(R.layout.three_recipe_item, parent, false);
                break;

        }

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ThreeAdapter.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        final List<Tikongcan.StuffListEntity> stuffListEntities1;
        List<Tikongcan.RecipeListEntity> recipeListEntities1;
        switch (itemViewType) {
            case 1:
//

                holder.text.setText(promptListEntities.get(position / 4).getContent());
                switch (promptListEntities.get(position / 4).getEatTime()) {
                    case 1:
                        holder.image1.setImageResource(R.mipmap.tiko_item_icon_0003);
                        holder.image2.setImageResource(R.mipmap.tiko_item_text_0003_good_morning);
                        holder.layout.setBackgroundResource(R.drawable.tiko_item_bg_0003);
                        break;
                    case 2:
                        holder.image1.setImageResource(R.mipmap.tiko_item_icon_0002);
                        holder.image2.setImageResource(R.mipmap.tiko_item_text_0002_good_afternoon);
                        holder.layout.setBackgroundResource(R.drawable.tiko_item_bg_0002);

                        break;
                    case 3:
                        holder.image1.setImageResource(R.mipmap.tiko_item_icon_0001);
                        holder.image2.setImageResource(R.mipmap.tiko_item_text_0001_good_evening);
                        holder.layout.setBackgroundResource(R.drawable.tiko_item_bg_0001);

                        break;
                    case 4:
                        holder.image1.setImageResource(R.mipmap.tiko_item_icon_0000);
                        holder.image2.setImageResource(R.mipmap.tiko_item_text_0000);
                        holder.layout.setBackgroundResource(R.drawable.tiko_item_bg_0000);

                        break;
                }
                break;
            case 2:
                stuffListEntities1 = new ArrayList<>();
                switch (position) {
                    case 1:
                        holder.t1.setText("餐");
                        holder.t2.setText("前");
                        holder.t3.setText("预");
                        holder.t4.setText("防");
                        stuffListEntities1.add(stuffListEntities.get(0));
                        stuffListEntities1.add(stuffListEntities.get(1));
                        stuffListEntities1.add(stuffListEntities.get(2));
                        holder.h1.setBackgroundResource(R.color.colorGreen);
                        holder.v1.setBackgroundResource(R.color.colorGreen);
                        holder.circle1.setBackgroundResource(R.mipmap.tiko_item_circle_0003);
                        break;
                    case 3:
                        holder.t1.setText("餐");
                        holder.t2.setText("后");
                        holder.t3.setText("消");
                        holder.t4.setText("脂");
                        stuffListEntities1.add(stuffListEntities.get(3));
                        stuffListEntities1.add(stuffListEntities.get(4));
                        stuffListEntities1.add(stuffListEntities.get(5));
                        holder.h1.setBackgroundResource(R.color.colorGreen);
                        holder.v1.setBackgroundResource(R.color.colorGreen);
                        holder.circle1.setBackgroundResource(R.mipmap.tiko_item_circle_0003);

                        break;
                    case 5:
                        holder.t1.setText("餐");
                        holder.t2.setText("前");
                        holder.t3.setText("预");
                        holder.t4.setText("防");
                        stuffListEntities1.add(stuffListEntities.get(6));
                        stuffListEntities1.add(stuffListEntities.get(7));
                        stuffListEntities1.add(stuffListEntities.get(8));
                        holder.h1.setBackgroundResource(R.color.colorOrange);
                        holder.v1.setBackgroundResource(R.color.colorOrange);
                        holder.circle1.setBackgroundResource(R.mipmap.tiko_item_circle_0002);

                        break;
                    case 7:
                        holder.t1.setText("餐");
                        holder.t2.setText("后");
                        holder.t3.setText("消");
                        holder.t4.setText("脂");
                        stuffListEntities1.add(stuffListEntities.get(9));
                        stuffListEntities1.add(stuffListEntities.get(10));
                        stuffListEntities1.add(stuffListEntities.get(11));
                        holder.h1.setBackgroundResource(R.color.colorOrange);
                        holder.v1.setBackgroundResource(R.color.colorOrange);
                        holder.circle1.setBackgroundResource(R.mipmap.tiko_item_circle_0002);

                        break;
                    case 9:
                        holder.t1.setText("餐");
                        holder.t2.setText("前");
                        holder.t3.setText("预");
                        holder.t4.setText("防");
                        stuffListEntities1.add(stuffListEntities.get(12));
                        stuffListEntities1.add(stuffListEntities.get(13));
                        stuffListEntities1.add(stuffListEntities.get(14));
                        holder.h1.setBackgroundResource(R.color.colorBlue);
                        holder.v1.setBackgroundResource(R.color.colorBlue);
                        holder.circle1.setBackgroundResource(R.mipmap.tiko_item_circle_0001);


                        break;
                    case 11:
                        holder.t1.setText("餐");
                        holder.t2.setText("后");
                        holder.t3.setText("消");
                        holder.t4.setText("脂");
                        stuffListEntities1.add(stuffListEntities.get(15));
                        stuffListEntities1.add(stuffListEntities.get(16));
                        stuffListEntities1.add(stuffListEntities.get(17));
                        holder.h1.setBackgroundResource(R.color.colorBlue);
                        holder.v1.setBackgroundResource(R.color.colorBlue);
                        holder.circle1.setBackgroundResource(R.mipmap.tiko_item_circle_0001);

                        break;
                    case 13:
                        holder.t1.setText("睡");
                        holder.t2.setText("前");
                        holder.t3.setText("推");
                        holder.t4.setText("荐");
                        stuffListEntities1.add(stuffListEntities.get(18));
                        stuffListEntities1.add(stuffListEntities.get(19));
                        stuffListEntities1.add(stuffListEntities.get(20));
                        holder.h1.setBackgroundResource(R.color.colorGray);
                        holder.v1.setBackgroundResource(R.color.colorGray);
                        holder.circle1.setBackgroundResource(R.mipmap.tiko_item_circle_0000);

                        break;
                }
                StuffListAdapter adapter = new StuffListAdapter(holder.view.getContext(), stuffListEntities1);
                LinearLayoutManager linear = new LinearLayoutManager(holder.view.getContext());
                holder.view.setLayoutManager(linear);
                holder.view.setAdapter(adapter);
                adapter.setOnItemClickListener(new StuffListAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(int position, Tikongcan.StuffListEntity stuffListEntity) {
                        int sid = stuffListEntity.getSid();
                        String url_sid = "http://bcp.525happy.com/base/stuff/" + sid + "?version=510&appkey=10001";
                        String url_goto=initGson(url_sid,holder.view.getContext());
                        if (url_goto != null) {
                            Intent intent = new Intent();
                            intent.setClass(holder.view.getContext(), GotoWebView.class);
                            intent.putExtra("infoUrl", url_goto);
                            holder.view.getContext().startActivity(intent);
                        }
                    }
                });
//                adapter.updateRes(stuffListEntities1);

//                ViewGroup.LayoutParams params = holder.view.getLayoutParams();
//                params.height = 3;
//                holder.view.setLayoutParams(params);
                break;
            case 3:
                recipeListEntities1 = new ArrayList<>();
                switch (position) {
                    case 2:
                        holder.rt1.setText("早");
                        holder.rt2.setText("餐");
                        holder.rt3.setText("推");
                        holder.rt4.setText("荐");
                        recipeListEntities1.add(recipeListEntities.get(0));
                        recipeListEntities1.add(recipeListEntities.get(1));
                        holder.h2.setBackgroundResource(R.color.colorGreen);
                        holder.v2.setBackgroundResource(R.color.colorGreen);
                        holder.circle2.setBackgroundResource(R.mipmap.tiko_item_circle_0003);

                        break;
                    case 6:
                        holder.rt1.setText("午");
                        holder.rt2.setText("餐");
                        holder.rt3.setText("推");
                        holder.rt4.setText("荐");
                        recipeListEntities1.add(recipeListEntities.get(2));
                        recipeListEntities1.add(recipeListEntities.get(3));
                        holder.h2.setBackgroundResource(R.color.colorOrange);
                        holder.v2.setBackgroundResource(R.color.colorOrange);
                        holder.circle2.setBackgroundResource(R.mipmap.tiko_item_circle_0002);

                        break;
                    case 10:
                        holder.rt1.setText("晚");
                        holder.rt2.setText("餐");
                        holder.rt3.setText("推");
                        holder.rt4.setText("荐");
                        recipeListEntities1.add(recipeListEntities.get(4));
                        recipeListEntities1.add(recipeListEntities.get(5));
                        holder.h2.setBackgroundResource(R.color.colorBlue);
                        holder.v2.setBackgroundResource(R.color.colorBlue);
                        holder.circle2.setBackgroundResource(R.mipmap.tiko_item_circle_0001);

                        break;
                }
                RecipeListAdapter adapter1 = new RecipeListAdapter(holder.view1.getContext(), recipeListEntities1);
                GridLayoutManager manager = new GridLayoutManager(holder.view1.getContext(), 2);
                holder.view1.setLayoutManager(manager);
                holder.view1.setAdapter(adapter1);
                adapter1.setOnItemClickListener(new RecipeListAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(int position, Tikongcan.RecipeListEntity recipeListEntity) {
                        int sid = recipeListEntity.getSid();
                        String url_sid = "http://bcp.525happy.com/base/stuff/" + sid + "?version=510&appkey=10001";
                        String url_goto=initGson(url_sid,holder.view1.getContext());
                        if (url_goto != null) {
                            Intent intent = new Intent();
                            intent.setClass(holder.view1.getContext(), GotoWebView.class);
                            intent.putExtra("infoUrl", url_goto);
                            holder.view1.getContext().startActivity(intent);
                        }
                    }
                });
//                adapter1.updateRes(recipeListEntities1);
                break;
        }
    }

    private String initGson(String url_sid, Context context) {
        RequestQueue queue= Volley.newRequestQueue(context);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url_sid, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Gson gson = new Gson();
                Three_Info_Web info_web = gson.fromJson(response.toString(), Three_Info_Web.class);
                url =info_web.getShareLink();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("gson-result", error.toString());

            }
        });

        queue.add(jsonObjectRequest);
        return url;
    }

    @Override
    public int getItemCount() {
        return 14;
    }

    // 继承自RecyclerView.ViewHolder 作为RecyclerView.Adapter的泛型
    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image1;
        ImageView image2;
        TextView text;
        LinearLayout layout;
        TextView t1;
        TextView t2;
        TextView t3;
        TextView t4;
        TextView rt1;
        TextView rt2;
        TextView rt3;
        TextView rt4;
        RecyclerView view;
        RecyclerView view1;
        View h1;
        View h2;
        View v1;
        View v2;
        View circle1;
        View circle2;


        public ViewHolder(View itemView) {
            super(itemView);
            image1 = (ImageView) itemView.findViewById(R.id.three_prompt_img_icon);
            image2 = (ImageView) itemView.findViewById(R.id.three_prompt_img_text);
            text = (TextView) itemView.findViewById(R.id.three_prompt_content);
            layout = (LinearLayout) itemView.findViewById(R.id.three_prompt_layout);
            t1 = (TextView) itemView.findViewById(R.id.three_stuff_item_title_first);
            t2 = (TextView) itemView.findViewById(R.id.three_stuff_item_title_second);
            t3 = (TextView) itemView.findViewById(R.id.three_stuff_item_title_third);
            t4 = (TextView) itemView.findViewById(R.id.three_stuff_item_title_fourth);
            rt1 = (TextView) itemView.findViewById(R.id.three_recipe_item_title_first);
            rt2 = (TextView) itemView.findViewById(R.id.three_recipe_item_title_second);
            rt3 = (TextView) itemView.findViewById(R.id.three_recipe_item_title_third);
            rt4 = (TextView) itemView.findViewById(R.id.three_recipe_item_title_fourth);
            view = (RecyclerView) itemView.findViewById(R.id.three_stuff_listView);
            view1 = (RecyclerView) itemView.findViewById(R.id.three_recipe_gv);
            circle1 = itemView.findViewById(R.id.three_stuff_circle);
            circle2 = itemView.findViewById(R.id.three_recipe_circle);
//            three_recipe_item_h_line three_stuff_circle

            h1 = itemView.findViewById(R.id.three_stuff_item_h_line);
            h2 = itemView.findViewById(R.id.three_recipe_item_h_line);
            v1 = itemView.findViewById(R.id.three_stuff_item_v_line);
            v2 = itemView.findViewById(R.id.three_recipe_item_v_line);
        }


    }

    @Override
    public int getItemViewType(int position) {
        int type = 0;
        switch (position % 4) {
            case 0:
                type = 1;
                break;
            case 1:
                type = 2;
                break;
            case 2:
                type = 3;
                break;
            case 3:
                type = 2;
                break;

        }
        return type;
    }
}
