package com.wzy.nofat.model;

/**
 * Created by Administrator on 16-4-11.
 */
public class TwoFragmentModel {
    //文字
    private String title;
    //跳转的网站
    private String content;
    //跳转以后显示的内容
    private String desc;
    //别吃胖
    private String source;
    //图片
    private String img;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
