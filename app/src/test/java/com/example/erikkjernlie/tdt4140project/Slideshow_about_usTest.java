package com.example.erikkjernlie.tdt4140project;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;

/**
 * Created by Jørgen on 02.04.2017.
 */

public class Slideshow_about_usTest {

    private Slideshow_about_us sau;

    @Before
    public void setUp() throws Exception {
        sau = new Slideshow_about_us();
    }

    @Test
    public void testOnCreate() throws Exception {
        assertFalse(sau == null);
    }

    @After
    public void tearDown() throws Exception {
        sau = null;
    }
}