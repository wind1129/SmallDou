package com.example.wind.smalldou.mvp.model.bean;

/**
 * Created by Wind1129 on 17/4/5.
 */

import java.util.List;

/**
 *
     {
     "rating": {
         "max": 10,
         "numRaters": 61862,
         "average": "8.4",
         "min": 0
     },
     "subtitle": "",
     "author": [
        "[日] 东野圭吾"
     ],
     "pubdate": "2009-6",
     "tags": [
         {
         "count": 18494,
         "name": "东野圭吾",
         "title": "东野圭吾"
         },
         {
         "count": 11145,
         "name": "推理",
         "title": "推理"
         },
         {
         "count": 7648,
         "name": "日本",
         "title": "日本"
         },
         {
         "count": 4571,
         "name": "小说",
         "title": "小说"
         },
         {
         "count": 4054,
         "name": "東野圭吾",
         "title": "東野圭吾"
         },
         {
         "count": 3405,
         "name": "推理小说",
         "title": "推理小说"
         },
         {
         "count": 3162,
         "name": "悬疑",
         "title": "悬疑"
         },
         {
         "count": 2888,
         "name": "日本文学",
         "title": "日本文学"
         }
     ],
     "origin_title": "悪意",
     "image": "https://img5.doubanio.com/mpic/s3814606.jpg",
     "binding": "平装",
     "translator": [
        "娄美莲"
     ],
     "catalog": "事件之章
     野野口修的手记
     疑惑之章
     加贺恭一郎的记录
     解决之章
     野野口修的手记
     探究之章
     加贺恭一郎的独白
     告白之章
     野野口修的手记
     过去之章(一)
     加贺恭一郎的记录
     过去之章(二)
     认识他们的人所说的话
     过去之章(三)
     加贺恭一郎的回忆
     真相之章
     加贺恭一郎的阐明",
     "pages": "264",
     "images": {
         "small": "https://img5.doubanio.com/spic/s3814606.jpg",
         "large": "https://img5.doubanio.com/lpic/s3814606.jpg",
         "medium": "https://img5.doubanio.com/mpic/s3814606.jpg"
     },
     "alt": "https://book.douban.com/subject/3646172/",
     "id": "3646172",
     "publisher": "南海出版公司",
     "isbn10": "7544244423",
     "isbn13": "9787544244428",
     "title": "恶意",
     "url": "https://api.douban.com/v2/book/3646172",
     "alt_title": "悪意",
     "author_intro": "东野圭吾，日本著名作家。1958年生于大阪，直木奖、推理作家协会奖、江户川乱步奖、本格推理小说大奖等日本重要文学奖项得主，出道20余年来作品逾60部。
     早期作品多为精巧细致的本格推理，随着写作功底浸润日深，涉及领域也不断延伸，对社会现象的剖析日渐精微。后期笔锋越发老辣，文字鲜加雕琢，叙述简练凶狠，情节跌宕诡异，故事架构几至匪夷所思的地步，擅长从极不合理之处写出极合理的故事，功力之深令人瞠目骇然。
     1985年，凭校园推理小说《放学后》夺得第31届江户川乱步奖，开始专职写作。
     1999年，《秘密》获第52届日本推理作家协会奖，入围第120届直木奖。
     2000年，《白夜行》入围第122届直木奖。
     2001年，《暗恋》入围第125届直木奖。
     2003年，《信》入围第129届直木奖。
     2004年，《幻夜》入围第131届直木奖。
     2006年，《嫌疑人X的献身》创造了日本推理小说史上绝无仅有的奇迹，将第134届直木奖、第6届本格推理小说大奖及当年度日本三大推理小说排行榜第1名一并收入囊中。",
     "summary": "畅销书作家在出国的前一晚于家中被杀。凶手很快落网，对罪行供认不讳、但求速死，却对作案动机语焉不详。
     他当真是罪犯？他究竟为何杀人？
     在彻查被害人与凶手的过去之后，警官面对案情、手法均平淡无奇的事实，却感到如坠万丈深渊般无边的寒意……
     作为一部手记体杰作，《恶意》多年来在票选中始终名列前茅，同时被评论界和众多读者视为东野圭吾的巅峰之作，与《白夜行》同享光辉与荣耀：环环相扣的侦破进展百转千回，将手记体叙事的无限可能发挥得淋漓尽致；对复杂人性抽丝剥茧的深刻描画，令人眼花缭乱、哑口无言。
     更引人注目的，是《恶意》与《白夜行》恰似两生花，《白夜行》中的爱情极度炽烈，令人粉身碎骨；《恶意》中的怨恨则无比深沉，令人万劫不复。人性的两极就这样奇异地直击人心。",
     "series": {
         "id": "868",
         "title": "新经典文库·东野圭吾作品"
     },
     "price": "18.00"
     }
 */


/**
 * 图书们
 */
public class BookBean {
    private RatingBean rating;
    private String subtitle;
    private String pubdate;
    private String image;
    private String pages;
    private ImagesBean images;
    private String id;
    private String publisher;
    private String title;
    private String summary;
    private List<String> author;

    public RatingBean getRating() {
        return rating;
    }

    public void setRating(RatingBean rating) {
        this.rating = rating;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getPubdate() {
        return pubdate;
    }

    public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public ImagesBean getImages() {
        return images;
    }

    public void setImages(ImagesBean images) {
        this.images = images;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public List<String> getAuthor() {
        return author;
    }

    public void setAuthor(List<String> author) {
        this.author = author;
    }
}
