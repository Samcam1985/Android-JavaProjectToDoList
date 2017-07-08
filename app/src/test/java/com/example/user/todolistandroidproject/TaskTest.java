package com.example.user.todolistandroidproject;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by user on 08/07/2017.
 */

public class TaskTest {

    Task task;

    @Before
    public void before() { task = new Task("Collect Shopping",
            "Collect click and collect from tesco Corstorphine on 14/7 between 9am and 11am");}

    @Test
    public void getTitleTest() {
        assertEquals("Collect Shopping", task.getTitle());
    }
}
