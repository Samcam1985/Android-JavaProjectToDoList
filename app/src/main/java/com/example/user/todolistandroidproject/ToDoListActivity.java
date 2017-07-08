package com.example.user.todolistandroidproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class ToDoListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list);

        ToDoList toDoList = new ToDoList();
        ArrayList<Task> list = toDoList.getList();

        ToDoListAdapter toDoAdapter = new ToDoListAdapter(this, list);


        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(toDoAdapter);
    }

    public void getTask(View listItem) {
        Task task = (Task) listItem.getTag();
        Log.d("Task Title: ", task.getTitle());
    }
}
