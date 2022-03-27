/* 
 * CinemaManagementSystem
 * Copyright(C)2022, Group 4 SE1511 FPTU-HN
 * 
 * Interface IShowtimesDAO
 * Record of change:
 * DATE         Version     AUTHOR        Description
 * 2022-02-11   1.0         Nguyen Nam    First Implement
 */
package dao;

import java.sql.Date;
import java.util.ArrayList;
import model.MovieRoom;

/**
 * This is the interface class that declares the methods to access the data of
 * the TimeRoom object Abstract method getAllTimeRoom used to retrieve all
 * feedback
 *
 * @author Nguyen Nam
 */
public interface IShowtimesDAO {

    //get movie room by movieroomId
    public MovieRoom getShowtimes(int movieRoomId);

    //count total movie room
    public int countTotal();

    //get all movie room with pagging and searching
    public ArrayList<MovieRoom> getAllDatePaggingAndSearching(int pageIndex, int pageSize, Date searchDate);

    //add movie room
    public int addShowtimes(Date date);

    //edit movie room
    public void editShowtimes(MovieRoom movieRoom);

    //delete movie room
    public void deleteShowtimes(int movieRoomId);

    //get all date in movieroom
    public ArrayList<MovieRoom> getAllDate();

}
