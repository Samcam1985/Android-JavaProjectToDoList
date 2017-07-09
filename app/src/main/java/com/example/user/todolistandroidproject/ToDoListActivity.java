package com.example.user.todolistandroidproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
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
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Task task = (Task) adapterView.getItemAtPosition(i);
                Intent intent = new Intent(ToDoListActivity.this, details_activity.class);
                intent.putExtra("task", task);

                startActivity(intent);
            }
        });
    }

    public void getTask(View listItem) {
        Task task = (Task) listItem.getTag();
        Log.d("Task Title: ", task.getTitle());


    }
}
