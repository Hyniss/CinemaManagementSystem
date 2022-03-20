/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author Bảo Châu Bống
 */
public class CVInfor {

    private int id;
    private String fullname;
    private String CV;
    private String date;
    private int chucvu;
    private int status;

    public CVInfor() {
    }

    public CVInfor(int status) {
        this.status = status;
    }

    public CVInfor(int id, int status) {
        this.id = id;
        this.status = status;
    }

    public CVInfor(int id, String fullname, String CV, String date, int chucvu) {
        this.id = id;
        this.fullname = fullname;
        this.CV = CV;
        this.date = date;
        this.chucvu = chucvu;
    }

    public CVInfor(int id, String fullname, String CV, String date, int chucvu, int status) {
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

    public int getChucvu() {
        return chucvu;
    }

    public void setChucvu(int chucvu) {
        this.chucvu = chucvu;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CVInfor{" + "id=" + id + ", fullname=" + fullname + ", CV=" + CV + ", date=" + date + ", chucvu=" + chucvu + ", status=" + status + '}';
    }

}
