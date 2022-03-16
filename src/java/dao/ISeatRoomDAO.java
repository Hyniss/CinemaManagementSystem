/* 
 * CinemaManagementSystem
 * Copyright(C)2022, Group 4 SE1511 FPTU-HN
 * 
 * Interface ISeatRoomDAO
 * Record of change:
 * DATE         Version     AUTHOR        Description
 * 2022-02-11   1.0         Nguyen Nam    First Implement
 */
package dao;

import java.util.ArrayList;
import model.SeatRoom;

/**
 * This is the interface class that declares the methods to access the data of
 * the MovieRoom object Abstract method getSeatRoom used to retrieve all seat
 * room
 *
 * @author Nguyen Nam
 */
public interface ISeatRoomDAO {
    public int addSeatRoom(SeatRoom seatRoom);
    
    public ArrayList<SeatRoom> getSeatRoomByTimeIdAndMovieId(int timeId, String roomId, int movieId ,int movieRoomId);
}
