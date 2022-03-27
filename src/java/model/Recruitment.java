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
    private String title;
    private String content;
    private String date;

    public Recruitment() {
    }

    public Recruitment(int ID, String img, String title, String content, String date) {
        this.ID = ID;
        this.img = img;
        this.title = title;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

//    public String getFormatedDate() {
//        String formattedDate = new SimpleDateFormat("dd/MM/yyyy").format(date);
//        return formattedDate;
//    }

//    public static void main(String[] args) {
//
//        long millis = System.currentTimeMillis();
//        Timestamp timestamp = new Timestamp(millis);
//        //System.out.println(timestamp);
//
//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//
//        /*
//         * Parameters:
//         *
//         * date - the time value to be formatted into a time string.
//         *
//         * Returns:
//         *
//         * the formatted time string.
//         */
//        String formatedStrDate = sdf.format(timestamp);
//        System.out.println(formatedStrDate);
//
//    }

    @Override
    public String toString() {
        return "Recruitment{" + "ID=" + ID + ", img=" + img + ", title=" + title + ", content=" + content + ", date=" + date + '}';
    }

}
