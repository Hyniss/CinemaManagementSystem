/* 
 * CinemaManagementSystem
 * Copyright(C)2022, Group 4 SE1511 FPTU-HN
 * 
 * Interface ISeatDAO
 * Record of change:
 * DATE         Version     AUTHOR        Description
 * 2022-02-11   1.0         Nguyen Nam    First Implement
 */
package dao;

import java.util.List;
import model.Seat;
/**
 * This is the interface class that declares the methods to access the data of the Subject object
 * Abstract method getSeatInfoBySeatId used to retrieve seat with corresponding ID
 * 
 * @author Nguyen Nam
 */
public interface ISeatDAO {
    public Seat getSeatInfoBySeatId(String id); //Get seat by seat id from database
    
}
