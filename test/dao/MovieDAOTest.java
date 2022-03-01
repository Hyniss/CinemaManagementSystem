/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.impl.MovieDAO;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Thai Tran
 */
public class MovieDAOTest {

    MovieDAO movieDAO;
    MovieDAO movieDaoSpy;

    public MovieDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        movieDAO = new MovieDAO();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGetAllMovie() {
        movieDAO.getAllMovie();
    }

    @Test
    public void testGetTop8Movie() {
        movieDAO.getTop8Movie();
    }

    @Test
    public void testGetMovieByValidId() {
        int id = 7;
        movieDAO.getMovieById(id);
    }


    @Test
    public void testGetMoviePremere() {
        movieDAO.getMoviePremere();
    }

    @Test
    public void testGetMovieComing() {
        movieDAO.getMovieComing();
    }

}
