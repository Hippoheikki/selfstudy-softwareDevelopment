package com.example.frans.to_do;

import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {

    private ArrayList<Task> tasks;

    public TaskAdapter() {
        this.tasks = TaskStorage.getInstance().tasks;
    }

    @NonNull
    @Override
    public TaskAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.task_layout, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskAdapter.ViewHolder viewHolder, int i) {
        Task item = tasks.get(i);

        viewHolder.name.setPaintFlags(viewHolder.name.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
        viewHolder.done.setChecked(false);
        viewHolder.name.setText(item.getName());
        viewHolder.itemNum = i;
    }

    @Override
    public int getItemCount() {
        if (this.tasks != null) {
            return this.tasks.size();
        } else {
            return 0;
        }
    }

    public void updateData(ArrayList<Task> set) {
        this.tasks = set;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final View view;
        public final TextView name;
        public final CheckBox done;

        private int itemNum;

        public ViewHolder(View view) {
            super(view);
            this.view = view;
            this.name = view.findViewById(R.id.taskNameField);
            this.done = view.findViewById(R.id.doneBox);

            this.done.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        name.setPaintFlags(name.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                        Task task = TaskStorage.getInstance().tasks.get(itemNum);
                        task.setChecked(true);
                    } else {
                        name.setPaintFlags(name.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
                        Task task = TaskStorage.getInstance().tasks.get(itemNum);
                        task.setChecked(false);
                    }
                }
            });
            this.view.setOnClickListener(this);
        }

        public void onClick(View view) {
            System.out.println("Task: " + itemNum);
            ((MainActivity) view.getContext()).openDesc(itemNum);
        }
    }
}
