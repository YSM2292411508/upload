package com.yuan.Tool;

public class Data {
    private Integer id;
    private String tupian;
    private String wenjian;
    private String jieshao;
    private String lianjie;
    private String mingzi;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTupian() {
        return tupian;
    }

    public void setTupian(String tupian) {
        this.tupian = tupian;
    }

    public String getWenjian() {
        return wenjian;
    }

    public void setWenjian(String wenjian) {
        this.wenjian = wenjian;
    }

    public String getJieshao() {
        return jieshao;
    }

    public void setJieshao(String jieshao) {
        this.jieshao = jieshao;
    }

    public String getLianjie() {
        return lianjie;
    }

    public void setLianjie(String lianjie) {
        this.lianjie = lianjie;
    }

    public String getMingzi() {
        return mingzi;
    }

    public void setMingzi(String mingzi) {
        this.mingzi = mingzi;
    }

    @Override
    public String toString() {
        return "Data{" +
                "id=" + id +
                ", tupian='" + tupian + '\'' +
                ", wenjian='" + wenjian + '\'' +
                ", jieshao='" + jieshao + '\'' +
                ", lianjie='" + lianjie + '\'' +
                ", mingzi='" + mingzi + '\'' +
                '}';
    }
}
