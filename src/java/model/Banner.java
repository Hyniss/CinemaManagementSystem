/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Bảo Châu Bống
 */
public class Banner {

    private int id;
    private String img;
    private String title;
    private String desc;

    public Banner() {
    }

    public Banner(String img, String title, String desc) {
        this.img = img;
        this.title = title;
        this.desc = desc;
    }

    public Banner(int id, String img, String title, String desc) {
        this.id = id;
        this.img = img;
        this.title = title;
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Banner{" + "id=" + id + ", img=" + img + ", title=" + title + ", desc=" + desc + '}';
    }

}
