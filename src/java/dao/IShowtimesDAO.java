/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import model.MovieRoom;

/**
 *
 * @author Bảo Châu Bống
 */
public interface IShowtimesDAO {

    public ArrayList<MovieRoom> getAllShowtimes();

    public ArrayList<MovieRoom> getTimeByDate(String premiere);

    public ArrayList<MovieRoom> getTimeById(int movieId);

    public ArrayList<MovieRoom> getTimeByDateAndId(int movieId, String premiere);

    public void addShowtimes(MovieRoom movieRoom);

    public void editShowtimes(MovieRoom movieRoom);

    public void deleteShowtimes(int movieRoomId);

    public MovieRoom getShowtimesExist(int movieId, Time time, Date premiere, int roomId);

    public MovieRoom get(int id);
}
