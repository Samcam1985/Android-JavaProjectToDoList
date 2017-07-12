package com.example.user.todolistandroidproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by user on 08/07/2017.
 */

public class CompletedListAdapter extends ArrayAdapter<Task> {
    public CompletedListAdapter(Context context, ArrayList<Task> list) {
        super(context, 0, list);
    }

    @Override
    public View getView(int position, View listItemView, ViewGroup parent) {
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.activity_completed_task_item, parent, false);
        }

        Task liveTask = getItem(position);

        TextView title = (TextView) listItemView.findViewById(R.id.title);
        title.setText(liveTask.getTitle());

        CheckBox chk_isComplete = (CheckBox) listItemView.findViewById(R.id.checkbox_complete);
        chk_isComplete.setId(position);


        if(liveTask.getIsComplete() != null)
        {
            if(liveTask.getIsComplete() == true)
            {
                chk_isComplete.setChecked(true);
                listItemView.setTag(liveTask);
            }
        }

        return listItemView;

    }
}


