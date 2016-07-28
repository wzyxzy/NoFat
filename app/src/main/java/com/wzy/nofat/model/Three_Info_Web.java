package com.wzy.nofat.model;

/**
 * Created by zy on 2016/4/15.
 */
public class Three_Info_Web {
    /**
     * shareLink : http://bcp.525happy.com/share/link?version=1.0&appkey=10001&moduleId=10&sourceId=245
     * stuff : {"picUrl":"http://m.525happy.com/upload/stuff/pic/2015/5/29/7b3b9364ba154717abb00827a7625143.jpg","effect":"桑椹具有生津止渴、促进消化、帮助排便、减肥消脂、乌发养发、美容养颜、增强免疫力防癌等作用。","name":"桑葚","id":"245","desc":"http://m.525happy.com/upload/stuff/html/2015/5/29/83fb0827df334a7089a8303fbabcd6c2.html","tags":"易瘦,早,中,晚,睡前"}
     */

    private String shareLink;
    /**
     * picUrl : http://m.525happy.com/upload/stuff/pic/2015/5/29/7b3b9364ba154717abb00827a7625143.jpg
     * effect : 桑椹具有生津止渴、促进消化、帮助排便、减肥消脂、乌发养发、美容养颜、增强免疫力防癌等作用。
     * name : 桑葚
     * id : 245
     * desc : http://m.525happy.com/upload/stuff/html/2015/5/29/83fb0827df334a7089a8303fbabcd6c2.html
     * tags : 易瘦,早,中,晚,睡前
     */

    private StuffEntity stuff;

    public String getShareLink() {
        return shareLink;
    }

    public void setShareLink(String shareLink) {
        this.shareLink = shareLink;
    }

    public StuffEntity getStuff() {
        return stuff;
    }

    public void setStuff(StuffEntity stuff) {
        this.stuff = stuff;
    }

    public static class StuffEntity {
        private String picUrl;
        private String effect;
        private String name;
        private String id;
        private String desc;
        private String tags;

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getEffect() {
            return effect;
        }

        public void setEffect(String effect) {
            this.effect = effect;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getTags() {
            return tags;
        }

        public void setTags(String tags) {
            this.tags = tags;
        }
    }
}
