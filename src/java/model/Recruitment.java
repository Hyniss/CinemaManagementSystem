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
public class Recruitment {

    private int ID;
    private String img;
    private String Title;
    private String content;
    private String date;

    public Recruitment() {
    }

    public Recruitment(String Title) {
        this.Title = Title;
    }

    public Recruitment(int ID, String img, String Title, String content, String date) {
        this.ID = ID;
        this.img = img;
        this.Title = Title;
        this.content = content;
        this.date = date;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFormatedDate() {
        String formattedDate = new SimpleDateFormat("dd/MM/yyyy").format(date);
        return formattedDate;
    }

    @Override
    public String toString() {
        return "Recruitment{" + "ID=" + ID + ", img=" + img + ", Title=" + Title + ", content=" + content + ", date=" + date + '}';
    }

}
