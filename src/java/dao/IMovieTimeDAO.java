/* 
 * CinemaManagementSystem
 * Copyright(C)2022, Group 4 SE1511 FPTU-HN
 * 
 * Interface IMovieTimeDAO
 * Record of change:
 * DATE         Version     AUTHOR        Description
 * 2022-02-11   1.0         Nguyen Nam    First Implement
 */
package dao;

import java.sql.Time;
import java.util.ArrayList;
import model.MovieRoom;
import model.MovieTime;

/**
 * This is the interface class that declares the methods to access the data of
 * the TimeRoom object Abstract method getAllTimeRoom used to retrieve all movie
 * time
 *
 * @author Nguyen Nam
 */
public interface IMovieTimeDAO {

    //get all movie time by list of movie room
    public ArrayList<MovieTime> getMovieTimeByMovieRoomId(ArrayList<MovieRoom> list);

    //get all movie time by movie room id
    public ArrayList<MovieTime> getMovieByMovieRoomId(int movieRoomId);

    //get all movie time by movie room id and slot has added
    public ArrayList<MovieTime> getMovieByMovieRoomIdAndAdd(int movieRoomId);

    //add movie time with time added
    public boolean addMovieTime(String slot, Time start, Time end, int movieRoomId, String add);

    //add movie time without time added
    public boolean addMovieTimeSlot(String slot, int movieRoomId, String add);

    //delet movie time by movieroomId
    public boolean deleteMovieTime(int movieRoomId);

    //edit movie time with time
    public void editMovieTime(Time start, Time end, int movieRoomId, String slot, String add);

    //edit add propertites in movie time
    public void editMovieTimeSlot(int movieRoomId, String add);

    //get movie time by movie room and slot
    public MovieTime getMovieTime(int movieroomId, String slot);

    //get movie time bby movie room and time room
    public MovieTime getMovieTimeByTimeRoom(int movieroomId, int timeRoomId);

    //get movie time by id
    public MovieTime getMovieTime(int timeId);

    public ArrayList<MovieTime> getAllMovieTime();

    public ArrayList<MovieTime> getId(int movieId, int movieRoomId, String roomId);
}
