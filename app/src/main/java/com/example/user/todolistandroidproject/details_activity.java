package com.example.user.todolistandroidproject;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class details_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_activity);

       Task task = (Task) getIntent().getSerializableExtra("task");
        TextView title = (TextView) findViewById(R.id.title);
        TextView description = (TextView) findViewById(R.id.description);

        title.setText(task.getTitle());
        description.setText(task.getDescription());



    }

    public void getTask(View listItem) {
        Task task = (Task) listItem.getTag();
        Log.d("Task Description: ", task.getDescription());
    }
}


