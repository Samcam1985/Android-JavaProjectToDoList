package com.example.user.todolistandroidproject;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ToDoListActivity extends AppCompatActivity {

    private ArrayList<Task> persistedToDolist;
    private ArrayList<Task> persistedCompletedlist;
    private ArrayList<Task> toDoList = new ArrayList<Task>();
    private ArrayList<Task> completedList = new ArrayList<Task>();
    private Gson gson;
    private SharedPreferences sharedPref;
    private ToDoListAdapter toDoListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list);
        sharedPref = getSharedPreferences("ToDoListApp", Context.MODE_PRIVATE);

        String toDoListString = sharedPref.getString("ToDoList", new ArrayList<Task>().toString());
        String completedListString = sharedPref.getString("CompletedList", new ArrayList<Task>().toString());
        gson = new Gson();

        TypeToken<ArrayList<Task>> toDoTaskArrayList = new TypeToken<ArrayList<Task>>(){};
        persistedToDolist = gson.fromJson(toDoListString, toDoTaskArrayList.getType());

        TypeToken<ArrayList<Task>> completedTaskArrayList = new TypeToken<ArrayList<Task>>(){};
        persistedCompletedlist = gson.fromJson(completedListString, completedTaskArrayList.getType());

        for(Task task : persistedToDolist)
        {
            if(task.getIsComplete() == null || task.getIsComplete() == false)
            {
                toDoList.add(task);
            }
            else
            {
                persistedCompletedlist.add(task);
            }
        }

        toDoListAdapter = new ToDoListAdapter(this, toDoList);

//        ToDoList toDoList = new ToDoList();
//        ArrayList<Task> list = toDoList.getList();

        Task task = (Task) getIntent().getSerializableExtra("task");
        if(task != null)
        {
            toDoList.add(task);
        }

        SharedPreferences.Editor editor = sharedPref.edit();

        editor.putString("ToDoList", gson.toJson(toDoList));
        editor.putString("CompletedList", gson.toJson(persistedCompletedlist));
        editor.apply();

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(toDoListAdapter);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Log.d("AHH", "IS THIS RUNNING?!");
//                Task task = (Task) adapterView.getItemAtPosition(i);
//                Intent intent = new Intent(ToDoListActivity.this, details_activity.class);
//                intent.putExtra("task", task);
//                startActivity(intent);
//            }
//        });
    }

    public void onItemClicked(View view) {
        Task task = (Task) view.getTag();
        Intent intent = new Intent(ToDoListActivity.this, details_activity.class);
        intent.putExtra("task", task);
        startActivity(intent);
    }

    public void onCheckboxClicked(View view) {
        CheckBox chk_IsComplete = (CheckBox)view;
        boolean checked = chk_IsComplete.isChecked();
        int id = chk_IsComplete.getId();

        Task task = (Task)toDoList.get(id);
        task.setIsComplete(checked);
        toDoList.remove(id);
        persistedCompletedlist.add(task);

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("ToDoList", gson.toJson(toDoList));
        editor.putString("CompletedList", gson.toJson(persistedCompletedlist));
        editor.apply();

        Intent intent = new Intent(ToDoListActivity.this, ToDoListActivity.class);
        startActivity(intent);
    }

    public void addNewTaskButtonClicked(View view) {
        Intent intent = new Intent(this, AddTaskActivity.class);

        startActivity(intent);
    }

    public void viewCompletedTasks(View view){
        Intent intent = new Intent(this, CompletedTaskListActivity.class);
        startActivity(intent);

//        ArrayList<Task> copyList = list;
//        //toDoListAdapter.clear();
//        for(Task task : copyList)
//        {
//            if(task.getIsComplete() != null)
//            {
//                if(task.getIsComplete() == true)
//                {
//                    toDoListAdapter.add(task);
//                    toDoListAdapter.notifyDataSetChanged();
//                }
//            }
//        }

        //toDoListAdapter = new ToDoListAdapter(this, completedList);

        //toDoListAdapter.addAll(completedList);
        //toDoListAdapter.notifyDataSetChanged();

        //CompletedListAdapter completedListAdapter = new CompletedListAdapter(this, list);

        //ListView listView = (ListView) findViewById(R.id.list);
        //listView.setAdapter(completedListAdapter);
        //completedListAdapter.notifyDataSetChanged();

    }

}


//Delete from list,
//
// Is the view now checked?
//


//        // Check which checkbox was clicked
//        switch(view.getId()) {
//            case R.id.checkbox_complete:
//                if (checked);
//
//            else
//
//                break;
//
//
//        }