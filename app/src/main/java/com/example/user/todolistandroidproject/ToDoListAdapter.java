package com.example.user.todolistandroidproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by user on 08/07/2017.
 */

public class ToDoListAdapter extends ArrayAdapter<Task> {
    public ToDoListAdapter(Context context, ArrayList<Task> list) {
        super(context, 0, list);
    }

    @Override
    public View getView(int position, View listItemView, ViewGroup parent) {
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.task_item, parent, false);
        }

        Task liveTask = getItem(position);

        TextView title = (TextView) listItemView.findViewById(R.id.title);
        title.setText(liveTask.getTitle());

        listItemView.setTag(liveTask);

        return listItemView;

    }
}


