package com.example.user.todolistandroidproject;

import java.util.ArrayList;

import static android.R.id.list;

/**
 * Created by user on 08/07/2017.
 */

public class ToDoList {

    private ArrayList<Task> list;

    public ToDoList() {
        list = new ArrayList<Task>();
        list.add(new Task("Go to John Lewis", "Buy wedding gift for Neil and Elizabeth"));
        list.add(new Task("Update Cv", "CV needs to be updated by Week 9 of course for CV review"));
        list.add(new Task("Android Project", "Complete project by 13/7/17"));
        list.add(new Task("Prepare presentation", "Prepare presentation for project"));
        list.add(new Task("Buy outfit", "Buy outfit for Neil and Elizabeth's wedding"));
        list.add(new Task("Book Hotel", "Book hotel for Hollie and Grant's wedding"));
        list.add(new Task("Buy wedding gift", "Buy wedding gift for Hollie and Grant"));
        list.add(new Task("Make dinner reservations", "Book dinner for Wednesday night for 8"));
        list.add(new Task("Go to travel agent",
                "Enquire about US holidays for September and iceland holidays for Christmas"
        ));
        list.add(new Task("Phone Vet", "Book appointment for Vigo to get his ears checked"));
        list.add(new Task("Car Service", "Book cars in for service at Evans Halshaw"));
        list.add(new Task("Airport Dropoff", "Drop Rich off at airport on Monday morning by 7am"));
    }

    public ArrayList<Task> getList() {
        return new ArrayList<Task>(list);
    }

    public void add (Task task){
        list.add(task);


    }

}