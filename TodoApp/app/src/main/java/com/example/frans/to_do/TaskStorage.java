package com.example.frans.to_do;

import java.util.ArrayList;
import java.util.Iterator;

public class TaskStorage {

    protected ArrayList<Task> tasks;
    private static TaskStorage instance = null;

    public TaskStorage() {
        this.tasks = new ArrayList<>();
    }

    public static TaskStorage getInstance() {
        if (instance == null) {
            instance = new TaskStorage();
        }
        return instance;
    }

    public void clearDoneTasks() {
        Iterator<Task> iter = instance.tasks.iterator();

        while(iter.hasNext()) {
            Task task = iter.next();
            if (task.isChecked()) {
                iter.remove();
            }
        }
    }
}
