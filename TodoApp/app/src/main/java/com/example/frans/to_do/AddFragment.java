package com.example.frans.to_do;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddFragment extends Fragment {

    Button makeTask;
    TextInputLayout taskName;
    TextInputLayout taskDescription;

    public AddFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add, container, false);
        ((MainActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        this.makeTask = view.findViewById(R.id.addTaskToList);
        this.taskName = view.findViewById(R.id.taskName);
        this.taskDescription = view.findViewById(R.id.taskDesc);

        this.makeTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = taskName.getEditText().getText().toString();
                String Description = taskDescription.getEditText().getText().toString();
                if (name.length() != 0) {
                    TaskStorage.getInstance().tasks.add(new Task(name, Description));
                    taskName.getEditText().setText("");
                    taskDescription.getEditText().setText("");

                    try {
                        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(getActivity().INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                } else {
                    alertView("Name is empty");
                }

            }
        });

        return view;
    }

    private void alertView( String message ) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(getContext());
        dialog.setTitle( "Warning" )
                .setMessage(message)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialoginterface, int i) {
                    }
                }).show();
    }

}
