package com.bograpoly.emp;

import java.io.Serializable;
import java.util.Date;

public class Hotline {
    private String titleEn;
    private String numberEn;
    private String thumbImageEn;
    private String descriptionEn;

    public Hotline(String titleEn, String numberEn, String descriptionEn, String thumbImageEn) {
        this.titleEn = titleEn;
        this.numberEn = numberEn;
        this.thumbImageEn = thumbImageEn;
        this.descriptionEn = descriptionEn;
    }

    public String getTitleEn() {
        return titleEn;
    }

    public void setTitleEn(String titleEn) {
        this.titleEn = titleEn;
    }

    public String getNumberEn() {
        return numberEn;
    }

    public void setNumberEn(String numberEn) {
        this.numberEn = numberEn;
    }

    public String getThumbImageEn() {
        return thumbImageEn;
    }

    public void setThumbImageEn(String thumbImageEn) {
        this.thumbImageEn = thumbImageEn;
    }

    public String getDescriptionEn() {
        return descriptionEn;
    }

    public void setDescriptionEn(String descriptionEn) {
        this.descriptionEn = descriptionEn;
    }
}
