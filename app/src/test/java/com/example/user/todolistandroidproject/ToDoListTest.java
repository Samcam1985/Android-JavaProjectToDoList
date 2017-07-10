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

    @Test
    public void addTest() {
       ToDoList toDoList = new ToDoList();
        Task task = new Task ("Book Flights", "Go on holiday");
        toDoList.add(task);
        assertEquals(13, toDoList.getList().size());

    }



}
