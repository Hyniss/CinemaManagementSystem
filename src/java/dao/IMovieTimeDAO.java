/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Time;
import java.util.ArrayList;
import model.MovieRoom;
import model.MovieTime;

/**
 *
 * @author tenhik
 */
public interface IMovieTimeDAO {

    public ArrayList<MovieTime> getMovieTimeByMovieRoomId(ArrayList<MovieRoom> list);

    public ArrayList<MovieTime> getMovieByMovieRoomId(int movieRoomId);

    public boolean addMovieTime(String slot, Time start, Time end, int movieRoomId, String add);

    public boolean addMovieTimeSlot(String slot, int movieRoomId, String add);

    public boolean deleteMovieTime(int movieRoomId);

    public void editMovieTime(Time start, Time end, int movieRoomId, String slot, String add);

    public void editMovieTimeSlot(int movieRoomId, String add);

    public MovieTime getMovieTime(int movieroomId, String slot);
}
