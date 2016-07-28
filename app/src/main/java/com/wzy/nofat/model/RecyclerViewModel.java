package com.wzy.nofat.model;

/**
 * Created by Administrator on 16-4-13.
 */
public class RecyclerViewModel {

    private String tname;
    private String pic;
    private int position;
    private int id;

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
