package com.example.frans.to_do;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment fragment = new ListFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.mainView, fragment, "main").commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; go home
                int index = getSupportFragmentManager().getBackStackEntryCount() - 1;
                FragmentManager.BackStackEntry backEntry = getSupportFragmentManager().getBackStackEntryAt(index);
                String tag = backEntry.getName();
                Fragment fragment = getSupportFragmentManager().findFragmentByTag(tag);
                getSupportFragmentManager().beginTransaction().replace(R.id.mainView, fragment, fragment.getTag()).commit();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void navigate(int viewNumber) {
        switch (viewNumber) {
            case 0:
                Fragment listFragment = new ListFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.mainView, listFragment, listFragment.getTag()).commit();
                break;
            case 1:
                Fragment addFragment = new AddFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.mainView, addFragment, "add").addToBackStack("main").commit();
                break;
            default:
                //do nothing
        }
    }

    public void openDesc(int listNum) {
        Bundle info = new Bundle();
        Task task = TaskStorage.getInstance().tasks.get(listNum);
        if (task.getDescription().length() != 0) {
            info.putString("desc", task.getDescription());
            Fragment descFragment = new DescriptionFragment();
            descFragment.setArguments(info);
            getSupportFragmentManager().beginTransaction().replace(R.id.mainView, descFragment, "desc").addToBackStack("main").commit();
        }
    }
}
