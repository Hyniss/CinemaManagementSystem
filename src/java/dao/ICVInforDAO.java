/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import model.CVInfor;

/**
 *
 * @author Bảo Châu Bống
 */
public interface ICVInforDAO {

    public CVInfor getCV(int id);

    public ArrayList<CVInfor> getAllCV();

    public void addCV(CVInfor cvinfor);

    public void editCV(CVInfor cvinfor);

    public void deleteCV(int id);

    public ArrayList<CVInfor> getAllStatus();

    // new
    public int getTotalCV();

    public List<CVInfor> pagingCV(int pageIndex);
}
