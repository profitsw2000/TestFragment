package ru.profitsw2000.testfragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements FragmentActionListener{

    FragmentManager fragmentManager ;
    FragmentTransaction fragmentTransaction ;
    String selectedClub  ;
    String TAG = "Main"  ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager()   ;
        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            if (savedInstanceState == null) {
                addFootballClubsFragment();
            }
            else {
                addFCDescriptionFragment(R.id.fragment_container, savedInstanceState);
            }
        } else {
            addFootballClubsFragment();
            if (savedInstanceState == null) {
                Bundle bundle = new Bundle()    ;
                bundle.putString(FragmentActionListener.KEY_SELECTED_CLUB, "Barcelona");
                bundle.putInt(FragmentActionListener.ACTION_KEY,FragmentActionListener.ACTION_VALUE_CLUB_SELECTED);
                addFCDescriptionFragment(R.id.fragment_container_description, bundle);
            }
            else {
                //String temp = savedInstanceState.getString("selected club")   ;
                addFCDescriptionFragment(R.id.fragment_container_description, savedInstanceState);
            }
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(FragmentActionListener.KEY_SELECTED_CLUB, selectedClub);
        outState.putInt(FragmentActionListener.ACTION_KEY,FragmentActionListener.ACTION_VALUE_CLUB_SELECTED);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        selectedClub = savedInstanceState.getString(FragmentActionListener.KEY_SELECTED_CLUB, "Barcelona")    ;
    }

    private void addFootballClubsFragment() {
        fragmentTransaction = fragmentManager.beginTransaction();
        FootballClubsFragment footballClubsFragment = new FootballClubsFragment()   ;
        footballClubsFragment.setFragmentActionListener(this);
        fragmentTransaction.add(R.id.fragment_container, footballClubsFragment) ;
        fragmentTransaction.commit()    ;
    }

    /**
     * Start fragment with description of chosen football club.
     * @param bundle - parameters from main fragment
     */
    private void addFCDescriptionFragment(int containerID, Bundle bundle) {

        String tempString = bundle.getString(FragmentActionListener.KEY_SELECTED_CLUB)  ;

        FCDescriptionFragment footballClubsFragment = new FCDescriptionFragment()   ;
        fragmentTransaction = fragmentManager.beginTransaction();

        footballClubsFragment.setArguments(bundle);

        fragmentTransaction.replace(containerID, footballClubsFragment) ;
        if(this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) fragmentTransaction.addToBackStack(null)   ;
        fragmentTransaction.commit()    ;
    }

    /**
     * Method to start fragment with description of selected football club
     * @param bundle - parameters from main fragment
     */
    @Override
    public void onActionPerformed(Bundle bundle) {
        int actionPerformed = bundle.getInt(ACTION_KEY) ;
        switch (actionPerformed) {
            case FragmentActionListener.ACTION_VALUE_CLUB_SELECTED:
                if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                    addFCDescriptionFragment(R.id.fragment_container, bundle);
                } else if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    addFootballClubsFragment();
                    addFCDescriptionFragment(R.id.fragment_container_description, bundle);
                }
                selectedClub = bundle.getString(KEY_SELECTED_CLUB)   ;
                Log.d(TAG, selectedClub)    ;
                break;
        }
    }
}