package com.example.frans.to_do;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {

    FloatingActionButton addBtn;
    RecyclerView listView;
    TaskAdapter adapter;
    Button clearBtn;

    public ListFragment() {
        //empty
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        ((MainActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        this.addBtn = view.findViewById(R.id.addTasks);
        this.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).navigate(1);
            }
        });

        this.clearBtn = view.findViewById(R.id.clearBtn);
        this.clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TaskStorage.getInstance().clearDoneTasks();
                adapter.updateData(TaskStorage.getInstance().tasks);
            }
        });

        this.listView = view.findViewById(R.id.listView);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        this.listView.setLayoutManager(mLayoutManager);

        this.adapter = new TaskAdapter();
        this.listView.setAdapter(this.adapter);

        return view;
    }

}
