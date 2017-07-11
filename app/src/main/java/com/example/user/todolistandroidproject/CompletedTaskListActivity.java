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
    private ToDoListAdapter completedListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_completed_task_list);
        sharedPref = getSharedPreferences("ToDoListApp", Context.MODE_PRIVATE);

        //String completedListString = sharedPref.getString("CompletedList", new ArrayList<Task>().toString());
        gson = new Gson();

        TypeToken<ArrayList<Task>> toDoTaskArrayList = new TypeToken<ArrayList<Task>>(){};
        //completedList = gson.fromJson(completedListString, toDoTaskArrayList.getType());

        //if(completedList.size() == 0)
        //{
            String todoListString = sharedPref.getString("ToDoList", new ArrayList<Task>().toString());
            list = gson.fromJson(todoListString, toDoTaskArrayList.getType());

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
        //}

        //SharedPreferences.Editor editor = sharedPref.edit();

        //editor.putString("CompletedList", gson.toJson(completedList));
        //editor.apply();

        completedListAdapter = new ToDoListAdapter(this, completedList);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(completedListAdapter);
    }


}
