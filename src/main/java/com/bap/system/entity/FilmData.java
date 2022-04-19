package com.bap.system.entity;
/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/4/19 9:27:51
 */

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import javax.persistence.Column;
import javax.persistence.Id;

@TableName("data1")
public class FilmData {

    @Id
    @TableId(value="id", type= IdType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer f1;
    private String title;
    private String star;
    private String director;
    private String budget;
    private String type;
    private String keyword;
    private String language;
    private String popularity;
    private String country;
    private String release;
    private String boxoffice;
    private String duration;
    private String score;
    private String evaluators;

    public Integer getF1() {
        return f1;
    }

    public void setF1(Integer f1) {
        this.f1 = f1;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public String getBoxoffice() {
        return boxoffice;
    }

    public void setBoxoffice(String boxoffice) {
        this.boxoffice = boxoffice;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getEvaluators() {
        return evaluators;
    }

    public void setEvaluators(String evaluators) {
        this.evaluators = evaluators;
    }
}
