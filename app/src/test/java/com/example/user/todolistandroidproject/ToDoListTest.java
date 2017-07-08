package com.example.user.todolistandroidproject;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by user on 08/07/2017.
 */

public class ToDoListTest {

    @Test
    public void getListTest() {
        ToDoList toDoList = new ToDoList();
        assertEquals(12, toDoList.getList().size());
    }
}
