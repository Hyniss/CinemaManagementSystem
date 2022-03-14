/* 
 * CinemaManagementSystem
 * Copyright(C)2022, Group 4 SE1511 FPTU-HN
 * 
 * Interface IRoomDAO
 * Record of change:
 * DATE         Version     AUTHOR        Description
 * 2022-02-11   1.0         Nguyen Nam    First Implement
 */
package dao;

import java.util.ArrayList;
import model.Room;

/**
 * This is the interface class that declares the methods to access the data of
 * the TimeRoom object Abstract 
 * method getAllRoom used to retrieve all room
 *
 * @author Nguyen Nam
 */
public interface IRoomDAO  {
    //get all room
    public ArrayList<Room> getAllRoom();
    //get room by room id
    public Room room(String roomId);
}
