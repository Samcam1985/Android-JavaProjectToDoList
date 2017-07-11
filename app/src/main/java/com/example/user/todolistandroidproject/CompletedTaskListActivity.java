package com.example.user.todolistandroidproject;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class CompletedTaskListActivity extends AppCompatActivity {

    private ArrayList<Task> list;
    private ArrayList<Task> completedList = new ArrayList<Task>();
    private Gson gson;
    private SharedPreferences sharedPref;
    private CompletedListAdapter completedListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_completed_task_list);
        sharedPref = getSharedPreferences("ToDoListApp", Context.MODE_PRIVATE);
        gson = new Gson();

        TypeToken<ArrayList<Task>> completedTaskArrayList = new TypeToken<ArrayList<Task>>(){};
        String completedListString = sharedPref.getString("CompletedList", new ArrayList<Task>().toString());
        list = gson.fromJson(completedListString, completedTaskArrayList.getType());

            for(Task task : list)
            {
                if(task.getIsComplete() != null)
                {
                    if(task.getIsComplete() == true)
                    {
                        completedList.add(task);
                    }
                }
            }

        completedListAdapter = new CompletedListAdapter(this, completedList);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(completedListAdapter);
    }


}
