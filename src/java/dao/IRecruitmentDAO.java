
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import model.Recruitment;

/**
 *
 * @author Bảo Châu Bống
 */
public interface IRecruitmentDAO {

    public Recruitment getRecruitment(int id);

    public ArrayList<Recruitment> getAllRecruitment();

    public void addRecruitment(Recruitment Recruitment);

    public void editRecruitment(Recruitment Recruitment);

    public void deleteRecruitment(int id);

    public Recruitment get(int id);
    
    public ArrayList<Recruitment> getAllChucVu();
}
