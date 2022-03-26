/* 
 * CinemaManagementSystem
 * Copyright(C)2022, Group 4 SE1511 FPTU-HN
 * 
 * Interface ITimeRoomDAO
 * Record of change:
 * DATE         Version     AUTHOR        Description
 * 2022-02-11   1.0         Nguyen Nam    First Implement
 */
package dao;

import java.util.ArrayList;
import model.TimeRoom;

/**
 * This is the interface class that declares the methods to access the data of
 * the TimeRoom object Abstract method getAllTimeRoom used to retrieve all tỉme
 * room
 *
 * @author Nguyen Nam
 */
public interface ITimeRoomDAO {

    //get all time room
    public ArrayList<TimeRoom> getAllTimeRoom();

    //get all time room by movie room
    public ArrayList<TimeRoom> getAllTimeRoomByMovieRoom(int movieRoomId);

    //get all time room by movie room room id and time id
    public TimeRoom getTimeRoomByMovieRoom(int movieRoomId, String roomId, int timeId);

    //get time room by id
    public TimeRoom getTimeRoom(int timeRoomId);

    //get time room by time and room
    public TimeRoom getTimeRoomByTimeAndRoom(int timeId, String RoomId);

    //add
    public boolean addTimeRoom(TimeRoom timeRoom);

    //edit
    public boolean editTimeRoom(TimeRoom timeRoom);

    //delete
    public boolean deleteTimeRoom(int timeRoomId);

    public ArrayList<TimeRoom> getByMovieId(int movieId);
    
    public TimeRoom getTimeRoomByTimeAndRoom(int timeId, String roomId, int movieId); 

}
