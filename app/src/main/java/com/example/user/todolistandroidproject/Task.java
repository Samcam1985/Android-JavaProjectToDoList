package com.example.user.todolistandroidproject;

import java.io.Serializable;

/**
 * Created by user on 08/07/2017.
 */

public class Task implements Serializable {

    private String title;
    private String description;
    private Boolean isComplete;



    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.isComplete = false;
    }

    public String getTitle() {return title;}
    public String getDescription() {return description;}
    public Boolean getIsComplete() {return isComplete;}

    public void setIsComplete(Boolean complete) {isComplete = complete;}

    }
