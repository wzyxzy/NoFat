package com.wzy.nofat.one_model;

/**
 * Created by Administrator on 2016/4/12 0012.
 */
public class Model_List {
    //名字
    private String name;
    //奇偶判断
    private int eatTime;
    //图片
    private String pic;
    //推荐指数的星星
    private int level;
    //条状页面的拼接参数
    private int sid;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getEatTime() {
        return eatTime;
    }

    public void setEatTime(int eatTime) {
        this.eatTime = eatTime;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
