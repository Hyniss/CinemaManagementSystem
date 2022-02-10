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
    private Date date;

    public Promotion() {
    }

    public Promotion(int id, String title, String content, String imageLink, Date date) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.imageLink = imageLink;
        this.date = date;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getFormatedDate() {
        String formattedDate = new SimpleDateFormat("dd/MM/yyyy").format(date);
        return formattedDate;
    }

    @Override
    public String toString() {
        return "Promotion{" + "id=" + id + ", title=" + title + ", content=" + content + ", imageLink=" + imageLink + ", date=" + date + '}';
    }
}
