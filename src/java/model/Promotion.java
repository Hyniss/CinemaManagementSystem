/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author Bảo Châu Bống
 */
public class Promotion {

    private int id;
    private String title;
    private String content;
    private String imageLink;
    private String date;
    private int discount;
    private String magiam;

    public Promotion() {
    }

    public Promotion(int id, String title, String content, String imageLink, String date, int discount, String magiam) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.imageLink = imageLink;
        this.date = date;
        this.discount = discount;
        this.magiam = magiam;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getMagiam() {
        return magiam;
    }

    public void setMagiam(String magiam) {
        this.magiam = magiam;
    }

    @Override
    public String toString() {
        return "Promotion{" + "id=" + id + ", title=" + title + ", content=" + content + ", imageLink=" + imageLink + ", date=" + date + ", discount=" + discount + ", magiam=" + magiam + '}';
    }

}
