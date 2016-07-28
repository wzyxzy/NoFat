package com.wzy.nofat.model;

import java.util.List;

/**
 * Created by zy on 2016/4/11.
 */
public class Tikongcan {

    /**
     * solarDate : [{"date":"","label":"上一个节气"},{"date":"2016-04-04","label":"04月04日"},{"date":"2016-04-05","label":"04月05日"},{"date":"2016-04-06","label":"04月06日"},{"date":"2016-04-07","label":"04月07日"},{"date":"2016-04-08","label":"04月08日"},{"date":"2016-04-09","label":"04月09日"},{"date":"2016-04-10","label":"昨天"},{"date":"2016-04-11","label":"今天"},{"date":"2016-04-12","label":"明天"},{"date":"2016-04-13","label":"04月13日"},{"date":"2016-04-14","label":"04月14日"},{"date":"2016-04-15","label":"04月15日"},{"date":"2016-04-16","label":"04月16日"},{"date":"2016-04-17","label":"04月17日"},{"date":"2016-04-18","label":"04月18日"},{"date":"","label":"下一个节气"}]
     * recipeList : [{"id":8862893,"sid":18184,"name":"紫薯蛋糕卷","effect":null,"pic":"http://static.525happy.com/upload/recipe/youban/1359528133664.jpg","eatTime":1,"level":null},{"id":8862894,"sid":18194,"name":"简易纸杯小蛋糕","effect":null,"pic":"http://static.525happy.com/upload/recipe/youban/1359536418870.jpg","eatTime":1,"level":null},{"id":8862895,"sid":18099,"name":"酱猪肝拌菠菜","effect":null,"pic":"http://static.525happy.com/upload/recipe/youban/1355998174441.jpg","eatTime":2,"level":null},{"id":8862896,"sid":16646,"name":"蛤蜊蒸蛋","effect":null,"pic":"http://static.525happy.com/upload/recipe/youban/1314592019444.jpg","eatTime":2,"level":null},{"id":8862897,"sid":17999,"name":"凉拌凉粉丝","effect":null,"pic":"http://static.525happy.com/upload/recipe/youban/1352453346312.jpg","eatTime":3,"level":null},{"id":8862898,"sid":17710,"name":"金枪鱼三明治","effect":null,"pic":"http://static.525happy.com/upload/recipe/youban/1343275464130.jpg","eatTime":3,"level":null}]
     * solarTerm : 清明
     * promptList : [{"id":671,"content":"早上没吃饱？再吃根香蕉好啦，营养美味还不胖！","eatTime":1},{"id":672,"content":"中午吃太撑了？可以喝几口米酒帮助消化哦~","eatTime":2},{"id":673,"content":"晚上不能吃零食？不一定哦~嗑嗑瓜子完全没问题！","eatTime":3},{"id":674,"content":"夜深啦，不要再抱着电脑对着手机了，快关机睡觉去吧~","eatTime":4}]
     * stuffList : [{"id":8862693,"sid":89,"name":"无花果","effect":"1. 无花果含有苹果酸、柠檬酸、脂肪酶、蛋白酶、水解酶等，能帮助人体对食物的消化，促进食欲，又因其含有多种脂类，故具有润肠通便的效果；2. 无花果所含的脂肪酶、水解酶等有降低血脂和分解血脂的功能，可减少脂肪在血管内的沉积，进而起到降血压、预防冠心病的作用；3. 无花果有抗炎消肿之功，可利咽消肿；","pic":"http://static.525happy.com/upload/2015/3/19/150_wuhuaguo.png","eatTime":5,"level":5},{"id":8862694,"sid":158,"name":"绿茶","effect":"瘦身指数：★★★★\r\n推荐理由：绿茶可是个刮油神器啊!富含能溶解脂肪、化浊去腻的芳香族化合物。绿茶中的儿茶素具有抗氧化、提高新陈代谢、清除自由基等作用，小编良心推荐！不过肠胃不好的妹子们不宜多喝哦~\r\n","pic":"http://static.525happy.com/upload/app/stuff/pic/2015/4/2/42798325343201.jpg","eatTime":5,"level":4},{"id":8862695,"sid":253,"name":"大麦茶","effect":"瘦身指数：★★★★★\r\n推荐理由：饭前喝点大麦茶会觉得肚子饱饱的，而油腻用餐后喝一点，立马觉得油腻感轻多了，这是因为大麦茶富含膳食纤维，还能吸附脂肪，瘦身指数五颗星！","pic":"http://m.525happy.com/upload/stuff/pic/2015/6/4/8c793ddd62954780bbb6ece0f0108e69.jpg","eatTime":5,"level":5},{"id":8862696,"sid":108,"name":"苹果","effect":"瘦身指数：★★★★★\r\n推荐理由：苹果富含膳食纤维，具有非常好的润肠通便作用。一天一苹果不仅医生远离我，肥胖也会远离我。瘦身指数5颗星！","pic":"http://static.525happy.com/upload/2015/3/19/150_pingguo.png","eatTime":6,"level":5},{"id":8862697,"sid":226,"name":"牛奶","effect":"瘦身指数：★★\r\n推荐理由：牛奶含有丰富的蛋白质和微量元素，常喝可以增强体质。而且牛奶中含有的脂肪和碳水化合物含量并不高，所以减重期也可以喝。瘦身指数2颗星。","pic":"http://m.525happy.com/upload/stuff/pic/2015/5/13/ecbca17569eb4aeb82b5b58781a4a305.jpg","eatTime":6,"level":2},{"id":8862698,"sid":174,"name":"红酒","effect":"瘦身指数：★★\r\n推荐理由：喝点红酒，能暖身、加快身体代谢，每日一小杯，可以辅助瘦身哦。不过千万不能贪杯，喝多了不仅有发胖风险，而且伤的是自己的身体！","pic":"http://static.525happy.com/upload/app/stuff/pic/2015/4/9/42855996206701.jpg","eatTime":6,"level":2},{"id":8862699,"sid":219,"name":"人参果","effect":"人参果对于女性美白养颜很有功效；还可以增加人体中的津液而缓解口渴，咽喉干燥等病症；增强肠胃吸收功能和机体抗感染能力；多种维生素保护心血管等脏器，还能刺激免疫球蛋白及抗体的产生。","pic":"http://m.525happy.com/upload/stuff/pic/2015/5/13/b49a2f63b28d4ceea744be8e51166e6c.jpg","eatTime":7,"level":0},{"id":8862700,"sid":107,"name":"荸荠","effect":"瘦身指数：★★★★\r\n推荐理由：荸荠味道清甜，常吃能清心泻火、利肠通便，对于想促进消化排毒减重的小伙伴来说，它可是不可多得的健康美食呢。\r\n","pic":"http://static.525happy.com/upload/2015/3/19/150_boji.png","eatTime":7,"level":4},{"id":8862701,"sid":245,"name":"桑葚","effect":"桑椹具有生津止渴、促进消化、帮助排便、减肥消脂、乌发养发、美容养颜、增强免疫力防癌等作用。","pic":"http://m.525happy.com/upload/stuff/pic/2015/5/29/7b3b9364ba154717abb00827a7625143.jpg","eatTime":7,"level":0},{"id":8862702,"sid":245,"name":"桑葚","effect":"桑椹具有生津止渴、促进消化、帮助排便、减肥消脂、乌发养发、美容养颜、增强免疫力防癌等作用。","pic":"http://m.525happy.com/upload/stuff/pic/2015/5/29/7b3b9364ba154717abb00827a7625143.jpg","eatTime":8,"level":0},{"id":8862703,"sid":257,"name":"乌龙茶","effect":"瘦身指数：★★★★★\r\n推荐理由：乌龙茶排毒瘦身指数5颗星，乌龙茶排毒瘦身指数5颗星，乌龙茶排毒瘦身指数5颗星，重要的事情说三遍~","pic":"http://m.525happy.com/upload/stuff/pic/2015/6/4/9686c766992b44e594ca1a49f39022c4.jpg","eatTime":8,"level":5},{"id":8862704,"sid":243,"name":"荷叶茶","effect":"瘦身指数：★★★★★\r\n推荐理由：几个妹子不水肿？几个女人不便秘？肉肉松垮的妹纸们，荷叶茶就是你的福音！《本草纲目》明文记载，荷叶颇具瘦身功效，还不快喝起来!\r\n","pic":"http://m.525happy.com/upload/stuff/pic/2015/5/29/aa16846cefba4d669fce04b346db63a2.jpg","eatTime":8,"level":0},{"id":8862705,"sid":198,"name":"普洱茶","effect":"瘦身指数：★★★★★\r\n推荐理由：普洱茶是发酵茶，泡开进入肠胃后可以加快肠胃蠕动，解油治便秘，效果人人夸。瘦身指数5颗星。","pic":"http://m.525happy.com/upload/stuff/pic/2015/4/b7e1e88d1f9f404dbd31a9e278ec2472.jpg","eatTime":9,"level":5},{"id":8862706,"sid":58,"name":"柠檬","effect":"瘦身指数：★★★★★\r\n推荐理由：酸酸的柠檬可促进胃中蛋白质分解酶的分泌，增加肠胃蠕动，有助于消化吸收和减肥，大鱼大肉的冬天尤其推荐！不过有肠胃溃疡的小伙伴们要忌吃哦~\r\n","pic":"http://static.525happy.com/upload/2015/3/19/150_ningmeng.png","eatTime":9,"level":5},{"id":8862707,"sid":253,"name":"大麦茶","effect":"瘦身指数：★★★★★\r\n推荐理由：饭前喝点大麦茶会觉得肚子饱饱的，而油腻用餐后喝一点，立马觉得油腻感轻多了，这是因为大麦茶富含膳食纤维，还能吸附脂肪，瘦身指数五颗星！","pic":"http://m.525happy.com/upload/stuff/pic/2015/6/4/8c793ddd62954780bbb6ece0f0108e69.jpg","eatTime":9,"level":5},{"id":8862708,"sid":107,"name":"荸荠","effect":"瘦身指数：★★★★\r\n推荐理由：荸荠味道清甜，常吃能清心泻火、利肠通便，对于想促进消化排毒减重的小伙伴来说，它可是不可多得的健康美食呢。\r\n","pic":"http://static.525happy.com/upload/2015/3/19/150_boji.png","eatTime":10,"level":4},{"id":8862709,"sid":242,"name":"薰衣草茶","effect":"瘦身指数：★★★★★\r\n推荐理由：薰衣草茶可是大S超爱的一款茶饮哦，不仅能够滋润皮肤，还能把身体多余的脂肪和肥肉甩掉。总之，常喝薰衣草茶会让你变得更美！ \r\n","pic":"http://m.525happy.com/upload/stuff/pic/2015/5/29/860cc47c5dc74deda9734583e42c6412.jpg","eatTime":10,"level":5},{"id":8862710,"sid":58,"name":"柠檬","effect":"瘦身指数：★★★★★\r\n推荐理由：酸酸的柠檬可促进胃中蛋白质分解酶的分泌，增加肠胃蠕动，有助于消化吸收和减肥，大鱼大肉的冬天尤其推荐！不过有肠胃溃疡的小伙伴们要忌吃哦~\r\n","pic":"http://static.525happy.com/upload/2015/3/19/150_ningmeng.png","eatTime":10,"level":5},{"id":8862711,"sid":238,"name":"洛神花茶","effect":"瘦身指数：★★★★★\r\n推荐理由：洛神花茶名字很美，让人遥想到它和女神有什么联系。洛神花茶可以帮助人体排毒、保持体型，经常饮用可以让你变得更美哦!\r\n","pic":"http://m.525happy.com/upload/stuff/pic/2015/5/28/e51894fe80204e8daa37191de74c45a8.jpg","eatTime":11,"level":5},{"id":8862712,"sid":89,"name":"无花果","effect":"1. 无花果含有苹果酸、柠檬酸、脂肪酶、蛋白酶、水解酶等，能帮助人体对食物的消化，促进食欲，又因其含有多种脂类，故具有润肠通便的效果；2. 无花果所含的脂肪酶、水解酶等有降低血脂和分解血脂的功能，可减少脂肪在血管内的沉积，进而起到降血压、预防冠心病的作用；3. 无花果有抗炎消肿之功，可利咽消肿；","pic":"http://static.525happy.com/upload/2015/3/19/150_wuhuaguo.png","eatTime":11,"level":5},{"id":8862713,"sid":226,"name":"牛奶","effect":"瘦身指数：★★\r\n推荐理由：牛奶含有丰富的蛋白质和微量元素，常喝可以增强体质。而且牛奶中含有的脂肪和碳水化合物含量并不高，所以减重期也可以喝。瘦身指数2颗星。","pic":"http://m.525happy.com/upload/stuff/pic/2015/5/13/ecbca17569eb4aeb82b5b58781a4a305.jpg","eatTime":11,"level":2}]
     */

    private String solarTerm;
    /**
     * date :
     * label : 上一个节气
     */

    private List<SolarDateEntity> solarDate;
    /**
     * id : 8862893
     * sid : 18184
     * name : 紫薯蛋糕卷
     * effect : null
     * pic : http://static.525happy.com/upload/recipe/youban/1359528133664.jpg
     * eatTime : 1
     * level : null
     */

    private List<RecipeListEntity> recipeList;
    /**
     * id : 671
     * content : 早上没吃饱？再吃根香蕉好啦，营养美味还不胖！
     * eatTime : 1
     */

    private List<PromptListEntity> promptList;
    /**
     * id : 8862693
     * sid : 89
     * name : 无花果
     * effect : 1. 无花果含有苹果酸、柠檬酸、脂肪酶、蛋白酶、水解酶等，能帮助人体对食物的消化，促进食欲，又因其含有多种脂类，故具有润肠通便的效果；2. 无花果所含的脂肪酶、水解酶等有降低血脂和分解血脂的功能，可减少脂肪在血管内的沉积，进而起到降血压、预防冠心病的作用；3. 无花果有抗炎消肿之功，可利咽消肿；
     * pic : http://static.525happy.com/upload/2015/3/19/150_wuhuaguo.png
     * eatTime : 5
     * level : 5
     */

    private List<StuffListEntity> stuffList;

    public String getSolarTerm() {
        return solarTerm;
    }

    public void setSolarTerm(String solarTerm) {
        this.solarTerm = solarTerm;
    }

    public List<SolarDateEntity> getSolarDate() {
        return solarDate;
    }

    public void setSolarDate(List<SolarDateEntity> solarDate) {
        this.solarDate = solarDate;
    }

    public List<RecipeListEntity> getRecipeList() {
        return recipeList;
    }

    public void setRecipeList(List<RecipeListEntity> recipeList) {
        this.recipeList = recipeList;
    }

    public List<PromptListEntity> getPromptList() {
        return promptList;
    }

    public void setPromptList(List<PromptListEntity> promptList) {
        this.promptList = promptList;
    }

    public List<StuffListEntity> getStuffList() {
        return stuffList;
    }

    public void setStuffList(List<StuffListEntity> stuffList) {
        this.stuffList = stuffList;
    }

    public static class SolarDateEntity {
        private String date;
        private String label;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }
    }

    public static class RecipeListEntity {
        private int id;
        private int sid;
        private String name;
        private Object effect;
        private String pic;
        private int eatTime;
        private Object level;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getSid() {
            return sid;
        }

        public void setSid(int sid) {
            this.sid = sid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Object getEffect() {
            return effect;
        }

        public void setEffect(Object effect) {
            this.effect = effect;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public int getEatTime() {
            return eatTime;
        }

        public void setEatTime(int eatTime) {
            this.eatTime = eatTime;
        }

        public Object getLevel() {
            return level;
        }

        public void setLevel(Object level) {
            this.level = level;
        }
    }

    public static class PromptListEntity {
        private int id;
        private String content;
        private int eatTime;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getEatTime() {
            return eatTime;
        }

        public void setEatTime(int eatTime) {
            this.eatTime = eatTime;
        }
    }

    public static class StuffListEntity {
        private int id;
        private int sid;
        private String name;
        private String effect;
        private String pic;
        private int eatTime;
        private int level;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getSid() {
            return sid;
        }

        public void setSid(int sid) {
            this.sid = sid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEffect() {
            return effect;
        }

        public void setEffect(String effect) {
            this.effect = effect;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
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
    }
}
