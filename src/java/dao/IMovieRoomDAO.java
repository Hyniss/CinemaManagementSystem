/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import model.MovieRoom;

/**
 *
 * @author Bảo Châu Bống
 */
public interface IMovieRoomDAO {

    public ArrayList<MovieRoom> getAllMovieRoom();

    public ArrayList<MovieRoom> getListById(int movieRoomId);

    public MovieRoom getMovieRoomById(int movieRoomId);
}
