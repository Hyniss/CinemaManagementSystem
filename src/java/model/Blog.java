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
public class Blog {

    private int id;
    private String author;
    private String title;
    private String content;
    private String imageLink;

    public Blog() {
    }

    public Blog(int id, String author, String title, String content, String imageLink) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.content = content;
        this.imageLink = imageLink;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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

    @Override
    public String toString() {
        return "Blog{" + "id=" + id + ", author=" + author + ", title=" + title + ", content=" + content + ", imageLink=" + imageLink + '}';
    }

}
