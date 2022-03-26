/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import model.Banner;

/**
 *
 * @author tenhik
 */
public interface IBannerDAO {

    public Banner getBanner(int id);

    public ArrayList<Banner> getAllBanner();

    public void addBanner(Banner banner);

    public void editBanner(Banner banner);

    public void deleteBanner(int id);

    public Banner get(int id);

    // new
    public int getTotalBanner();

    public List<Banner> pagingBanner(int pageIndex);

    public ArrayList<Banner> getBannerByTitle(String title, int pageIndex);

    public int getTotalBannerByTitle(String title);
}
