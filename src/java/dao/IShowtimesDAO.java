/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import model.MovieRoom1;

/**
 *
 * @author Bảo Châu Bống
 */
public interface IShowtimesDAO {

    public ArrayList<MovieRoom1> getAllShowtimes();

    public ArrayList<MovieRoom1> getTimeByDate(String premiere);

    public ArrayList<MovieRoom1> getTimeById(int movieId);

    public ArrayList<MovieRoom1> getTimeByDateAndId(int movieId, String premiere);

    public void addShowtimes(MovieRoom1 movieRoom);

    public void editShowtimes(MovieRoom1 movieRoom);

    public void deleteShowtimes(int movieRoomId);

    public MovieRoom1 getShowtimesExist(int movieId, Time time, Date premiere, int roomId);

    public MovieRoom1 get(int id);
}
