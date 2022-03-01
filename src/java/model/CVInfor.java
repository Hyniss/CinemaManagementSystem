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
public class CVInfor {

    private int id;
    private String fullname;
    private String CV;
    private String date;
    private String chucvu;
    private String status;

    public CVInfor() {
    }

    public CVInfor(String status) {
        this.status = status;
    }

    public CVInfor(int id, String fullname, String CV, String date, String chucvu, String status) {
        this.id = id;
        this.fullname = fullname;
        this.CV = CV;
        this.date = date;
        this.chucvu = chucvu;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getCV() {
        return CV;
    }

    public void setCV(String CV) {
        this.CV = CV;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getChucvu() {
        return chucvu;
    }

    public void setChucvu(String chucvu) {
        this.chucvu = chucvu;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CVInfor{" + "id=" + id + ", fullname=" + fullname + ", CV=" + CV + ", date=" + date + ", chucvu=" + chucvu + ", status=" + status + '}';
    }

}
