package com.jade.bean;

public class TripArticle {
    private String title;
    private Integer id;
    private String content;
    private Integer continent;
    private Integer province;
    private Integer citys = 0;       //city我觉得应该有默认值
    private String headimg = "";

    public String getHeadimg() {
        return headimg;
    }

    public void setHeadimg(String headimg) {
        this.headimg = headimg;
    }

    public Integer getContinent() {
        return continent;
    }

    public void setContinent(Integer continent) {
        this.continent = continent;
    }

    public Integer getProvince() {
        return province;
    }

    public void setProvince(Integer province) {
        this.province = province;
    }

    public Integer getCitys() {
        return citys;
    }

    public void setCitys(Integer citys) {
        this.citys = citys;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    //发布时间，可以用time类或者转string

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
