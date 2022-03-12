/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Date;
import java.util.ArrayList;
import model.MovieRoom;
import model.MovieRoom1;

/**
 *
 * @author Bảo Châu Bống
 */
public interface IShowtimesDAO {
    
    public MovieRoom getShowtimes(int movieRoomId);
    
    public int countTotal();
    
    public ArrayList<MovieRoom> getAllDatePaggingAndSearching(int pageIndex, int pageSize,Date searchDate);

    public int addShowtimes(Date date);

    public void editShowtimes(MovieRoom movieRoom);

    public void deleteShowtimes(int movieRoomId);

}
