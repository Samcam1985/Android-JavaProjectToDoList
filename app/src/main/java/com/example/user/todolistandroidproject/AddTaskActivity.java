package com.example.user.todolistandroidproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
    }

    public void addTaskToListClicked(View view) {

        EditText title   = (EditText)findViewById(R.id.title);
        EditText description = (EditText)findViewById(R.id.description);
        Task task = new Task(title.getText().toString(),description.getText().toString());

        Intent intent = new Intent(this, ToDoListActivity.class);
        intent.putExtra("task", task);


        startActivity(intent);
    }
}
